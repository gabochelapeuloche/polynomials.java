package app;

import java.util.Arrays;
import td.td_imperatif;
import td_objets.Polynomial;

/**
 * @author fedou
 *
 */
public class app {
	
	/* Tests td programmation imp�rative */
	
	public static void testTdImperatif()
	{
		// Mentions
		System.out.println("Test de la fonction permettant de d�terminer "
				+ "la mention qu'� obtenu un �tudiant en fonction de sa note,");
		double note = 14.9;
		System.out.println("Pour la note : " + note + "\n"
				+ "l'�tudiant obtient la mention : " + td_imperatif.mention(14.9));
		
		System.out.println();
		
		// Ecole du rugby
		System.out.println("Test de la fonction permettant de d�termminer"
				+ " � quelle cat�gorie d'age correspond une ann�e de naissance,");
		int year = 2011;
		System.out.println("Pour l'ann�e : " + year + "\n"
				+ "on est dans la cat� : " + td_imperatif.ecoleRugby(2011));
		
		System.out.println();
		
		// Nombres premiers
		System.out.println("Test de la fonction permettant de d�terminer"
				+ "les nombre premiers jusqu'� une limite,");
		int limit = 500;
		System.out.println("Liste des nombres premiers jusqu'� " + limit + ",\n"
				+ td_imperatif.primeNumbers(limit));
		
		System.out.println();
		
		// Nombres parfaits
		System.out.println("Test de la fonction permettant de d�terminer"
				+ "les nombre parfaits jusqu'� une limite,");
		limit = 500;
		System.out.println("Liste des nombres parfaits jusqu'� : " + limit
				+ td_imperatif.perfectNumbers(limit));
		
		System.out.println();
		
		// Tableau aleatoire trie
		System.out.println("Test de la fonction permettant de cr�er un tableau"
				+ "de nombres al�atoires et de les trier,");
		limit = 100;
		System.out.println("Tableau de 100 nombres "
				+ td_imperatif.initArrThenOrderArr(limit));
		
		System.out.println();
		
		// Anagrames
		System.out.println("Test de la fonction permettant de comparer"
				+ "deux chaines de caract�res afin de d�terminer si elles sont anagrames,");
		String anagramOne = "OIUUoi";
		String anagramTwo = "Ouioui";
		System.out.println(anagramOne + " anagrame de  " + anagramTwo + " -> " + td_imperatif.anagrams(anagramOne, anagramTwo));
		anagramTwo = "zodjozdjio";
		System.out.println(anagramOne + " anagrame de " + anagramTwo + " -> " +td_imperatif.anagrams(anagramOne, anagramTwo));
		anagramOne = "parisien";
		anagramTwo = "aspirine";
		System.out.println(anagramOne + " anagrame de " + anagramTwo + " -> " + td_imperatif.anagrams(anagramOne, anagramTwo));
		
		System.out.println();
		
		// PGCD
		System.out.println("Test de la fonction permettant de trouver le PGCD de deux nombres,");
		int nbOne = 10;
		int nbTwo = 5;
		System.out.println("le PGCD de " + nbOne 
				+ " et " + nbTwo + " est " 
				+ td_imperatif.pgcdFinder(nbOne, nbTwo));
		nbOne = 34;
		nbTwo = 39;
		System.out.println("le PGCD de " + nbOne 
				+ " et " + nbTwo + " est " 
				+ td_imperatif.pgcdFinder(nbOne, nbTwo));
		nbTwo = 2;
		System.out.println("le PGCD de " + nbOne 
				+ " et " + nbTwo + " est " 
				+ td_imperatif.pgcdFinder(nbOne, nbTwo));
		
		System.out.println();
		
		// Trachtenberg * 4
		System.out.println("Test de la fonction permettant de multiplier un nombre "
				+ "par 4 avec la m�thode de Trachtenberg,");
		int nbTracht = 5314;
		System.out.println(nbTracht + " * 4" + " = " + td_imperatif.trachtenbergsWay(nbTracht));
		nbTracht = 4;
		System.out.println(nbTracht + " * 4" + " = " + td_imperatif.trachtenbergsWay(nbTracht));
		nbTracht = 1;
		System.out.println(nbTracht + " * 4" + " = " + td_imperatif.trachtenbergsWay(nbTracht));
		nbTracht = 53;
		System.out.println(nbTracht + " * 4" + " = " + td_imperatif.trachtenbergsWay(nbTracht));
	}
	
