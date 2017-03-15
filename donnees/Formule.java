package donnees;

import org.opensourcephysics.numerics.specialfunctions.Legendre;

import objets.Point;

public class Formule {
	
	
	
	public static double[] calcul(Point p){
		final double R=3.986005*Math.pow(10,8);//km^3/s²
		final double rayon=6371200;
		double X=0;// coordonnées du champ magnetique
		double Y=0;
		double Z=0;
		double x, y;
		double[] tab = new double[3];
		
		double teta=p.getLat()*Math.PI/2;
		for(int n=1;n<14;n++){//n -> degree
			x=0;
			y=0;
			for(int m=0;m<n+1;m++){//m -> ordre
//				s+=(Lecture.getGv(n,m)*Math.cos(m*z.getLon())+Lecture.getHv(n,m)*Math.sin(m*z.getLon()))*Legendre.getAssociatedFunction(n, m).evaluate(teta);
				x += (-Lecture.getGv(n, m)*Math.sin(m*p.getLon())+Lecture.getHv(n, m)*m*Math.cos(m*p.getLon())*Legendre.getAssociatedFunction(n, m).evaluate(teta));
				if(n-1==0)
					y += (Lecture.getGv(n,m)*Math.cos(m*p.getLon())+Lecture.getHv(n,m)*Math.sin(m*p.getLon()))*1/(1-Math.pow(teta, 2))*(n+1)*1*n*teta*Legendre.getAssociatedFunction(n, m).evaluate(teta);
				else
					y += (Lecture.getGv(n,m)*Math.cos(m*p.getLon())+Lecture.getHv(n,m)*Math.sin(m*p.getLon()))*1/(1-Math.pow(teta, 2))*(n+1)*Legendre.getAssociatedFunction(n-1, m-1).evaluate(teta)*n*teta*Legendre.getAssociatedFunction(n, m).evaluate(teta);
			}
//			S+=s*Math.pow(R/rayon,n+1);	
			X+=x*Math.pow(R/rayon,n+1);
			Y+=y*Math.pow(R/rayon,n+1);
			Z+=(n+1)*Math.pow(-2*rayon*R/Math.pow(rayon,2), n);
		}
		tab[0]=R/rayon*X;
		tab[1]=R/(rayon*Math.sin(teta))*Y;
		tab[2]=R*Z;
		return tab; //potentiel scalaire
		
		//Calculs des coordonnees champs magnetique
		//double X = (1/rayon)*diff(V, teta);
		//double Y = (1/(rayon*Math.sin(teta)))*diff(V, z.getLon()*Math.PI/2);
		//double Z = diff(V, rayon);
	}
}
// source :http://geomag.nrcan.gc.ca/mag_fld/magref-fr.php
