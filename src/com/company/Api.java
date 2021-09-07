package com.company;

import com.company.models.BookModel;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

class Api {

  public static void run(String path, String input){
    switch(path){
      case "/book/get":
        getBook(input);
        break;
      case "/book/create":
        createBook(input);
        break;
      default:
        System.out.println("404 not found");
        break;
    }
  }

  public static void getBook(String input){
    try{
      BookModel book = BookModel.getByTitle(input);
      System.out.println(book.toJson());

    }catch(Exception e){
      System.out.println("Error 500: " + e.getMessage());
    }
  }

  public static void createBook(String input){
    try{
      //First check if exists
      try{
        BookModel book = BookModel.getByTitle(input);
      }catch(Exception e){
        if(e.getMessage().equals("Book not found")){
          System.out.println("400: Book already exists");
        }
      }

      BookModel book = new BookModel(input, "Hans klok", 112);
      book.create();
      System.out.println(book.toJson());

    }catch(Exception e){
      System.out.println("Error 500: " + e.getMessage());
    }
  }
}