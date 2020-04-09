<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<script src="<c:url value="js/jquery-1.11.1.min.js"/>"></script>
</head>


<body>
	<fieldset>
		<legend>Visualizar</legend>
		
		<p>
			<label for="nmUsuario">Usuario: </label>
			<input id="nmUsuario" name="nmUsuario" type="text" readonly="readonly" value="${Usuario.nmUsuario}"/>
		</p>
		<p>
			<label for="dsEmail"> Email: </label>
			<input id="dsEmail" name="dsEmail" type="text" readonly="readonly" value="${Usuario.dsEmail}"/>
		</p>
		<p>
			<label for="pkPerfil">Perfil: </label>
			<input id="pkPerfil" name="pkPerfil" type="text" readonly="readonly" value="${Usuario.perfil.nmPerfil}"/>
		</p>
		<p>
			<label for="flSituacao">Situação: </label>
			<input id="flSituacao" name="flSituacao" type="text" readonly="readonly" value="${Usuario.flSituacaoString}"/>
		</p>
		<p>
			<input type="button" value="Voltar" onclick="javascript:history.go(-1);"/>
		</p>
	</fieldset>
</body>

</html>