Feature: Calculadora Rest

  Scenario: Operacion unica exitosa
    When David envia la siguiente operacion al servicio "https://reqres.in/api/users"
      |names|Sergio|
      |job|TAE|
    Then valida que el codigo de status sea 201
    And que el contenido de la llave "result" sea "16"
    And que el contenido de la llave "error" sea null