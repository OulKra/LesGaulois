package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbrVillageois = 0;
	
	public Village(String nom, int nbVillageoisMaximum)
	{
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}

	public Chef getChef() {
		return chef;
	}
	
	void ajouterHabitant(Gaulois gau)
	{
		villageois[nbrVillageois] = gau;
		nbrVillageois++;
	}
	
	Gaulois trouverHabitant(int id)
	{
		return villageois[id];
	}

	void afficherVillageois()
	{
		System.out.println("Dans le village du chef " + chef + " vivent les légendaires gaulois : ");
		for (int i = 0; i < villageois.length; i++) 
		{
			if (villageois[i] != null) 
			{
				System.out.println("- " + villageois[i].getNom());
			}
		}
	}
	
	public static void main(String[] arg)
	{
		Village village = new Village("Village des Irréductibles", 30);
		//Gaulois gaulois = village.trouverHabitant(30); ==> Exception in thread parce que la liste a bien 30 element mais ils sont vides
		Chef Abraracourcix = new Chef("Abraracourcix", 6, 1, village);
		Gaulois Asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(Asterix);
		
		Gaulois Obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(Obelix);
		
		village.afficherVillageois();
		
	}
}
