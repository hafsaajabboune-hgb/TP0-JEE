<%@ include file="/WEB-INF/vues/en-tete.jsp" %>

<c:choose>
    <c:when test="${materielCourant != null}">
        <h2>Modifier un materiel</h2>
        <form action="${pageContext.request.contextPath}/materiel-save" method="post">
            <input type="hidden" name="id" value="${materielCourant.identifiant}">
    </c:when>
    <c:otherwise>
        <h2>Ajouter un materiel</h2>
        <form action="${pageContext.request.contextPath}/materiel-save" method="post">
    </c:otherwise>
</c:choose>

<div class="groupe-formulaire">
    <label>Reference unique :</label>
    <input type="text" name="reference" value="${materielCourant.reference}" required>
</div>

<div class="groupe-formulaire">
    <label>Modele :</label>
    <input type="text" name="modele" value="${materielCourant.modele}" required>
</div>

<div class="groupe-formulaire">
    <label>Marque :</label>
    <input type="text" name="marque" value="${materielCourant.marque}">
</div>

<div class="groupe-formulaire">
    <label>Tarif journalier (€) :</label>
    <input type="number" step="0.01" name="tarif" value="${materielCourant.tarif}" required>
</div>

<c:if test="${materielCourant != null}">
    <div class="groupe-formulaire">
        <label>Quantite en stock :</label>
        <input type="number" name="quantite" value="${materielCourant.quantite}" min="0">
    </div>
</c:if>

<button type="submit" class="bouton bouton-succes">Enregistrer</button>
<a href="${pageContext.request.contextPath}/materiels" class="bouton bouton-secondaire">Annuler</a>
</form>

<%@ include file="/WEB-INF/vues/pied-page.jsp" %>