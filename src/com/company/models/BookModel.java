package com.company.models;

import com.company.Database;
import java.sql.ResultSet;

public class BookModel {
    public String title;
    public String author;
    public int PageNumbers;

    public BookModel(String title, String author, int PageNumbers) {
        this.title = title;
        this.author = author;
        this.PageNumbers = PageNumbers;
    }

    public void create(){
        String query = "INSERT BLAAA";
        try {
            Database.runQuery(query);
        }catch(Exception e){
            System.out.println("ALLES KAPOT" + e.getMessage());
        }
    }

    public static BookModel getByTitle(String title) {
        String query = "SELECT * FROM book WHERE Title = '" + title + "'";
        ResultSet result = Database.runQuery(query);

        try {
            if (result.next()) {
                return new BookModel(
                    result.getString("Title"),
                    result.getString("AuthorName"),
                    result.getInt("PageNumbers")
                );
            }else{
                throw new Exception("Book not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("lol");
        }
    }

    public String toJson() {
        return "{\"title\":" + this.title + ",\"author\":" + this.author + ",\"PageNumbers\":" + this.PageNumbers + "}";
    }
}
 