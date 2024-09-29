package GUI;

import javax.swing.*;
import java.awt.*;

public class Panel implements UIComponents
{
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    public Panel()
    {
        this.panel1 = new JPanel();
        this.panel1.setBackground(Color.RED);
        this.panel1.setBounds(0,0,250,250);
        this.panel1.setLayout(null);

        this.panel2 = new JPanel();
        this.panel2.setBackground(Color.YELLOW);
        this.panel2.setBounds(250,0,250,250);

        this.panel3 = new JPanel();
        this.panel3.setBackground(Color.BLUE);
        this.panel3.setBounds(500,0,250,250);
    }

    public JPanel GetPanel1(){ return this.panel1;}
    public JPanel GetPanel2(){ return this.panel2;}
    public JPanel GetPanel3(){ return this.panel3;}

    @Override
    public void AddComponents(Component components) {
        this.panel1.add(components);
    }

    @Override
    public void Refresh() {
        this.panel1.invalidate();
        this.panel1.validate();
        this.panel1.repaint();
    }
}
