package com.AliCetin.javase.dto;

import java.io.Serializable;
import java.util.Date;

    public class BaseDto implements Serializable {
    //Serializable = veriyi ve veri tipinin beraber tutulmasıdır.
    //serialVersionUID seriyaleştirme olayı yapılırken verilen serialversiyon kodudur.
    //Veri okunurken kayıtlı kod ile okuma esnasındaki kodu karşılaştırır.
    public static final long serialVersionUID = 1L;

    //Variable
    private Long id;
    private Date systemCreatedDate;

    // Constructor
    public BaseDto() {
    }

    public BaseDto(Long id, Date systemCreatedDate) {
        this.id = id;
        this.systemCreatedDate = systemCreatedDate;
    }

    // toString
    @Override
    public String toString() {
        return "BaseDto{" +
                "id=" + id +
                ", systemCreatedDate=" + systemCreatedDate +
                '}';
    }


    // GETTER AND SETTER
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSystemCreatedDate() {
        return systemCreatedDate;
    }

    public void setSystemCreatedDate(Date systemCreatedDate) {
        this.systemCreatedDate = systemCreatedDate;
    }
} //End Class BaseDto
