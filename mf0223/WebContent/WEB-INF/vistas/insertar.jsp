<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2>Nuevo plato a insertar</h2>
<br />

<form action="insertar" method="post" class="needs-validation" novalidate>
	
	<!-- Nombre -->
	<div class="form-group row">
		<label for="nombre" class="col-md-4 col-lg-3 col-form-label">Plato</label>
		<div class="col">
			<input type="text" class="form-control" id="nombre" name="nombre">
		</div>
	</div>
	
	<!-- Calorias -->
	<div class="form-group row">
		<label for="calorias" class="col-md-4 col-lg-3 col-form-label">Calorías</label>
		<div class="input-group col">		
			<input type="number" class="form-control" id="calorias" value="${plato.calorias}"
				name="calorias" required min="0" placeholder="Debe introducir un número mayor que 0"/>
			<div class="input-group-append">
				<span class="input-group-text rounded-right">calorías</span>
			</div>
		</div>
	</div>
	
	<!-- Categoria -->
	<div class="form-group row">
		<label for="categoria" class="col-md-4 col-lg-3 col-form-label">Categoría</label>
		<div class="col">	
			<select class="custom-select mr-sm-2" id="categoria" name="categoria">
                    <c:forEach items="${categorias}" var="c">
                        <option value="${c.id}">${c.nombre}</option>
                    </c:forEach>
     	 	</select>
		</div>
	</div>
	
	<!-- Procedencia -->
	<div class="form-group row">
		<label for="procedencia" class="col-md-4 col-lg-3 col-form-label">Procedencia</label>
		<div class="col">
			<select class="custom-select mr-sm-2" id="procedencia" name="procedencia">
                    <c:forEach items="${procedencias}" var="p">
                        <option value="${p.id}">${p.nombre}</option>
                    </c:forEach>
     	 	</select>
		</div>
	</div>
	
	<div class="form-group row">
		<div class="offset-md-4 offset-lg-3 col">
			<button type="submit" class="btn btn-primary">Guardar</button>
			<a class="btn btn-primary" onclick="history.back()">Volver</a>
		</div>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>