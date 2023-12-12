# :computer: Java e Spring Boot

## Spring Boot 3: desenvolva uma API Rest em Java

- _Spring_: framework para desenvolvimento de aplicações em Java, popular pela simplicidade e facilidade de integração
  - <span style="background-color:#b2e2f2">desenvolvido de maneira modular</span>, cada recurso é representado por um módulo, que pode ser adicionado conforme as necessidades
  - _MVC_: desenvolvimento de aplicações Web e API's Rest
  - _Security_: lidar com controle de autenticação e autorização da aplicação
  - _Transactions_: gerenciar o controle transacional.
- _Spring Boot_: módulo do Spring com o propósito de agilizar a criação de um projeto com o Spring como framework, e simplificar as configurações de seus módulos
- _Spring Initializr_: ferramenta pra criação de projeto com estrutura inicial necessária
- _Spring Boot DevTools_: módulo para não precisar reiniciar a aplicação a cada alteração feita no código, elas subirão automaticamente.
- _Lombok_: ferramenta para gerar códigos, como getters e setters, baseado em anotações
- _Spring Web_: se faz necessaŕio o módulo web para trabalhar com uma API Rest

---

### :pencil: Spring

- `@Controller`: comunicar ao Spring MVC que é uma classe controller
  - `@RestController` ao trabalhar com uma API Rest
- `@RequestMapping`: informar qual a URL que o controller vai responder, pode ser usada tanto na classe quanto no nível do método
- `@GetMapping`/`@PostMapping`: mapeia solicitações HTTP nos métodos
- `@RequestBody`/`@ResponseBody`: utilizadas pela API REST para indicar ao Spring que um recurso não será enviado ou recebido por uma página da web, usa-se estas anotações para o envio ou recebimento dos recursos
- `@Autowired`: indica um ponto para aplicar a injeção automática de dependência
- `@Transactional`: demarca transações, sendo estas unidades de trabalho isoladas que levam o banco de dados de um estado consistente a outro estado consistente

---

### :pencil: JPA

- `@Table`: usada para especificar a tabela da entidade
- `@Entity`: denota que a classe representa um tipo de entidade
- `@GeneratedValue`: indica que o valor do identificador é gerado automaticamente usando uma coluna de identidade, uma sequência de banco de dados ou um gerador de tabelas
- `@Embedded`: especifica que um atributo da entidade representa um tipo incorporável
- `@Embeddable`: usada para especificar tipos incorporáveis, estes que não tem identidade e são gerenciados por sua entidade proprietária.

---

### :pencil: Lombok

- `@Getter`/`@Setter`: fornecem métodos getters e setters dos atributos
  - podem ter um parâmetro que indica o tipo de acesso aos dados
  `@Getter(AccessLevel.PROTECTED)`
- `@NoArgsConstructor`: criação de um construtor vazio
- `@AllArgsConstructor`: criação de um construtor com todos os atributos
  - possível definir o tipo de acesso ou so o construtor é estático
  `@AllArgsConstructor(AccessLevel.PRIVATE)`
  `@AllArgsConstructor(staticName = "of")`
- `@EqualsAndHashCode`: gera os métodos `equals()` e `hachCode()`
  - possível personalizar os atributos que serão validados
  `@EqualsAndHashCode(exclude={"field1","field2"})`
  `@EqualsAndHashCode(of = "field")`
- `@Data`: combinação de `@ToString, @EqualsAndHashCode, @Getter e @Setter`, e também tem a geração de um construtor público com campos `@NonNull` ou `final` como parâmetros

---

#### :pencil2: CORS (Cross-Origin Resource Sharing)

- usado para adicionar cabeçalhos HTTP informando aos navegadores se um determinado recurso pode ou não ser acessado, é chamada de requisição cross-origin HTTP

#### :pencil2: Same-origin policy

- mecanismo de segurança dos browsers que restringe a maneira de um documento ou script de uma origem interagir com recursos de outra origem, com o objetivo de frear ataques maliciosos
  - por exemplo, uma aplicação Front-end, escrita em JavaScript, só consegue acessar recursos localizados na mesma origem da solicitação
  - duas URLs compartilham a mesma origem se o protocolo, porta (caso especificado) e host são os mesmos
  - em casos de origens diferentes, a API precisa retornar a header _Access-Control-Allow-Origin_, para informar as origens que serão permitidas para consumir a API

#### :pencil2: Java Record

- permite representar uma classe imutável, com atributos, construtor e métodos de leitura, de maneira mais simples.
  - ideal para representar classes DTO, já que é usada para representar dados que serão recebidos/devolvidos pela API, sem algum comportamento.

#### :pencil2: Arquivo de propriedades

- por padrão, o spring boot acessa configurações definidas no arquivo _application.properties_, que usa um formato de _chave=valor_, onde cada linha é uma configuração única
- _YAML Configuration_: utilizado para definir dados de configuração hierárquica, facilitando armazenamento de variáveis de configuração de ambiente

#### :pencil2: Padrão DAO vs Padrão Repository

- _DAO (Data Access Object)_: utilizado para persistência de dados, com o objetivo de separar regras de negócio de regras de acesso a banco de dados
  - os códigos que lidam com conexões, comandos SQLs e funções diretas ao banco de dados são separados, para que estes não se espalhem por outros pontos da aplicação, dificultando a manutenção do código e a troca das tecnologias e do mecanismo de persistência
- _Repository_: também lida com dados e oculta consultas, porém ele se encontra em um nível mais alto, próximo da lógica de negócios da aplicação
  - não tem tomada de decisões, aplicação de algoritmos de transformação de dados ou serviços a outras camadas ou módulos da aplicação

#### :pencil2: Padrão DTO (Data Transfer Object)

- usado para representar dados que eram enviados e recebidos entre aplicações cliente e servidor, pode ser utilizado quando não queremos expor todos os atributos de alguma entidade do projeto

#### :pencil2: Mass Assignment Attack

- ocorre quando um usuário é capaz de inicializar/substituir parâmetros que não deveriam ser modificados na aplicação. Refere-se a injetar um conjunto de valores diretamente em um objeto, que sem a devida validação pode causar sérios problemas

#### :pencil2: PUT vs PATCH

- _PUT_: substitui todos os atuais dados de um recurso pelos dados passados na requisição, é feita a atualização total do recurso em uma requisição
- _PATCH_: aplica modificações parciais em um recurso, o que torna as atualizações mais flexíveis

---

| :link: | :link: | :link: | :link: |:link: | :link: |
|---|---|---|---|---|---|
| [Spring Boot](https://spring.io/projects/spring-boot) | [Spring Initializr](https://start.spring.io/) | [Bean Validation](https://jakarta.ee/specifications/bean-validation/3.0/jakarta-bean-validation-spec-3.0.html#builtinconstraints) | [12 Factor App](https://12factor.net/) | [Java Record](https://docs.oracle.com/en/java/javase/16/language/records.html) | [PageableDefault](https://www.linkedin.com/pulse/spring-boot-e-data-performance-com-pagina%C3%A7%C3%A3o-cache-nick-kras-borges/?originalSubdomain=pt)

---
