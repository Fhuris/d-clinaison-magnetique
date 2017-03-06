package image;

import java.io.File;

import javaxt.io.Image;

public class Glbchkfu {

	public static void main(String[] args) {
		String file="C:/User/Corentin/Doc/workspace/Déclinaison magnétique/test.jpg";
		File fichier=new File(file);
		Image img=new Image(file);
		img.rotate(30);
		
		
		String chemin = new String();
		chemin = fichier.getAbsolutePath();
		String[] r = chemin.trim().split(".");
		System.out.println(r[0]);
		
		img.saveAs(r[0]+"_rot."+r[1]);	
	}

}
