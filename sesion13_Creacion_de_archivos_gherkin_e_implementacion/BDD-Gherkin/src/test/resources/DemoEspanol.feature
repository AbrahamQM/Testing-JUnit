# language: es

  Escenario: Tengo una lista de metodos de pago
    Dado El usuario va a pagar con uno de estos metodos
      | Tarjeta  |
      | Efectivo |
      | Cheque   |
    Cuando Solicitamos que realice el pago
    Entonces Verificamos el metodo seleccionado


  Escenario: Verificar usuario y contraseña
    Dado Los pares de usuario y clave
      | username | password |
      | usuario  | miclave  |
      | usuario2 | miclave2 |

    Cuando el usuario los envie
    Entonces los verificamos con el backEnd