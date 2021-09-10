<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<t:layout>
	<jsp:body>
		<div class="container">
	        <div class="py-5 text-center">
	
	            <h2>Commande</h2>
	            <p class="lead">Veuillez renseigner les informations permettant de finaliser votre commande.</p>
	            <p class="text-primary lead"><i class="fa fa-info-circle" aria-hidden="true"></i> La livraison est offerte durant la période de crise sanitaire du COVID-19 !</p>
	        </div>
	
	        <div class="row">
	            <div class="col-md-4 order-md-2 mb-4">
	                <h4 class="d-flex justify-content-between align-items-center mb-3">
	                    <span class="text-muted">Votre panier</span>
	                    <span class="badge badge-secondary badge-pill">${sessionScope['detailedCart'].size()}</span>
	                </h4>
	                <ul class="list-group mb-3">
	                    <c:forEach var="item" items="${sessionScope['detailedCart']}">	                    
	                        <li class="list-group-item d-flex justify-content-between lh-condensed">
	                            <div class="d-flex">
	                                <small class="text-muted mr-2 p-0">
	                                    <a role="button" class="m-0 p-0 btn btn-link text-right text-danger" style="text-decoration: none" href="panier-retirer?livreId=${ item.key.id }">X</a>
	                                </small>
	                                <div class="m-0 p-0">
	                                    <h6 class="my-0">${ item.key.titre } x ${ sessionScope['cart'].get(item.key.id) }</h6>
	                                    <small class="text-muted">${ item.key.auteur }</small>
	                                </div>
	                            </div>
	                            <span class="text-muted"><fmt:formatNumber value="${ item.key.prix * sessionScope['cart'].get(item.key.id) }" type="currency"/></span>
	                        </li>
	                    </c:forEach>
	                    <li class="list-group-item d-flex justify-content-between">
	                        <span>Sous-total</span>
	                        <strong><fmt:formatNumber value="${ sessionScope['totalPanier'] }" type="currency"/></strong>
	                    </li>
	                    <li class="list-group-item d-flex justify-content-between bg-light">
	                        <div class="text-success">
	                            <h6 class="my-0">TVA</h6>
	                            <small>20%</small>
	                        </div>
	                        <span class="text-success">+ <fmt:formatNumber value="${ sessionScope['totalPanier'] * 0.20 }" type="currency"/></span>
	                    </li>
	                    <li class="list-group-item d-flex justify-content-between bg-light">
	                        <div class="text-success">
	                            <h6 class="my-0">Livraison</h6>
	                        </div>
	                        <span class="text-success">Offerte</span>
	                    </li>
	                    <li class="list-group-item d-flex justify-content-between">
	                        <span>Total à payer (TTC)</span>
	                        <strong>
	                        	<fmt:formatNumber value="${ sessionScope['totalPanier'] + (sessionScope['totalPanier'] * 0.20) }" type="currency"/>
	                        </strong>
	                    </li>
	                </ul>
	            </div>
	            <div class="col-md-8 order-md-1">
	                <h4 class="mb-3">Données de facturation</h4>
	                <form class="needs-validation" method="post" action="confirm-order" >
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
	
	                    <h4 class="mb-3">Paiement</h4>
	
	                    <div class="d-block my-3">
	                        <div class="custom-control custom-radio">
	                            <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked required>
	                            <label class="custom-control-label" for="credit">Carte de crédit</label>
	                        </div>
	                        <div class="custom-control custom-radio">
	                            <input id="paypal" name="paymentMethod" type="radio" class="custom-control-input" required>
	                            <label class="custom-control-label" for="paypal">PayPal</label>
	                        </div>
	                    </div>
	                    <div class="row">
	                        <div class="col-md-6 mb-3">
	                            <label for="cc-name">Nom</label>
	                            <input type="text" class="form-control" id="cc-name" placeholder="" required>
	                            <small class="text-muted">Entrez le nom exact inscrit sur la carte</small>
	                            <div class="invalid-feedback">
	                                Name on card is required
	                            </div>
	                        </div>
	                        <div class="col-md-6 mb-3">
	                            <label for="cc-number">Numéro de carte</label>
	                            <input type="text" class="form-control" id="cc-number" placeholder="" required>
	                            <div class="invalid-feedback">
	                                Credit card number is required
	                            </div>
	                        </div>
	                    </div>
	                    <div class="row">
	                        <div class="col-md-3 mb-3">
	                            <label for="cc-expiration">Date d'expiration</label>
	                            <input type="date" class="form-control" id="cc-expiration" placeholder="JJ/MM/AAAA" required>
	                            <div class="invalid-feedback">
	                                Expiration date required
	                            </div>
	                        </div>
	                        <div class="col-md-3 mb-3">
	                            <label for="cc-cvv">CVV</label>
	                            <input type="text" class="form-control" id="cc-cvv" placeholder="" required>
	                            <div class="invalid-feedback">
	                                Security code required
	                            </div>
	                        </div>
	                    </div>
	                    <hr class="mb-4">
	                    <button class="btn btn-primary btn-lg btn-block" type="submit">Confirmer la commande</button>
	                </form>
	            </div>
	        </div>
	    </div>
	</jsp:body>
</t:layout>