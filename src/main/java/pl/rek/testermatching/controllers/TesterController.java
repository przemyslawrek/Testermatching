package pl.rek.testermatching.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.rek.testermatching.model.TesterExperienceSearchCriteria;
import pl.rek.testermatching.services.TesterService;
import pl.rek.testermatching.db.tester.TesterExperience;
import pl.rek.testermatching.db.tester.Tester;

import java.util.List;

@RestController
@RequestMapping(path = "testers")
@RequiredArgsConstructor
public class TesterController {

    private final TesterService testerService;

    @GetMapping(path = "country/{country}")
    public List<Tester> getTesterByCountry(@PathVariable("country") String country) {
        return testerService.getTesterByCountry(country);
    }

    @GetMapping(path = "countryList")
    public List<String> getCountryList() {
        return testerService.getCountryList();
    }

    @GetMapping
    public List<Tester> getTesters() {
        return testerService.getAllTesters();
    }

    @GetMapping(path = "experience")
    public List<TesterExperience> getTesterExperience(@RequestParam("countries") List<String> countries, @RequestParam("deviceIds") List<Long> deviceIds) {
        return testerService.getTestersExperience(countries, deviceIds);
    }

    @PostMapping(path = "experience")
    public List<TesterExperience> getTesterExperienceByCriteria(@RequestBody TesterExperienceSearchCriteria criteria) {
        return testerService.getTestersExperience(criteria.getCountries(), criteria.getDeviceIds());
    }

}
