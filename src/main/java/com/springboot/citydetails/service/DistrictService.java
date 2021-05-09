package com.springboot.citydetails.service;

import java.util.List;

import com.springboot.citydetails.model.CityList;

public interface DistrictService {

	public List<Object[]> findDistDetailsByState(final String state) throws Exception;

	public List<CityList> findStateDistDetailsByTown(final String cityTown);

	public List<CityList> findTownDetailsByDist(final String district);

}
