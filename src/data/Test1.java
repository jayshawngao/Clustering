package data;

import util.KmeanField;

/**
 * 
* @ClassName: Test1
* @Description: TODO(335个数据，2个属性，5个簇集)
* @author Jayshawn
* @date 2016年5月18日 下午2:29:02
*
 */
public class Test1 {
	@KmeanField
	private double att1;
	@KmeanField
	private double att2;
	public double getAtt1() {
		return att1;
	}
	public void setAtt1(double att1) {
		this.att1 = att1;
	}
	public double getAtt2() {
		return att2;
	}
	public void setAtt2(double att2) {
		this.att2 = att2;
	}
	public Test1(double att1, double att2) {
		super();
		this.att1 = att1;
		this.att2 = att2;
	}
	public Test1() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Test1 [att1=" + att1 + ", att2=" + att2 + "]";
	}
	

}
