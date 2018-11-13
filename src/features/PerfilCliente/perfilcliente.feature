Feature: Prueba Consulta Perfil Cliente
  Scenario Outline: perfil cliente
  Given El usuario abre navegador y entra al sitio Web SICRET
    When El usuario ingresa un userName "<user>" y el passWord "<password>"
    And El usuario ingresa a GESCOM desde Menu SICRET
    And El usuario ingresa a Perfil Clientes desde menu SICRET
    And El usuario busca cliente ingresando el rut "<rut>", "<instancias>" e "<idcotizacion>" 
    And El usuario ingresa filtros de busqueda "<rut>" e "<instancias>"
    And El usuario ingresa filtros de "<rut>" e "<idcotizacion>"
    And El usuario ingresa solo rut "<rut>"
    And Se Valida que existan datos que mostrar
    And El usuario ingresa solo instancia "<instancias>"
    And El usuario ingresa solo cotizacion "<idcotizacion>"
    And El usuario ingresa solo nro ficha "<fichas>"
    And El usuario ingresa solo condominio "<condominios>"
    And El usuario ingresa filtros de direccion "<centrourbano>", "<comunas>", "<calles>", "<sufijos>", "<numeros>", "<deptos>", "<pisos>"
    And El usuario cierra la ventana y navegador
 Examples:
      | user | password | rut |instancias |idcotizacion |fichas |condominios |centrourbano |comunas|calles|sufijos|numeros|deptos|pisos|
      | dsouza | Gtd*2018 |2005 |229445372 | 3581 | 3035 |EDIFICIO LOS MILITARES|GRAN SANTIAGO |SANTIAGO|TARAPACA|A|752|1005|10|