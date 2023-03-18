package nl.tudelft.jpacman.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.ui.ScorePanel.ScoreFormatter;

/**
 * The default JPacMan UI frame. The PacManUI consists of the following
 * elements:
 *
 * <ul>
 * <li>A score panel at the top, displaying the score of the player(s).
 * <li>A board panel, displaying the current level, i.e. the board and all units
 * on it.
 * <li>A button panel, containing all buttons provided upon creation.
 * </ul>
 *
 * @author Jeroen Roosen 
 *
 */
public class PacManUI extends JFrame implements ActionListener  {

    /**
     * Default serialisation UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The desired frame rate interval for the graphics in milliseconds, 40
     * being 25 fps.
     */
    private static final int FRAME_INTERVAL = 40;

    /**
     * The panel displaying the player scores.
     */
    private final ScorePanel scorePanel;

    /**
     * The panel displaying the game.
     */
    private final BoardPanel boardPanel;

    JPanel cardPanel = new JPanel();
    CardLayout cardLayout = new CardLayout();

    MainmenuUI MainUI = new MainmenuUI();

    JPanel GameUI = new JPanel();

    PlaySound playSound = new PlaySound();

    GameselectUI GSelectUI = new GameselectUI();
    CasualUI CasualUI = new CasualUI();

    JButton startBTN = new JButton("Start");
    JButton leaderBTN = new JButton("Leader Board");
    JButton casualBTN = new JButton("Casual");
    JButton rankBTN = new JButton("Ranking");
    JButton GbackBTN = new JButton("Back");

    JButton[] MapBTN = new JButton[5];



    private ButtonPanel buttonPanel;
    /**
     * Creates a new UI for a JPacman game.
     *
     * @param game
     *            The game to play.
     * @param buttons
     *            The map of caption-to-action entries that will appear as
     *            buttons on the interface.
     * @param keyMappings
     *            The map of keyCode-to-action entries that will be added as key
     *            listeners to the interface.
     * @param scoreFormatter
     *            The formatter used to display the current score.
     */
    public PacManUI(final Game game, final Map<String, Action> buttons,
                    final Map<Integer, Action> keyMappings,
                    ScoreFormatter scoreFormatter) {
        super("JPacman 2019");
        assert game != null;
        assert buttons != null;
        assert keyMappings != null;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        cardPanel.setLayout(cardLayout);

        PacKeyListener keys = new PacKeyListener(keyMappings);
        addKeyListener(keys);

        buttonPanel = new ButtonPanel(buttons, this);
        MainUI.setBackground("src\\main\\resources\\bg02.png");
        GSelectUI.setBackground("src\\main\\resources\\gameselect.png");
        scorePanel = new ScorePanel(game.getPlayers());
        if (scoreFormatter != null) {
            scorePanel.setScoreFormatter(scoreFormatter);
        }

        boardPanel = new BoardPanel(game);
        GameUI.setLayout(new BorderLayout());
        GameUI.add(buttonPanel, BorderLayout.SOUTH);
        GameUI.add(scorePanel, BorderLayout.NORTH);
        GameUI.add(boardPanel, BorderLayout.CENTER);

        MainUI.addButton(startBTN);
        MainUI.addButton(leaderBTN);

        startBTN.addActionListener(this);
        casualBTN.addActionListener(this);

        GSelectUI.addButton(casualBTN);
        GSelectUI.addButton(rankBTN);
        GSelectUI.addBotButton(GbackBTN);

        CasualUI.setBackground("src\\main\\resources\\bg01.jpg");

        //Loop create Map button object in Casual Mode
        for (int i=0; i<5; i++){
            MapBTN[i] = new JButton();
            int a = i+1;
            MapBTN[i].setText("Map "+a);
            MapBTN[i].addActionListener(this);
            CasualUI.addButton(MapBTN[i]);
        }


        add(cardPanel);
        cardPanel.add(MainUI,"Mainmenu");
        cardPanel.add(GameUI,"Game");
        cardPanel.add(GSelectUI,"Gamemode_Select");
        cardPanel.add(CasualUI,"Casual");
        pack();


        startBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startBTN.setBackground(Color.GREEN);
                startBTN.setOpaque(true);

                startBTN.setFont(new Font("Arial", Font.PLAIN,25));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                startBTN.setFont(new Font("Arial", Font.PLAIN,15));
                startBTN.setOpaque(false);
            }
        });
        casualBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GSelectUI.setText("casual");
//                playSound.playSound("src\\main\\resources\\click.wav");
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GSelectUI.cleanText();

            }
        });
        rankBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GSelectUI.setText("rank");
                playSound.playSound("src\\main\\resources\\click.wav");
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GSelectUI.cleanText();
            }
        });

        MapBTN[0].addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CasualUI.setImagePanelBackground("src\\main\\resources\\img\\map1.jpg");
            }
        });
        MapBTN[1].addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CasualUI.setImagePanelBackground("src\\main\\resources\\img\\map2.jpg");
            }
        });
        MapBTN[2].addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CasualUI.setImagePanelBackground("src\\main\\resources\\img\\map3.jpg");
            }
        });
        MapBTN[3].addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CasualUI.setImagePanelBackground("src\\main\\resources\\img\\map4.jpg");
            }
        });
        MapBTN[4].addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CasualUI.setImagePanelBackground("src\\main\\resources\\img\\map5.jpg");
            }
        });



    }

    /**
     * Starts the "engine", the thread that redraws the interface at set
     * intervals.
     */
    public void start() {
        setVisible(true);
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(this::nextFrame, 0, FRAME_INTERVAL, TimeUnit.MILLISECONDS);
    }

    /**
     * Draws the next frame, i.e. refreshes the scores and game.
     */
    private void nextFrame() {
        boardPanel.repaint();
        scorePanel.refresh();
        scorePanel.reMap();

    }

    //Button Action
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startBTN){
            cardLayout.show(cardPanel,"Gamemode_Select");
        }else if(e.getSource()== casualBTN){
            cardLayout.show(cardPanel,"Casual");
        }else if(e.getSource()==MapBTN[0]){
            cardLayout.show(cardPanel,"Game");
        }
    }
}
