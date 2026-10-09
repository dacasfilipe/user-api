# User API

API de usuários desenvolvida com Spring Boot e PostgreSQL.

## Pré-requisitos

- Java 17
- Docker
- Docker Compose

O projeto inclui o Maven Wrapper, portanto não é necessário instalar o Maven separadamente.

## Subir o banco de dados

Na raiz do projeto, execute:

```bash
docker compose up -d
```

Se a instalação do Docker utilizar o comando legado, execute:

```bash
docker-compose up -d
```

Esse comando inicia um container PostgreSQL chamado `dev_ecommerce`, acessível na porta `5433` da máquina.

Para verificar se o container está em execução:

```bash
docker ps --filter name=dev_ecommerce
```

Para acompanhar os logs do banco:

```bash
docker logs -f dev_ecommerce
```

## Rodar a aplicação

Com o banco de dados em execução, rode:

```bash
./mvnw spring-boot:run
```

A API ficará disponível em:

```text
http://localhost:8080
```

Na primeira inicialização, o Flyway cria o schema e aplica as migrations presentes em `src/main/resources/db/migration`.

## Executar os testes

Os testes carregam o contexto da aplicação e precisam que o PostgreSQL esteja rodando:

```bash
./mvnw test
```

## Parar o banco de dados

Para parar e remover o container criado pelo Compose:

```bash
docker compose down
```

Ou, com o comando legado:

```bash
docker-compose down
```

Os dados atuais não usam um volume persistente e podem ser perdidos quando o container for removido.

## Solução de problemas

Se a aplicação apresentar `Unable to obtain connection from database`, confirme que:

1. O container `dev_ecommerce` está em execução.
2. A porta `5433` está livre e publicada pelo Docker.
3. O banco, o usuário e a senha correspondem ao `docker-compose.yml` e ao `application.properties`.

Para reiniciar o banco:

```bash
docker compose restart meu-banco
```

Ou:

```bash
docker-compose restart meu-banco
```
