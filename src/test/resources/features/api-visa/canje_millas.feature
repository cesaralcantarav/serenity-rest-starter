Feature: Canje de Millas de API VISA

  Scenario Outline:  [HAPPY PATH] Canje de Millas de diferentes tarjetas

    Given el usuario accede a la aplicacion
    When el usuario ingresa su tarjeta "<numero_tarjeta>", cantidad de millas "<cantidad_millas>", tipo de documento "<tipo_doc>" y número "<num_doc>"
    Then el canje de millas es satisfactorio


    Examples: Tarjeta ABC
      | numero_tarjeta   | cantidad_millas | tipo_doc | num_doc  |
      | 4222240010041347 | 1               | 1        | 89003394 |