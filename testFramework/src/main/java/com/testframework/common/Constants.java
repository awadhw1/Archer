package com.testframework.common;

import static com.testframework.common.GetDirectory.ExecutionEnv;
import static com.testframework.common.GetDirectory.getEnv;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

//import com.thoughtworks.selenium.webdriven.commands.GetExpression;

public class Constants {
	public static final String ieWebDriverName = "webdriver.ie.driver";
	// public static final String
	// ExecutionEnv=System.getProperty("ExecutionEnv");

	 public static final String ExecutionEnv=getEnv();
	public static final String chromeWebDriverPath = "/src/test/resources/dependency/Chrome_4.0/chromedriver.exe"; // V2.29
//	public static final String chromeWebDriverMACPath = "//src//test//resources//dependency//chrome_Mac//chromedriver";
	public static final String PROPERTIES_FILE = "/src/main/java/com/testframework/properties/config/"
			+ ExecutionEnv + "_env.properties";
	public static final String rootDir = System.getProperty("user.dir");

	public static final String URL="url";
	public static final String BAASURL="baasurl";
	public static final String HOMEURL="homeurl";
	public static final String LOGINURL="loginurl";
	public static final String SSOLOGINURL="ssologinurl";


	public static final String STRATEGYDBURL = "qa_strategyDBUrl";
	public static final String STRATEGYDBUNAME = "qa_strategyDBUname";
	public static final String STRATEGYDBPWD = "qa_strategyDBPwd";

	public static final String PLANDBURL = "planDBUrl";
	public static final String PLANDBUNAME = "planDBUname";
	public static final String PLANDBPWD = "planDBPwd";
	public static final String PLANDBSCHEMA = "planDBSchema";

	public static final String PLAN_CASSANDRA_DB_HOST = "cassandrahosturl";
	public static final String PLAN_CASSANDRA_DB_KEYSPACE = "cassandrakeyspace";
	public static final String PLAN_CASSANDRA_DB_PORT = "cassandra_port";
	public static final String PLAN_CASSANDRA_DB_USERNAME = "cassandra_username";
	public static final String PLAN_CASSANDRA_DB_PASSWORD = "cassandra_password";


	public static final String invalidSTRATEGYNAME="invalidstrategyname";
	public static final String STRATEGYNAME="strategyname";
	public static int count=0;

	public static final String USERNAME_PLANNER="usernamePlanner";
	public static final String PASSWORD_PLANNER="passwordPlanner";
	public static final String USERNAME_PLANNINGDIRECTOR="usernamePlanningDirector";
	public static final String PASSWORD_PLANNINGDIRECTOR="passwordPlanningDirector";
	public static final String USERNAME_SUPPORTAGENT="usernameSupportAgent";
	public static final String PASSWORD_SUPPORTAGENT="passwordSupportAgent";
	
	public static final String LOGFILE="log4j.properties";
	public static final int DepartmentID=7;
	public static final int CategoryID=3016;
	public static final int SubcategoryID=6272;
	public static final int FinelineID=4850;
	public static Connection conn=null;

	public static final String StrategyTypeSellThrough="Sell Through";
	public static final String StrategyTypeOutofstock="Out Of Stock";
	public static final String StrategyTypehardmarkdown="Hard MD";

	public static final String SellthroghPerc="20";
	public static final String SellthroghPercIncrement="20.01";
	public static HashMap StrategyDetailsMap=null;
	public static String StrategyDetailsQuery="select * from QAstrategies.Exitstrategy where exitstrategy_name=";
	public static String StrategyDetailsQueryStrategytype="select s.id,s.name,s.days_before_alert,s.market_code,r.days_prior,r.md_vehicle,mapE.keyvalue as mdStrategyTypeValue,l.disp_string as strategy_type, hier.path  from QAstrategies.Strategies s, QAstrategies.MapEntries mapE ,QAstrategies.filters fil,QAstrategies.ProdHierPaths hier, QAstrategies.Lists l ,QAstrategies.Reviews r where s.id=r.strategy_id and mapE.map_id=fil.filter_valmap  and fil.review_id=r.id and s.id=hier.strategy_id and fil.filter_id=l.id and  s.name=%s order by review_num asc;";
	public static String StrategyDetailsQueryPricingType="select s.id,s.name,s.days_before_alert,s.market_code,hier.path,mapE.keyvalue,r.days_prior,r.md_vehicle,l.disp_string,mapE.keyvalue as mdPricingTypeValue from QAstrategies.Strategies s, QAstrategies.Reviews r,QAstrategies.MapEntries mapE ,QAstrategies.filters fil,QAstrategies.ProdHierPaths hier , QAstrategies.Lists l where s.id=r.strategy_id and  mapE.map_id=r.md_mode_valmap  and fil.review_id=r.id and s.id=hier.strategy_id and r.md_mode = l.id and s.name=%s order by review_num asc;";

