package restAssured;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.fail;

public class ApiTests {
  private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
  private static final String BASE_PATH = "/posts";

  static {
    RestAssured.baseURI = BASE_URL;
    RestAssured.basePath = BASE_PATH;
  }

  private Response getId(String id) {
    return given().get(id);
  }

  private Response get() {
    return given().get();
  }

  private int putId(String id) {
    Response response = null;
    if (getId(id).statusCode() == 200) {
      given().put(id);
      return 200;
    } else return getId(id).statusCode();
  }

  private Response deleteId(String id) {
    String str = "/" + id;
    return given().delete(str);
  }

  private int create() {
    Response response = given().contentType("application/json").post();
    return response.statusCode();
  }

  @Test(description = "Получение записи по id")
  public void getIdTest() {
    getId("1").getBody().print();
  }

  @Test(description = "Получение всех записей")
  public void getAllTest() {
    get().getBody().prettyPrint();
  }

  @Test(description = "Изменение записи по Id")
  public void putId() {
    if (putId("100") != 200) {
      fail("Изменение прошло с ошибкой");
    }
  }

  @Test(description = "Удаление записи по id")
  public void deleteIdTest() {
    if (deleteId("100").statusCode() != 200) {
      fail();
    }
  }

  @Test(description = "Добавление записи")
  public void createTest() {
    if (create() != 201){
      fail();
    }
  }
}