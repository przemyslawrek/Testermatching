package pl.rek.tester_matching.bug;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.rek.tester_matching.device.Device;
import pl.rek.tester_matching.tester.Tester;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Bug {
    @Id
    @Column(name = "bugId")
    private Long bugId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="deviceId")
    @JsonManagedReference
    private Device device;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="testerId")
    @JsonManagedReference
    private Tester tester;


}
