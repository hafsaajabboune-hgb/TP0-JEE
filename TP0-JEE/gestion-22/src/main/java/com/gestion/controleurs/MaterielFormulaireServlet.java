package com.gestion.controleurs;

/**
 * Controleur pour le formulaire d'ajout/modification de materiel
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
import java.util.Optional;

@WebServlet("/materiel-form")
public class MaterielFormulaireServlet extends HttpServlet {

    private GestionStockService service = new GestionStockService();

    @Override
    protected void doGet(HttpServletRequest requete, HttpServletResponse reponse)
            throws ServletException, IOException {
        String parametreId = requete.getParameter("id");
        if (parametreId != null && !parametreId.isEmpty()) {
            Optional<Materiel> materiel = service.obtenirMaterielParId(Long.parseLong(parametreId));
            materiel.ifPresent(m -> requete.setAttribute("materielCourant", m));
        }
        requete.getRequestDispatcher("/WEB-INF/vues/materiels/formulaire.jsp").forward(requete, reponse);
    }
}