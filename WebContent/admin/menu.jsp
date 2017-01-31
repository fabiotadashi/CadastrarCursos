<!DOCTYPE html>
<html>
<head>
<title>Menu de opções</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<form>
		<h1>Menu de opções</h1>
		<ul>
			<li><a href="/CadastroCursos/admin/escola.jsp">Cadastro de Escolas</a></li>
			<li><a href="/CadastroCursos/admin/curso.jsp">Cadastro de Curso</a></li>
			<li><a href="/CadastroCursos/admin/professor.jsp">Cadastro de Professor</a></li>
			<li><a href="/CadastroCursos/admin/disciplina.jsp">Cadastro de Disciplina</a></li>
			<li><a href="/CadastroCursos/admin/aluno.jsp">Cadastro de Aluno</a></li>
			<li><a href="/CadastroCursos/admin/matricularAluno.jsp">Matricular Aluno em Curso</a></li>
			<li><a href="/CadastroCursos/admin/listarCursos.jsp">Listar Cursos</a></li>
			<li><a href="/CadastroCursos/professor/listarAlunos.jsp">Listar Alunos</a></li>
		</ul>
		<p>${msg}</p>
	</form>
</body>
</html>