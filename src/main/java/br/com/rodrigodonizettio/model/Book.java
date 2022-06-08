package br.com.rodrigodonizettio.model;

public class Book {
    private Integer id;
    private String title;
    private int numberOfPages;
    private String isTranslated;

    public Book(Integer id, String title, int numberOfPages, String isTranslated) {
        this.id = id;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.isTranslated = isTranslated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getIsTranslated() {
        return isTranslated;
    }

    public void setIsTranslated(String isTranslated) {
        this.isTranslated = isTranslated;
    }
}
