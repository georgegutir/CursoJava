<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>


<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5">
	<c:forEach items="${productos}" var="producto">
		<div class="col mb-4">
			<div class="card h-100">
				<c:if test="${producto.descuento != null}">
					<p class="bg-danger text-white position-absolute px-2 rounded-pill">-${producto.descuento}%</p>
				</c:if>
				<img src="${producto.urlImagen}" class="card-img-top" alt="">
				<%-- <c:if test="${producto.descuento != null}">
					<div class="card-header">${producto.descuento != null ? ''.concat(producto.descuento).concat('% descuento') : ''}</div>
				</c:if> --%>
				<div class="card-body">
					<h5 class="card-title">${producto.nombre}</h5>
					<p class="card-text">${producto.genero}</p>
					<p class="card-text">${producto.descripcion}</p>
					<p class="card-text lead row">
						<strong class="${producto.descuento != null ? 'col-6' : 'col-12'}">
							<c:if test="${producto.descuento != null}">
								<del>
							</c:if>
							<fmt:formatNumber type="currency" value="${producto.precio}" />
							<c:if test="${producto.descuento != null}">
								</del>
							</c:if>
						</strong>
						<c:if test="${producto.descuento != null}">
							<strong class="col-6 text-danger text-right">
								<fmt:formatNumber type="currency" value="${producto.precioConDescuento}" />
							</strong>
						</c:if>
					</p>
				</div>
				<div class="card-footer bg-primary p-0">
					<a href="#" class="btn btn-block text-white">Comprar película</a>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>