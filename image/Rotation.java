package image;

import java.io.File;

import javaxt.io.Image;

public class Rotation {

	public static void main(String[] args) {
		String file="D:/G2_projet_info/Lighthouse.jpg";
		File fichier=new File(file);
		Image img=new Image(file);
		img.rotate(30);
		
		
		String chemin = new String();
		chemin = fichier.getAbsolutePath();
		String[] r = chemin.trim().split("\\.");		
		img.saveAs(r[0]+"_rot."+r[1]);
		
	}

}
