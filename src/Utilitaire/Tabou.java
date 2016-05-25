/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaire;

import java.util.ArrayList;

import Controleur.MoteurObserveur;
import Controleur.Renjou;
import Enum.TypeDirection;
import Enum.TypeTabous;

/**
 *
 * @author michauad
 */
public class Tabou implements InterfaceTabou, java.io.Serializable {
	private boolean troisFoistrois;
	private boolean quatreFoisQuatre;
	private boolean sixSept;
	private InfosAlignement infoGauche;
	private InfosAlignement infoDroite;
	private InfosAlignement infoHaut;
	private InfosAlignement infoBas;
	private InfosAlignement infoDiagonaleHautGauche;
	private InfosAlignement infoDiagonaleHautDroite;
	private InfosAlignement infoDiagonaleBasGauche;
	private InfosAlignement infoDiagonaleBasDroite;

	// Constructeur
	public Tabou(ArrayList<TypeTabous> listeTabous) {

		this.troisFoistrois = false;
		this.quatreFoisQuatre = false;
		this.sixSept = false;

		for (TypeTabous typeTabou : listeTabous) {
			switch (typeTabou) {
			case TROIS_TROIS:
				this.troisFoistrois = true;
				break;
			case QUATRE_QUATRE:
				this.quatreFoisQuatre = true;
				break;
			case SIX_SEPT:
				this.sixSept = true;
				break;
			default:
				break;

			}
		}
	}

	public Tabou(boolean troisFoistrois, boolean quatreFoisQuatre, boolean sixSept) {

		this.troisFoistrois = troisFoistrois;
		this.quatreFoisQuatre = quatreFoisQuatre;
		this.sixSept = sixSept;
	}

	public ArrayList<TypeTabous> getListeTabous() {
		ArrayList<TypeTabous> listeTabous = new ArrayList<TypeTabous>();
		if (troisFoistrois) {
			listeTabous.add(TypeTabous.TROIS_TROIS);

		}
		if (quatreFoisQuatre) {
			listeTabous.add(TypeTabous.QUATRE_QUATRE);

		}
		if (sixSept) {
			listeTabous.add(TypeTabous.SIX_SEPT);

		}
		return listeTabous;
	}

	public void setListeTabous(ArrayList<TypeTabous> listeTabous) {
		this.troisFoistrois = false;
		this.quatreFoisQuatre = false;
		this.sixSept = false;

		for (TypeTabous typeTabou : listeTabous) {
			switch (typeTabou) {
			case TROIS_TROIS:
				this.troisFoistrois = true;
				break;
			case QUATRE_QUATRE:
				this.quatreFoisQuatre = true;
				break;
			case SIX_SEPT:
				this.sixSept = true;
				break;
			default:
				break;

			}
		}
	}

	// A appliquer que sur noir!!!!
	@Override
	// A appliquer que sur noir!!!!
	public boolean estValide(PlateauDeJeu r, Coordonnees c) {
		// initialisation des infos selon les directions
		Log.print(1010, "r = " + r + "c" + c);

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
		if (troisFoistrois) {
			estValide = estValide && !troisFoisTrois();
		}
		if (quatreFoisQuatre) {
			estValide = estValide && !quatreFoisQuatre();
		}
		if (sixSept) {
			estValide = estValide && !sixSept();
		}
		return estValide;
	}

	public boolean sixSept() {
		if ((nbPionNoirDiagonaleDroiteContinu() > 5)) {
			return true;
		}
		if (nbPionNoirDiagonaleGaucheContinu() > 5) {
			return true;
		}
		if (nbPionNoirHorizontaleContinu() > 5) {
			return true;
		}
		if (nbPionNoirVerticaleContinu() > 5) {
			return true;
		}

		return false;
	}

	public boolean troisFoisTrois() {
		if (estTroisDiagonaleDroite()) {
			if (estTroisDiagonaleGauche()) {
				return true;
			} else if (estTroisHorizontale()) {
				return true;
			} else if (estTroisVerticale()) {

				return true;
			}

		} else if (estTroisDiagonaleGauche()) {
			if (estTroisHorizontale()) {
				return true;
			} else if (estTroisVerticale()) {
				return true;
			}
		} else if (estTroisHorizontale()) {
			if (estTroisVerticale()) {
				return true;
			}
		}

		return false;
	}

	public boolean quatreFoisQuatre() {

		// test quand le 4*4 est dans des directions différentes cf
		// testQuatreQuatreBasique1
		if (estQuatreDiagonaleDroite()) {
			if (estQuatreDiagonaleGauche()) {
				return true;
			} else if (estQuatreHorizontale()) {
				return true;
			} else if (estQuatreVerticale()) {
				return true;
			}

		} else if (estQuatreDiagonaleGauche()) {
			if (estQuatreHorizontale()) {
				return true;
			} else if (estQuatreVerticale()) {
				return true;
			}
		} else if (estQuatreHorizontale()) {
			if (estQuatreVerticale()) {
				return true;
			}
		}

		return false;
	}

