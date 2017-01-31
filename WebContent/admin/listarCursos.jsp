<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista de Cursos</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Lista de Cursos</h1>
	<p>${msg}</p>
	<jsp:useBean id="usuarioBean" class="br.com.fiap.bean.UsuarioBean" />
	<form action="listarCursos" method="get">
		Buscar por professor:<select name="professor">
			<option value="">Selecione...</option>
			<c:forEach var="professor" items="${usuarioBean.listaProfessor}">
				<option value="${professor.id}">${professor.nome}</option>
			</c:forEach>
		</select> <br /> 
		<input type="submit" value="Enviar" /><br /> 
	</form>
	<table border="1">
		<tr>
			<td>Nome</td>
			<td>Descrição</td>
			<td>Listar alunos</td>
		</tr>
		<c:forEach var="curso" items="${listaCursos}">
		<tr>
			<td>${curso.nome}</td>
			<td>${curso.descricao}</td>
			<td><a href="/CadastroCursos/professor/listarAlunos?curso=<c:out value="${curso.id}"/>">listar</a></td>
		</tr>
		
		</c:forEach>
	</table>
</body>
</html>