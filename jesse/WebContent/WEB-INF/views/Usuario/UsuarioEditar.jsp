<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<script src="<c:url value="js/jquery-1.11.1.min.js"/>"></script>
</head>

<body>
	<fieldset>
		<legend>Cadastrar</legend>
		<form id="formPesquisar" action="/Aula_04_-_PrimeiroCRUD/Usuario/salvar" method="post">
			<input name="cdId" type="hidden" value="${Usuario.cdId}" />
			
			<p>
				<label for="nmUsuario">*Nome do Usuario: </label>
				<input id="nmUsuario" name="nmUsuario" type="text" value="${Usuario.nmUsuario}"/>
			</p>
			<p>
				<label for="dsSenha">*Senha: </label>
				<input id="dsSenha" name="dsSenha" type="text" value="${Usuario.dsSenha}"/>
		
			</p>
			<p>
				<label for="dsEmail">*Email: </label>
				<input id="dsEmail" name="dsEmail" type="text" value="${Usuario.dsEmail}"/>
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
				<input id="flSituacao" name="flSituacao" type="radio" value="true" ${Usuario.flSituacao ? 'checked="checked"' : '' } />Ativo
				<input id="flSituacao" name="flSituacao" type="radio" value="false" ${!Usuario.flSituacao ? 'checked="checked"' : '' } />Inativo
			</p>
			<p>
				<input type="submit" value="Salvar" />
				<input type="button" value="Cancelar" onclick="javascript:history.go(-1);"/>
			</p>
		</form>
	</fieldset>
</body>

</html>