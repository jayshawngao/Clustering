package data;

import util.KmeanField;
/**
 * 
* @ClassName: Iris
* @Description: TODO(150�����ݣ�4�����ԣ�3���ؼ��������������ؼ������ص�)
* @author Jayshawn
* @date 2016��4��15�� ����2:36:07
*
 */
public class Iris {
	@KmeanField
	private double att1;
	@KmeanField
	private double att2;
	@KmeanField
	private double att3;
	@KmeanField
	private double att4;
	
	
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
	public double getAtt3() {
		return att3;
	}
	public void setAtt3(double att3) {
		this.att3 = att3;
	}
	public double getAtt4() {
		return att4;
	}
	public void setAtt4(double att4) {
		this.att4 = att4;
	}
	public Iris(double att1, double att2, double att3, double att4) {
		super();
		this.att1 = att1;
		this.att2 = att2;
		this.att3 = att3;
		this.att4 = att4;
	}
	public Iris() {
		super();
	}
	@Override
	public String toString() {
		return "Iris [att1=" + att1 + ", att2=" + att2 + ", att3=" + att3 + ", att4=" + att4 + "]";
	}
	
}
