package edu.mondragon.riskFit.Controller;

import edu.mondragon.riskFit.Model.RealTimeDataRequest;
import edu.mondragon.riskFit.Service.RealTimeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/realTimeData")
public class RealTimeDataController {

    @Autowired
    private RealTimeDataService realTimeDataService;

    @PostMapping
    public ResponseEntity<String> receiveRealTimeData(@RequestBody RealTimeDataRequest request) {
        realTimeDataService.processRealTimeData(request);
        return ResponseEntity.ok("Real-time data received successfully!");
    }
}
