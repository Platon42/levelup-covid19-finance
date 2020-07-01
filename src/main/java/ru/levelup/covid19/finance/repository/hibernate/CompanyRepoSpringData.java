package ru.levelup.covid19.finance.repository.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.levelup.covid19.finance.jpa.CompanyEntity;

@Repository
public interface CompanyRepoSpringData extends JpaRepository<CompanyEntity, Integer> {
    CompanyEntity findBySymbol(String symbol);
}
