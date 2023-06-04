/*
 toString and Shuffle methods.

 */

package cardgame;
//import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author jacob
 */
public class Deck
{
  
    ArrayList<Card> cards = new ArrayList<Card>();
    public static final int EMPTY = 0;
    public static final int PINOCHLE = 1;
    public static final int CANASTA = 2;
    public static final int STANDARD = 3;
    
    
    public Deck(int whichdeck)
    {
        if(whichdeck == PINOCHLE)
        {
            int count = 0;
            int[] pincards = {9, 10, Card.JACK, Card.QUEEN, Card.KING, Card.ACE};
            for(int j = 0; j < 2; j++)
            {
                 for(int n = 0; n < 4; n++)
                {
                     for(int fv: pincards)
                {
                    Card currcard = new Card(fv, n, true);
                    cards.add(currcard);
                    count++;
                }
                    
            }
                    //this is the for loop(above line is much easier to read
//                for(int i=9; i <= Card.KING; i++)
//                { 
//                    
//                    Card currcard = new Card(i, n, true);
//                    cards[count] = currcard;
//                    count++;
//                    System.out.println((count) + " " + (i) + " " + currcard);
//                }
//                int nextcard = 0;
//                Card tempace = new Card(Card.ACE, n, true);
//                cards[count] = tempace;
//                count++;
//                System.out.println(count + " " + tempace);
//            }
            
        }
        }
        else if(whichdeck == CANASTA)
        {
            int count = 0;
            for(int dnum = 0; dnum < 2; dnum++)
            {
                for(int n = 0; n < 4; n++)
                    {
                         for (int i = 1; i <= 13; i++)
                            {
                                cards.add(new Card(i, n, true));
                                //FOR MY OWN SANITY for testing
//                                System.out.println(this.toString());
//                                System.out.println(currcard);
//                                count++;
//                                System.out.println("INDEX" + (i-1 + (13 * n)));
//                                System.out.println(count);
                            }
                    }
            }
            for(int index = 104; index <= cards.size() -1; index++)
                cards.add(Card.makejoker());
        }
        else if(whichdeck == STANDARD)
        {            
            for(int n = 0; n < 4; n++)
                {
                    for (int i = 1; i <= 13; i++)
                        {
                            cards.add(new Card(i,n, true));
                            //Further use to understand
                            //System.out.println("Current index " + (i -1 + (13 * n)) + " " + (i) + " " + (n));
                        }   
                    
                }
        }
    }
    
    public static Deck makeStandard()
    {
        Deck standard = new Deck(STANDARD);
        
        return standard;
    }
    public static Deck pinochle()
    {
        Deck pinochle = new Deck(PINOCHLE);
        return pinochle;
    }
    public static Deck canasta()
    {
        Deck canasta = new Deck(CANASTA);
        return canasta;
    }
    public static Deck empty()
    {
        return new Deck(EMPTY);
    }
        
    @Override
    public String toString()
       {
           
           String deckstring = "";
           int i = 1;
           for(Card cardtemp: cards)
           {
               
               if (cardtemp != null)
               {
               deckstring += cardtemp.toString() + ", ";
              
               
//                   System.out.println("AAAAA");
//                   System.out.println(deckstring);
//                   System.out.println("+++++");
               }else
                  deckstring += "Null ";
               
               if(i % 6 == 0)
                       deckstring += "\n";
                       i++;
               
               //System.out.println("Test " + cardtemp);
           }
           
           return deckstring + "\n The end " + "\n this size is " + cards.size();
       }
    public void shuffle()
    {
        Collections.shuffle(cards);
//        int randomnum= ThreadLocalRandom.current().nextInt(0, cards.size());
//        ArrayList<Card> [] temparr  = new Card [cards.size()];
//         for(Card ownvar: cards)
//         {
//             while(temparr[randomnum] != null)
//             {        
//                 randomnum = ThreadLocalRandom.current().nextInt(0, cards.size());
//             }
//             
//             temparr[randomnum] = ownvar;             
//             randomnum = ThreadLocalRandom.current().nextInt(0, cards.size());
        
//          }        
    }
        public void deal(Hand targethand)
            {
                targethand.acceptCard(cards.remove(0));
                
                 //choose card (start at index 0)
                //put card in hand (pass hand object into this method as an argument)
                //remove card from deck (remove at index 0)
            }
        public void addToDeck(Card cardtoadd)
            {
                 cards.add(cardtoadd);
            }
        public void addToDeck(Deck decktoadd)
        {
            // blackjack ----> discard
           while(decktoadd.cards.size() > 0)
           {
               this.cards.add(decktoadd.cards.remove(0));
           }
        }
        public boolean isOneThird()
        {
                return cards.size() < 17;            
        }
        //This is the same as the above Function but static
//        public static void addDeckToDeck(Deck targetdeck, Deck decktoadd)
//        {
//            while(decktoadd.cards.size() > 0)
//            {
//                targetdeck.cards.add(decktoadd.cards.remove(0));
//            }               
//        }
            
                
        
}
//try to make it not collide at all
