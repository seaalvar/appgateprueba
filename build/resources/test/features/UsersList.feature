Feature: Lista de usuarios

  Scenario: Lista de usuarios exitosa
    When se envia la peticion de listar usuarios al servicio "https://reqres.in/api/users?page=1"
    Then se valida que el codigo de status sea 200


  Scenario: Lista de usuarios con endpoint incorrecto
    When se envia la peticion de listar usuarios al servicio "https://reqres.in/ap"
    Then se valida que el codigo de status sea 404


  Scenario: Numero de registros por pagina
    When se envia la peticion de listar usuarios al servicio "https://reqres.in/api/users?page=1"
    Then se valida numero de registros "per_page" sea "6"


  Scenario: Lista de usuarios en pagina
    When se envia el numero de pagina "2" a consultar al servicio "https://reqres.in/api/users?page="
    Then se valida que el codigo de status sea 200


  Scenario Outline: Validacion informacion
    When se envia el numero de pagina "2" a consultar al servicio "https://reqres.in/api/users?page="
    Then se valida el contenido de la "<key>" sea "<value>"

    Examples:
      | key         | value |
      | page        | 2     |
      | per_page    | 6     |
      | total       | 12    |
      | total_pages | 2     |

  @tag
  Scenario Outline: Validacion informacion
    When se envia el numero de pagina "1" a consultar al servicio "https://reqres.in/api/users?page="
    Then se valida que la informacion del registro "2" sea "<key>" "<value>"

    Examples:
      | key        | value                                   |
      | email      | janet.weaver@reqres.in                  |
      | first_name | Janet                                   |
      | last_name  | Weaver                                  |
      | avatar     | https://reqres.in/img/faces/2-image.jpg |
