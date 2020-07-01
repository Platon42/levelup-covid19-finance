package ru.levelup.covid19.finance.dto.mmvb;

/* Индексы ММВБ */
public enum MmvbIndexes {
    /** Металлы */
    MOEXMM("MOEXMM"),
    /** Финансы */
    MOEXFN("MOEXFN"),
    /** Нефть и газ */
    MOEXOG("MOEXOG"),
    /** Потребительский сектор */
    MOEXCN("MOEXCN"),
    /** Электроэнергия */
    MOEXEU("MOEXEU"),
    /** Транспорт */
    MOEXTN("MOEXTN"),
    /** Телеком */
    MOEXTL("MOEXTL"),
    /** Химия */
    MOEXCH("MOEXCH"),
    /** Инновации */
    MOEXINN("MOEXINN"),
    /** Голубые фишки */
    MOEXBC("MOEXBC");

    public String value;
    MmvbIndexes(final String value) {
        this.value = value;
    }
}

