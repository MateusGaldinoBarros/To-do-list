# 📝 To-Do List

Aplicação de gerenciamento de tarefas via terminal, desenvolvida em Java com persistência de dados em MySQL via JDBC.

## 🚀 Funcionalidades

- Adicionar tarefas com descrição e status
- Remover tarefas por ID com confirmação antes de deletar
- Alterar o status de uma tarefa existente
- Listar todas as tarefas cadastradas
- Filtrar tarefas por status (Concluída, Em andamento, Não feita)

## 🛠️ Tecnologias

- Java
- JDBC
- MySQL

## 🗄️ Configuração do Banco de Dados

Crie um banco de dados MySQL e execute o seguinte SQL para criar a tabela:

```sql
CREATE DATABASE to_do_list;

USE to_do_list;

CREATE TABLE tarefas (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    descricao   VARCHAR(255) NOT NULL,
    status      VARCHAR(50)  NOT NULL
);
```

## ▶️ Como rodar

**Pré-requisitos:**
- Java JDK instalado
- MySQL instalado e rodando
- MySQL Connector/J (JDBC driver)

**Passos:**

1. Clone o repositório:
```bash
git clone https://github.com/MateusGaldinoBarros/to-do-list.git
```

2. Abra o projeto no IntelliJ IDEA

3. Adicione o `mysql-connector-j.jar` nas bibliotecas do projeto em `File → Project Structure → Libraries`

4. Configure as credenciais do banco em `ConexaoDB.java`:
```java
private static final String URL     = "jdbc:mysql://localhost:3306/to_do_list";
private static final String USUARIO = "root";
private static final String SENHA   = "sua_senha";
```

5. Execute a classe `Main.java`

## 📁 Estrutura do projeto

```
src/
├── Main.java         — ponto de entrada e menu interativo
├── Menu.java         — exibe as opções do menu no terminal
├── Tarefa.java       — modelo que representa uma tarefa
├── TarefaDAO.java    — operações no banco de dados (CRUD + filtro)
└── ConexaoDB.java    — gerencia a conexão com o MySQL
```

## 👤 Autor

Mateus Galdino — [github.com/MateusGaldinoBarros](https://github.com/MateusGaldinoBarros)
