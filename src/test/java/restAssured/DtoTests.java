package restAssured;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;
import restAssured.ApiData.PostDto;
import java.util.Arrays;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.fail;

public class DtoTests {
  private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
  private static final String BASE_PATH = "/posts";

  static {
    RestAssured.baseURI = BASE_URL;
    RestAssured.basePath = BASE_PATH;
  }

  @Test (description = "Получение записи по Id и проверка, что id не равен null")
  public void getNotNullIdTest() {
    Response response = given().get("1");
    if (response.statusCode() != 200) {
      fail();
    }
    else {
      PostDto postDto = given().get("1").as(PostDto.class); //Десериализация
      if (postDto.getId() == null) {
        fail();
      }
    }
  }

  @Test (description = "Проверка, что id имеет тип integer")
  public void getIntegerIdTest() {
    Response response = given().get("1");
    if (response.statusCode() != 200) {
      fail();
    }
    else {
      PostDto postDto = given().get("1").as(PostDto.class); //Десериализация
      if (!(postDto.getId() instanceof Integer)) {
        fail();
      }
    }
  }

  @Test (description = "Проверка, что title имеет тип integer")
  public void getStringTitleTest() {
    Response response = given().get("1");
    if (response.statusCode() != 200) {
      fail();
    }
    else {
      PostDto postDto = given().get("1").as(PostDto.class); //Десериализация
      if (!(postDto.getTitle() instanceof String)) {
        fail();
      }
    }
  }

  @Test (description = "Получение всех записей") //!!!!!!!! Список
  public void getAllSuccessTest() {
    PostDto[] responseList = given()
            .contentType("application/json")
            .get()
            .as(PostDto[].class);
    List<PostDto> listDto = Arrays.asList(responseList);
    if (given().get().statusCode() == 200) {
      for (int i = 0; i < listDto.size(); i++) {
        System.out.println("id: " + listDto.get(i).getId());
        System.out.println("userId: " + listDto.get(i).getUserId());
        System.out.println("body: " + listDto.get(i).getBody());
        System.out.println("title: " + listDto.get(i).getTitle());
        System.out.println("********************************");
      }
    }
  }

  @Test (description = "Создание записи")
  public void createSuccessTest() {
    PostDto postDto = new PostDto();
    postDto.setUserId(101);
    postDto.setTitle("kasjcjks");
    postDto.setBody("kasjcjksefdsfesfesdfedf");
    Response response = given()
            .contentType("application/json")
            .body(postDto)
            .when()
            .post();
    if (response.statusCode() != 201) {
      fail();
    }
    else response.print();
  }

  @Test (description = "Изменение записи")
  public void putSuccessTest() {
    PostDto postDto = given().get("1").as(PostDto.class);
    postDto.setUserId(1000);
    postDto.setTitle("121gdsg");
    postDto.setBody("dsgdfgdfg121gdsg");
    Response response = given()
            .body(postDto)
            .when()
            .put("1");
    if (response.statusCode() != 200) {
      fail();
    }
    else response.print();
  }
}