dto- employee

package com.freeflux.dto;

public class Employee {

	private int empNo = 0; // ��� ������ȣ
	private String empName = ""; // ����̸�
	private String job = ""; // ����
	private String mgr = ""; // ���޹�ȣ
	private String hireDate = ""; // �Ի���
	private int sale = 0; // �޿�
	private int commission = 0; // ������
	private int deptNo = 0; // �μ���ȣ

	public Employee() { // �⺻ ������
	}
	
	/** Overloading ������ **/
	public Employee(int empNo, String empName, String job, String mgr, String hireDate, int sale, int commission, int deptNo) {
		this.empNo=empNo;
		this.empName=empName;
		this.job=job;
		this.mgr=mgr;
		this.hireDate=hireDate;
		this.sale=sale;
		this.commission=commission;
		this.deptNo=deptNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMgr() {
		return mgr;
	}

	public void setMgr(String mgr) {
		this.mgr = mgr;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", job=" + job + ", mgr=" + mgr + ", hireDate="
				+ hireDate + ", sale=" + sale + ", commission=" + commission + ", deptNo=" + deptNo + "]";
	}

	
}
