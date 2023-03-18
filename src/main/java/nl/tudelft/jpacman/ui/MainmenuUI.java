package nl.tudelft.jpacman.ui;

import javax.swing.*;
import java.awt.*;

public class MainmenuUI extends JPanel {

    private ImageIcon background;
    private JPanel buttonPanel;

    public MainmenuUI() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setBackground(new java.awt.Color(255, 255, 255, 0));

        GridBagConstraints spaceConstraints = new GridBagConstraints();

        spaceConstraints.gridx = 0; // start at column 0
        spaceConstraints.gridy = 0; // start at row 0
        spaceConstraints.gridwidth = 1; // span one column
        spaceConstraints.gridheight = 1; // span one row
        spaceConstraints.weightx = 1.0; // resize horizontally
        spaceConstraints.weighty = 0.0; // do not resize vertically
        spaceConstraints.anchor = GridBagConstraints.CENTER; // align at page start
        this.setLayout(new GridBagLayout());
    }

    public void start() {
        setVisible(true);
    }

    public void addButton(JButton btn) {
        // Set the background of the button panel to transparent
        buttonPanel.setOpaque(false);

        buttonPanel.add(btn);
        GridBagConstraints buttonConstraints = new GridBagConstraints();

        buttonConstraints.gridy = 1;// start at row 1

        btn.setBackground(new java.awt.Color(255, 255, 255, 0));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT); //set button alignment
        btn.setForeground(Color.WHITE);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setFont(new Font("Arial", Font.PLAIN,15));

        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Component[] components = this.getComponents();
        for (Component c : components) {
            if (c instanceof JPanel) {
                this.remove(buttonPanel);
                this.revalidate();
            }
        }
        this.add(buttonPanel, buttonConstraints);
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
}
