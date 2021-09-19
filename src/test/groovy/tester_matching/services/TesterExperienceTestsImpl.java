package tester_matching.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.rek.testermatching.db.tester.TesterExperience;


@Data
@AllArgsConstructor
public class TesterExperienceTestsImpl implements TesterExperience {
    private String firstName;
    private String lastName;
    private Integer experience;
}
