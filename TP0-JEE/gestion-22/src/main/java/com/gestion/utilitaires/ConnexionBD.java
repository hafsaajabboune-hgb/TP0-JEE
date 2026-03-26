package com.gestion.utilitaires;

/**
 * Classe utilitaire pour la gestion de la connexion a la base de donnees
 * Developpee par : Hafsa
 * Version : 22.0
 * Date : Mars 2025
 */
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnexionBD {

    private static final SessionFactory usineSession = construireUsineSession();

    private static SessionFactory construireUsineSession() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable erreur) {
            System.err.println("Erreur d'initialisation de la base de donnees: " + erreur);
            throw new ExceptionInInitializerError(erreur);
        }
    }

    /**
     * Retourne l'usine de sessions Hibernate
     * @return SessionFactory
     */
    public static SessionFactory obtenirUsineSession() {
        return usineSession;
    }

    /**
     * Ferme proprement la connexion a la base de donnees
     */
    public static void fermerConnexion() {
        if (usineSession != null) {
            usineSession.close();
        }
    }
}