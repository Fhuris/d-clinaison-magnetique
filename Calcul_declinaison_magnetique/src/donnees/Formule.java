package donnees;

import objets.Point;

public class Formule {
	public static double calcul(Point p){
		final double R=3.986005*Math.pow(10,14);//m^3/s²
		
		double X=0;
		double Y=0;
		double Z=0;
		double x, y, z;
		double[][] g=Lecture.getG();
		double[][] h=Lecture.getH();
		double lon=p.getLon();
		double phi=p.getPHI();
		double r=p.getR();
		
		for(int n=1;n<13;n++){//n -> degree			
			x=0;
			y=0;
			z=0;
			for(int m=0;m<=n;m++){//m -> ordre				
				x+=(g[n][m]*Math.cos(m*lon)+h[n][m]*Math.sin(m*lon))*(n+1)*Math.tan(phi)*Leg.norm(n,m,Math.sin(phi))-Math.sqrt(Math.pow(n+1,2)-Math.pow(m,2))*1/Math.cos(phi)*Leg.norm(n+1,m,phi);
				y+=m*(g[n][m]*Math.sin(m*lon)-h[n][m]*Math.cos(m*lon))*Leg.norm(n,m,Math.sin(phi));
			    z+=(g[n][m]*Math.cos(m*lon)+h[n][m]*Math.sin(m*lon))*Leg.norm(n,m,Math.sin(phi));
			}
			X+=x*Math.pow(R/r,n+2);
			Y+=y*Math.pow(R/r,n+2);
			Z+=z*(n+1)*Math.pow(R/r,n+2);
		}
		
		X*=-1;
		Y/=Math.cos(phi);
		Z*=-1;
		
		X=X*(Math.cos(phi-p.getLat()))-Z*(Math.sin(phi-p.getLat()));
		Z=X*(Math.sin(phi-p.getLat()))-Z*(Math.cos(phi-p.getLat()));
			
		return Math.atan(Y/X);
//		return 2*Math.atan(Y/(Math.sqrt(Math.pow(X,2)+Math.pow(Y,2))+X));
	}

}