package donnees;

import objets.Point;

public class Formule {
	public static double calcul(Point p){
		final double R=3.986005*Math.pow(10,14);//m^3/s²
		
		double X=0;
		double Y=0;
		double Z=0;
		double x, y, z;
		for(int n=1;n<13;n++){//n -> degre			
			x=0;
			y=0;
			z=0;
			for(int m=0;m<n+1;m++){//m -> ordre
				
				x+=(Lecture.getGv(n, m)*Math.cos(m*p.getLon())+Lecture.getHv(n, m)*Math.sin(m*p.getLon()))*(n+1)*Math.tan(p.getPHI())*Leg.norm(n,m,Math.sin(p.getPHI()))-Math.sqrt(Math.pow(n+1, 2)-Math.pow(m, 2))*1/Math.cos(p.getPHI())*Leg.norm(n+1,m,p.getPHI());
				y+=m*(Lecture.getGv(n, m)*Math.sin(m*p.getLon())-Lecture.getHv(n, m)*Math.cos(m*p.getLon()))*Leg.norm(n,m,Math.sin(p.getPHI()));
			    z+=(Lecture.getGv(n, m)*Math.cos(m*p.getLon())+Lecture.getHv(n, m)*Math.sin(m*p.getLon()))*Leg.norm(n,m,Math.sin(p.getPHI()));
			}
			X+=x*Math.pow(R/p.getR(),n+2);
			Y+=y*Math.pow(R/p.getR(),n+2);
			Z+=z*(n+1)*Math.pow(R/p.getR(),n+2);
		}
		
		X*=-1;
		Y/=Math.cos(p.getPHI());
		Z*=-1;
		
		X*=(Math.cos(p.getPHI()-p.getLat()))-Z*(Math.sin(p.getPHI()-p.getLat()));
//		Z=X*(Math.sin(p.getPHI()-p.getLat()))-Z*(Math.cos(p.getPHI()-p.getLat()));
		return 2*Math.atan(Y/(Math.sqrt(Math.pow(X,2)+Math.pow(Y,2))+X));
	}

}