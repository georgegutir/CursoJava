<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<h2>BBDD Restaurada</h2>
<br />
<form action="listado" method="get">
	<button type="submit" name="listado" value="listado" class="btn btn-primary btn-lg">Listado de platos</button>
</form>
<br />
<form action="listado" method="post">
	<button type="submit" name="insertar" value="insertar" class="btn btn-primary btn-lg">Insertar nuevo plato</button>
</form>
<br />

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>