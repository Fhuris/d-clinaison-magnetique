package executable;

import java.io.IOException;
import java.util.Scanner;

import image.Rotation;

public class Image {

	public static void main(String[] args) throws IOException {
		Scanner input=new Scanner(System.in);
		System.out.println("Entrez l'URL de votre image TIFF (attention, le fichier .tfw associé doit être au même endroit)");
		String filename=input.nextLine();
		input.close();
//		String filename="NE1_HR_LC_SR_W_red.tif";
		Rotation.exe(filename);
	}

}
