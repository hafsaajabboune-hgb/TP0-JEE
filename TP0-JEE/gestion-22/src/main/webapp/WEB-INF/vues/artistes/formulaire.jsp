<%@ include file="/WEB-INF/vues/en-tete.jsp" %>

<c:choose>
    <c:when test="${artisteCourant != null}">
        <h2>Modifier un artiste</h2>
        <form action="${pageContext.request.contextPath}/artiste-save" method="post">
            <input type="hidden" name="id" value="${artisteCourant.identifiant}">
    </c:when>
    <c:otherwise>
        <h2>Ajouter un artiste</h2>
        <form action="${pageContext.request.contextPath}/artiste-save" method="post">
    </c:otherwise>
</c:choose>

<div class="groupe-formulaire">
    <label>Nom complet :</label>
    <input type="text" name="nomComplet" value="${artisteCourant.nomComplet}" required>
</div>

<div class="groupe-formulaire">
    <label>Courriel :</label>
    <input type="email" name="courriel" value="${artisteCourant.courriel}" required>
</div>

<div class="groupe-formulaire">
    <label>Domaine / Specialite :</label>
    <input type="text" name="domaine" value="${artisteCourant.domaine}">
</div>

<c:if test="${artisteCourant != null}">
    <div class="groupe-formulaire">
        <label>Niveau de competence (1-5) :</label>
        <input type="number" name="niveau" value="${artisteCourant.niveau}" min="1" max="5">
    </div>
</c:if>

<button type="submit" class="bouton bouton-succes">Enregistrer</button>
<a href="${pageContext.request.contextPath}/artistes" class="bouton bouton-secondaire">Annuler</a>
</form>

<%@ include file="/WEB-INF/vues/pied-page.jsp" %>