@ValidarRegrasSimulacao
Feature: Validar regras Simulacao

  @ValidarMensagemCamposVazios
  Scenario: Validar mensagem campos vazios - Endpoint - /api/v1/simulacoes
    Given que execute o endpoint para criar simulacao inserindo parcelas 6 e seguro "true"
    And receber o response com o statusCode "400"
    Then no body do response deve ter as mensagem de erro "Valor não pode ser vazio", "CPF não pode ser vazio", "Nome não pode ser vazio", "E-mail não deve ser vazio"

  @ValidarFormatoCPF
  Scenario: Criar Simulacao com formato invalido - Endpoint - /api/v1/simulacoes
    Given que execute o endpoint para criar simulacao inserindo nome "Renato Bento", cpf "999.122.325-10", email "renato@email.com", valor 1200.00,  parcelas 6 e seguro "true"
    And receber o response com o statusCode "201"
    Then no body do response o campo cpf deve caracter especiais


  @ValidarMensagemErroCamposCriaSimulacao
  Scenario Outline: Validar regras e mensagens dos campos - Endpoint - /api/v1/simulacoes
    Given que execute o endpoint para criar simulacao inserindo nome "<nome>", cpf "<cpf>", email "<email>", valor <valor>,  parcelas <parcelas> e seguro "<seguro>"
    And receber o response com o statusCode "<statusCode>"
    Then no body do response deve ter mensagem de erro na key "<key>" "<mensagem>"
    Examples:
      | nome            |   cpf          | email             | valor   | parcelas | seguro | statusCode |                 mensagem                  |      key        |
      | Renato Bento    | 17822386034    | renato@email.com  |1200.00  |     6    | true   |    409     |             CPF já existente              | mensagem        |
      | Renato Bento    | 97093120101    | email.com         |1200.00  |     6    | true   |    400     | não é um endereço de e-mail               | erros.email     |
      | Renato Bento    | 97093120106    | renato@email.com  |40001.00 |     6    | true   |    400     | Valor deve ser menor ou igual a R$ 40.000 | erros.valor     |
      | Renato Bento    | 97093120107    | renato@email.com  |999.00   |     6    | true   |    400     | Valor deve ser maior ou igual a R$ 1.000  | erros.valor     |
      | Renato Bento    | 97093120108    | renato@email.com  |1200.00  |     1    | true   |    400     | Parcelas deve ser igual ou maior que 2    | erros.parcelas  |
      | Renato Bento    | 97093120109    | renato@email.com  |1300.00  |     49   | true   |    400     | Parcelas deve ser igual ou menor que 48   | erros.parcelas  |


  @ValidarMensagemSimulacaoNaoEncontrada
  Scenario: Consultar simulacao CPF - Endpoint - /api/v1/simulacoes/{cpf}
    Given que execute o endpoint para consultar simulacao por cpf inserindo o cpf "000011112233"
    And receber o response com o statusCode "404"
    Then no body do response o campo mensagem deve ter a mensagem "CPF 000011112233 não encontrado"

  @ValidarMensagemErroCamposAtualizarSimulacao
  Scenario Outline: Validar regras e mensagens dos campos atualizar simulacao - Endpoint - /api/v1/simulacoes/{cpf}
    Given que execute o endpoint para atualizar simulacao inserindo nome "<nome>", cpf "<cpf>", email "<email>", valor <valor>,  parcelas <parcelas> e seguro "<seguro>"
    And receber o response com o statusCode "<statusCode>"
    Then no body do response deve ter mensagem de erro na key "<key>" "<mensagem>"
    Examples:
      | nome       |   cpf          | email             | valor   | parcelas | seguro | statusCode |                 mensagem                  |      key        |
      | Renato     | 17822380000     | renato@email.com  |1200.00  |     6    | true   |    404     |        CPF 17822380000 não encontrado       | mensagem        |
      | Renato     | 66414919004     | email.com         |1200.00  |     6    | true   |    400     | não é um endereço de e-mail               | erros.email     |
      | Renato     | 66414919004     | renato@email.com  |40001.00 |     6    | true   |    400     | Valor deve ser menor ou igual a R$ 40.000 | erros.valor     |
      | Renato     | 66414919004     | renato@email.com  |999.00   |     6    | true   |    400     | Valor deve ser maior ou igual a R$ 1.000  | erros.valor     |
      | Renato     | 66414919004     | renato@email.com  |1200.00  |     1    | true   |    400     | Parcelas deve ser igual ou maior que 2    | erros.parcelas  |
      | Renato     | 66414919004     | renato@email.com  |1300.00  |     49   | true   |    400     | Parcelas deve ser igual ou menor que 48   | erros.parcelas  |


  @ValidarMessagemExclusaoSimulacaoNaoEncontrada
  Scenario: Excluir simulacao - Endpoint - /api/v1/simulacoes/{id}
    Given que execute o endpoint para excluir simulacao inserindo o id inexistente
    And receber o response com o statusCode "404"
    Then no body do response o campo mensagem deve ter a mensagem "Simulação não encontrada"

