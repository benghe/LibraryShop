<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:body>
		 <div class="container mt-5">
		     <div class="row justify-content-center">
		           <div class="col-md-6">
		               <div class="card">
		                   <header class="card-header">
		                       <h4 class="card-title mt-2 text-center">Inscription</h4>
		                   </header>
		                   <article class="card-body">
		                   	<form method="post" action="register">
	                        	<c:if test="${!empty failureMessage}">
	                        		<div class="alert alert-danger">${ failureMessage }</div>
	                        	</c:if>
	                        	<c:if test="${!empty successMessage}">
	                        		<div class="alert alert-success">${ successMessage }</div>
	                        	</c:if>
	                            <div class="form-group mt-2">
	                                <div class="input-group input-group-lg">
	                                    <input type="text" name="login" id="login"
	                                           class="form-control" placeholder="Nom d'utilisateur" required autofocus>
	                                </div>
	                            </div>
	                            <div class="form-group mt-4">
	                                <div class="input-group input-group-lg">
	                                    <input type="password" name="password" id="password"
	                                           class="form-control" placeholder="Mot de passe" required>
	                                </div>
	                            </div>
	                            <div class="form-group mt-4">
	                                <div class="input-group input-group-lg">
	                                    <input type="nom" name="nom" id="nom"
	                                           class="form-control" placeholder="Nom" required>
	                                </div>
	                            </div>
	                            <div class="form-group mt-4">
	                                <div class="input-group input-group-lg">
	                                    <input type="prenom" name="prenom" id="prenom"
	                                           class="form-control" placeholder="Prénom" required>
	                                </div>
	                            </div>
	                            <div class="form-group mt-4">
	                                <div class="input-group input-group-lg">
	                                    <input type="adresse" name="adresse" id="adresse"
	                                           class="form-control" placeholder="Adresse" required>
	                                </div>
	                            </div>
	                            <div class="form-group mt-5">
	                                <button type="submit" class="btn btn-primary btn-block btn-lg"> S'inscrire </button>
	                            </div>
	                        </form>
		                   </article>
		               </div>
		           </div>
		       </div>
		   </div>
	</jsp:body>
</t:layout>