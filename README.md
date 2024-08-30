# Estacionamento API

## Descrição

A API para o sistema de estacionamento permite o gerenciamento de fabricantes, modelos, status, tipos e veículos. A API oferece endpoints para criar, ler, atualizar e excluir (CRUD) cada um desses recursos.

<h2>Estrutura do Projeto</h2>
<p>O projeto está estruturado da seguinte forma:</p>
<ul>
    <li><strong>Entidades:</strong> Fabricante, Modelo, Tipo, Veículo, Status</li>
    <li><strong>DTOs:</strong> Objetos de Transferência de Dados usados para a comunicação entre o frontend e o backend.</li>
    <li><strong>Mappers:</strong> Conversão entre Entidades e DTOs.</li>
    <li><strong>Controllers:</strong> Manipulação das requisições HTTP e execução das operações CRUD.</li>
    <li><strong>Services:</strong> Lógica de negócio e manipulação de dados.</li>
</ul>

## Endpoints

### Fabricante

- <span style="color: green; font-weight: bold;">**POST /fabricantes**:</span> Cria um novo fabricante.
- <span style="color: blue; font-weight: bold;">**GET /fabricantes**:</span> Retorna uma lista de todos os fabricantes.
- <span style="color: blue; font-weight: bold;">**GET /fabricantes/{id}**:</span> Retorna o fabricante com o ID especificado.
- <span style="color: orange; font-weight: bold;">**PUT /fabricantes/{id}**:</span> Atualiza o fabricante com o ID especificado.
- <span style="color: red; font-weight: bold;">**DELETE /fabricantes/{id}**:</span> Exclui o fabricante com o ID especificado.

### Modelo

- <span style="color: green; font-weight: bold;">**POST /modelos**:</span> Cria um novo modelo.
- <span style="color: blue; font-weight: bold;">**GET /modelos**:</span> Retorna uma lista de todos os modelos.
- <span style="color: blue; font-weight: bold;">**GET /modelos/{id}**:</span> Retorna o modelo com o ID especificado.
- <span style="color: orange; font-weight: bold;">**PUT /modelos/{id}**:</span> Atualiza o modelo com o ID especificado.
- <span style="color: red; font-weight: bold;">**DELETE /modelos/{id}**:</span> Exclui o modelo com o ID especificado.

### Status

- <span style="color: green; font-weight: bold;">**POST /status**:</span> Cria um novo status.
- <span style="color: blue; font-weight: bold;">**GET /status**:</span> Retorna uma lista de todos os status.
- <span style="color: blue; font-weight: bold;">**GET /status/{id}**:</span> Retorna o status com o ID especificado.
- <span style="color: red; font-weight: bold;">**DELETE /status/{id}**:</span> Exclui o status com o ID especificado.

### Tipo

- <span style="color: green; font-weight: bold;">**POST /tipos**:</span> Cria um novo tipo.
- <span style="color: blue; font-weight: bold;">**GET /tipos**:</span> Retorna uma lista de todos os tipos.
- <span style="color: blue; font-weight: bold;">**GET /tipos/{id}**:</span> Retorna o tipo com o ID especificado.
- <span style="color: orange; font-weight: bold;">**PUT /tipos/{id}**:</span> Atualiza o tipo com o ID especificado.
- <span style="color: red; font-weight: bold;">**DELETE /tipos/{id}**:</span> Exclui o tipo com o ID especificado.

### Veículo

- <span style="color: green; font-weight: bold;">**POST /veiculos**:</span> Cria um novo veículo.
- <span style="color: blue; font-weight: bold;">**GET /veiculos**:</span> Retorna uma lista de todos os veículos.
- <span style="color: blue; font-weight: bold;">**GET /veiculos/{id}**:</span> Retorna o veículo com o ID especificado.
- <span style="color: orange; font-weight: bold;">**PUT /veiculos/{id}**:</span> Atualiza o veículo com o ID especificado.
- <span style="color: red; font-weight: bold;">**DELETE /veiculos/{id}**:</span> Exclui o veículo com o ID especificado.

  <h3>Configurar o Banco de Dados</h3>
<p>Crie um banco de dados MySQL com o nome "estacionamento".</p>
<p>No caminho <code>Estacionamento\estacionamento\src\main\resources</code>, crie o arquivo <code>application.properties</code></p>
<p>Adicione essas informações:</p>
<pre><code>spring.datasource.url=jdbc:mysql://localhost:3306/estacionamento
spring.datasource.username=usuario_do_banco
spring.datasource.password=senha_do_banco
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.main.allow-bean-definition-overriding=true
spring.jpa.hibernate.ddl-auto=update</code></pre>

## Swagger

Para testar e visualizar a documentação da API, acesse o Swagger UI em:

[http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)

## Configuração

Certifique-se de que todas as dependências estão instaladas e que o projeto está corretamente configurado para executar a API. Para iniciar o servidor, use o comando:

```bash
./mvnw spring-boot:run
