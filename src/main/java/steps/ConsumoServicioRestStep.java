package steps;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import models.Registro;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class ConsumoServicioRestStep {

  public Response response;
  public RequestSpecification request;

  @Step
  public void crearEstructuraServicio(String nombreCabecera, String tipo) {
    request = given().header(nombreCabecera, tipo);
  }

  @Step
  public void llamarServicioRestGet(String requestJson) {
    response = request.when().get(requestJson);
  }

  public Registro datosRegistro(String correo, String contrasena) {
    Registro registro = new Registro(correo, contrasena);
    if(!contrasena.isEmpty()){
      registro.setEmail(correo);
      registro.setPassword(contrasena);
    }
    else {
      registro.setEmail(correo);
    }
    return registro;
  }

  @Step
  public void llamarServicioRestPost(String requestJson, String correo, String contrasena) {
    response = request.when().body(datosRegistro(correo, contrasena)).post(requestJson);
  }

  @Step
  public void verificarDatosServicioGet(String estado, String nombre, String anio) {
    Map<String, String> datosJsonGet = response.jsonPath().getJsonObject("data");
    Assert.assertEquals(Integer.parseInt(estado), response.getStatusCode());
    Assert.assertEquals(nombre, datosJsonGet.get("name"));
    Assert.assertEquals(Integer.parseInt(anio), datosJsonGet.get("year"));
  }

  @Step
  public void verificarDatosServicioPost(String estado, String validacion) {
    Map<String, String> datosJsonPost = response.jsonPath().get();
    Assert.assertEquals(Integer.parseInt(estado), response.getStatusCode());
    if (estado.equalsIgnoreCase("200")) {
      Assert.assertEquals(validacion, datosJsonPost.get("token"));
    } else {
      Assert.assertEquals(validacion, datosJsonPost.get("error"));
    }
  }
}
