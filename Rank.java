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
 * An enumeration of card ranks.
 * 
 * @author David M Rosenberg
 * @version 1.0.0 2016-03-16 initial version
 */
public enum Rank
    {
//  Element     Display Name    Graphic     Points      Alt Points  Priority    Alt Priority
    /** Ace */
    ACE     (   "Ace",          "A",        1,          11,         1,          14 ),
    /** Two */
    TWO     (   "Duece",        "2",        2,          2,          2,          2 ),
    /** Three */
    THREE   (   "Three",        "3",        3,          3,          3,          3 ),
    /** Four */
    FOUR    (   "Four",         "4",        4,          4,          4,          4 ),
    /** Five */
    FIVE    (   "Five",         "5",        5,          5,          5,          5 ),
    /** Six */
    SIX     (   "Six",          "6",        6,          6,          6,          6 ),
    /** Seven */
    SEVEN   (   "Seven",        "7",        7,          7,          7,          7 ),
    /** Eight */
    EIGHT   (   "Eight",        "8",        8,          8,          8,          8 ),
    /** Nine */
    NINE    (   "Nine",         "9",        9,          9,          9,          9 ),
    /** Ten */
    TEN     (   "Ten",          "10",       10,         10,         10,         10 ),
    /** Jack */
    JACK    (   "Jack",         "J",        10,         10,         10,         10 ),
    /** Queen */
    QUEEN   (   "Queen",        "Q",        10,         10,         10,         10 ),
    /** King */
    KING    (   "King",         "K",        10,         10,         10,         10 ),
    /** Joker */
    JOKER   (   "Joker",        "R",        0,          0,          99,         99 )
    ;

    private final String displayName;
    private final String graphic;
    private final int points;
    private final int altPoints;
    private final int priority;
    private final int altPriority;
    

    /**
     * @param rankDisplayName
     *     more esthetically pleasing for display
     * @param rankGraphic
     *     the 'standard' icon
     * @param rankPoints
     *     numeric value for the card
     * @param rankAltPoints
     *     alternate value for the card (e.g., Ace can be worth 1 or 11 points)
     * @param rankPriority
     *     numeric priority for the card
     * @param rankAltPriority
     *     alternate priority for the card (e.g., Ace can have the lowest or highest
     *     priority)
     */
    private Rank( String rankDisplayName, 
                  String rankGraphic, 
                  int rankPoints, 
                  int rankAltPoints, 
                  int rankPriority, 
                  int rankAltPriority )
        {
        this.displayName =   rankDisplayName;
        this.graphic =       rankGraphic;
        this.points =        rankPoints;
        this.altPoints =     rankAltPoints;
        this.priority =      rankPriority;
        this.altPriority =   rankAltPriority;
        
        } // end constructor

    
    /**
     * @return the alternate point value
     */
    public int getAltPoints()
        {
        return this.altPoints;
        
        } // end getAltPoints
    
    
    /**
     * @return the alternate priority
     */
    public int getAltPriority()
        {
        return this.altPriority;
        
        } // end getAltPriority
    
    
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
     * @return the point value
     */
    public int getPoints()
        {
        return this.points;
        
        } // end getPoints
    
    
    /**
     * @return the priority
     */
    public int getPriority()
        {
        return this.priority;
        
        } // end getPriority
    
    
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
        System.out.printf( "%-5s %-8s %-8s %-15s %-15s %-6s   %-10s   %-10s %-15s%n", 
                            "#",
                            "Rank",
                            "Graphic",
                            "Name",
                            "Display Name",
                            "Points",
                            "Alt Points",
                            "Priority",
                            "Alt Priority");
        
        // display each element of the enumeration
        for ( Rank aRank : Rank.values() )
            {
            System.out.printf( "%-5d %-8s %-8s %-15s %-15s %-6d   %-10d   %-10d %-15d%n", 
                                aRank.ordinal(),
                                aRank,
                                aRank.graphic,
                                aRank.name(),
                                aRank.displayName,
                                aRank.points,
                                aRank.altPoints,
                                aRank.priority,
                                aRank.altPriority );
            }   // end for
        
        }   // end main()

    } // end enum Rank