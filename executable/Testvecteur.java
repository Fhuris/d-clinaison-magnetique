package declinaison;

public class Testvecteur {
	public static void main(String[] args) {
		
		Point a= new Point(45,75,0);
		Point b= new Point(90,30,0);
		Vecteur w= new Vecteur(a);
		Vecteur v= new Vecteur(b);
		Vecteur m = Translation.getVecteur(v,a);
		Declinaison dec= new Declinaison(w,v);
		
		//System.out.println("coordonnées= "+ w.toString());
		//System.out.println("norme= "+ w.getNorme());
		//System.out.println("coordonnées= "+ v.toString());
		//System.out.println("norme= "+ v.getNorme());
		System.out.println("déclinaison= " + dec.getDeclinaison());
		
		
		
		
	}

}
