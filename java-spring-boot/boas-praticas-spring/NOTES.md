# :computer: Java e Spring Boot

## Spring Boot 3: aplique boas práticas e proteja uma API Rest

- Em métodos de remoção é uma boa prática usar o código 204 e não o 200. O `204 No Content' significa que foi processado com sucesso, mas não possui conteúdo para ser mostrado na resposta
- Em métodos de atualização dos dados, é interessante devolver a informação atualizada
- Para métodos de cadastro, se faz uso do código 201, que significa que a requisição foi processada e o novo recurso foi criado, devolvendo no corpo da resposta os dados do novo recurso/registro criado e um cabeçalho do protocolo HTTP (Location)
- Não é recomendado devolver e receber entidades JPA no controller
- _UriComponentsBuilder_: classe que encapsula o endereço da API

---

### :pencil:

---

#### :pencil2:

---

| :link:                                                                                                                          | :link: | :link:                         | :link: |:link: | :link: |
|---------------------------------------------------------------------------------------------------------------------------------|-------|--------------------------------|---|---|---|
| [ResponseEntity](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html) | [UriComponentsBuilder](https://www.baeldung.com/spring-uricomponentsbuilder)  | [HTTP Dogs](https://http.dog/) |  |  |
---
