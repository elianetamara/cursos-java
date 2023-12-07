## :computer: Spring Boot 3: desenvolva uma API Rest em Java

- _Spring_: framework para desenvolvimento de aplicações em Java, popular pela simplicidade e facilidade de integração
  - <span style="background-color:#b2e2f2">desenvolvido de maneira modular</span>, cada recurso é representado por um módulo, que pode ser adicionado conforme as necessidades
  - _MVC_: desenvolvimento de aplicações Web e API's Rest
  - _Security_: lidar com controle de autenticação e autorização da aplicação
  - _Transactions_: gerenciar o controle transacional.
- _[Spring Boot](https://spring.io/projects/spring-boot)_: módulo do Spring com o propósito de agilizar a criação de um projeto com o Spring como framework, e simplificar as configurações de seus módulos
- _[Spring Initializr](https://start.spring.io/)_: ferramenta pra criação de projeto com estrutura inicial necessária
- _Spring Boot DevTools_: módulo para não precisar reiniciar a aplicação a cada alteração feita no código, elas subirão automaticamente.
- _Lombok_: ferramenta para gerar códigos, como getters e setters, baseado em anotações
- _Spring Web_: se faz necessaŕio o módulo web para trabalhar com uma API Rest

---

- `@Controller`: comunicar ao Spring MVC que é uma classe controller
  - `@RestController` ao trabalhar com uma API Rest
- `@RequestMapping`: informar qual a URL que o controller vai responder, pode ser usada tanto na classe quanto no nível do método
- `@GetMapping`/`@PostMapping`: mapeia solicitações HTTP nos métodos
- `@RequestBody`/`@ResponseBody`: utilizadas pela API REST para indicar ao Spring que um recurso não será enviado ou recebido por uma página da web, usa-se estas anotações para o envio ou recebimento dos recursos

---

:pencil2: CORS (Cross-Origin Resource Sharing)

- usado para adicionar cabeçalhos HTTP informando aos navegadores se um determinado recurso pode ou não ser acessado, é chamada de requisição cross-origin HTTP

:pencil2: Same-origin policy

- mecanismo de segurança dos browsers que restringe a maneira de um documento ou script de uma origem interagir com recursos de outra origem, com o objetivo de frear ataques maliciosos
  - por exemplo, uma aplicação Front-end, escrita em JavaScript, só consegue acessar recursos localizados na mesma origem da solicitação
  - duas URLs compartilham a mesma origem se o protocolo, porta (caso especificado) e host são os mesmos
  - em casos de origens diferentes, a API precisa retornar a header _Access-Control-Allow-Origin_, para informar as origens que serão permitidas para consumir a API

:pencil2: [Java Record](https://docs.oracle.com/en/java/javase/16/language/records.html)

- permite representar uma classe imutável, com atributos, construtor e métodos de leitura, de maneira mais simples.
  - ideal para representar classes DTO, já que é usada para representar dados que serão recebidos/devolvidos pela API, sem algum comportamento.

:pencil2: Arquivo de propriedades

- por padrão, o spring boot acessa configurações definidas no arquivo _application.properties_, que usa um formato de _chave=valor_, onde cada linha é uma configuração única
- _YAML Configuration_: utilizado para definir dados de configuração hierárquica, facilitando armazenamento de variáveis de configuração de ambiente

:pencil2: [12 Factor App](https://12factor.net/)

- metodologia que define 12 boas práticas para uma aplicação moderna, escalável e de manutenção simples

---
