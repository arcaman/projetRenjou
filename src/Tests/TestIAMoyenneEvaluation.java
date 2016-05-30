package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Controleur.Moteur;
import Enum.TypeCase;
import Enum.TypeCouleur;
import Enum.TypeJoueur;
import Joueur.IAMoyenne;
import Utilitaire.Log;
import Utilitaire.PlateauDeJeu;

public class TestIAMoyenneEvaluation {

	private static String chemin = "Tests/TestsIAMoyenne/Evaluation/";
	Moteur m;
	PlateauDeJeu pdj;
	IAMoyenne iaNoir;
	IAMoyenne iaBlanc;
	@Before
	public void init() {
		pdj = new PlateauDeJeu();
		iaNoir = new IAMoyenne(TypeJoueur.IAMoyenne, 60, TypeCouleur.Noir);
		iaBlanc = new IAMoyenne(TypeJoueur.IAMoyenne, 60, TypeCouleur.Blanc);

		// plage de test de IAMoyenne entre 700 et 800
		// plage detestEstBlancOuNoir 701 710
		// plage detestPartieFinie 711 720
		// plage detestEstJouableSimple 721 730
		// plage detestEstJouable 731 740
		Log.setPlage(504,600);
		//Log.setPlage(00,00);
	}
	@Test
	public void DeuxBlanc() {
		pdj = pdj.charger(chemin + "DeuxBlanc");
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
//		

		fail();
	}

