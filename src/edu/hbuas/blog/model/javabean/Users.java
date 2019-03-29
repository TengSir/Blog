package edu.hbuas.blog.model.javabean;


public class Users {

  private long userid;
  private String username;
  private String password;
  private String nickname;
  private long sex;
  private long age;
  private String image;
  private long level;


  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  public long getSex() {
    return sex;
  }

  public void setSex(long sex) {
    this.sex = sex;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }


  public long getLevel() {
    return level;
  }

  public void setLevel(long level) {
    this.level = level;
  }

  @Override
  public String toString() {
    return "Users{" +
            "userid=" + userid +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", nickname='" + nickname + '\'' +
            ", sex=" + sex +
            ", age=" + age +
            ", image='" + image + '\'' +
            ", level=" + level +
            '}';
  }
}
