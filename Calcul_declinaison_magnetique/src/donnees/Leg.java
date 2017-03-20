package donnees;

import org.opensourcephysics.numerics.specialfunctions.Legendre;


public class Leg {
	
	
	
	public static double norm(int n,int m,double phi){
		double Pn;
		
		if (m==0){
			Pn = Legendre.getAssociatedFunction(n, m).evaluate(phi);
		}else{
			Pn = Math.sqrt(2*(factorial(n-m)/factorial(n+m)))*Legendre.getAssociatedFunction(n, m).evaluate(phi);	
		}
		return Pn;
	}


	private static int factorial(int i) {
		int fact = 1; 
		for (int n = 1;n<i+1; n++) {
			fact *= n;
		}
		return fact;
	}
}