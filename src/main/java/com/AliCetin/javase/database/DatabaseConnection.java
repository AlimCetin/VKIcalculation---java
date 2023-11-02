package com.AliCetin.javase.database;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection extends DatabaseInformation {

    // Variable
    // kalıtım olarak aldığı protected den ki verileri super ile almak.
    private String url = super.url;
    private String user = super.user;
    private String password = super.password;
    private String forNameData = super.forNameData;

    // JDBC Connection
    private Connection connection;  //java.sql.Connection

    // Singleton Design Pattern (Variable)
    private static DatabaseConnection instance;

    // Singleton Design Pattern (Constructor)
    private DatabaseConnection() {
        try {
            //Driver yükleniyor
            Class.forName(this.forNameData);
            //Database bağlanıyor
            connection = DriverManager.getConnection(url, user, password);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    } //end constructor

    // Singleton Design Pattern (Method)
    public static DatabaseConnection getInstance() {
        try {
            // Eğer connection kapalı veya null ise oluştur
            // Eğer bağlantı varsa o bağlantıyı kullan.
            if (instance == null || instance.connection.isClosed()) {
                instance = new DatabaseConnection();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return instance;
    } //end instance

    // GETTER AND SETTER
    public Connection getConnection () {
        return connection;
    }

    public void setConnection (Connection connection){
        this.connection = connection;
    }


} //End Class DatabaseConnection
