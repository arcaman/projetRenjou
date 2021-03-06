package Utilitaire;

import Enum.TypeCouleur;


/*
 * Cette classe permet de choisir les motifs que l'on veut faire reconnaitre a l'IA
 * Plus il y en a plus l'IA repondra juste mais avec plus de temps de calcul
 */
public enum MotifsReconnus {

	estDeuxFoisDeuxLibreLibre {
		@Override
		public boolean verif(Motif motif, TypeCouleur couleur) {
			return motif.estDeuxFoisDeuxLibreLibre(couleur);
		}
	},

	estTroisFoisTroisLibre {
		@Override
		public boolean verif(Motif motif, TypeCouleur couleur) {
			return motif.estTroisFoisTroisLibre(couleur);
		}
	},
	estTroisFoisDeux {
		@Override
		public boolean verif(Motif motif, TypeCouleur couleur) {
			return motif.estTroisFoisDeux(couleur);
		}
	},
	estTroisLibre {
		@Override
		public boolean verif(Motif motif, TypeCouleur couleur) {
			return motif.estTroisLibre(couleur);
		}
	},
	estTroisFoisTroisLibreLibre {
		@Override
		public boolean verif(Motif motif, TypeCouleur couleur) {
			return motif.estTroisFoisTroisLibreLibre(couleur);
		}
	},
	estTroisLibreLibre {
		@Override
		public boolean verif(Motif motif, TypeCouleur couleur) {
			return motif.estTroisLibreLibre(couleur);
		}
	},
	estQuatreLibre {
		@Override
		public boolean verif(Motif motif, TypeCouleur couleur) {
			return motif.estQuatreLibre(couleur);
		}
	},
	estTroisFoisDeuxLibreLibre {
		@Override
		public boolean verif(Motif motif, TypeCouleur couleur) {
			return motif.estTroisFoisDeuxLibreLibre(couleur);
		}
	},
	estTroisFoisDeuxLibre {
		@Override
		public boolean verif(Motif motif, TypeCouleur couleur) {
			return motif.estTroisFoisDeuxLibre(couleur);
		}
	}, 
	estQuatreFoisTrois {
		@Override
		public boolean verif(Motif motif, TypeCouleur couleur) {
			return motif.estQuatreFoisTrois(couleur);
		}
	};

	public abstract boolean verif(Motif motif, TypeCouleur couleur);
}
