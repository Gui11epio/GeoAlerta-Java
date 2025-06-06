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


## Jsons para testes

- Cadastro de Usuario
```bash
{
  "user_name": "João Silva",
  "senha": "senhaSegura123",
  "email": "joao.silva@example.com",
  "telefone": "(11) 91234-5678"
}
```

- Para fazer o Login
```bash
{
  "email": "joao.silva@example.com",
  "senha": "senhaSegura123"
}
```

- Para cadastrar o Endereço(depois do Login)
```bash
{
  "bairro": "Centro",
  "cidade": "São Paulo",
  "usuarioId": 1
}
```

- Cadastro do Alerta(depois do Login)
✅ 1. MUITO_BAIXO
```bash
{
  "chuva": 0,
  "umidade": 40,
  "temperatura": 28,
  "vento": 2,
  "nuvens": 20,
  "pressao": 1015,
  "usuarioId": 1,
  "enderecoId": 1
}
```
🔸Score ≈ 17.7 
🔸NivelRisco: MUITO BAIXO
🔸Descrição: "Chuvas leves. Nenhum risco visível."
🔸Probabilidade: 15


✅ 2. BAIXO
```bash
{
  "chuva": 4,
  "umidade": 65,
  "temperatura": 25,
  "vento": 6,
  "nuvens": 50,
  "pressao": 1005,
  "usuarioId": 1,
  "enderecoId": 1
}
```
Score ≈ 1.2 + 13 + 0.6 + 2.5 + 9.5 + 0 = 27.8
🔸NivelRisco: BAIXO
🔸Probabilidade: 15

✅ 3. MODERADO
```bash
{
  "chuva": 12,
  "umidade": 80,
  "temperatura": 22,
  "vento": 10,
  "nuvens": 70,
  "pressao": 995,
  "usuarioId": 1,
  "enderecoId": 1
}
```
Score ≈ 3.6 + 16 + 1 + 3.5 + 10.5 + 0 = 34.6
🔸NivelRisco: MODERADO
🔸Probabilidade: 40

✅ 4. ALTO
```bash
{
  "chuva": 25,
  "umidade": 85,
  "temperatura": 17,
  "vento": 20,
  "nuvens": 85,
  "pressao": 980,
  "usuarioId": 1,
  "enderecoId": 1
}
```
🔸Score ≈ 43.05 → MODERADO (quase ALTO)
🔸Probabilidade: 40
Aumente a Chuva ou abaixe mais a Temperatura para forçar ALTO

✅ 5. CRÍTICO
```bash
{
  "chuva": 50,
  "umidade": 95,
  "temperatura": 10,
  "vento": 30,
  "nuvens": 95,
  "pressao": 960,
  "usuarioId": 1,
  "enderecoId": 1
}
```
🔸Score ≈ 56.75 → ALTO

✅ 6. CRÍTICO (forçado)
Com Chuva e Temperatura mais extremas:
```bash
{
  "chuva": 100,
  "umidade": 100,
  "temperatura": 5,
  "vento": 40,
  "nuvens": 100,
  "pressao": 950,
  "usuarioId": 1,
  "enderecoId": 1
}
```
🔸Score ≈ 30 + 20 + 4 + 5 + 15 + 1.5 = 75.5 → CRÍTICO













