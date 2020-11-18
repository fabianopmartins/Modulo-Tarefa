<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Lista de Tarefas</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" />
<script src="https://code.jquery.com/jquery-3.3.1.js">
	
</script>
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
</head>
<body id="page-top">
	<div id="wrapper">

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-2 text-gray-800 tab">Tarefas</h1>
					</div>

					<!-- DataTales Example -->
					<div class="card mb-4 text-center">
						<div class="card-body">
							<div class="table-responsive">
								<table id="tabela_id" class="display" style="width: 100%">
									<thead>
										<tr>
											<th class="align-middle text-center">Id</th>
											<th class="align-middle text-center">Titulo</th>
											<th class="align-middle text-center">Usuário</th>
											<th class="align-middle text-center">Data</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${tarefas}" var="tarefa">
											<tr>
												<td><c:out value="${tarefa.id}" /></td>
												<td><c:out value="${tarefa.titulo}" /></td>
												<td><c:out value="${tarefa.usuario.nome}" /></td>
												<td><fmt:formatDate pattern="dd/MM/yyyy"
														value="${tarefa.dataTarefa}" /></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<button type="button" class="btn btn-primary"
		style="margin-left: 10px;"
		onclick="location.href='usuarioController?action=listaUsuario'">
		Lista de Usuários</button>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#tabela_id').dataTable();
		});
	</script>
</body>
</html>