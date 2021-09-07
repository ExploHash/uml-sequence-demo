package com.company;

public class Main {

    public static void main(String[] args) {
        Database.initializeConnection();
        Api.run("/book/create", "Cynthia");
        Database.closeConnection();
    }
}
