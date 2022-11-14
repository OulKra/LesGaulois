package personnages;

public class Romain {
	private String texte;
	
	private String nom;
	private int force;
	Equipement[] equipement = new Equipement[2];
	int nbrEquipement = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert force > 0: "La force doit �tre positive";
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + " �");
	}
 	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	/*public void recevoirCoup(int forceCoup) {
		assert force > 0: "La force doit �tre positive";
		int force_tmp = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert force < force_tmp: "La force n'a pas diminu�e";
	}*/
 	
 	public Equipement[] recevoirCoup(int forceCoup) {
 		Equipement[] equipementEjecte = null;
 		// pr�condition
 		assert force > 0;
 		int oldForce = force;
 		forceCoup = CalculResistanceEquipement(forceCoup);
 		force -= forceCoup;

 		switch (force) 
 		{
	 		case 0:
	 			parler("A�e");
	 		default:
	 			equipementEjecte = ejecterEquipement();
	 			parler("J'abandonne...");
	 			break;
 		}
 		// post condition la force a diminu�e
 		assert force < oldForce;
 		return equipementEjecte;
 		}


 	private int CalculResistanceEquipement(int forceCoup) 
 	{
 		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
 		int resistanceEquipement = 0;
 		if (!(nbrEquipement == 0)) 
 		{
	 		texte += "\n Mais heureusement, grace � mon �quipement sa force est diminu� de ";
	 		for (int i = 0; i < nbrEquipement;) 
	 		{
	 		if ((equipement[i] != null && equipement[i].equals(Equipement.BOUCLIER)) == true) 
	 		{
	 			resistanceEquipement += 8;
	 		} else {
		 		resistanceEquipement += 5;
	 		}
	 		i++;
	 		}
	 		texte += resistanceEquipement + "!";
 		}
 		parler(texte);
 		forceCoup -= resistanceEquipement;
 		if (forceCoup < 0)
 		{
 			forceCoup = 0;
 		}
 		return forceCoup;
 	}
	private Equipement[] ejecterEquipement() 
	{
 		Equipement[] equipementEjecte = new Equipement[nbrEquipement];
 		System.out.println("L'�quipement de " + nom.toString() + " s'envole sous la force du coup.");
 		//TODO
 		int nbEquipementEjecte = 0;
 		for (int i = 0; i < nbrEquipement; i++) 
 		{
 			if (equipement[i] == null) 
 			{
 				continue;
 			} 
 			else 
 			{
 				equipementEjecte[nbEquipementEjecte] =
 				equipement[i];
 				nbEquipementEjecte++;
 				equipement[i] = null;
 			}
 		}
 		return equipementEjecte;
	} 	
 	
	public int getForce() {
			return force;
		}
	public String getNom() {
		// TODO Auto-generated method stub
		return nom;
	}
	
	public void sEquiper(Equipement equip)
	{
		int nbr_equip = nbrEquipement;
		switch (nbr_equip)
		{
		case 0:
			equipement[nbrEquipement] = equip;
			nbrEquipement++;
			System.out.println("Le romain " + nom + " s'�quipe d'un " + equip.nom);
			break;
			
		case 1:
			if(equipement[0] == equip)
			{
				System.out.println("Le romain " + nom + " poss�de d�j� un " + equip.nom);
			}
			else
			{
				equipement[nbrEquipement] = equip;
				nbrEquipement++;
				System.out.println("Le romain " + nom + " s'�quipe d'un " + equip.nom);
			}
			break;
		case 2:
			System.out.println("Le romain " + nom + " est deja bien prot�g� !!!!!!!");
			
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
