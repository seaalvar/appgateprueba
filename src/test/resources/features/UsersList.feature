Feature: Lista de usuarios

  Scenario: Listar Usuarios
    When David envia la siguiente operacion al servicio "https://reqres.in/api/users"
      |names|Sergio|
      |job|TAE|
    Then valida que el codigo de status sea 201


