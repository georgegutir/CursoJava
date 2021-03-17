<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<h2>Restaurar bbdd</h2>
<form action="restauracion" method="post">
	<%--  <div class="form-group">
    	<input type="file" class="form-control-file" id="archivo" name="archivo">
  	</div>
  	--%>

	<button type="submit" name="restauracion" value="restauracion" class="restauracion">Restaurar bbdd</button>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>