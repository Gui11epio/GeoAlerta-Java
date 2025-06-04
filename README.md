# 📦 GEOALERTA - API de Java
Este projeto é uma API REST desenvolvida com **Spring Boot**, foco na coleta e análise de dados climáticos para identificar riscos de deslizamento em determinadas regiões. O sistema recebe dados de sensores/meteo, armazena informações de usuários e endereços, e calcula o risco com base em regras predefinidas.

## GRUPO:
Guilherme Camasmie Laiber de Jesus - 554894, 

Pedro Manzo Yokoo - 556115, 

Fernando Fernandes Prado - 557982

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Gradle
- Spring Data JPA
- Oracle Database
- Swagger/OpenAPI
- ModelMapper
- Bean Validation
- Dockerfile
- JWT

## ⚙️ Como Executar o Projeto Localmente

### Passos

1. Clone o repositório ou extraia o conteúdo do `.zip`
2. - Vá nos três pontinhos  
![image](https://github.com/user-attachments/assets/5efa2b64-c870-4136-a5b9-f22159c3b2db)

- Clique em **"Run with Parameters"**  
![image](https://github.com/user-attachments/assets/f55d4cf2-9cf6-432a-ac06-77f5b379b813)

- Vá em **"Modify options"**  
![image](https://github.com/user-attachments/assets/9d75404e-61af-4735-93e1-d9e4e9e4f0a8)


- Ache e clique na opção "**Environment varibles**"  
![image](https://github.com/user-attachments/assets/bc1d0969-7712-4532-83a0-e6778dbecdc7)

- Clique no ícone ao lado da pasta  
![image](https://github.com/user-attachments/assets/82c657b8-5f39-4746-ae3f-8a11675052d9)

- Adicione "**db.user**" e "**db.passwb**" e, nos valores, coloque seu usuário e senha do Oracle DB.  
Depois clique **OK**, **APPLY** e **RUN**  
![image](https://github.com/user-attachments/assets/46029a42-c5be-40bc-a9d2-3e298b822e04)

3. Entre na pasta resources e entre no arquivo **application.properties**.
   
   ![image](https://github.com/user-attachments/assets/5b43a0e1-5cd5-42d2-acf3-8fe6d5d202b6)

4.Dentro do arquivo, altere o datasource, se necessário:

![image](https://github.com/user-attachments/assets/e2134110-0527-4bfb-a51a-964daa91b6a7)

5. Volte para a Main do projeto e rode ele

## ⚙️ Executar o Projeto pelo Render
No caso do Render vai ser utilizado o nosso banco de dados

Para acessar no Swagger:
```bash
https://geoalerta-java.onrender.com/swagger-ui/index.html#/
```

Para o Postman:
```bash
https://geoalerta-java.onrender.com/
```

## 🧭 Como Utilizar a API via Swagger
A API pode ser acessada via Swagger para fazer os testes do projeto. Disponível após subir o projeto:

🔗 Acesse:

http://localhost:8080/swagger-ui/index.html#/

## 🗂️  Caminhos Disponíveis

📍 USUÁRIO

- Endpoint: GET/usuarios/{id}
  
     **Pega usuário por Id**

- Endpoint: PUT/usuarios/{id}

     **Atualiza o usuário por Id**

- Endpoint: DELETE/usuarios/{id}

     **Deleta o usuário por Id**

- Endpoint: GET/usuarios

     **Pega todos os usuários**

- Endpoint: POST/usuarios

     **Cadastra um usuário**


📍 ENDEREÇO(Disponível apenas depois do Login)

- Endpoint: GET/enderecos/{id}
  
     **Pega endereço por Id**

- Endpoint: PUT/enderecos/{id}

     **Atualiza o endereço por Id**

- Endpoint: DELETE/enderecos/{id}

     **Deleta o endereço por Id**

- Endpoint: GET/enderecos

     **Pega todos os endereços**

- Endpoint: POST/enderecos

     **Cadastra um endereço**



📍 ALERTA(Disponível apenas depois do Login)

- Endpoint: POST/alerta

     **Faz o alerta sobre os deslizamentos, usando o id do usuário e endereço**


📍 AUTH

- Endpoint: POST/auth/login

     **Faz o Login, mandando o email e senha já cadastrados para serem validados. Também gera o Tokem.**












