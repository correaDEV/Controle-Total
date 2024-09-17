# Controle Total - Backend ⚙️

Este é o backend da aplicação **Controle Total**, desenvolvido em **Spring Boot** como parte do projeto final da 7ª Academia Java.

O backend é responsável por fornecer a API REST que gerencia o sistema de controle financeiro pessoal.

## ✔️ Principais funcionalidades do backend

- API REST para gerenciar rendas e despesas (CRUD)
- Integração com banco de dados MySQL para persistência de dados

## 🛠 Tecnologias utilizadas

- **Java 17**
- **Spring Boot 3.3.2**
- **JPA/Hibernate** para persistência de dados
- **MySQL** como banco de dados
- **Lombok** para reduzir boilerplate
- **Maven** como gerenciador de dependências

## 📃 Configuração do ambiente

1. Clone o repositório e navegue até a pasta `backend`.
2. Configure o banco de dados MySQL no arquivo `application.properties` ou `application.yml`.
3. Rode o projeto com **Maven**:
   ```bash
   mvn spring-boot:run
