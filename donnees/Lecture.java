package données;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Lecture {
	private String gh;
	private int n=0;
	private int m;
	private double coef;
	private double dif;
	private double[][] g;
	private double[][] h;
	
	
	public Lecture(){
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

			g=new double[n+1][n+1];
			h=new double[n+1][n+1];
			
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
				System.out.println(gh);
				System.out.println(n);
				System.out.println(m);
				System.out.println(coef);
				if(gh.equals("g")){
					g[n][m]=coef;
				}else if(gh.equals("h")){
					h[n][m]=coef;
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
	
	public double getGv(int n, int m) {
		return g[n][m];
	}	
	public double getHv(int n, int m) {
		return h[n][m];
	}
	
	public double[][] getG(){
		return g;
	}
	public double[][] getH(){
		return h;
	}
}
