package pl.rek.tester_matching.tester;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.rek.tester_matching.bug.Bug;
import pl.rek.tester_matching.device.Device;

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
