Feature: Actualizar Usuarios

  Scenario: Actualizacion de un usuario exitosa
    When se envia la siguiente actualizacion del usuario con id "2" al servicio "https://reqres.in/api/users"
      |name|Sergio|
      |job|TAE|
    Then se valida que el codigo de status sea 200

  @tag
  Scenario: Actualizacion de un usuario con endpoint incorrecto
    When se envia la siguiente actualizacion del usuario con id "2" al servicio "https://reqres.in/ap"
      |name|Sergio|
      |job|TAE|
    Then se valida que el codigo de status sea 404