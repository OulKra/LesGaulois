package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + " �");
	}
 	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			
		} else {
			parler("J'abandonne...");
		}
	}
	public String getNom() {
		// TODO Auto-generated method stub
		return nom;
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		Romain solene = new Romain("Sol�ne", 5);
		
		solene.parler("Hey");
	}
}
