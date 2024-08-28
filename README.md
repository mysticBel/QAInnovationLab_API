# QAInnovationLab - Automatización de APIS

Automation Team / For education purpose

Se le he encargado la misión de automatizar las pruebas unitarias del API del Store. Dicha funcionalidad es la encargada de crear los pedidos en la tienda de mascotas, y también validarlos para garantizar que los componentes estén funcionando adecuadamente (códigos de respuesta), incluyendo la validación de la conexión de la BD.

Debe redactar en Gherkin un caso de pruebas, que pueda garantizar la integridad del API de Store.

APP: https://petstore.swagger.io/

Debe crear 1 solo Feature que contenga los siguientes 2 Escenarios:

- Creación de Order: POST /store/order
- Consulta de Order: GET /store/order/{orderId}

Puntaje:

Escenario 1: 6 puntos
Escenario 2: 6 puntos
Uso de Assertions correctamente en el Then: 2 puntos
Uso de Scenario Outline y Examples: 4 puntos
Buena redacción en Gherkin y claridad en el código Java 2 puntos
Nota:

Al ejecutarse, debe ejecutarse primero el escenario 1, y luego el escenario 2.
El código de la solución debe estar en la rama principal (main o master).
Cada escenario debe validar el status code del response, y también validar el body del response.
