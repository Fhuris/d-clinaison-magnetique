package executable;

import donnees.Formule;
import objets.Point;

public class Main {

	public static void main(String[] args) {
		Point Paris=new Point(48.85341,2.34880,85.806); // D=0.501
		System.out.println(Formule.calcul(Paris));
		
//		Point z=new Point (-30,37,500);
//		System.out.println(Formule.calcul(z));
	}

}
