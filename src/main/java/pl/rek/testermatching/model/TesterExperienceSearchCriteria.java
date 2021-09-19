package pl.rek.testermatching.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TesterExperienceSearchCriteria {
    private List<String> countries;
    private List<Long> deviceIds;

    public TesterExperienceSearchCriteria(List<String> countries, List<Long> deviceIds) {
        this.countries = (countries == null)? new ArrayList<>():countries;
        this.deviceIds = (deviceIds == null)? new ArrayList<>(): deviceIds;
    }
}
