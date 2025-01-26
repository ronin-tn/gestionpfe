package pfe;

public class Test {

    public static void main(String[] args) {
        try {
            Entreprise entreprise = new Entreprise("ENT1","Informatique");

            Projet projet1 = new Projet("P001", "AI", "2024-01-01", "2024-06-01");
            Stage stage1 = new Stage("S001", entreprise, "2024-02-01", "2024-07-01");
            entreprise.ajouterOffreStage(stage1);


            Encadrant encadrant1 = new Encadrant("EN001", "Ahmed", "Khalil", "Informatique");
            Encadrant encadrant2 = new Encadrant("EN002", "Samir", "Bouaziz", "Réseaux");

            Etudiant etudiant1 = new Etudiant("ET001", "Ali", "Ben Salah", "Informatique", "Genie Logiciel");
            Etudiant etudiant2 = new Etudiant("ET002", "Sara", "Mejri", "Informatique", "Réseaux");
            Etudiant etudiant3 = new Etudiant("ET003", "chahin", "Dridi", "Informatique", "AI");
            Etudiant etudiant4 = new Etudiant("ET004", "sajed", "Gafsi", "Informatique", "BD");
            Etudiant etudiant5 = new Etudiant("ET005", "Malik", "chrif", "Informatique", "Electro");
            Etudiant etudiant6 = new Etudiant("ET006", "Louay", "abidi", "Informatique", "WEB DEV");

            GestionAffectations gestion = new GestionAffectations();
            gestion.affecterProjet(etudiant1, projet1, encadrant1);
            
            etudiant1.postulerStage(stage1);
            
            stage1.setEtudiant(etudiant1);
            stage1.setEncadrant(encadrant1);
            
            
            
            Salle salle1 = new Salle("S101", "Salle 101");
            Salle salle2 = new Salle("S102", "Salle 102");
            Jury jury = new Jury("J001", "2024-06-15");
            jury.ajouterMembre(encadrant1);
            jury.ajouterMembre(encadrant2);
            jury.setSalle(salle1);
            /*jury.afficherDetailsJury();*/

            Rapport rapport1 = new Rapport("R001", "Rapport Final AI");
            
            rapport1.setProjet(projet1);
            
            Soutenance soutenance1 = new Soutenance("AB281",etudiant1,jury,salle1,"2024-06-15",rapport1);
            etudiant1.soumettreRapport(rapport1,stage1);
            soutenance1.planifierSoutenance(jury, salle1);
            jury.evaluerSoutenance(etudiant1, 17.5);
            soutenance1.setNoteFinale(17.5);
            rapport1.validerRapport(soutenance1.getNoteFinale());
            soutenance1.afficheDetailsSoutenance();
            
            
            Projet projet2 = new Projet("P002", "Cloud Computing", "2024-02-01", "2024-07-01");
            Stage stage2 = new Stage("S002", entreprise, "2024-03-01", "2024-08-01");
            
            entreprise.ajouterOffreStage(stage2);
            Rapport rapport2 = new Rapport("R002", "Rapport Final Cloud Computing");
            rapport2.setProjet(projet2);
            gestion.affecterProjet(etudiant2, projet2, encadrant2);
            etudiant2.postulerStage(stage2);
            stage2.setEtudiant(etudiant2);
            stage2.setEncadrant(encadrant2);
            
            Soutenance soutenance2 = new Soutenance("CD2327",etudiant2,jury,salle1,"2024-06-17",rapport2);
            etudiant2.soumettreRapport(rapport2,stage2);
            soutenance2.planifierSoutenance(jury, salle2);
            jury.evaluerSoutenance(etudiant2, 18);
            soutenance2.setNoteFinale(18.0);
            rapport2.validerRapport(soutenance2.getNoteFinale());      
            soutenance2.afficheDetailsSoutenance();

        } catch (pfeException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}
