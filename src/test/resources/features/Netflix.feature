Feature: Netflix - Challenge automated test

  @Challenge
  Scenario: Imprimir título
    When Ingreso a la pagina de Netflix
    And Maximizo la pantalla
    Then Verifico e imprimo la actual URL


  @Challenge
  Scenario: Inicio de sesión fallido
    When Ingreso a la pagina de Netflix
    And Maximizo la pantalla
    And Clickeo el botón Iniciar Sesión
    Then Se carga la página de inicio de sesión
    When Ingreso mi email "joan.example@gmail.com" y password "123456"
    And Clickeo el botón de inicio de sesión
    Then Se muestra un mensaje de error