Feature: Prueba Codificacion

  Scenario: Crear empleados
    When se crea el empleado en la base de datos
      | idEmpleado | nombre    | meses | salario |
      | 12258      | Simon     | 3     | 6000000 |
      | 13545      | Tomas     | 5     | 5400000 |
      | 45687      | Bartolome | 9     | 7200000 |
      | 21546      | Juan      | 24    | 4300000 |
      | 46875      | Andres    | 65    | 3500000 |
      | 654543     | Pedro     | 54    | 3800000 |
      | 56156      | Santiago  | 12    | 6600000 |
      | 99865      | Felipe    | 13    | 1800000 |
      | 3461       | Mateo     | 1     | 3514132 |
      | 788756     | Judas     | 4     | 2355000 |


  Scenario Outline: Consulta empleados
    When se listan empleados con menos de "<meses>" y un salario mayor a "<salario>"

    Examples:
      | meses | salario |
      | 6     | 5000000 |