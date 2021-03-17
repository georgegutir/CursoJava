<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<h1>VOLCADO DE BBDD</h1>
<form action="backup" method="get">
	<div class="form-group">
    	<h3>
    		<label for="nombre">Guardar como:</label>
    	</h3>
    	<input type="text" class="form-control" id="nombre" name="nombre">
  	</div>
	<button type="submit" name="backup" value="backup" class="backup">Migrar bbdd</button>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>