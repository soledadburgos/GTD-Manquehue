Feature: Prueba de prediccion de abandono
  Scenario Outline: Prediccion de Abandono
    Given El usuario en el navegador entra al sitio Web SICRET
    When El usuario ingresa su userName "<user>" y su passWord "<password>"
    And El usuario selecciona GESCOM desde el Menu SICRET
    And El usuario selecciona Resumen Cliente desde el menu de GESCOM
    And El usuario busca un cliente ingresando el rut "<rut>" en resumen cliente
    And El usuario selecciona la cuenta de servicio "<ctaServicio>" del cliente
    And Se valida que aparezca grafico de prediccion de abandono en gescom y se evalua el "<puntaje>"
    And El usuario selecciona Perfil Clientes desde el menu SICRET
    And El usuario busca el mismo cliente ingresando el rut "<rut>" en perfil cliente
    And El usuario selecciona la misma cuenta de servicio "<ctaServicio>" del cliente
    And Se valida que aparezca grafico de prediccion de abandono en perfil cliente y se evalua el "<puntaje>"
    And El usuario cierra las ventanas y el navegador
    Examples:
      | user | password | rut | ctaServicio | puntaje |
      |rurbina|gtd1234  |17193491|3280844   |19       |