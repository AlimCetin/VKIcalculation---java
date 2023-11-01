package com.AliCetin.dto;

import java.io.Serializable;
import java.util.Date;

public class RegisterDto extends BaseDto implements Serializable {

    // Serileştirme
    //static burada bir kere tanımlayıp diğer class larda new yapmadan kullanmak için
    //program sonlandırılana kadar bellekte kalır.
    public static final Long serialVersionUID=1L;

    //Variable
    private String uNickname; // Adı
    private Long kilo; //kilo
    private Long weight;//ağırlık
    private String explanation; //açıklama
    private Long minVkiInterval;//minVki degeri
    private Long maxVkiInterval;//maxVki degeri
    private String rolles;

    // Constructor

    public RegisterDto(Long id, Date systemCreatedDate, String uNickname, Long kilo, Long weight, String rolles) {
        super(id, systemCreatedDate);
        this.uNickname = uNickname;
        this.kilo = kilo;
        this.weight = weight;
        this.rolles = rolles;
    }

    public RegisterDto(String explanation, Long minVkiInterval, Long maxVkiInterval) {
        this.explanation = explanation;
        this.minVkiInterval = minVkiInterval;
        this.maxVkiInterval = maxVkiInterval;
    }

    //toString
    @Override
    public String toString() {
        return "RegisterDto{" +
                "uNickname='" + uNickname + '\'' +
                ", kilo=" + kilo +
                ", weight=" + weight +
                ", explanation='" + explanation + '\'' +
                '}';
    }


    //GETTER AND SETTER
    public String getuNickname() {
        return uNickname;
    }

    public void setuNickname(String uNickname) {
        this.uNickname = uNickname;
    }

    public Long getKilo() {
        return kilo;
    }

    public void setKilo(Long kilo) {
        this.kilo = kilo;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Long getMinVkiInterval() {
        return minVkiInterval;
    }

    public void setMinVkiInterval(Long minVkiInterval) {
        this.minVkiInterval = minVkiInterval;
    }

    public Long getMaxVkiInterval() {
        return maxVkiInterval;
    }

    public void setMaxVkiInterval(Long maxVkiInterval) {
        this.maxVkiInterval = maxVkiInterval;
    }

    public String getRolles() {
        return rolles;
    }

    public void setRolles(String rolles) {
        this.rolles = rolles;
    }
} //End Class RegisterDto
