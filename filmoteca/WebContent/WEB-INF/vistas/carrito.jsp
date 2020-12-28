<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Películas compradas</h1>
<!-- ${carrito} -->
<table class="table">
	<thead>
		<tr>
			<th>Id</th>
			<th>foto</th>
			<th>Nombre</th>
			<th>Cantidad</th>
			<th>Precio</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${carrito}" var="producto">
			<tr>
				<th>${producto.id}</th>
				<th>${producto.urlImagen}</th>
				<th>${producto.nombre}</th>
				<th>${producto.cantidad}</th>
				<th><fmt:formatNumber type="currency" value="${producto.precioConDescuento}" /></th>
				<!-- ${producto} -->
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>