package pl.rek.testermatching.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.rek.testermatching.db.device.Device;
import pl.rek.testermatching.services.DeviceService;

import java.util.List;

@RestController
@RequestMapping(path = "device")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @GetMapping
    public List<Device> getAllDevice(){
        return deviceService.getAllDevice();
    }


}
