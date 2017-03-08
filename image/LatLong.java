package image; // A VERIFIER
// A EXPLORER : http://stackoverflow.com/questions/4634053/using-the-gps-locationmanager-how-to-get-the-current-time
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;

public class LatLong {	//conversion des coordonnées géographiques en pixel

        private  int  imageW,  imageH;
        //coordonnées récupérées par GPS
        private final static   double   west = -180,      north = 90,
                                        east = 180,      south = -90;

        public LatLong (int w, int h) {
                imageW = w;
                imageH = h;
        }

        public List<Point2D> convertLatLongToCoord (List<Point2D> coordinate) {
            List<Point2D> latLong = new ArrayList<Point2D>();
            for (Point2D coord : coordinate) {
                double  x = coord.getY(),       px = imageW * (x-east) / (west-east),
                        y = coord.getX(),       py = imageH * (y-north)/(south-north);
                latLong.add (new Point2D.Double(px,py));
            }
            return latLong;
        }

        public static void main (String[] args) {
                double[] latit = {39.64581, 39.64651, 39.646915, 39.646538, 39.646458},
                        longit = {-79.97168, -79.97275, -79.97342, -79.97279, -79.97264};

                List<Point2D> pointList = new ArrayList<Point2D>();
                for (int i = 0 ; i < latit.length ; i++)
                        pointList.add (new Point2D.Double(latit[i], longit[i]));
                
                List<Point2D> pixels = new LatLong (1024,768).convertLatLongToCoord (pointList);

                for (int i = 0 ; i < latit.length ; i++)
                        System.out.println ("[" + (i+1) + "]\t(" + latit[i] + "," + longit[i] + ") -> " +
                                (int) (pixels.get(i).getX()) + "," + (int) (pixels.get(i).getY()));
        }
}// source :  http://stackoverflow.com/questions/24874693/conversion-of-latitude-longtitude-into-image-coordinates-pixel-coordinates-on
