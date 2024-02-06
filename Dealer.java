
package edu.wit.scds.comp2000.list.app ;

/**
 * @author Sean Prevett
 * @version 1.0.0 2021-11-30 Initial implementation
 */
public class Dealer extends Player
    {

    /**
     * dealer constructor (creates a player)
     */
    public Dealer()
        {
        super() ;
        }


    @Override
    public void hit( Card card )
        {
        this.hand.addCard( card ) ;
        }


    @Override
    public void stand()
        {
        this.stand = true ;
        }

    }
// end class Dealer