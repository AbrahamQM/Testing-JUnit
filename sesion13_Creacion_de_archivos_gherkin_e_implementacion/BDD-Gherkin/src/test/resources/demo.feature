Feature: Verificar metodos de pago

  Scenario: Tengo una lista de metodos de pago
    Given El usuario va a pagar con uno de estos metodos
      | Tarjeta  |
      | Efectivo |
      | Cheque   |
    When Solicitamos que realice el pago
    Then Verificamos el metodo seleccionado


  Scenario: Verificar usuario y contraseña
    Given Los pares de usuario y clave
      | username | password |
      | usuario  | miclave  |
      | usuario2 | miclave2 |

    When el usuario los envie
    Then los verificamos con el backEnd