package com.amelie;

import java.util.Scanner;

public class Main {

    /**
     * Afficher chaque niveau
     */
    public static String main(String[] args) {

        /*Afficher les regles du jeu*/
        Configuration configuration = new Configuration();
        int nbEssais = configuration.getNbEssais();
        MethodesRepetitives methodesRepetitives = new MethodesRepetitives();

        System.out.println("Votre mission si vous l'acceptez est de sortir de cette pièce.");
        System.out.println("Pour celà vous devez vaincre l'ordinateur.");
        System.out.println("Vous avez "  + nbEssais + " essais. Passé ce nombre, vous aurez perdu.");
        System.out.println("Vous avez le choix entre différents mode : challenge, défenseur et duel.");
        System.out.println("Choix du niveau");
        System.out.println("1- challenge : vous devez deviner le code secret de l'ordinateur");
        System.out.println("2- défenseur : l'ordinateur va à son tour essayer de deviner votre code");
        System.out.println("3- duel : vous devez deviner le code de l'ordinateur avant que celui-ci ne devine le votre");

        /**
         * Afficher niveau sélectionné et lancer le niveau demandé
         */
        String nbLevel;
        Challenge challenge = new Challenge();
        Defenseur defenseur = new Defenseur();
        Duel duel = new Duel ();
        int i;
        String reponse;

        do {
            System.out.println("Quel niveau choisissez-vous ?");
            Scanner sc = new Scanner(System.in);
            nbLevel = sc.nextLine();

            switch (nbLevel) {

                case "1":
                    System.out.println("Vous avez choisi le niveau challenge");
                    challenge.jeu();
                    methodesRepetitives.rejouer();
                    break;
                case "2":
                    System.out.println("Vous avez choisi le niveau défenseur");
                    defenseur.jeu();
                    break;
                case "3":
                    System.out.println("Vous avez choisi le niveau duel");
                    duel.jeu();
                    break;
                default:
                    System.out.println("Vous n'avez pas choisi de niveau parmi ceux proposés. Veuillez réitérer votre choix");
                    break;

            }
        } while (!nbLevel.equals("1") && !nbLevel.equals("2") && !nbLevel.contentEquals("3"));

        return nbLevel;
    }

    /* Demander au joueur s'il souhaite rejouer*/

    public void rejouer(String niveau) {

        String reponse;
        niveau = main();

        do {
            System.out.println("Si vous souhaitez rejouer au même niveau tapez 1");
            System.out.println("Si vous souhaitez rejouer à un autre niveau tapez 2");
            System.out.println("Si vous souhaitez quitter le jeu tapez 3");
            Scanner sc2 = new Scanner(System.in);
            reponse = sc2.nextLine();
            reponse = reponse.toUpperCase();

            if (!reponse.equals ("1") && !reponse.equals ("2") && !reponse.equals ("3")) {
                System.out.println("Vous n'avez pas saisi un caractère valide !");
            }else if (reponse.equals("1") && niveau.equals("1")) {
                challenge.jeu();
            }else if (reponse.equals("1") && niveau.equals("2")) {
                defenseur.jeu();
            }else if (reponse.equals("1") && niveau.equals("3")) {
                duel.jeu();
            }else if (reponse.equals("3")) {
                main();
            }
        }
        while(reponse.equals("1") ||reponse.contentEquals("2"));
    }

}
