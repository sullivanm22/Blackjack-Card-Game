
package edu.wit.scds.comp2000.list.app ;

import java.util.ArrayList ;
import java.util.Scanner ;

/**
 * @author Thomas Michael / Myles Sullivan
 * @version 1.0.0 2021-11-30 Initial implementation
 */

public class Blackjack
    {

    /**
     * This will start and end the game meanwhile displaying all the correct messages to the players.
     *
     * @param args
     */
    public static void main( String[] args )
        {
        boolean restart = true ;
        while ( restart )
            {
            Scanner scan = new Scanner( System.in ) ;
            System.out.println( "               ** BLACKJACK **                " ) ;
            System.out.println( "Welcome! \n\nEnter Player One's name." ) ;
            String player1Name = scan.nextLine() ;
            Player player1 = new Player( player1Name ) ;
            System.out.println( "\nEnter Player Two's name." ) ;
            String player2Name = scan.nextLine() ;
            Player player2 = new Player( player2Name ) ;
            System.out.println( "\nEnter Player Three's name." ) ;
            String player3Name = scan.nextLine() ;
            Player player3 = new Player( player3Name ) ;

            // create an array list of all the players to easily iterate though them
            ArrayList<Player> players = new ArrayList<>( 3 ) ;
            players.add( player1 ) ;
            players.add( player2 ) ;
            players.add( player3 ) ;

            Deck deck = new Deck() ;
            deck.shuffle() ;

            Dealer dealer = new Dealer() ;

            System.out.println( "\nStarting game...Cards are being dealt!\n" ) ;
            initialDeal( deck, players, dealer ) ;
            System.out.printf( "%s: %s%n%n%s: %s%n%n%s: %s%n%n",
                               player1.getName(),
                               player1.getHand().toString(),
                               player2.getName(),
                               player2.getHand().toString(),
                               player3.getName(),
                               player3.getHand().toString() ) ;
            System.out.printf( "Dealer: %s%n%n", dealer.getHand().toString() ) ;
            System.out.println( "\n\n" ) ;

            // complete all turns including the dealer
            play( deck, players, scan, dealer ) ;

            // calculate end results and display for each player if they won/lost
            endResults( players, dealer ) ;

            System.out.println( "Do you want to play again: (y or n)" ) ;
            String again = scan.nextLine() ;

            // read input to continue playing or not
            while ( true )
                {
                if ( again.equalsIgnoreCase( "y" ) )
                    {
                    restart = true ;
                    break ;
                    }
                else if ( again.equalsIgnoreCase( "n" ) )
                    {
                    restart = false ;
                    break ;
                    }
                else
                    {
                    System.out.println( "Invalid entry, type 'y' to restart or 'n' to end game." ) ;
                    again = scan.nextLine() ;
                    }
                }
            }

        System.out.println( "GAME ENDED" ) ;
        System.exit( 0 ) ;
        }


    /**
     * This method will populate all 3 player's hands in correct order. That is each
     * player is handed 1 card, then the dealer is given one card(flipped over) and
     * then all 3 players get another card and the dealer gets one more card. All
     * cards are dealt from the top of the current (already shuffled) deck.
     *
     * @param deck
     * @param players
     * @param dealer
     */
    public static void initialDeal( Deck deck,
                                    ArrayList<Player> players,
                                    Dealer dealer )
        {
        // player 1
        players.get( 0 ).getHand().addCard( deck.dealTopCard() ) ;
        // player 2
        players.get( 1 ).getHand().addCard( deck.dealTopCard() ) ;
        // player 3
        players.get( 2 ).getHand().addCard( deck.dealTopCard() ) ;
        // dealer
        dealer.getHand().addCard( deck.dealTopCard() ) ;
        dealer.getHand().getCards().get( 0 ).flip() ;

        players.get( 0 ).getHand().addCard( deck.dealTopCard() ) ;
        players.get( 1 ).getHand().addCard( deck.dealTopCard() ) ;
        players.get( 2 ).getHand().addCard( deck.dealTopCard() ) ;
        dealer.getHand().addCard( deck.dealTopCard() ) ;

        }


    /**
     * give all three players the chance to play their turn
     *
     * @param deck
     * @param players
     * @param scan
     */
    public static void play( Deck deck,
                             ArrayList<Player> players,
                             Scanner scan,
                             Dealer dealer )
        {
        for ( Player player : players )
            {
            System.out.printf( "%s's Hand: %s%n",
                               player.getName(),
                               player.getHand().toString() ) ;
            while ( ( player.getHand().calculateHandValue() <= 21 ) &&
                    !player.getStand() )
                {
                System.out.printf( "%s's turn (type 'H' to hit or 'S' to stand): ",
                                   player.getName() ) ;
                String input = null ;
                input = scan.nextLine() ;
                if ( input.equalsIgnoreCase( "h" ) )
                    {
                    player.hit( deck.dealTopCard() ) ;
                    System.out.printf( "%s's Hand: %s%n",
                                       player.getName(),
                                       player.getHand().toString() ) ;
                    if ( player.getHand().calculateHandValue() > 21 )
                        {
                        System.out.print( "You busted :( " ) ;
                        player.stand() ;
                        }

                    }
                else if ( input.equalsIgnoreCase( "s" ) )
                    {
                    player.stand() ;
                    System.out.printf( "%s's Hand: %s%n",
                                       player.getName(),
                                       player.getHand().toString() ) ;
                    }
                else
                    {
                    System.out.println( "Invalid entry, type 'H' to hit or 'S' to stand." ) ;
                    }

                } // end while

            System.out.println( "\n" ) ;
            }

        // flip the dealers first card so it is visible to players
        dealer.getHand().getCards().get( 0 ).flip() ;
        System.out.println() ;

        System.out.printf( "Dealer's Hand: %s%n", dealer.getHand().toString() ) ;
        // complete the dealers turn
        while ( ( dealer.getHand().calculateHandValue() <= 17 ) &&
                !dealer.getStand() )
            {
            if ( dealer.getHand().calculateHandValue() < 17 )
                {
                dealer.hit( deck.dealTopCard() ) ;
                System.out.println( "Dealer hits!" ) ;
                System.out.printf( "Dealer's Hand: %s%n",
                                   dealer.getHand().toString() ) ;
                if ( dealer.getHand().calculateHandValue() > 21 )
                    {
                    dealer.stand() ;
                    System.out.println( "Dealer has busted!" ) ;
                    System.out.printf( "Dealer's Hand: %s%n",
                                       dealer.getHand().toString() ) ;
                    }
                }
            else
                {
                dealer.stand() ;
                System.out.println( "Dealer stands!" ) ;
                System.out.printf( "Dealer's Hand: %s%n",
                                   dealer.getHand().toString() ) ;
                }
            } // end while
        System.out.printf( "Dealer's Hand: %d%n",
                           dealer.getHand().calculateHandValue() ) ;

        System.out.println( "\n\n" ) ;
        }


    /**
     * iterate through all three players and check their win conditions against the
     * dealer and display the correct messages.
     *
     * @param players
     * @param dealer
     */
    public static void endResults( ArrayList<Player> players,
                                   Dealer dealer )
        {
        for ( Player player : players )
            {
            System.out.printf( "%s's Hand Total: %d%n",
                               player.getName(),
                               player.getHand().calculateHandValue() ) ;
            if ( player.getHand().calculateHandValue() > 21 )
                {
                System.out.println( player.getName() +
                                    " lost this hand (busted)." ) ;
                }
            else if ( player.getHand().calculateHandValue() >
                      dealer.getHand().calculateHandValue() )
                {
                System.out.println( player.getName() + " won this hand!" ) ;
                }
            else if ( ( player.getHand().calculateHandValue() <
                        dealer.getHand().calculateHandValue() ) &&
                      ( dealer.getHand().calculateHandValue() <= 21 ) )
                {
                System.out.println( player.getName() +
                                    " lost this hand to the dealer." ) ;
                }
            else if ( player.getHand().calculateHandValue() ==
                      dealer.getHand().calculateHandValue() )
                {
                System.out.println( player.getName() + " tied the dealer!" ) ;
                }
            else if ( player.getHand().calculateHandValue() <= 21 &&
                      dealer.getHand().calculateHandValue() > 21 )
                {
                System.out.println( "Dealer busted!" ) ;
                System.out.println( player.getName() + " won this hand!" ) ;
                }
            System.out.println( "\n" ) ;
            }
        }
    }
// end class Blackjack