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
		if(force < 0)
		{
			throw new IllegalArgumentException("La force doit etre positive");
		}
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + " �");
	}
	String r = "Le romain";
 	private String prendreParole() {
		return r + nom + " : ";
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

 		assert force > 0;
 		int oldForce = force;
 		forceCoup = calculResistanceEquipement(forceCoup);
 		force -= forceCoup;
 		if (force != 0) 
 		{
	 			parler("Aie");
 		}
	 	else
	 	{
	 			equipementEjecte = ejecterEquipement();
	 			parler("J'abandonne...");
 		}
 		// post condition la force a diminu�e
 		assert force < oldForce;
 		return equipementEjecte;
 		}


 	int calculResistanceEquipement(int forceCoup) 
 	{
 		String texteParle = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
 		int resistanceEquipement = 0;
 		System.out.println("1");
 		if (nbrEquipement != 0) 
 		{
 			System.out.println("2");
	 		texteParle += "\n Mais heureusement, grace � mon �quipement sa force est diminu� de ";
	 		System.out.println("lol " + nbrEquipement);

	 		for (int i = 0; i < nbrEquipement;) 
	 		{
	 			System.out.println("coucou");
		 		if (equipement[i] != null && equipement[i].equals(Equipement.BOUCLIER))
		 		{
		 			resistanceEquipement += 8;
		 		} 
		 		else 
		 		{
		 			if (equipement[i] != null)
		 			{
				 		System.out.println("Equipement casque");
				 		resistanceEquipement += 5;
		 			}
		 		}
	 		}
	 		texteParle += resistanceEquipement + "!";
	 		System.out.println("3");
 		}
 		System.out.println("4");
 		parler(texteParle);
 		if(forceCoup > 0)
 		{
 	 		forceCoup -= resistanceEquipement;
 		}
 		if (forceCoup < 0)
 		{
 			forceCoup = 0;
 		}
 		System.out.println(forceCoup);
 		return forceCoup;
 	}
	private Equipement[] ejecterEquipement() 
	{
 		Equipement[] equipementEjecte = new Equipement[nbrEquipement];
 		System.out.println("L'�quipement de " + nom.toString() + "s'envole sous la force du coup.");

 		int nbEquipementEjecte = 0;
 		for (int i = 0; i < nbrEquipement; i++) 
 		{
 			if (equipement[i] != null) 
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
		return nom;
	}
	
	public void sEquiper(Equipement equip)
	{
		int nbrEquip = nbrEquipement;
		switch (nbrEquip)
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
			break;
		default:
			break;
			
		}
		
		
		
	}
	
	public static void main(String[] arg)
	{
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		
	}
}
