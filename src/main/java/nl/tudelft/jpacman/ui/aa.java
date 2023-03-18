import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class aa {

    public static void main (String [] args) {
        aa MainWindow = new aa ();
        MainWindow.buildMainWindow();
    }

    String [] allContactsList = {"Contact 1", "Contact 2", "Contact 3"};
    JFrame frame;
    JPanel showPanel;
    JPanel listPanel;
    JPanel contactsPanel;
    JPanel allContactsPanel;
    JLabel allContactsTitle = new JLabel("All Contacts");
    JLabel contactsTitle = new JLabel("Contacts");
    Dimension miniSize = new Dimension (100,1000);

    public void buildMainWindow() {// open method       

        frame = new JFrame("Contacts");
        frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.pack();

        listPanel = new JPanel();
        showPanel = new JPanel();
        showPanel.setBackground(Color.white);
        allContactsPanel = new JPanel();
        contactsPanel = new JPanel();

        JSplitPane contactsSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, allContactsPanel, contactsPanel);
        contactsSplitPane.setOneTouchExpandable(true);
        contactsSplitPane.setDividerLocation(50);



        allContactsPanel.setBackground( Color.LIGHT_GRAY);
        allContactsPanel.add(allContactsTitle);
        allContactsPanel.setMinimumSize(miniSize );
        allContactsPanel.setPreferredSize(miniSize );

        JList<String> allContacts = new JList<String>(allContactsList);
        //allContacts.setBackground(Color.LIGHT_GRAY); 

        contactsPanel.setBackground( Color.white);
        contactsPanel.add(contactsTitle);
        contactsPanel.setMinimumSize( miniSize );
        contactsPanel.setPreferredSize( miniSize );
        contactsPanel.add(allContacts);



        //allContactsPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));


        listPanel.setBackground(Color.LIGHT_GRAY);
        listPanel.add(contactsSplitPane);
        //listPanel.add( allContactsPanel );
        //listPanel.add( contactsPanel );

        frame.add( BorderLayout.WEST, listPanel );
        frame.setSize( 1000, 1000 );
        frame.setVisible(true);
        frame.add(BorderLayout.CENTER, showPanel);





    }//close method

}// close class
