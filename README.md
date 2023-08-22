<h1 align="center"> DESAFIO 2 - Locadora de veículos </h1>

## Dependências

- [Java](https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html)
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/)
- [Spring Data](https://spring.io/projects/spring-data-jpa)
- [PostgreSQL](https://www.postgresql.org/)
- [Lombok](https://projectlombok.org/)
- [Docker](https://www.docker.com/) 
- [Swagger](https://swagger.io/)


## Como clonar o projeto
```
git clone git@github.com:solutis-squad8/locadora.git
```
Instale as dependências do Maven

## Banco de dados
### Observações 
Para configurar as propriedades corretamente você deve:
* Renomear `application.properties.example` -> `application.properties`
* Altere dentro de `application.properties` seus valores para conexão do banco de dados
* url=jdbc:mysql: `//localhost:5432/locadora`
* username exemplo: `postgres`
* password exemplo: `root`

## Docker
### Para iniciar o projeto utilizando o Docker, siga os passos abaixo:
```
git clone git@github.com:solutis-squad8/locadora.git
docker-compose up -d
```
## Swagger
[Documentação em Swagger](http://localhost:8080/swagger-ui/index.html#/)