	/* Test TD Objets, les polynomes */
	public static void testPolynomial()
	{
		// Test D�claration et Instentiation de polynomes avec les diff�rents 
		//constructeurs et setters d�velopp�s
		
		System.out.println("On cr�� le polynome p : ");
		Polynomial p = new Polynomial(10);
		System.out.println("tableau des coefficients : " + Arrays.toString(p.getAllCoeffs()));
		System.out.println("degr� du polynome : " + p.getDeg());
		System.out.println("p(x) = " + p.getExpression());
		
		System.out.println();
		
		System.out.println("On set notre premier coefficient : ");
		p.setCoeff(2, 2.02);
		System.out.println("tableau des coefficients : " + Arrays.toString(p.getAllCoeffs()));
		System.out.println("p(x) = " + p.getExpression());
		
		System.out.println();
		
		System.out.println("On set les autres coefficients");
		p.setCoeff(4, 1);
		p.setCoeff(0, 4);
		System.out.println("tableau des coefficients : " + Arrays.toString(p.getAllCoeffs()));
		System.out.println("p(x) = " + p.getExpression());
		
		System.out.println();
		
		System.out.println("La taille du tableau et le degr� ne correspondent plus � "
				+ "notre polynome,\non appelle la fonction correctDeg() pour y rem�dier");
		p.correctDeg();
		System.out.println("tableau des coefficient re-siz� : " + Arrays.toString(p.getAllCoeffs()));
		System.out.println("nouveau degr� : " + p.getDeg());
		System.out.println("p(x) = " + p.getExpression());
		
		System.out.println();
		
		//p.correctDeg();
		
		Polynomial pPrime = p.derivative();
		System.out.println("d�riv�es du polynome p :");
		System.out.println("p(x) = " + p.getExpression());
		System.out.println("p'(x) = " + pPrime.getExpression());
		Polynomial pSec = pPrime.derivative();
		System.out.println("p''(x) = " + pSec.getExpression());
		Polynomial pThird = pSec.derivative();
		System.out.println("p'''(x) = " + pThird.getExpression());
		Polynomial pFourth = pThird.derivative();
		System.out.println("p''''(x) = " + pFourth.getExpression());
		Polynomial pFifth = pFourth.derivative();
		System.out.println("p'''''(x) = " + pFifth.getExpression());
		
		System.out.println();
		
		Polynomial pTwo = p.sum(pPrime);
		System.out.println("somme de p et p' : ");
		System.out.println(p.getExpression());
		System.out.println("+ " + pPrime.getExpression());
		System.out.println("= " + pTwo.getExpression()); 
		
		System.out.println();
		
		Polynomial pNew = p;
		pNew.sumToThis(pPrime);
		System.out.println("somme (sur l'objet lui-m�me : \"this.\") de pNew = p et p' : ");
		System.out.println(p.getExpression());
		System.out.println("+ " + pPrime.getExpression());
		System.out.println("= " + pNew.getExpression()); 
		
		System.out.println();
		
		System.out.println("Maintenant, on cherche les images de x :");
		System.out.println("p -> " + p.printedResolve(10));
		System.out.println("p -> " + p.printedResolve(2));
		System.out.println("somme de p et p' -> " + pTwo.printedResolve(10));
		System.out.println("somme de p et p' -> " + pTwo.printedResolve(-2));
		
		System.out.println();
		
		System.out.println("Les deux m�thodes donnes-t-elles le m�me r�sultat ? "
				+ "On v�rifie avec la m�thode equals :");
		System.out.println(pNew.equals(pTwo));
		
		System.out.println();
		
		System.out.println("On cherche maintenant l'ensemble des racines :");
		double[] tab = {-2, 2};
		p.setAllCoeffs(tab);
		System.out.println("expression du polynome p : " + p.getExpression());
		p.correctDeg();
		System.out.println("racines de p : " + p.printRacinesEnti�resIntervalle(-100, 100));
		System.out.println(p.printedResolve(1));
		double[] tabA = {2, 0, -2};
		Polynomial polyA = new Polynomial(tabA);
		System.out.println("expression du polynome polyA : " + polyA.getExpression());
		System.out.println("racines de polyA : " + polyA.printRacinesEnti�resIntervalle(-100, 100));
		System.out.println(polyA.printedResolve(1));
		System.out.println(polyA.printedResolve(-1));
		
		System.out.println();
		
		System.out.println("test de d�claration de polynomes par l'expression :");
		String expression = "3 + 3 * x + 4 * x ^ 2";
		System.out.println("a(x) = " + expression);
		Polynomial a = new Polynomial(expression);
		System.out.println(a.getExpression());
		expression = "2 + 3 * x + 4 * x ^ 4";
		System.out.println("b(x) = " + expression);
		Polynomial b = new Polynomial(expression);
		System.out.println(b.getExpression());
		expression = "3*x+4x7";
		System.out.println("b(x) = " + expression);
		Polynomial c = new Polynomial(expression);
		System.out.println(c.getExpression());
		
		System.out.println();
		
		System.out.println("Test du produit de deux polynomes");
		System.out.println("p'(x) = " + pPrime.getExpression());
		System.out.println("pNew(x) = " + pNew.getExpression());
		pNew = pNew.product(pPrime);
		System.out.println("pNew(x) * p'(x) = " + pNew.getExpression());
	}
	
	/* Test TD objets geometrie */
	public static void testGeometrics()
	{
		
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		
		//----------- td_imperatif tests: 
		
//		System.out.println("\n\n----------- td_imperatif tests:\n\n");
//		testTdImperatif();
		
		//----------- Polynoms tests: 
		
		System.out.println("\n\n----------- Polynomials tests:\n\n");
		testPolynomial();
		
		//----------- Geometrics tests: 

		

	}

}
