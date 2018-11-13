Feature: Prueba de encuesta Residencial
  Scenario Outline: Encuesta
    Given El usuario abre navegador y entra al Web SICRET
    When En encuestas el usuario ingresa userName "<user>" y el passWord "<password>"
    And En encuestas el usuario ingresa a GESCOM desde el Menu SICRET
    And En encuestas el usuario ingresa a Resumen Cliente desde GESCOM
    And En encuestas el usuario busca un cliente ingresando el rut "<rut>"
    And Se responde la encuesta Pregunta uno "<opcion1>"
    And En encuestas el usuario cierra la ventana y el navegador
    Examples:
      | user | password | rut |opcion1 |
      |dsouza|Gtd*2018  |2009 |3 |