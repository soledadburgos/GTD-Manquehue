Feature: Prueba Cambio de numero
  Scenario Outline: Cambio de numero a una instancia Activa
    Given el usuario abre navegador e ingresamos al sitio Web de SICRET
    When el usuario ingresa userName "<user>" y el passWord "<password>"
    And el usuario ingresa a GESCOM del menu de SICRET
    And el usuario ingresa a Resumen Cliente del submenu GESCOM
    And el usuario ingresa rut "<rut>", selecciona la cuenta "<ctaServicio>", intancia y selecciona cambio de numero
    And el usuario selecciona opcion uno crea modifica cambio de numero fase I
    And el usuario selecciona Activo con estado disponible sicret
    And el usuario guarda el cambio de numero
    And el usuario selecciona opcion dos con los datos de la venta fase I
    And el usuario ingresa los datos del vendedor y guarda
    And el usuario presiona finalizar fase I
    And el usuario selecciona opcion uno crea modifica contacto cliente fase II y seleccionar contacto
    And el usuario presiona finalizar fase II y presiona ver gestor de solicitudes
    And el usuario busca la solicitud para Agregar productos a instancia
    And el usuario selecciona la solicitud y ejecuta la operacion Agregar producto a instancia
    And el usuario selecciona la instancia con tipo de linea linea SIP
    And el usuario selecciona el boton Finalizar en Agregar producto a instancia
    And el usuario selecciona la solicitud y ejecuta la operacion Gestionar Contrato
    And el usuario presiona el boton crear contrato en la interfaz Gestion de contrato
    And el usuario selecciona los datos del tipo de venta y finaliza los datos de la venta
    And el usuario presiona crear para un nuevo contrato y se presiona el boton volver en pantalla contrato
    And el usuario presiona el boton finalizar y cerrar el contrato
    And el usuario espera que la solicitud quede en estado OT creada y pendiente(10)
    And el usuario cierra la ventana y el navegador
  
    Examples:
      |user  |password| rut |ctaServicio|
      |dsouza|Gtd*2018|2037 |3282586    |