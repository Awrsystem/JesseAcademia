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
		<a href="/Escola/Usuario/novo">Cadastrar Usuario</a>
	</p>
		<legend>Pesquisar</legend>
		<form id="formPesquisar" action="/Escola/Usuario/pesquisar">
			<p>
				<label for="nmUsuario">Nome: </label>
				<input id="nmUsuario" name="nmUsuario" type="text" value="${filtro.nmUsuario}"/>
			</p>
			
			
			<div class="form-group">
				<label for="fkPerfil">*Perfil:</label>
				<select id="fkPerfil" name="fkPerfil" required title="Perfil:
									Campo de preenchimento obrigatório" >
					
					<option label="Selecione um perfil"></option>
       					<c:forEach var="Perfil" items="${listPerfil}">
					<option value="${Perfil.cdId}" ${Usuario.fkPerfil == Perfil.cdId ? 'selected' : ''}>${Perfil.nmPerfil}</option>
						</c:forEach>
				</select>
			</div>				
			
			
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
	<form id="formListar" action="/Escola/Usuario/listar" method="get">
		<table style="border: 1px solid;">
			<thead>
				<tr style="border: 1px solid;">
					<th style="border: 1px solid;">Ações:</th>
					<th style="border: 1px solid;">Nome</th>
					<th style="border: 1px solid;">Senha</th>
					<th style="border: 1px solid;">Email</th>
					<th style="border: 1px solid;">Perfil</th>
					<th style="border: 1px solid;">Situação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="Usuario" items="${listUsuario}">
					<tr>
						<td style="border: 1px solid;">
							<a href="/Escola/Usuario/visualizar/${Usuario.cdId}">Visualizar</a>
							<a href="/Escola/Usuario/editar/${Usuario.cdId}">Editar</a>
							<a href="/Escola/Usuario/excluir/${Usuario.cdId}">Excluir</a>
						</td>
						<td style="border: 1px solid;">${Usuario.nmUsuario}</td>
						<td style="border: 1px solid;">${Usuario.dsSenha}</td>
						<td style="border: 1px solid;">${Usuario.dsEmail}</td>
						<td style="border: 1px solid;">${Usuario.perfil.nmPerfil}</td>
						<td style="border: 1px solid;">${Usuario.flSituacaoString}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>

</html>