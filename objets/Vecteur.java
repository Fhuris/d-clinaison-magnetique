package declinaison;

public class Vecteur {
	
		
		private Point a;
		private double x,y,z;
		double Nlat=Math.PI/2;
		double Nlon=0;
		double Nalt=6356752.314140347;
		
		
		  public Vecteur (Point a) {
		    this.x = a.getLat()- Nlat;
		    this.y = a.getLon()- Nlon;
		    this.z = a.getAlt()- Nalt;
		    
		   	  }
		  
		  public Vecteur (double[][] a) {
			    this.x=a[0][0];
			    this.y=a[0][1];
			    this.z=a[0][2];
			   	  }
		  
		  public double getx() {
			    return x;
			  }

			  public double gety() {
			    return y;
			  }
			  
			  public double getz() {
				    return z;
				  }
			  
			  public double getNorme(){
			  return	Math.sqrt((this.x*this.x)+(this.y*this.y)+(this.z*this.z));		 
			  }

			  public String toString() {
			    return "(" + x + ";" + y +";" + z + ")";
			  }


	}


