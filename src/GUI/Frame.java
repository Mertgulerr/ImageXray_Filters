package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class Frame extends JFrame implements UIComponents
{
    public Frame()
    {
        this.setTitle("My Frame");
        this.setSize(750,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0x123456));
        this.setLayout(null);
        this.setVisible(true);
    }
    @Override
    public void Refresh()
    {
        this.invalidate();
        this.validate();
        this.repaint();
    }
    @Override
    public void AddComponents(Component component)
    {
        this.add(component);
        Refresh();
    }
}
