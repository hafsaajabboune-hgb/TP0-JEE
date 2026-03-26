package com.gestion.controleurs;

/**
 * Controleur pour la sauvegarde d'un artiste (creation ou modification)
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

@WebServlet("/artiste-save")
public class ArtisteSauvegardeServlet extends HttpServlet {

    private GestionStockService service = new GestionStockService();

    @Override
    protected void doPost(HttpServletRequest requete, HttpServletResponse reponse)
            throws ServletException, IOException {

        String parametreId = requete.getParameter("id");
        String nomComplet = requete.getParameter("nomComplet");
        String courriel = requete.getParameter("courriel");
        String domaine = requete.getParameter("domaine");

        if (parametreId == null || parametreId.isEmpty()) {
            // Creation d'un nouvel artiste
            service.inscrireArtiste(nomComplet, courriel, domaine);
        } else {
            // Modification d'un artiste existant
            String parametreNiveau = requete.getParameter("niveau");
            Integer niveau = (parametreNiveau != null && !parametreNiveau.isEmpty())
                    ? Integer.parseInt(parametreNiveau) : null;
            service.modifierArtiste(Long.parseLong(parametreId), nomComplet, courriel, domaine, niveau);
        }

        reponse.sendRedirect(requete.getContextPath() + "/artistes");
    }
}