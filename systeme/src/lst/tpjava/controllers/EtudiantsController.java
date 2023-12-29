
package lst.tpjava.controllers;

import lst.tpjava.Main;
import lst.tpjava.models.Departement;
import lst.tpjava.services.DB;
import lst.tpjava.services.DepartementServices;
import lst.tpjava.services.EnseignantServices;
import lst.tpjava.services.*;
import lst.tpjava.models.Etudiant;
import lst.tpjava.models.Filiere;
public class EtudiantsController {


    public static void showMenu(){
        System.out.println("-------------------------[ Etudiant ]---------------------------");


        System.out.println("1: Pour ajouter un Etudiant");
        System.out.println("2: Pour afficher les Etudiants");
        System.out.println("3: Pour modifier un Etudiant");
        System.out.println("4: Pour supprimer un Etudiant");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEtudiant();
                break;
            case 2:
               showEtudiants();
                break;
            case 3:
                editEtudiant();
                break;
            case 4:
                destroyEtudiant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }



    public static void showEtudiants(){
        for (Etudiant etudiant : DB.etudiants) {
            System.out.print("Id : " + etudiant.getId());
            System.out.print(" | nom : " + etudiant.getNom());
            if (! Main.isNull(etudiant.getId())) {
                System.out.print(" | Etudiant : " +etudiant.getId()+" "+ etudiant.getId()+ " " + etudiant.getNom());
            }
            System.out.println("");
        }

    }

    public static void createEtudiant(){
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("Entrez l'email :");
        int apogee = Main.getIntInput("Entrez apogee :");
       FilieresController.showFilieres();

        int id = Main.getIntInput("choisez un etudiant par id :");
        EtudiantServices.addEtd(nom,prenom,email,apogee,FiliereServices.getFiliereById(id));
        showEtudiants();
        showMenu();


    }


    public static void editEtudiant(){
        showEtudiants();
        int id = Main.getIntInput("Sélecionnez un departement par id pour modifier :");
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("Entrez l'emal :");
        int apogee = Main.getIntInput("Entrez apogee :");
       FilieresController.showFilieres();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");

        EtudiantServices.updateEtd(id, nom,prenom,email,apogee,FiliereServices.getFiliereById(id));

        showEtudiants();
        showMenu();
    }
    public static void destroyEtudiant(){
        showEtudiants();
        int id = Main.getIntInput("Sélecionnez un departement par id pour supprimer :");
        DepartementServices.deleteDeptById(id);
        showEtudiants();

    }
}





