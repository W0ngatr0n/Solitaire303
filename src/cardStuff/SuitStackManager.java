package cardStuff;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import cardStuff.Card.Suit;

public class SuitStackManager 
{
	List<Stack<Card>> suitStacks = new ArrayList<Stack<Card>>(Suit.values().length);
	public SuitStackManager()
	{
	}
	public boolean canMoveTo(Card c, Suit suit)
	{
		boolean validMove = false;
		if (c.getSuit() == suit)
		{
			if(c.getRank().ordinal() == suitStacks.get(suit.ordinal()).peek().getRank().ordinal()+1)
			{
				validMove = true;
				return validMove;				
			}
			else if(suitStacks.get(suit.ordinal()).isEmpty() && c.getRank().ordinal()==0)
			{
				validMove = true;
				return validMove;
			}
		}
		return validMove;
	}
	public void moveTo (Card c, Suit suit)
	{
		if(canMoveTo(c, suit))
		{
			suitStacks.get(suit.ordinal()).push(c);
		}
	}
	public Card remove (Suit suit)
	{
		if(!suitStacks.get(suit.ordinal()).isEmpty())
		{
			return suitStacks.get(suit.ordinal()).pop();
		}
		return null;
	}
}
