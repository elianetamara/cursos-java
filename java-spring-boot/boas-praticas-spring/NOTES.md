# :computer: Java e Spring Boot

## Spring Boot 3: aplique boas práticas e proteja uma API Rest

- _UriComponentsBuilder_: classe que encapsula o endereço da API
- Não é recomendado devolver e receber entidades JPA no controller
- Não é uma boa prática retornarmos um stack trace para o usuário da API, acaba por expor informações sensíveis e desnecessárias, podendo se tornar uma brecha de segurança
- Por padrão, exceções não tratadas no código são interpretadas pelo Spring Boot como erro 500
- Em métodos de atualização dos dados, é interessante devolver a informação atualizada

---

### :pencil: Spring

- `@RestControllerAdvice`:
- `@ExceptionHandler(XXXException.class)`:

---

#### :pencil2: códigos do protocolo HTTP

- protocolo HTTP (Hypertext Transfer Protocol) é o protocolo responsável por fazer a comunicação entre o cliente, que normalmente é um browser, e o servidor
  - 1XX: Informativo – a solicitação foi aceita ou o processo continua em andamento
  - 2XX: Confirmação – a ação foi concluída ou entendida
    - Para métodos de cadastro, se faz uso do código 201, que significa que a requisição foi processada e o novo recurso foi criado, devolvendo no corpo da resposta os dados do novo recurso/registro criado e um cabeçalho do protocolo HTTP (Location)
    - Em métodos de remoção é uma boa prática usar o código 204 e não o 200. O `204 No Content' significa que foi processado com sucesso, mas não possui conteúdo para ser mostrado na resposta
  - 3XX: Redirecionamento – indica que algo mais precisa ser feito ou precisou ser feito para completar a solicitação
  - 4XX: Erro do cliente – indica que a solicitação não pode ser concluída ou contém a sintaxe incorreta;
    - 403: Significa que o servidor entendeu a requisição do cliente, mas se recusa a processá-la, pois o cliente não possui autorização para isso
    - 404: significa que essa URL não te levou a lugar nenhum, pode ser que a aplicação não exista mais, a URL mudou ou você digitou a URL errada
  - 5XX: Erro no servidor – o servidor falhou ao concluir a solicitação
    - 500: significa que há um problema com alguma das bases que faz uma aplicação rodar. Esse erro pode ser, basicamente, no servidor que mantém a aplicação no ar ou na comunicação com o sistema de arquivos, que fornece a infraestrutura para a aplicação
    - 503: significa que o serviço acessado está temporariamente indisponível. Causas comuns são um servidor em manutenção ou sobrecarregado. Ataques maliciosos, como o DDoS, causam bastante esse problema.

---

| :link:                                                                                                                          | :link: | :link:                         | :link: |:link: | :link: |
|---------------------------------------------------------------------------------------------------------------------------------|-------|--------------------------------|--------|---|---|
| [ResponseEntity](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html) | [UriComponentsBuilder](https://www.baeldung.com/spring-uricomponentsbuilder)  | [HTTP Dogs](https://http.dog/) | [Common Application Properties](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html) |  |
---
