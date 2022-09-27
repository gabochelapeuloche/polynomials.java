package td;

import java.util.ArrayList;
import java.util.Arrays; 

/**
 * @author fedou
 *
 */
public class td_imperatif {
	
	/* Fonction qui affiche une mention relativement à une note moyenne */
	public static String mention(double mean)
	{
		if (mean < 0 || mean > 20) return "note impossible";
		if (mean < 10) return "non-passable";
		if (mean >= 18) return "félicitation-du-jury";
		if (mean >= 16) return "très-bien";
		if (mean >= 14) return "bien";
		if (mean >= 12) return "assez-bien";
		else return "passable";
	}
	
	/* Fonction qui retourne la catégorie dans laquelle un joueur évolue en 
	 * fonction de son année de naissance*/
	public static String ecoleRugby(int anneeNaissance)
	{
		switch (anneeNaissance)
		{
			case 2008, 2009 : return "Minime";
			case 2010, 2011 : return "Benjamin";
			case 2012, 2013 : return "Poussin";
			case 2014, 2015 : return "Mini poussin";
			case 2016, 2017 : return "Pépinère";
			case 2018, 2019 : return "Baby";
			default : return "categorie inconnue";
		}
	}
	
	/* Fonction qui retourne la liste des nombres premiers inférieurs à une limite */
	public static String primeNumbers(int limite)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		boolean isPrime = true;
		
		for (int i = 2; i <= limite; i++)
		{
			isPrime = true;
			int j = 2;
			
			while (isPrime && j < i-1)
			{
				isPrime = !(i % j == 0);
				j ++;
			}
			if (isPrime) result.add(i);
		}
		return result.toString();
	}
	
	/* Fonction qui retourne la liste des nombres parfaits inférieurs à une limite */
	public static String perfectNumbers(int upperBound)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		int dividerSum;
		
		for(int i = 0; i <= upperBound; i ++)
		{
			dividerSum = 0;
			for (int j = 1; j <= i; j ++)
			{
				if (i % j == 0) dividerSum += j;
			}
			if (i == dividerSum/2) result.add(i);
		}
		
		return result.toString();
	}
	
	/* Fonction qui initie une tableau avec des valeurs aléatoires comprises entre 0 
	 * et 100 et les ordonnes */
	public static String initArrThenOrderArr(int arrLength)
	{
		int[] arrSlc = new int[arrLength];
		int random;
		
		for (int i = 0; i < arrLength; i++)
		{
			random = 0 + (int)(Math.random() * ((100 - 0) + 1));
			int j = 0;
			while (random <= arrSlc[j] && j != i) j += 1;
			
			if (j == i) 
			{
				arrSlc[j] = random;
			}
			else 
			{
				for (int k = i; k > j; k--)
				{
					arrSlc[k] = arrSlc[k-1];
				}
				arrSlc[j] = random;
			}
		}
		return Arrays.toString(arrSlc);
	}
	
	/* Fonction qui compare deux mots afin de déterminer s'ils sont anagrames */
	public static boolean anagrams (String strOne, String strTwo)
	{
		String[] arrOne = strOne.toLowerCase().split("");
		String[] arrTwo = strTwo.toLowerCase().split("");
		
		Arrays.sort(arrOne);
		Arrays.sort(arrTwo);
		
		return Arrays.equals(arrOne, arrTwo);
	}
	
	/* Fonction récursive permettant de trouver le PGCD de deux nombres */
	public static int pgcdFinder(int a, int b)
	{
		if (a == b)
		{
			return a;
		}
		if (a > b)
		{
			return pgcdFinder(a-b,b);
		}
		else
		{
			return pgcdFinder(a,b-a);
		}
	}
	
	/* Fonction permettant de multiplier un nombre par 4 en appliquant 
	 * la méthode de Trachtenberg */
	public static int trachtenbergsWay(int a)
	{
		String[] strNumber = String.valueOf(a).split("");
		int[] arrNumber = new int[strNumber.length];
		int[] arrSlc = new int[strNumber.length + 1];
		int slc = 0;
		
		
		for (int i = 0; i < arrNumber.length; i ++)
		{
			arrNumber[i] = Integer.valueOf(strNumber[i]);
		}

		
		if (arrNumber[arrNumber.length - 1] % 2 == 0)
			arrSlc[arrNumber.length] = 10 - arrNumber[arrNumber.length - 1];
		else
			arrSlc[arrNumber.length] = 15 - arrNumber[arrNumber.length - 1];
		for (int i = arrNumber.length - 2; i >= 0; i--)
		{
			if (arrNumber[i] % 2 == 0)
				arrSlc[i+1] = 9 - arrNumber[i] + arrNumber[i+1]/2;
			else 
				arrSlc[i+1] = 9 - arrNumber[i] + arrNumber[i+1]/2 + 5;
		}
		arrSlc[0] = arrNumber[0]/2 - 1;

		
		for (int i = 0; i < arrSlc.length; i++)
		{
			slc += arrSlc[arrSlc.length - 1 - i] * Math.pow(10, i);
		}
		
		return (a * 4 == slc) ? slc : 0;
	}
}