package histoire;

import personnages.Gaulois;
import personnages.Humain;
import personnages.Musee;
import personnages.Romain;


import personnages.Equipement;
//import villagegaulois.Musee;

@SuppressWarnings("unused")
public class Scenario {

	public static void main(String[] args) 
	{
		Gaulois emilie = new Gaulois("Emilie", 50);
		Romain romain = new Romain("Romain", 3);
		
		romain.sEquiper(Equipement.BOUCLIER);
		romain.sEquiper(Equipement.CASQUE);
		do 
		{
			emilie.frapper(romain);
		} while (romain.getForce() > 0);
		
		Musee musee = new Musee("Musée");
		emilie.faireUneDonnation(musee);
		
		
	}

}