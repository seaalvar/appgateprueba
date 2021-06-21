Feature: Prueba Codificacion

  @creacion
  Scenario Outline: Crear empleados
    When se crea el empleado en la base de datos "<idEmpleado>" "<nombre>" "<meses>" "<salario>"

    Examples:
      | idEmpleado | nombre   | meses | salario |
      | 12258      | Simon    | 3     | 6000000 |

  @consulta
  Scenario Outline: Consulta empleados
    When se listan empleados con al menos "<meses>" y un salario mayor a "<salario>"

    Examples:
      | meses | salario |
      | 6     | 5000000 |