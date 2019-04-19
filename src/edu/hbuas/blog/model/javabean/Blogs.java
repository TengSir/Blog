package edu.hbuas.blog.model.javabean;


public class Blogs {

  private long blogid;
  private String title;
  private String content;
  private String publishtime;
  private long visitedcount;

  private Users user;//has-a

  public Blogs() {
  }

  public Blogs(long blogid, String title, String content, String publishtime, long visitedcount) {
    this.blogid = blogid;
    this.title = title;
    this.content = content;
    this.publishtime = publishtime;
    this.visitedcount = visitedcount;
  }

  @Override
  public String toString() {
    return "Blogs{" +
            "blogid=" + blogid +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", publishtime='" + publishtime + '\'' +
            ", visitedcount=" + visitedcount +
            ", user=" + user +
            '}';
  }

  public long getBlogid() {
    return blogid;
  }

  public void setBlogid(long blogid) {
    this.blogid = blogid;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getPublishtime() {
    return publishtime;
  }

  public void setPublishtime(String publishtime) {
    this.publishtime = publishtime;
  }

  public long getVisitedcount() {
    return visitedcount;
  }

  public void setVisitedcount(long visitedcount) {
    this.visitedcount = visitedcount;
  }

  public Users getUser() {
    return user;
  }

  public void setUser(Users user) {
    this.user = user;
  }
}
