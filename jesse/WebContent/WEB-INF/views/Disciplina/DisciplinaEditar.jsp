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
		<form id="formPesquisar" action="/Escola/Disciplina/salvar" method="post">
			<input name="cdId" type="hidden" value="${Disciplina.cdId}" />
			
			<p>
				<label for="nmDisciplina">*Disciplina: </label>
				<input id="nmDisciplina" name="nmDisciplina" type="text" value="${Disciplina.nmDisciplina}"/>
			</p>
			
			<p>
			<!--
				 <label for="fkTipoCurso">*Tipo do Curso: </label>
				<input id="fkTipoCurso" name="fkTipoCurso" type="text" value="${Curso.fkTipoCurso}"/>
				
			-->
			</p>
							
			<div class="form-group">
				<label for="fkCurso">*Curso:</label>
				<select id="fkCurso" name="fkCurso" required title="Curso:
									Campo de preenchimento obrigatório" >
					
					<option label="Selecione um curso"></option>
       					<c:forEach var="Curso" items="${listCurso}">
					<option value="${Curso.cdId}" ${Disciplina.fkCurso == Curso.cdId ? 'selected' : ''}>${Curso.nmCurso}</option>
						</c:forEach>
				</select>
			</div>				
			
			<p>
				<label for="flSituacao">*Situação: </label>
				<input id="flSituacao" name="flSituacao" type="radio" value="true" ${Disciplina.flSituacao ? 'checked="checked"' : '' } />Ativo
				<input id="flSituacao" name="flSituacao" type="radio" value="false" ${!Disciplina.flSituacao ? 'checked="checked"' : '' } />Inativo
			</p>
			<p>
				<input type="submit" value="Salvar" />
				<input type="button" value="Cancelar" onclick="javascript:history.go(-1);"/>
			</p>
		</form>
	</fieldset>
</body>

</html>