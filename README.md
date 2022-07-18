#PROVA TECNICA API 

##RESUMO
Automação de API com restAssured e java, utilizando BDD, cucumber e cucumber report.
##2. Estrutura do projeto:
###2.1 Features
Onde encontra os cenários BDDs, com a escrita gherkin dos comportamentos que cada cenário deve ter.
####2.1.1 Simulacao.feature ->
Contém os cenários positivos onde todos as requisições não contêm erro de resposta
####2.1.2 ValidarRegrasSimulacao.feature ->
Contém os cenários negativos onde são testados se as respostas aos erros e regra de negócios estabelecidas estão ok.
###2.2 Models
Onde encontras as classes responsáveis pelos métodos que interagir com a API
####2.2.1 SimulacaoMap
Classe responsável pelo mapeamento do objeto, header e parâmetros enviados na requisição
####2.2.2 Simulacao
Classe onde se encontra o método que irá fazer a requisição para a API receber sua resposta
###2.3 Gherkin/Stepsdefinitions
Pacote que contém as classes com os métodos steps, que executa por passos cada cenário de testes baseado nas features
###2.4 Runner
Classe que tem a função de executar os cenários das features com os métodos definidos nas steps. Classe Runner te um suite de teste que executa todas as outras Runners
###2.5 Utils
Pacote Utils tem classes necessárias para a execução dos métodos.
####2.5.1 ToReadResponse
Método para ler json vindo de responses
####2.5.2 Urls
Possui o mapeamento das urls usadas nos endpoints
####2.5.3 Utils
Possui métodos de leitura de json, manipulação de properties e etc

##3 RestAssured
É classe que responsavel pela requisição direto na api, os métodos rest são feitos nelas, com esperas de parametros para que torne mais fácil a criação dos métodos nas classes
###3.1 Tipos de requests:
####3.1.1 POST
####3.1.2 GET COM E SEM PARAMENTROS
####3.1.2 PUT COM E SEM PARAMENTROS
####3.1.2 DELETE
####3.1.2 PACTH
####3.1.2 OPTIONS
###3.2 GET HEADER, RESPONSECODE E KEYS
A classe possui métodos que retorna logs com a requisição resposta das requests
##4  Relatórios
Usado plugin extentreports do cucumber que gera o report dos cenários testados com seus bugs, e a descrição dos cenários.
Esses relatórios são gerados em tempo de execução e salvos no formato HTML na pasta target/output

##5 CI/CD
###Actions
Adicionado o workflow do github actions onde, o mesmo executa os testes e gera os relatórios de testes.



