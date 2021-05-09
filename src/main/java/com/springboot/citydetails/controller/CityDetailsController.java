package com.springboot.citydetails.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.citydetails.model.CityList;
import com.springboot.citydetails.service.DistrictService;

import io.swagger.annotations.ApiOperation;

//@CrossOrigin(origins = {"${app.api.settings.cross-origin.urls}"})

@RestController
@RequestMapping("/api")
public class CityDetailsController {
	
	private static final  Logger logger = LogManager.getLogger(CityDetailsController.class);	
	public static final String ERROR_OCCURED = "Error Occured";
	
	@Autowired
	DistrictService districtService;
	
	@ApiOperation(value = "Returns all the Districts name based on state")
	@GetMapping(value = "/citydetails/state/{state}")
	public ResponseEntity<List<Object[]>> findDistDetailsByState(@PathVariable String state) {

		List<Object[]> districtList = null;
		
		logger.info("CityDetails - CityDetailsController findDistDetailsByState:"+state);
		
		try {
			districtList = districtService.findDistDetailsByState(state);
		}
		
		catch (Exception exception) {
			logger.error("CityDetails-findDistDetailsByState() - Error");
			logger.error(exception.getMessage());			
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(districtList);		
	}
		
	
	@ApiOperation(value = "Returns all the State and Districts name based on town")
	@GetMapping(value = "/citydetails/city/{cityTown}")
	public ResponseEntity<List<CityList>> findStateDistDetailsByTown(@PathVariable String cityTown) {

		List<CityList> stateDistrictList = null;
		
		logger.info("CityDetails - CityDetailsController findStateDistDetailsByTown:"+cityTown);
		
		try {
			stateDistrictList = districtService.findStateDistDetailsByTown(cityTown);
		}
		
		catch (Exception exception) {
			logger.error("CityDetails-findStateDistDetailsByTown() - Error");
			logger.error(exception.getMessage());			
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(stateDistrictList);		
	}
	
	
	@ApiOperation(value = "Returns all the Town name based on District")
	@GetMapping(value = "/citydetails/district/{district}")
	public ResponseEntity<List<CityList>> findTownDetailsByDist(@PathVariable String district) {

		List<CityList> townList = null;
		
		logger.info("CityDetails - CityDetailsController findTownDetailsByDist:"+district);
		
		try {
			townList = districtService.findTownDetailsByDist(district);
		}
		
		catch (Exception exception) {
			logger.error("CityDetails-findTownDetailsByDist() - Error");
			logger.error(exception.getMessage());			
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(townList);		
	}
	
}
