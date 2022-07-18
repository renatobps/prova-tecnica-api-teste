@Simulacao
Feature: Simulacao

  @CriarSimulacao
  Scenario: Criar Simulacao - Endpoint - /api/v1/simulacoes
    Given que execute o endpoint para criar simulacao inserindo nome "Renato Bento", cpf "97093232222", email "renato@email.com", valor 1200.00,  parcelas 6 e seguro "true"
    And receber o response com o statusCode "201"
    Then no body do response o campo nome deve ser "Renato Bento" e cpf "97093232222"

  @ConsultarSimulacoes
  Scenario: Consultar simulacoes - Endpoint - /api/v1/simulacoes
    Given que execute o endpoint para consultar simulacoes
    And receber o response com o statusCode "200"
    Then no body do response na lista de cpfs deve ter o cpf "97093232222"

  @ConsultarSimulacaoCPF
  Scenario: Consultar simulacao CPF - Endpoint - /api/v1/simulacoes/{cpf}
    Given que execute o endpoint para consultar simulacao por cpf inserindo o cpf "97093232222"
    And receber o response com o statusCode "200"
    Then no body do response o campo nome deve ser "Renato Bento" e cpf "97093232222"

  @AtualizarSimulacao
  Scenario: Atualizar simulacao - Endpoint - /api/v1/simulacoes/{cpf}
    Given que execute o endpoint para atualizar simulacao inserindo nome "Renato Bento Atualizado a", cpf "97093232222", email "renato.bento@email.com", valor 1200.00,  parcelas 6 e seguro "false"
    And receber o response com o statusCode "200"
    Then no body do response o campo nome deve ser "Renato Bento Atualizado a", cpf "97093232222", email "renato.bento@email.com"

  @ExcluirSimulacao
  Scenario: Excluir simulacao - Endpoint - /api/v1/simulacoes/{id}
    Given que execute o endpoint para excluir simulacao inserindo o id
    And receber o response com o statusCode "200"


  @ConsultarRestricaoCPF
  Scenario: Consultar Restricao CPF - Endpoint - /api/v1/restricoes/{cpf}
    Given que execute o endpoint para consultar restricao inserindo o cpf "97093236014"
    And receber o response com o statusCode "200"
    Then no body do response o campo mensagem deve ter a mensagem "O CPF 97093236014 tem problema"


