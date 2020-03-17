Feature: Anulacion de Canje de Millas

  Scenario Outline: [HAPPY PATH] Anulacion de canje de millas por tarjeta

    Given el usuario accede a la aplicacion
    When el usuario ingresa su tarjeta "<numero_tarjeta>", cantidad de millas "<cantidad_millas>", tipo de documento "<tipo_doc>" y número "<num_doc>"
    Then el canje de millas es satisfactorio
    When el usuario anula la operacion de su tarjeta "<numero_tarjeta>"
    Then la anulacion de canje de millas de su tarjeta "<numero_tarjeta>" es satisfactoria

    Examples: Visa Infiniti
      | numero_tarjeta   | cantidad_millas | tipo_doc | num_doc  |
      | 4222240010041347 | 1               | 1        | 89003394 |

    Examples: Tarjeta American Express® Tha Platinum Card
      | numero_tarjeta   | cantidad_millas | tipo_doc | num_doc  |
      | 377752998043567 | 1               | 1         | 89003394 |

    Examples: Tarjeta Interbank Visa Signature
      | numero_tarjeta   | cantidad_millas | tipo_doc | num_doc  |
      | 4110909980108154 | 1               | 1        | 89003394 |

    Examples: Tarjeta Interbank Visa Platinum
      | numero_tarjeta   | cantidad_millas | tipo_doc | num_doc  |
      | 4222249980045253 | 1               | 1        | 89003394 |

    Examples: Tarjeta Interbank Visa Clasica INTERNACIONAL
      | numero_tarjeta   | cantidad_millas | tipo_doc | num_doc  |
      | 4547759980067295 | 1               | 1        | 89003394 |

#    Examples: Tarjeta Interbank Visa Oro
#      | numero_tarjeta   | cantidad_millas | tipo_doc | num_doc  |
#      | 4913379980064329 | 1               | 1        | 89003394 |
#
#    Examples: Tarjeta Interbank MasterCard Platinum
#      | numero_tarjeta   | cantidad_millas | tipo_doc | num_doc  |
#      | 5491619980056362 | 1               | 1        | 89003394 |
#
#    Examples: Tarjeta Interbank MasterCard Clasica
#      | numero_tarjeta   | cantidad_millas | tipo_doc | num_doc  |
#      | 5444029980042479 | 1               | 1        | 89003394 |
#
#    Examples: Tarjeta Interbank MasterCard Oro
#      | numero_tarjeta   | cantidad_millas | tipo_doc | num_doc  |
#      | 5443599980050392 | 1               | 1        | 89003394 |

    Examples: Tarjeta Amex Blue
      | numero_tarjeta   | cantidad_millas | tipo_doc | num_doc  |
      | 377754498038626 | 1               | 1        | 89003394 |

    Examples: Tarjeta Amex Black
      | numero_tarjeta   | cantidad_millas | tipo_doc | num_doc  |
      | 377754798044860 | 1               | 1        | 89003394 |

    Examples: Tarjeta American Express®  - AMEX REVOL
      | numero_tarjeta   | cantidad_millas | tipo_doc | num_doc  |
      | 377753006141567 | 1               | 1        | 89003394 |

    Examples: Tarjeta American Express® Gold - AMEX REV.G
      | numero_tarjeta   | cantidad_millas | tipo_doc | num_doc  |
      | 377753998029150 | 1               | 1        | 89003394 |