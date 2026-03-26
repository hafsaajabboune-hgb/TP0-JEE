package com.gestion.donnees;

/**
 * Implementation abstraite generique des operations CRUD
 * Developpee par : Hafsa
 * Version : 22
 */
import com.gestion.utilitaires.ConnexionBD;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

public abstract class CRUDAbstract<T, I> implements CRUDOperations<T, I> {

    protected Class<T> classeEntite;

    @SuppressWarnings("unchecked")
    public CRUDAbstract() {
        this.classeEntite = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Override
    public void enregistrer(T entite) {
        Transaction transaction = null;
        try (Session session = ConnexionBD.obtenirUsineSession().openSession()) {
            transaction = session.beginTransaction();
            session.persist(entite);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Erreur lors de l'enregistrement: " + e.getMessage());
        }
    }

    @Override
    public List<T> listerTous() {
        try (Session session = ConnexionBD.obtenirUsineSession().openSession()) {
            String requete = "from " + classeEntite.getSimpleName();
            return session.createQuery(requete, classeEntite).list();
        } catch (Exception e) {
            System.err.println("Erreur lors du listage: " + e.getMessage());
            return List.of();
        }
    }

    @Override
    public Optional<T> trouverParIdentifiant(I identifiant) {
        try (Session session = ConnexionBD.obtenirUsineSession().openSession()) {
            return Optional.ofNullable(session.get(classeEntite, identifiant));
        } catch (Exception e) {
            System.err.println("Erreur lors de la recherche: " + e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public void actualiser(T entite) {
        Transaction transaction = null;
        try (Session session = ConnexionBD.obtenirUsineSession().openSession()) {
            transaction = session.beginTransaction();
            session.merge(entite);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Erreur lors de la mise a jour: " + e.getMessage());
        }
    }

    @Override
    public void supprimer(I identifiant) {
        Transaction transaction = null;
        try (Session session = ConnexionBD.obtenirUsineSession().openSession()) {
            transaction = session.beginTransaction();
            T entite = session.get(classeEntite, identifiant);
            if (entite != null) {
                session.remove(entite);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Erreur lors de la suppression: " + e.getMessage());
        }
    }
}