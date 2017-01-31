# CadastrarCursos

Para inicializar o projeto:

1. No banco Mysql (localhost:3306) criar o schema dbcursos;

2. Alterar o persistence.xml com user e password para conexão ao banco de dados;

3. Inserir o usuário administrativo com o seguinte script:

	INSERT INTO `dbcursos`.`USUARIO`(NOME,PERFIL,SENHA) VALUES ('Admin','ADMIN','123456');

4. Adicionar o projeto ao Tomcat 8;

5. O projeto pode ser acessado pela URL:

	http://localhost:8080/CadastroCursos/menu.jsp