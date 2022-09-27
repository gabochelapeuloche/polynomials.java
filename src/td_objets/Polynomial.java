/**
 * 
 */
package td_objets;

import java.util.Arrays;

/**
 * @author fedou
 *
 */
public class Polynomial {
	
	// Propertys
	
	private int deg;
	private double[] coeffs = new double[deg + 1];
	
	// Constructor
	
	public Polynomial(int deg)
	{
		this.deg = deg;
		this.coeffs = new double[deg + 1];
	}
	
	public Polynomial(double[] coefficients)
	{
		this.deg = coefficients.length - 1;
		this.coeffs = coefficients;
	}
	
	public Polynomial(String expression)
	{
		String handler = expression;
		handler = handler.trim().replace(" ", "").replace("x+", "x1+")
				.replace("*", "").replace("^", "").replace("-", "+-");
		String[] arrHandDimOne = handler.split("\\+");
		String[][] arrHandDimTwo = new String[arrHandDimOne.length][2];
		
		for (int i = 0; i < arrHandDimTwo.length; i++)
		{
			arrHandDimTwo[i] = arrHandDimOne[i].split("x");
		}
		
		double[] arrSoluce = new double[Integer.valueOf(arrHandDimTwo[arrHandDimTwo.length - 1][1]) + 1];
		if (arrHandDimTwo[0].length == 1) arrSoluce[0] = Integer.valueOf(arrHandDimTwo[0][0]);
		else arrSoluce[Integer.valueOf(arrHandDimTwo[0][1])] = Integer.valueOf(arrHandDimTwo[0][1]);
		
		for (int i = 1; i < arrSoluce.length; i++)
		{
			for (int j = 1; j < arrHandDimTwo.length; j++)
			{
				if (Integer.valueOf(arrHandDimTwo[j][1]) == i)
				{
					arrSoluce[i] = Integer.valueOf(arrHandDimTwo[j][0]);
				}
			}
		}
		this.coeffs = (arrSoluce);
		this.deg = arrSoluce.length - 1;
	}
	
	// Getters Setters
	
	// Getters
	
	public int getDeg()
	{
		return this.deg;
	}
	
	public double getCoeff(int deg)
	{
		return this.coeffs[deg];
	}
	
	public double[] getAllCoeffs()
	{
		return this.coeffs;
	}
	
	public String getExpression()
	{
		String expression = " ";

		
		for (int i=0; i < this.coeffs.length; i++)
		{
			if (coeffs[i] != 0)
			{
				if (i == 0) expression += coeffs[i] + " ";
				else if (i == 1) expression += coeffs[i] + "*x" + " ";
				else expression += coeffs[i] + "*x^" + i + " ";
			}
		}
		
		return (expression == " ") ? "0": expression.trim()
													.replace(" ", " + ")
													.replace("*", " * ")
													.replaceAll("1.\\d* \\* ", "");
	}
	
	// Setters
	
	public void setDeg(int deg)
	{
		this.deg = deg;
	}
	
	public void setCoeff(int degCoeff, double coeff)
	{
		this.coeffs[degCoeff] = coeff;
	}
	
	public void setAllCoeffs(double[] coefficients)
	{
		this.coeffs = coefficients;
	}
	
	public void setAllCoeffs(String expression)
	{
		String handler = expression;
		handler
			.trim()
			.replace("x+", "x1+")
			.replace("*", "")
			.replace("^", "");
		System.out.println(handler);
		String[] arrHandDimOne = handler.trim().split("+");
		String[][] arrHandDimTwo = new String[arrHandDimOne.length][2];
		
		for (int i = 0; i < arrHandDimTwo.length; i++)
		{
			arrHandDimTwo[i] = arrHandDimOne[i].split("x");
		}
		
		double[] arrSoluce = new double[Integer.valueOf(arrHandDimTwo[arrHandDimTwo.length - 1][1])];
		
		for (int i = 0; i < arrSoluce.length; i++)
		{
			if (Integer.valueOf(arrHandDimTwo[i][1]) == i)
			{
				arrSoluce[i] = Integer.valueOf(arrHandDimTwo[i][0]);
			}
		}
		
		this.setAllCoeffs(arrSoluce);
	}
	
	// Methods
	
	// Methods exercice

