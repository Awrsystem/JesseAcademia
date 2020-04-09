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
		<form id="formPesquisar" action="/Escola/Atividade/salvar" method="post">
			<input name="cdId" type="hidden" value="${Atividade.cdId}" />
			
			<p>
				<label for="nmAtividade">*Atividade: </label>
				<input id="nmAtividade" name="nmAtividade" type="text" value="${Atividade.nmAtividade}"/>
			</p>
			
			<p>
			</p>
							
			<div class="form-group">
				<label for="fkDisciplina">*Disciplina:</label>
				<select id="fkDisciplina" name="fkDisciplina" required title="Disciplina:
									Campo de preenchimento obrigatório" >
					
					<option label="Selecione uma disciplina"></option>
       					<c:forEach var="Disciplina" items="${listDisciplina}">
					<option value="${Disciplina.cdId}" ${Atividade.fkDisciplina == Disciplina.cdId ? 'selected' : ''}>${Disciplina.nmDisciplina}</option>
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