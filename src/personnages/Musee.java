package personnages;

public class Musee 
{
	Trophee[] listTrophee = new Trophee[200];
	int nbrTrophee = 0;
	String nom;
	public Musee(String nom)
	{
		this.nom = nom;
	}
	
	public void donnerTrophees(Gaulois gau, Trophee equi)
	{
		listTrophee[nbrTrophee] = equi;
		nbrTrophee++;
	}
}
