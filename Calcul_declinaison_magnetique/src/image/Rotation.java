package image;

import java.io.File;

import javaxt.io.Image;

public class Rotation {

	public static void main(String[] args) {
		String filename="test.jpg";
		Image img=new Image(filename);
		img.rotate(30);
		
		File fichier=new File(filename);
		String chemin = new String();
		chemin = fichier.getAbsolutePath();
		String[] r = chemin.trim().split("\\.");	
		
		img.saveAs(r[0]+"_rot."+r[1]);
	}

}
