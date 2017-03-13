package declinaison;

import Jama.Matrix;

public class Translation {
	
	
	public static Vecteur getVecteur(Vecteur v, Point a){
	
		 double lon,lat;
		 Vecteur fin;
		 
		 lon= a.getLon();
		 lat= a.getLat();
		 
		 
		 Matrix m = new Matrix(new double[]{v.getx(),v.gety(),v.getz()}, 1);
		 double[][] t = {{-Math.sin(lon),Math.cos(lon),0},{-Math.sin(lat)*Math.cos(lon),-Math.sin(lat)*Math.sin(lon),Math.cos(lat)},{Math.cos(lat)*Math.cos(lon),Math.cos(lat)*Math.sin(lon),Math.sin(lon)}};
		 Matrix r = new Matrix(t);
		 Matrix f= m.times(r);
		 
		 /*
		 double[][] affiche = f.getArray();
		 for(int i = 0; i < affiche.length; i++) {
			    for(int j = 0; j < affiche[i].length; j++) {        
			        System.out.print( " " + affiche[i][j] );
			        }
		 }
		 */
			        fin = new Vecteur(f.getArray());
			        return fin;
		
		 
	
	
	}
	}
	