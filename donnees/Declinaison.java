package declinaison;

public class Declinaison {
	private double declinaison;

	public Declinaison(Vecteur a , Vecteur b) {
		this.declinaison=Math.acos((a.getx()*b.getx()+a.gety()*b.gety())/(a.getNorme()*b.getNorme()));
	}
	
	
public double getDeclinaison(){
	return declinaison*180/Math.PI;
	
}
}
