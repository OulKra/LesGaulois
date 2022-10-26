package personnages;

public class Gaulois {
	private String nom;
	//private int force;
	private int effetPotion = 1;

	
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}

	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "�" + texte + "�");
	}
	
	/*private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}*/
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}

	
	/*public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		romain.recevoirCoup(force / 3);
	}*/

	public void frapper(Romain romain)
	{
		System.out.println(nom + " envoie un grand coup dans la	m�choire de " + romain.getNom());
		Equipement[] tropheeRomain = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheeRomain != null && i < tropheeRomain.length; i++, nbTrophees++) 
		{
			this.trophees[nbTrophees] = tropheeRomain[i];
		}
	}

	
	void boirePotion(int forcePotion)
	{
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois d�cupl�e");
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		Romain romain = new Romain("Romain (le mec de Emilie)", 5);
		
		System.out.println(asterix);
		asterix.parler("Hey");
		asterix.frapper(romain);
		asterix.boirePotion(5);
	}
}