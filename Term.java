/* Class for representing an autocompletion term, 
 ie a query string & a weight. */

import java.util.Comparator;

public class Term //implements Comparator
{
	private String query;
	private int weight;

	// Initializes a term with the given query string and weight.
	public Term(String query, int weight)
	{ 
		try
		{
			if(query == null)
			{
				java.lang.NullPointerException nullString = new 
					java.lang.NullPointerException("String argument "
                                        + "(query) cannot be null."); 
				throw nullString;
			}
                        if(weight < 0)
                        {
                                java.lang.IllegalArgumentException negative =
                                        new java.lang.IllegalArgumentException("Numeric"
                                        + " argument (weight) cannot be negative.");
                                throw negative;

                        }
		} 

		catch(NullPointerException nullString)
		{
			System.out.println(nullString.getMessage());
			return;
		}
		catch(IllegalArgumentException negative)
		{
			System.out.println(negative.getMessage());
			return;
		}
		

		this.query = query;
		this.weight = weight;		
	}
	public String getQuery()
	{
		return this.query;
	}
	public int getWeight()
	{
		return this.weight;
	}
/*
	// Compares the two terms in lexicographic order by query.
	public static Comparator<Term> byLexicographicOrder() {}

	// Compares the two terms in descending order by weight.
	public static Comparator<Term> byReverseWeightOrder() {}

	// Compares the two terms in lexicographic order,
	// but using only the first k characters of each query.
	public static Comparator<Term> byPrefixOrder(int k) {}    */

	// Returns a string representation of this term in the following format:
	// the weight, followed by whitespace, followed by the query.
	public String toString()
	{
		return String.format("%12d    %s", this.weight, this. query);
	}

}
