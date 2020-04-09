<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<script src="<c:url value="js/jquery-1.11.1.min.js"/>"></script>
	</head>
	
	<body>
				<a href="/Escola/" style="float: right">Sair do sistema</a><br>
				<div id="bemvindo" style="float: right"> Bem vindo(a) ${sessionScope.usuarioLogado.nmUsuario} </div>
		<p>
			<a href="/Escola/TipoCurso/">Acessar o cadastro de Tipo de Curso</a><br>
			<a href="/Escola/Curso/">Acessar o cadastro de Curso</a><br>
			<a href="/Escola/Usuario/"> Acessar o cadastro de Usuário</a><br>
			<a href="/Escola/Perfil/"> Acessar o cadastro de Perfil</a><br>
			<a href="/Escola/Disciplina/"> Acessar o cadastro da Disciplina</a><br>
			<a href="/Escola/Atividade/"> Acessar o cadastro da Atividade</a><br>
			<a href="/Escola/Nota/"> Acessar o cadastro da Nota</a>
		</p>
	</body>
</html>