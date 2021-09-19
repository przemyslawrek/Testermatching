package pl.rek.tester_matching.db.device;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.rek.tester_matching.db.bug.Bug;
import pl.rek.tester_matching.db.tester.Tester;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Device {
    @Id
    private Long deviceId;

    @OneToMany(mappedBy = "device", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Bug> bugs;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(
            name = "tester_device",
            joinColumns = @JoinColumn(name="device_Id"),
            inverseJoinColumns = @JoinColumn(name = "tester_Id")
    )
    private Set<Tester> testers;

    private String description;



}
