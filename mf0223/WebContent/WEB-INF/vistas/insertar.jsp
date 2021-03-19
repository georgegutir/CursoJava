<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2>Nuevo plato a insertar</h2>
<br />

<form action="insertar" method="post" class="needs-validation" novalidate>
	
	<!-- Nombre -->
	<div class="form-group row">
      		<label for="nombre">Plato</label>
      		<input type="text" class="form-control" id="nombre" name="nombre">
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
                    <c:forEach var="c" items="${categoria}">
                        <option value="${c.id}">${c.nombre}</option>
                    </c:forEach>
     	 	</select>
		
			<!--<input type="text" class="form-control ${plato.errorNombre != null ? 'is-invalid' : '' }" id="categoria" name="categoria" value="${plato.nombre}"
				required minlength="3" pattern="\p{Lu}\p{Ll}{2}[\p{Ll} ]*"
				placeholder="Debe introducir un nombre con solo letras y mayúscula la primera letra">
			<select class="form-control custom-select required id="categoria" name="categoria">
				<option value="0">Seleccione la categoría</option>					
				<c:forEach items="${categoria}" var="categoria">
					<option value="${categoria.id}" ${categoria.id == plato.categoria_id ? 'selected' : ''}>${categoria.nombre}</option>
				</c:forEach>
			</select> -->
		</div>
	</div>
	
	<!-- Procedencia -->
	<div class="form-group row">
		<label for="procedencia" class="col-md-4 col-lg-3 col-form-label">Procedencia</label>
		<div class="col">
			<select class="custom-select mr-sm-2" id="origen" name="origen">
                    <c:forEach var="p" items="${procedencia}">
                        <option value="${p.id}">${p.nombre}</option>
                    </c:forEach>
     	 	</select>
		
			<!-- <input type="text" class="form-control ${plato.errorNombre != null ? 'is-invalid' : '' }" id="procedencia" name="procedencia" value="${procedencia.nombre}"
				required minlength="3" pattern="\p{Lu}\p{Ll}{2}[\p{Ll} ]*"
				placeholder="Debe introducir un nombre con solo letras y mayúscula la primera letra">
			<select class="form-control custom-select ${plato.errorProcedencia != null ? 'is-invalid' : '' }" required id="procedencia" name="procedencia">
				<option value="0">Introduzca la procedencia</option>					
				<c:forEach items="${procedencia}" var="procedencia">
					<option value="${procedencia.id}" ${procedencia.id == plato.procedencia.id ? 'selected' : ''}>${procedencia.nombre}</option>
				</c:forEach>
			</select> -->
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