	//public static String PlanQuery="select processing_status,plan_id FROM QAMdPlans.Plan where plan_name=%s;";
	public static String PlanQuery="select processing_status,plan_id FROM %s.Plan where plan_name=%s;";
	public static String approvedPlanQuery= "select status_code,plan_review_id from %s.Plan_Review where plan_id=62219 and plan_review_id=%s;";
	public static String PlanId="select plan_id,processing_status FROM %s.Plan where plan_name=%s;";
	public static String PlanDraftQuery="select processing_status,plan_id FROM QAMdPlans.Plan where plan_name=%s and is_draft=1;";
	public static String PlanDetailsQueryPricingType="select p.plan_id,p.plan_name,mdval.keyvalue as PricingTypeValue,l.disp_string,p.strategy_id_ref,p.month,p.department_id,p.processing_status,p.days_before_alert,p.final_date,p.country_code,r.md_vehicle_cd,r.review_id, r.review_effective_date,r.md_pricing_type_cd,r.md_pricing_type_val_cd ,r.comment from QAMdPlans.Plan p, QAMdPlans.List l,QAMdPlans.Review r,QAMdPlans.MdValue mdval where p.plan_id=r.plan_id and mdval.md_val_cd=r.md_pricing_type_val_cd and r.md_pricing_type_cd= l.list_id and p.plan_name=%s order by review_num asc;";
	public static String PlanDetailsQueryStrategyType="select p.plan_id,p.plan_name,p.strategy_id_ref,p.month,p.department_id,l.disp_string,p.processing_status,p.days_before_alert,p.final_date,p.country_code,r.md_vehicle_cd,r.review_effective_date,fil.filter_cd,mdval.keyvalue as StrategyTypeValue,fil.filter_val_cd as 'mdval.md_val_cd=fil.filter_val_cd' from QAMdPlans.Plan p, QAMdPlans.Review r,QAMdPlans.List l,QAMdPlans.MdValue mdval,QAMdPlans.MdFilter fil where mdval.md_val_cd=fil.filter_val_cd  and p.plan_id=r.plan_id  and fil.filter_cd= l.list_id and fil.review_id=r.review_id  and p.plan_name=%s order by review_num asc;";
	public static String PlanDetailsItemNode="SELECT p.plan_name, i.item_num, n.node_group_value,i.plan_id FROM QAMdPlans.PlanItem i, QAMdPlans.PlanNode n, QAMdPlans.Plan p where n.plan_id = p.plan_id and i.plan_id = p.plan_id and p.plan_name=";

	public static String getPlanId = "select plan_id FROM %s.Plan where plan_name=%s;";
	public static String updateReviewStatus = "update %s.Plan_Review set status_code = %s where plan_id = %s and plan_review_id = %s;";
	public static String updateUserForPlan = "update %s.Plan set create_user_id='%s' where create_user_id='%s';";
	public static String PlanIdForUser="select plan_id FROM %s.Plan where create_user_id=%s;";
	public static String updateReviewStatusForUser = "update %s.Plan_Review set status_code = %s where plan_id in (SELECT plan_id from %s.Plan WHERE create_user_id ='%s')";

	public static String getItemAggrPrimeItem = "select * from markdown.md_items_aggr where plan_id = %s and review_id = %s and is_prime = true;";
	public static String getItemAggrIsScenario = "select * from markdown.md_items_aggr where plan_id = %s and review_id = %s and is_prime = true and is_scenario = true;";

	public static LinkedHashMap<String, LinkedHashMap<String, String>> contents = new LinkedHashMap<String, LinkedHashMap<String, String>>();
	public static LinkedHashMap<String, ArrayList<String>> values = new LinkedHashMap<String, ArrayList<String>>();

	public static ArrayList<String> daysprior_array = new ArrayList<String>();
	public static ArrayList<String> strategyTypeValue_array = new ArrayList<String>();
	public static ArrayList<String> StrategyTypeName_array = new ArrayList<String>();
	public static ArrayList<String> pricingTypeValue_array = new ArrayList<String>();
	public static ArrayList<String> pricingTypeName_array = new ArrayList<String>();
	public static ArrayList<String> mdVehicleTypearray = new ArrayList<String>();
	public static ArrayList<String> StrategyDetailsarray = new ArrayList<String>();
	public static ArrayList<String> StrategyDetailsverifyarray = new ArrayList<String>();
	public static ArrayList<String> WorkspaceMDDetails_new = new ArrayList<String>();
	public static ArrayList<String> WorkspaceMDDetails_edited = new ArrayList<String>();

	public static ArrayList<Integer> Searchresult = new ArrayList<Integer>();
	public static ArrayList<Integer> AscSort = new ArrayList<Integer>();
	public static ArrayList<Integer> DescSort = new ArrayList<Integer>();
	public static ArrayList<String> Searchresult1 = new ArrayList<String>();
	public static ArrayList<Integer> AscSort1 = new ArrayList<Integer>();
	public static ArrayList<String> DescSort1 = new ArrayList<String>();

	public static ArrayList<Integer> SearchStore = new ArrayList<Integer>();
	public static ArrayList<String> SearchCity = new ArrayList<String>();
	public static ArrayList<String> SearchState = new ArrayList<String>();
	public static ArrayList<String> SearchMktName = new ArrayList<String>();
	public static ArrayList<String> SearchMktStore = new ArrayList<String>();

