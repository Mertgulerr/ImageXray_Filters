import GUI.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    @SuppressWarnings({"unchecked"})
    public static void main(String[] args) throws IOException
    {
        Frame frame = new Frame();
        Label label = new Label();
        Panel panel = new Panel();
        Buttons button = new Buttons();
        //panel.AddComponents(label.GetLabel());
        panel.AddComponents(button.GetButton());
        frame.AddComponents(panel.GetPanel1());
        frame.AddComponents(panel.GetPanel2());
        frame.AddComponents(panel.GetPanel3());


    }

}