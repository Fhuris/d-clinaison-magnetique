package image;

import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.io.IOException;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;

import com.sun.media.jai.codec.FileSeekableStream;
import com.sun.media.jai.codec.TIFFDecodeParam;

import donnees.Formule;
import javaxt.io.Image;
import objets.Point;

public class Rotation {

	public static void exe(String filename) throws IOException {
		String newfilename=filename.substring(0,filename.length()-3);
		double[] c= Coordonnees.coord(newfilename+"tfw");
		FileSeekableStream stream = new FileSeekableStream(filename);
		TIFFDecodeParam decodeParam = new TIFFDecodeParam();
		decodeParam.setDecodePaletteAsShorts(true);
		ParameterBlock params = new ParameterBlock();
		params.add(stream);
		RenderedOp image1 = JAI.create("tiff", params);
		BufferedImage img = image1.getAsBufferedImage();
		int h = img.getHeight();
		int w = img.getWidth();
		double X=c[2]+c[0]*w/2;
		double Y=c[3]+c[1]*h/2;
		
		Point p=new Point(X,Y,0);
		
		Image img2 = new Image(img);
		img2.rotate(-1*Formule.calcul(p));
		
		File fichier=new File(filename);
		String chemin = new String();
		chemin = fichier.getAbsolutePath();
		String[] r = chemin.trim().split("\\.");	
		
		img2.saveAs(r[0]+"_rot."+"jpg"/*r[1]*/);
	}

}
