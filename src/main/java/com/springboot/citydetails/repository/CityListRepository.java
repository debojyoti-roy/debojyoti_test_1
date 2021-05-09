package com.springboot.citydetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.citydetails.model.CityList;



public interface CityListRepository extends JpaRepository<CityList, Integer> {
	

	public static final String distDetailsQuery = "SELECT a.state, a.District_Code, a.district FROM CityList a WHERE a.state=:state";
	public static final String stateDistDetailsQuery = "SELECT new com.springboot.citydetails.model.CityList(a.state, a.District_Code, a.district) FROM CityList a WHERE a.cityTown=:cityTown";
	
	@Query(value=distDetailsQuery)	
	List<Object[]> findDistDetailsByState(@Param("state") String state) throws Exception;

	@Query(value=stateDistDetailsQuery, nativeQuery = false)
	List<CityList> findStateDistDetailsByCityTown(@Param("cityTown") String ctyTwn1);

	List<CityList> findTownDetailsByDistrict(final String district);	 

}