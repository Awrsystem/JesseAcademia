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
		<form id="formPesquisar" action="/Aula_04_-_PrimeiroCRUD/Perfil/salvar" method="post">
			<input name="cdId" type="hidden" value="${Perfil.cdId}" />
			
			<p>
				<label for="nmPerfil">*Perfil: </label>
				<input id="nmPerfil" name="nmPerfil" type="text" value="${Perfil.nmPerfil}"/>
			</p>
			<p>
				<label for="dsIdentificador">*Identificador: </label>
				<input id="dsIdentificador" name="dsIdentificador" type="text" value="${Perfil.dsIdentificador}"/>
			</p>
			<p>
				<label for="flSituacao">Situação: </label>
				<input id="flSituacao" name="flSituacao" type="radio" value="true" ${Perfil.flSituacao ? 'checked="checked"' : '' } />Ativo
				<input id="flSituacao" name="flSituacao" type="radio" value="false" ${!Perfil.flSituacao ? 'checked="checked"' : '' } />Inativo
			</p>
			<p>
				<input type="submit" value="Salvar" />
				<input type="button" value="Cancelar" onclick="javascript:history.go(-1);"/>
			</p>
		</form>
	</fieldset>
</body>

</html>