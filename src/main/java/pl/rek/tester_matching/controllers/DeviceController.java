package pl.rek.tester_matching.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.rek.tester_matching.device.Device;
import pl.rek.tester_matching.services.DeviceService;

import java.util.List;

@RestController
@RequestMapping(path = "device")
public class DeviceController {

    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @GetMapping
    public List<Device> getAllDevice(){
        return deviceService.getAllDevice();
    }


}
