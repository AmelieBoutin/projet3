package com.niveaux;

import ressources.Configuration;
import com.fonctionnement.DeroulementJeu;
import com.fonctionnement.MethodesRepetitives;

import java.util.Scanner;

public class Challenger implements DeroulementJeu {

    /*Valeurs reprises de la classe configuration*/
    static Configuration configuration = new Configuration();
    static int longueurNb = configuration.getLongueurNb();
    static int nbEssais = configuration.getNbEssais();
    boolean modeDeveloppeur = configuration.getModeDeveloppeur();

    /*Méthodes reprises de la classe methodesrepetitives*/
    MethodesRepetitives methodesRepetitives = new MethodesRepetitives();


    public String nbMystere() {

        String nbInconnu = new String();

        /*générer code aléatoire*/
        nbInconnu = methodesRepetitives.genererCodeAleatoire();

        /*Afficher nb mystere selon mode developpeur actif ou non*/
        if (modeDeveloppeur = true) {
            System.out.println("Combinaison secrète du Joueur : " + nbInconnu);
        } else {
        }
        return nbInconnu;
    }

    public String proposition() {

        String nb;
        int i = 0;
        boolean vf;

        do { /*Vérifier si la saisie du joueur est bien un nombre à 4 chiffres*/
            System.out.println("Proposition Joueur :");

            Scanner sc = new Scanner(System.in);
            nb = sc.nextLine();
            vf = true;

            vf = methodesRepetitives.siEstUnNombreAQuatreChiffres(vf, nb);

        }
        while (vf == false || nb.length() != longueurNb);

        return nb;
    }


    public boolean jeu() {/*boucle la méthode jeuTourneUneFois selon le nombre d'essais défini*/


        String resultcomp = "";
        int k;
        String reponse;
        String nbOrdi = nbMystere();/*definir nb a trouver*/
        String nbJoueur = proposition();/*demande au joueur de saisir un nombre*/
        boolean victoire = false;


        for (k = 1; victoire == false && k <= nbEssais; k++) {/*une boucle qui tourne tant que le joueur n'a pas trouve le nb, et tant qu'on a pas atteind le nb limite d'essais*/
            resultcomp = methodesRepetitives.compare(nbOrdi, nbJoueur);/*lancer la comparaison des valeur*/
            System.out.println(" -> Réponse Joueur : " + resultcomp);/*afficher les symboles de comparaison*/

            if (resultcomp.equals("====")) {/*si la saisie du joueur correspond au nb mystere alors victoire */
                victoire = true;
            } else if (k < nbEssais) { /*sinon relancer methode de saisie du joueur*/
                nbJoueur = proposition();
            }

        }
        System.out.println("Le nombre mystère est : " + nbOrdi);/*arrivee au dernier essai afficher le nb qu'il fallait trouver*/

        return victoire;

    }
}
