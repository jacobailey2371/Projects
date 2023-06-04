/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jacob
 */
public class myGUI extends javax.swing.JFrame implements ActionListener
{

    public ArrayList<JButton> buttons;
    private int buttonsizepx;
    private int gameheight = 40;
    private int gamewidth = 40;
    private int buttonsize = 70;
    private boolean issteppressed = false;
    private JButton start = new JButton("Start");
    private JButton step = new JButton("Step");
    private JButton clear = new JButton("Clear");

    public myGUI(int gamesize)
    {
        gameheight = gamesize;
        gamewidth = gamesize;

        buttons = new ArrayList<JButton>();
        int buttoncontrolheight = 100;
        int buttoncontrolwidth = 150;

        this.setVisible(true);
        this.setTitle("Game Of Life");
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000, 800);

        //Start button
        start.setLocation((gamewidth * buttonsize) + 20, (gameheight * buttonsize) * 1 / 4 - (buttoncontrolheight / 2));
        start.setSize(buttoncontrolwidth, buttoncontrolheight);
        this.add(start);
        start.addActionListener(this);

        //Step button
        step.setLocation((gameheight * buttonsize) + 20, (gamewidth * buttonsize) * 2 / 4 - (buttoncontrolheight / 2));
        step.setSize(buttoncontrolwidth, buttoncontrolheight);
        this.add(step);
        step.addActionListener(this);

        //Clear button
        clear.setLocation((gameheight * buttonsize) + 20, (gamewidth * buttonsize) * 3 / 4 - (buttoncontrolheight / 2));
        clear.setSize(buttoncontrolwidth, buttoncontrolheight);
        this.add(clear);
        clear.addActionListener(this);

        for (int y = 0; y < gameheight; y++)
        {
            for (int x = 0; x < gamewidth; x++)
            {
                String name = Integer.toString((y * 20) + x);
                JButton button1 = new JButton();
                button1.setBackground(Color.LIGHT_GRAY);
                button1.addActionListener(this);
                button1.setText(name);
                buttons.add(button1);
                this.add(button1);
                button1.setSize(buttonsize, buttonsize);
                button1.setLocation(x * buttonsize, y * buttonsize);

            }
        }
    }

    public void actionPerformed(ActionEvent ae)
    {
        int index = 0;
        JButton clicked = (JButton) ae.getSource();
        
        if (ae.getSource() == start)
        {
            if (start.getText() == "Stop")
            {
                start.setText("Start");
            } else if (start.getText() == "Start")
            {
                start.setText("Stop");
            }
        } else if (ae.getSource() == step)
        {
            issteppressed = true;
        } else if (ae.getSource() == clear)
        {
            clearAll();
        } else
        {
            if (clicked.getBackground() == Color.red)
            {
                clicked.setBackground(Color.LIGHT_GRAY);
            } else
            {
                clicked.setBackground(Color.red);
            }
        }

        //making a fucntion that clears all squares inside of myGUI
        //you can definetly write it *hint loop over button inside the function, and call in main method
        // make clear button clear all squares
        //start and stop needs to be 
    }

    public void clearAll()
    {
        for (JButton tempbutton : buttons)
        {
            tempbutton.setBackground(Color.LIGHT_GRAY);
        }
    }

    public boolean isStart()
    {

        if (issteppressed == true)
        {
            issteppressed = false;
            return true;
        } else if (start.getText() == "Stop")
        {
            return true;
        }

        return false;
    }

    public int numNeighbor(int i)
    {
        boolean upneighbor = i >= gamewidth;
        boolean downneighbor = i < (gameheight - 1) * gamewidth;
        boolean leftneighbor = i % gamewidth != 0;
        boolean rightneighbor = i % gamewidth != gamewidth - 1;

        int numberofneighbor = 0;
        if (rightneighbor && buttons.get(i + 1).getBackground() == Color.red)
        {
            numberofneighbor++;
        }
        if (leftneighbor && buttons.get(i - 1).getBackground() == Color.red)
        {
            numberofneighbor++;
        }
        if (upneighbor && buttons.get(i - gamewidth).getBackground() == Color.red)
        {
            numberofneighbor++;
        }
        if (downneighbor && buttons.get(i + gamewidth).getBackground() == Color.red)
        {
            numberofneighbor++;
        }
        //diagnal neighbors
        if (upneighbor && leftneighbor && buttons.get((i - gamewidth) - 1).getBackground() == Color.red)
        {
            numberofneighbor++;
        }
        if (upneighbor && rightneighbor && buttons.get((i - gamewidth) + 1).getBackground() == Color.red)
        {
            numberofneighbor++;
        }
        if (downneighbor && rightneighbor && buttons.get((i + gamewidth) + 1).getBackground() == Color.red)
        {
            numberofneighbor++;
        }
        if ((downneighbor && leftneighbor && buttons.get((i + gamewidth) - 1).getBackground() == Color.red))
        {
            numberofneighbor++;
        }
        return numberofneighbor;
    }
}
