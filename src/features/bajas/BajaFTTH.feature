Feature: Prueba de Flujo de Baja de tecnologia FTTH
  Scenario Outline: Baja FTTH
    Given El usuario abre el navegador e ingresa al sistema SICRET
    When el usuario ingresa sus datos, usuario "<user>" y la contrasena "<password>"
    And el usuario ingresa a GESCOM desde el menu ingreso datos de SICRET
    And el usuario ingresa a Resumen Cliente desde el menu GESCOM
    And el usuario crea una Baja FTTH ingresando el rut "<rut>" y seleccionando la cuenta de Servicio "<ctaServicio>"
    And el usuario selecciona el enlace servicio solicitado desde la pantalla crear solicitud
    And el usuario selecciona los servicios FTTH y los desconecta
    And el usuario finaliza la primera fase de solicitud
    And el usuario selecciona el boton crear solicitud
    And el usuario selecciona Datos de la venta en la pantalla crear solicitud
    And el usuario ingresa todos los datos de la venta
    And el usuario finaliza la fase de baja del servicio FTTH
    And el usuario ingresa a gestor de solicitudes desde GESCOM
    And el usuario busca la solicitud de baja FTTH en el gestor de solicitudes
    And el usuario espera a que la solicitud este en estado "<PprovisionProductosOK>"
    And el usuario selecciona gestionar contrato de la lista de operaciones
    And se comienza con las validaciones
    And se selecciona baja presencial y se presiona finalizar
    And se presiona el boton crear contrato y luego se presiona el boton volver
    And se finaliza la etapa de gestion de contrato
    And el usuario espera a que la solicitud quede en estado "<estadoOTCreadaPendiente>"
    And el usuario ingresa al sistema INSTALACIONES desde el menu de sicret
    And el usuario busca la solicitud en el gestor de OT de instalaciones
    And el usuario cierra las actividades de baja de FTTH
    And el usuario espera a que se cierre la OT
    Examples:
      | user | password | rut | ctaServicio | PprovisionProductosOK | estadoOTCreadaPendiente |
    |rurbina|gtd1234  |2003 |3281875      |PROVISION PRODUCTOS OK (8)|OT CREADA Y PENDIENTE (10)|