package com.AliCetin.roles;

public enum ERoles {
    //Kullanıcılar admin - user
    ADMIN(1L,"admin"), USER(2L,"user");

    //Const
    private final Long key;
    private final String value;

    // Construction
    // Sabit değişkene değer atamak
    private ERoles(Long key, String value) {
        this.key = key;
        this.value = value;
    } // End ERoles

    // Getter - final olduğu için Setter kullanamıyoruz
    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}