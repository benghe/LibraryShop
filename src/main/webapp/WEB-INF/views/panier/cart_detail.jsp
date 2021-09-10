<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<t:layout>
	<jsp:body>
		<div class="container py-5" style="min-width: 80vh;">
		       <div class="row">
		           <h1>Panier</h1>
		       </div>
		       <div class="row">
		           <c:choose>
		           		<c:when
						test="${ sessionScope['detailedCart'].size() > 0 }">
		           			<table class="table">
			                   <thead>
			                   <tr>
			                       <th></th>
			                       <th>Livre</th>
			                       <th class="text-right">Prix</th>
			                       <th class="text-right">Quantité</th>
			                       <th class="text-right">Total</th>
			                       <th></th>
			                   </tr>
			                   </thead>
			                   <tbody>
			                   <c:forEach var="item"
									items="${ sessionScope['detailedCart'] }">
			                   		<tr>
			                           <td class="text-center px-0">
			                               <img src="${ item.key.photo }"
											class="img-thumbnail w-25 h-30" style="width: 15rem;">
			                           </td>
			                           <td class="align-middle">
			                               <h6 class="my-0">${ item.key.titre }</h6>
			                               <small class="text-muted">${ item.key.auteur }</small>
			                           </td>
			                           <td class="text-right align-middle"><h6
												class="my-0">
												<fmt:formatNumber
													value="${ item.key.prix }" type="currency" />
											</h6></td>
			                           <td class="text-center align-middle"><h6
												class="my-0">${ item.value }</h6></td>
			                           <td class="text-right align-middle"><h6
												class="my-0">
												<fmt:formatNumber
													value="${ item.key.prix * item.value }" type="currency" />
											</h6></td>
			                           <td class="text-center align-middle">
			                               <a
											href="panier-retirer?livreId=${ item.key.id }"
											class="btn btn-danger btn-sm">
			                                   <i class="fas fa-times"></i>
			                               </a>
			                           </td>
			                       </tr>
			                   </c:forEach>
			                   </tbody>
			                   <tfoot>
			                       <tr>
			                           <th colspan="4"
										class="text-right align-middle">Total : </th>
			                           <th class="text-right align-middle"><fmt:formatNumber
											value="${ sessionScope['totalPanier'] }"
											type="currency" /></th>
			                           <td class="text-right align-middle"><a
										role="button" href="confirm-order"
										class="btn btn-success text-white">Passer commande</a></td>
			                       </tr>
			                   </tfoot>
			               </table>
		           		</c:when>
			           <c:otherwise>
			               <p>Votre panier est tristement vide :(</p>
			           </c:otherwise>
		           	</c:choose>

		       </div>
		   </div>
	</jsp:body>
</t:layout>