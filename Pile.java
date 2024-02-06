
package edu.wit.scds.comp2000.list.app ;

import java.util.ArrayList ;
import java.util.Collections ;
import java.util.List ;

/**
 * @author Myles Sullivan
 * @version 1.0.0 2021-11-30 Initial implementation
 */
public class Pile
    {

    private int numberOfCards = 0 ;
    private ArrayList<Card> cards = new ArrayList<>( 52 ) ;

    /**
     * pile constructor used by other classes to create a list of cards
     */
    public Pile()
        {}


    /**
     * add a card to the pile
     *
     * @param card
     */
    public void addCard( Card card )
        {
        this.getCards().add( card ) ;
        this.numberOfCards++ ;
        }


    /**
     * remove card at the specified index
     *
     * @param index
     */
    public void removeAtIndex( int index )
        {
        this.getCards().remove( index ) ;
        this.numberOfCards-- ;
        }


    /**
     * return the number of cards in the pile
     *
     * @return
     */
    public int getNumOfCards()
        {
        return this.numberOfCards ;
        }


    /**
     * @return true/false
     */
    public boolean isEmpty()
        {
        if ( this.numberOfCards == 0 )
            {
            return true ;
            }
        return false ;
        }


    /**
     * find the index of where the card is located
     *
     * @param card
     * @return -1 if not in pile, or the index it is located at
     */
    public int containsCard( Card card )
        {
        if ( !isEmpty() )
            {
            return -1 ;
            }
        for ( int i = 0 ; i < this.getCards().size() ; i++ )
            {
            if ( card.compareTo( this.getCards().get( i ) ) == 0 )
                {
                return i ;
                }
            }
        return -1 ;
        }


    /**
     * returns if there is a card of specified rank in the pile
     *
     * @param rank
     * @return true/false
     */
    public boolean containsCardRank( Rank rank )
        {
        if ( !isEmpty() )
            {
            return false ;
            }
        for ( int i = 0 ; i < this.getCards().size() ; i++ )
            {
            if ( rank.compareTo( this.getCards().get( i ).rank ) == 0 )
                {
                return true ;
                }
            }
        return false ;
        }


    /**
     * using the rank enum returns -1, if the card isnt in the deck 0-51, index the
     * card rank is located at
     * 
     * @param rank
     * @return -1, if the card isnt in the deck 0-51, index the card rank is located
     *     at
     */
    public int findCardRank( Rank rank )
        {
        if ( !isEmpty() )
            {
            return -1 ;
            }
        for ( int i = 0 ; i < this.getCards().size() ; i++ )
            {
            if ( rank.compareTo( this.getCards().get( i ).rank ) == 0 )
                {
                return i ;
                }
            }
        return -1 ;
        }


    /**
     * shuffles the collection of cards
     */
    public void shuffle()
        {
        Collections.shuffle( this.getCards() ) ;
        }


    @Override
    public String toString()
        {
        String pileOfCards = "" ;
        for ( Card Card : this.getCards() )
            {
            pileOfCards += Card.toString() + " " ;
            }
        return pileOfCards ;
        }


    /**
     * @return the cards
     */
    public ArrayList<Card> getCards()
        {
        return this.cards ;
        }
    }
// end class Pile