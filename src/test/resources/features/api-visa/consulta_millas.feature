
  Feature: Consultar saldo de millas

    Scenario Outline: Consultar saldo de millas <tarjeta>

      Given el usuario accede a la aplicacion
      When el usuario consulta su tarjeta "<numero_tarjeta>"
      Then obtiene su saldo de millas

      Examples:
        | tarjeta                                      | numero_tarjeta   |
        | VISA Infiniti                                | 4772899980045028 |
        | Tarjeta American Express® Tha Platinum Card  | 377752998043567  |
        | Tarjeta Interbank Visa Signature             | 4110909980108154 |
        | Tarjeta Interbank Visa Platinum              | 4222249980045253 |
        | Tarjeta Interbank Visa Clasica INTERNACIONAL | 4547759980067295 |
        | Tarjeta Interbank Visa Oro                   | 4913379980064329 |
        | Tarjeta Interbank MasterCard Platinum        | 5491619980056362 |
        | Tarjeta Interbank MasterCard Clasica         | 5444029980042479 |
        | Tarjeta Interbank MasterCard Oro             | 5443599980050392 |
        | Tarjeta Amex Blue                            | 377754498038626  |
        | Tarjeta Amex Black                           | 377754798044860  |
        | Tarjeta American Express®  - AMEX REVOL      | 377753006141567  |
        | Tarjeta American Express® Gold - AMEX REV.G  | 377753998029150  |

