<%@ include file="/WEB-INF/vues/en-tete.jsp" %>

<h2>Liste du materiel</h2>
<a href="${pageContext.request.contextPath}/materiel-form" class="bouton bouton-succes" style="margin-bottom: 15px;">+ Ajouter du materiel</a>

<c:choose>
    <c:when test="${empty listeMateriels}">
        <p style="text-align: center; color: #7f8c8d;">Aucun materiel enregistre.</p>
    </c:when>
    <c:otherwise>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Reference</th>
                    <th>Modele</th>
                    <th>Marque</th>
                    <th>Tarif journalier</th>
                    <th>Stock</th>
                    <th>Disponible</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="materiel" items="${listeMateriels}">
                    <tr>
                        <td>${materiel.identifiant}</td>
                        <td>${materiel.reference}</td>
                        <td>${materiel.modele}</td>
                        <td>${materiel.marque}</td>
                        <td>${materiel.tarif} €</td>
                        <td>${materiel.quantite}</td>
                        <td>${materiel.estDisponible() ? 'Oui' : 'Non'}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/materiel-form?id=${materiel.identifiant}" class="bouton bouton-principal" style="padding: 5px 10px;">Modifier</a>
                            <a href="${pageContext.request.contextPath}/materiel-delete?id=${materiel.identifiant}" class="bouton bouton-danger" style="padding: 5px 10px;" onclick="return confirm('Supprimer ce materiel ?')">Supprimer</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

<%@ include file="/WEB-INF/vues/pied-page.jsp" %>