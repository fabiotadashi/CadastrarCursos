<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Cadastro de Cursos</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Cadastro de Cursos</h1>
	<jsp:useBean id="escolaBean" class="br.com.fiap.bean.EscolaBean" />
	<form action="curso" method="post">
		Nome: <input type="text" name="nome" size="10"  required/><br /> 
		Descri��o: <input type="text" name="descricao" size="10"  required/><br /> 
		Escola: <select name ="escola">
			<c:forEach var="escola" items="${escolaBean.listaEscola}">
				<option value="${escola.id}">${escola.nome}</option>
			</c:forEach>
		</select> 
		<br />
		<input type="submit" value="Enviar" />
	</form>
</body>
</html>
