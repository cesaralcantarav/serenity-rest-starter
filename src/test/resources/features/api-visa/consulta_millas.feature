
  Feature: Consultar saldo de millas

    Scenario Outline: Consultar saldo de millas

      Given el usuario accede a la aplicacion
      When el usuario consulta su tarjeta "<numero_tarjeta>"
      Then el usuario "<obtener_millas>" obtiene su saldo de millas

      Examples: Visa Infiniti
        | numero_tarjeta   | obtener_millas |
        | 4222240010041347 | si             |

      Examples: Tarjeta American Express® Tha Platinum Card
        | numero_tarjeta  | obtener_millas |
        | 377752998043567 | si             |

      Examples: Tarjeta Interbank Visa Signature
        | numero_tarjeta   | obtener_millas |
        | 4110909980108154 | si             |

      Examples: Tarjeta Interbank Visa Platinum
        | numero_tarjeta   | obtener_millas |
        | 4222249980045253 | si             |

      Examples: Tarjeta Interbank Visa Clasica INTERNACIONAL
        | numero_tarjeta   | obtener_millas |
        | 4547759980067295 | si             |

#      Examples: Tarjeta Interbank Visa Oro
#        | numero_tarjeta   | obtener_millas |
#        | 4913379980064329 | si             |
#
#      Examples: Tarjeta Interbank MasterCard Platinum
#        | numero_tarjeta   | obtener_millas |
#        | 5491619980056362 | si             |
#
#      Examples: Tarjeta Interbank MasterCard Clasica
#        | numero_tarjeta   | obtener_millas |
#        | 5444029980042479 | si             |
#
#      Examples: Tarjeta Interbank MasterCard Oro
#        | numero_tarjeta   | obtener_millas |
#        | 5443599980050392 | si             |

      Examples: Tarjeta Amex Blue
        | numero_tarjeta  | obtener_millas |
        | 377754498038626 | si             |

      Examples: Tarjeta Amex Black
        | numero_tarjeta  | obtener_millas |
        | 377754798044860 | si             |

      Examples: Tarjeta American Express®  - AMEX REVOL
        | numero_tarjeta  | obtener_millas |
        | 377753006141567 | si             |

      Examples: Tarjeta American Express® Gold - AMEX REV.G
        | numero_tarjeta  | obtener_millas |
        | 377753998029150 | si             |

