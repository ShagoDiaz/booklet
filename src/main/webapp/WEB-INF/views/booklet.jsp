<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">

<link href="/css/style.css" rel="stylesheet" />
<title>Booklet</title>
</head>
<body>

	<div class="container" align="center">
		<div style="page-break-after: always;"€‹>
			<div class="row py-2">
				<h1>Booklet</h1>
			</div>
			<form:form id="formulario" action="" modelAttribute="libro">
				<div class="row  py-2">
					<form:input path="id_libro" type="hidden" class="form-control"
						name="id_libro" id="id_libro" value="${libro.id_libro}" />
					<form:input path="disponible" type="hidden" class="form-control"
						name="disponible" id="disponible" value="${libro.disponible}" />
					<div class="col">
						<form:input path="titulo" class="form-control"
							placeholder="titulo" aria-label="titulo" name="titulo"
							id="titulo" required="true" value="${libro.titulo}" />
					</div>
					<div class="col">
						<form:input path="autor" class="form-control" placeholder="autor"
							aria-label="autor" name="autor" id="autor" required="true"
							value="${libro.autor}" />
					</div>
					<div class="col">
						<form:input path="publicacion" class="form-control"
							placeholder="Año publicacion" aria-label="publicacion"
							name="publicacion" id="publicacion" required="true"
							value="${libro.publicacion}" />
					</div>
				</div>
				<div class="row  py-2">
					<div class="col-sm-6">
						<form:input path="imprenta" class="form-control"
							placeholder="imprenta" aria-label="imprenta" name="imprenta"
							id="imprenta" required="false" value="${libro.imprenta}" />
					</div>
					<div class="col-sm-2 form-check form-switch ">
						<input type="checkbox" class="form-check-input"
							name="disponibleCheck" id="disponibleCheck" checked /> <label
							class="form-check-label" for="disponible" id="textStock">Disponible</label>
					</div>
				</div>
				<div class="row  py-2">
					<div class="col">
						<input type="submit" class="btn btn-outline-primary"
							name="agregar" value="Agregar">
					</div>
					<div class="col">
						<input type="submit" class="btn btn-outline-danger"
							name="eliminar" value="Eliminar">
					</div>

				</div>

			</form:form>
		</div>
		<div style="page-break-after: always;"€‹>
			<div class="row">
				<h1>Libros registrados</h1>
			</div>
			<div class="row">
				<form:form id="filtro" action="/booklet/filtrar"
					modelAttribute="texto" method="get">
					<div class="col-md-4 py-3">
						<input path="texto" class="form-control" type="text"
							placeholder="Ingresa criterios para filtrar" aria-label="texto"
							name="texto" id="texto" required="true" />
					</div>
					<div class="col-md-4 py-3">
						<input type="submit" class="btn btn-outline-primary"
							value="Filtrar">
					</div>
				</form:form>
			</div>
			<div class="row">
				<table id="registros" class="table table-striped table-hover">
					<tr>
						<th></th>
						<th>ID</th>
						<th>Titulo</th>
						<th>Autor</th>
						<th>Año Publicacion</th>
						<th>Imprenta</th>
						<th>Disponibilidad</th>
					</tr>
					<c:forEach items="${libros}" var="libro">
						<tr>
							<td><input type="radio" id="optSelectRow${libro.id_libro}"
								name="${libro.id_libro}" /></td>
							<td>${libro.id_libro}</td>
							<td>${libro.titulo}</td>
							<td>${libro.autor}</td>
							<td>${libro.publicacion}</td>
							<td>${libro.imprenta}</td>

							<td class="form-check form-switch"><c:choose>
									<c:when test="${libro.disponible eq 1}">
										<input class="form-check-input" type="checkbox"
											id="switchStock${libro.id_libro}" name="${libro.id_libro}"
											checked>
										<p id="textStock${libro.id_libro}">Disponible</p>
									</c:when>
									<c:otherwise>
										<input class="form-check-input" type="checkbox"
											id="switchStock${libro.id_libro}" name="${libro.id_libro}">
										<p id="textStock${libro.id_libro}">Sin disponibilidad</p>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"
		integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"
		integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/"
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>