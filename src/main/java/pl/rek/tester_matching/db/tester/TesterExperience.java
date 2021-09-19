package pl.rek.tester_matching.db.tester;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TesterExperience {
    String firstName;
    String lastName;
    Integer experience;
}
