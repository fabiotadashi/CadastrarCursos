<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Cadastro de Disciplinas</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Cadastro de Disciplinas</h1>
	<jsp:useBean id="cursoBean" class="br.com.fiap.bean.CursoBean" />
	<jsp:useBean id="professorBean" class="br.com.fiap.bean.UsuarioBean" />
	<form action="disciplina" method="post">
		Nome: <input type="text" name="nome" size="10" /><br /> 
		Descrição: <input type="text" name="descricao" size="10" /><br /> 
		Curso: <select name ="curso">
			<c:forEach var="curso" items="${cursoBean.listaCurso}">
				<option value="${curso.id}">${curso.nome}</option>
			</c:forEach>
		</select> 
		<br />
		Professor: <select name ="professor">
			<c:forEach var="professor" items="${professorBean.listaProfessor}">
				<option value="${professor.id}">${professor.nome}</option>
			</c:forEach>
		</select> 
		<br />
		<input type="submit" value="Enviar" />
	</form>
</body>
</html>
