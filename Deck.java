
package edu.wit.scds.comp2000.list.app ;

/**
 * @author Myles Sullivan
 * @version 1.0.0 2021-11-30 Initial implementation
 */
public class Deck extends Pile
    {

    /**
     * constructs a pile and adds the respective 52 cards into the deck
     */
    public Deck()
        {
        super() ;
        for ( Suit suit : Suit.values() )
            {
            //excluding the NONE suit value
            if ( suit != suit.NONE )
                {
                for ( Rank rank : Rank.values() )
                    {
                    //excluding the joker rank
                    if ( rank != rank.JOKER )
                        {
                        Card newCard = new Card( suit, rank ) ;
                        addCard( newCard ) ;
                        }
                    }
                }
            }

        }


    /**
     * remove the card from the top of the deck
     *
     * @return the card from the top of the deck
     */
    public Card dealTopCard()
        {
        Card card = this.getCards().get( this.getNumOfCards() - 1 ) ;
        removeAtIndex( this.getNumOfCards() - 1 ) ;
        return card ;
        }

    }
// end class Deck