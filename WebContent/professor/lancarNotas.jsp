<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lançar Notas</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Lançar Notas</h1>
	<jsp:useBean id="disciplinaBean"
		class="br.com.fiap.bean.DisciplinaBean" />
	<form action="lancarNotas" method="get">
		Disciplina:<select name="disciplina">
			<option value="">Selecione...</option>
			<c:forEach var="d" items="${disciplinaBean.listaDisciplina}">
				<option value="${d.id}">${d.nome}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Buscar" /><br /> 
		<p>${msg}</p>
	</form>
	<form action="lancarNotas" method="post">
		<table border="1">
			<tr>
				<td>Nome</td>
				<td>Lançar notas</td>
				<td>Média da disciplina</td>
				<td>Aprovação</td>
			</tr>
			<c:forEach var="alunoDisciplina" items="${listaAlunos}">
				<tr>
					<td>${alunoDisciplina.aluno.nome}</td>
					<td><a href="/CadastroCursos/professor/lancarNotasAluno?alunoDisciplina=${alunoDisciplina.id}" >lançar</a></td>
					<td>${alunoDisciplina.media}</td>
					<td>${alunoDisciplina.aprovacao}</td>
				</tr>

			</c:forEach>
		</table>
	</form>
</body>
</html>