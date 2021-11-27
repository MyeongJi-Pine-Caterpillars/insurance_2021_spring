package com.insurance.sce.model.insurance;

import com.insurance.sce.model.customer.Insurant;

public class FireInsurance extends Insurance {

	// Attributes
	private double[] rateOfPostedPrice = {0.9, 1.0, 1.1, 1.2, 1.3}; // index[0: ~5泥쒕쭔�썝/ 1: ~5�뼲/ 2: ~10�뼲/ 3: ~20�뼲/ 4: 洹� �씠�긽]
	private double[] rateOfStructureUsage = {1.0, 0.9, 1.2, 1.2, 1.1, 1.1}; // index[0: 二쇳깮/ 1: 援먯쑁/ 2: 怨듭옣/ 3: 李쎄퀬/ 4: �궗臾�/ 5: 怨듦났�떆�꽕]

	// Constructor
	public FireInsurance(){
	}

	// getters & setters
	public double[] getRateOfPostedPrice() {return rateOfPostedPrice;}
	public void setRateOfPostedPrice(double[] rateOfPostedPrice) {this.rateOfPostedPrice = rateOfPostedPrice;}

	public double[] getRateOfStructureUsage() {return rateOfStructureUsage;}
	public void setRateOfStructureUsage(double[] rateOfStructureUsage) {this.rateOfStructureUsage = rateOfStructureUsage;}
		
	// Methods
	public int calculateFee(Insurant insurant){
		double fee = this.getBasicFee();
		// �옱�궛 洹쒕え�뿉 �뵲瑜� �슂�쑉 怨꾩궛
		if (insurant.getPostedPriceOfStructure() > 0 && insurant.getPostedPriceOfStructure() <= 50000000) {
			fee *= this.getRateOfPostedPrice()[0];
		} else if (insurant.getPostedPriceOfStructure() > 50000000 && insurant.getPostedPriceOfStructure() <= 500000000) {
			fee *= this.getRateOfPostedPrice()[1];
		} else if (insurant.getPostedPriceOfStructure() > 500000000 && insurant.getPostedPriceOfStructure() <= 1000000000) {
			fee *= this.getRateOfPostedPrice()[2];
		} else if (insurant.getPostedPriceOfStructure() > 1000000000 && insurant.getPostedPriceOfStructure() <= 2000000000) {
			fee *= this.getRateOfPostedPrice()[3];
		} else if (insurant.getPostedPriceOfStructure() > 2000000000) {
			fee *= this.getRateOfPostedPrice()[4];
		}
		
		// �옱�궛�쓽 �궗�슜 �슜�룄�뿉 �뵲瑜� �슂�쑉 怨꾩궛
		switch(insurant.getEUsageOfStructure()) {
		case house:
			fee *= this.getRateOfStructureUsage()[0];
			break;
		case study:
			fee *= this.getRateOfStructureUsage()[1];
			break;
		case factory:
			fee *= this.getRateOfStructureUsage()[2];
			break;
		case warehouse:
			fee *= this.getRateOfStructureUsage()[3];
			break;
		case office:
			fee *= this.getRateOfStructureUsage()[4];
			break;
		case publicFacility:
			fee *= this.getRateOfStructureUsage()[5];
			break;
		default:
			break;
		}
		
		return (int) fee;
	}

	public Insurance newInstance() {
		return new FireInsurance();
	}

}