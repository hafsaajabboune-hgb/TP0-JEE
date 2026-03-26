package com.gestion.controleurs;

/**
 * Controleur pour l'affichage de la liste des artistes
 * Developpe par : Hafsa
 * Version : 22
 */
import com.gestion.services.GestionStockService;
import com.gestion.entites.Artiste;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/artistes")
public class ArtisteListeServlet extends HttpServlet {

    private GestionStockService service = new GestionStockService();

    @Override
    protected void doGet(HttpServletRequest requete, HttpServletResponse reponse)
            throws ServletException, IOException {
        List<Artiste> artistes = service.obtenirTousArtistes();
        requete.setAttribute("listeArtistes", artistes);
        requete.getRequestDispatcher("/WEB-INF/vues/artistes/liste.jsp").forward(requete, reponse);
    }
}