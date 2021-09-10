<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<t:layout>
	<jsp:body>
		<div class="container-fluid p-5">
	        <div class="row">
	            <h1>Utilisateurs</h1>
	        </div>
	        <div class="row">
	       	<form method="get" action="users-update">
	            <c:choose>
	            	<c:when test="${!empty users}">
	            		<table class="table">
		                    <thead>
		                    <tr>
		                        <th>Id</th>
		                        <th>Nom</th>
		                        <th>Prénom</th>
		                        <th>Adresse</th>
		                        <th>Login</th>
		                        <th></th>
		                        <th></th>
		                    </tr>
		                    </thead>
		                    <tbody>
		                    <c:forEach var="user" items="${users}">
		                    	<c:if test="${modification == 'allowed' && modifiedObjectId == user.id}">
		                    		<tr>		                    		
			                            <td><h6 class="my-0">${ user.id}</h6></td>
			                            <td>
			                            	<h6 class="my-0">
			                            		<input type="text" class="form-control" id="nom" name="nom"  placeholder="" value="${ user.nom}" required>
			                            	</h6>
			                            </td>
			                            <td>
			                            	<h6 class="my-0">
			                            		<input type="text" class="form-control" id="prenom" name="prenom"  placeholder="" value="${ user.prenom}" required>
			                            	</h6>
			                            </td>
			                            <td>
			                            	<h6 class="my-0">
			                            		<input type="text" class="form-control" id="adresse" name="adresse"  placeholder="" value="${ user.adresse}" required>
			                            	</h6>
			                            </td>
			                            <td>
			                            	<h6 class="my-0">
			                            		<input type="text" class="form-control" id="login" name="login"  placeholder="" value="${ user.login}" required>
			                            	</h6>
			                            </td>
			                            <td class="d-none">
			                            	<h6 class="my-0">
			                            		<input type="text" class="form-control" id="modifiedObjectId" name="modifiedObjectId"  placeholder="" value="${modifiedObjectId}">
			                            	</h6>
			                            </td>
			                            <td><h6 class="my-0">
			                               <button
											type="submit"
											class="btn btn-success btn-sm">
			                                   <i class="fas fa-check"></i>
			                                   Valider
			                               </button>
				                        	</h6>
				                        </td>
			                            <td><h6 class="my-0">
			                               <a
											href="users-administration"
											class="btn btn-danger btn-sm">
			                                   <i class="fas fa-times"></i>
			                                   Annuler
			                               </a>
				                        	</h6>
				                        </td>
			                    	</tr>
			                    </c:if>
		                    	<c:if test="${modification != 'allowed' || modifiedObjectId != user.id}">
			                    	<tr class="">		                    		
			                            <td><h6 class="my-0">${ user.id}</h6></td>
			                            <td><h6 class="my-0">${ user.nom}</h6></td>
			                            <td><h6 class="my-0">${ user.prenom}</h6></td>
			                            <td><h6 class="my-0">${ user.adresse}</h6></td>
			                            <td><h6 class="my-0">${ user.login}</h6></td>
			                            <td><h6 class="my-0">
			                               <a
											href="users-administration?modification=allowed&modifiedObjectId=${ user.id }"
											class="btn btn-primary btn-sm">
			                                   <i class="fas fa-pencil-alt"></i>
			                                   Modifier
			                               </a>
				                        	</h6>
				                        </td>
			                            <td><h6 class="my-0">
			                               <a
											href="users-delete?modifiedObjectId=${ user.id }"
											class="btn btn-danger btn-sm">
			                                   <i class="fas fa-trash"></i>
			                                   Supprimer
			                               </a>
				                        	</h6>
				                        </td>
			                        </tr>
		                        </c:if>
		                    </c:forEach>	                        
		                    </tbody>
		                    <tfoot>
		                </table>
	            	</c:when>
	            	<c:otherwise>
	                	<p>Pas d'utilisateur enregistré en base.</p>
	            	</c:otherwise>
	            </c:choose>
	          </form>	            
	        </div>
    	</div>
	</jsp:body>
</t:layout>