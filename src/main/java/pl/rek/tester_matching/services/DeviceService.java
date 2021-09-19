package pl.rek.tester_matching.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rek.tester_matching.db.device.Device;
import pl.rek.tester_matching.db.device.DeviceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;


    public List<Device> getAllDevice() {
        return deviceRepository.findAll();
    }

}
