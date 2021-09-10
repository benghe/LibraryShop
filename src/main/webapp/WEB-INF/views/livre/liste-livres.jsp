<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:body>
	    <div class="container">
	        <div class="row">
	            <c:forEach var="livre" items="${ livres }" varStatus="status">
	            	<div class="col-md-4 card book border border-0 d-flex flex-column justify-content-end bg-white">
	                    <div class="card-body d-flex flex-column justify-content-end">
	                        <div class="text-center">
	                            <a href="#resume${ status.index }" data-toggle="modal">
	                                <img src="${ livre.photo }" class="card-img-top book-image img-thumbnail mx-0" style="width: 17rem;" >
	                            </a>
	                            <div class="modal fade m-5" id="resume${ status.index }" tabindex="-5" role="dialog"
	                                 aria-hidden="true">
	                                <div class="modal-dialog modal-dialog-centered" role="document">
	                                    <div class="modal-content" style="min-width: 35vh; min-height: 40vh">
	                                        <div class="modal-header bg-warning">
	                                            <div class="d-flex flex-column justify-content-center">
	                                                <h6 class="my-0">${ livre.titre }</h6>
	                                                <small class="text-left">${ livre.auteur }</small>
	                                            </div>
	                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                                                <span aria-hidden="true">&times;</span>
	                                            </button>
	                                        </div>
	                                        <div class="modal-body">
	                                            <div class="container-fluid">
	                                                <div class="row p-0">
	                                                    <div class="col-md-4 mr-0">
	                                                        <img src="${ livre.photo }" class="card-img-top book-image img-thumbnail mx-0" style="width: 17rem;" >
	                                                    </div>
	                                                    <div class="col-md-7 m-0 p-0">
	                                                    	<h5 class="text-left"><strong class="text-muted">Résumé </strong></h5>
	                                                        <h5 class="text-left font-weight-normal font-italic">${ livre.resume }</h5>
	                                                    </div>
	                                                </div>
	                                            </div>
	                                        </div>
	                                        <div class="modal-footer">
	                                            <p class="pt-3"> <strong> Prix : </strong> ${ livre.prix } euros</p>
	                                            <a class="btn btn-secondary rounded-circle" href="panier?livreId=${ livre.id }">
	                                                <i class="fas fa fa-shopping-cart"></i>
	                                            </a>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                        <hr>
	                        <h5 class="text-center">${ livre.titre }</h5>
	                        <div class="d-flex justify-content-between">
	                            <p> <strong> Prix : </strong> ${ livre.prix } euros </p>
	                            <p class="mb-0"> <strong> Auteur : </strong> ${ livre.auteur }</p>
	                        </div>
	                        <div class="text-right align-bottom">
	                            <a class="btn btn-secondary rounded-circle" href="panier?livreId=${ livre.id }">
	                                <i class="fas fa fa-shopping-cart"></i>
	                            </a>
	                        </div>
	                    </div>
	                </div>
	            </c:forEach >                
	        </div>
	    </div>
	</jsp:body>
</t:layout>