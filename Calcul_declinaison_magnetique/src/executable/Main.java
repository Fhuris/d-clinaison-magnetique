package executable;

import donnees.Formule;
import objets.GeomagneticField;
import objets.Point;

public class Main {

	public static void main(String[] args) {
		Point Paris=new Point(48.85341,2.34880,85.806); // D=0.501
		System.out.println(Formule.calcul(Paris));
		
//		Point z=new Point (50,50,0);
//		System.out.println(Formule.calcul(z));
		
		GeomagneticField n=new GeomagneticField(48.85,2.35,42,1.482*Math.pow(10,12));
		System.out.println(n.getDeclination());
	}

}
