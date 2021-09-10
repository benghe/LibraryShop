<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<t:layout>
	<jsp:body>
		<div class="container py-5">
	        <div class="row">
	            <h1>Mes commandes</h1>
	        </div>
	        <div class="row">
	            <c:choose>
	            	<c:when test="${!empty commandes}">
	            		<table class="table">
		                    <thead>
		                    <tr>
		                        <th>Date de commande</th>
		                        <th>Payé le</th>
		                        <th>Total</th>
		                        <th>Effectuée par</th>
		                    </tr>
		                    </thead>
		                    <tbody>
		                    <c:forEach var="commande" items="${commandes}">
		                    	<tr>
		                            <td><h6 class="my-0">${ commande.date}</h6></td>
		                            <td><h6 class="my-0">${ commande.date}</h6></td>
		                            <td><h6 class="my-0">${ commande.montant } €</h6></td>
		                            <td><h6 class="my-0">${ sessionScope['currentUser'].nom} ${sessionScope['currentUser'].prenom}</h6></td>
		                        </tr>
		                    </c:forEach>	                        
		                    </tbody>
		                    <tfoot>
		                </table>
	            	</c:when>
	            	<c:otherwise>
	                	<p>Vous n'avez pas de commandes en cours.</p>
	            	</c:otherwise>
	            </c:choose>
	        </div>
    	</div>
	</jsp:body>
</t:layout>