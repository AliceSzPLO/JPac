package nl.tudelft.jpacman.ui;

import javax.swing.*;
import java.awt.*;

public class GameselectUI extends JPanel {
    ImageIcon background;

    Insets i = new Insets(0,0,0,0);

    JPanel topPanel = new JPanel();
    JPanel descPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    JLabel free = new JLabel();

    String desc = "";
    JLabel descLabel = new JLabel(desc);

    public GameselectUI() {

        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        GridBagConstraints GridConstraints = new GridBagConstraints();
        GridConstraints.fill = GridConstraints.HORIZONTAL;
        GridConstraints.gridy = 0;  // set the row to 1
        GridConstraints.weighty = 1.0;  // allocate extra vertical space to second row
        this.setLayout(new GridBagLayout());
        topPanel.setBackground(new java.awt.Color(255, 255, 255, 255));

        add(topPanel,GridConstraints);


        GridConstraints.fill = GridConstraints.HORIZONTAL;

        GridConstraints.gridy = 1;  // set the row to 1
        GridConstraints.weighty = 1.0;  // allocate extra vertical space to second row

        descPanel.add(descLabel);
        descPanel.setBackground(new java.awt.Color(255, 255, 255, 0));
        descLabel.setForeground(Color.WHITE);
        this.add(descPanel,GridConstraints);

    }

    public void start() {setVisible(true);}

    public void addButton(JButton btn) {
        buttonPanel.setOpaque(false);

        buttonPanel.add(btn);
        buttonPanel.setBackground(new java.awt.Color(255, 255, 255, 0));
        GridBagConstraints buttonConstraints = new GridBagConstraints();

        buttonConstraints.gridy = 2;// start at row 1
        buttonConstraints.weighty = 0.5;  // allocate extra vertical space to third row
        buttonConstraints.ipady = 0;
        buttonConstraints.fill = GridBagConstraints.HORIZONTAL;

        btn.setBackground(new java.awt.Color(255, 255, 255, 0));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT); //set button alignment
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.PLAIN,25));
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        Component[] components = this.getComponents();
        for (Component c : components) {
            if (c instanceof JPanel) {
                this.remove(buttonPanel);
                this.revalidate();
            }
        }
        this.add(buttonPanel, buttonConstraints);

    }

    public void addBotButton(JButton btn){

        bottomPanel.setOpaque(false);
        bottomPanel.add(btn);
        bottomPanel.setBackground(new java.awt.Color(0, 255, 255, 255));
        GridBagConstraints botConstraints = new GridBagConstraints();

        botConstraints.anchor = GridBagConstraints.LAST_LINE_START; //bottom of space
        botConstraints.gridy = 3;       //third row
        botConstraints.gridx = 0;
        botConstraints.weighty = 1.0;  // allocate extra vertical space to third row
        botConstraints.gridwidth = 3;
        botConstraints.insets = new Insets(0, 0, 0, 0); // add some padding to the panel


        btn.setBackground(new java.awt.Color(255, 255, 255, 0));
        btn.setForeground(Color.WHITE);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setFont(new Font("Arial", Font.PLAIN,25));
        Component[] components = this.getComponents();
        for (Component a : components) {
            if (a instanceof JPanel) {
                this.remove(bottomPanel);
                this.revalidate();
            }
        }
        this.add(bottomPanel, botConstraints);
    }

    @Override
    public void paintComponent(Graphics g) {
        // Call the super method
        super.paintComponent(g);
        // Draw the image icon on the panel
        g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
    }

    public void setBackground(String path) {
        background = new ImageIcon(path);
    }

    public void setText(String i){
        if (i == "rank"){
            desc = "This is Rank Mode";
        }else if(i == "casual"){
            desc = "This is Casual Mode";
        }
        descLabel.setForeground(Color.YELLOW);
        descLabel.setText(desc);
    }
    public void cleanText(){
        desc = "";
        descLabel.setText(desc);
    }
}
