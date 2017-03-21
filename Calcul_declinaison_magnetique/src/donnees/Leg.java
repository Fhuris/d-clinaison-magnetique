package donnees;

import org.opensourcephysics.numerics.specialfunctions.Legendre;


public class Leg {
	
	
	
	public static double norm(int n,int m,double phi){
		if (m==0){
			return Legendre.getAssociatedFunction(n, m).evaluate(phi);
		}else{
			return Math.sqrt(2*(factorial(n-m)/factorial(n+m)))*Legendre.getAssociatedFunction(n, m).evaluate(phi);	
		}
	}


	private static double factorial(int i) {
		double fact = 1; 
		for (int n = 2;n<=i; n++) {
			fact *= n;
		}
		return fact;
	}
}