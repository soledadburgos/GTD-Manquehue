Feature: Prueba de Flujo de Alta de tecnologia Cobre
  Scenario Outline: Alta Cobre
    Given el usuario abre el navegador y vamos al sitio Web de SICRET
    When el usuario ingrese sus datos, userName "<user>" y el passWord "<password>"
    And el usuario ingrese a GESCOM desde el menu de SICRET
    And el usuario ingrese a Resumen Cliente desde GESCOM
    And el usuario crea un Alta Cobre ingresando el rut "<rut>" y seleccionando la cuenta de facturacion "<ctaFacturacion>"
    And el usuario selecciona crear modificar cliente desde el menu de crear solicitud
    And el usuario presiona el boton modificar cliente en la pantalla de crear cliente
    And el usuario selecciona crear modificar cuenta de servicio desde el menu de crear solicitud
    And el usuario selecciona la cuenta de servicio "<ctaServicio>" y presiona el boton seleccionar
    And el usuario selecciona servicio solicitado desde el menu crear solicitud
    And el usuario selecciona tipo uso "<tipoUso>", tipo servicio "<tipoServicio>" y velocidad "<velocidad>"
    And el usuario selecciona una vez mas para gregar TV tipo uso "<tipoUso>" y tipo servicio "<tipoServicioTV>"
    And el usuario presiona el boton guardar
    And el usuario selecciona datos de la venta desde el menu de crear solicitud
    And el usuario ingresa comentario "<comentarioVenta>" de la venta
    And el usuario selecciona crear modificar cta facturacion desde el menu de crear solicitud
    And el usuario presiona el boton modificar
    And el usuario selecciona crear modificar contacto cliente desde pantalla crear solicitud
    And el usuario finaliza la fase de crear el Alta Cobre
    Then el usuario ingresa en el Gestor de Solicitudes
    And el usuario busca la solicitud recien creada
    And se revisa si la solicitud esta en revision comercial
    And si esta en revision comercial, se aprueba y se continua
    And se espera que el estado de la solicitud sea factibilidad tecnica OK
    And se selecciona agregar productos a instancia y se presiona el boton ejecutar
    And se selecciona la instancia y se agregan los productos "<productoCU>", "<contratoVoz>", "<productoTVCU>" y "<equipoDecoTV>"
    And se presiona el boton Finalizar
    And se selecciona gestionar contrato desde el gestor de solicitud y se presiona el boton ejecutar
    And se presiona el boton crear contrato
    And se selecciona venta presencial
    And se crea el contrato y se presiona el boton volver
    And se adjunta archivo
    And se espera que la solicitud quede en estado 10 OT creada y pendiente
    And se ingresa al sistema de Instalaciones desde el menu de SICRET
    And se busca la solicitud creada de Alta Cobre
    And se cierran las actividades
    And se espera que se cierre la OT

    Examples:
      | user    | password | rut |ctaFacturacion| ctaServicio | tipoUso | tipoServicio |tipoServicioTV| velocidad | comentarioVenta    | productoCU                | contratoVoz         | productoTVCU                          | equipoDecoTV                              |
      |rurbina  |gtd1234   |2003 | 3145236      |3281863      |COMERCIAL|ADSL          |TELEVISION    |2000/600   |Test Automatizado CU|PLAN INTERNET HOGAR 5 Mbps |PLAN VOZ 500 MINUTOS |PLAN TV INTERACTIVA - INICIAL (60-977) |ARRIENDO DECO PVR TV INTERACTIVA ADICIONAL |
