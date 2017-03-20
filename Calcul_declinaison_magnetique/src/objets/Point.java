package objets;


public class Point {
	
	private double lat,lon,h;
	
	private final double A = 6378137;
	private final double f = 0.0033528106647475;
	private final double e = f*(2-f);	
		
	  public Point (double lat , double lon, double h) {
	    this.lat =lat;
	    this.lon =lon;
	    this.h = h;
	  }
	  
	  public double getZ(){
		  double Rc = A/(Math.sqrt(1-e*Math.pow(Math.sin(getLat()),2)));
		  return (Rc*(1-e)+h)*Math.sin(getLat());
	  }
	  
	  public double getR(){
		  double Rc = A/(Math.sqrt(1-e*Math.pow(Math.sin(getLat()),2)));
		  double p = (Rc + h)*Math.cos(getLat());
		  return Math.sqrt(Math.pow(p,2) + Math.pow(getZ(),2));
	  }
	  	  
	  public double getPHI() {//latitude géocentrique
		    return Math.asin(getZ()/getR());
		  }
	  
	  public double getLat() {
		    return lat*Math.PI/180;
		  }

		  public double getLon() {
		    return lon*Math.PI/180;
		  }
		  
		  public String toString() {
		    return "(" + lat + ";" + lon + ";" + h + ")";
		  }
}