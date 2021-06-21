Feature: Eliminar Usuario

  Scenario: Eliminacion de un usuario exitosa
    When se envia el id "2" del usuario a eliminar al servicio "https://reqres.in/api/users"
    Then se valida que el codigo de status sea 204


  Scenario: Eliminacion de un usuario con endpoint incorrecto
    When se envia el id "2" del usuario a eliminar al servicio "https://reqres.in/ap"
    Then se valida que el codigo de status sea 404