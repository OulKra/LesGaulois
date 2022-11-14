package personnages;

public class Humain 
{
	String nom;
	String boissonFavorite;
	int argent;
	String[] inventaire = new String[50];
	int nbrObjet = 0;
	public Humain(String nom, String boissonFavorite, int argent)
	{
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}
	public String getNom() {
		return nom;
	}
	public String getBoissonFavorite() {
		return boissonFavorite;
	}
	public int getArgent() {
		return argent;
	}
	
	
	void parler(String texte)
	{
		System.out.println(texte);
	}
	
	public void direBonjour()
	{
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonFavorite);
	}
	
	public void boire()
	{
		parler("Mmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix)
	{
		if(argent >= prix)
		{
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir une boisson à " + prix + " sous.");
			inventaire[nbrObjet] = bien;
			nbrObjet++;
			argent -= prix;
		}
		else
		{
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir un " + bien + " à " + prix + " sous");
		}
	}
	
	public void gagnerArgent(int gain)
	{
		argent += gain;
	}
	public void perdreArgent(int perte)
	{
		argent -= perte;
	}
}
