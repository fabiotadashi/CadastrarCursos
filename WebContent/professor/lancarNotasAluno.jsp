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
	<h1>Lançar Notas de ${alunoDisciplina.aluno.nome}</h1>

	<form action="lancarNotasAluno" method="post">
		<input type="hidden" value="${alunoDisciplina.id}" name="id">
		Projeto 1: <input type="number" value="${alunoDisciplina.projeto1}" name="projeto1" size="10" max="10" min="0"/><br /> 
		Projeto 2: <input type="number" value="${alunoDisciplina.projeto2}" name="projeto2" size="10"  max="10" min="0"/><br /> 
		Atividade Prática: <input type="number" value="${alunoDisciplina.atividadePratica}" name="atividadePratica" size="10"  max="10" min="0"/><br /> 
		<br /> <input type="submit" value="Salvar Notas" /><br />
	</form>
</body>
</html>