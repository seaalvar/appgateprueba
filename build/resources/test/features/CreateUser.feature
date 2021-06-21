Feature: Crear Usuarios

  Scenario: Creacion de un usuario exitosa
    When se envia la siguiente informacion del usuario al servicio "https://reqres.in/api/users"
      |name|Sergio|
      |job|TAE|
    Then se valida que el codigo de status sea 201

  @tag
  Scenario: Creacion de un usuario con endpoint incorrecto
    When se envia la siguiente informacion del usuario al servicio "https://reqres.in/ap"
      |name|Juan|
      |job|Medico|
    Then se valida que el codigo de status sea 404
