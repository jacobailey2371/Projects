package gameoflife;

import java.util.concurrent.TimeUnit;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author jacob
 */
public class GameofLife
{

    private ArrayList<JButton> buttons;
    private ArrayList<String> buttonname;

    public static void main(String[] args)
    {
        ArrayList<Integer> growing = new ArrayList();
        ArrayList<Integer> dying = new ArrayList();

        int userint = Integer.parseInt(JOptionPane.showInputDialog("What size do you want to make your Game Of Life? Please enter a number that is 10 or bigger!"));
        int gamesize = 20;
        if (userint >= 10)
        {
            gamesize = userint;
        }

        myGUI gol = new myGUI(gamesize);
        gol.setVisible(true);

        while (true)
        {
            try
            {
                Thread.sleep(500);
            } catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }

            if (gol.isStart())
            {

                for (int i = 0; i < gol.buttons.size(); i++)
                {
                    JButton tempbutton = gol.buttons.get(i);

                    tempbutton.setText(Integer.toString(gol.numNeighbor(i)));
                    //TESTING THE FOR LOOP
//                    if(tempbutton.getBackground() == Color.red)
//                    {
//                        System.out.println(gol.numNeighbor(i) + "||" + (gol.numNeighbor(i) <= 1) + "||" + (gol.numNeighbor(i) >= 4));
//                    }
                    if (tempbutton.getBackground() == Color.red && gol.numNeighbor(i) <= 1 || gol.numNeighbor(i) >= 4)
                    {
                        dying.add(i);
                    }
                    if (tempbutton.getBackground() == Color.LIGHT_GRAY && gol.numNeighbor(i) == 3)
                    {
                        growing.add(i);
                    }
                }
                while (!growing.isEmpty())
                {
                    gol.buttons.get(growing.remove(0)).setBackground(Color.red);
                }
                while (!dying.isEmpty())
                {
                    gol.buttons.get(dying.remove(0)).setBackground(Color.LIGHT_GRAY);
                }

            }

            for (int i = 0; i < gol.buttons.size(); i++)
            {
                JButton tempbutton = gol.buttons.get(i);

                tempbutton.setText(Integer.toString(gol.numNeighbor(i)));

            }
        }

        // This is the method call gol.clearall();\
    }

}
