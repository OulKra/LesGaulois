package personnages;

public class Romain {
	private String nom;
	private int force;
	Equipement[] equipement = new Equipement[2];
	int nbrEquipement = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert force > 0: "La force doit être positive";
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}
 	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	public void recevoirCoup(int forceCoup) {
		assert force > 0: "La force doit être positive";
		int force_tmp = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert force < force_tmp: "La force n'a pas diminuée";
	}
	public String getNom() {
		// TODO Auto-generated method stub
		return nom;
	}
	
	void sEquiper(Equipement equip)
	{
		int nbr_equip = nbrEquipement;
		switch (nbr_equip)
		{
		case 0:
			equipement[nbrEquipement] = equip;
			nbrEquipement++;
			System.out.println("Le romain " + nom + " s'équipe d'un " + equip.nom);
			break;
			
		case 1:
			if(equipement[0] == equip)
			{
				System.out.println("Le romain " + nom + " possède déjà un " + equip.nom);
			}
			else
			{
				equipement[nbrEquipement] = equip;
				nbrEquipement++;
				System.out.println("Le romain " + nom + " s'équipe d'un " + equip.nom);
			}
			break;
		case 2:
			System.out.println("Le romain " + nom + " est deja bien protégé !!!!!!!");
			
		}
		
		
		
	}
	
	public static void main(String[] arg)
	{
		Romain Minus = new Romain("Minus", 6);
		Minus.sEquiper(Equipement.CASQUE);
		Minus.sEquiper(Equipement.CASQUE);
		Minus.sEquiper(Equipement.BOUCLIER);
		Minus.sEquiper(Equipement.CASQUE);
		
	}
}
