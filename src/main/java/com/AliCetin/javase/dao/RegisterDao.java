package com.AliCetin.javase.dao;

import com.AliCetin.javase.dto.RegisterDto;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
Transaction:  Create, Delete, Update
connection.setAutoCommit(false)  => Default: true
connection.commit();   ==> Başarılı
connection.rollback(); ==> Başarısız
 */

public class RegisterDao implements IDaoGenerics<RegisterDto>, Serializable {


    // CREATE
    @Override
    public RegisterDto create(RegisterDto registerDto) {
        try (Connection connection = getInterfaceConnection()) {
            // Manipulation: executeUpdate() [create, delete, update]
            // Sorgularda  : executeQuery [list, find]
            // Transaction:
            connection.setAutoCommit(false); //default:true
            String sql = "INSERT INTO `vkidatabase`.`register` (`nick_name`,`kilo`,`weight`,`roles`) \n" +
                    " VALUES (?, ?, ?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, registerDto.getuNickname());
            preparedStatement.setLong(2, registerDto.getKilo());
            preparedStatement.setLong(3, registerDto.getWeight());
            preparedStatement.setString(4, registerDto.getRolles());
            int rowsEffected = preparedStatement.executeUpdate();
            // eğer ekleme yapılmamışsa -1 değerini döner
            if (rowsEffected > 0) {
                System.out.println(" ==> Veriler başarılı bir şekilde eklendi.");
                System.out.println("Adınız --> "+registerDto.getuNickname()+" Boyunuz --> "+registerDto.getWeight()+" Kilonuz  --> "+registerDto.getKilo() );

                connection.commit(); // başarılı
            } else {
                System.err.println("=> Veriler Eklenemedi.");
                connection.rollback(); // başarısız
            }
            return  registerDto; // eğer başarılı ise return registerDto
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // FIND Nickname
    @Override
    public ArrayList<RegisterDto> findByName (String uNickname) {
        ArrayList<RegisterDto> findByName=new ArrayList<>();
        RegisterDto registerDto;
        try (Connection connection = getInterfaceConnection()) {
            // Dikkat: email_address String olduğu için tırnak içinde yazıyoruz örneğin: email="hamitmizrak@gmail.com"
            String sql = "SELECT * FROM vkidatabase.register where nick_name='"+uNickname+"\'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // executeUpdate() [create, delete, update]
            // Sorgularda  : executeQuery [list, find]
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                // nick_name, kilo, weight, roles
                registerDto=new RegisterDto();
                registerDto.setId(resultSet.getLong("id"));
                registerDto.setuNickname(resultSet.getString("nick_name"));
                registerDto.setKilo(resultSet.getLong("kilo"));
                registerDto.setWeight(resultSet.getLong("weight"));
                registerDto.setRolles(resultSet.getString("roles"));
                registerDto.setSystemCreatedDate(resultSet.getDate("system_created_date"));
                findByName.add(registerDto);
            }
            return findByName; // eğer başarılı ise return registerDto
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // VKI LIST
    @Override
    public ArrayList<RegisterDto> vkiList() {
        ArrayList<RegisterDto> list=new ArrayList<>();
        RegisterDto registerDto;
        try (Connection connection = getInterfaceConnection()) {
            // Dikkat: email_address String olduğu için tırnak içinde yazıyoruz örneğin: email="hamitmizrak@gmail.com"
            String sql = "SELECT * FROM vkidatabase.vkidata";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // executeUpdate() [create, delete, update]
            // Sorgularda  : executeQuery [list, find]
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                // nick_name, email_address, password, roles, remaining_number, is_passive
                registerDto=new RegisterDto();
                registerDto.setId(resultSet.getLong("id"));
                registerDto.setExplanation(resultSet.getString("explanation"));
                registerDto.setMinVkiInterval(resultSet.getLong("minVkiInterval"));
                registerDto.setMaxVkiInterval(resultSet.getLong("maxVkiInterval"));
                list.add(registerDto);
            }
            return  list; // eğer başarılı ise return registerDto
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // UPDATE
    @Override
    public RegisterDto vkiUpdate(Long id, RegisterDto registerDto) {
        try (Connection connection = getInterfaceConnection()) {
            connection.setAutoCommit(false); //default:true
            String sql = "UPDATE `vkidatabase`.`vkidata` SET `explanation`=?, `minVkiInterval`=?, `maxVkiInterval`=?, " +
                    " WHERE `id` =?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, registerDto.getExplanation());
            preparedStatement.setLong(2, registerDto.getMinVkiInterval());
            preparedStatement.setLong(3, registerDto.getMaxVkiInterval());
            preparedStatement.setLong(4, registerDto.getId());
            int rowsEffected = preparedStatement.executeUpdate();
            // eğer güncelle yapılmamışsa -1 değerini döner
            if (rowsEffected > 0) {
                System.out.println(RegisterDao.class + " Başarılı Güncelleme Tamamdır");
                connection.commit(); // başarılı
            } else {
                System.err.println(RegisterDao.class + " !!! Başarısız Güncelleme Tamamdır");
                connection.rollback(); // başarısız
            }
            return  registerDto; // eğer başarılı ise return registerDto
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

} //end class RegisterDao
