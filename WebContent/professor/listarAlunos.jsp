<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista de Alunos</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Lista de Alunos</h1>
	<jsp:useBean id="usuarioBean" class="br.com.fiap.bean.UsuarioBean" />
	<jsp:useBean id="cursoBean" class="br.com.fiap.bean.CursoBean" />
	<form action="listarAlunos" method="get">
		Buscar por professor:<select name="professor">
			<option value="">Selecione...</option>
			<c:forEach var="p" items="${usuarioBean.listaProfessor}">
				<option value="${p.id}">${p.nome}</option>
			</c:forEach>
		</select> <br /> 
		ou<br />
		Buscar por curso:<select name="curso">
			<option value="">Selecione...</option>
			<c:forEach var="curso" items="${cursoBean.listaCurso}">
				<option value="${curso.id}">${curso.nome}</option>
			</c:forEach>
		</select> <br /> 
		<input type="submit" value="Buscar" /><br /> 
		<p>${msg}</p>
	</form>
	<table border="1">
		<tr>
			<td>Nome</td>
			<td>Perfil</td>
			<td>Media Geral</td>
			<td>Aprovado</td>
		</tr>
		<c:forEach var="usuario" items="${listaAlunos}">
		<tr>
			<td>${usuario.nome}</td>
			<td>${usuario.perfil}</td>
			<td>${usuario.mediaGeral }</td>
			<td>${usuario.aprovacao }</td>
		</tr>
		
		</c:forEach>
	</table>
</body>
</html>