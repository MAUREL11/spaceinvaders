package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;

public class SpaceInvaders {

	private static final char MARQUE_VIDE = '.';
	private static final char MARQUE_VAISSEAU = 'V';
	int longueur;
    int hauteur;
    Vaisseau vaisseau;
    public SpaceInvaders(int longueur, int hauteur) {
	   this.longueur = longueur;
	   this.hauteur = hauteur;
   }
    
    
    
    @Override
	public String toString() {
		return recupererEspaceJeuDansChaineASCII();
	}


	public String recupererEspaceJeuDansChaineASCII() {
		StringBuilder espaceDeJeu = new StringBuilder();
		for (int y = 0; y < hauteur; y++) {
			for (int x = 0; x < longueur; x++) {
				char marque = recupererMarqueDeLaPosition(x, y);
				
			      espaceDeJeu.append(marque);
			}
			espaceDeJeu.append('\n');
		}
		return espaceDeJeu.toString();
	}


	public char recupererMarqueDeLaPosition(int x, int y) {
		char marque;
		  if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
		      marque=MARQUE_VAISSEAU;
		  else
		      marque=MARQUE_VIDE;
		return marque;
	}


	public boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
		return aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
	}


	public boolean aUnVaisseau() {
		return vaisseau!=null;
	}

	
	public void positionnerUnNouveauVaisseau(int longueur, int hauteur, int x, int y) {
		if (estPasDansEspaceJeu(x, y))
			throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");

		vaisseau = new Vaisseau(longueur, hauteur);
		vaisseau.positionner(x, y);
	}

	public boolean estPasDansEspaceJeu(int x, int y) {
		return !(((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur)));
	}


	public void deplacerVaisseauVersLaDroite() {
		if (vaisseau.abscisseLaPlusADroite() < (longueur - 1))
			vaisseau.seDeplacerVersLaDroite();
	}


	public void deplacerVaisseauVersLaGauche() {
		if (vaisseau.abscisseLaPlusAGauche()>0) vaisseau.seDeplacerVersLaGauche();
		
	}




}
	
