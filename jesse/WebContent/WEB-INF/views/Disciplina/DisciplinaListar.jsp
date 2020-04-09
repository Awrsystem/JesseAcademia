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
		<a href="/Escola/Disciplina/novo">Cadastrar nova Disciplina</a>
	</p>
		<legend>Pesquisar</legend>
		<form id="formPesquisar" action="/Escola/Disciplina/pesquisar">
			<p>
				<label for="nmDisciplina">Disciplina: </label>
				<input id="nmDisciplina" name="nmDisciplina" type="text" value="${filtro.nmDisciplina}"/>
			</p>
			
			
			<div class="form-group">
				<label for="fkCurso">Curso:</label>
				<select id="fkCurso" name="fkCurso" >
					
					<option label="Selecione um curso"></option>
       					<c:forEach var="Curso" items="${listCurso}">
					<option value="${Curso.cdId}" ${Disciplina.fkCurso == Curso.cdId ? 'selected' : ''}>${Curso.nmCurso}</option>
						</c:forEach>
				</select>
			</div>		
			<br>		
			<input type="submit" value="pesquisar" />
		</form>
	</fieldset>
	<br></br>
	<br></br>
	<form id="formListar" action="/Escola/Disciplina/listar" method="get">
		<table style="border: 1px solid;">
			<thead>
				<tr style="border: 1px solid;">
					<th style="border: 1px solid;">Ações:</th>
					<th style="border: 1px solid;">Disciplina</th>
					<th style="border: 1px solid;">Curso</th>
					<th style="border: 1px solid;">Situação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="Disciplina" items="${listDisciplina}">
					<tr>
						<td style="border: 1px solid;">
							<a href="/Escola/Disciplina/visualizar/${Disciplina.cdId}">Visualizar</a>
							<a href="/Escola/Disciplina/editar/${Disciplina.cdId}">Editar</a>
							<a href="/Escola/Disciplina/excluir/${Disciplina.cdId}">Excluir</a>
						</td>
						<td style="border: 1px solid;">${Disciplina.nmDisciplina}</td>
						<td style="border: 1px solid;">${Disciplina.curso.nmCurso}</td>
						<td style="border: 1px solid;">${Disciplina.flSituacaoString}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>

</html>