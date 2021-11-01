Feature: Calcular
  Scenario: Somar Dois Numeros Inteiros Positivos
    Given abro a calculadora do Google no meu smartphone
    When seleciono "8" mais "2" e pressiono o botao Igual
    Then exibe o resultado como "10"