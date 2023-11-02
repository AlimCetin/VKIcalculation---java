package com.AliCetin.javase.dao;

import com.AliCetin.javase.database.DatabaseConnection;

import java.sql.Connection;
import java.util.ArrayList;

// INTERFACE
public interface IDaoGenerics <T> {

    // C R U D
    // CREATE
    public T create(T t);

    // FIND BY Nickname
    public ArrayList<T> findByName(String uNicName);

    // LIST
    public ArrayList<T> vkiList();

    // UPDATE
    public T vkiUpdate(Long id, T t);
    // Sonucu Vki de karşılaştırma

    ///////////////////////////////////////////////////////
    default Connection getInterfaceConnection(){
        return DatabaseConnection.getInstance().getConnection();
    } //end body interface
} //end interface IDaoGenerics
