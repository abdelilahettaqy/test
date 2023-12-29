

package lst.tpjava;

import lst.tpjava.controllers.*;
import lst.tpjava.models.*;
import lst.tpjava.models.Module;
import lst.tpjava.services.DB;

import java.util.Scanner;

public class Main {

    public static boolean isNull(Object ob) {
        return ob == null;
    }

    public static int getIntInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un nombre entier : ";
        if (msg.length > 0)
            message = msg[0];
        System.out.print(message);


        // This method reads the number provided using keyboard
        int num = scan.nextInt();

        // Closing Scanner after the use
        //  scan.close();
        return num;
    }

    public static String getStringInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un texte : ";
        if (msg.length > 0)
            message = msg[0];
        System.out.print(message);

        // This method reads the number provided using keyboard
        String str = scan.nextLine();

        // Closing Scanner after the use
        //  scan.close();
        return str;
    }

    public static void showPrincipalMenu() {
        System.out.println("-------------------------[ Bienvenu ]---------------------------");


        System.out.println(" Pour gérer les départements taper--: a");
        System.out.println(" Pour gérer les filières taper------: b");
        System.out.println(" Pour gérer les enseignants---------: c");
        System.out.println(" Pour gérer les modules-------------: d");
        System.out.println(" Pour gérer les étudiants-----------: e");
        System.out.println(" Pour sortir -----------------------: s");

        //"Veuillez sélectionner une option : ")
        String option = getStringInput("Veuillez choisez une option : ");
        switch (option) {
            case "a":
                DepartementsController.showMenu();
                break;
            case "b":
                FilieresController.showMenu();
                break;
            case "c":

                EnseignantsController.showMenu();
                break;
            case "d":
                ModulesController.showMenu();
                break;
            case "e":
                EtudiantsController.showMenu();
                break;
            default:
                // code block
        }
       /* switch (option) {
            case 1:

                DepartementsController.showMenu();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                // code block
        }*/


    }

    public static void main(String[] args) {

        Enseignant enseignant = new Enseignant();
        enseignant.setNom("Ait Said");
        enseignant.setPrenom("Mahdi");
        enseignant.setEmail("test@gmail.com");
        enseignant.setGrade("ing");
        enseignant.setId(DB.getEnsId());
        DB.enseignants.add(enseignant);
        showPrincipalMenu();
        /*
        Departement departement=new Departement();
        departement.setId(DB.getDeptId());
        departement.setIntitule("informatique");
        DB.departements.add(departement);
        showPrincipalMenu();

        Etudiant etudiant =new Etudiant();
        etudiant.setNom("Abdelilah");
        etudiant.setPrenom("ET TAQY");
        etudiant.setEmail("etaqy@gmail.com");
        etudiant.setApogee(21010985);
        etudiant.setId(1);
        DB.etudiants.add(etudiant);
        showPrincipalMenu();

        Filiere filiere=new Filiere();
        filiere.setId(3);
        filiere.setIntitule("MIP");
        filiere.set
        DB.filieres.add(filiere);
        showPrincipalMenu();

        Module module=new Module();
        module.setId(4);
        module.setIntitule("java");
        DB.modules.add(module);
        showPrincipalMenu();

        Note note=new Note();
        note.setNote(18);
        DB.notes.add(note);
        showPrincipalMenu();
*/


    }
}