	// A appliquer que sur noir!!!!

	// -
	// -
	// -
	private boolean estTroisDiagonaleDroite() {
		// Log.print(1010, infoDiagonaleHautGauche.toString());
		return (infoDiagonaleHautGauche.estLibreNoir() && infoDiagonaleBasDroite.estLibreNoir()
				&& (infoDiagonaleHautGauche.estLibre2CasesNoir() || infoDiagonaleBasDroite.estLibre2CasesNoir())
				&& (nbPionNoirDiagonaleDroite() == 3));
	}

	// -
	// -
	// -
	private boolean estTroisDiagonaleGauche() {
		return (infoDiagonaleHautDroite.estLibreNoir() && infoDiagonaleBasGauche.estLibreNoir()
				&& (infoDiagonaleHautDroite.estLibre2CasesNoir() || infoDiagonaleBasGauche.estLibre2CasesNoir())
				&& (nbPionNoirDiagonaleGauche() == 3));
	}

	private boolean estTroisVerticale() {

		return (infoHaut.estLibreNoir() && infoBas.estLibreNoir()
				&& (infoHaut.estLibre2CasesNoir() || infoBas.estLibre2CasesNoir()) && (nbPionNoirVerticale() == 3));
	}

	private boolean estTroisHorizontale() {

		return (infoDroite.estLibreNoir() && infoGauche.estLibreNoir()
				&& (infoDroite.estLibre2CasesNoir() || infoGauche.estLibre2CasesNoir())
				&& (nbPionNoirHorizontale() == 3));
	}

	// -
	// -
	// -
	// -
	private boolean estQuatreDiagonaleDroite() {
		return ((infoDiagonaleHautGauche.estLibreNoir() || infoDiagonaleBasDroite.estLibreNoir())
				&& (nbPionNoirDiagonaleDroite() == 4));
	}

	// -
	// -
	// -
	// -
	private boolean estQuatreDiagonaleGauche() {
		return ((infoDiagonaleHautDroite.estLibreNoir() || infoDiagonaleBasGauche.estLibreNoir())
				&& (nbPionNoirDiagonaleGauche() == 4));
	}

	private boolean estQuatreVerticale() {
		return ((infoHaut.estLibreNoir() || infoBas.estLibreNoir()) && (nbPionNoirVerticale() == 4));
	}

	private boolean estQuatreHorizontale() {
		return ((infoDroite.estLibreNoir() || infoGauche.estLibreNoir()) && (nbPionNoirHorizontale() == 4));
	}

	private int nbPionNoirDiagonaleDroite() {
		return (infoDiagonaleHautGauche.getNbNoirNonContinu() + infoDiagonaleBasDroite.getNbNoirNonContinu()
				+ infoDiagonaleHautGauche.getNbNoir() + infoDiagonaleBasDroite.getNbNoir() + 1);
	}

	private int nbPionNoirDiagonaleGauche() {
		return (infoDiagonaleHautDroite.getNbNoirNonContinu() + infoDiagonaleBasGauche.getNbNoirNonContinu()
				+ infoDiagonaleHautDroite.getNbNoir() + infoDiagonaleBasGauche.getNbNoir() + 1);
	}

	private int nbPionNoirVerticale() {
		return (infoHaut.getNbNoirNonContinu() + infoBas.getNbNoirNonContinu() + 1 + infoHaut.getNbNoir()
				+ infoBas.getNbNoir());
	}

	private int nbPionNoirHorizontale() {
		return (infoDroite.getNbNoirNonContinu() + infoGauche.getNbNoirNonContinu() + 1 + infoDroite.getNbNoir()
				+ infoGauche.getNbNoir());
	}

	private int nbPionNoirDiagonaleDroiteContinu() {
		return (infoDiagonaleHautGauche.getNbNoir() + infoDiagonaleBasDroite.getNbNoir() + 1);
	}

	private int nbPionNoirDiagonaleGaucheContinu() {
		return (infoDiagonaleHautDroite.getNbNoir() + infoDiagonaleBasGauche.getNbNoir() + 1);
	}

	private int nbPionNoirVerticaleContinu() {
		return (infoHaut.getNbNoir() + infoBas.getNbNoir() + 1);
	}

	private int nbPionNoirHorizontaleContinu() {
		return (infoDroite.getNbNoir() + infoGauche.getNbNoir() + 1);
	}

}
