<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<h2>BBDD Restaurada</h2>
<form action="libros" method="get">
	<button type="submit" name="lista" value="lista" class="btn btn-primary btn-lg">Listar libros</button>
</form>
<form class="form-inline" action="buscarTitulo" method="post">
  <div class="form-group mb-2">
    <input type="text" readonly class="form-control-plaintext" value="Buscar por título">
  </div>
  <div class="form-group mx-sm-3 mb-2">
    <input type="text" class="form-control" id="titulo" name ="titulo" placeholder="Título">
  </div>
  <button type="submit" class="btn btn-primary mb-2">Buscar</button>
</form>
<form class="form-inline" action="buscarISBN" method="post">
  <div class="form-group mb-2">
    <input type="text" readonly class="form-control-plaintext" value="Buscar por isbn">
  </div>
  <div class="form-group mx-sm-3 mb-2">
    <input type="text" class="form-control" id="isbn" name ="isbn" placeholder="ISBN">
  </div>
  <button type="submit" class="btn btn-primary mb-2">Buscar</button>
</form>


<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>