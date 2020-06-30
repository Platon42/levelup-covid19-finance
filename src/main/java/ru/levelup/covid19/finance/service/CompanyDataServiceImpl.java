package ru.levelup.covid19.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levelup.covid19.finance.dto.yahoo.market.CompanySymbol;
import ru.levelup.covid19.finance.dto.yahoo.stock.profile.AssetProfile;
import ru.levelup.covid19.finance.dto.yahoo.stock.profile.CompanyOfficer;
import ru.levelup.covid19.finance.dto.yahoo.stock.profile.CompanyProfileProvider;
import ru.levelup.covid19.finance.jpa.CompanyEntity;
import ru.levelup.covid19.finance.jpa.PersonEntity;
import ru.levelup.covid19.finance.repository.hibernate.CompanyRepoSpringData;
import ru.levelup.covid19.finance.repository.hibernate.PersonRepoSpringData;

import java.util.List;

@Service
public class CompanyDataServiceImpl implements CompanyDataService {
    @Autowired
    private CompanyRepoSpringData companyRepoSpringData;
    @Autowired
    private PersonRepoSpringData personRepoSpringData;

    public void saveCompanySpringData(CompanyProfileProvider companyProfileProvider) {
        if (companyProfileProvider == null || !companyProfileProvider.getError().isEmpty())
            return;

        CompanyEntity companyEntity = new CompanyEntity();
        AssetProfile profile = companyProfileProvider.getAssetProfile();
        companyEntity.setSymbol(companyProfileProvider.getSymbol());
        companyEntity.setName(companyProfileProvider.getPrice().getLongName());
        companyEntity.setCountry(profile.getCountry());
        companyEntity.setCity(profile.getCity());
        companyEntity.setAddress(profile.getAddress1());
        companyEntity.setPhone(profile.getPhone());
        companyEntity.setWebsite(profile.getWebsite().toString());
        companyEntity.setSector(profile.getSector());
        companyEntity.setDescription(profile.getLongBusinessSummary());
        companyRepoSpringData.save(companyEntity);

        List<CompanyOfficer> persons = profile.getCompanyOfficers();
        if (persons != null) {
            persons.forEach(person -> {
                PersonEntity personEntity = new PersonEntity();
                personEntity.setName(person.getName());
                personEntity.setYearBorn(person.getYearborn());
                personEntity.setAge(person.getAge());
                personEntity.setTitle(person.getTitle());
                personEntity.setCompanyByCompanyId(companyEntity);
                personRepoSpringData.save(personEntity);
            });
        }
    }

    public String getCompanySector(CompanySymbol companySymbol) {
        return companyRepoSpringData.findBySymbol(companySymbol.value).getSector();
    }
}
