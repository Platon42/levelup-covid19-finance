package ru.levelup.covid19.finance.repository.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.levelup.covid19.finance.jpa.FinanceHistoryEntity;

public interface HistoryRepoSpringData extends JpaRepository<FinanceHistoryEntity, Integer> {

}
