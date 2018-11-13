Feature: Prueba de Flujo de Baja de tecnologia Cobre
  Scenario Outline: Baja Cobre
    Given El usuario abre el navegador e ingresa al sitio Web de SICRET
    When el usuario ingresa sus datos, userName "<user>" y el passWord "<password>"
    And el usuario ingresa a GESCOM desde el menu de SICRET
    And el usuario ingresa a Resumen Cliente desde GESCOM
    And el usuario crea una Baja Cobre ingresando el rut "<rut>" y seleccionando la cuenta de Servicio "<ctaServicio>"
    And el usuario selecciona el enlace servicio solicitado desde el menu crear solicitud
    And el usuario selecciona los servicios ADSL y los desconecta
    And el usuario finaliza la primera fase
    And el usuario selecciona el boton crear solicitud en la pantalla crear solicitud
    And el usuario selecciona Datos de la venta del menu
    And el usuario ingresa los datos de la venta
    And el usuario finaliza la fase de baja del servicio cobre
    And el usuario ingresa a gestor de solicitudes desde el menu de GESCOM
    And el usuario busca la solicitud de baja en el gestor de solicitudes
    And el usuario espera que la solicitud este en estado provision productos OK
    And el usuario selecciona gestionar contrato
    And se crea el contrato y se comienza con las validaciones
    And se selecciona baja presencial y se finaliza la validacion
    And se selecciona crear contrato y se presiona el boton volver
    And se finaliza etapa de gestion de contrato
    And el usuario espera que la solicitud quede en estado OT creada y pendiente
    And el usuario ingresa al sistema de instalaciones desde el menu de sicret
    And el usuario busca la solicitud en el gestor de OT
    And el usuario cierra las actividades de baja de cobre
    And el usuario espera que el cierre de OT
    Examples:
      | user | password | rut | ctaServicio |
      |rurbina|gtd1234  |2003 |3281863      |

