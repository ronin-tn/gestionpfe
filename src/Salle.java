package pfe;
import java.util.ArrayList;
public class Salle {
    private String identifiant;
    private String nom;
    private boolean estDisponible;
    private ArrayList<String> datesReservees;
    public Salle(String identifiant,String nom) {
        this.identifiant=identifiant;
        this.nom=nom;
        this.estDisponible = true;
        this.datesReservees=new ArrayList<>();
    }
    public String getIdentifiant() {
        return identifiant;
    }
    public String getNom() {
        return nom;
    }
    public boolean verifierDisponibilite(String date) {
        return !datesReservees.contains(date);
    }

    public void reserverSalle(String date) {
        if (verifierDisponibilite(date)) {
            datesReservees.add(date);
        } else {
        	System.out.println("=========================================");
            System.out.println("La salle " + nom + " est déjà réservée pour la date : " + date);
            System.out.println("=========================================");
        }
    }
    public void afficherDetailsSalle() {
        System.out.println("Salle: " + nom);
        System.out.println("Identifiant: " + identifiant);
        System.out.println("Disponibilité: " + (estDisponible ? "Disponible" : "Indisponible"));
    }
}