package edu.hbuas.blog.model.javabean;


public class Blogs {

  private long blogid;
  private String title;
  private String content;
  private String publishtime;
  private long visitedcount;
  private long userid;

  public Blogs() {
  }

  @Override
  public String toString() {
    return "Blogs{" +
            "blogid=" + blogid +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", publishtime='" + publishtime + '\'' +
            ", visitedcount=" + visitedcount +
            ", userid=" + userid +
            '}';
  }

  public Blogs(long blogid, String title, String content, String publishtime, long visitedcount, long userid) {
    this.blogid = blogid;
    this.title = title;
    this.content = content;
    this.publishtime = publishtime;
    this.visitedcount = visitedcount;
    this.userid = userid;
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


  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }

}
