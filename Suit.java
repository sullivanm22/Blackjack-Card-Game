/* @formatter:off
 *
 * Dave Rosenberg
 * Comp 2000 - Data Structures
 * Lab: List application - card game
 * Fall, 2021
 * 
 * Usage restrictions:
 * 
 * You may use this code for exploration, experimentation, and furthering your
 * learning for this course. You may not use this code for any other
 * assignments, in my course or elsewhere, without explicit permission, in
 * advance, from myself (and the instructor of any other course).
 * 
 * Further, you may not post nor otherwise share this code with anyone other than
 * current students in my sections of this course. Violation of these usage
 * restrictions will be considered a violation of the Wentworth Institute of
 * Technology Academic Honesty Policy.
 *
 * Do not remove this notice.
 *
 * @formatter:on
 */

package edu.wit.scds.comp2000.list.app ;

/**
 * An enumeration of card suits. (Listing C-2 of Appendix C.)
 * <p>
 * You may want/need to adjust the priorities for your game.  As provided, suits are
 * ordered by priority:<br>
 * <pre>Spades (highest) -> Diamonds -> Hearts -> Clubs -> none (lowest)</pre>
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 4.0
 * 
 * @author David M Rosenberg
 * @version 4.1.0 2016-03-16
 *     <ul>
 *     <li>enhanced definition: added display name and graphic
 *     <li>added test driver main()
 *     </ul>
 * @version 4.1.1 2021-11-19
 *     <ul>
 *     <li>fill in Javadoc comments
 *     <li>add Comparator/compare()
 *     </ul>
 */
public enum Suit
    {
//  Element         Display Name    Graphic     Color      Priority
    /** Spades suit */
    SPADES      (   "Spades",       "♠",        "black",    1 ),
    /** Diamonds suit */
    DIAMONDS    (   "Diamonds",     "♦",        "red",      2 ),
    /** Hearts suit */
    HEARTS      (   "Hearts",       "♥",        "red",      3 ),
    /** Clubs suit */
    CLUBS       (   "Clubs",        "♣",        "black",    4 ),
    /** no suit - for cards such as Joker */
    NONE        (   "",             "",         "",         5 )
    ;


    // data fields
    private final String displayName;
    private final String graphic;
    private final String color;
    private final int priority;

    
    /**
     * @param suitDisplayName
     *     more esthetically pleasing for display
     * @param suitGraphic
     *     the 'standard' icon for the suit
     * @param suitColor
     *     the 'standard' color for the suit
     * @param suitPriority
     *     relative value/priority of the suit - used by compare()
     */
    private Suit( String suitDisplayName, 
                  String suitGraphic, 
                  String suitColor, 
                  int suitPriority )
        {
        this.displayName =   suitDisplayName;
        this.graphic =       suitGraphic;
        this.color =         suitColor;
        this.priority =      suitPriority;
        
        } // end constructor

    
    /**
     * @return the display name
     */
    public String getDisplayName()
        {
        return this.displayName;
        
        } // end getDisplayName
    
    
    /**
     * @return the graphic/icon
     */
    public String getGraphic()
        {
        return this.graphic;
        
        } // end getGraphic

 
    /**
     * @return the color
     */
    public String getColor()
        {
        return this.color;
        
        } // end getColor
    

    /**
     * @return the suit's priority
     */
    public int getPriority()
        {
        return this.priority;
        
        }   // end getPriority
    

    /**
     * For display, use the graphic/icon
     */
    @Override
    public String toString()
        {
        return this.graphic ;
        
        }   // end toString()
    
    
    /**
     * Test driver
     *
     * @param args
     *     -unused-
     */
    public static void main( String[] args )
        {
        // display column headers 
        System.out.printf( "%-5s %-15s %-8s %-15s %-15s %-10s %-10s%n", 
                            "#",
                            "Suit",
                            "Graphic",
                            "Name",
                            "Display Name",
                            "Color",
                            "Priority" );

        // display each element of the enumeration
        for ( Suit aSuit : Suit.values() )
            {
            System.out.printf( "%-5d %-15s %-8s %-15s %-15s %-10s %-10d%n", 
                                aSuit.ordinal(), 
                                aSuit,
                                aSuit.graphic,
                                aSuit.name(),
                                aSuit.displayName,
                                aSuit.color,
                                aSuit.getPriority() );
            }   // end for
        
        }   // end main()

    } // end enum Suit