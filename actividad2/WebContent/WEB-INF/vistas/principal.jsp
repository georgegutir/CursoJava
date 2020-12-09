<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="agregarcarrito" method="get">
	<button class="btn btn-primary btn-block mb-3">Agregar al carrito</button>
	<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5">
		<c:forEach items="${productos}" var="producto">
			<div class="col mb-4">
				<div class="card h-100">
					<img src="${producto.urlImagen}" class="card-img-top" alt="">
					<div class="card-body">
						<h5 class="card-title">${producto.nombre}</h5>
						<p class="card-text">
						<fmt:formatNumber type="currency" value="${producto.precio}" />
						</p>
					</div>
					<div class="card-footer">
						<div class="input-group mx-auto" style="width: 9rem">
							<input type="number"
								class="form-control text-center font-weight-bold" placeholder=""
								aria-label="Cantidad" value="0" name="${producto.id}"
								min="0" />			
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</form>


<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>