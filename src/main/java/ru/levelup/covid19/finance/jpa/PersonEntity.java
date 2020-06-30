package ru.levelup.covid19.finance.jpa;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "person", schema = "public", catalog = "covid")
public class PersonEntity {
    private int personId;
    private String name;
    private Integer yearBorn;
    private Integer age;
    private String title;
    private CompanyEntity companyByCompanyId;

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "year_born")
    public Integer getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(Integer yearBorn) {
        this.yearBorn = yearBorn;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEntity that = (PersonEntity) o;
        return personId == that.personId &&
                Objects.equals(name, that.name) &&
                Objects.equals(yearBorn, that.yearBorn) &&
                Objects.equals(age, that.age) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, name, yearBorn, age, title);
    }

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    public CompanyEntity getCompanyByCompanyId() {
        return companyByCompanyId;
    }

    public void setCompanyByCompanyId(CompanyEntity companyByCompanyId) {
        this.companyByCompanyId = companyByCompanyId;
    }
}
