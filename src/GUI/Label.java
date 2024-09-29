package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Label {
    private JLabel label;

    public Label() {
        this.label = new JLabel();
        Border border = BorderFactory.createLineBorder(Color.green);
        ImageIcon icon = new ImageIcon(Frame.class.getResource("vhagar.png"));
        this.label.setText("Bro do you even code ?"); // set text of label
        this.label.setIcon(icon);
        this.label.setHorizontalTextPosition(JLabel.CENTER); // set text LEFT,CENTER,RIGHT of icon
        this.label.setVerticalTextPosition(JLabel.BOTTOM); // set text TOP, CENTER, BOTTOM of icon

        this.label.setForeground(Color.WHITE); // Set Font Color of Text

        //this.label.setBackground(Color.YELLOW); // Set background color of Jlabel
        //this.label.setOpaque(true); // Display Background color

        //this.label.setFont(new Font("MV Boli", Font.BOLD, 9)); // set font of Jlabel

        //this.label.setBorder(border); // set border of Jlabel(not icon + text)
        this.label.setIconTextGap(-20); // set gap of text to image
        //this.label.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of image+icon within label
        //this.label.setVerticalAlignment(JLabel.CENTER); // set vertical positions of icon+image within label
        this.label.setBounds(0 ,0, 255, 197);
    }

    public JLabel GetLabel() {
        return this.label;
    }
}
