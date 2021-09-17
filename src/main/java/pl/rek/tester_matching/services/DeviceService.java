package pl.rek.tester_matching.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rek.tester_matching.device.Device;
import pl.rek.tester_matching.device.DeviceRepository;

import java.util.List;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository){
        this.deviceRepository = deviceRepository;
    }

    public List<Device> getAllDevice() {
        return deviceRepository.findAll();
    }

}
