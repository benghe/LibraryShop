<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="title">Modifier une commande</jsp:attribute>
	
	<jsp:body>
		
		<form method="POST">
			<div>
				<label>Id de la commande</label>
				<input type="text" name="idCommande" />
			</div>
			
			<div>
				<label>Date de la commande</label>
				<input type="date" name="dateCommande" />
			</div>
			
			<div>
				<label>Id du client</label>
				<input type="number" name="idClient" />
			</div>
			
			<div>
				<label>montant de la commande</label>
				<input type="number" name="montantCommande" />
			</div>
			
			<input type="submit" value="Modifier" />
		</form>
		
	</jsp:body>
</t:layout>