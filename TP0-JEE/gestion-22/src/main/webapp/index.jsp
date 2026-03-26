<%@ include file="/WEB-INF/vues/en-tete.jsp" %>

<div class="message-accueil">
    <h2>Bienvenue sur l'application de gestion de stock</h2>
    <p style="margin: 20px 0; font-size: 18px;">Cette application permet de gerer :</p>
    <ul style="list-style: none; margin: 20px 0;">
        <li style="margin: 10px 0;">Les artistes et leurs informations</li>
        <li style="margin: 10px 0;">Le materiel disponible a la location</li>
    </ul>
    <div style="display: flex; gap: 20px; justify-content: center; margin-top: 30px;">
        <a href="${pageContext.request.contextPath}/artistes" class="bouton bouton-principal" style="padding: 12px 25px;">Voir les artistes</a>
        <a href="${pageContext.request.contextPath}/artiste-form" class="bouton bouton-succes" style="padding: 12px 25px;">Ajouter un artiste</a>
        <a href="${pageContext.request.contextPath}/materiels" class="bouton bouton-principal" style="padding: 12px 25px;">Voir le materiel</a>
        <a href="${pageContext.request.contextPath}/materiel-form" class="bouton bouton-succes" style="padding: 12px 25px;">Ajouter du materiel</a>
    </div>
</div>

<%@ include file="/WEB-INF/vues/pied-page.jsp" %>