	public static ArrayList<Integer> AscStoreSort = new ArrayList<Integer>();
	public static ArrayList<Integer> DescStoreSort = new ArrayList<Integer>();
	public static ArrayList<String> StoreInfoAsc = new ArrayList<String>();
	public static ArrayList<String> StoreInfoDesc = new ArrayList<String>();

	public static String StrategyName = null;
	public static String StrategyResponse = null;
	public static String PlanResponse = null;
	public static String MDStrategyTypeCd = null;
	public static String MDPricingTypeCd = null;
	public static String MDVehicleTypeCd = null;
	// public static String PlanName = null;
	public static int Store_Size = 0;
	public static final String InitialStore_Size = "initialStore_size";
	public static final String DraftStore_Size = "draftStore_size";
	public static List<String> InitialStore = null;
	public static List<String> DraftStore = null;

	public static final int SellthroghVal = 20;
	public static final int PricingVal = 30;
	public static final int daysprior = -32;
	public static final String inventoryWeek = "5";
	public static final String EFFECTIVEDATE = "effectivedate";
	public static int editeffectivedate = 4;

	public static final String daysbeforealert = "2";
	public static final String mdVehicle = "Shelf";
	public static final String EndDateVal = "01/01/2025";

	// Input data
	public static final String[] inventory = { "0", "53" };

	// Market Types
	public static final String Stores = "Store Numbers";
	public static final String Markets = "MARKETS";
	public static final String Region = "REGION";
	public static final String State = "STATE";
	public static final String WeatherMajor = "WEATHER-MAJOR";
	public static final String WeatherSubZone = "WEATHER-SUB ZONES";
	public static final String[] marketTypes = { "MARKETS", "REGION", "STATE",
			"WEATHER-MAJOR", "WEATHER-SUB ZONES" };

	// Values are defined in properties file, after code refactor below section
	// can be removed
	public static final String StrategyType = "Sell Through";
	public static final String StrategyType_2 = "Out of Stock";
	public static final String StrategyType_3 = "Hard MD";
	public static final String PricingType = "Percent Off";

	// Item Store list

	public static String StoreList1 = "792,864";
	public static String ItemList1 = "201956,202118,202125";

	// Error messages
	public static String InventoryWeek = "warning Please enter inventory evaluation duration between 1 and 52 Weeks";
	public static String PercentOff = "warning Percent Off value should be increased by at least 0.01%";
	public static String DollarOff = "warning Dollar Off value should be increased by at least $0.01";
	public static String PricePoint = "warning Price Point value should be decreased by at least $0.01";
	public static String Effectivedate = "warning Effective Date must be in increasing increments";
	public static String EndDate = "warning Please enter valid date";
	public static String FinalDate = "warning Effective Date should be in between -42 to 28 days of Final Date";

	// Create Scenario
	public static final String GETPLANNAME = "PlanName";
	public static String PlanName = null;

	public static final String CMDScenario="Clearance Markdown";

	//Set Strategy
	public static int mdCount=3;
	public static int TotalMD=4;
	public static final String StrategyTypeName="strategytype";
	public static final String PricingTypeName="pricingtype";
	public static final String[] percentOff ={"10.01","20.02","30.03","40.04","50.05","70.06"};
	public static final String[] dollarOff ={"1","2.2","3.3","4.4","5.5","6.6"};
	public static final String[] pricePoint ={"40.40","30.30","25.25","20.20","15.15","10.10"};

	//Item-Store list

	public static String ItemList = "ItemList";
	public static String DraftItemList = "DraftItemList";
	public static String StoreList = "StoreList";
	public static String DraftStoreList = "DraftStoreList";
	public static String StoreException = "StoreException";

	public static int dbchecklimit = 90; // 90 Seconds

	// ItemList in gate
	public static ArrayList<String> GateItems_Temp = new ArrayList<String>();
	public static ArrayList<String> Items_Expected = new ArrayList<String>();
	public static ArrayList<String> Items_Actual = new ArrayList<String>();

	// Gate Status
	public static ArrayList<String> GateStatus_Expected = new ArrayList<String>();
	public static ArrayList<String> GateStatus_Actual = new ArrayList<String>();

	// ItemList in gate
	public static ArrayList<String> Stores_added = new ArrayList<String>();
	public static ArrayList<String> Stores_exempted = new ArrayList<String>();

	// Exempted Stores
	public static ArrayList<String> ExemptedStore_Expected = new ArrayList<String>();
	public static ArrayList<String> ExemptedStore_Actual = new ArrayList<String>();

	public interface AddItem {
		public static final String[] SelectGateHeaders = { "", "MD #",
				"Strategy", "Pricing", "Vehicle", "Effective Date" };
	}

	// Plan Status Code
	public static final int EXECUTED = 16;
	public static final int APPROVED = 14;
	public static final int EXPIRED = 17;
	public static final int REJECTED_EXPIRED = 19;
	public static final int PUBLISHING = 18;

	public static final String PLANNER = "planner";
	public static final String PLANNINGDIRECTOR = "planning director";
}
