package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons  implements  UIComponents, ActionListener
{

    private JButton button1;

    public Buttons()
    {
        button1 = new JButton();
        button1.setBounds(10,10,200,100);
        button1.setText("Click On Me!!");
        button1.setBackground(Color.LIGHT_GRAY);
        button1.setForeground(Color.BLUE);
        button1.setFont(new Font("Comic Sans",Font.BOLD,25));
        button1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button1.setFocusable(false);
        button1.setEnabled(true);
        button1.setVisible(true);
        button1.addActionListener(this);
    }
    @Override
    public void AddComponents(Component components) {

    }

    @Override
    public void Refresh()
    {
        this.button1.invalidate();
        this.button1.validate();
        this.button1.repaint();
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1)
        {
            System.out.println("Hi");
        }
    }

    public JButton GetButton() {
        return this.button1;
    }
}
