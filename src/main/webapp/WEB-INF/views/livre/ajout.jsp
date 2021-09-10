<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>

	
	<jsp:body>
		
		<form method="POST">
			<div>
				<label>Titre</label>
				<input type="text" name="titre" />
			</div>
			
			<div>
				<label>Auteur</label>
				<input type="text" name="auteur" />
			</div>
			
			<div>
				<label>Prix</label>
				<input type="number" name="prix" />
			</div>
			
			<div>
				<label>Photo de couverture</label>
				<input type="text" name="photo" />
			</div>
			
			<div>
				<label>Résumé</label>
				<input type="text" name="resume" />
			</div>
			
			<input type="submit" value="Ajouter" />

		</form>
		
	</jsp:body>
</t:layout>