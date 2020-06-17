package ru.levelup.covid19.finance.repository.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import ru.levelup.covid19.finance.jpa.FinanceHistoryEntity;
import ru.levelup.covid19.finance.jpa.PriceEntity;

@Mapper
@Service
public interface PriceRepoMyBatis {
    @Select("select * from price where price_id = #{priceId}")
    PriceEntity getPriceMyBatis(@Param("priceId") Integer priceId);

}
