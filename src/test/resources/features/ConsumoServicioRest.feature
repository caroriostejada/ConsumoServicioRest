# language: es

Característica: Consumo de servicios rest de la página reqres para pruebas.

  Esquema del escenario: Consumir servicio rest Json vacío (SINGLE RESOURCE)
    Dado que se crea la estructura del servicio con el <nombreCabecera> y <tipo>
    Cuando hago un llamado al servicio <request>
    Entonces se verifica que el <estado>, <nombre> y <anio> sean correctos
    Ejemplos:
      | nombreCabecera | tipo             | request                         | estado | nombre       | anio |
      | Content-Type   | application/json | https://reqres.in/api/unknown/2 | 200    | fuchsia rose | 2001 |


  Esquema del escenario: Consumir servicio rest con parámetros (REGISTER - SUCCESSFUL y REGISTER - UNSUCCESSFUL)
    Dado que se crea la estructura del servicio con el <nombreCabecera> y <tipo>
    Cuando se realiza un llamado al servicio <request> con los datos <correo> y <contrasena>
    Entonces se verifica que el <estado> y <validacion> correspondan con los datos enviados
    Ejemplos:
      | nombreCabecera | tipo             | request                        | estado | correo             | contrasena | validacion        |
      | Content-Type   | application/json | https://reqres.in/api/register | 200    | eve.holt@reqres.in | pistol     | QpwL5tke4Pnpja7X4 |
      | Content-Type   | application/json | https://reqres.in/api/register | 400    | sydney@fife        |            | Missing password  |