<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Matricular Aluno</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Matricular Aluno</h1>
	<jsp:useBean id="usuarioBean" class="br.com.fiap.bean.UsuarioBean" />
	<jsp:useBean id="cursoBean" class="br.com.fiap.bean.CursoBean" />
	<form action="matricula" method="post">
		Aluno:<select name="aluno">
			<c:forEach var="aluno" items="${usuarioBean.listaAlunos}">
				<option value="${aluno.id}">${aluno.nome}</option>
			</c:forEach>
		</select> <br /> 
		Curso:<select name="curso">
			<c:forEach var="curso" items="${cursoBean.listaCurso}">
				<option value="${curso.id}">${curso.nome}</option>
			</c:forEach>
		</select> <br /> 
		<input type="submit" value="Enviar" />
	</form>
</body>
</html>
