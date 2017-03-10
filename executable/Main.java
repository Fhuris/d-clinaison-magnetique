package executable;

import donnees.Formule;
import objets.Point;

public class Main {

	public static void main(String[] args) {
		Point z=new Point(1,2);
		Formule V=new Formule(z);
		System.out.println(V.calcul());
	}

}
