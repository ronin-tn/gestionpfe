package pfe;

public class Soutenance {
	private String ID;
    private Etudiant etudiant;
    private Jury jury;
    private Salle salle;
    private String date;
    private Rapport rapport;
    private double notefinale;

    public Soutenance(String id,Etudiant etudiant,Jury J,Salle S,String D,Rapport R) {
        this.ID=id;
    	this.etudiant = etudiant;
        this.jury=J;
        this.salle=S;
        this.date=D;
        this.rapport=R;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Jury getJury() {
        return jury;
    }

    public void setJury(Jury jury) {
        this.jury = jury;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public Rapport getRapport() {
        return rapport;
    }

    public void setDate(Rapport R) {
        this.rapport = R;
    }
    
    public void setNoteFinale(double note) {
        this.notefinale = note;
        }
    public double getNoteFinale()
    {
    	return notefinale;
    }
    public void planifierSoutenance(Jury jury, Salle salle) {
        if (salle.verifierDisponibilite(this.date)) {
            this.jury = jury;
            this.salle = salle;
            salle.reserverSalle(date);
            System.out.println("=========================================");
            System.out.println("Soutenance planifiée pour " + etudiant.getNom() + " le " + date);
            System.out.println("=========================================");
        } else {
        	System.out.println("=========================================");
            System.out.println("La soutenance de " + etudiant.getNom() + " " + etudiant.getPrenom() + " ne peut pas être planifiée à " + date + " car la salle est déjà réservée.");
            System.out.println("=========================================");
        }
    }
    public void afficheDetailsSoutenance() {
    	System.out.println("=========================================");
        System.out.println("Détails de la Soutenance "+ID);
        System.out.println("Date de la soutenance :" + date);
        System.out.println("Salle : "+(salle != null ? salle.getNom():"Aucune salle attribuée"));
        System.out.println("\n--- Étudiant ---");
        etudiant.affiche_etudiant();
        System.out.println("\n--- Jury ---");
        if (jury != null) {
            jury.afficherDetailsJury();
        } else {
            System.out.println("Aucun jury assigné.");
        }
        System.out.println("\n--- Rapport ---");
        System.out.println("- Identifiant : "+rapport.getIdentifiant());
        System.out.println("- Titre : " +rapport.getTitre());
        System.out.println("- Statut : "+rapport.getStatut());
        System.out.println("- Note : " +rapport.getNote());
        System.out.println("- Validé : "+(rapport.estValide()?"Oui" : "Non"));
        System.out.println("=========================================");
        
    }

    
}
