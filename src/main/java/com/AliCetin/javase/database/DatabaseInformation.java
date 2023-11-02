package com.AliCetin.javase.database;

// Database Information
abstract public class DatabaseInformation {

    // Variable
    //Kalıtım sağlayacak klasöre getter - setter yapmadan direkt alabilecek
    //protected amacı public ilr private arasında bağlantıyı sağlamak.
    protected String url;
    protected String user;
    protected String password;
    protected String forNameData;

    // Constructor
    public DatabaseInformation() {
        user="root";
        //Yanlış olursa: Caused by: java.sql.SQLException: Access denied for user 'root44'@'localhost' (using password: YES)
        password="root";
        //Yanlıs olursa: Caused by: java.sql.SQLException: Access denied for user 'root'@'localhost'   (using password: YES)
        url="jdbc:mysql://localhost:3306/vkidatabase";
        forNameData="com.mysql.cj.jdbc.Driver";
    }
    public DatabaseInformation(String url, String user, String password, String forNameData) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.forNameData = forNameData;
    }

    // GETTER AND SETTER
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getForNameData() {
        return forNameData;
    }

    public void setForNameData(String forNameData) {
        this.forNameData = forNameData;
    }
} //end class DatabaseInformation
