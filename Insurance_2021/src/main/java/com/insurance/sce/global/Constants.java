package com.insurance.sce.global;

import com.insurance.sce.model.insurance.*;

public class Constants {
	
	public static int thisYear = 2021;
	public static int thisMonth = 6;
	
	public static enum eAge {
		kids(1, "영유아"),
		teen(2, "10대"),
		twenties(3, "20대"),
		thirties(4, "30대"),
		fourties(5, "40대"),
		fifties(6, "50대"),
		older(7, "노년층");

		final private int num;
		final private String name;
		
		private eAge(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {return num;}
		public String getName() {return this.name;}
		public static eAge get(int n) {return eAge.values()[n - 1];}
	}
	
	public static enum eAccidentType {
		driver(1),
		dental(2),
		actual(3),
		fire(4),
		cancer(5),
		trip(6);
		
		final private int num;
		
		private eAccidentType(int num) {
			this.num = num;
		}

		public int getNum() {return num;}
		public static eAccidentType get(int n) {return eAccidentType.values()[n - 1];}
	}

	public static enum eGender {
		male(1, "남성"),
		female(2, "여성"),
		both(3, "남성/여성");

		final private int num;
		final private String name;
		
		private eGender(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {return num;}
		public String getName() {return this.name;}
		
		public static eGender get(int n) {return eGender.values()[n - 1];}
	}

	public static enum eJob {
		none(0, "none"),
		officeWorker(1, "사무직"),
		driver(2, "운송업"),
		factoryWorker(3, "현장직"),
		student(4, "학생"),
		teacher(5, "교육직"),
		soldier(6, "군인"),
		etc(7, "기타");

		final private int num;
		final private String name;
		
		private eJob(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {return num;}
		public String getName() {return this.name;}

		public static eJob get(int job) {return eJob.values()[job];}
	}

	public static enum eTypeOfCar {
		none(0, "null"),
		bus(1, "버스"),
		van(2, "승합차"),
		suv(3, "SUV"),
		foreign(4, "외제차"),
		etc(5, "기타");

		final private int num;
		final private String name;
		
		private eTypeOfCar(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {return num;}
		public String getName() {return name;}

		public static eTypeOfCar get(int typeOfCar) {
			return eTypeOfCar.values()[typeOfCar];
		}
	}
	
	public static enum eRankOfCar {
		none(0, "null"),
		luxury(1, "최고급"),
		high(2, "고급"),
		middle(3, "보급형"),
		low(4, "저가");

		final private int num;
		final private String name;
		
		private eRankOfCar(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {return num;}
		public String getName() {return name;}

		public static eRankOfCar get(int rankOfCar) {
			return eRankOfCar.values()[rankOfCar];
		}
	}
	
	public static String[] accidentHistory = {"0회", "1회", "2회~3회", "4회~5회", "6회~7회", "8회 이상"};
	
	public static enum eUsageOfStructure {
		none(0, "null"),
		house(1,"주택"), 
		study(2, "교육"), 
		factory(3, "공장"), 
		warehouse(4, "창고"), 
		office(5, "사무"), 
		publicFacility(6, "공공시설");
		
		final private int num;
		final private String name;
		
		private eUsageOfStructure(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {return num;}
		public String getName() {return name;}

		public static eUsageOfStructure get(int n) {return eUsageOfStructure.values()[n];}
	}

	public static enum eRiskOfTripCountry {
		none(0, "null"),
		safe(1, "안전"), 
		first(2, "1단계"), 
		second(3, "2단계"), 
		third(4, "3단계");

		final private int num;
		final private String name;
		
		private eRiskOfTripCountry(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {return num;}
		public String getName() {return name;}

		public static eRiskOfTripCountry get(int riskOfTripCountry) {
			return eRiskOfTripCountry.values()[riskOfTripCountry];
		}
	}

	public static enum eGuaranteePlanGuaranteeItem {

	}
	
