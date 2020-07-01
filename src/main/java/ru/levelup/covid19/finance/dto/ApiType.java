package ru.levelup.covid19.finance.dto;

public enum ApiType {
    YAHOO("yahoo"),
    MMVB("mmvb");

    public String value;
    ApiType(final String value) {
        this.value = value;
    }
}
