package objets;

public class Point {
	
	private double lat,lon;
	
	
	  public Point (double lon , double lat) {
	    this.lat =lat;
	    this.lon =lon;
	   	  }
	  
	  public double getLat() {
		    return lat*Math.PI/180;
		  }

		  public double getLon() {
		    return lon*Math.PI/180;
		  }

		  public String toString() {
		    return "(" + lat + ";" + lon + ")";
		  }


}
