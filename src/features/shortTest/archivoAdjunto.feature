Feature: Prueba archivo adjunto
  Scenario Outline: Archivo adjunto
    Given Abrimos el navegador y vamos al sitio Web de SICRET
    When El usuario ingrese el userName "<user>" y el passWord "<password>"
    And El usuario ingrese a Atencion Clientes desde el menu de SICRET
    And El usuario ingrese al gestor de reclamos
    And El usurio busca reclamo con id Reclamo "<idReclamo>" y presiona boton buscar
    And El usuario presiona boton Archivo Adjunto
    And El usuario presiona boton agregar y evaluamos mensaje "<noExisteArchivo>" y mensaje "<debeSeleccionarArchivo>"
    And El usuario adjunta un archivo y evaluamos mensaje "<archivoGuardadoCorrectamente>"
    And El usuario selecciona archivo y presiona el boton BORRAR SELECCIONADOS
    And Se confirma borrado del archivo y se evalua mensaje "<borradoExitoso>"
    Examples:
      | user | password | idReclamo | noExisteArchivo | debeSeleccionarArchivo | archivoGuardadoCorrectamente | borradoExitoso |
    |rurbina|Gtd12345  |6134865    |NO existen archivos adjuntos|Falta seleccionar un archivo|El archivo DOC6134865.doc se guardo correctamente.|Los archivos seleccionados se borraron correctamente.|