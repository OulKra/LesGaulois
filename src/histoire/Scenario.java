package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		Gaulois obelix = new Gaulois("Ob�lix", 99);
		Romain romain = new Romain("Romain (le mec de Emilie)", 5);		
		Druide pano = new Druide("Panoramix", 5, 10);
		
		pano.parler("Je vais aller preparer une petite potion...");
		pano.preparerPotion();
		pano.booster(obelix);
		obelix.parler("Par B�l�nos, ce n'est pas juste !");
		pano.booster(asterix);
		asterix.parler("Bonjour");
		romain.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(romain);
		asterix.frapper(romain);
		asterix.frapper(romain);

	}

}
