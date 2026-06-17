# Gerenciador de Cursos API

Uma API REST desenvolvida em **Java** com **Spring Boot** para o gerenciamento de cursos, instrutores e matrículas. Este projeto serve como um excelente ponto de partida para sistemas educacionais ou plataformas de cursos online.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **MySQL** 
- **Lombok** 
- **Maven** 

##  Estrutura de Endpoints (API REST)

A aplicação expõe os seguintes endpoints principais:

###  Cursos (`/cursos`)
- `GET /cursos` - Lista todos os cursos
- `GET /cursos/{id}` - Busca um curso pelo ID
- `POST /cursos` - Cadastra um novo curso
- `PUT /cursos/{id}` - Atualiza os dados de um curso
- `DELETE /cursos/{id}` - Remove um curso

###  Instrutores (`/instrutor`)
- `GET /instrutor` - Lista todos os instrutores
- `GET /instrutor/{id}` - Busca um instrutor pelo ID
- `POST /instrutor` - Cadastra um novo instrutor
- `PUT /instrutor/{id}` - Atualiza os dados de um instrutor
- `DELETE /instrutor/{id}` - Remove um instrutor

###  Matrículas (`/matriculas`)
- `GET /matriculas` - Lista todas as matrículas
- `GET /matriculas/{id}` - Busca uma matrícula pelo ID
- `POST /matriculas` - Registra uma nova matrícula
- `PUT /matriculas/{id}` - Atualiza completamente uma matrícula
- `PATCH /matriculas/{id}` - Atualiza parcialmente uma matrícula
- `DELETE /matriculas/{id}` - Cancela/Remove uma matrícula

##  Como Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/SEU_USUARIO/cursos.git
   ```

2. **Configuração do Banco de Dados:**
   - Certifique-se de ter o MySQL instalado e rodando na porta `3306`.
   - Crie um banco de dados chamado `cursos_db`.
   - Edite o arquivo `src/main/resources/application.properties` com as credenciais do seu banco:
     ```properties
     spring.datasource.username=seu_usuario
     spring.datasource.password=sua_senha
     ```

3. **Execute a aplicação:**
   Na raiz do projeto, execute:
   ```bash
   ./mvnw spring-boot:run
   ```
   *A API estará disponível em `http://localhost:8081`.*


---

