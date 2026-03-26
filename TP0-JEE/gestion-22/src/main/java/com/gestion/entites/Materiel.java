package com.gestion.entites;

/**
 * Entite representant un materiel (appareil photo)
 * Classe developpee par : Hafsa
 * Version personnalisee : 22
 */
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "materiels_22")
public class Materiel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identifiant_materiel")
    private Long identifiant;

    @Column(unique = true, nullable = false, length = 50)
    private String reference;

    @Column(nullable = false, length = 100)
    private String modele;

    @Column(length = 50)
    private String marque;

    @Column(name = "tarif_journalier")
    private Double tarif;

    @Column(name = "stock_disponible")
    private Integer quantite;

    @Column(name = "actif")
    private Boolean disponible;

    @Column(name = "date_enregistrement")
    private LocalDateTime dateAjout;

    /**
     * Constructeur par defaut
     */
    public Materiel() {
        this.dateAjout = LocalDateTime.now();
        this.quantite = 1;
        this.disponible = true;
    }

    /**
     * Constructeur avec parametres principaux
     * @param reference Reference unique du materiel
     * @param modele Modele du materiel
     * @param marque Marque du materiel
     * @param tarif Tarif de location journalier
     */
    public Materiel(String reference, String modele, String marque, Double tarif) {
        this();
        this.reference = reference;
        this.modele = modele;
        this.marque = marque;
        this.tarif = tarif;
    }

    /**
     * Verifie si le materiel est disponible a la location
     * @return true si disponible, false sinon
     */
    public boolean estDisponible() {
        return quantite != null && quantite > 0 && disponible != null && disponible;
    }

    // ========== ACCESSEURS (GETTERS) ==========
    public Long getIdentifiant() { return identifiant; }
    public String getReference() { return reference; }
    public String getModele() { return modele; }
    public String getMarque() { return marque; }
    public Double getTarif() { return tarif; }
    public Integer getQuantite() { return quantite; }
    public Boolean getDisponible() { return disponible; }
    public LocalDateTime getDateAjout() { return dateAjout; }

    // ========== MODIFICATEURS (SETTERS) ==========
    public void setIdentifiant(Long identifiant) { this.identifiant = identifiant; }
    public void setReference(String reference) { this.reference = reference; }
    public void setModele(String modele) { this.modele = modele; }
    public void setMarque(String marque) { this.marque = marque; }
    public void setTarif(Double tarif) { this.tarif = tarif; }
    public void setQuantite(Integer quantite) { this.quantite = quantite; }
    public void setDisponible(Boolean disponible) { this.disponible = disponible; }
    public void setDateAjout(LocalDateTime dateAjout) { this.dateAjout = dateAjout; }
}