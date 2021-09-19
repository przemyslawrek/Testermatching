package pl.rek.testermatching.db.tester;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.rek.testermatching.db.bug.Bug;
import pl.rek.testermatching.db.device.Device;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name="Tester")
@NoArgsConstructor
@AllArgsConstructor
public class Tester {
    @Id
    private Long testerId;

    @ManyToMany(mappedBy = "testers")
    @JsonIgnore
    private Set<Device> devices;

    @OneToMany(mappedBy = "tester")
    @JsonBackReference
    private Set<Bug> bugs;


    private String firstName;

    private String lastName;

    private String country;

    private Date lastLogin;

}
