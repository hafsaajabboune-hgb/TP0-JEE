package com.gestion.controleurs;

/**
 * Controleur pour l'affichage de la liste des materiels
 * Developpe par : Hafsa
 * Version : 22
 */
import com.gestion.services.GestionStockService;
import com.gestion.entites.Materiel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/materiels")
public class MaterielListeServlet extends HttpServlet {

    private GestionStockService service = new GestionStockService();

    @Override
    protected void doGet(HttpServletRequest requete, HttpServletResponse reponse)
            throws ServletException, IOException {
        List<Materiel> materiels = service.obtenirTousMateriels();
        requete.setAttribute("listeMateriels", materiels);
        requete.getRequestDispatcher("/WEB-INF/vues/materiels/liste.jsp").forward(requete, reponse);
    }
}