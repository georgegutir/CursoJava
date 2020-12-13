<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row row-cols-1 row-cols-md-3 g-4 mx-0">

	<c:forEach items="${libros}" var="libro">
		<div class="col mb-4">
			<div class="card h-100 border-0">
				<div class="card-body">
					<img src="${libro.urlImagen}" class="card-img-top mx-auto d-block" alt="" style="width: 15em">
					<hr>
				    <div class="row">
				    	<div class="col-10">
				       		<p class="card-text text-muted">${libro.nombre}</p>
				        	<p class="text-uppercase fw-bold">${libro.autor}</p>
				    	</div>
				    	<div class="col-2 text-right">
      						<i class="far fa-heart"></i>
      					</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>