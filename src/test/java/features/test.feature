@funcional
Feature: Categoria Comics
  Como usuario quiero leer chistes de testers para reirme y pasar un buen rato.

  @browser @slow
  Scenario: Ingresar a la categoria comics desde la pantalla home
    Given El usuario se encuentra en la pagina home de imalittletester
    When Hace click sobre el boton The little tester comics
    Then Se debe redirigir a la pantalla comic

@outline @fast
Scenario Outline: Bebiendo
  Given Hay <inicio> cervezas
  When tomo <cantidad> cervezas
  Then Deberian quedar <resto> cervezas
  @test1
  Examples:
  |inicio|cantidad|resto|
  |10    |5       |5    |
  |10    |10      |0    |
  @test2
  Examples:
    |inicio|cantidad|resto|
    |80    |30       |50    |
    |30   |10      |20    |
  @docstring @fast
  Scenario: Doc Strings
    Given Un blog llamado "Random" con el siguiente contenido
    """
    Teoria de la tierra forma de rosquilla
    =============
    Este es el primer parrafo
    """
  @datatable
  Scenario: Data table
    Given Los siguientes usuarios existentes
    |nombre|email|twitter|
    |santi |santi@mgial.com|@santi|
    |orion |ori@gmail.com  |@ori  |
