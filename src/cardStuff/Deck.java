package cardStuff;


import java.util.Collections;
/*import java.util.Comparator;*/
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import cardStuff.Card.Rank;
import cardStuff.Card.Suit;

/**
 * An iterable implementation of cards.
 */
public class Deck implements Iterable<Card>
{
	private final Stack<Card> aCards = new Stack<>();
	
/*	public static void main(String[] args)
	{
		Deck deck = new Deck();
		deck.shuffle();
		deck.sort();
		for( Card card : deck )
		{
			System.out.println(card);
		}
	}*/
	
	public Deck()
	{
		
	}
	
	public void sort()
	{
		Collections.sort(aCards, Card.createByRankComparator());
	}
	
	public List<Card> getCards()
	{
		return Collections.unmodifiableList(aCards);
	}
	
	public Deck( Deck pDeck )
	{
		for( Card card : pDeck.aCards )
		{
			aCards.add(new Card(card));
		}
	}
	
	public void shuffle()
	{
		aCards.clear();
		for( Suit suit : Suit.values() )
		{
			for( Rank rank : Rank.values())
			{
				aCards.push(new Card(rank, suit));
			}
		}
		Collections.shuffle(aCards);
	}
	
	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}
	
	public Card draw()
	{
		return aCards.pop();
	}

	@Override
	public Iterator<Card> iterator()
	{
		return aCards.iterator();
	}
}