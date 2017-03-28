package executable;

import java.util.Scanner;

import donnees.Formule;
//import objets.GeomagneticField;
import objets.Point;

public class Calcul {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Entrez la latitude de votre point");
		double lambda=input.nextDouble();
		System.out.println("Entrez la longitude de votre point");
		double phi=input.nextDouble();
		System.out.println("Entrez la hauteur �llispo�dale de votre point");
		double h=input.nextDouble();
		input.close();
		Point z=new Point (lambda,phi,h);
		System.out.println(Formule.calcul(z));
		
//		Point Paris=new Point(48.85341,2.34880,85.806); // D=0.501
//		System.out.println(Formule.calcul(Paris));
/*		GeomagneticField n=new GeomagneticField(48.85341,2.34880,42,1.482*Math.pow(10,12));
		System.out.println(n.getDeclination());*/
	}

}
