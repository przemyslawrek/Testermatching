package pl.rek.tester_matching.db.bug;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.rek.tester_matching.db.device.Device;
import pl.rek.tester_matching.db.tester.Tester;

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
