<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<t:layout>
	<jsp:body>
		<div class="container">
	        <div class="py-5 text-left">
	            <h2>Mon Profil</h2>
	        </div>
	        <div class="row">
	            <div class="col-md-12 order-md-1">
	                <form class="needs-validation" method="get" action="profile-update" >
	                    <div class="row">
	                        <div class="col-md-6 mb-3">
	                            <label for="nom">Nom</label>
            					<input type="text" class="form-control" id="nom" name="nom"  placeholder="" value="${sessionScope['currentUser'].nom}" required>
	                            <div class="invalid-feedback">
	                                Valid first name is required.
	                            </div>
	                        </div>
	                        <div class="col-md-6 mb-3">
	                            <label for="prenom">Prénom</label>
            					<input type="text" class="form-control" id="prenom" name="prenom" placeholder="" value="${sessionScope['currentUser'].prenom}" required>
	                            <div class="invalid-feedback">
	                                Valid last name is required.
	                            </div>
	                        </div>
	                    </div>
	
	                    <div class="mb-3">
	                        <label for="username">E-mail</label>
	                        <div class="input-group">
	                            <div class="input-group-prepend">
	                                <span class="input-group-text">@</span>
	                            </div>
	                            <input type="email" class="form-control" id="username" placeholder="monadresse@example.com" value="${sessionScope['currentUser'].login}@example.com" required>
	                            <div class="invalid-feedback" style="width: 100%;">
	                                Your username is required.
	                            </div>
	                        </div>
	                    </div>
	
	                    <div class="mb-3">
	                        <label for="addresse">Addresse</label>
          					<input type="text" class="form-control" name="adresse" value="${sessionScope['currentUser'].adresse}" id="addresse" placeholder="" required>
	                        <div class="invalid-feedback">
	                            Please enter your shipping address.
	                        </div>
	                    </div>
	
	                    <div class="d-none">
          					<input type="text" class="form-control" name="modifiedObjectId" value="${sessionScope['currentUser'].id}" id="modifiedObjectId" placeholder="" required>
	                    </div>
	
	                    <div class="row">
	                        <div class="col-md-3 mb-3">
	                            <label for="zip">Téléphone</label>
          						<input type="text" class="form-control" value="" id="address" placeholder="" required>
	                            <div class="invalid-feedback">
	                                Zip code required.
	                            </div>
	                        </div>
	
	                        <div class="col-md-4 mb-3">
	                            <label for="zip">Code Postal</label>
          						<input type="text" class="form-control" value="" id="address" placeholder="" required>
	                            <div class="invalid-feedback">
	                                Zip code required.
	                            </div>
	                        </div>
	
	                        <div class="col-md-5 mb-3">
	                            <label for="zip">Ville</label>
          						<input type="text" class="form-control" value="" id="address" placeholder="" required>
	                            <div class="invalid-feedback">
	                                City code required.
	                            </div>
	                        </div>
	                    </div>
	                    <hr class="mb-4">
	                    <button class="btn btn-secondary btn-lg btn-block" type="submit">Modifier mes informations</button>
	                </form>
	            </div>
	        </div>
	    </div>
	</jsp:body>
</t:layout>