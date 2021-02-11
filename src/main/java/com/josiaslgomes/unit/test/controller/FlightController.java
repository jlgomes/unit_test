package com.josiaslgomes.unit.test.controller;

import com.josiaslgomes.unit.test.model.Flight;
import com.josiaslgomes.unit.test.repository.FlightRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.josiaslgomes.unit.test.constant.Paths.FLIGHT;
import static com.josiaslgomes.unit.test.constant.Paths.VERSION;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RestController
@RequestMapping(value = VERSION + FLIGHT)
@Api(value = VERSION + FLIGHT)
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @ApiOperation(value = "Get all flights")
    @RequestMapping(value = "all", method = GET)
    @ResponseBody
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @ApiOperation(value = "Get flights by ID")
    @RequestMapping(value = "{id}", method = GET)
    @ResponseBody
    public Flight getFlightById(@PathVariable(value = "id") int id) {
        return flightRepository.findAllById(id);
    }
}
