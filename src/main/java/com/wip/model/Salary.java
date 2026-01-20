package com.wip.model;

public class Salary {
	int basic;
	double hra;
	double pf;
	double gross;
	double net;

	public Salary() {
		super();
		
	}

	public Salary(int basic, double hra, double pf, double gross, double net) {
		super();
		this.basic = basic;
		this.hra = hra;
		this.pf = pf;
		this.gross = gross;
		this.net = net;
	}

	public int getBasic() {
		return basic;
	}

	public void setBasic(int basic) {
		this.basic = basic;
	}

	public double getHra() {
		return hra;
	}

	public void setHra() {
		this.hra = basic * 0.1;
	}

	public double getPf() {
		return pf;
	}

	public void setPf() {
		this.pf = basic * 0.05;
	}

	public double getGross() {
		return gross;
	}

	public void setGross() {
		this.gross = basic + hra +pf;
	}

	public double getNet() {
		return net;
	}

	public void setNet() {
		this.net = gross - pf;
	}

	@Override
	public String toString() {
		return "Salary [basic=" + basic + ", hra=" + hra + ", pf=" + pf + ", gross=" + gross + ", net=" + net + "]";
	}

}
