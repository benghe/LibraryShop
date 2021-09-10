<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<t:layout>
	<jsp:body>
		<div class="container-fluid p-5">
	        <div class="row">
	            <h1>Commandes</h1>
	        </div>
	        <div class="row">
	            <c:choose>
	            	<c:when test="${!empty commandes}">
	            		<table class="table">
		                    <thead>
		                    <tr>
		                        <th>Id</th>
		                        <th>Date de commande</th>
		                        <th>Id du client</th>
		                        <th>Montant</th>
		                        <th></th>
		                    </tr>
		                    </thead>
		                    <tbody>
		                    <c:forEach var="commande" items="${commandes}">
		                    	<tr>		                    		
		                            <td><h6 class="my-0">${ commande.id}</h6></td>
		                            <td><h6 class="my-0">${ commande.date}</h6></td>
		                            <td><h6 class="my-0">${ commande.clientId}</h6></td>
		                            <td><h6 class="my-0">${ commande.montant } €</h6></td>
	                            	<td><h6 class="my-0">
		                               <a
										href="commandes-delete?modifiedObjectId=${ commande.id }"
										class="btn btn-danger btn-sm">
		                                   <i class="fas fa-trash"></i>
		                                   Supprimer
		                               </a>
			                        	</h6>
			                        </td>
		                        </tr>
		                    </c:forEach>	                        
		                    </tbody>
		                    <tfoot>
		                </table>
	            	</c:when>
	            	<c:otherwise>
	                	<p>Pas de commande enregistrée en base.</p>
	            	</c:otherwise>
	            </c:choose>
	        </div>
    	</div>
	</jsp:body>
</t:layout>