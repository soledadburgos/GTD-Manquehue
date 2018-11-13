Feature: Prueba de metrogas
  Scenario Outline: Metrogas
    Given El usuario abre el navegador y entra al sitio Web SICRET
    When El usuario ingresa userName "<user>" y el passWord "<password>"
    And El usuario ingresa a GESCOM desde el Menu SICRET
    And El usuario ingresa a Resumen Cliente desde GESCOM
    And El usuario busca un cliente ingresando el rut "<rut>"
    And Se valida que se abra el mensaje de metrogas y se evalua el "<mensaje>"
    And El usuario se dirije a Gestor de Solicitudes
    And El usuario busca al cliente ingresando el rut "<rut>"
    And Se valida que se abra el mensaje de metrogas y se evalua el "<mensaje>"
    And El usuario ingresa a Perfil Clientes desde el menu SICRET
    And El usuario busca el mismo cliente ingresando el rut "<rut>"
    And Se valida que se abra el mensaje de metrogas y se evalua el "<mensaje>"
    And El usuario cierra la ventana y el navegador
    Examples:
      | user | password | rut | mensaje |
      |dsouza|gtd123  |2009 |¿Metrogas Combo S - 10% los 3 primeros meses para un cilindros de 15 Kg?|