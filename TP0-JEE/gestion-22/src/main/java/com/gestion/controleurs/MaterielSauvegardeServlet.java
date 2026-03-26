package com.gestion.controleurs;

/**
 * Controleur pour la sauvegarde d'un materiel (creation ou modification)
 * Developpe par : Hafsa
 * Version : 22
 */
import com.gestion.services.GestionStockService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/materiel-save")
public class MaterielSauvegardeServlet extends HttpServlet {

    private GestionStockService service = new GestionStockService();

    @Override
    protected void doPost(HttpServletRequest requete, HttpServletResponse reponse)
            throws ServletException, IOException {

        String parametreId = requete.getParameter("id");
        String reference = requete.getParameter("reference");
        String modele = requete.getParameter("modele");
        String marque = requete.getParameter("marque");
        Double tarif = Double.parseDouble(requete.getParameter("tarif"));

        if (parametreId == null || parametreId.isEmpty()) {
            // Creation d'un nouveau materiel
            service.ajouterMateriel(reference, modele, marque, tarif);
        } else {
            // Modification d'un materiel existant
            String parametreQuantite = requete.getParameter("quantite");
            Integer quantite = (parametreQuantite != null && !parametreQuantite.isEmpty())
                    ? Integer.parseInt(parametreQuantite) : 1;
            service.modifierMateriel(Long.parseLong(parametreId), modele, marque, tarif, quantite);
        }

        reponse.sendRedirect(requete.getContextPath() + "/materiels");
    }
}