/*

MAKE SURE TO ADD KING, QUEEN, ACE, JACK!!
 */
package cardgame;

/**
 *
 * @author jacob
 */
public class Card
{
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 1;
    
   public static final int HEART = 0;
   public static final int SPADE = 1;
   public static final int DIAMOND = 2;
    public static final int CLUB = 3;
   public static final int JOKER = 4;
    
    
    public int facevalue;
    public int suit;
    public boolean faceup = false;
    
    
    public Card(int f, int s)
    {
        facevalue = f;
        suit = s;
    }
    //Overloaded Constructor
    public Card(int fv, int su, boolean fu)
    {
        facevalue = fv;
        suit = su;
        faceup = fu;
    }
    @Override
    public String toString()
    {
        String suitstring;
        String cardval;
        
        if(faceup)    
        {
            if(suit == JOKER)
            {
                return "Joker"; 
            }     
            
             switch(suit) 
        {
            case HEART:
                suitstring = "Hearts";
            break;
            case SPADE:
                suitstring = "Spades";
            break;
            case DIAMOND:
                suitstring = "Diamonds";
            break;
            case CLUB:
                suitstring = "Clubs";
            break;
            case JOKER:
                suitstring = "Joker";
            break;
            default:
                suitstring = "Error";
            break;
            
        }
            switch (facevalue)
            {
                case JACK:
                    cardval = "Jack";
                break;
                case QUEEN:
                    cardval = "Queen";
                break;
                case KING:
                    cardval = "King";
                break;
                case ACE:
                    cardval = "Ace";
                break;
                default:
                    cardval = Integer.toString(facevalue);
                break;
            }
            
                return cardval + " OF " +suitstring;
            
        }else
        {
            return "facedown";
        }
  
    }
    public static Card makejoker()
    {
        Card Joker = new Card(0, Card.JOKER, true);
        return Joker;
    }
}
