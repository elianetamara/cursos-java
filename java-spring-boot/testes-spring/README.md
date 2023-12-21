# :computer: Java e Spring Boot

## Spring Boot 3: documente, teste e prepare uma API para o deploy

- service executa regras de negócio e validações da aplicação
- controller não deve trazer regras de negócio da aplicação

---

### :pencil: Spring

-

---

#### :pencil2: Service Pattern

-
  -
    -
    -

---

#### :pencil2: anotação @JsonAlias

- os nomes dos campos enviados no JSON para a API devem ser iguais aos nomes dos atributos do DTO, pois o Spring consegue preencher corretamente as informações recebidas

- porém, pode acontecer de um campo ser enviado no JSON com um nome diferente do DTO. Há duas soluções:
  - renomear os atributos no DTO para terem o mesmo nome do JSON
  - solicitar que a aplicação cliente altere os nomes dos campos no JSON enviado
- outra alternativa é utilizar a anotação `@JsonAlias`, que serve para mapear “apelidos” para os campos recebidos do JSON, sendo possível atribuir múltiplos _alias_

`public record DadosCompra(`
`@JsonAlias(“produto_id”) Long idProduto,`
`@JsonAlias(“data_da_compra”) LocalDate dataCompra`
`){}`

`public record DadosCompra(`
`@JsonAlias({“produto_id”, “id_produto”}) Long idProduto,`
`@JsonAlias({“data_da_compra”, “data_compra”}) LocalDate dataCompra`
`){}`

---

#### :pencil2: anotação @JsonFormat

- o Spring tem um padrão de formatação para campos de data  em atributos do tipo _LocalDateTime_

- porém é possível alterar o padrão para utilizar outras formatações

`@NotNull`
`@Future`
`@JsonFormat(pattern = "dd/MM/yyyy HH:mm")`
`LocalDateTime data`

- o atributo pattern indica o padrão esperado,de acordo com as [regras definidas pelo Java](https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html)

---

| :link: | :link:|:link: | :link: |:link:| :link: |
|---|---|---|---|---|---|
| | | | | | |

---