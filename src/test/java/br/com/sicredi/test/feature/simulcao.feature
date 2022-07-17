Feature: Simulacao

  @CriarSimulacao
  Scenario: Criar Simulacao - Endpoint - /api/v1/simulacoes
    Given que execute o endpoint para criar simulacao inserindo nome "Renato Bento", cpf "96123455622", email "renato@email.com", valor 1200,  parcelas 6 e seguro "true"
    And receber o response com o statusCode "201"
    Then no body do response o campo nome deve ser "Renato Bento" e cpf "96123455622"

  @ConsultarSimulacoes
  Scenario: Consultar simulacoes - Endpoint - /api/v1/simulacoes
    Given que execute o endpoint para consultar simulacoes
    And receber o response com o statusCode "200"
    Then no body do response na lista de cpfs deve ter o cpf "96123455622"

  @ConsultarSimulacaoCPF
  Scenario: Consultar simulacao CPF - Endpoint - /api/v1/simulacoes/{cpf}
    Given que execute o endpoint para consultar simulacao por cpf inserindo o cpf "96123455622
    And receber o response com o statusCode "200"
    Then no body do response o campo nome deve ser "Renato Bento" e cpf "96123455622"

  @AtualizarSimulacao
  Scenario: Atualizar simulacao - Endpoint - /api/v1/simulacoes/{cpf}
    Given que execute o endpoint para atualizar simulacao inserindo nome "Renato Bento Atualizado", cpf "96123455622", email "renato.bento@email.com", valor 1200,  parcelas 6 e seguro "false"
    And receber o response com o statusCode "202"
    Then no body do response o campo nome deve ser "Renato Bento Atualizado", cpf "96123455622", email "renato.bento@email.com"

  @ExcluirSimulacao
  Scenario: Excluir simulacao - Endpoint - /api/v1/simulacoes/{cpf}
    Given que execute o endpoint para excluir simulacao por cpf inserindo o cpf "96123455622"
    And receber o response com o statusCode "200"
    Then a string deve retornar "OK"

  @ConsultarRestricaoCPF
  Scenario: Consultar Restricao CPF - Endpoint - /api/v1/restricoes/{cpf}
    Given que execute o endpoint para consultar restricao inserindo o cpf "97093236014"
    And receber o response com o statusCode "202"
    Then no body do response o campo mensagem deve ter a mensagem "O CPF 97093236014 tem problema"


