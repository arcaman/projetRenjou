/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaire;


import Controleur.Renjou;
import Enum.TypeCouleur;
import Enum.TypeDirection;

/**
 *
 * @author michauad
 */
public class Tabou implements InterfaceTabou, java.io.Serializable {
	private String nom;
	private boolean[][] configuration;
	private InfosAlignement infoGauche;
	private InfosAlignement infoDroite;
	private InfosAlignement infoHaut;
	private InfosAlignement infoBas;
	private InfosAlignement infoDiagonaleHautGauche;
	private InfosAlignement infoDiagonaleHautDroite;
	private InfosAlignement infoDiagonaleBasGauche;
	private InfosAlignement infoDiagonaleBasDroite;
	

	// Constructeur
	public Tabou(boolean[][] conf, String nom) {
		this.nom=nom;
		this.configuration=conf;
	}

	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public boolean[][] getConfiguration() {
		return this.configuration;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setConfiguration(boolean[][] configuration) {
		this.configuration = configuration;
	}

	//A appliquer que sur noir!!!!
	@Override
	//A appliquer que sur noir!!!!
	public boolean estValide(PlateauDeJeu r, Coordonnees c, boolean troisFoistrois, boolean quatreFoisQuatre, boolean sixSept ) {
		//initialisation des infos selon les directions
		Log.print(1010, "r = " +r + "c" + c);
		
		infoGauche = new InfosAlignement(r, c, TypeDirection.Gauche);
		infoDroite = new InfosAlignement(r, c, TypeDirection.Droite);
		infoHaut = new InfosAlignement(r, c, TypeDirection.Haut);
		infoBas = new InfosAlignement(r, c, TypeDirection.Bas);
		infoDiagonaleHautGauche = new InfosAlignement(r, c, TypeDirection.DiagonaleHautGauche);
		infoDiagonaleHautDroite = new InfosAlignement(r, c, TypeDirection.DiagonaleHautDroite);
		infoDiagonaleBasGauche = new InfosAlignement(r, c, TypeDirection.DiagonaleBasGauche);
		infoDiagonaleBasDroite = new InfosAlignement(r, c, TypeDirection.DiagonaleBasDroite);
		
		
		Log.print(1010, infoDiagonaleHautGauche.toString());
		Log.print(1010, infoDiagonaleHautDroite.toString());
		Log.print(1010, infoDiagonaleBasGauche.toString());
		Log.print(1010, infoDiagonaleBasDroite.toString());
		
		boolean estValide = true;
		if(troisFoistrois){
			estValide = estValide && !troisFoisTrois();
		}
		if(quatreFoisQuatre){
			estValide = estValide && !quatreFoisQuatre();
		}
		if(sixSept){
			estValide = estValide && !sixSept();
		}
		return estValide;
	}
	
	public boolean sixSept() {
		if((nbPionNoirDiagonaleDroiteContinu() > 5)){
			return true;
		}
		if(nbPionNoirDiagonaleGaucheContinu() > 5){
			return true;
		}
		if(nbPionNoirHorizontaleContinu() > 5){
			return true;
		}
		if(nbPionNoirVerticaleContinu() > 5){
			return true;
		}
		
		return false;
	}

	public boolean troisFoisTrois(){
		if(estTroisDiagonaleDroite()){
			if(estTroisDiagonaleGauche()){
				return true;
			}else if(estTroisHorizontale()){
					return true;
			}else if(estTroisVerticale()){
				
				return true;
			}
			
		}else if(estTroisDiagonaleGauche()){
			if(estTroisHorizontale()){
				return true;
			}else if(estTroisVerticale()){
				return true;
			}
		}else if(estTroisHorizontale()){
			if(estTroisVerticale()){
				return true;
			}
		}
		
		
		return false;
	}
	
	public boolean quatreFoisQuatre(){
		
		//test quand le 4*4 est dans des directions différentes cf testQuatreQuatreBasique1
		if(estQuatreDiagonaleDroite()){
			if(estQuatreDiagonaleGauche()){
				return true;
			}else if(estQuatreHorizontale()){
					return true;
			}else if(estQuatreVerticale()){
				return true;
			}
			
		}else if(estQuatreDiagonaleGauche()){
			if(estQuatreHorizontale()){
				return true;
			}else if(estQuatreVerticale()){
				return true;
			}
		}else if(estQuatreHorizontale()){
			if(estQuatreVerticale()){
				return true;
			}
		}
		
		return false;
	}
	
	//A appliquer que sur noir!!!!
	
	// -
	//   -
	//     -
	private boolean estTroisDiagonaleDroite(){
		//Log.print(1010, infoDiagonaleHautGauche.toString());
		return (infoDiagonaleHautGauche.estLibre(TypeCouleur.Noir) && infoDiagonaleBasDroite.estLibre(TypeCouleur.Noir) && (infoDiagonaleHautGauche.estLibre2Cases(TypeCouleur.Noir) || infoDiagonaleBasDroite.estLibre2Cases(TypeCouleur.Noir)) && (nbPionNoirDiagonaleDroite() == 3));
	}
	
	//     -
	//   -
	// -
	private boolean estTroisDiagonaleGauche(){	
		return (infoDiagonaleHautDroite.estLibre(TypeCouleur.Noir) && infoDiagonaleBasGauche.estLibre(TypeCouleur.Noir) && (infoDiagonaleHautDroite.estLibre2Cases(TypeCouleur.Noir) || infoDiagonaleBasGauche.estLibre2Cases(TypeCouleur.Noir)) && ( nbPionNoirDiagonaleGauche() == 3));
	}
	
	private boolean estTroisVerticale(){
		
		return (infoHaut.estLibre(TypeCouleur.Noir) && infoBas.estLibre(TypeCouleur.Noir) && (infoHaut.estLibre2Cases(TypeCouleur.Noir) || infoBas.estLibre2Cases(TypeCouleur.Noir)) && (nbPionNoirVerticale() == 3));
	}
	
	private boolean estTroisHorizontale(){
		
		return (infoDroite.estLibre(TypeCouleur.Noir) && infoGauche.estLibre(TypeCouleur.Noir) && (infoDroite.estLibre2Cases(TypeCouleur.Noir) || infoGauche.estLibre2Cases(TypeCouleur.Noir)) &&( nbPionNoirHorizontale()== 3));
	}
	
	
	// -
	//   -
	//     -
	//       -
	private boolean estQuatreDiagonaleDroite(){
		return ((infoDiagonaleHautGauche.estLibre(TypeCouleur.Noir) || infoDiagonaleBasDroite.estLibre(TypeCouleur.Noir)) && (nbPionNoirDiagonaleDroite() == 4));
	}
	
	//       -
	//     -
	//   -
	// -
	private boolean estQuatreDiagonaleGauche(){	
		return ((infoDiagonaleHautDroite.estLibre(TypeCouleur.Noir) || infoDiagonaleBasGauche.estLibre(TypeCouleur.Noir)) && (nbPionNoirDiagonaleGauche() == 4));
	}
	
	private boolean estQuatreVerticale(){
		return ((infoHaut.estLibre(TypeCouleur.Noir) || infoBas.estLibre(TypeCouleur.Noir)) && (nbPionNoirVerticale() == 4));
	}
	
	private boolean estQuatreHorizontale(){
		return ((infoDroite.estLibre(TypeCouleur.Noir) || infoGauche.estLibre(TypeCouleur.Noir)) && (nbPionNoirHorizontale() == 4));
	}
	
	private int nbPionNoirDiagonaleDroite(){
		return (infoDiagonaleHautGauche.getNbPionNonContinu(TypeCouleur.Noir) + infoDiagonaleBasDroite.getNbPionNonContinu(TypeCouleur.Noir) + infoDiagonaleHautGauche.getNbPion(TypeCouleur.Noir) + infoDiagonaleBasDroite.getNbPion(TypeCouleur.Noir)  + 1);
	}
	
	private int nbPionNoirDiagonaleGauche(){
		return (infoDiagonaleHautDroite.getNbPionNonContinu(TypeCouleur.Noir) + infoDiagonaleBasGauche.getNbPionNonContinu(TypeCouleur.Noir) + infoDiagonaleHautDroite.getNbPion(TypeCouleur.Noir) + infoDiagonaleBasGauche.getNbPion(TypeCouleur.Noir) + 1);
	}
	
	private int nbPionNoirVerticale(){
		return (infoHaut.getNbPionNonContinu(TypeCouleur.Noir) + infoBas.getNbPionNonContinu(TypeCouleur.Noir) + 1 + infoHaut.getNbPion(TypeCouleur.Noir) + infoBas.getNbPion(TypeCouleur.Noir));
	}
	
	private int nbPionNoirHorizontale(){
		return (infoDroite.getNbPionNonContinu(TypeCouleur.Noir) + infoGauche.getNbPionNonContinu(TypeCouleur.Noir) + 1 + infoDroite.getNbPion(TypeCouleur.Noir) + infoGauche.getNbPion(TypeCouleur.Noir));
	}
	
	private int nbPionNoirDiagonaleDroiteContinu(){
		return (infoDiagonaleHautGauche.getNbPion(TypeCouleur.Noir) + infoDiagonaleBasDroite.getNbPion(TypeCouleur.Noir) + 1);
	}
	
	private int nbPionNoirDiagonaleGaucheContinu(){
		return (infoDiagonaleHautDroite.getNbPion(TypeCouleur.Noir) + infoDiagonaleBasGauche.getNbPion(TypeCouleur.Noir) + 1);
	}
	
	private int nbPionNoirVerticaleContinu(){
		return (infoHaut.getNbPion(TypeCouleur.Noir) + infoBas.getNbPion(TypeCouleur.Noir) + 1);
	}
	
	private int nbPionNoirHorizontaleContinu(){
		return (infoDroite.getNbPion(TypeCouleur.Noir) + infoGauche.getNbPion(TypeCouleur.Noir) + 1);
	}
	
}
