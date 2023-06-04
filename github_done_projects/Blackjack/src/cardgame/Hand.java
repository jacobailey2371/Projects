/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

import cardgame.Card;
import java.util.ArrayList;

/**
 *
 * @author jacob
 */
public class Hand
{
    ArrayList<Card> cardsinhand = new ArrayList<Card>();
    boolean isdealer;
    
    
    public Hand(boolean d)
    {
        isdealer = d;
    }
    public int calculate()
    {
        int numace = 0;
        
        int runningtotal = 0;
        for(Card card: cardsinhand)
            //NEED TO ADD ACE AS 11
        {
            if(card.facevalue >= 2 && card.facevalue <= 10)
            {
                runningtotal += card.facevalue;
            }
            else if(card.facevalue >=Card.JACK && card.facevalue <= Card.KING)
                    {
                        runningtotal += 10;
                    }
            else if(card.facevalue == Card.ACE)
                    {
                        numace++;
                        runningtotal += card.facevalue;
                    }       
            
        }
       
        if(numace > 0 && runningtotal <= 11)
        {
            runningtotal += 10;
        }
        
        return runningtotal;            
    }
    public boolean isbust()
    {
        return this.calculate()>21;
    }
    public boolean isBlackJack()
    {
        return this.calculate()==21 && cardsinhand.size() == 2;
    }
    public void acceptCard(Card cardtoadd)
    {
       cardsinhand.add(cardtoadd);
    }
    /**
     * taking all cards from hand, and putting them into target deck Ex:Discarding your hand into the discard pile
     * @param targetdeck 
     */
    public void discardToDeck(Deck targetdeck)
    {
        while(cardsinhand.size() > 0)
        {
            targetdeck.addToDeck(cardsinhand.remove(0));
        }      
    }
    @Override
    public String toString()
    {
        return cardsinhand.toString() + " Value of cards: " + this.calculate();
    }
        
}
