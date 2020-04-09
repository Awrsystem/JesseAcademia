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
		<a href="/Escola/Atividade/novo">Cadastrar nova Atividade</a>
	</p>
		<legend>Pesquisar</legend>
		<form id="formPesquisar" action="/Escola/Atividade/pesquisar">
			<p>
				<label for="nmAtividade">Atividade: </label>
				<input id="nmAtividade" name="nmAtividade" type="text" value="${filtro.nmAtividade}"/>
			</p>
			
			
			<div class="form-group">
				<label for="fkDisciplina">Disciplina:</label>
				<select id="fkDisciplina" name="fkDisciplina" >
					
					<option label="Selecione uma disciplina"></option>
       					<c:forEach var="Disciplina" items="${listDisciplina}">
					<option value="${Disciplina.cdId}" ${Atividade.fkDisciplina == Disciplina.cdId ? 'selected' : ''}>${Disciplina.nmDisciplina}</option>
						</c:forEach>
				</select>
			</div>		
			<br>		
			<input type="submit" value="pesquisar" />
		</form>
	</fieldset>
	<br></br>
	<br></br>
	<form id="formListar" action="/Escola/Atividade/listar" method="get">
		<table style="border: 1px solid;">
			<thead>
				<tr style="border: 1px solid;">
					<th style="border: 1px solid;">Ações:</th>
					<th style="border: 1px solid;">Atividade</th>
					<th style="border: 1px solid;">Disciplina</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="Atividade" items="${listAtividade}">
					<tr>
						<td style="border: 1px solid;">
							<a href="/Escola/Atividade/visualizar/${Atividade.cdId}">Visualizar</a>
							<a href="/Escola/Atividade/editar/${Atividade.cdId}">Editar</a>
							<a href="/Escola/Atividade/excluir/${Atividade.cdId}">Excluir</a>
						</td>
						<td style="border: 1px solid;">${Atividade.nmAtividade}</td>
						<td style="border: 1px solid;">${Atividade.disciplina.nmDisciplina}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>

</html>