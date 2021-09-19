package pl.rek.testermatching.db.bug;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.rek.testermatching.db.device.Device;
import pl.rek.testermatching.db.tester.Tester;

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
