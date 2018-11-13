Feature: Prueba de recrear Contrasena cliente
  Scenario Outline: Recrear Contrasena
    Given El usuario abre el navegador y en el sitio Web de SICRET
    When El usuario ingrese userName "<user>" y el passWord "<password>"
    And El usuario ingrese a GESCOM desde el Menu SICRET
    And El usuario ingrese a Resumen Cliente desde GESCOM
    And El usuario busca un cliente ingresando el rut "<rut>" y seleccionando la cuenta de facturacion "<ctaFacturacion>"
    And El usuario selecciona Url Recrear Contrasena ActiveDirectory
    And El usuario en la pantalla DATOS CLIENTE EN ACTIVE DIRECTORY presiona boton RECREAR
    And El usuario cierra la pantalla y el navegador
    Examples:
      | user | password | rut | ctaFacturacion |
      |rurbina|Gtd12345  |17193491|3280843      |