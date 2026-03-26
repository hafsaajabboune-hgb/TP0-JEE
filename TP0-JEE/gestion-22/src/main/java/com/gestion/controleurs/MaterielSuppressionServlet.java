package com.gestion.controleurs;

/**
 * Controleur pour la suppression d'un materiel
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

@WebServlet("/materiel-delete")
public class MaterielSuppressionServlet extends HttpServlet {

    private GestionStockService service = new GestionStockService();

    @Override
    protected void doGet(HttpServletRequest requete, HttpServletResponse reponse)
            throws ServletException, IOException {
        Long identifiant = Long.parseLong(requete.getParameter("id"));
        service.supprimerMateriel(identifiant);
        reponse.sendRedirect(requete.getContextPath() + "/materiels");
    }
}