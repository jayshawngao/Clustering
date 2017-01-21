package data;

import util.KmeanField;

/**
 * 
* @ClassName: Glass
* @Description: TODO(214个数据，9个属性,6个簇集)
* @author Jayshawn
* @date 2016年4月20日 下午2:39:39
*
 */
public class Glass {
	/**
	 * RI: refractive index
	 */
	@KmeanField
	private double att1;
	/**
	 * Na: Sodium (unit measurement: weight percent in corresponding oxide, as are attributes 4-10)
	 */
	@KmeanField
	private double att2;
	/**
	 * Mg: Magnesium
	 */
	@KmeanField
	private double att3;
	/**
	 * Al: Aluminum
	 */
	@KmeanField
	private double att4;
	/**
	 * Si: Silicon
	 */
	@KmeanField
	private double att5;
	/**
	 * K: Potassium
	 */
	@KmeanField
	private double att6;
	/**
	 * Ca: Calcium
	 */
	@KmeanField
	private double att7;
	/**
	 * Ba: Barium
	 */
	@KmeanField
	private double att8;
	/**
	 * Fe: Iron
	 */
	@KmeanField
	private double att9;
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
	public double getAtt5() {
		return att5;
	}
	public void setAtt5(double att5) {
		this.att5 = att5;
	}
	public double getAtt6() {
		return att6;
	}
	public void setAtt6(double att6) {
		this.att6 = att6;
	}
	public double getAtt7() {
		return att7;
	}
	public void setAtt7(double att7) {
		this.att7 = att7;
	}
	public double getAtt8() {
		return att8;
	}
	public void setAtt8(double att8) {
		this.att8 = att8;
	}
	public double getAtt9() {
		return att9;
	}
	public void setAtt9(double att9) {
		this.att9 = att9;
	}
	
	public Glass() {
		super();
	}
	public Glass(double att1, double att2, double att3, double att4, double att5, double att6, double att7, double att8,
			double att9) {
		super();
		this.att1 = att1;
		this.att2 = att2;
		this.att3 = att3;
		this.att4 = att4;
		this.att5 = att5;
		this.att6 = att6;
		this.att7 = att7;
		this.att8 = att8;
		this.att9 = att9;
	}
	@Override
	public String toString() {
		return "Glass [att1=" + att1 + ", att2=" + att2 + ", att3=" + att3 + ", att4=" + att4 + ", att5=" + att5
				+ ", att6=" + att6 + ", att7=" + att7 + ", att8=" + att8 + ", att9=" + att9 + "]";
	}

}
