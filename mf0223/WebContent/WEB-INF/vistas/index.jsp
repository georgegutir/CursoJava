<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<h2>Restaurar bbdd</h2>
<form action="restauracion" method="post" enctype="multipart/form-data">
	<div class="form-group">
    	<input type="file" class="form-control-file" id="archivo" name="archivo">
  	</div>
	<button type="submit" name="restauracion" value="restauracion" class="btn btn-primary btn-lg">Restaurar bbdd</button>
</form>
<br>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>