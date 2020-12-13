<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="login" method="post">
	<div class="form-group row">
		<label for="usuario" class="col-sm-2 col-form-label">Usuario</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="usuario" name="usuario" required>
		</div>
	</div>
	<div class="form-group row">
		<label for="password" class="col-sm-2 col-form-label">Contraseña</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="password" name="password" required>
		</div>
	</div>
	
	<div class="form-group row">
		<div class="offset-sm-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Iniciar sesión</button>
		</div>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>