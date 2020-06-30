package ru.levelup.covid19.finance.repository.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levelup.covid19.finance.jpa.PersonEntity;

public interface PersonRepoSpringData extends JpaRepository<PersonEntity, Integer> {
}
