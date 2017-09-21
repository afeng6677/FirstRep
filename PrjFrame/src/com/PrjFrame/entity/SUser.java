package com.PrjFrame.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Table(name = "s_user")
public class SUser {
	@Id
	@GeneratedValue
	@Column(name = "P_Guid")
	private Integer pGuid;
	@Column(name = "AF_Pid")
	private Integer afPid;
	@Column(name = "D_UserName")
	private String dUsername;
	@Column(name = "D_FullName")
	private String dFullname;
	@Column(name = "D_Password")
	private String dPassword;
	@Column(name = "D_Mail")
	private String dMail;
	@Column(name = "D_Mobil")
	private String dMobil;

	@Column(name = "D_PhoneInLine")
	private String dPhoneinline;
	@Column(name = "D_Address")
	private String dAddress;
	@Column(name = "D_PostCode")
	private String dPostcode;
	@Column(name = "D_Duty")
	private String dDuty;
	@Column(name = "D_Status")
	private Integer dStatus;
	@Column(name = "D_Sex")
	private String dSex;
	@Column(name = "D_Birthday")
	private String dBirthday;
	@Column(name = "D_Card")
	private String dCard;
	@Column(name = "D_CreateTime")
	private String dCreatetime;
	@Column(name = "D_Type")
	private Integer dType;
	@Column(name = "D_PwdUpdateTime")
	private String dPwdupdatetime;// 密码更新日期(yyyy-MM-dd)
	@Transient
	private List<SRole> sroleList = new ArrayList<SRole>();
	@Transient
	private Map<String,SMenu> smenuMap = new HashMap<String,SMenu>();
	@Transient
	private String smenuStr = new String();
	@Transient
	private Map<String,SMenu> isNosmenuMap = new HashMap<String,SMenu>();
	@Transient
	private List<String> authorityList = new ArrayList<String>();
	
	@Transient
	private String afPidText;
	
	public String getSmenuStr() {
		return smenuStr;
	}
	public void setSmenuStr(String smenuStr) {
		this.smenuStr = smenuStr;
	}
	public String getAfPidText() {
		return afPidText;
	}
	public void setAfPidText(String afPidText) {
		this.afPidText = afPidText;
	}
	public List<String> getAuthorityList() {
		return authorityList;
	}
	public void setAuthorityList(List<String> authorityList) {
		this.authorityList = authorityList;
	}
	
	public Map<String, SMenu> getIsNosmenuMap() {
		return isNosmenuMap;
	}
	public void setIsNosmenuMap(Map<String, SMenu> isNosmenuMap) {
		this.isNosmenuMap = isNosmenuMap;
	}
	public Map<String, SMenu> getSmenuMap() {
		return smenuMap;
	}
	public void setSmenuMap(Map<String, SMenu> smenuMap) {
		this.smenuMap = smenuMap;
	}
	public List<SRole> getSroleList() {
		return sroleList;
	}
	public void setSroleList(List<SRole> sroleList) {
		this.sroleList = sroleList;
	}
	public void setPGuid(Integer pGuid){
		this.pGuid=pGuid;
	}
	public Integer getPGuid(){
		return pGuid;
	}
	public void setAfPid(Integer afPid){
		this.afPid=afPid;
	}
	public Integer getAfPid(){
		return afPid;
	}
	public void setDUsername(String dUsername){
		this.dUsername=dUsername;
	}
	public String getDUsername(){
		return dUsername;
	}
	public void setDFullname(String dFullname){
		this.dFullname=dFullname;
	}
	public String getDFullname(){
		return dFullname;
	}
	public void setDPassword(String dPassword){
		this.dPassword=dPassword;
	}
	public String getDPassword(){
		return dPassword;
	}
	public void setDMail(String dMail){
		this.dMail=dMail;
	}
	public String getDMail(){
		return dMail;
	}
	public void setDMobil(String dMobil){
		this.dMobil=dMobil;
	}
	public String getDMobil(){
		return dMobil;
	}
	public void setDPhoneinline(String dPhoneinline){
		this.dPhoneinline=dPhoneinline;
	}
	public String getDPhoneinline(){
		return dPhoneinline;
	}
	public void setDAddress(String dAddress){
		this.dAddress=dAddress;
	}
	public String getDAddress(){
		return dAddress;
	}
	public void setDPostcode(String dPostcode){
		this.dPostcode=dPostcode;
	}
	public String getDPostcode(){
		return dPostcode;
	}
	public void setDDuty(String dDuty){
		this.dDuty=dDuty;
	}
	public String getDDuty(){
		return dDuty;
	}
	public void setDStatus(Integer dStatus){
		this.dStatus=dStatus;
	}
	public Integer getDStatus(){
		return dStatus;
	}
	public void setDSex(String dSex){
		this.dSex=dSex;
	}
	public String getDSex(){
		return dSex;
	}
	public void setDBirthday(String dBirthday){
		this.dBirthday=dBirthday;
	}
	public String getDBirthday(){
		return dBirthday;
	}
	public void setDCard(String dCard){
		this.dCard=dCard;
	}
	public String getDCard(){
		return dCard;
	}
	public void setDCreatetime(String dCreatetime){
		this.dCreatetime=dCreatetime;
	}
	public String getDCreatetime(){
		return dCreatetime;
	}
	public void setDType(Integer dType){
		this.dType=dType;
	}
	public Integer getDType(){
		return dType;
	}
	public String getdPwdupdatetime() {
		return dPwdupdatetime;
	}
	public void setdPwdupdatetime(String dPwdupdatetime) {
		this.dPwdupdatetime = dPwdupdatetime;
	}
	
}

