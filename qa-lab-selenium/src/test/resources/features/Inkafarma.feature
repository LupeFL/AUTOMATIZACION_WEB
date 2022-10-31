@testInkafarma

Feature: Login Inkafarma
  @testInk1
  Scenario: Login con correo en pagina de Inkafarma
    Given estoy en la pagina web de Inkafarma
    When doy click en inicio de sesion
    And selecciono ingresa con correo electronico
    And ingreso el usuario "ysabelfl@outlook.es"
    And ingreso la contraseña "Prueba$2022"
    And hago click en el boton Ingresar
    Then valido que el mensaje en el menu sea "Isabel Flores"