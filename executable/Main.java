package executable;

import donnees.Formule;
import objets.Point;

public class Main {

	public static void main(String[] args) {
		Point z=new Point(37,144,6371000);
		System.out.println(Formule.calcul(z)[0]+" "+Formule.calcul(z)[1]+" "+Formule.calcul(z)[2]);
		System.out.println(Math.atan(Formule.calcul(z)[1]/Formule.calcul(z)[0]));
	}

}
