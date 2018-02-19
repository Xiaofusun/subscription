package cr.model;


public class Testuser {

  private long id;
  private long age;
  private String user_name;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public String getUser_name() {
    return user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  public Testuser(long id, long age, String user_name) {
    this.id = id;
    this.age = age;
    this.user_name = user_name;
  }

  public Testuser() {
  }

  @Override
  public String toString() {
    return "Testuser{" +
            "id=" + id +
            ", age=" + age +
            ", user_name='" + user_name + '\'' +
            '}';
  }
}
