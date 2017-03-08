package données;

import org.apache.commons.math3.analysis.polynomials.PolynomialsUtils;

import objets.Point;

public class Formule {
	final double R=3.986005*Math.pow(10,14);//m^3/s²
	final int r=6371000;//rayon de la Terre
	double p;//legendre
	double X;//coordonnées cartésiennes
	double Y;
	double Z;
	Point z;
	Lecture l;
	
	public Formule(Point z){
		this.z=z;
	}
	
	public double calcul(){
		double teta=z.getLat()*Math.PI/2;
		double V;
		double S=0;
		double s=0;
		for(int n=1;n<14;n++){//n -> degré
			p=PolynomialsUtils.createLegendrePolynomial(n).value(teta);//Legendre
			for(int m=0;m<n+1;m++)//m -> ordre
				s+=(l.getGv(n,m)*Math.cos(m*z.getLon())+l.getHv(n,m)*Math.sin(m*z.getLon()))*p;
			S+=s*Math.pow(R/r,n+1);
		}
		V=R*S;
		return V; //potentiel scalaire
		
		//Calculs des coordonnées cartésiennes
		double X = (1/r)*diff(V, teta);
		double Y = (1/(r*sin(teta)))*diff(V, 'z.getLon()*Math.PI/2');
		double Z = diff(V, r);
	}
}
// source :http://geomag.nrcan.gc.ca/mag_fld/magref-fr.php
