Feature: Buscar usuario unico

  Scenario: Busqueda de un solo usuario exitosa
    When se envia el id "2" del usuario a buscar al servicio "https://reqres.in/api/users"
    Then se valida que el codigo de status sea 200


  Scenario: Busqueda de un solo usuario con endpoint incorrecto
    When se envia el id "2" del usuario a buscar al servicio "https://reqres.in/ap"
    Then se valida que el codigo de status sea 404


  Scenario: Busqueda de un solo usuario inexistente
    When se envia el id "35" del usuario a buscar al servicio "https://reqres.in/api/users"
    Then se valida que el codigo de status sea 404


  Scenario Outline: Validacion informacion del usuario
    When se envia el id "2" del usuario a buscar al servicio "https://reqres.in/api/users"
    Then se valida que el contenido de la "<key>" sea "<value>"

    Examples:
    | key        | value                                   |
    | email      | janet.weaver@reqres.in                  |
    | first_name | Janet                                   |
    | last_name  | Weaver                                  |
    | avatar     | https://reqres.in/img/faces/2-image.jpg |
