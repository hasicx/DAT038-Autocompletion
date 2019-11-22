/* Class for representing an autocompletion term, 
 ie a query string & a weight. */

import java.util.Comparator;

public class Term //implements Comparator
{
	private String query;
	private double weight;

	// Initializes a term with the given query string and weight.
	public Term(String query, double weight)
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
                                java.lang.IllegalArgumentException negativeWeight =
                                        new java.lang.IllegalArgumentException("Numeric"
                                        + " argument (weight) cannot be negative.");
                                throw negativeWeight;

                        }
		} 

		catch(NullPointerException nullString)
		{
			System.out.println(nullString.getMessage());
			return;
		}
		catch(IllegalArgumentException negativeWeight)
		{
			System.out.println(negativeWeight.getMessage());
			return;
		}

		this.query = query;
		this.weight = weight;
	}
	public String getQuery()
	{
		return this.query;
	}
	public double getWeight()
	{
		return this.weight;
	}

	// Compares the two terms in lexicographic order by query.
	public static Comparator<Term> byLexicographicOrder()
	{
		Comparator<Term> comp = new byLexicographicOrder();
		return comp;
	}


	// Compares the two terms in descending order by weight.
	public static Comparator<Term> byReverseWeightOrder()
	{
		Comparator<Term> comp = new byReverseWeightOrder();
		return comp;
	}




	// Compares the two terms in lexicographic order,
	// but using only the first k characters of each query.
/*
	public static Comparator<Term> byPrefixOrder(int k)
	{
		try
                {
                        if(k < 0)
                        {
                                java.lang.IllegalArgumentException negativeArg =
                                        new java.lang.IllegalArgumentException("Numeric"
                                        + " argument (weight) cannot be negative.");
                                throw negativeArg;
                        }
                }

                catch(IllegalArgumentException negativeArg)
                {
                        System.out.println(negativeArg.getMessage());
                        return;
                }
	} */

	// Returns a string representation of this term in the following format:
	// the weight, followed by whitespace, followed by the query.
	public String toString()
	{
		return String.format("%12d    %s", this.weight, this. query);
	}

	private static class byLexicographicOrder implements Comparator<Term>
	{
		public int compare(Term t1, Term t2)
		{
			return t1.getQuery().compareTo(t2.getQuery());
		}
	}

	private static class byReverseWeightOrder implements Comparator<Term>
	{
		public int compare(Term t1, Term t2)
		{
			Double dbl1 = t1.getWeight();
			Double dbl2 = t2.getWeight();

			return -dbl1.compareTo(dbl2);
		}
	}

}

