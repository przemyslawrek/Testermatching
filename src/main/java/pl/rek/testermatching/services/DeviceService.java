package pl.rek.testermatching.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rek.testermatching.db.device.Device;
import pl.rek.testermatching.db.device.DeviceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;


    public List<Device> getAllDevice() {
        return deviceRepository.findAll();
    }

}
