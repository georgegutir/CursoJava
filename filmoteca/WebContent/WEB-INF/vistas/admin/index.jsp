<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-sm">
		<caption>Listado de productos</caption>
		<thead class="thead-dark">
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Nombre</th>
				<th scope="col">Imagen</th>
				<th scope="col">Precio</th>
				<th scope="col">Descuento</th>
				<th scope="col">Cantidad</th>
				<th scope="col">Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="producto">
				<tr>
					<th scope="row">${producto.id}</th>
					<td>${producto.nombre}</td>
					<td><img src="${producto.urlImagen}" alt="" style="height: 3em" /></td>
					<td><fmt:formatNumber type="currency" value="${producto.precio}" /></td>
					<td><fmt:formatNumber type="percent" value="${producto.descuento / 100}" /></td>
					<td>${producto.cantidad}</td>
					<td>
						<div class="btn-group" role="group" aria-label="Opciones">
							<a class="btn btn-primary btn-sm" href="#">Editar</a>
							<a class="btn btn-danger btn-sm" href="#">Borrar</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<a class="btn btn-primary" href="admin/producto">Añadir producto</a> 
	</p>
</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>