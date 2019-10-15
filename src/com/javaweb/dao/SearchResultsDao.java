package com.javaweb.dao;

import com.javaweb.beans.SearchResults;
import com.javaweb.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchResultsDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet res = null;

    public ArrayList<SearchResults> findResultsLikeKeyword(String keyword){
        ArrayList<SearchResults> results = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from searchresults where keyword = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,keyword);
            res = ps.executeQuery();

            while (res.next()){
                SearchResults s = new SearchResults();
                s.setId(res.getInt("id"));
                s.setKeyword(res.getString("keyword"));
                s.setNumber(res.getInt("number"));
                results.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps,res);
        }
        return results;
    }
}
