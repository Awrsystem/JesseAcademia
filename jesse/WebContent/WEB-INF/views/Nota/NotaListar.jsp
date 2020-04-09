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
		<a href="/Escola/Nota/novo">Cadastrar nova Nota</a>
	</p>
		<legend>Pesquisar</legend>
		<form id="formPesquisar" action="/Escola/Nota/pesquisar">
			<p>
				<label for="vlNota">Nota: </label>
				<input id="vlNota" name="vlNota" type="text" value="${filtro.vlNota}"/>
			</p>
			
			
			<div class="form-group">
				<label for="fkAtividade">Atividade:</label>
				<select id="fkAtividade" name="fkAtividade" >
					
					<option label="Selecione uma atividade"></option>
       					<c:forEach var="Atividade" items="${listAtividade}">
					<option value="${Atividade.cdId}" ${Nota.fkAtividade == Atividade.cdId ? 'selected' : ''}>${Atividade.nmAtividade}</option>
						</c:forEach>
				</select>
			</div>		
			<div class="form-group">
				<label for="fkAluno">Aluno:</label>
				<select id="fkAluno" name="fkAluno" >
					
					<option label="Selecione um aluno"></option>
       					<c:forEach var="Usuario" items="${listUsuario}">
					<option value="${Usuario.cdId}" ${Nota.fkAluno == Usuario.cdId ? 'selected' : ''}>${Usuario.nmUsuario}</option>
						</c:forEach>
				</select>
			</div>		
			<br>		
			<input type="submit" value="pesquisar" />
		</form>
	</fieldset>
	<br></br>
	<br></br>
	<form id="formListar" action="/Escola/Nota/listar" method="get">
		<table style="border: 1px solid;">
			<thead>
				<tr style="border: 1px solid;">
					<th style="border: 1px solid;">Ações:</th>
					<th style="border: 1px solid;">Nota</th>
					<th style="border: 1px solid;">Atividade</th>
					<th style="border: 1px solid;">Aluno</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="Nota" items="${listNota}">
					<tr>
						<td style="border: 1px solid;">
							<a href="/Escola/Nota/visualizar/${Nota.cdId}">Visualizar</a>
							<a href="/Escola/Nota/editar/${Nota.cdId}">Editar</a>
							<a href="/EscolaNota/excluir/${Nota.cdId}">Excluir</a>
						</td>
						<td style="border: 1px solid;">${Nota.vlNota}</td>
						<td style="border: 1px solid;">${Nota.atividade.nmAtividade}</td>
						<td style="border: 1px solid;">${Nota.usuario.nmUsuario}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>

</html>