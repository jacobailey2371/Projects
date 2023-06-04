package slidepuzzle;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author jacob
 */
public class myGUI extends javax.swing.JFrame implements ActionListener
{

    private ArrayList<JButton> buttons;
    private ArrayList<String> buttonname;
    private int buttonsizepx;

    public myGUI()
    {
        //SET FONT!
        super("Slide puzzle");
        buttons = new ArrayList<JButton>();
        buttonname = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "")); 
        buttonsizepx = 150;

        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setSize(800, 600);

        Collections.shuffle(buttonname);

        for (int y = 0; y < 3; y++)
        {
            for (int x = 0; x < 3; x++)
            {
                String currname = buttonname.remove(0);

                JButton b1 = new JButton((currname));
                buttons.add(b1);
                this.add(b1);
                b1.addActionListener(this);
                b1.setSize(buttonsizepx, buttonsizepx);
                b1.setBackground(Color.darkGray);
                b1.setForeground(Color.cyan);
                b1.setFont(new Font("Arial", Font.PLAIN, 40));
                b1.setVisible(true);
                b1.setLocation(x * buttonsizepx, y * buttonsizepx);

            }
        }

    }
    public JButton getBlankNeighbor(int index)
    {
        if(index -3 >= 0 && buttons.get(index-3).getText() == "")
        {
            return buttons.get(index-3);
        }
        if(index +3 < 9 && buttons.get(index+3).getText() == "")
        {
            return buttons.get(index+3);
        }
        if((index + 1)%3 != 0 && buttons.get(index+1).getText() == "")
        {
            
            return buttons.get(index+1);
        }
        if((index %3) != 0 && buttons.get(index-1).getText() == "")
        {
            return buttons.get(index-1);
        }
        System.out.println("index is: |" + index +"| Math is: |" + (index %3) + "|"+ "|");
        return null;
        
    }
    public void actionPerformed(ActionEvent ae)
    {      
        /*
        if has blank nieghbor 
            swap with blank nieghbor
        blank niehbor method
            check to see if neighbor is blank
                two types of neighbors
                    1. up and down(vertical) +- 3
                    2. left and right(horizontal) +-1
                        
            return which neighbor is blank
        */
        JButton blankbutton = new JButton();
        JButton clicked = (JButton)ae.getSource();
        
        String click = clicked.getText();
        blankbutton = getBlankNeighbor(buttons.indexOf(clicked));
        if(blankbutton == null)
        {
            return;
        }
//            for(JButton buttontemp: buttons)
//            {
//                if(buttontemp.getText()  == "")
//                {
//                    blankbutton = buttontemp;
//                }
//            }
            String blank = blankbutton.getText();
            clicked.setText(blank);
            blankbutton.setText(click);
}
}