package com.AliCetin.javase.controller;

import com.AliCetin.javase.dao.IDaoGenerics;
import com.AliCetin.javase.dao.RegisterDao;
import com.AliCetin.javase.dto.RegisterDto;

import java.util.ArrayList;

    public class RegisterController implements IDaoGenerics<RegisterDto> {
    // Injection  =>   RegisterDao'yu classın içine enjekte ettik.
    private RegisterDao registerDao = new RegisterDao();

    ///////////////////////////////////////////////////////////////////////
    // Bağlantılar
    // CREATE
    @Override
    public RegisterDto create(RegisterDto registerDto) {
        return registerDao.create(registerDto);
    }

        // Find Nickname
    @Override
    public ArrayList<RegisterDto> findByName(String uNickName) {
        return registerDao.findByName(uNickName);
    }
    // List Vki
    @Override
    public ArrayList<RegisterDto> vkiList() {
        return registerDao.vkiList();
    }
    //Update Vki
    @Override
    public RegisterDto vkiUpdate(Long id, RegisterDto registerDto) {
        return registerDao.vkiUpdate(id, registerDto);
    }
}//End Class RegisterController
