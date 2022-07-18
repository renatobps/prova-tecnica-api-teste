@ValidarRegrasSimulacao
Feature: Validar regras Simulacao

  @ValidarMensagemCamposVazios
  Scenario: Validar mensagem campos vazios - Endpoint - /api/v1/simulacoes
    Given que execute o endpoint para criar simulacao inserindo parcelas 6 e seguro "true"
    And receber o response com o statusCode "400"
    Then no body do response deve ter as mensagem de erro "Valor não pode ser vazio", "CPF não pode ser vazio", "Nome não pode ser vazio", "E-mail não deve ser vazio"

  @ValidarEmailValido
  Scenario: Validacao de email - Endpoint - /api/v1/simulacoes
    Given que execute o endpoint para criar simulacao inserindo nome "Renato Bento", cpf "97093123456", email "email.com", valor 1200.00,  parcelas 6 e seguro "true"
    And receber o response com o statusCode "400"
    Then no body do response deve ter as mensagem de erro "não é um endereço de e-mail"

  @ValidarCPFExistente
  Scenario: Validacao de email - Endpoint - /api/v1/simulacoes
    Given que execute o endpoint para criar simulacao inserindo nome "Renato Bento", cpf "17822386034", email "renato@email.com", valor 1200.00,  parcelas 6 e seguro "true"
    And receber o response com o statusCode "400"
    Then no body do response deve ter mensagem de erro de cpf "CPF duplicado"

  @ValidarValorMenor40mil
  Scenario: Validar valor menor que 4o mil - Endpoint - /api/v1/simulacoes
    Given que execute o endpoint para criar simulacao inserindo nome "Renato Bento", cpf "97093123456", email "renato@email.com", valor 80000.00,  parcelas 6 e seguro "true"
    And receber o response com o statusCode "400"
    Then no body do response deve ter mensagem de erro de valor "Valor deve ser menor ou igual a R$ 40.000"