package ru.levelup.covid19.finance.dto.yahoo.market;

public enum CompanySymbol {
    /** Норильский никель (RUB) */
    GMKN_ME("GMKN.ME"),
    /** Норильский никель (USD) */
    NILSY("NILSY"),
    /** Лукойл */
    LUKOY(""),
    /** Мегафон */
    MFOYY("MFOYY"),
    /** МТС (RUB) */
    MTSS_ME("MTSS.ME"),
    /** МТС (USD) */
    MTSC("MTSC"),
    /** Газпром */
    OGZPY("OGZPY"),
    /** Сбербанк (RUB) */
    SBER_ME("SBER.ME"),
    /** Сбербанк (USD) */
    SBRCY("SBRCY");

    public String value;
    CompanySymbol(final String value) {
        this.value = value;
    }
}
