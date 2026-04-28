# 📦 Stock API - Gerenciamento de Produtos

API REST desenvolvida com **Java + Spring Boot** para gerenciamento de estoque de produtos.

O sistema permite realizar operações completas de CRUD (Create, Read, Update, Delete), além de paginação e validações básicas.

---

## 🚀 Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate
* Banco de Dados H2 (em memória)
* Lombok

---

## 📁 Estrutura do Projeto

```
stock/
├── controller       # Camada de controle (endpoints REST)
├── service          # Regras de negócio
├── repository       # Acesso ao banco de dados
├── model            # Entidades JPA
├── dto              # Objetos de transferência de dados
├── exception        # Tratamento de erros
```

---

## ⚙️ Configuração do Projeto

O projeto utiliza banco de dados em memória **H2**, configurado no `application.properties`:

```properties
spring.application.name=stock

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

---

## 🗄️ Acesso ao Banco H2

Após iniciar a aplicação, acesse:

```
http://localhost:8080/h2-console
```

Credenciais:

* **JDBC URL:** `jdbc:h2:mem:testdb`
* **User:** `sa`
* **Password:** (vazio)

---

## 📊 Dados Iniciais

O sistema já inicia com diversos produtos cadastrados automaticamente (notebooks, smartphones, consoles, etc).

---

## 📌 Endpoints da API

### 🔹 Listar produtos (paginado)

```
GET /api/v1/products
```

Parâmetros:

* `page` → número da página
* `size` → quantidade por página (mín: 1 | máx: 50)

---

### 🔹 Buscar produto por ID

```
GET /api/v1/products/{id}
```

---

### 🔹 Criar produto

```
POST /api/v1/products
```

Body:

```json
{
  "name": "Produto Exemplo",
  "price": 100.0,
  "quantity": 10
}
```

---

### 🔹 Atualizar produto

```
PUT /api/v1/products/{id}
```

Body (parcial permitido):

```json
{
  "name": "Novo Nome",
  "price": 200.0
}
```

---

### 🔹 Deletar produto

```
DELETE /api/v1/products/{id}
```

---

## 📦 Modelo de Dados

### Product

| Campo    | Tipo    |
| -------- | ------- |
| id       | Integer |
| name     | String  |
| price    | Double  |
| quantity | Integer |

---

## ⚠️ Tratamento de Erros

O projeto possui tratamento básico de exceções:

* `NotFoundException` → Produto não encontrado
* `PageSizeExceededException` → Limite de paginação inválido

---

## ✅ Regras de Negócio

* Nenhum campo pode ser nulo ao criar produto
* Paginação limitada entre **1 e 50 itens**
* Atualização permite alteração parcial dos dados

---

## ▶️ Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/stock.git
```

2. Acesse o projeto:

```bash
cd stock
```

3. Execute a aplicação:

```bash
./mvnw spring-boot:run
```

ou rode pela sua IDE.

---

## 💡 Possíveis Melhorias

* 🔐 Implementar autenticação com JWT
* 📊 Adicionar filtros (por nome, preço, etc)
* 🧾 Documentação com Swagger/OpenAPI
* 🐘 Integração com banco PostgreSQL
* 📈 Controle de movimentação de estoque (entrada/saída)

---

## 👨‍💻 Autor

Desenvolvido por **Felipe Movio**

---

## 📄 Licença

Este projeto está sob a licença MIT.
