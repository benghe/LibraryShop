<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<t:layout>
	<jsp:body>
		<div class="container-fluid p-5">
	        <div class="row">
	            <h1>Livres</h1>
	            
	        </div>

	        <div class="row">
	       	<form method="get" action="${ajout == 'actif' ? 'livre-ajouter' : 'livres-update' } ">
	            <c:choose>
	            	<c:when test="${!empty livres}">
	            		<table class="table">
		                    <thead>
		                    <tr>
		                    	<th>Id</th>
		                        <th>Titre</th>
		                        <th>Auteur</th>
		                        <th>Prix</th>
		                        <th>Photo</th>
		                        <th>Résumé</th>
		                        <th></th>
		                        <th><a style="min-width : 100px" href="livres-administration?ajout=actif" class="btn btn-success btn-sm"> <i class="fas fa-plus"></i> Ajouter </a></th>
		                    </tr>
		                    </thead>
		                    <tbody>
		                    <c:if test="${ajout == 'actif'}">
		                    		<tr>		                    		
			                            <td><h6 class="my-0"></h6></td>
			                            <td>
			                            	<h6 class="my-0">
			                            		<input type="text" class="form-control" id="titre" name="titre"  placeholder="" value="" required>
			                            	</h6>
			                            </td>
			                            <td>
			                            	<h6 class="my-0">
			                            		<input type="text" class="form-control" id="auteur" name="auteur"  placeholder="" value="" required>
			                            	</h6>
			                            </td>
			                            <td>
			                            	<h6 class="my-0">
			                            		<input type="number" step="0.1" class="form-control" id="prix" name="prix"  placeholder="" value="" required>
			                            	</h6>
			                            </td>
			                            <td>
			                            	<h6 class="my-0">
			                            		<input type="url" class="form-control" id="photo" name="photo"  placeholder="" value="" required>
			                            	</h6>
			                            </td>
			                            <td>
			                            	<h6 class="my-0">
			                            		<input type="text" class="form-control" id="resume" name="resume"  placeholder="" value="" required>
			                            	</h6>
			                            </td>
			                            <td class="d-none">
			                            	<h6 class="my-0">
			                            		<input type="text" class="form-control" id="modifiedObjectId" name="modifiedObjectId"  placeholder="" value="">
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
											href="livres-administration"
											class="btn btn-danger btn-sm">
			                                   <i class="fas fa-times"></i>
			                                   Annuler
			                               </a>
				                        	</h6>
				                        </td>
			                    	</tr>
			                </c:if>
		                    <c:forEach var="livre" items="${livres}">
		                    	<c:if test="${modification == 'allowed' && modifiedObjectId == livre.id}">
		                    		<tr>		                    		
			                            <td><h6 class="my-0">${ livre.id}</h6></td>
			                            <td>
			                            	<h6 class="my-0">
			                            		<input type="text" class="form-control" id="titre" name="titre"  placeholder="" value="${livre.titre}" required>
			                            	</h6>
			                            </td>
			                            <td>
			                            	<h6 class="my-0">
			                            		<input type="text" class="form-control" id="auteur" name="auteur"  placeholder="" value="${livre.auteur}" required>
			                            	</h6>
			                            </td>
			                            <td>
			                            	<h6 class="my-0">
			                            		<input type="number" step="0.1" class="form-control" id="prix" name="prix"  placeholder="" value="${livre.prix}" required>
			                            	</h6>
			                            </td>
			                            <td>
			                            	<h6 class="my-0">
			                            		<input type="url" class="form-control" id="photo" name="photo"  placeholder="" value="${livre.photo}" required>
			                            	</h6>
			                            </td>
			                            <td>
			                            	<h6 class="my-0">
			                            		<input type="text" class="form-control" id="resume" name="resume"  placeholder="" value="${livre.resume}" required>
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
											href="livres-administration"
											class="btn btn-danger btn-sm">
			                                   <i class="fas fa-times"></i>
			                                   Annuler
			                               </a>
				                        	</h6>
				                        </td>
			                    	</tr>
			                    </c:if>
		                    	<c:if test="${modification != 'allowed' || modifiedObjectId != livre.id}">
			                    	<tr class="">		                    		
			                            <td><h6 class="my-0">${ livre.id}</h6></td>
			                            <td><h6 class="my-0">${ livre.titre}</h6></td>
			                            <td><h6 class="my-0">${ livre.auteur}</h6></td>
			                            <td><h6 class="my-0">${ livre.prix}</h6></td>
			                            <td><h6 class="my-0">${ livre.photo}</h6></td>
			                            <td><h6 class="my-0">${ livre.resume}</h6></td>
			                            <td><h6 class="my-0">
			                               <a
											href="livres-administration?modification=allowed&modifiedObjectId=${ livre.id }"
											class="btn btn-primary btn-sm">
			                                   <i class="fas fa-pencil-alt"></i>
			                                   Modifier
			                               </a>
				                        	</h6>
				                        </td>
			                            <td><h6 class="my-0">
			                               <a
											href="livres-delete?modifiedObjectId=${ livre.id }"
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
	                	<p>Pas de livre enregistré en base.</p>
	            	</c:otherwise>
	            </c:choose>
	          </form>	            
	        </div>
    	</div>

	</jsp:body>
</t:layout>