	public Polynomial sum(Polynomial p)
	{
		double[] sum = new double[Math.max(p.getDeg(), this.getDeg())];
		
		if (p.getDeg() > this.getDeg()) sum = p.getAllCoeffs().clone();
		else sum = this.getAllCoeffs().clone();

		for (int i = 0; i < Math.min(p.getDeg(), this.getDeg()) + 1; i ++)
		{
			sum[i] = p.getCoeff(i) + this.getCoeff(i);
		}
		
		Polynomial pSum = new Polynomial(sum);
		return pSum;
	}
	
	public void sumToThis(Polynomial p)
	{
		double[] sum = new double[Math.max(p.getDeg(), this.getDeg())];
		
		if (p.getDeg() > this.getDeg()) sum = p.getAllCoeffs().clone();
		else sum = this.getAllCoeffs().clone();

		for (int i = 0; i < Math.min(p.getDeg(), this.getDeg()) + 1; i ++)
		{
			sum[i] = p.getCoeff(i) + this.getCoeff(i);
		}
		
		this.setAllCoeffs(sum);
	}
	
	public int[] racinesEntièresIntervalle(int upperBound, int lowerBound)
	{
		int[] racines = new int[this.getDeg() + 1];
		int counter = 0;
		
		for (int i = lowerBound; i <= upperBound; i++)
		{
			if (this.resolve(i) == 0)
			{
				racines[counter] = i;
				counter ++;
			}
		}
		
		return racines;
	}
	
	public String printRacinesEntièresIntervalle(int lowerBound, int upperBound)
	{
		String racines = "";
		int counter = 0;
		
		for (int i = lowerBound; i <= upperBound; i++)
		{
			if (this.resolve(i) == 0)
			{
				racines += i + ", ";
				counter ++;
			}
		}
		return (counter == 0) ? "ce polynome n'a pas de racines" : racines + "sont les racines de ce polynome";
	}
	
	// Methods Supp
	
	public void correctDeg()
	{
		int i = this.getAllCoeffs().length - 1;
		boolean isNull = true;
		while (i >= 0 && isNull)
		{
			if (this.getCoeff(i) == 0)
			{
				i --;
			}
			else 
			{
				this.setDeg(i);
				isNull = false;
			}
		}
		double[] correctArr = new double[this.getDeg() + 1];
		for (i = 0; i < this.getDeg() + 1; i ++)
		{
			correctArr[i] = this.getCoeff(i);
		}
		this.setAllCoeffs(correctArr);
	}
	
	public Polynomial product(Polynomial p)
	{
		double[] coeffsOne = new double[p.getDeg() + 1];
		double[] coeffsTwo = new double[this.getDeg() + 1];
		double[] coeffsProduct = new double[coeffsOne.length + coeffsTwo.length];
		
		coeffsOne = this.getAllCoeffs();
		coeffsTwo = p.getAllCoeffs();
		
		for (int i=0; i <= this.getDeg(); i ++)
		{
			for (int j=0; j <= p.getDeg(); j ++)
			{
				coeffsProduct[i + j] += coeffsOne[i] * coeffsTwo[j];
			}
		}
		
		Polynomial slc = new Polynomial(coeffsProduct);
		return slc;
	}
	
	public Polynomial derivative()
	{
		double[] derivative = new double[this.coeffs.length - 1];
		for (int i = 1; i < this.coeffs.length; i++)
		{
			if (this.coeffs[i] != 0)
			{
				derivative[i - 1] = this.coeffs[i] * i;
			}
		}
		Polynomial p = new Polynomial(derivative);
		return p;
	}
	
	public double resolve(double x)
	{
		double image = 0;
		for (int i = 0; i < this.getDeg() + 1; i++)
		{
			image += this.getCoeff(i) * Math.pow(x, i);
		}
		return image;
	}
	
	public String printedResolve(double x)
	{
		double image = this.resolve(x);
		return "p(" + x + ") = " + 
				this.getExpression().replace("x", String.valueOf(x)) +
				" = " + image;
	}
	
	public boolean equals(Polynomial p)
	{
		return (this.getDeg() == p.getDeg()) ? Arrays.equals(this.getAllCoeffs(), p.getAllCoeffs()) : false;
	}
}
