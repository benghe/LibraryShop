<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<base href="/projet-jee/" />
		<title>Lib Online</title>
	   <link 
	       rel="stylesheet" 
	       href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	       integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	       crossorigin="anonymous"
	   >	
    </head>
	
	<body class="d-flex flex-column" style="min-height: 100vh;">
		<%-- Navbar --%>
	    <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top" role="navigation">
	        <div class="container-fluid">
	
	            <%-- Left side --%>
	            <div class="navbar-header">
	                <a class="navbar-brand" href="livres">
	                    <img src="https://www.graphicsprings.com/filestorage/stencils/2f3bdb9733c4a68659dc2900a7595fea.png?width=500&height=500" width="30" height="30" class="d-inline-block align-top" alt="">
	                    Lib Online
	                </a>
	            </div>
	
	            <%-- Right side --%>
	            <ul class="nav navbar-nav navbar-right">
	            	<c:choose>
	            		<c:when test="${!empty sessionScope['currentUser']}">
            				<c:if test="${sessionScope['currentUser'].login == 'admin'}">
	                        	<li class="nav-item dropdown pt-1">
			                        <a href="#" class="dropdown-toggle mr-3 text-white" data-toggle="dropdown"> 
			                            <i class="fa fa-cog fa-1x" aria-hidden="true"></i>
			                        </a>
			                        <ul class="dropdown-menu">
			                            <li class="dropdown-item"><a class="text-center" href="livres-administration">Gestion des livres</a></li>
			                            <li class="dropdown-item"><a class="text-center" href="users-administration">Gestion des utilisateurs</a></li>
			                            <li class="dropdown-item"><a class="text-center" href="orders-administration">Gestion des commandes</a></li>
			                        </ul>
			                    </li>
            				</c:if>
	            			<li class="nav-item dropdown">
		                        <a href="#" class="dropdown-toggle mr-3 text-white" data-toggle="dropdown">
		                            <i class="fa fa-user fa-1x" aria-hidden="true"></i>
		                        </a>
		                        <a class="btn btn-default btn-danger text-white mr-3" href="disconnect">
		                            Se déconnecter
		                        </a>
		                        <ul class="dropdown-menu">
		                            <li class="dropdown-item"><a class="text-center" href="mon-profil">Mes informations</a></li>
		                            <li class="dropdown-item"><a class="text-center" href="mes-commandes">Mes commandes</a></li>
		                        </ul>
		                    </li>
	            		</c:when>
	            		<c:otherwise>
	            			<li class="nav-item">
		                        <a class="btn btn-default btn-info text-white mr-1 " href="login-page" role="button"><b>S'identifier</b> <span class="caret"></span></a>
		                        <a class="btn btn-default btn-warning mr-3" href="register-page"><b>Créer un compte </b></a>
		                    </li>
	            		</c:otherwise>
	            	</c:choose>
	                <li class="nav-item">
	                    <a class="btn btn-secondary" href="panier">
	                        <i class="fa fa-shopping-cart" aria-hidden="true"></i> Panier <span
	                                class="badge bg-dark text-light">${sessionScope['cart'] != null ? sessionScope['cart'].size() : 0}</span>
	                    </a>
	                </li>
	            </ul>
	        </div>
	    </nav>
	    
	    <%-- BODY --%>
		
		<main class="flex-fill py-4">
			<jsp:doBody />
		</main>
		
		<%-- Scripts --%>
		
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	           integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	   	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	           integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	           
	   	<%-- Font Awesome --%>
	   	
	   	<script src="https://kit.fontawesome.com/5f876598f4.js" crossorigin="anonymous"></script>
	
	   	<%-- Footer --%>
	
	   	<div class="footer navbar-fixed-bottom my-5 pt-5 text-muted text-center text-small">
	       <p class="mb-1">&copy; 2021 Lib Online</p>
	       <ul class="list-inline">
	           <li class="list-inline-item"><a href="#">Privacy</a></li>
	           <li class="list-inline-item"><a href="#">Terms</a></li>
	           <li class="list-inline-item"><a href="#">Support</a></li>
	       </ul>
	   </div>
	</body>
</html>