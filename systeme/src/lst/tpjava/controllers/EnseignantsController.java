
package lst.tpjava.controllers;

import lst.tpjava.Main;
import lst.tpjava.models.Enseignant;
import lst.tpjava.services.DB;
import lst.tpjava.services.DepartementServices;
import lst.tpjava.services.EnseignantServices;

public class EnseignantsController {

    public static void showMenu(){

        System.out.println("-------------------------[ Enseignants ]---------------------------");


        System.out.println("1: Pour ajouter un Enseignant");
        System.out.println("2: Pour afficher les Enseignants");
        System.out.println("3: Pour modifier un Enseignant");
        System.out.println("4: Pour supprimer un Enseignant");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("entrer votre  option : ");
        switch(option) {
            case 1:
                createEnseignant();
                break;
            case 2:
                showEnseignants();
                break;
            case 3:
                editEnseignant();
                break;
            case 4:
                destroyEnseignant();
                break;
            default:
                Main.showPrincipalMenu();
        }

    }
    public static void showEnseignants(){
        for (Enseignant enseignant : DB.enseignants) {
            System.out.print("Id : " + enseignant.getId());
            System.out.print(" | Nom : " + enseignant.getNom() + " " + enseignant.getPrenom());
            System.out.print(" | Email : " + enseignant.getEmail() );

            if (! Main.isNull(enseignant.getId())) {
               System.out.print(" | Chef : " + enseignant.getId() + " " + enseignant.getNom() +" "+enseignant.getEmail());
            }
            System.out.println("");
        }
    }
    public static void createEnseignant(){

        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String grade = Main.getStringInput("Entrez le grade :");
        String email = Main.getStringInput("Entrez l'email :");
        DepartementsController.showDepartements();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        EnseignantServices.addEns(nom,prenom,email,grade,DepartementServices.getDeptById(id));

        showEnseignants();
        showMenu();

    }
    public static void editEnseignant(){

        showEnseignants();
        int id = Main.getIntInput("Sélecionnez un Enseignant par id pour modifier :");
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("Entrez l'email :");
        String grade = Main.getStringInput("Entrez le grade :");
        DepartementsController.showDepartements();
        int iddpr = Main.getIntInput("Sélecionnez un Deparetement par id :");

        EnseignantServices.updateEns(id, nom,prenom,email,grade,DepartementServices.getDeptById(id) );

        showEnseignants();
        showMenu();

    }
    public static void destroyEnseignant(){

        showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id pour supprimer :");
        EnseignantServices.deleteEnsById(id);
        showEnseignants();

    }
}



