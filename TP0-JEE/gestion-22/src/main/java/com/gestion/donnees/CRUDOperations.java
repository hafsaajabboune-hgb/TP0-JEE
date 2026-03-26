package com.gestion.donnees;

/**
 * Interface generique pour les operations d'acces aux donnees
 * Developpee par : Hafsa
 * Version : 22
 */
import java.util.List;
import java.util.Optional;

public interface CRUDOperations<T, I> {

    /**
     * Sauvegarde une entite en base de donnees
     * @param entite L'entite a sauvegarder
     */
    void enregistrer(T entite);

    /**
     * Recupere toutes les entites
     * @return Liste de toutes les entites
     */
    List<T> listerTous();

    /**
     * Recherche une entite par son identifiant
     * @param identifiant L'identifiant de l'entite
     * @return Optional contenant l'entite si trouvee
     */
    Optional<T> trouverParIdentifiant(I identifiant);

    /**
     * Met a jour une entite existante
     * @param entite L'entite a mettre a jour
     */
    void actualiser(T entite);

    /**
     * Supprime une entite par son identifiant
     * @param identifiant L'identifiant de l'entite a supprimer
     */
    void supprimer(I identifiant);
}