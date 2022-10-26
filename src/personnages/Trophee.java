package personnages;

public class Trophee 
{
	Gaulois gaulois;
	Equipement equipement;
	
	public Trophee(Gaulois gau, Equipement equip)
	{
		this.gaulois = gau;
		this.equipement = equip;
	}

	public Gaulois getGaulois() {
		return gaulois;
	}

	public Equipement getEquipement() {
		return equipement;
	}
	
	public String donnerNom()
	{
		return gaulois.getNom();
	}
}
