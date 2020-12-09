<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Carrito de la compra</h1>

<button class="btn btn-primary btn-block mb-3">Comprar</button>
<table class="table table-striped">
	<thead class="table-dark">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Cantidad</th>
			<th>Total</th>
		</tr>
	</thead>
	<tbody> 
		<c:forEach items="${carrito}" var="producto">
			<tr>
				<td>${producto.value.id}</td>
				<td>${producto.value.nombre}</td>
				<td><fmt:formatNumber type="currency" value="${producto.value.precio}" /></td>
				<td>${producto.value.cantidad}</td>
				<!-- <c:set var="totalProducto" value="${producto.value.precio*producto.value.cantidad}" /> -->
				<td><fmt:formatNumber type="currency" value="${producto.value.totalProducto}" /></td>
				<!-- <c:set var="totalCompra" value="${(totalCompra + totalProducto)}" /> -->
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th colspan="4" class="text-right">Total de la compra:</th>
			<th><fmt:formatNumber type="currency" value="${totalCompra}"/></th>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>