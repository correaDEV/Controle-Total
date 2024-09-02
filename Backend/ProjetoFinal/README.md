 <h1>Backend - Controle Total</h1>

  <p>Este projeto utiliza Spring Boot 3.3.2 e Java 17 para o desenvolvimento do backend.</p>

   <h2>Pré-requisitos</h2>
    <p>Antes de executar o projeto, certifique-se de ter instalado em sua máquina:</p>
    <ul> 
        <li>Java Development Kit (JDK) 17</li>
        <li>Maven 3.6+ (opcional, caso não utilize o wrapper do Maven incluído no projeto)</li>
        <li>MySQL Server (ou outro banco de dados configurado no projeto)</li>
    </ul>

  <h2>Configuração do Banco de Dados</h2>
    <p>Configure o banco de dados MySQL criando um banco com o nome desejado. Em seguida, ajuste as propriedades de conexão no arquivo <code>application.properties</code>, localizado em <code>src/main/resources/</code>, com as informações corretas de URL, usuário e senha do banco de dados.</p>

  <h2>Executando o Projeto</h2>
    <p>Para executar o projeto, siga os seguintes passos:</p>
    <ol>
        <li>Navegue até o diretório raiz do projeto onde o arquivo <code>pom.xml</code> está localizado.</li>
        <li>Execute o comando <code>./mvnw spring-boot:run</code> no terminal (para Linux/Mac) ou <code>mvnw.cmd spring-boot:run</code> (para Windows) para iniciar o servidor Spring Boot.</li>
        <li>Após a inicialização bem-sucedida, o backend estará disponível em <code>http://localhost:8080/</code>.</li>
    </ol>

   <h2>Testando as APIs</h2>
    <p>Utilize o Postman ou qualquer outro cliente REST para testar as APIs. O projeto inclui controladores para:</p>
    <ul>
        <li><strong>Rendas</strong>: APIs para operações de CRUD relacionadas às rendas.</li>
        <li><strong>Despesas</strong>: APIs para operações de CRUD relacionadas às despesas.</li>
        <li><strong>Estatísticas</strong>: APIs para obter estatísticas financeiras, como saldo, despesas totais e receitas totais.</li>
    </ul>

  <h2>Compilando o Projeto</h2>
    <p>Para compilar o projeto em um arquivo JAR executável, utilize o comando <code>./mvnw clean package</code> no terminal. O arquivo JAR será gerado no diretório <code>target/</code>.</p>

  <h2>Executando o Arquivo JAR</h2>
    <p>Após a compilação, você pode executar o projeto diretamente pelo JAR gerado com o comando:</p>
    <code>java -jar target/nome-do-arquivo.jar</code>
    <p>Substitua <code>nome-do-arquivo.jar</code> pelo nome real do arquivo JAR gerado.</p>

   <h2>Testes</h2>
    <p>Para executar testes unitários e de integração, utilize o comando <code>./mvnw test</code>. Os relatórios de testes serão exibidos diretamente no terminal.</p>

   <h2>Documentação Adicional</h2>
    <p>Para mais informações sobre como utilizar o Spring Boot e suas funcionalidades, consulte a <a href="https://spring.io/projects/spring-boot" target="_blank">documentação oficial do Spring Boot</a>.</p>
