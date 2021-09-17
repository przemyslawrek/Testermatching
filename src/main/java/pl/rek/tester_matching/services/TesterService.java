package pl.rek.tester_matching.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rek.tester_matching.tester.ITesterExperience;
import pl.rek.tester_matching.tester.Tester;
import pl.rek.tester_matching.tester.TesterRepository;

import java.util.List;

@Service
public class TesterService {
    private final TesterRepository testerRepository;

    @Autowired
    public TesterService(TesterRepository testerRepository){
        this.testerRepository = testerRepository;
    }

    public List<Tester> getTesterByCountry(String country){
        return testerRepository.findAllByCountry(country);
    }

    public List<Tester> getAllTesters() {
        return testerRepository.findAll();
    }

    public List<ITesterExperience> getTestersExperience(List<String> countries, List<Long> deviceIds){
        if(countries.isEmpty() && deviceIds.isEmpty()){
            return testerRepository.findAllOrderByBugs();
        }

        if(countries.isEmpty()){
            return testerRepository.findAllByDevicesInOrderByBugs(deviceIds);
        }

        if(deviceIds.isEmpty()){
            return testerRepository.findAllByCountryInOrderByBugs(countries);
        }
        return testerRepository.findAllByCountryInAndDevicesInOrderByBugs(countries, deviceIds);
        }

    public List<String> getCountryList() {
        return testerRepository.findDistinctCountry();
    }
}
