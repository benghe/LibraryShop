<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:body>
		 <div class="container mt-5">
	        <div class="row justify-content-center">
	            <div class="col-md-6">
	                <div class="card">
	                    <header class="card-header">
	                        <h4 class="card-title mt-2 text-center">S'identifier</h4>
	                    </header>
	                    <article class="card-body">
	                        <form method="post" action="login">
	                        	<c:if test="${!empty loginError}">
	                        		<div class="alert alert-danger">${ loginError }</div>
	                        	</c:if>
	                            <div class="form-group mt-2">
	                                <div class="input-group input-group-lg">
	                                    <div class="input-group-prepend">
	                                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
	                                    </div>
	                                    <input type="text" name="login" id="email"
	                                           class="form-control" placeholder="Nom d'utilisateur" required autofocus>
	                                </div>
	                            </div>
	                            <div class="form-group mt-4">
	                                <div class="input-group input-group-lg">
	                                    <div class="input-group-prepend">
	                                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
	                                    </div>
	                                    <input type="password" name="password" id="password"
	                                           class="form-control" placeholder="Mot de passe" required>
	                                </div>
	                            </div>
	                            <div class="form-group mt-5">
	                                <button type="submit" class="btn btn-primary btn-block btn-lg"> S'identifier </button>
	                            </div>
	                        </form>
	                    </article>
	                </div>
	            </div>
	        </div>
	    </div>
	</jsp:body>
</t:layout>