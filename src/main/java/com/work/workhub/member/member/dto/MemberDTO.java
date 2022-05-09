package com.work.workhub.member.member.dto;

import com.work.workhub.admin.workgroup.model.dto.WorkGroupDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
   
   private int no;
   private String id;
   private String pwd;
   private int depNo;
   private int positionNo;
   private int groupNo;
   private String name;
   private String email;
   private String phone;
   private String status;
   
   private DepartmentDTO dept;
   private PositionDTO position;
   private WorkGroupDTO workGroup;
   
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	@Override
	public String toString() {
		return "MemberDTO [no=" + no + ", id=" + id + ", pwd=" + pwd + ", depNo=" + depNo + ", positionNo=" + positionNo
				+ ", groupNo=" + groupNo + ", name=" + name + ", email=" + email + ", phone=" + phone + ", status=" + status
				+ ", dept=" + dept + ", position=" + position + ", workGroup=" + workGroup + ", hashCode()=" + hashCode()
				+ ", getNo()=" + getNo() + ", getId()=" + getId() + ", getPwd()=" + getPwd() + ", getDepNo()=" + getDepNo()
				+ ", getPositionNo()=" + getPositionNo() + ", getGroupNo()=" + getGroupNo() + ", getName()=" + getName()
				+ ", getEmail()=" + getEmail() + ", getPhone()=" + getPhone() + ", getStatus()=" + getStatus()
				+ ", getDept()=" + getDept() + ", getPosition()=" + getPosition() + ", getWorkGroup()=" + getWorkGroup()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getDepNo() {
		return depNo;
	}
	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}
	public int getPositionNo() {
		return positionNo;
	}
	public void setPositionNo(int positionNo) {
		this.positionNo = positionNo;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public DepartmentDTO getDept() {
		return dept;
	}
	public void setDept(DepartmentDTO dept) {
		this.dept = dept;
	}
	public PositionDTO getPosition() {
		return position;
	}
	public void setPosition(PositionDTO position) {
		this.position = position;
	}
	public WorkGroupDTO getWorkGroup() {
		return workGroup;
	}
	public void setWorkGroup(WorkGroupDTO workGroup) {
		this.workGroup = workGroup;
	}

}