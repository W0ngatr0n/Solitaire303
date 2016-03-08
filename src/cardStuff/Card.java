package cardStuff;



import java.util.Comparator;

import cardStuff.Card.Rank;

/**
 * Same as version 7. My last example.
 */
public class Card implements Comparable<Card>
{	
	/**
 	 * A card's rank.
	 */
	public enum Rank 
	{ ACE, TWO, THREE, FOUR, FIVE, SIX,
		SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
	}
	
	/**
	 * A card's suit.
	 */
	public enum Suit
	{
		CLUBS, DIAMONDS, SPADES, HEARTS
	}
	
	public static final String[] RANKS = {"Ace", "Two", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	
	public static final String[] SUITS = {"Clubs", "Diamonds", "Spades", "Hearts"};
	
	private Rank aRank; // Invariant: != null
	private Suit aSuit; // Invariant: != null
	
	/**
	 * @param pRank The index of the rank in RANKS
	 * @param pSuit The index of the suit in SUITS
	 * @pre pRank != null && pSuit != null
	 */
	public Card(Rank pRank, Suit pSuit)
	{
		assert pRank != null && pSuit != null;
		aRank = pRank;
		aSuit = pSuit;
	}
	
	public Card( Card pCard )
	{
		aRank = pCard.aRank;
		aSuit = pCard.aSuit;
	}
	
	/**
	 * @return The index in RANKS corresponding to the rank of the card.
	 * @post return != null
	 */
	public Rank getRank()
	{
		return aRank;
	}
	
	/**
	 * @return The index in SUITS corresponding to the suit of the card.
	 * @post return != null
	 */
	public Suit getSuit()
	{
		return aSuit;
	}
	
	/**
	 * Assigns a new suit to the card.
	 * @param pSuit The new suit.
	 * @pre pSuit != null
	 */
	public void setSuit(Suit pSuit)
	{
		aSuit = pSuit;
	}
	
	@Override
	public String toString()
	{
		return aRank + " of " + aSuit;
	}

	@Override
	public int compareTo(Card pCard)
	{
		return getRank().ordinal() - pCard.getRank().ordinal();
	}

	public static Comparator<Card> createByRankComparator()
	{
		return new Comparator<Card>(){

			@Override
			public int compare(Card o1, Card o2)
			{
				if( o1.getRank() == o2.getRank())
				{
					return createBySuitComparator().compare(o1, o2);
				}
				else
				{
					return o1.getRank().ordinal() - o2.getRank().ordinal();
				}
			}};
	}
	
	public static Comparator<Card> createBySuitComparator()
	{
		return new Comparator<Card>(){

			@Override
			public int compare(Card o1, Card o2)
			{
				return o1.getSuit().ordinal() - o2.getSuit().ordinal();
			}};
	}

}

class ByRankComparator2 implements Comparator<Card>
{

	@Override
	public int compare(Card o1, Card o2)
	{
		return o1.getRank().ordinal() - o2.getRank().ordinal();
	}}

/**
 * Not a good idea...
 */
class HackedComparator implements Comparator<Card>
{
	private Object aType;
	
	HackedComparator(Object pType) { aType = pType; }
	
	void setType(Object pType) { aType = pType; }

	@Override
	public int compare(Card o1, Card o2)
	{
		int number1 = 0;
		int number2 = 0;
		if( aType instanceof Rank )
		{ 
			number1 = o1.getRank().ordinal();
			number2 = o2.getRank().ordinal();
		}
		else 
		{
			number1 = o1.getSuit().ordinal();
			number2 = o2.getSuit().ordinal();
		}
		return number1 - number2;
	}
	
	
}