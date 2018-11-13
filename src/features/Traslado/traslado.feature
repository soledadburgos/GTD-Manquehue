Feature: Prueba Traslado
  Scenario Outline: Traslado a una cuenta de servicio origen Activa
    Given el usuario debe abrir el navegador e ingresamos al sitio Web de SICRET
    When el usuario ingresa el userName "<user>" y el passWord "<password>"
    And el usuario ingresa a GESCOM en el menu de SICRET
    And el usuario ingresa a Resumen Cliente en el submenu GESCOM
    And el usuario ingresa el rut "<rut>", selecciona la cuenta "<ctaServicio>" y selecciona Traslado
    And el usuario selecciona opcion uno Buscar Cta Facturacion fase I
    And el usuario busca la cuenta de facturacion "<ctafacturacion"> y la modifica
    
   
   Examples:
      |user  |password| rut     |ctaServicio|ctafacturacion|
      |dsouza|Gtd*2018|16016406 |3282162    |3282161       |