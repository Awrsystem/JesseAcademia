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
			<label for="nmAtividade">Atividade: </label>
			<input id="nmAtividade" name="nmAtividade" type="text" readonly="readonly" value="${Atividade.nmAtividade}"/>
		</p>
		
		<p>
			<label for="fkDisciplina"> Disciplina: </label>
			<input id="fkDisciplina" name="fkDisciplina" type="text" readonly="readonly" value="${Atividade.disciplina.nmDisciplina}"/>
		</p>	
		<p>
			<input type="button" value="Voltar" onclick="javascript:history.go(-1);"/>
		</p>
	</fieldset>
</body>

</html>