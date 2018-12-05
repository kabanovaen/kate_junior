package restAssured.ApiData;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class PostDto implements Serializable {
  private Integer userId;
  private Integer id;
  private String title;
  private String body;

  public PostDto() {
  }

  @JsonCreator
  public PostDto(@JsonProperty("userId") Integer userId, @JsonProperty("id") Integer id, @JsonProperty("title") String title, @JsonProperty("body") String body) {
    this.userId = userId;
    this.id = id;
    this.title = title;
    this.body = body;
  }

  public Integer getUserId() {
    return userId;
  }

  public Integer getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getBody() {
    return body;
  }

  @JsonSetter("userId")
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  @JsonSetter("id")
  public void setId(Integer id) {
    this.id = id;
  }

  @JsonSetter("title")
  public void setTitle(String title) {
    this.title = title;
  }

  @JsonSetter("body")
  public void setBody(String body) {
    this.body = body;
  }

  @Override
  public String toString() {
    return "PostDto{" + "userId=" + userId + ", id=" + id + ", title='" + title + '\'' + ", body='" + body + '\'' + '}';
  }
}