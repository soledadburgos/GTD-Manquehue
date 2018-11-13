Feature: Prueba de Flujo de Alta de tecnologia FTTH
  Scenario Outline: Alta FTTH
    Given El usuario abre el navegador y vamos al sitio Web de SICRET
    When el usuario ingresa sus datos, usuario "<user>" y el passWord "<password>"
    And el usuario ingresa a GESCOM desde el menu SICRET
    And el usuario ingresa a Resumen Cliente desde el menu de GESCOM
    And el usuario crea un Alta FTTH ingresando el rut "<rut>" y seleccionando la cuenta de facturacion "<ctaFacturacion>"
    And el usuario selecciona crear modificar cliente desde la pantalla crear solicitud
    And el usuario presiona el boton modificar cliente en la pantalla crear modificar cliente
    And el usuario selecciona crear modificar cuenta de servicio desde la pantalla crear solicitud
    And el usuario busca la cuenta de servicio "<ctaServicio>" y presiona el boton seleccionar
    And el usuario selecciona servicio solicitado desde la pantalla crear solicitud
    And el usuario selecciona tipo uso "<tipoUso>" y tipo servicio "<tipoServicioTVFTTH>"
    And el usuario selecciona tipo uso "<tipoUso>", tipo servicio "<tipoServicioINTFTTH>" y velocidad del servicio "<velocidad>"
    And el usuario selecciona tipo uso "<tipoUso>", tipo servicio "<tipoServicioVOZFTTH>"
    And el usuario presiona el boton guardar en la pantalla de servicio solicitado
    And el usuario selecciona datos de la venta desde la pantalla crear solicitud
    And el usuario ingresa un comentario "<comentarioVenta>" de la venta
    And el usuario selecciona crear modificar cta facturacion desde la pantalla crear solicitud
    And el usuario presiona el boton modificar en la pantalla crear modificar cta facturacion
    And el usuario selecciona crear contacto cliente desde pantalla crear solicitud
    And el usuario finaliza la fase de crear el Alta FTTH
    Then el usuario ingresa al Gestor de Solicitudes
    And el usuario busca la solicitud en el gestor de solicitudes
    And se revisa si la solicitud esta en estado revision comercial
    And si esta en estado revision comercial, se aprueba y se continua
    And se revisa que el estado de la solicitud sea factibilidad tecnica OK
    And se selecciona agregar productos a instancia y se presiona ejecutar
    And se_selecciona_cada_instancia_y_se_aprovisiona "<contratoVoz>", "<planInternet>", "<planTVFTTH>" y "<equipoTV>"
    And se presiona el boton Finalizar en pantalla agregar productos a instancia
    And se selecciona gestionar contrato desde el gestor de solicitud y se presiona boton ejecutar
    And se presiona el boton crear contrato en la pantalla gestion de contrato
    And se selecciona venta presencial en la pantalla de contrato
    And se crea el contrato y se presiona el boton volver en pantalla contrato
    And se adjunta documento de contrato
    And se espera que la solicitud quede en estado OT creada y pendiente
    And el usuario ingresa al sistema de Instalaciones desde el menu de SICRET
    And el usuario busca la solicitud creada de Alta FTTH
    And se cierran las actividades de cada OT
    And se espera que se termine la solicitud y se cierre la OT
    Examples:
      | user | password | rut | ctaFacturacion | ctaServicio | tipoUso | tipoServicioTVFTTH | tipoServicioINTFTTH | velocidad | tipoServicioVOZFTTH | comentarioVenta | contratoVoz | planInternet | planTVFTTH | equipoTV |
      |dsouza|Gtd*2018  |2003 |3145236         |3281875      |COMERCIAL|TV FTTH             |INT FTTH             |2000/1500  |VOZ FTTH             |Test Automatizado Tri play FTTH|PLAN VOZ 500 MINUTOS|PLAN INTERNET HOGAR 10 Mbps|PLAN TV INTERACTIVA - INICIAL (60-977)|ARRIENDO DECO|