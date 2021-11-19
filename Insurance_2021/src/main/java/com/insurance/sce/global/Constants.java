package com.insurance.sce.global;

import com.insurance.sce.model.insurance.*;

public class Constants {
	
	public static int thisYear = 2021;
	public static int thisMonth = 6;
	
	public static enum eAge {
		kids(1, "�쁺�쑀�븘"),
		teen(2, "10��"),
		twenties(3, "20��"),
		thirties(4, "30��"),
		fourties(5, "40��"),
		fifties(6, "50��"),
		older(7, "�끂�뀈痢�");

		final private int num;
		final private String name;
		
		private eAge(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {return num;}
		public String getName() {return this.name;}
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
	}

	public static enum eGender {
		male(1, "�궓�꽦"),
		female(2, "�뿬�꽦"),
		both(3, "�궓�꽦/�뿬�꽦");

		final private int num;
		final private String name;
		
		private eGender(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {return num;}
		public String getName() {return this.name;}
	}

	public static enum eJob {
		none(0, "none"),
		officeWorker(1, "�궗臾댁쭅"),
		driver(2, "�슫�넚�뾽"),
		factoryWorker(3, "�쁽�옣吏�"),
		student(4, "�븰�깮"),
		teacher(5, "援먯쑁吏�"),
		soldier(6, "援곗씤"),
		etc(7, "湲고�");

		final private int num;
		final private String name;
		
		private eJob(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {return num;}
		public String getName() {return this.name;}
	}

	public static enum eTypeOfCar {
		none(0, "null"),
		bus(1, "踰꾩뒪"),
		van(2, "�듅�빀李�"),
		suv(3, "SUV"),
		foreign(4, "�쇅�젣李�"),
		etc(5, "湲고�");

		final private int num;
		final private String name;
		
		private eTypeOfCar(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {return num;}
		public String getName() {return name;}
	}
	
	public static enum eRankOfCar {
		none(0, "null"),
		Luxury(1, "理쒓퀬湲�"),
		high(2, "怨좉툒"),
		middle(3, "蹂닿툒�삎"),
		low(4, "��媛�");

		final private int num;
		final private String name;
		
		private eRankOfCar(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {return num;}
		public String getName() {return name;}
	}
	
	public static String[] accidentHistory = {"0�쉶", "1�쉶", "2�쉶~3�쉶", "4�쉶~5�쉶", "6�쉶~7�쉶", "8�쉶 �씠�긽"};
	
	public static enum eUsageOfStructure {
		none(0, "null"),
		house(1,"二쇳깮"), 
		study(2, "援먯쑁"), 
		factory(3, "怨듭옣"), 
		warehouse(4, "李쎄퀬"), 
		office(5, "�궗臾�"), 
		publicFacility(6, "怨듦났�떆�꽕");
		
		final private int num;
		final private String name;
		
		private eUsageOfStructure(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {return num;}
		public String getName() {return name;}
	}

	public static enum eRiskOfTripCountry {
		none(0, "null"),
		safe(1, "�븞�쟾"), 
		first(2, "1�떒怨�"), 
		second(3, "2�떒怨�"), 
		third(4, "3�떒怨�");

		final private int num;
		final private String name;
		
		private eRiskOfTripCountry(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {return num;}
		public String getName() {return name;}
	}

	public static enum eGuaranteePlanGuaranteeItem {

	}
	
	private static String[] driverGuarantee = {"�옄�룞李⑥궗怨좊쾶湲�(���씤)", "�옄�룞李⑥궗怨좊쾶湲�(��臾�)", "援먰넻�긽�빐遺��긽移섎즺鍮�", "�옄�룞李⑥궗怨좎옱�궛�뵾�빐"};
	private static String[] dentalGuarantee = {"�젅吏�", "�겕�씪�슫", "���땲", "�엫�뵆���듃", "�뒪耳��씪留�", "諛쒖튂"};
	private static String[] fireGuarantee = {"�솕�옱", "�닔�빐", "�룄�궃�넀�빐", "�긽�빐�썑�쑀�옣�븷", "怨좎옣�닔由�"};
	private static String[] cancerGuarantee = {"媛먯긽�꽑�븫", "怨좏솚�븫", "�궃�냼�븫", "�떇�룄�븫", "�룓�븫", "媛꾩븫", "�쐞�븫", "痍뚯옣�븫"};
	private static String[] tripGuarantee = {"�궗留�", "�긽�빐", "�빐�쇅�쓽猷뚮퉬", "�쑕���뭹�넀�빐", "諛곗긽梨낆엫", "�빆怨듦린�궔移�"};

