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
		<a href="/Escola/Perfil/novo">Cadastrar Perfil</a>
	</p>
		<legend>Pesquisar</legend>
		<form id="formPesquisar" action="/Aula_04_-_PrimeiroCRUD/Perfil/pesquisar">
			<p>
				<label for="nmPerfil">Perfil: </label>
				<input id="nmPerfil" name="nmPerfil" type="text" value="${filtro.nmPerfil}"/>
			</p>
			<p>
				<label for="flSituacao">Situação: </label>
				<input id="flSituacao" name="flSituacao" type="radio" value="true" ${filtro.flSituacao ? 'checked="checked"' : '' } />Ativo
				<input id="flSituacao" name="flSituacao" type="radio" value="false" ${!filtro.flSituacao ? 'checked="checked"' : '' } />Inativo
			</p>
						
			<input type="submit" value="pesquisar" />
		</form>
	</fieldset>
	<br></br>
	<br></br>
	<form id="formListar" action="/Escola/Perfil/listar" method="get">
		<table style="border: 1px solid;">
			<thead>
				<tr style="border: 1px solid;">
					<th style="border: 1px solid;">Ações:</th>
					<th style="border: 1px solid;">Perfil</th>
					<th style="border: 1px solid;">Identificador</th>
					<th style="border: 1px solid;">Situação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="Perfil" items="${listPerfil}">
					<tr>
						<td style="border: 1px solid;">
							<a href="/Escola/Perfil/visualizar/${Perfil.cdId}">Visualizar</a>
							<a href="/Escola/Perfil/editar/${Perfil.cdId}">Editar</a>
							<a href="/Escola/Perfil/excluir/${Perfil.cdId}">Excluir</a>
						</td>
						<td style="border: 1px solid;">${Perfil.nmPerfil}</td>
						<td style="border: 1px solid;">${Perfil.dsIdentificador}</td>
						<td style="border: 1px solid;">${Perfil.flSituacaoString}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>

</html>