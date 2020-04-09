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
		<a href="/Escola/Curso/novo">Cadastrar novo curso</a>
	</p>
		<legend>Pesquisar</legend>
		<form id="formPesquisar" action="/Escola/Curso/pesquisar">
			<p>
				<label for="nmCurso">Curso: </label>
				<input id="nmCurso" name="nmCurso" type="text" value="${filtro.nmCurso}"/>
			</p>
			<!-- 
			<p>
				<label for="fkTipoCurso">Tipo do Curso: </label>
				<input id="fkTipoCurso" name="fkTipoCurso" type="text" value="${filtro.fkTipoCurso}"/>
				
			</p>
			-->
			
			<div class="form-group">
				<label for="fkTipoCurso">Tipo do curso:</label>
				<select id="fkTipoCurso" name="fkTipoCurso" >
					
					<option label="Selecione um tipo de curso"></option>
       					<c:forEach var="TipoCurso" items="${listTipoCurso}">
					<option value="${TipoCurso.cdId}" ${Curso.fkTipoCurso == TipoCurso.cdId ? 'selected' : ''}>${TipoCurso.nmTipoCurso}</option>
						</c:forEach>
				</select>
			</div>		
			<br>		
			<input type="submit" value="pesquisar" />
		</form>
	</fieldset>
	<br></br>
	<br></br>
	<form id="formListar" action="/Escola/Curso/listar" method="get">
		<table style="border: 1px solid;">
			<thead>
				<tr style="border: 1px solid;">
					<th style="border: 1px solid;">Ações:</th>
					<th style="border: 1px solid;">Curso</th>
					<th style="border: 1px solid;">Tipo do Curso</th>
					<th style="border: 1px solid;">Valor Mensal</th>
					<th style="border: 1px solid;">Duração (meses)</th>
					<th style="border: 1px solid;">Situação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="Curso" items="${listCurso}">
					<tr>
						<td style="border: 1px solid;">
							<a href="/Escola/visualizar/${Curso.cdId}">Visualizar</a>
							<a href="/Escola/Curso/editar/${Curso.cdId}">Editar</a>
							<a href="/Escola/Curso/excluir/${Curso.cdId}">Excluir</a>
						</td>
						<td style="border: 1px solid;">${Curso.nmCurso}</td>
						<td style="border: 1px solid;">${Curso.tipoCurso.nmTipoCurso}</td>
						<td style="border: 1px solid;">${Curso.vlMensalCurso}</td>
						<td style="border: 1px solid;">${Curso.nrDuracao}</td>
						<td style="border: 1px solid;">${Curso.flSituacaoString}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>

</html>