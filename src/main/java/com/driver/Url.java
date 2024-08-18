package com.driver;

public enum Url {
    BASE_URL("");

    private String value;

     Url(String value){
        this.value=value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
