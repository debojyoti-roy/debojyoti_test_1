package com.springboot.citydetails.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city_list")
public class CityList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Sl_No")
	private Integer slNo;
	
	@Column(name = "City_Town")
	private String cityTown;

	@Column(name = "Urban_Status")
	private String urbanStatus;
	
	@Column(name = "State_Code")
	private Integer stateCode;
	
	@Column(name = "State")
	private String state;
	
	@Column(name = "District_Code")
	private Integer District_Code;
	
	@Column(name = "District")
	private String district;
	
	public CityList(String state, Integer District_Code, String district)
	{
		this.state = state;
		this.District_Code = District_Code;
		this.district = district;
	}	

	public Integer getSlNo() {
		return slNo;
	}

	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}

	public String getCityTown() {
		return cityTown;
	}

	public void setCityTown(String cityTown) {
		this.cityTown = cityTown;
	}

	public String getUrbanStatus() {
		return urbanStatus;
	}

	public void setUrbanStatus(String urbanStatus) {
		this.urbanStatus = urbanStatus;
	}

	public Integer getStateCode() {
		return stateCode;
	}

	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getDistrict_Code() {
		return District_Code;
	}

	public void setDistrict_Code(Integer district_Code) {
		District_Code = district_Code;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "CityList [slNo=" + slNo + ", cityTown=" + cityTown + ", stateCode=" + stateCode + ", state=" + state
				+ ", District_Code=" + District_Code + ", district=" + district + "]";
	}	

}
