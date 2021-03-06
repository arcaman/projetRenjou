package IHMFx;

import java.io.IOException;
import java.util.ArrayList;

import Controleur.Moteur;
import Enum.TypeJoueur;
import Enum.TypeTabous;
import IHMFx.FenetreMenu;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class EcouteurFenetreMenu {
	private IHM ihm;
	private Moteur m;
	private String ancienTheme;
	private boolean themeChangement;
	@FXML
	private ImageView boutonValider;
	@FXML
	private ImageView boutonAnnuler;
	private ToggleGroup noir;
	private ToggleGroup blanc;
	@FXML
	private RadioButton noir1;
	@FXML
	private RadioButton noir2;
	@FXML
	private RadioButton noir3;
	@FXML
	private RadioButton noir4;
	@FXML
	private RadioButton noir5;
	@FXML
	private RadioButton blanc1;
	@FXML
	private RadioButton blanc2;
	@FXML
	private RadioButton blanc3;
	@FXML
	private RadioButton blanc4;
	@FXML
	private RadioButton blanc5;
	@FXML
	private TabPane tabs;
	@FXML
	private CheckBox tabou1;
	@FXML
	private CheckBox tabou2;
	@FXML
	private CheckBox tabou3;
	@FXML
	private ImageView fond;
	@FXML
	private ImageView tabouImage;
	@FXML
	private ImageView tabouExplication;
	@FXML
	private CheckBox modeDebutant;
	@FXML
	private ImageView imageTuto;
	
	
	public EcouteurFenetreMenu(IHM ihm) {
		this.ihm = ihm;
		this.m = ihm.m;
		this.ancienTheme = m.getRenjou().getEmplacementThemes();
		this.themeChangement = false;
		try {
			ihm.fm = new FenetreMenu(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		noir = new ToggleGroup();
		blanc = new ToggleGroup();
		noir1.setToggleGroup(noir);
		noir2.setToggleGroup(noir);
		noir3.setToggleGroup(noir);
		noir4.setToggleGroup(noir);
		blanc1.setToggleGroup(blanc);
		blanc2.setToggleGroup(blanc);
		blanc3.setToggleGroup(blanc);
		blanc4.setToggleGroup(blanc);
	}
	
	@FXML
	private void boutonAnnuler(MouseEvent e) {
		annuler();
	}
	
	public void annuler() {
		ihm.etatTuto = 1;
		ihm.modeTuto = false;
		imageTuto.setImage(ihm.i.getImageVide());
		if (themeChangement) {
			m.getRenjou().setNouveauTheme(ancienTheme);
			ihm.i.setImage();
			ihm.actualiser();
			themeChangement = false;
		}	
		ihm.fj.montrer();
		ihm.fm.cacher();
		ihm.efj.setEnabled();
	}
	
	@FXML
	private void clickImage(MouseEvent e) {
		Tutoriel();
	}
	
	@FXML
	private void boutonValider(MouseEvent e) {
		if (ihm.etatTuto == 12) {
			imageTuto.setImage(ihm.i.getImageVide());
			ihm.etatTuto = 1;
			ihm.modeTuto = false;
		}
		
		TypeJoueur[] tab = new TypeJoueur[2];
		ArrayList<TypeTabous> tabous = new ArrayList<TypeTabous>();
		
		//Valeurs selectionnees radiobutton joueur
		if(noir1.isSelected()) {
			tab[0] = TypeJoueur.values()[0];
		} else if(noir2.isSelected()) {
			tab[0] = TypeJoueur.values()[1];
		} else if(noir3.isSelected()) {
			tab[0] = TypeJoueur.values()[2];
		} else if(noir4.isSelected()) {
			tab[0] = TypeJoueur.values()[3];
		} else if(noir5.isSelected()) {
			tab[0] = TypeJoueur.values()[4];
		}
		
		if(blanc1.isSelected()) {
			tab[1] = TypeJoueur.values()[0];
		} else if(blanc2.isSelected()) {
			tab[1] = TypeJoueur.values()[1];
		} else if(blanc3.isSelected()) {
			tab[1] = TypeJoueur.values()[2];
		} else if(blanc4.isSelected()) {
			tab[1] = TypeJoueur.values()[3];
		} else if(blanc5.isSelected()) {
			tab[1] = TypeJoueur.values()[4];
		}
		
		//Valeurs selectionnees dans tabou
		if (tabou1.isSelected()) {
			tabous.add(TypeTabous.TROIS_TROIS);
		}
		if (tabou2.isSelected()) {
			tabous.add(TypeTabous.QUATRE_QUATRE);
		}
		if (tabou3.isSelected()) {
			tabous.add(TypeTabous.SIX_SEPT);
		}
		
        if (tab[0] != null && tab[1] != null) {
            m.configurerPartie(tab[0], tab[1], tabous, ihm.fm.getNouvellePartie(),modeDebutant.isSelected());
        }
        ancienTheme = m.getRenjou().getEmplacementThemes();
		ihm.efj.setEnabled();
        ihm.efj.update();
        themeChangement = false;
		ihm.fj.montrer();
		ihm.fm.cacher();
	}
	
	@FXML
	private void boutonValiderFinDrag(MouseEvent e) {
		boutonValider.setImage(ihm.i.getBoutonValider());
	}
	
	@FXML
	private void boutonValiderDebutDrag(MouseEvent e) {
		boutonValider.setImage(ihm.i.getBoutonValiderDrag());
	}
	
	@FXML
	private void boutonAnnulerDebutDrag(MouseEvent e) {
		boutonAnnuler.setImage(ihm.i.getBoutonAnnulerDrag());
	}
	
	@FXML
	private void boutonAnnulerFinDrag(MouseEvent e) {
		boutonAnnuler.setImage(ihm.i.getBoutonAnnuler());
	}
	
	@FXML
	public void tabou1DebutDrag(MouseEvent e) {
		tabouImage.setImage(ihm.i.getTroisTroisImage());
		tabouExplication.setImage(ihm.i.getTroisTroisExplication());
	}
	
	@FXML
	public void tabou2DebutDrag(MouseEvent e) {
		tabouImage.setImage(ihm.i.getQuatreQuatreImage());
		tabouExplication.setImage(ihm.i.getQuatreQuatreExplication());
	}
	
	@FXML
	public void tabou3DebutDrag(MouseEvent e) {
		tabouImage.setImage(ihm.i.getSixSeptImage());
		tabouExplication.setImage(ihm.i.getSixSeptExplication());
	}
	
	@FXML
	private void selectionnerThemeTraditionnel(MouseEvent e) {
		themeChangement = true;
		selectionnerTheme("Traditionnel");
	}
	
	@FXML
	private void selectionnerThemeZelda(MouseEvent e) {
		themeChangement = true;
		selectionnerTheme("Zelda");
	}
	
	@FXML
	private void selectionnerThemeCage(MouseEvent e) {
		themeChangement = true;
		selectionnerTheme("Cage");
	}
	
	@FXML
	private void selectionnerThemeRugby(MouseEvent e) {
		themeChangement = true;
		selectionnerTheme("Rugby");
	}
	
	@FXML
	private void selectionnerThemeStarWars(MouseEvent e) {
		themeChangement = true;
		selectionnerTheme("StarWars");
	}
	
	public void selectionnerTheme(String nouveauTheme) {
		m.getRenjou().setNouveauTheme(nouveauTheme);
		ihm.i.setImage();
		ihm.actualiser();
	}
	
	public void setAncienTheme(String theme) {
		this.ancienTheme = theme;
	}
	
	public void selectionnerBoxJoueur() {
		if (!themeChangement) {
			if(m.getRenjou().getJoueurs()[0].getType() == TypeJoueur.values()[0]) {
				noir1.setSelected(true);
			} else if(m.getRenjou().getJoueurs()[0].getType() == TypeJoueur.values()[1]) {
				noir2.setSelected(true);
			} else if(m.getRenjou().getJoueurs()[0].getType() == TypeJoueur.values()[2]) {
				noir3.setSelected(true);
			} else if(m.getRenjou().getJoueurs()[0].getType() == TypeJoueur.values()[3]) {
				noir4.setSelected(true);
			} else if(m.getRenjou().getJoueurs()[0].getType() == TypeJoueur.values()[4]) {
				noir5.setSelected(true);
			}
			if(m.getRenjou().getJoueurs()[1].getType() == TypeJoueur.values()[0]) {
				blanc1.setSelected(true);
			} else if(m.getRenjou().getJoueurs()[1].getType() == TypeJoueur.values()[1]) {
				blanc2.setSelected(true);
			} else if(m.getRenjou().getJoueurs()[1].getType() == TypeJoueur.values()[2]) {
				blanc3.setSelected(true);
			} else if(m.getRenjou().getJoueurs()[1].getType() == TypeJoueur.values()[3]) {
				blanc4.setSelected(true);
			} else if(m.getRenjou().getJoueurs()[1].getType() == TypeJoueur.values()[4]) {
				blanc5.setSelected(true);
			}
			if (m.getRenjou().estModeDebutant()) {
				modeDebutant.setSelected(true);
			}
			if (m.getRenjou().getTabouJeu().estDansListeTabous(TypeTabous.TROIS_TROIS)) {
				tabou1.setSelected(true);
			} else {
				tabou1.setSelected(false);
			}
			if (m.getRenjou().getTabouJeu().estDansListeTabous(TypeTabous.QUATRE_QUATRE)) {
				tabou2.setSelected(true);
			} else {
				tabou2.setSelected(false);
			}
			if (m.getRenjou().getTabouJeu().estDansListeTabous(TypeTabous.SIX_SEPT)) {
				tabou3.setSelected(true);
			} else {
				tabou3.setSelected(false);
			}
		}	
	}
	
	public TabPane getTabPane() {
		return tabs;
	}
	
	
	public void update() {
		fond.setImage(ihm.i.getFond());
		boutonValider.setImage(ihm.i.getBoutonValider());
		boutonAnnuler.setImage(ihm.i.getBoutonAnnuler());
		selectionnerBoxJoueur();
		if (ihm.etatTuto == 8) {
			Tutoriel();
		}
	}
	
	private void Tutoriel() {
		if (ihm.etatTuto == 8) {
			System.out.println(ihm.etatTuto);
			ihm.etatTuto = ihm.etatTuto+1;
			imageTuto.setImage(ihm.i.getImagesTuto().get(ihm.etatTuto-1));
		} else if (ihm.etatTuto == 9) {
			ihm.etatTuto = ihm.etatTuto+1;
			imageTuto.setImage(ihm.i.getImagesTuto().get(ihm.etatTuto-1));
			getTabPane().getSelectionModel().select(1);
		} else if (ihm.etatTuto == 10) {
			ihm.etatTuto = ihm.etatTuto+1;
			imageTuto.setImage(ihm.i.getImagesTuto().get(ihm.etatTuto-1));
			getTabPane().getSelectionModel().select(2);
		} else if (ihm.etatTuto == 11) {
			ihm.etatTuto = ihm.etatTuto+1;
			imageTuto.setImage(ihm.i.getImagesTuto().get(ihm.etatTuto-1));
		} else if (ihm.etatTuto == 12) {
			//DO NOTHING
		} else {
			imageTuto.setImage(ihm.i.getImageVide());
		}	
	}
}
