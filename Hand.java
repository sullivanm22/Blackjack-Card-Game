
package edu.wit.scds.comp2000.list.app ;

/**
 * @author Myles Sullivan / Thomas Michael
 * @version 1.0.0 2021-11-30 Initial implementation
 */
public class Hand extends Pile
    {

    /**
     * hand constructor
     */
    public Hand()
        {
        super() ;
        }


    /**
     * calculate the value of the hand
     *
     * @return value, total hand value
     */
    public int calculateHandValue()
        {
        int value = 0 ;
        for ( int i = 0 ; i < this.getCards().size() ; i++ )
            {
            if ( this.containsCardRank( Rank.ACE ) )
                {
                if ( value + this.getCards().get( i ).getValue() > 21 )
                    {
                    //reset value to 0 to recalculate new value with ace being 1
                    value = 0 ;
                    for ( int j = 0 ; i < this.getCards().size() ; j++ )
                        {
                        value += this.getCards().get( j ).getValue() ;
                        }
                    break;
                    }
                //let ace be worth 11
                value += this.getCards().get( i ).getAltValue() ;
                }
            else
                {
                value += this.getCards().get( i ).getAltValue() ;
                }
            }//end for-loop
        return value ;
        }

    }
// end class Hand