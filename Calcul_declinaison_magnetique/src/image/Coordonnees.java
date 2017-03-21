package image;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Coordonnees {

	public static double[] coord(String filename){
		File file = new File(filename);
		double[] c=new double[4];
		int n=0;
		//Lecture du fichier txt et récupération des données
		try { 
			InputStream ips = new FileInputStream(file); 
			InputStreamReader ipsr = new InputStreamReader(ips); 
			BufferedReader br = new BufferedReader(ipsr); 
			String ligne;
			for(int i=0;i<6;i++){
				ligne=br.readLine();
				if (i!=1 && i!=2){
					c[n]=Double.parseDouble(ligne.trim());
					n++;
				}
			}
			br.close(); 
		}
		catch (Exception e) { 
			//afficher l'erreur et d'où elle vient
			System.out.println(e.toString()); 
			e.printStackTrace();
		}
		return c;
	}
}
