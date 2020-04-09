<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<script src="<c:url value="../js/jquery-1.11.1.min.js"/>"></script>
</head>

<body>
	<fieldset>
	<p>
		<a href="/Escola/TipoCurso/novo">Cadastrar novo tipo de curso</a>
	</p>
		<legend>Pesquisar</legend>
		<form id="formPesquisar" action="/Escola/TipoCurso/pesquisar">
			<p>
				<label for="nmTipoCurso">Tipo do Curso: </label>
				<input id="nmTipoCurso" name="nmTipoCurso" type="text" value="${filtro.nmTipoCurso}"/>
			</p>
			<input type="submit" value="pesquisar" />
		</form>
	</fieldset>
	<br></br>
	<br></br>
	<form id="formListar" action="/Escola/TipoCurso/listar" method="get">
		<table style="border: 1px solid;">
			<thead>
				<tr style="border: 1px solid;">
					<th style="border: 1px solid;">Ações:</th>
					<th style="border: 1px solid;">Tipo do Curso</th>
					<th style="border: 1px solid;">Situação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="TipoCurso" items="${listTipoCurso}">
					<tr>
						<td style="border: 1px solid;">
							<a href="/Escola/TipoCurso/visualizar/${TipoCurso.cdId}">Visualizar</a>
							<a href="/Escola/TipoCurso/editar/${TipoCurso.cdId}">Editar</a>
							<a href="/Escola/TipoCurso/excluir/${TipoCurso.cdId}">Excluir</a>
						</td>
						<td style="border: 1px solid;">${TipoCurso.nmTipoCurso}</td>
						<td style="border: 1px solid;">${TipoCurso.flSituacaoString}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>

</html>