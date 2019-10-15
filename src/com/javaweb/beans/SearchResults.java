package com.javaweb.beans;

public class SearchResults {
    private Integer id;
    private String keyword;
    private Integer number;

    public SearchResults() {
    }

    @Override
    public String toString() {
        return "SearchResults{" +
                "id=" + id +
                ", keyword='" + keyword + '\'' +
                ", number=" + number +
                '}';
    }

    public SearchResults(Integer id, String keyword, Integer number) {
        this.id = id;
        this.keyword = keyword;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
