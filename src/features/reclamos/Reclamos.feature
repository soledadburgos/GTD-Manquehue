Feature: Prueba de reclamos en atención clientes
  Scenario Outline: Reclamos
    Given abrimos el navegador y vamos al sitio Web de SICRET
    When el usuario ingrese el userName "<user>" y el passWord "<password>"
    And el usuario ingrese a Atencion Clientes desde el menu de SICRET
    And el usuario ingrese al gestor de reclamos
    And el usuario presione el boton crear modificar reclamos
    And se crea reclamo con rut "<rut>" y familia de reclamos "<familia>" y tipo de reclamo "<tipo>" y sintoma "<sintoma>"
    And se busca reclamo creado para cerrarlo
    And se cierra reclamo con rut "<rut>", familia "<familia2>" y solucion "<solucion>"
    Examples:
      | user  | password | rut    | familia     | tipo          | sintoma                           |familia2            | solucion                                           |
      |rurbina|Gtd12345   |13435786|TECNICO      |INT CU-ON-LINE |PROBLEMA EQUIPO CLIENTE            |EQUIPO              |EQUIPO - SE RECONFIGURA ROUTER RESETEADO POR CLIENTE|
      |rurbina|Gtd12345|2008|FIDELIZACION|FIDELIZACION|FIDELIZACION_LLAMADO DE BIENVENIDA|FIDELIZACION|CLIENTE CONFORME|
      |rurbina|Gtd12345|2008|FACTURACION|FACTURACION|LLAMADA NO RECONOCIDA|FACTURACION|SE AJUSTA CARGO|
      |rurbina|Gtd12345|2008|COMERCIAL|ENVIOS|NO RECIBIO CORRESPONDENCIA CIA|SERVICIOS|SE ENVIA GUIA A DOMICILIO DE CLIENTE|
      |rurbina|Gtd12345|2008|PREGUNTA|PREGUNTA|FELICITACIONES|PREGUNTA|SE AJUSTA CARGO|


