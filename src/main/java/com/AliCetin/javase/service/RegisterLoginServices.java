package com.AliCetin.javase.service;

import com.AliCetin.javase.controller.RegisterController;
import com.AliCetin.javase.dto.RegisterDto;
import com.AliCetin.javase.files.FilePathData;

import java.util.ArrayList;
import java.util.Scanner;

public class RegisterLoginServices {

    // Injection
    private RegisterController registerController = new RegisterController();
    private FilePathData filePathData = new FilePathData();

    // 1-> Kullancısı bilgileri girip vki hesalamasını yapacak ve eski verilerini gösterecek
    // 2-> Kullanıcının rolünü konrtol ederek.
    //   a-> Eğer Admin ise
    //      - Vki nin referans datasını update edebilecek.
    //   b-> Eğer user ise sadece eski kayıt yaptığı verileri görebilecek

    private void vkiHesapla(RegisterDto registerDto) {
        Long sonuc = (registerDto.getKilo() / (registerDto.getWeight() * registerDto.getWeight()));
        Boolean dataNull=Boolean.FALSE;
        System.out.println("-------------------------");
        System.out.println("Vki Sonucu :" + sonuc);
        System.out.println("-------------------------");
        ArrayList<RegisterDto> list=registerController.vkiList();
        for (RegisterDto regDto : list) {
            if ((regDto.getMinVkiInterval()<= sonuc )&&(regDto.getMaxVkiInterval()>=sonuc))  {
                System.out.println(regDto.getMinVkiInterval()+ " < "+sonuc+" > "+regDto.getMaxVkiInterval());
                System.out.println(regDto.getExplanation());
                dataNull=Boolean.TRUE;
                break;
            }
            if(dataNull) {
                System.out.println(sonuc+" Vki nin belirtilen aralıkta sonucunuz değildir ");
            }
        }
    }
    private void listNickname(RegisterDto registerDto){

        ArrayList<RegisterDto> list=registerController.findByName(registerDto.getuNickname());
        for (RegisterDto regDto : list) {
                System.out.println("Adınız --> "+regDto.getuNickname()+" Boyunuz --> "+regDto.getWeight() +
                        " Kilonuz  -->"+regDto.getKilo() + " Tarih  --> "+regDto.getSystemCreatedDate() );
        }
    }
    private void autoRegister(RegisterDto registerDto) {
        registerController.create(registerDto);
    }
    public void vkiVKIcalculation() {
        Scanner klavye = new Scanner(System.in);
        RegisterDto registerDto = new RegisterDto();
        System.out.println("\n<== Vki Hesap Sayfasına Hoşgeldiniz =>");
        System.out.println("Adınızı giriniz");
        registerDto.setuNickname(klavye.nextLine());
        System.out.println("Kilo bilginizi giriniz");
        registerDto.setKilo(klavye.nextLong());
        System.out.println("Boy bilginizi giriniz");
        registerDto.setWeight(klavye.nextLong());
        // Otomatik olarak bilgiler database kayıt
        autoRegister(registerDto);
        vkiHesapla(registerDto);
        System.out.println("--------- Eski Veriler----------");
        listNickname(registerDto);
    }
} //end class
