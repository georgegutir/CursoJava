<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<br />
<h2>MENÚ</h2>
<br />
<form action="listado" method="post">
	<div class="table-responsive">
		<table class="table table-striped table-bordered table-hover table-sm">
			<caption>Platos</caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Nombre</th>
					<th scope="col">Calorías</th>
					<th scope="col">Categoría</th>
					<th scope="col">Procedencia</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${platos}" var="p">
					<tr>
						<th scope="row">${p.id}</th>
						<td>${p.nombre}</td>
						<td>${p.calorias}</td>
						<td>${p.categoria.nombre}</td>
						<td>${p.procedencia.nombre}</td>	
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<button type="submit" class="btn btn-primary">Insertar nuevo plato</button>
	<br />
	</div>
</form>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>