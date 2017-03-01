public class Points {
	
	private double lat,lon;
	
	
	  public Points (double lat , double lon) {
	    this.lat =lat;
	    this.lon =lon;
	   	  }
	  
	  public double getlat() {
		    return lat;
		  }

		  public double getlon() {
		    return lon;
		  }

		  public String toString() {
		    return "(" + lat + ";" + lon + ")";
		  }


}
