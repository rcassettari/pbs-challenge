<h2>API REST para gerenciamento de movimento financeiro de forma manual com Spring Boot</h2>

Foi desenvolvida uma API REST para o gerenciamento de movimentos financeiros, API criada com o Spring Boot, que permite incluir um movimento manual para um determinado produto e cosifCode, bem como consultar os movimentos manuais já inclusos.

Foram utilizados para o projeto:

* Banco de dados H2, em memória;
* import.sql para carregar alguns registros na tabela PRODUTO e na tabela PRODUTO_COSIF assim que 
 o serviço for inicializado;
* Foram feitas validações de entrada no método de inclusão de movimentos manuais, bem como uma
 validação de path variable no método de consulta de PRODUTO_COSIF por código de produto; 

**Interpretação de regras**

Na tabela PRODUTO e na tabela PRODUTO_COSIF existe uma coluna STA_STATUS.
Foi feita uma interpretação que isso indica um registro de PRODUTO ou PRODUTO_COSIF ativo ou inativo ( A ou I ) e, para fins de uso no cadastro de movimentos, só devemos usar os registro ativos.

Campo MOVIMENTO_MANUAL.DAT_MES : Foi feita uma interpretação implícita que o mês informado deveria ser tratado para que fosse aceito somente os valores de 1 a 12, conforme os meses do ano.
 
Campo MOVIMENTO_MANUAL.DES_DESCRICAO : foi feito tratamento para que o tamanho mínimo da entrada aceita seja de 10 caracteres.

Foram feitas tratamentos de entrada adicionais nos campos para a inclusão do registro de movimento manual, em conformidade com as especificações do modelo relacional original informado.  

**Endpoints de APIs disponíveis**

- Para listar todos os produtos ativos (GET sem body):

```
http://localhost:8085/v1/product/allactive

Retorno possível:

[
    {
        "code": "0001",
        "description": "Desc 001"
    },
    {
        "code": "0002",
        "description": "Desc 002"
    }
]

```

- Para listar um produto_cosif ativo, para um determinado código de produto específico ( GET sem body ):

```
http://localhost:8085/v1/productcosif/allactive/product/0001

Retorno possível:

[
    {
        "cosifCode": "00000000001",
        "classificationCode": "Alfa"
    },
    {
        "cosifCode": "00000000002",
        "classificationCode": "Beta"
    }
]


```

- Para incluir um determinado movimento manual (POST com body ): 

```
http://localhost:8085/v1/manualmovement

Exemplo de body usado durante os testes:

{
    "monthOfYear":1,
    "year":2023,
    "cosifCode":"00000000001",
    "productCode":"0001",
    "value":1234567890123456.45,
    "description":"Teste 1234"
}

```

- Para consultar todos os movimentos manuais existentes (GET sem body):

```

Exemplo de retorno obtido durante os testes:

http://localhost:8085/v1/manualmovement

[
    {
        "monthOfYear": 1,
        "year": 2023,
        "noteNumber": 1,
        "value": 1234567890123456.45,
        "description": "Teste 1234",
        "product": {
            "code": "0001",
            "description": "Desc 001"
        }
    }
]

```

Foram feitos e abordados os seguintes tópicos:

* Setup inicial de projeto com o Spring Boot Initialzr
* Criação de modelo de dados para o mapeamento de entidades em bancos de dados, usando JPA e 
 que, em tempo de execução, usa o framework hibernate para acesso.
* Desenvolvimento de operações de gerenciamento de movimentos manuais ( Inclusão / Consulta ).
* Relação de cada uma das operações acima com o padrão arquitetural REST;

São necessários os seguintes pré-requisitos para a execução do projeto desenvolvido:

* Java 17 ou versões superiores.
* Maven 3.8.4 ou versões superiores.
* Intellj IDEA Community Edition ou sua IDE favorita.
* Lombok implantado no IDE;
* Controle de versão GIT instalado na sua máquina.
* Conta no GitHub para o armazenamento do seu projeto na nuvem.

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:8085/v1/product/allactive
```

Abaixo, seguem links de referência usados no projeto :

* [SDKMan! para gerenciamento e instalação do Java e Maven](https://sdkman.io/)
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.2/maven-plugin/reference/html/)
* [Referência do Intellij IDEA Community, para download](https://www.jetbrains.com/idea/download)
* [Palheta de atalhos de comandos do Intellij](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf)
* [Site oficial do Spring](https://spring.io/)
* [Site oficial do Spring Initialzr, para setup do projeto](https://start.spring.io/)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.7.2/reference/htmlsingle/#actuator)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.2/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.2/reference/htmlsingle/#web)
* [Site oficial do GIT](https://git-scm.com/)
* [Site oficial do GitHub](http://github.com/)
* [Documentação oficial do Lombok](https://projectlombok.org/)
* [Documentação oficial do Map Struct](https://mapstruct.org/)
* [Referência para o padrão arquitetural REST](https://restfulapi.net/)

Segue alguns guias para entendimento dos conceitos usados no projeto:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)



