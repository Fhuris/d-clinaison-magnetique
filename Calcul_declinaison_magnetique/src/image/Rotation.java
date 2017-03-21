package image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import donnees.Formule;
import javaxt.io.Image;
import objets.Point;

public class Rotation {

	public static void main(String[] args) throws IOException {
		String filename="NE1_HR_LC_SR_W.tif";
		String newfilename=filename.substring(0,filename.length()-3);
		double[] c= Coordonnees.coord(newfilename+"tfw");
		BufferedImage img=ImageIO.read(new File("test.jpg"));
		System.out.println(c[0]+" "+c[1]+" "+c[2]+" "+c[3]+" ");
		System.out.println(img);
		int h = img.getHeight();
		int w = img.getWidth();
		double X=c[2]+c[0]*w/2;
		double Y=c[3]+c[1]*h/2;
		
		Point p=new Point(X,Y,0);
		
		Image img2 = new Image(filename);
		img2.rotate(Formule.calcul(p));
		
		File fichier=new File(filename);
		String chemin = new String();
		chemin = fichier.getAbsolutePath();
		String[] r = chemin.trim().split("\\.");	
		
		img2.saveAs(r[0]+"_rot."+r[1]);
	}

}
