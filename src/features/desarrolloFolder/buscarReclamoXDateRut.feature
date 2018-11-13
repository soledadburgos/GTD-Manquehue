Feature: Prueba que busca reclamos por rut y fecha
  Scenario Outline: Busqueda reclamos
    Given El usuario abre el navegador y entra al sitio Web de SICRET
    When El usuario ingresa el userName "<user>" y el passWord "<password>"
    And El usuario ingresa a Atencion Clientes desde el menu de SICRET
    And El usuario ingresa al gestor de reclamos
    And El usuario selecciona Fecha desde y selecciona 1 mes antes de la fecha actual
    And El usuario ingresa rut "<rut>"
    And Se Valida que existan registros que mostrar
    And El usuario cierra el navegador

    Examples:
      | user | password | rut |
    |rurbina|Gtd12345  |17193491|