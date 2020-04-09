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
		<form id="formPesquisar" action="/Escola/Curso/salvar" method="post">
			<input name="cdId" type="hidden" value="${Curso.cdId}" />
			
			<p>
				<label for="nmCurso">*Nome do Curso: </label>
				<input id="nmCurso" name="nmCurso" type="text" value="${Curso.nmCurso}"/>
			</p>
			
			<p>
			<!--
				 <label for="fkTipoCurso">*Tipo do Curso: </label>
				<input id="fkTipoCurso" name="fkTipoCurso" type="text" value="${Curso.fkTipoCurso}"/>
				
			-->
			</p>
							
			<div class="form-group">
				<label for="fkTipoCurso">*Tipo do curso:</label>
				<select id="fkTipoCurso" name="fkTipoCurso" required title="Tipo do curso:
									Campo de preenchimento obrigatório" >
					
					<option label="Selecione um tipo de curso"></option>
       					<c:forEach var="TipoCurso" items="${listTipoCurso}">
					<option value="${TipoCurso.cdId}" ${Curso.fkTipoCurso == TipoCurso.cdId ? 'selected' : ''}>${TipoCurso.nmTipoCurso}</option>
						</c:forEach>
				</select>
			</div>				
				 
			<p>
				<label for="vlMensalCurso">Valor Mensal do Curso: </label>
				<input id="vlMensalCurso" name="vlMensalCurso" type="text" value="${Curso.vlMensalCurso}"/>
			</p>
			<p>
				<label for="nrDuracao">Duração (meses): </label>
				<input id="nrDuracao" name="nrDuracao" type="text" value="${Curso.nrDuracao}"/>
			</p>
			<!-- <p>
				<label for="nm_coordenador">Nome do Coordenador: </label>
				<input id="nm_coordenador" name="nm_coordenador" type="text" value="${curso.nm_coordenador}"/>
			</p>  -->
			<p>
				<label for="flSituacao">*Situação: </label>
				<input id="flSituacao" name="flSituacao" type="radio" value="true" ${Curso.flSituacao ? 'checked="checked"' : '' } />Ativo
				<input id="flSituacao" name="flSituacao" type="radio" value="false" ${!Curso.flSituacao ? 'checked="checked"' : '' } />Inativo
			</p>
			<p>
				<input type="submit" value="Salvar" />
				<input type="button" value="Cancelar" onclick="javascript:history.go(-1);"/>
			</p>
		</form>
	</fieldset>
</body>

</html>