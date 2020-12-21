<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-sm">
		<caption>Listado de libros</caption>
		<thead class="thead-dark">
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Nombre</th>			
				<th scope="col">Precio</th>
				<th scope="col">Descuento</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${libros}" var="libro">
				<tr>
					<th scope="row">${libro.id}</th>
					<td>${libro.nombre}</td>
					<td><fmt:formatNumber type="currency" value="${libro.precio}" /></td>
					<td><fmt:formatNumber type="percent" value="${libro.descuento / 100}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a class="btn btn-primary" href="libro">Añadir libro</a> 
	</p>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>