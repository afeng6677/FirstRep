package com.PrjFrame.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "s_role")
public class SRole {
	@Id
	@GeneratedValue
	@Column(name = "P_Guid")
	private Integer pGuid;
	@Column(name = "D_RoleName")
	private String dRolename;
	@Column(name = "D_Desc")
	private String dDesc;
	@Column(name = "D_Summary")
	private String dSummary;
	public void setPGuid(Integer pGuid){
		this.pGuid=pGuid;
	}
	public Integer getPGuid(){
		return pGuid;
	}
	public void setDRolename(String dRolename){
		this.dRolename=dRolename;
	}
	public String getDRolename(){
		return dRolename;
	}
	public void setDDesc(String dDesc){
		this.dDesc=dDesc;
	}
	public String getDDesc(){
		return dDesc;
	}
	public void setDSummary(String dSummary){
		this.dSummary=dSummary;
	}
	public String getDSummary(){
		return dSummary;
	}
}

