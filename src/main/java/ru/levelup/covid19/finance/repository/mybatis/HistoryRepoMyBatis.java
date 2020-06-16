package ru.levelup.covid19.finance.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import ru.levelup.covid19.finance.jpa.FinanceHistoryEntity;

@Mapper
@Service
public interface HistoryRepoMyBatis {
    @Select("select * from finance_history where finance_history_id = #{financeHistoryId}")
    FinanceHistoryEntity getFinanceHistoryMyBatis(@Param("financeHistoryId") Integer financeHistoryId);
}
