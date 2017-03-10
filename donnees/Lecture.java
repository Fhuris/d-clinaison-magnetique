package donnees;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Lecture {
	
	
	
//	public Lecture(){}
	
	public static double[][][] coef(){
		String gh;
		int n=0;
		int m;
		double coef;
		double dif;
		double[][][] tab = null;
		File file = new File("donnees.txt");
		//Lecture du fichier txt et récupération des données
		try { 
			InputStream ipstmp = new FileInputStream(file); 
			InputStreamReader ipsrtmp = new InputStreamReader(ipstmp); 
			BufferedReader brtmp = new BufferedReader(ipsrtmp);
			String lntmp;
			while ((lntmp = brtmp.readLine()) != null) { 
				String[] r = lntmp.trim().split(" ");
				int tmp=Integer.parseInt(r[1]);
				if (tmp>n)
					n=tmp;
			}
			brtmp.close(); 

			tab=new double[2][n+1][n+1];
			
			InputStream ips = new FileInputStream(file); 
			InputStreamReader ipsr = new InputStreamReader(ips); 
			BufferedReader br = new BufferedReader(ipsr); 
			String ligne;
			while ((ligne = br.readLine()) != null) { 
				String[] r = ligne.trim().split(" "); //espace comme séparateur
				gh = r[0];
				n = Integer.parseInt(r[1]); 
				m = Integer.parseInt(r[2]);
				coef = Double.parseDouble(r[3]);
				dif = Double.parseDouble(r[4]);
				coef += dif*2;
				if(gh.equals("g")){
					tab[0][n][m]=coef;
				}else if(gh.equals("h")){
					tab[1][n][m]=coef;
				}else{
					System.out.println("Fichier éronné");
					System.exit(0);
				}
			}
			br.close(); 
		}
		catch (Exception e) { 
			//afficher l'erreur et d'où elle vient
			System.out.println(e.toString()); 
			e.printStackTrace();
		}
		return tab;
		/*
		for(int i=0;i<g.length;i++){
			for(int j=0;j<g.length;j++)
				System.out.print(g[i][j]+" ");
		System.out.println();
		}
		System.out.println();

		for(int i=0;i<h.length;i++){
			for(int j=0;j<h.length;j++)
				System.out.print(h[i][j]+" ");
		System.out.println();
		}
		*/
		
	}
	
	public static double getGv(int n, int m) {
		return coef()[0][n][m];
	}	
	public static double getHv(int n, int m) {
		return coef()[1][n][m];
	}
	
	public static double[][] getG(){
		return coef()[0];
	}
	public static double[][] getH(){
		return coef()[1];
	}
}
