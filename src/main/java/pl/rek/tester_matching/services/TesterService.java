package pl.rek.tester_matching.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rek.tester_matching.db.tester.TesterExperience;
import pl.rek.tester_matching.db.tester.Tester;
import pl.rek.tester_matching.db.tester.TesterRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TesterService {
    private final TesterRepository testerRepository;

    public List<Tester> getTesterByCountry(String country) {
        return testerRepository.findAllByCountry(country);
    }

    public List<Tester> getAllTesters() {
        return testerRepository.findAll();
    }

    public List<TesterExperience> getTestersExperience(List<String> countries, List<Long> deviceIds) {
        if (countries.isEmpty() && deviceIds.isEmpty()) {
            return testerRepository.findAllOrderByBugs();
        }

        if (countries.isEmpty()) {
            return testerRepository.findAllByDevicesInOrderByBugs(deviceIds);
        }

        if (deviceIds.isEmpty()) {
            return testerRepository.findAllByCountryInOrderByBugs(countries);
        }
        return testerRepository.findAllByCountryInAndDevicesInOrderByBugs(countries, deviceIds);
    }

    public List<String> getCountryList() {
        return testerRepository.findDistinctCountry();
    }
}
