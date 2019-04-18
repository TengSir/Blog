package edu.hbuas.blog.model.javabean;

public class PageBean {
    private int nowPage;
    private int nextPage;
    private int previousPage;
    private int firstPage;
    private int lastPage;
    private int allPages;
    private  int allCount;
    private int everyPageCount;

    @Override
    public String toString() {
        return "PageBean{" +
                "nowPage=" + nowPage +
                ", nextPage=" + nextPage +
                ", previousPage=" + previousPage +
                ", firstPage=" + firstPage +
                ", lastPage=" + lastPage +
                ", allPages=" + allPages +
                ", allCount=" + allCount +
                ", everyPageCount=" + everyPageCount +
                '}';
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getAllPages() {
        return allPages;
    }

    public void setAllPages(int allPages) {
        this.allPages = allPages;
    }

    public int getAllCount() {
        return allCount;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    public int getEveryPageCount() {
        return everyPageCount;
    }

    public void setEveryPageCount(int everyPageCount) {
        this.everyPageCount = everyPageCount;
    }
}
