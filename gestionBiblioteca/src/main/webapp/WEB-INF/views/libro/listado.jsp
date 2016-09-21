<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags"%>
<tag:url var="bootstrapCSS" value="/resources/css/bootstrap.min.css" />
<tag:url var="font" value="/resources/css/font-awesome.min.css" />
<tag:url var="style" value="/resources/css/styles.css" />
<tag:url var="jsBootstrap" value="/resources/js/bootstrap.min.js" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Biblioteca</title>
<link rel="stylesheet" href="${bootstrapCSS}" />
<link rel="stylesheet" href="${font}" />
<link rel="stylesheet" href="${style}" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="${jsBootstrap}"></script>
</head>
<body class="container-fluid">
	<nav role="navigation" class="nav navbar-inverse">
		<div class="navbar-header">
			<!-- Lo siguiente es para los dispositivos moviles, para que se adapte de manera correcta la barra de navegacion -->
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Desplegar navegación</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand active" href='<c:url value="/"/>'>Inicio</a>
		</div>
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href='<c:url value="/libro/"/>'>Listado
						de libros</a></li>
				<li><a href='<c:url value="/ejemplar/"/>'>Listado de
						ejemplares</a></li>
				<li class="dropdown"><a href='<c:url value="/usuario/"/>'
					class="dropdown-toggle" data-toggle="dropdown">Usuarios<b
						class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li class="divider"></li>
						<li><a href='<c:url value="/usuario/"/>'>Listado de
								usuarios</a></li>
						<li class="divider"></li>
						<li><a href="#">Devolver libro</a></li>
						<li class="divider"></li>
					</ul></li>
			</ul>
		</div>
	</nav>
	<div class="row">
		<div class="col-xs-12 col-lg-12 col-ms-12 text-center">
			<h1>Gestión Biblioteca</h1>
		</div>
	</div>



	<main> 
	<div class="row">
		<div class="col-xs-12 col-ms-12 col-lg-12">
			<a class="btn btn-success pull-right"
				href='<c:url value="createUpdate"/>'>Registrar libros</a>
		</div>
	</div>
	<c:if test="${!empty libros}">
		<c:forEach var="libro" items="${libros}">
			<div class="row">
				<div class="col-xs-12 col-ms-12 col-lg-12">
					<div class="col-xs-8 col-ms-8 col-lg-8">
						<p>
							Titulo:
							<c:out value="${libro.titulo}" />
						</p>
						<p>
							Autor:
							<c:out value="${libro.nombreApellidos}" />
						</p>
						<p>
							ISBN:
							<c:out value="${libro.ISBN}" />
						</p>
					</div>
					<div class="col-xs-2 col-ms-2 col-lg-2">
						<a class="btn btn-warning" href="libros/${libro.codigo}">Modificar
							libro</a>
					</div>
					<div class="col-xs-2 col-ms-2 col-lg-2">
						<a class="btn btn-danger" href="libro/${libro.codigo}">Borrar
							libro</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</c:if> <c:if test="${empty libros}">
		<h3>No hay ejemplares registrados</h3>
	</c:if> </main>
	<footer>
		<div class="row">
			<div class="col-xs-12 col-ms-12 col-lg-12">
				<h3 class="text-center">Servicios ofrecidos por ipartek
					formación</h3>
			</div>
		</div>
	</footer>
</body>
</html>