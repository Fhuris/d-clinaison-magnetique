package declinaison;


public class Point {
	
	private double lat,lon,alt;
	
		
	  public Point (double lon , double lat, double alt) {
	    this.lat =lat;
	    this.lon =lon;
	    this.alt = alt;
	   	  }
	  
	  public double getLat() {
		    return lat*Math.PI/180;
		  }

		  public double getLon() {
		    return lon*Math.PI/180;
		  }
		  public double getAlt() {
			    return alt;
		  }
		  public String toString() {
		    return "(" + lat + ";" + lon + ";" + alt + ")";
		  }


}