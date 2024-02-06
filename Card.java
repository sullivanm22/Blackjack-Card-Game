/*
 * Dave Rosenberg
 * Comp 2000 - Data Structures
 * Lab: List application - card game
 * Spring, 2019
 * 
 * Usage restrictions:
 * 
 * You may use this code for exploration, experimentation, and furthering your
 * learning for this course. You may not use this code for any other
 * assignments, in my course or elsewhere, without explicit permission, in
 * advance, from myself (and the instructor of any other course).
 * 
 * Further, you may not post or otherwise share this code with anyone other than
 * current students in my sections of this course. Violation of these usage
 * restrictions will be considered a violation of the Wentworth Institute of
 * Technology Academic Honesty Policy.
 */

package edu.wit.scds.comp2000.list.app ;

import java.util.ArrayList ;
import java.util.Collections ;
import java.util.List ;
import java.util.Objects ;

/**
 * An immutable playing card with a suit and rank.
 * <p>
 * You can use this as a template to create customized implementations according to the
 * requirements of your game.
 * 
 * @author Dave Rosenberg
 * @version 1.0.0 2020-11-19 initial version
 * 
 * @author Myles Sullivan
 * @version 2.0 2021-11-30 added methods for Blackjack implementation
 */
public class Card implements Comparable<Card>
    {
    // data fields
    /** The card's suit */
    public final Suit suit ;
    /** The card's rank within its suit */
    public final Rank rank ;
    //card is flipped or not
    private boolean flipped = false;

    /**
     * @param theSuit
     *     this card's suit
     * @param theRank
     *     this card's rank
     */
    public Card( final Suit theSuit,
                 final Rank theRank )
        {
        this.suit = theSuit ;
        this.rank = theRank ;
        }   // end constructor


    /**
     *Flips the card over 
     *
     */
    public void flip()
    {
    if(!isFlipped())
        {
        this.flipped = true;
        }
        else if(isFlipped())
        {
        this.flipped = false;
        }
   
    }
    /**
     * 
     * @return if the card is flipped over (true) or not (false)
     */
    private boolean isFlipped()
        {
        if(!this.flipped)
            {
            return this.flipped=false;
            }
        return true;
        }
        
    /**
     *
     * @return value of the card
     */
    public int getValue()
    {
    return this.rank.getPoints();
    }
    
    public int getAltValue()
    {
    return this.rank.getAltPoints();
    }


    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo( Card otherCard )
        {
        final int suitOrder = this.suit.compareTo( otherCard.suit ) ;
        if ( suitOrder == 0 )
            {
            return this.rank.compareTo( otherCard.rank ) ;
            }
        
        return suitOrder ;
        
        }   // end compareTo()



    /* (non-Javadoc)
     * @see java.lang.Comparable#equals(java.lang.Object)
     */
    @Override
    public boolean equals( Object otherObject )
        {
        // same object?
        if ( this == otherObject )
            {
            return true ;
            }
        
        // another Card?  false if otherObject is null
        if ( otherObject instanceof Card )
            {
            final Card otherCard = (Card) otherObject ;
            
            return this.suit.equals( otherCard.suit ) && 
                   this.rank.equals( otherCard.rank ) ;
            }
        
        // no match
        return false ;
        
        }   // end equals()


    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
        {
        return Objects.hash( this.suit, this.rank ) ;
        
        }   // end hashCode()
    

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
        {
        if(this.flipped)
            {
            return "XX";
            }
        return this.rank.toString() + this.suit.toString() ;
        
        }   // end toString()


    /**
     * Test driver
     * 
     * @param args
     *     -unused-
     */
    public static void main( String[] args )
        {
        final Suit[] suits = Suit.values() ;
        final Rank[] ranks = Rank.values() ;
        
        final List<Card> cards = new ArrayList<>( suits.length * ranks.length ) ;
        
        // generate a deck of cards
        System.out.printf( "New cards:%n" ) ;
        for ( final Suit suit : suits )
            {
            // skip placeholder suit
            if ( suit.equals( Suit.NONE ) )
                {
                continue ;
                }
            
            for ( final Rank rank : ranks )
                {
                // skip non-playing card(s) - Joker
                if ( rank.equals( Rank.JOKER ) )
                    {
                    continue ;
                    }
                
                // build a card
                Card newCard = new Card( suit, rank ) ;
                System.out.printf( " %s", newCard ) ;
                
                // keep track of it
                cards.add( newCard ) ;
                }
            }
        
        // display all the cards
        System.out.printf( "%n%nAll cards:%n%s%n%n", cards.toString() ) ;
        
        // shuffled
        Collections.shuffle( cards ) ;
        System.out.printf( "%nShuffled:%n%s%n%n", cards.toString() ) ;
        
        // shuffled
        Collections.sort( cards ) ;
        System.out.printf( "%nSorted:%n%s%n%n", cards.toString() ) ;
        
        
        // compare some cards against each other
        Card card1 = cards.get( 15 ) ;
        Card card2 = cards.get( 43 ) ;
        System.out.printf( "%s.compareTo(%s) = %,d%n", card1, card2, card1.compareTo( card2 ) ) ;
        
        card2 = cards.get( 4 ) ;
        System.out.printf( "%s.compareTo(%s) = %,d%n", card1, card2, card1.compareTo( card2 ) ) ;
        
        card2 = cards.get( 20 ) ;
        System.out.printf( "%s.compareTo(%s) = %,d%n", card1, card2, card1.compareTo( card2 ) ) ;
        
        
        System.out.printf( "%n" ) ;
        System.out.printf( "%s.equals(%s) = %b%n", card1, card1, card1.equals( card1 ) ) ;
        System.out.printf( "%s.equals(%s) = %b%n", card1, card2, card1.equals( card2 ) ) ;
        
        card1 = new Card( Suit.DIAMONDS, Rank.FOUR ) ;
        card2 = new Card( Suit.HEARTS, Rank.FOUR ) ;
        System.out.printf( "%s.equals(%s) = %b%n", card1, card2, card1.equals( card2 ) ) ;
        
        }   // end main()

    }   // end class Card
