package pl.rek.tester_matching.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TesterExperienceSearchCriteria {
    List<String> countries;
    List<Long> deviceIds;

    public TesterExperienceSearchCriteria(List<String> countries, List<Long> deviceIds) {
        this.countries = (countries == null)? new ArrayList<>():countries;
        this.deviceIds = (deviceIds == null)? new ArrayList<>(): deviceIds;
    }
}
