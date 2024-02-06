
package edu.wit.scds.comp2000.list.app ;

/**
 * @author Ben Mallett
 * @version 1.0.0 2021-11-30 Initial implementation
 */
public class Player
    {

    private String name = null ;
    protected Hand hand = new Hand() ;
    protected boolean stand = false ;

    /**
     * default constructor
     */
    public Player()
        {}


    /**
     * create a player and set the name
     * 
     * @param newName
     */
    public Player( String newName )
        {
        this.name = newName ;
        }


    /**
     * @return players name
     */
    public String getName()
        {
        return this.name ;
        }


    /**
     * @return the players hand
     */
    public Hand getHand()
        {
        return this.hand ;
        }


    /**
     * add card to players hand
     *
     * @param card
     */
    public void hit( Card card )
        {
        this.hand.addCard( card ) ;
        }


    /**
     * set stand to true indicating end of turn
     */
    public void stand()
        {
        this.stand = true ;
        }


    /**
     * @return stand
     */
    public boolean getStand()
        {
        return this.stand ;
        }
    }
// end class Player