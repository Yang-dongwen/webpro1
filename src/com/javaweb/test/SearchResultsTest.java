package com.javaweb.test;

import com.javaweb.beans.SearchResults;
import com.javaweb.dao.SearchResultsDao;

import java.util.ArrayList;

public class SearchResultsTest {
    public static void main(String[] args) {
        SearchResultsDao dao = new SearchResultsDao();
        ArrayList<SearchResults> qq = dao.findResultsLikeKeyword("qq");
        for (SearchResults s: qq) {
            System.out.println(s);
        }
    }
}
