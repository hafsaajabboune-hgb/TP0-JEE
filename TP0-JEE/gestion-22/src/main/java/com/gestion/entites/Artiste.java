package com.gestion.entites;

/**
 * Entite representant un artiste (photographe)
 * Classe developpee par : Hafsa
 * Version personnalisee : 22
 */
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "artistes_22")
public class Artiste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identifiant_artiste")
    private Long identifiant;

    @Column(name = "nom_complet", length = 100, nullable = false)
    private String nomComplet;

    @Column(unique = true, nullable = false, length = 150)
    private String courriel;

    @Column(length = 50)
    private String domaine;

    @Column(name = "niveau_competence")
    private Integer niveau;

    @Column(name = "date_inscription")
    private LocalDateTime dateCreation;

    /**
     * Constructeur par defaut requis par Hibernate
     */
    public Artiste() {
        this.dateCreation = LocalDateTime.now();
        this.niveau = 1;
    }

    /**
     * Constructeur avec parametres principaux
     * @param nomComplet Nom complet de l'artiste
     * @param courriel Adresse email
     * @param domaine Specialite/domaine d'activite
     */
    public Artiste(String nomComplet, String courriel, String domaine) {
        this();
        this.nomComplet = nomComplet;
        this.courriel = courriel;
        this.domaine = domaine;
    }

    // ========== ACCESSEURS (GETTERS) ==========
    public Long getIdentifiant() { return identifiant; }
    public String getNomComplet() { return nomComplet; }
    public String getCourriel() { return courriel; }
    public String getDomaine() { return domaine; }
    public Integer getNiveau() { return niveau; }
    public LocalDateTime getDateCreation() { return dateCreation; }

    // ========== MODIFICATEURS (SETTERS) ==========
    public void setIdentifiant(Long identifiant) { this.identifiant = identifiant; }
    public void setNomComplet(String nomComplet) { this.nomComplet = nomComplet; }
    public void setCourriel(String courriel) { this.courriel = courriel; }
    public void setDomaine(String domaine) { this.domaine = domaine; }
    public void setNiveau(Integer niveau) { this.niveau = niveau; }
    public void setDateCreation(LocalDateTime dateCreation) { this.dateCreation = dateCreation; }
}