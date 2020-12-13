<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es_ES" />
<!doctype html>
<html lang="es">
<head>

<!-- base pa tener el mismo menu en todas las pag y no se rompa la ruta ej. cuenta admin -->
<%-- <base href="/libreria/" /> --%>
<base href="${pageContext.request.contextPath}/" /> 

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- FontAwesome -->
<link rel="stylesheet" href="css/all.min.css">
<!-- Datatables -->
<link rel="stylesheet" href="css/dataTables.bootstrap4.min.css" />
<!-- Hoja de estilos personalizada -->
<link rel="stylesheet" href="css/ejercicio.css">

<title>Librería</title>
</head>
<body>
	<div class="card bg-dark text-white">
		<img src="img/cabecera.jpg" alt="librería" class="card-img img-fluid">
	</div>
	<header class="sticky-top">	
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<h1><a class="navbar-brand" href="principal">Librería</a></h1>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<c:if test="${sessionScope.usuario != null}">
						<li class="nav-item"><a class="nav-link" href="admin/libro">Dar de alta</a></li>
						<li class="nav-item"><a class="nav-link" href="admin/index">Editar</a></li>
					</c:if>
				</ul>
				<ul class="navbar-nav">
					<c:choose>
							<c:when test="${sessionScope.usuario == null}">
								<li class="nav-item"><a class="nav-link" href="login">Iniciar sesión</a></li>
							</c:when>
							<c:otherwise>
								<li class="navbar-text">Administrador</li>
								<li class="nav-item"><a class="nav-link" href="logout">Cerrar sesión</a></li>
							</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</nav>
		<c:if test="${alertaTexto != null}">
			<div class="alert alert-${alertaNivel} alert-dismissible fade show"
				role="alert">
				${alertaTexto}
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
	</header> 
	<main class="container pt-3"> 