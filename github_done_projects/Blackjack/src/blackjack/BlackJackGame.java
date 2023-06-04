package blackjack;

import cardgame.Hand;
import cardgame.Card;
import cardgame.Deck;
import java.util.Scanner;

/**
 *
 * @author jacob
 */
public class BlackJackGame
{
    //user input
    //control of the game in main method bust,hit,stay (bet whole dollar amounts), cash-out odds
    //blackjack
    //deck(deal with face up and down option, draw method (cards are not returned to deck)@1/3 or less cards left shuffle, let player know shuffle is happening)
    //table

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        int playersmoney = 1000;
        int playersbet = 0;
        //int maxbet = 1000;
        int minbet = 10;
        boolean firsthand = true;
        char moneysign = '$';
//        boolean didbust;
//        Card twoofhearts = new Card(Card.JACK,Card.HEART, true);
//        Card test3 = new Card(3, Card.HEART, true);
//        
        Deck blackjack = Deck.makeStandard();
        Deck discarddeck = Deck.empty();
        Hand dealer = new Hand(true);
        Hand player = new Hand(false);
//        player.acceptCard(ace);
//        player.acceptCard(twoofhearts);
//        player.acceptCard(test3);

        //System.out.println(player.toString());
        Scanner input = new Scanner(System.in);
        //create player hand, and dealer hand

        blackjack.shuffle();

        while (true)
        {
            boolean dealerbust = false;
            boolean playerbust = false;
            boolean playerbj = false;
            boolean dealerbj = false;

            if (blackjack.isOneThird())
            {
                System.out.println("The deck is shuffling");
                blackjack.addToDeck(discarddeck);
                blackjack.shuffle();
            }
            System.out.println("Your money: " + playersmoney + "$");
            if (!firsthand)
            {

                if (playersmoney == 0)
                {
                    System.out.println("Your all out of money");

                    break;
                }

                System.out.println("Do you want to cashout? Yes or No.");
                String playerschoice = input.next();

                if (playerschoice.equalsIgnoreCase("yes"))
                {
                    System.out.println("You have recieved $" + playersmoney);
                    break;
                }
            } else
            {

                firsthand = false;
            }

            System.out.println("What do you want to bet ?");
            while (true)
            {
                playersbet = input.nextInt();
                if (playersbet > playersbet || playersbet < minbet)
                {
                    System.out.println("Your bet must be between " + minbet + "$ " + playersbet + "$ \n Please enter a valid bet");
                    continue;
                } else if (playersbet > playersmoney)
                {
                    System.out.println("You only have " + playersmoney + "$ Your bet must be between " + minbet + " " + playersbet + "\n Please enter a valid bet");
                    continue;
                }
                break;
            }
            
            blackjack.deal(player);
            blackjack.deal(dealer);
            blackjack.deal(player);
            blackjack.deal(dealer);

            System.out.println("Your hand is " + player);
            System.out.println(" The Dealers hand is " + dealer);

            if (player.isBlackJack() || dealer.isBlackJack())
            {
                if (dealer.isBlackJack() && player.isBlackJack())
                {
                    System.out.println("Dealer and Player had natural 21");
                } else if (player.isBlackJack())
                {
                    playersmoney = (int) (playersbet * 2.5);
                } else if (dealer.isBlackJack())
                {
                    playersmoney -= playersbet;
                    System.out.println("You lost!");
                }
                player.discardToDeck(discarddeck);
                dealer.discardToDeck(discarddeck);
                continue;
            }

            while (!player.isbust())
            {
                System.out.println("Do you want to hit? Type hit, or stay");
                String playeranswer = input.next();
                if (playeranswer.equalsIgnoreCase("hit"))
                {
                    blackjack.deal(player);
                    System.out.println("Your hand is " + player);
                } else if (playeranswer.equalsIgnoreCase("stay"))
                {
                    //MAKE SURE TO FLIP DEALER CARD (FALSE)
                    break;
                }
            }
            if (player.isbust())
            {
                System.out.println("You bust!");
                playerbust = true;
            }
            while (!dealer.isbust() && dealer.calculate() <= 16)
            {
                blackjack.deal(dealer);
                System.out.println("The dealer hand is: " + dealer);
            }

            if (!player.isbust() && !dealer.isbust())
            {
                if (player.calculate() > dealer.calculate())
                {
                    System.out.println("We added money");
                    playersmoney += playersbet;
                } else if (player.calculate() < dealer.calculate())
                {
                    System.out.println("We took money away");
                    playersmoney -= playersbet;
                }
            }

            if (dealer.isbust())
            {
                System.out.println("Dealer busts");
                System.out.println(dealer);
                dealerbust = true;
            }

            //handles cashouts with busts
            if (playerbust == true)
            {
                System.out.println("Player busts");
                playersmoney -= playersbet;
            } else if (dealerbust == true)
            {
                System.out.println("Dealer busts");
                playersmoney += playersbet;
            }
            player.discardToDeck(discarddeck);
            dealer.discardToDeck(discarddeck);

            //no busts
            //ACES need to be 1 or 11
            //TEST!!
        }

    }

}
