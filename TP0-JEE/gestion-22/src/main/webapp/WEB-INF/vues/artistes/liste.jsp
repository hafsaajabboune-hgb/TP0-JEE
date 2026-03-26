<%@ include file="/WEB-INF/vues/en-tete.jsp" %>

<h2>Liste des artistes</h2>
<a href="${pageContext.request.contextPath}/artiste-form" class="bouton bouton-succes" style="margin-bottom: 15px;">+ Nouvel artiste</a>

<c:choose>
    <c:when test="${empty listeArtistes}">
        <p style="text-align: center; color: #7f8c8d;">Aucun artiste enregistre.</p>
    </c:when>
    <c:otherwise>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom complet</th>
                    <th>Courriel</th>
                    <th>Domaine</th>
                    <th>Niveau</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="artiste" items="${listeArtistes}">
                    <tr>
                        <td>${artiste.identifiant}</td>
                        <td>${artiste.nomComplet}</td>
                        <td>${artiste.courriel}</td>
                        <td>${artiste.domaine != null ? artiste.domaine : '-'}</td>
                        <td>${artiste.niveau}/5</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/artiste-form?id=${artiste.identifiant}" class="bouton bouton-principal" style="padding: 5px 10px;">Modifier</a>
                            <a href="${pageContext.request.contextPath}/artiste-delete?id=${artiste.identifiant}" class="bouton bouton-danger" style="padding: 5px 10px;" onclick="return confirm('Supprimer cet artiste ?')">Supprimer</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

<%@ include file="/WEB-INF/vues/pied-page.jsp" %>