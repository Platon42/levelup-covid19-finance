package ru.levelup.covid19.finance.dto.yahoo.market;

public enum CompanySymbol {
    /* Индексы ММВБ
    MOEXMM - металлы
    MOEXFN - финансы
    MOEXOG - нефть и газ
    MOEXCN - потребительский сектор
    MOEXEU - электроэнергия
    MOEXTN - транспорт
    MOEXTL - телеком
    MOEXCH - химия
    MOEXINN - инновации
    MOEXBC - голубые фишки */

    /* Тикеры Yahoo Finance */
    // Газпром
    OGZPY("OGZPY"),
    GAZ_DE("GAZ.DE"),
    GAZP_ME("GAZP.ME"),

    // Лукойл
    LUKOY("LUKOY"),
    LUK_DE("LUK.DE"),
    LKOH_ME("LKOH.ME"),

    // Мегафон
    MFOYY("MFOYY"),

    // МТС
    MBT("MBT"),
    MKY_F("MKY.F"),
    MTSS_ME("MTSS.ME"),

    // Новатек
    NOVKY("NOVKY"),
    NVTK_ME("NVTK.ME"),

    // Норильский никель
    NILSY("NILSY"),
    NNIC_DE("NNIC.DE"),
    GMKN_ME("GMKN.ME"),

    // Роснефть
    RNFTF("RNFTF"),
    OJSCY("OJSCY"),
    ROSN_ME("ROSN.ME"),

    // Сбербанк
    SBRCY("SBRCY"),
    SBNC_DE("SBNC.DE"),
    SBER_ME("SBER.ME"),

    // Сургутнефтегаз
    SGTZY("SGTZY"),
    SGN_F("SGN.F"),
    SNGS_ME("SNGS.ME"),

    // Яндекс
    YNDX("YNDX"),
    YDX_F("YDX.F"),
    YNDX_ME("YNDX.ME");

    public String value;
    CompanySymbol(final String value) {
        this.value = value;
    }
}
