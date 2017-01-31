<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Minhas notas</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Minhas notas</h1>
	<p>${msg}</p>
	<p>Nome do aluno: ${aluno.nome}</p>
	<p>Média Geral: ${aluno.mediaGeral}</p>
	<p>Status de aprovação: ${aluno.aprovacao}</p>
	
	<table border="1">
		<tr>
			<td>Curso</td>
			<td>Disciplina</td>
			<td>Media</td>
			<td>Aprovado</td>
		</tr>
		<c:forEach var="alunoDisciplina" items="${aluno.alunoDisciplina }">
		<tr>
			<td>${alunoDisciplina.disciplina.curso.nome}</td>
			<td>${alunoDisciplina.disciplina.nome}</td>
			<td>${alunoDisciplina.media}</td>
			<td>${alunoDisciplina.aprovacao}</td>
		</tr>
		
		</c:forEach>
	</table>
</body>
</html>