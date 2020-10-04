package definitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;
import steps.ConsumoServicioRestStep;

public class ConsumoServicioRestDefinition {

  @Steps ConsumoServicioRestStep pruebaCompraStep;

  @Dado("^que se crea la estructura del servicio con el (.*) y (.*)$")
  public void crearEstructura(String nombreCabecera, String tipo) {
    pruebaCompraStep.crearEstructuraServicio(nombreCabecera, tipo);
  }

  @Cuando("^hago un llamado al servicio (.*)$")
  public void llamarServicioGet(String request) {
    pruebaCompraStep.llamarServicioRestGet(request);
  }

  @Cuando("^se realiza un llamado al servicio (.*) con los datos (.*) y (.*)$")
  public void llamarServicioPost(String request, String correo, String contrasena) {
    pruebaCompraStep.llamarServicioRestPost(request, correo, contrasena);
  }

  @Entonces("^se verifica que el (.*), (.*) y (.*) sean correctos$")
  public void verificarDatosServicioRest(String estado, String nombre,String anio) {
    pruebaCompraStep.verificarDatosServicioGet(estado, nombre, anio);
  }

  @Entonces("^se verifica que el (.*) y (.*) correspondan con los datos enviados$")
  public void verificarDatosServicioPost(String estado, String validacion) {
    pruebaCompraStep.verificarDatosServicioPost(estado, validacion);
  }

}
