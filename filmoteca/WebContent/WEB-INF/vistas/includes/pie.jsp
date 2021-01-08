<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
</main>  
<footer>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">&copy; 2020 Jorge Gutiérrez</a>
		<div class="navbar-collapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="#">Privacidad</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Cookies</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Dónde estamos</a></li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#"><i class="fab fa-facebook"></i></a></li>
				<li class="nav-item"><a class="nav-link" href="#"><i class="fab fa-twitter"></i></a></li>
				<li class="nav-item"><a class="nav-link" href="#"><i class="fab fa-youtube"></i></a></li>
			</ul>
		</div>
	</nav>
</footer>

<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/dataTables.bootstrap4.min.js"></script>

<script>
	$(document).ready(function() {
		$('table').DataTable({
			"language" : {
				"url" : "js/Spanish.json"
			}
		});
	});
</script>

</body>
</html> 