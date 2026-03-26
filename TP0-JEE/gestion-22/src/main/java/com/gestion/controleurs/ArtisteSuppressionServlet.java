package com.gestion.controleurs;

/**
 * Controleur pour la suppression d'un artiste
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

@WebServlet("/artiste-delete")
public class ArtisteSuppressionServlet extends HttpServlet {

    private GestionStockService service = new GestionStockService();

    @Override
    protected void doGet(HttpServletRequest requete, HttpServletResponse reponse)
            throws ServletException, IOException {
        Long identifiant = Long.parseLong(requete.getParameter("id"));
        service.supprimerArtiste(identifiant);
        reponse.sendRedirect(requete.getContextPath() + "/artistes");
    }
}