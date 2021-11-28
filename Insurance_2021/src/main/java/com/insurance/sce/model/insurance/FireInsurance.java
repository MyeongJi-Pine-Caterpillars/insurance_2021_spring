package com.insurance.sce.model.insurance;

import com.insurance.sce.model.customer.Insurant;

public class FireInsurance extends Insurance {

	// Attributes
	private double[] rateOfPostedPrice = {0.9, 1.0, 1.1, 1.2, 1.3}; // index[0: ~5筌ｌ뮆彛뷂옙�뜚/ 1: ~5占쎈섣/ 2: ~10占쎈섣/ 3: ~20占쎈섣/ 4: 域뱄옙 占쎌뵠占쎄맒]
	private double[] rateOfStructureUsage = {1.0, 0.9, 1.2, 1.2, 1.1, 1.1}; // index[0: 雅뚯눛源�/ 1: �뤃癒��몓/ 2: �⑤벊�삢/ 3: 筌≪럡��/ 4: 占쎄텢�눧占�/ 5: �⑤벀�궗占쎈뻻占쎄퐬]

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
		// 占쎌삺占쎄텦 域뱀뮆�걟占쎈퓠 占쎈뎡�몴占� 占쎌뒄占쎌몛 �④쑴沅�
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
		
		// 占쎌삺占쎄텦占쎌벥 占쎄텢占쎌뒠 占쎌뒠占쎈즲占쎈퓠 占쎈뎡�몴占� 占쎌뒄占쎌몛 �④쑴沅�
		switch(insurant.getUsageOfStructure()) {
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