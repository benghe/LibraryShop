<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>	
	<jsp:body>
		<div class="container py-5">
        	<p class="${!empty successMessage ? 'text-success' : 'text-danger'} lead"><i class="${!empty successMessage ? 'fa fa-check-circle' : 'fa fa-times-circle'}" aria-hidden="true"></i>
        		${!empty successMessage ? successMessage : failureMessage}
        	</p>
    	</div>
	</jsp:body>
</t:layout>