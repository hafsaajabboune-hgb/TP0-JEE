package com.gestion.services;

/**
 * Service de gestion du stock et des artistes
 * Developpe par : Hafsa
 * Version personnalisee : 22
 */
import com.gestion.donnees.*;
import com.gestion.entites.*;
import java.util.List;
import java.util.Optional;

public class GestionStockService {

    private ArtisteDAO artisteDAO = new ArtisteDAO();
    private MaterielDAO materielDAO = new MaterielDAO();

    // ==================== GESTION DES ARTISTES ====================

    /**
     * Inscrit un nouvel artiste dans le systeme
     * @param nomComplet Nom complet de l'artiste
     * @param courriel Adresse email
     * @param domaine Domaine de specialite
     * @return L'artiste cree
     */
    public Artiste inscrireArtiste(String nomComplet, String courriel, String domaine) {
        Artiste artiste = new Artiste(nomComplet, courriel, domaine);
        artisteDAO.enregistrer(artiste);
        return artiste;
    }

    /**
     * Recupere la liste complete des artistes
     * @return Liste des artistes
     */
    public List<Artiste> obtenirTousArtistes() {
        return artisteDAO.listerTous();
    }

    /**
     * Recherche un artiste par son identifiant
     * @param identifiant L'identifiant de l'artiste
     * @return Optional contenant l'artiste si trouve
     */
    public Optional<Artiste> obtenirArtisteParId(Long identifiant) {
        return artisteDAO.trouverParIdentifiant(identifiant);
    }

    /**
     * Modifie les informations d'un artiste existant
     * @param identifiant Identifiant de l'artiste
     * @param nomComplet Nouveau nom complet
     * @param courriel Nouvel email
     * @param domaine Nouveau domaine
     * @param niveau Nouveau niveau de competence
     */
    public void modifierArtiste(Long identifiant, String nomComplet, String courriel,
                                String domaine, Integer niveau) {
        artisteDAO.trouverParIdentifiant(identifiant).ifPresent(artiste -> {
            artiste.setNomComplet(nomComplet);
            artiste.setCourriel(courriel);
            artiste.setDomaine(domaine);
            if (niveau != null) {
                artiste.setNiveau(niveau);
            }
            artisteDAO.actualiser(artiste);
        });
    }

    /**
     * Supprime un artiste du systeme
     * @param identifiant Identifiant de l'artiste a supprimer
     */
    public void supprimerArtiste(Long identifiant) {
        artisteDAO.supprimer(identifiant);
    }

    // ==================== GESTION DES MATERIELS ====================

    /**
     * Ajoute un nouveau materiel au stock
     * @param reference Reference unique
     * @param modele Modele du materiel
     * @param marque Marque du materiel
     * @param tarif Tarif journalier
     * @return Le materiel cree
     */
    public Materiel ajouterMateriel(String reference, String modele, String marque, Double tarif) {
        Materiel materiel = new Materiel(reference, modele, marque, tarif);
        materielDAO.enregistrer(materiel);
        return materiel;
    }

    /**
     * Recupere la liste complete des materiels
     * @return Liste des materiels
     */
    public List<Materiel> obtenirTousMateriels() {
        return materielDAO.listerTous();
    }

    /**
     * Recupere la liste des materiels disponibles
     * @return Liste des materiels disponibles
     */
    public List<Materiel> obtenirMaterielsDisponibles() {
        return materielDAO.listerDisponibles();
    }

    /**
     * Recherche un materiel par son identifiant
     * @param identifiant Identifiant du materiel
     * @return Optional contenant le materiel si trouve
     */
    public Optional<Materiel> obtenirMaterielParId(Long identifiant) {
        return materielDAO.trouverParIdentifiant(identifiant);
    }

    /**
     * Modifie les informations d'un materiel
     * @param identifiant Identifiant du materiel
     * @param modele Nouveau modele
     * @param marque Nouvelle marque
     * @param tarif Nouveau tarif
     * @param quantite Nouvelle quantite en stock
     */
    public void modifierMateriel(Long identifiant, String modele, String marque,
                                 Double tarif, Integer quantite) {
        materielDAO.trouverParIdentifiant(identifiant).ifPresent(materiel -> {
            materiel.setModele(modele);
            materiel.setMarque(marque);
            materiel.setTarif(tarif);
            materiel.setQuantite(quantite);
            materiel.setDisponible(quantite > 0);
            materielDAO.actualiser(materiel);
        });
    }

    /**
     * Supprime un materiel du stock
     * @param identifiant Identifiant du materiel a supprimer
     */
    public void supprimerMateriel(Long identifiant) {
        materielDAO.supprimer(identifiant);
    }

    // ==================== STATISTIQUES ====================

    /**
     * Obtient le nombre total d'artistes
     * @return Nombre d'artistes
     */
    public long compterArtistes() {
        return artisteDAO.listerTous().size();
    }

    /**
     * Obtient le nombre total de materiels
     * @return Nombre de materiels
     */
    public long compterMateriels() {
        return materielDAO.listerTous().size();
    }
}