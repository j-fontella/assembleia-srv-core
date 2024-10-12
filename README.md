# Gestor de Assembleias

Projeto para gerenciar votação de pautas em sessões de assembleias

## Tecnologias Utilizadas

- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Docker**: Plataforma para criação, envio e execução de aplicações em contêineres.
- **Docker Compose**: Ferramenta para definir e executar aplicações multi-contêiner.
- **Kafka**: Plataforma de streaming distribuída que permite publicar, armazenar e processar fluxos de dados em tempo real de forma escalável e durável. Utilizado para integração de sistemas, análise de dados em tempo real e processamento de eventos.

## Instalação

1. Clone este repositório:
   ```bash
    https://github.com/j-fontella/assembleia-srv-core.git

2. Antes de começar, verifique se você tem os seguintes softwares instalados:

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Java JDK 21 ou superior](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)

3. Compile o projeto
    Utilize o comando mvn clean install em um terminal na pasta do projeto

4. Suba os Containers
   Para iniciar os serviços, execute o seguinte comando:

```bash
docker-compose up --build
```
5.
    Para acessar a documentação acesse: 
    http://localhost:8080/swagger-ui/index.html