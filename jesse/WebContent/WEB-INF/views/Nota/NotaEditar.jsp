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
		<form id="formPesquisar" action="/Escola/Nota/salvar" method="post">
			<input name="cdId" type="hidden" value="${Nota.cdId}" />
			
			<p>
				<label for="vlNota">*Nota: </label>
				<input id="vlNota" name="vlNota" type="text" value="${Nota.vlNota}"/>
			</p>
			
			<p>
			</p>
							
			<div class="form-group">
				<label for="fkAtividade">*Atividade:</label>
				<select id="fkAtividade" name="fkAtividade" required title="Atividade:
									Campo de preenchimento obrigatório" >
					
					<option label="Selecione uma atividade"></option>
       					<c:forEach var="Atividade" items="${listAtividade}">
					<option value="${Atividade.cdId}" ${Nota.fkAtividade == Atividade.cdId ? 'selected' : ''}>${Atividade.nmAtividade}</option>
						</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="fkAluno">*Aluno:</label>
				<select id="fkAluno" name="fkAluno" required title="Aluno:
									Campo de preenchimento obrigatório" >
					
					<option label="Selecione um aluno"></option>
       					<c:forEach var="Usuario" items="${listUsuario}">
					<option value="${Usuario.cdId}" ${Nota.fkAluno == Usuario.cdId ? 'selected' : ''}>${Usuario.nmUsuario}</option>
						</c:forEach>
				</select>
			</div>						
			<p>
				<input type="submit" value="Salvar" />
				<input type="button" value="Cancelar" onclick="javascript:history.go(-1);"/>
			</p>
		</form>
	</fieldset>
</body>

</html>