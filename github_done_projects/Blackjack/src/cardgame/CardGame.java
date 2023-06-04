/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

/**
 *
 * @author jacob
 */
public class CardGame
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
      
            Deck deck1 = new Deck(Deck.PINOCHLE);
            System.out.println(deck1);
            deck1.shuffle();
            System.out.println(deck1);
            
//        Card card1 = new Card(2,Card.CLUB,true);
//        Card card2 = new Card(3, Card.CLUB, true);
//        Card card3 = new Card(4, Card.CLUB, true);
//        Card card4 = new Card(11, Card.CLUB, true);
//        
//        System.out.println(card1.toString());
//        System.out.println(card2.toString());
//        
//        for(int facevalue = 0; facevalue <=14; facevalue++)
//        {
//            Card currcard = new Card(facevalue, Card.CLUB, true);
//            System.out.println(currcard);
//        }
        
}
}
       