	@Test
	public void DeuxBlancLibre() {
		Log.setPlage(500, 502);
		pdj = pdj.charger(chemin + "DeuxBlancLibre");
		Log.print(501, pdj.toString());
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(0, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(0, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(0, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(0, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));

	}
	
	@Test
	public void DeuxBlancLibreLibre() {
		pdj = pdj.charger(chemin + "DeuxBlancLibreLibre");
		Log.print(501, pdj.toString());
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(-5, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(-5, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(5, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(5, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
		
	}
	
	@Test
	public void DeuxFoisDeuxBlanc() {
		
		pdj = pdj.charger(chemin + "DeuxFoisDeuxBlanc");
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
//		

		fail();
	}
	
	@Test
	public void DeuxFoisDeuxBlancLibre() {
		
		pdj = pdj.charger(chemin + "DeuxFoisDeuxBlancLibre");
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
//		

		fail();
	}
	
	@Test
	public void DeuxFoisDeuxBlancLibreLibre() {
		
		pdj = pdj.charger(chemin + "DeuxFoisDeuxBlancLibreLibre");
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
//		

		fail();
	}
	
	@Test
	public void DeuxFoisDeuxNoir() {
		
		pdj = pdj.charger(chemin + "DeuxFoisDeuxNoir");
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
//		

		fail();
	}
	
	@Test
	public void DeuxFoisDeuxNoirLibre() {
		Log.setPlage(501,502);
		pdj = pdj.charger(chemin + "DeuxFoisDeuxNoirLibre");
		Log.print(501, pdj.toString());
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(5, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(5, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(-5, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(-5, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
	}
	
	@Test
	public void DeuxFoisDeuxNoirLibreLibre() {
		pdj = pdj.charger(chemin + "DeuxFoisDeuxNoirLibreLibre");
//		Log.print(501, pdj.toString());
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(500, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(500, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(-500, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(-500, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
	}
	
	@Test
	public void DeuxNoir() {
		
		pdj = pdj.charger(chemin + "DeuxNoir");
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
//		

		fail();
	}
	
	@Test
	public void DeuxNoirEtBlancLibre() {
		
		pdj = pdj.charger(chemin + "DeuxNoirEtBlancLibre");
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
//		

		fail();
	}
	
	@Test
	public void DeuxNoirEtBlancLibreLibre() {
		pdj = pdj.charger(chemin + "DeuxNoirEtBlancLibreLibre");
		Log.print(505, pdj.toString());
		Log.print(505,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(505,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		Log.print(505,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(505,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(0, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(0, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(0, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(0, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));

	}
	
	@Test
	public void DeuxNoirLibre() {
		Log.setPlage(500, 502);;
		pdj = pdj.charger(chemin + "DeuxNoirLibre");
		Log.print(501, pdj.toString());
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(0, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(0, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(0, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(0, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
	}
	
	@Test
	public void QuatreBlancLibre() {
		
		pdj = pdj.charger(chemin + "QuatreBlancLibre");
		
		Log.print(501,pdj.toString());
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(-20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(-20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));

	}
	
	@Test
	public void QuatreBlancLibreLibre() {
		
		pdj = pdj.charger(chemin + "QuatreBlancLibreLibre");
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
//		
		fail();
		
	}
	
	@Test
	public void QuatreNoirEtBlancLibre() {
		
		pdj = pdj.charger(chemin + "QuatreNoirEtBlancLibre");
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
//		

		fail();
	}
	
	@Test
	public void QuatreNoirEtBlancLibreLibre() {
		pdj = pdj.charger(chemin + "QuatreNoirEtBlancLibreLibre");
		Log.print(501, pdj.toString());
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(-20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
	}
	
	@Test
	public void QuatreNoirLibre() {
		
		pdj = pdj.charger(chemin + "QuatreNoirLibre");
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
//		
		fail();
		
	}
	
	@Test
	public void QuatreNoirLibreLibre() {
		
		pdj = pdj.charger(chemin + "QuatreNoirLibreLibre");
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
//		

		fail();
	}
	
	@Test
	public void TroisBlanc() {
		
		pdj = pdj.charger(chemin + "TroisBlanc");
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
//		
		fail();
		
	}
	
	@Test
	public void TroisBlancLibre() {
		
		pdj = pdj.charger(chemin + "TroisBlancLibre");
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
//		
		fail();
		
	}
	
	@Test
	public void TroisBlancLibreLibre() {
		
		pdj = pdj.charger(chemin + "TroisBlancLibreLibre");
		//Log.setPlage(500,600);
		Log.print(501,pdj.toString());
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
//		

		fail();
	}
	
	@Test
	public void TroisFoisDeuxBlanc() {
		
		pdj = pdj.charger(chemin + "TroisFoisDeuxBlanc");
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
//		
		fail();
		
	}
	
	@Test
	public void TroisFoisDeuxBlancEtNoirLibre() {
		Log.setPlage(500, 502);
		pdj = pdj.charger(chemin + "TroisFoisDeuxBlancEtNoirLibre");
		Log.print(501, pdj.toString());
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(0, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(0, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(0, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(0, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
	}
	
	@Test
	public void TroisFoisDeuxBlancLibre() {
		
		pdj = pdj.charger(chemin + "TroisFoisDeuxBlancLibre");
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
//		

		fail();
	}
	
	@Test
	public void TroisFoisDeuxBlancLibreLibre() {
		
		pdj = pdj.charger(chemin + "TroisFoisDeuxBlancLibreLibre");
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
//		
		fail();
		
	}
	
	@Test
	public void TroisFoisDeuxNoir() {
		
		pdj = pdj.charger(chemin + "TroisFoisDeuxNoir");
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
//		
		fail();
		
	}
	
	@Test
	public void TroisFoisDeuxNoirLibre() {
		pdj = pdj.charger(chemin + "TroisFoisDeuxNoirLibre");
		Log.print(501, pdj.toString());
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(75, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(75, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(-75, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(-75, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));

	}
	
	@Test
	public void TroisFoisTroisBlanc() {
		pdj = pdj.charger(chemin + "TroisFoisTroisBlanc");
		Log.print(501,pdj.toString());
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(-100, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(-100, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(100, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(100, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
		
		
	}
	
	@Test
	public void TroisFoisTroisBlancEtNoirLibre() {
		pdj = pdj.charger(chemin + "TroisFoisTroisBlancEtNoirLibre");
		Log.print(501, pdj.toString());
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(-20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));

	}
	
	@Test
	public void TroisFoisTroisBlancLibre() {
		pdj = pdj.charger(chemin + "TroisFoisTroisBlancLibre");
		Log.print(501, pdj.toString());
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(-20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(-20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));

	}
	
	@Test
	public void TroisFoisTroisBlancLibreLibre() {
		pdj = pdj.charger(chemin + "TroisFoisTroisBlancLibreLibre");
		Log.print(501, pdj.toString());
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(-20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(-20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));

		
	}
	
	@Test
	public void TroisFoisTroisNoir() {
		pdj = pdj.charger(chemin + "TroisFoisTroisNoir");
		Log.print(501, pdj.toString());
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
		
	}
	
	@Test
	public void TroisFoisTroisNoirLibre() {
		pdj = pdj.charger(chemin + "TroisFoisTroisNoirLibre");
		Log.print(501, pdj.toString());
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));

	}
	
	@Test
	public void TroisFoisTroisNoirLibreLibre() {
		pdj = pdj.charger(chemin + "TroisFoisTroisNoirLibreLibre");
		Log.print(501, pdj.toString());
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
		
	}
	
	@Test
	public void TroisNoir() {
		
		pdj = pdj.charger(chemin + "TroisNoir");
		Log.print(501, pdj.toString());
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(0, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(0, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(0, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(0, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
	}
	
	@Test
	public void TroisNoirEtBlancLibreLibre() {
		pdj = pdj.charger(chemin + "TroisNoirEtBlancLibreLibre");
		Log.print(501, pdj.toString());
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
	}
	
	@Test
	public void TroisNoirLibre() {
		pdj = pdj.charger(chemin + "TroisNoirLibre");
		Log.print(501, pdj.toString());
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(0, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(0, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(0, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(0, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));

	}
	
	@Test
	public void TroisNoirLibreLibre() {
		pdj = pdj.charger(chemin + "TroisNoirLibreLibre");
		Log.print(501, pdj.toString());
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaNoir.Evaluation(pdj, TypeCase.PionNoir));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
//		Log.print(501,""+iaBlanc.Evaluation(pdj, TypeCase.PionNoir));	
		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(20000, iaNoir.Evaluation(pdj, TypeCase.PionNoir));
		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionBlanc));
		assertEquals(-20000, iaBlanc.Evaluation(pdj, TypeCase.PionNoir));
	}
	
}
