package nl.tudelft.jpacman.ui;

import javax.swing.*;
import java.awt.*;
import java.sql.Array;

public class CasualUI extends JPanel {
    ImageIcon background;

    JPanel buttonPanel = new JPanel();

    JPanel ImagePanel = new JPanel();

    JLabel backgroundLabel;

    JPanel bottomPanel = new JPanel();

    JPanel topPanel = new JPanel();

    BorderLayout layout = new BorderLayout();


    public CasualUI() {

        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        GridBagConstraints GridConstraints = new GridBagConstraints();
        GridConstraints.fill = GridConstraints.HORIZONTAL;
        GridConstraints.gridy = 0;  // set the row to 1
        GridConstraints.weighty = 1.0;  // allocate extra vertical space to second row
        layout.setVgap(140);
        this.setLayout(layout);

        ImageIcon defaultIcon = new ImageIcon("");
        backgroundLabel = new JLabel(defaultIcon);
        ImagePanel.add(backgroundLabel);

        add(bottomPanel,BorderLayout.PAGE_END);
        add(topPanel,BorderLayout.PAGE_START);
        add(ImagePanel,BorderLayout.CENTER);

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
        this.add(buttonPanel, BorderLayout.LINE_START);

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

    public void setImagePanelBackground(String i){
        ImageIcon newIcon = new ImageIcon(i);
        backgroundLabel.setIcon(newIcon);
    }

}