	public enum eInsuranceType {
		driverInsurance(1, new DriverInsurance(), "driverInsurance", driverGuarantee),
		dentalInsurance(2, new DentalInsurance(), "dentalInsurance", dentalGuarantee),
		actualCostInsurance(3, new ActualCostInsurance(), "actualCostInsurance", null),
		fireInsurance(4, new FireInsurance(), "fireInsurance", fireGuarantee),
		cancerInsurance(5, new CancerInsurance(), "cancerInsurance", cancerGuarantee),
		tripInsurance(6, new TripInsurance(), "tripInsurance", tripGuarantee);

		private int num;
		private Insurance selectedInsurance;
		private String name;
		private String[] GuaranteePlan;
		
		private eInsuranceType(int num, Insurance selectedInsurance, String name, String[] GuaranteePlan) {
			this.num = num;
			this.selectedInsurance = selectedInsurance;
			this.name = name;
			this.GuaranteePlan = GuaranteePlan;
		}

		public int getNum() {return this.num;}
		public Insurance getSelectedInsurance() {return this.selectedInsurance;}
		public String getName() {return this.name;}
		public String[] getGuaranteePlan() {return this.GuaranteePlan;}
	}

	public static enum eFamilyMedicalDisease {
		none(0, "null"),
		thyroid(1, "媛묒긽�꽑�븫"), 
		testicular(2, "怨좏솚�븫"), 
		ovarian(3, "�궃�냼�븫"), 
		esophageal(4, "�떇�룄�븫"), 
		lung(5, "�룓�븫");
		
		final private int num;
		final private String name;
		
		private eFamilyMedicalDisease(int num, String name) {
			this.name = name;
			this.num = num;
		}
		
		public int getNum() {return num;}
		public String getName() {return this.name;}
	}
	
	public static enum eFamilyMedicalRelationship {
		none(0, "null"),
		one(1, "1珥�"),
		two(2, "2珥�"),
		three(3, "3珥�"),
		four(4, "4珥�");
		
		
		final private int num;
		final private String name;
		
		private eFamilyMedicalRelationship(int num, String name) {
			this.name = name;
			this.num = num;
		}
		
		public int getNum() {return num;}
		public String getName() {return this.name;}
	}
	
	public static String[] postedPrice = {"(怨듭떆媛�)<=5泥쒕쭔�썝", "5泥쒕쭔�썝<(怨듭떆媛�)<=5�뼲", "5�뼲<(怨듭떆媛�)<=10�뼲", "10�뼲<(怨듭떆媛�)<=20�뼲", "20�뼲<(怨듭떆媛�)"};
	
	public static enum eCancer {
		thyroid(1,"媛묒긽�꽑�븫"), 
		testicular(2, "怨좏솚�븫"), 
		ovarian(3, "�궃�냼�븫"), 
		esophageal(4, "�떇�룄�븫"), 
		lung(5, "�룓�븫"),
		liver(6, "媛꾩븫"),
		colorectal(7, "���옣�븫");
		
		final private int num;
		final private String name;
		
		private eCancer(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {return num;}
		public String getName() {return this.name;}
	}

	public static enum eEmployeeRole {
		insuranceDeveloper(1), insuranceConfirmer(2), salesperson(3), contractManager(4), compensationHandler(5), underWriter(6);
		
		final private int num;
		
		private eEmployeeRole(int num) {
			this.num = num;
		}

		public int getNum() {return num;}
	}

}
