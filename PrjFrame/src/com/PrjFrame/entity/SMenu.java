package com.PrjFrame.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "s_menu")
public class SMenu {
	@Id
	@GeneratedValue
	@Column(name = "P_Guid")
	private Integer pGuid;
	@Column(name = "D_Name")
	private String dName;
	@Column(name = "D_Authority")
	private String dAuthority;
	@Column(name = "D_Type")
	private Integer dType;
	@Column(name = "D_Status")
	private Integer dStatus;
	@Column(name = "D_Url")
	private String dUrl;
	@Column(name = "D_Icon")
	private String dIcon;
	@Column(name = "D_Des")
	private String dDes;
	@Column(name = "F_ParentId")
	private Integer fParentid;
	@Column(name = "D_Sort")
	private Integer dSort;
	@Column(name = "D_CreateTime")
	private String dCreatetime;
	@Column(name = "D_Blank")
	private Integer dBlank; //菜单显示状态（打开新标签、原页面打开）
	@Column(name = "D_ViewType")
	private Integer dViewtype;//菜单显示方式
	@Column(name = "D_Size")
	private String dSize;//菜单显示大小
	@Column(name = "D_Style")
	private String dStyle;//菜单样式
	
	
	
	public String getDStyle() {
		return dStyle;
	}
	public void setDStyle(String dStyle) {
		this.dStyle = dStyle;
	}
	private boolean isShow;
	
	private boolean isUsable;
	
	public List<String> buttons = new ArrayList<String>();
	
	public Integer getDViewtype() {
		return dViewtype;
	}
	public void setDViewtype(Integer dViewtype) {
		this.dViewtype = dViewtype;
	}
	public String getDSize() {
		return dSize;
	}
	public void setDSize(String dSize) {
		this.dSize = dSize;
	}
	public Integer getDBlank() {
		return dBlank;
	}
	public void setDBlank(Integer dBlank) {
		this.dBlank = dBlank;
	}
	@Transient
	public List<String> getButtons() {
		return buttons;
	}
	public void setButtons(List<String> buttons) {
		this.buttons = buttons;
	}
	@Transient
	public boolean isShow() {
		return isShow;
	}
	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}
	@Transient
	public boolean isUsable() {
		return isUsable;
	}
	public void setUsable(boolean isUsable) {
		this.isUsable = isUsable;
	}
	public void setPGuid(Integer pGuid){
		this.pGuid=pGuid;
	}
	public Integer getPGuid(){
		return pGuid;
	}
	public void setDName(String dName){
		this.dName=dName;
	}
	public String getDName(){
		return dName;
	}
	public String getdAuthority() {
		return dAuthority;
	}
	public void setdAuthority(String dAuthority) {
		this.dAuthority = dAuthority;
	}
	public void setDType(Integer dType){
		this.dType=dType;
	}
	public Integer getDType(){
		return dType;
	}
	public void setDStatus(Integer dStatus){
		this.dStatus=dStatus;
	}
	public Integer getDStatus(){
		return dStatus;
	}
	public void setDUrl(String dUrl){
		this.dUrl=dUrl;
	}
	public String getDUrl(){
		return dUrl;
	}
	public void setDIcon(String dIcon){
		this.dIcon=dIcon;
	}
	public String getDIcon(){
		return dIcon;
	}
	public void setDDes(String dDes){
		this.dDes=dDes;
	}
	public String getDDes(){
		return dDes;
	}
	public void setFParentid(Integer fParentid){
		this.fParentid=fParentid;
	}
	public Integer getFParentid(){
		return fParentid;
	}
	public void setDSort(Integer dSort){
		this.dSort=dSort;
	}
	public Integer getDSort(){
		return dSort;
	}
	public void setDCreatetime(String dCreatetime){
		this.dCreatetime=dCreatetime;
	}
	public String getDCreatetime(){
		return dCreatetime;
	}
}

