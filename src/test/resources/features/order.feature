@Regression
Feature: Validación de Crear y Consultar los pedidos en la API PetStore

  @createOrder
  Scenario Outline: Crear pedidos
    When creo el pedido con id "<ID>", pedID "<petID>", quantity "<quantity>", shipDate "<shipDate>", status "<status>", complete, "<complete>"
    Then el código de respuesta es 200
    And el status es "placed"
    Examples:
      | ID | petID | quantity |        shipDate        | status | complete |
      |  123 |   1   |   5     |2024-08-27T10:00:00Z| placed |   true   |
      |  124 |   2   |   7     |2024-08-27T10:30:10Z| placed |   true   |
      |  125 |   3   |   2     |2024-08-27T10:59:20Z| placed |   true   |

  @getOrder
  Scenario Outline: Consultar pedidos

    Given consulto el pedido con ID "<ID>"
    Then el código de respuesta es 200
    And el status es "placed"
    Examples:
      | ID |
      | 123 |
      | 124 |
      | 125 |