<%@ page language="java" contentType="text/html;"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adicionar Novo Usuário</title>
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

<style type="text/css">
.form {
	position: absolute;
	top: 24;
	left: 0;
	width: 100%;
	height: 93%;
	background-color: #ddd;
}

.center {
	margin: 1% auto;
	align-items: center;
	display: flex;
	justify-content: center;	
	width: 40%;
}
</style>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="d-sm-flex align-items-center justify-content-between mb-4"
		align="center">
		<h1 class="h3 mb-2 text-gray-800 tab">Cadastrar Usuário</h1>
	</div>

	<form method="POST" action='usuarioController' name="frmAddUsuario">
		<div class="form">
			<div class="center">
				<label>Nome</label> <input type="text" name="nome"
					value="<c:out value="${usuario.nome}" />" required />
			</div>
			<div class="center">
				<label>E-mail</label> <input type="text" name="email"
					value="<c:out value="${usuario.email}" />" required />
			</div>
			<div class="center">
				<label>Senha</label> <input type="password" name="senha"
					value="<c:out value="${usuario.senha}" />" required />
			</div>
			<div class="center">
				<button type="submit" class="btn btn-primary" style="margin-left: 10px;">Salvar</button>
				<button type="button" class="btn btn-second"
					onclick="location.href='usuarioController?action=listaUsuario'" style="margin-left: 10px;">Voltar</button>
			</div>
		</div>
	</form>



</body>
</html>