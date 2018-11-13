Feature: Prueba Agregar Modificar Producto
  Scenario Outline: Agregar Modificar producto a una instancia Activa
    Given el usuario abre navegador y vamos al sitio Web de SICRET
    When el usuario ingresa los datos, userName "<user>" y el passWord "<password>"
    And el usuario ingrese a GESCOM desde menu de SICRET
    And el usuario ingrese a Resumen Cliente desde submenu GESCOM
    And el usuario ingresa el rut "<rut>", seleccionando la cuenta de servicio, intancia y agregar modficar productos
    And el usuario selecciono los Datos de la venta del menu
    And el usuario ingreso los datos de la venta
    And el usuario finalizo la primera fase
    And el usuario selecciono agregar productos a instancia
    And el_usuario_selecciona_la_instancia_y_se_desconectan_los_equipos
    And el_usuario_presionar_desconectar_un_equipo
    And el usuario presiona el boton finalizar
    And el usuario selecciona nuevamente la instancia y presiona el boton agregar nuevo
    And el usuario selecciona equipo, contrata mas equipos del que trae "<equipoTV>" y guarda productos
    And el usuario presiona el boton finalizar para agregar los equipos
    And el usuario finalizo la segunda fase y presionar gestor de solicitud
    And el usuario busca la solicitud agregar modificar productos en el gestor de solicitudes
    And el usuario modifica los productos nuevamente
    And el usuario selecciona el equipo desactivado
    And el usuario presiona activar equipo desactivado
    And el usuario selecciona el primer deco agregado
    And el usuario presiona estado anulada
    And el usuario selecciona el segundo deco agregado
    And el usuario presiona estado anulado
    And el usuario finaliza las modificaciones
    And el usuario busca la solicitud en el gestor de solicitud
    And se selecciona gestionar contrato desde el gestor de solicitud y presionar boton ejecutar
    And se presiona el boton crear contrato en pantalla gestion de contrato
    And se selecciona venta presencial en pantalla de contrato
    And se crea contrato y se presiona el boton volver en pantalla contrato
    And se adjunta el documento de contrato
    And se espera que la solicitud quede en estado OT creada
    And El usuario cierra la ventana y del navegador 
     
  
    Examples:
      | user    | password | rut |equipoTV |
      |dsouza   |Gtd*2018  |16016406|DECODIFICADOR IPTV (PQTE)|