<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="title">Liste des commandes</jsp:attribute>
	
	<jsp:body>
		<a class="btn btn-success btn-block" href="commande-ajouter">Ajouter une commande</a>
		
		<table class="table table-striped mt-5">
			<thead>
				<tr>
					<th>IdCommande</th>
					<th>dateCommande</th>
					<th>IdClient</th>
					<th>montantCommande</th>
			</thead>
			
			<tbody>
				<c:forEach var="commande" items="${ commandes }">
					<tr>
						<td>${ commande.id }</td>
						<td>${ commande.date }</td>
						<td>${ commande.clientId }</td>
						<td>${ commande.montant }</td>
						<td>
							<a class="btn btn-warning" href="commande-modifier?id=${ commande.id }">Modifier</a>
							<a class="btn btn-danger" href="commande-supprimer?id=${ commande.id }">Supprimer</a>
						</td>
				</c:forEach>
			</tbody>
		</table>
	</jsp:body>
</t:layout>