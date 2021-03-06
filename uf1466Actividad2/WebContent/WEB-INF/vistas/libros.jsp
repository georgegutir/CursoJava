<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Listado de libros</h1>

<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-sm">
		<caption>Listado de libros</caption>
		<thead class="thead-dark">
			<tr>
				<th scope="col">Código</th>
				<th scope="col">Título</th>
				<th scope="col">ISBN</th>
				<th scope="col">Autor</th>
				<th scope="col">Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${libros}" var="libro">
				<tr>
					<th scope="row">${libro.id}</th>
					<td>${libro.titulo}</td>
					<td>${libro.isbn}</td>
					<td>${libro.autor.nombre} ${libro.autor.apellidos}</td>
					<td>
						<div class="btn-group" role="group" aria-label="Opciones">
							<a class="btn btn-primary btn-sm"
									href="detalle?id=${libro.id}">Ver detalles</a> 						
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="form-inline my-2 my-lg-0">
		<button type="submit" class="btn btn-primary" onclick="history.back()">Volver</button>	
	</div>	
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>