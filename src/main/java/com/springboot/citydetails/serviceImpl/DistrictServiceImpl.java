package com.springboot.citydetails.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.citydetails.model.CityList;
import com.springboot.citydetails.repository.CityListRepository;
import com.springboot.citydetails.service.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService {
	
	private static final Logger logger = LogManager.getLogger(DistrictServiceImpl.class);
	
	@Autowired
	CityListRepository cityListRepository;

	@Override
	public List<Object[]> findDistDetailsByState(String state) throws Exception {		
		
		logger.info("citydetails-DistrictServiceImpl class - findDistDetailsByState() - for DistrictDetails" + state);

		List<Object[]> districtList = new ArrayList<>();
		
		districtList = cityListRepository.findDistDetailsByState(state);
		
		System.out.println("districtList" +districtList);

		return districtList;
	}

	@Override
	public List<CityList> findStateDistDetailsByTown(String cityTown) {
		
		logger.info("citydetails-DistrictServiceImpl class - findStateDistDetailsByTown() - for StateDistrictDetails" + cityTown);

		List<CityList> stateDistrictList = new ArrayList<>();
		
		stateDistrictList = cityListRepository.findStateDistDetailsByCityTown(cityTown);					

		return stateDistrictList;
	}

	@Override
	public List<CityList> findTownDetailsByDist(String district) {
		
		logger.info("citydetails-DistrictServiceImpl class - findTownDetailsByDist() - for TownDetails" + district);

		List<CityList> townList = new ArrayList<>();
		
		townList = cityListRepository.findTownDetailsByDistrict(district);					

		return townList;		
	}

}