	public static String[] driverGuarantee = {"자동차사고벌금(대인)", "자동차사고벌금(대물)", "교통상해부상치료비", "자동차사고재산피해"};
	public static String[] dentalGuarantee = {"레진", "크라운", "틀니", "임플란트", "스케일링", "발치"};
	public static String[] fireGuarantee = {"화재", "수해", "도난손해", "상해후유장애", "고장수리"};
	public static String[] cancerGuarantee = {"감상선암", "고환암", "난소암", "식도암", "폐암", "간암", "위암", "췌장암"};
	public static String[] tripGuarantee = {"사망", "상해", "해외의료비", "휴대품손해", "배상책임", "항공기납치"};

	public enum eInsuranceType {
		driverInsurance(1, new DriverInsurance(), "driverInsurance", driverGuarantee, "운전자보험"),
		dentalInsurance(2, new DentalInsurance(), "dentalInsurance", dentalGuarantee, "치과보험"),
		actualCostInsurance(3, new ActualCostInsurance(), "actualCostInsurance", null, "실비보험"),
		fireInsurance(4, new FireInsurance(), "fireInsurance", fireGuarantee, "화재보험"),
		cancerInsurance(5, new CancerInsurance(), "cancerInsurance", cancerGuarantee, "암보험"),
		tripInsurance(6, new TripInsurance(), "tripInsurance", tripGuarantee, "여행자보험");

		private int num;
		private Insurance selectedInsurance;
		private String name;
		private String[] GuaranteePlan;
		private String nameKor;
		
		private eInsuranceType(int num, Insurance selectedInsurance, String name, String[] GuaranteePlan, String nameKor) {
			this.num = num;
			this.selectedInsurance = selectedInsurance;
			this.name = name;
			this.GuaranteePlan = GuaranteePlan;
			this.nameKor = nameKor;
		}

		public int getNum() {return this.num;}
		public Insurance getSelectedInsurance() {return this.selectedInsurance;}
		public String getName() {return this.name;}
		public String[] getGuaranteePlan() {return this.GuaranteePlan;}
		public String getNameKor() {return this.nameKor;}
		
		public static eInsuranceType get(int n) {return eInsuranceType.values()[n - 1];}
		
	}

	public static enum eFamilyMedicalDisease {
		none(0, "null"),
		thyroid(1, "갑상선암"), 
		testicular(2, "고환암"), 
		ovarian(3, "난소암"), 
		esophageal(4, "식도암"), 
		lung(5, "폐암");
		
		final private int num;
		final private String name;
		
		private eFamilyMedicalDisease(int num, String name) {
			this.name = name;
			this.num = num;
		}
		
		public int getNum() {return num;}
		public String getName() {return this.name;}

		public static eFamilyMedicalDisease get(int familyMedicalDisease) {
			return eFamilyMedicalDisease.values()[familyMedicalDisease];
		}
	}
	
	public static enum eFamilyMedicalRelationship {
		none(0, "null"),
		one(1, "1촌"),
		two(2, "2촌"),
		three(3, "3촌"),
		four(4, "4촌");
		
		
		final private int num;
		final private String name;
		
		private eFamilyMedicalRelationship(int num, String name) {
			this.name = name;
			this.num = num;
		}
		
		public int getNum() {return num;}
		public String getName() {return this.name;}

		public static eFamilyMedicalRelationship get(int familyMedicalRelationship) {
			return eFamilyMedicalRelationship.values()[familyMedicalRelationship];
		}
	}
	
	public static String[] postedPrice = {"(공시가)<=5천만원", "5천만원<(공시가)<=5억", "5억<(공시가)<=10억", "10억<(공시가)<=20억", "20억<(공시가)"};
	
	public static enum eEmployeeRole {
		insuranceDeveloper(1),
		insuranceConfirmer(2),
		salesperson(3),
		contractManager(4),
		compensationHandler(5),
		underWriter(6);
		
		final private int num;
		
		private eEmployeeRole(int num) {
			this.num = num;
		}

		public int getNum() {return num;}
		
		public static eEmployeeRole get(int n) {return eEmployeeRole.values()[n - 1];}

	}

}
