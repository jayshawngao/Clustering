package data;

import util.KmeanField;
/**
 * 
* @ClassName: Test3
* @Description: TODO(513�����ݣ�2�����ԣ�5���ؼ�������28������)
* @author Jayshawn
* @date 2016��5��20�� ����10:28:55
*
 */
public class Test3 {
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
	@Override
	public String toString() {
		return "Test3 [att1=" + att1 + ", att2=" + att2 + "]";
	}
	public Test3(double att1, double att2) {
		super();
		this.att1 = att1;
		this.att2 = att2;
	}
	public Test3() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
