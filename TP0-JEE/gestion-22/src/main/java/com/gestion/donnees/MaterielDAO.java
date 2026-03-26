package com.gestion.donnees;

/**
 * DAO specifique pour l'entite Materiel
 * Developpe par : Hafsa
 * Version personnalisee : 22
 */
import com.gestion.entites.Materiel;
import com.gestion.utilitaires.ConnexionBD;
import org.hibernate.Session;
import java.util.List;
import java.util.Optional;

public class MaterielDAO extends CRUDAbstract<Materiel, Long> {

    /**
     * Recherche un materiel par sa reference unique
     * @param reference Reference a rechercher
     * @return Optional contenant le materiel si trouve
     */
    public Optional<Materiel> rechercherParReference(String reference) {
        try (Session session = ConnexionBD.obtenirUsineSession().openSession()) {
            String requete = "from Materiel where reference = :ref";
            return session.createQuery(requete, Materiel.class)
                    .setParameter("ref", reference)
                    .uniqueResultOptional();
        } catch (Exception e) {
            System.err.println("Erreur lors de la recherche par reference: " + e.getMessage());
            return Optional.empty();
        }
    }

    /**
     * Liste tous les materiels disponibles a la location
     * @return Liste des materiels disponibles
     */
    public List<Materiel> listerDisponibles() {
        try (Session session = ConnexionBD.obtenirUsineSession().openSession()) {
            String requete = "from Materiel where quantite > 0 and disponible = true";
            return session.createQuery(requete, Materiel.class).list();
        } catch (Exception e) {
            System.err.println("Erreur lors du listage des disponibles: " + e.getMessage());
            return List.of();
        }
    }

    /**
     * Recherche des materiels par marque
     * @param marque Marque a rechercher
     * @return Liste des materiels correspondants
     */
    public List<Materiel> rechercherParMarque(String marque) {
        try (Session session = ConnexionBD.obtenirUsineSession().openSession()) {
            String requete = "from Materiel where lower(marque) = :marque";
            return session.createQuery(requete, Materiel.class)
                    .setParameter("marque", marque.toLowerCase())
                    .list();
        } catch (Exception e) {
            System.err.println("Erreur lors de la recherche par marque: " + e.getMessage());
            return List.of();
        }
    }
}