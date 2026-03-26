package com.gestion.donnees;

/**
 * DAO specifique pour l'entite Artiste
 * Developpe par : Hafsa
 * Version personnalisee : 22
 */
import com.gestion.entites.Artiste;
import com.gestion.utilitaires.ConnexionBD;
import org.hibernate.Session;
import java.util.Optional;

public class ArtisteDAO extends CRUDAbstract<Artiste, Long> {

    /**
     * Recherche un artiste par son adresse email
     * @param courriel Adresse email a rechercher
     * @return Optional contenant l'artiste si trouve
     */
    public Optional<Artiste> rechercherParCourriel(String courriel) {
        try (Session session = ConnexionBD.obtenirUsineSession().openSession()) {
            String requete = "from Artiste where courriel = :courriel";
            return session.createQuery(requete, Artiste.class)
                    .setParameter("courriel", courriel)
                    .uniqueResultOptional();
        } catch (Exception e) {
            System.err.println("Erreur lors de la recherche par email: " + e.getMessage());
            return Optional.empty();
        }
    }
}