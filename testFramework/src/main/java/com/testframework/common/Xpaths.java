package com.testframework.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.testframework.common.Constants.*;

public class Xpaths {
	public interface HomePage {
		public static By loginPageUserIDtxtID =By.id("userId");
		public static By loginPagePwdtxtboxID =By.id("password");
		public static By loginButtonX =By.xpath("//button[@class='btn login-button']");
	}

	/*public interface StrategyPage {
		public static By UserNameLinkX =By.xpath("//a[@class='dropdown-toggle ng-binding']");
		public static By SettingsLinkX =By.xpath("//a[text()='SETTINGS']");
		public static By ExitStrategyLinkX =By.xpath("//a[text()='EXIT STRATEGY']");
		public static By CreatStrategyBtnX =By.xpath("//button[text()='CREATE EXIT STRATEGY']");
		public static By ExitStrategyTxtBoxID =By.id("exitStrategy");

		public static By MDTable=By.xpath("//tbody[@class='md-margin-10']");
		public static String mdStrategyTypeDropDownID ="mdStrategyType%s";
		public static String mdStrategyValuetxtID =("mdStrategyValue%s");
		public static String mdPricingNameDropdown =("(//select[@name='mdPricingType'])[%s]");
		public static String mdPricingValuetxtID =("mdPricingValue%s");
		public static String mdVehicleDropdown =("(//select[@name='mdVehicle'])[%s]");
		public static String daysPriortxt =("(//input[@name='daysPrior'])[%s]");
		public static By daysBeforeAlerttxtID =By.id("merchantAlert");
		public static By strategySuccess =By.xpath("//div[@class='messageBoxContent md-response-content clearfix']");
		public static By strategyPopupOk =By.xpath("//input[@value='Ok']");
		public static String closeIconX =("//a[text()='close'])[%s]");

		public static By mdStrategyTypeDropDownID0 =By.id("mdStrategyType0");
		public static By mdStrategyTypeDropDownID1 =By.id("mdStrategyType1");
		public static By mdStrategyTypeDropDownID2 =By.id("mdStrategyType2");
		public static By mdStrategyTypeDropDownID3 =By.id("mdStrategyType3");
		public static By mdStrategyTypeDropDownID4 =By.id("mdStrategyType4");
		public static By mdStrategyTypeDropDownID5 =By.id("mdStrategyType5");
		public static By mdStrategyValuetxtID0 =By.id("mdStrategyValue0");
		public static By mdStrategyValuetxtID1 =By.id("mdStrategyValue1");
		public static By mdStrategyValuetxtID2 =By.id("mdStrategyValue2");
		public static By mdStrategyValuetxtID3 =By.id("mdStrategyValue3");
		public static By mdStrategyValuetxtID4 =By.id("mdStrategyValue4");
		public static By mdStrategyValuetxtID5 =By.id("mdStrategyValue5");
		public static By mdPricingNameDropdownX1 =By.xpath("//select[@name='mdPricingType'])[1]");
		public static By mdPricingNameDropdownX2 =By.xpath("//select[@name='mdPricingType'])[2]");
		public static By mdPricingNameDropdownX3 =By.xpath("//select[@name='mdPricingType'])[3]");
		public static By mdPricingNameDropdownX4 =By.xpath("//select[@name='mdPricingType'])[4]");
		public static By mdPricingNameDropdownX5 =By.xpath("//select[@name='mdPricingType'])[5]");
		public static By mdPricingNameDropdownX6 =By.xpath("//select[@name='mdPricingType'])[6]");
		public static By mdPricingValuetxtID0 =By.id("mdPricingValue0");
		public static By mdPricingValuetxtID1 =By.id("mdPricingValue1");
		public static By mdPricingValuetxtID2 =By.id("mdPricingValue2");
		public static By mdPricingValuetxtID3 =By.id("mdPricingValue3");
		public static By mdPricingValuetxtID4 =By.id("mdPricingValue4");
		public static By mdPricingValuetxtID5 =By.id("mdPricingValue5");
		public static By mdVehicleDropdownX1 =By.xpath("//select[@name='mdVehicle'])[1]");

		public static By mdVehicleDropdownX2 =By.xpath("(//select[@name='mdVehicle'])[2]");
		public static By mdVehicleDropdownX3 =By.xpath("(//select[@name='mdVehicle'])[3]");

		public static By mdVehicleDropdownX4 =By.xpath("(//select[@name='mdVehicle'])[4]");
		public static By mdVehicleDropdownX5 =By.xpath("(//select[@name='mdVehicle'])[5]");

		public static By mdVehicleDropdownX6 =By.xpath("(//select[@name='mdVehicle'])[6]");
		public static By daysPriortxtX1 =By.xpath("(//input[@name='daysPrior'])[1]");

		public static By daysPriortxtX2 =By.xpath("(//input[@name='daysPrior'])[2]");
		public static By daysPriortxtX3 =By.xpath("(//input[@name='daysPrior'])[3]");

		public static By daysPriortxtX4 =By.xpath("(//input[@name='daysPrior'])[4]");
		public static By daysPriortxtX5 =By.xpath("(//input[@name='daysPrior'])[5]");

		public static By daysPriortxtX6 =By.xpath("(//input[@name='daysPrior'])[6]");
		public static By closeIconXfirst =By.xpath("(//a[text()='close'])[1]");
		public static By closeIconXsecond =By.xpath("(//a[text()='close'])[2]");
		public static By closeIconXthird =By.xpath("(//a[text()='close'])[3]");
		public static By addMarkdown =By.xpath("(//a[text()='ADD MARKDOWN'])");
		public static By daysBeforeAlerttxtName =By.name("daysBeforeAlert");
		public static By Nextstepbtnx =By.xpath("//input[@value='Next Step']");
		public static By FooterdivX =By.xpath("//div[@class='modal-footer clearfix']");	
		public static By DepartmentDropDownX =By.xpath("//div[@placeholder='ENTER DEPARTMENT']");
		public static By DepartmentDropDownListX =By.xpath("//ul[contains(@repeat,'department')and not(contains(@class, 'ng-hide'))]");
		public static By CategoryDropDownID =By.id("md-hir-category");
		public static By CategoryDropDownListX =By.xpath("//ul[contains(@repeat,'category')and not(contains(@class, 'ng-hide'))]");
		public static By SubcategoryDropDownID =By.id("md-hir-subcat");
		public static By SubcategoryDropDownListX=By.xpath("//ul[contains(@repeat,'subcategory')and not(contains(@class, 'ng-hide'))]");
		public static By FinelineDropDownID =By.id("md-hir-fineline");
		public static By DepartmentValueSelect =By.xpath("//span[text()='"+ Constants.DepartmentID + "']");
		public static By CategoryValueSelect =By.xpath("//span[text()='"+ Constants.CategoryID + "']");
		public static By SubcategoryValueSelect =By.xpath("//span[text()='"+ Constants.SubcategoryID + "']");
		public static By FinelineValueSelect =By.xpath("//span[text()='"+ Constants.FinelineID + "']");
		public static By FinishButtonX =By.xpath("//input[@value='Finish']");
		public static By ErrorMSGStrategyNameX =By.xpath("//div[@class='md-alert md-alert-error ng-binding']");
		public static By ErrorMSGX =By.xpath("//div[@class='md-alert md-alert-error pull-right ng-binding']");
	}

	public interface SearchStrategyPage {
		public static By SearchStrategytxtX =By.xpath("//input[@placeholder='Search by Exit Strategy Name']");
		public static By SearchStrategybtnX =By.xpath("//button/span[text()='SEARCH']");
		public static By DepartmentdropdownX =By.xpath("//span[text()='DEPARTMENT']");
		public static By DepartmentToysX =By.xpath("//span[text()='TOYS']");

		public static By CategorydropdownX =By.xpath("//span[text()='CATEGORY']");
		public static By SubcategorydropdownX =By.xpath("//span[text()='SUBCATEGORY']");
		public static By FinelinedropdownX =By.xpath("//span[text()='FINELINE']");
		public static By ResultTableX =By.xpath("//tbody[@class='search-results-body ng-scope']");
		public static By Details =By.xpath("//div[@class='details-container ng-scope']");
		public static String SearchresultX =("//td[contains(@title,%s)]");

	}
	public interface PlanMainPage {
		public static By ScenarioLink =By.xpath("//a[contains(text(),'SCENARIOS')]");
		public static By inboxlink =By.xpath("//li[@href='#/scenarios/inbox']");
		public static By draftlink =By.xpath("//li[@href='#/scenarios/drafts']");
		public static By archivedlink =By.xpath("//li[@href='#/scenarios/archived']");
		public static By NewPlanbuttonx =By.xpath("//button[text()='NEW PLAN']");
		public static By planNametxtID =By.id("planName");
		public static By createPlanButtonx =By.xpath("//button[contains(@type,'submit')]");
		public static By ExitStrategyButtonx =By.xpath("//button[@class='btn positive']");
		public static By EnterStrategyTextBoxx =By.xpath("//span[@class='ui-select-placeholder text-muted ng-binding']");
		public static By CalenderIconX =By.xpath("(//a[text()='today'])[1]");
		public static By MonthSelectionx =By.xpath("//button[@class='btn btn-default btn-sm pull-right uib-right']");
		public static By DateSelectionx =By.xpath("//span[text()='22']");
		public static By CalenderLeftbuttonX =By.xpath("//i[contains(@class,'left')]");
		public static By CalenderRightbuttonX =By.xpath("//i[contains(@class,'chevron-right')]");
		public static By CalenderMonthLabelx =By.xpath("//button[contains(@id,'datepicker')]");
		public static By CalenderTodayButtonX =By.xpath("//button[text()='Today']");
		public static By CalenderClearButtonX =By.xpath("//button[text()='Clear']");
		public static By CalenderCloseButtonX =By.xpath("//button[text()='Close']");
		public static By NextStepButtonx =By.xpath("//input[@value='Next Step']");
		public static By PreviousStepButtonx =By.xpath("//input[@value='Previous step']");
		public static By Inventory =By.id("inventory");

		//Store Selection Screen
		public static By StoreSelectionTextboxX =By.xpath("(//input[@placeholder='Search Store(s) Here'])[1]");
		public static By StoreSelectionCheckboxX=By.xpath("//li[@class='table-list--header__item sm text-center']");
		public static By StoreSelectionSingleX =By.xpath("(//li[@class='table-list__item md-padding-left-10 ng-binding'])[1]");
		public static By StoreSelectionSingleGate =By.xpath("(//li[@class='table-list__item md-padding-left-10 text-align-right ng-binding'])[1]");
		//public static By StoreSelectionDropDownX="(//button[@class='btn dropdown-toggle btn-primary col-md-12 md-padding-0 md-line-height-40 md-border-radius-0 market-label'])[1]");
		public static By StoreSelectionDropDownX =By.xpath("(//button[@class='btn btn-primary md-dropdown-menu-add-item-btn ng-binding dropdown-toggle'])[1]");
		//public static By StoreExceptionDropDownX="(//button[@class='btn dropdown-toggle btn-primary col-md-12 md-padding-0 md-line-height-40 md-border-radius-0 market-label'])[2]");
		public static By StoreExceptionDropDownX =By.xpath("(//button[@class='btn btn-primary md-dropdown-menu-add-item-btn ng-binding dropdown-toggle'])[2]");
		public static String Market =("//a[contains(text(),'%s')]");
		public static By Store =By.xpath("//a[contains(text(),'Store Numbers')]");
		public static By Deletestore =By.xpath("(//a[@class='material-icons md-del-btn md-icon-padding'])[1]");
		public static By StorecheckboxStatus =By.xpath("//li[@class='table-list--header__item sm text-center']//input");
		public static By StoreSelLHS =By.xpath("(//div[@class='md-scrollable right-constrained'])[1]");
		//public static By StoreSearchLHS =By.xpath("//li[@class='table-list__item md-padding-left-10 text-align-right ng-binding']");
		//public static By StoreSearchLHS =By.xpath("//li[@class='table-list__item ng-binding']");
		public static By StoreSearchRslt =By.xpath("//div[@class='md-scrollable left-constrained']//ul");
		public static String StoreSearchLHS =("(//div[@class='md-scrollable left-constrained']//ul//ul)[%s]");
		public static By MktSearchLHS =By.xpath("//li[@class='table-list__item md-padding-left-10 ng-binding']");
		public static By StoreScroll =By.xpath("//div[@class='md-scrollable left-constrained']");

		//Sort Icons : Store Selection
		public static By SortStoreAsc =By.xpath("(//span[@class='arrow-pos arrow-up'])[1]");
		public static By SortStoreDesc =By.xpath("(//span[@class='arrow-pos arrow-down'])[1]");
		public static By SortCityAsc =By.xpath("(//span[@class='arrow-pos arrow-up'])[2]");
		public static By SortCityDesc =By.xpath("(//span[@class='arrow-pos arrow-down'])[1]");
		public static By SortStateAsc =By.xpath("(//span[@class='arrow-pos arrow-up'])[3]");
		public static By SortStateDesc =By.xpath("(//span[@class='arrow-pos arrow-down'])[1]");

		//Sort Icons : Store Exception
		public static By SortStoreExcpAsc =By.xpath("(//span[@class='arrow-pos arrow-up'])[4]");
		public static By SortStoreExcpDesc =By.xpath("(//span[@class='arrow-pos arrow-down'])[1]");
		public static By SortCityExcpAsc =By.xpath("(//span[@class='arrow-pos arrow-up'])[5]");
		public static By SortCityExcpDesc =By.xpath("(//span[@class='arrow-pos arrow-down'])[1]");
		public static By SortStateExcpAsc =By.xpath("(//span[@class='arrow-pos arrow-up'])[6]");
		public static By SortStateExcpDesc =By.xpath("(//span[@class='arrow-pos arrow-down'])[1]");

		//Store Exception Screen
		public static By StoreExceptionTextboxX =By.xpath("(//input[@placeholder='Search Store(s) Here'])[2]");	
		public static By StoreExceptionCheckboxX =By.xpath("(//li[@class='table-list--header__item sm text-center'])[2]");
		public static By StoreExcpcheckboxStatus =By.xpath("(//li[@class='table-list--header__item sm text-center']//input)[2]");
		public static By StoreExcpRHS =By.xpath("(//div[@class='md-scrollable right-constrained background-light-blue'])[2]");

		//Item Selection Screen
		public static By ItemSelectionTextboxX =By.xpath("//input[@placeholder='Search Item(s) Here']");
		public static By ItemSelectionCheckboxX =By.xpath("//table[@class='table-fixed md-create-table md-items-table']//tr//th");
		public static By ItemSeletionCheckboxStatus =By.xpath("//table[@class='table-fixed md-create-table md-items-table']//tr//th//input");
		public static By ItemSelRHS =By.xpath("(//td[@class='right-item-constrained'])");
		public static By DeleteItem =By.xpath("(//a[@class='material-icons md-del-btn'])[1]");

		public static By PlanFinishButtonX =By.xpath("//input[@value='Finish']");
		public static By PlanMsgbox =By.xpath("//div[@class='messageBoxContent md-response-content clearfix']");
		public static By PlanMsgboxOk =By.xpath("//button[text()='OK']");

		public static By StoreExceptionListX =By.xpath("//li[@class='table-list-row ng-scope']");
		public static By NewScenariobuttonx =By.xpath("//button[text()='NEW SCENARIO']");
		public static By ScenarioNametxtID =By.id("scenarioName");
		public static By ScenarioTypeID =By.id("scenario-type");
		public static By ScenarioCMD =By.xpath("//span[text()='CMD']");
		public static By MonthID =By.id("month");
		public static By MonthX =By.xpath("//li[contains(text(),'JAN')]");
		public static By DeptID =By.id("dept");
		public static By DeptX =By.xpath("//li[contains(text(),'1 -')]");
		public static By CreateX =By.xpath("//button[text()='CREATE']");

		public static By InboxPlanSearchX =By.xpath("//em[@class='material-icons filter-icon-position name-filter-position']");
		public static By InboxPlanFilterId =By.id("nameFilter");
		public static By InboxEditX =By.xpath("//button[@class='spcility-btn edit-btn btn positive']");
		public static By InboxDelete =By.xpath("//li[@class='deleteButton ng-scope']");
		public static By ConfirmDelete =By.xpath("//button[text()='Yes, Delete']");
		public static By PlanCompleted =By.xpath("//span[text()='COMPLETED']");
		public static By PlanProgress =By.xpath("//span[text()='IN-PROGRESS']");

		//Create New Exit Strategy
		public static By CreateNewStrategy =By.xpath("//a[@class='btn light new-exit-strategy-button']");
		public static By MDNewStrategy =By.xpath("//div[@class='md-cs-plan-animate']");
		public static By MDlist =By.xpath("//div[contains(@class,'row md-cs-plan-animate ng-scope')]");
		public static String mdStrategytypeX =("//div[@class='row md-cs-plan-animate ng-scope'][%s]//div[@ng-model='review.strategyTypeObj']");
		public static String mdStrategyValueX =("(//span[text()='%s'])");
		public static String mdPricingtypeX =("//div[@class='row md-cs-plan-animate ng-scope'][%s]//div[@ng-model='review.pricingTypeObj']");
		public static String mdPricingtypeValueX =("(//span[text()='%s'])");
		public static String mdPricingValueX =("(//input[@name='mdPricingTypeValue%s'])");
		public static String mdVehiclex =("(//div[@ng-model='review.mdVehicleObj'])[%s]");
		public static By mdVehicleTypex =By.xpath("(//span[text()='Shelf'])");
		public static String mdCalenderx ="(//input[@name='mdEffectiveDate%s'])";
		public static String mdDateSelectionx =("//span[text()='%s']");
		public static By mdEndDate =By.xpath("(//input[@name='endDate'])");
		public static By MDNewStrategyPanel =By.xpath("//div[@class='md-margin-15 md-ui-select-container md-create-plan-container']");
		public static By MDStrategyPanelerror=By.xpath("//div[@class='md-alert md-alert-error pull-right ng-binding']");

		//ICMP Error Message
		public static By ZeroNetStorex =By.xpath("//span[text()='Net stores added to MD plan are zero']");
		public static By InventoryErr =By.xpath("//div[text()=' Please enter inventory evaluation duration between 1 and 52 Weeks ']");

	}
	public interface PlanWorkspace {
		public static By ModifyMDX =By.xpath("//button[@class='btn md-default btn-block' and contains(text(),'MODIFY MD')]");
		public static By ModifyMDScreenx =By.xpath("//div[@class='md-create-plan-content']");
		public static By ModifyMDlistX =By.xpath("//div[contains(@class,'row md-cs-plan-animate ng-scope')]");
		public static By WorkspaceMiddleX =By.xpath("//div[@class='col-md-8 md-main-container']");
		public static By WorkspaceMDX =By.xpath("//span[contains(@text,'Markdown')]");
		public static By ModifyMdOk =By.xpath("//input[@value='OK']");

		public static By WorkspaceMDItemX =By.xpath("//div[@class='col-md-8 md-main-container']//span[@class='markdown-item-name ng-binding']");
		public static String ExpandIconx =("//li[@class='table-list md-plan-table-list md-plan-table-list-review selected'][%s]//span[@class='md-expand-selected']");
		public static By CollapseIconx =By.xpath("//span[@class='md-expand-selected md-collapsed']");
		public static By LoadingId =By.id("loadingScreen");
		public static String MDGate1x =("//span[text()='Markdown %s']");
		public static String MDItem1x =("//span[text()='%s']");
		public static By ChangeExceptionx =By.xpath("//a[text()='CHANGE EXCEPTIONS']");
		public static By ChangeException_Cancelx =By.xpath("//button[@class='btn light']");
		public static By Draft_Msg =By.xpath("//h2[text()='Item Clearance Markdown Plan']");

		//ChangeException Screen
		public static By StoreExceptionTableHeaderX =By.xpath("//ul[@class='table-list-container']");
		public static By StoreExceptionScreenX =By.xpath("//div[@class='modal-popup-content md-bottom-radius']");
		public static By StoreExceptionListX =By.xpath("//li[@class='table-list-row ng-scope']");
		public static By StoreListX =By.xpath("//li[@class='table-list__item md-padding-store-cell text-center ng-binding']");
		public static By StoreCheckboxId =By.id("store%s");
		public static By StoreCheckboxX =By.xpath("(//li[@class='table-list__item sm text-center'])[%s]");
		public static By ExemptedStoreListX =By.xpath("//ul[@class='table-list body md-padding-scroll-width selected']//li[@class='table-list__item md-padding-store-cell text-align-right ng-binding']");

		//Add Item - Workspace
		public static By AddItem =By.xpath("//button[@class='btn md-positive' and contains(text(),'+ ITEMS ')]");
		public static By StoreSelection =By.xpath("//section[@wz-title='Store Selection']//input[@placeholder='Search Store(s) Here'][1]");
		public static By StoreSelectDropDownX =By.xpath("(//button[@class='btn btn-primary md-dropdown-menu-add-item-btn ng-binding dropdown-toggle'])[1]");

		//Add Store - Workspace
		public static By AddStore =By.xpath("//button[@class='btn md-default' and contains(text(),'+ STORE ')]");
		public static By AddStoreDropDownX =By.xpath("//button[@class='btn dropdown-toggle btn-primary col-md-12 md-padding-0 md-line-height-40 md-border-radius-0 market-label' and contains(text(),'Store')]");
		public static By AddStoreTextboxX =By.xpath("//input[@placeholder='Search Store(s) Here']");
		public static By AddStoreCheckboxX =By.xpath("//li[@class='table-list--header__item sm text-center']");
		public static By ApplyAllButtonX =By.xpath("//button[@class='btn positive split']");
		public static By ApplySelectedX =By.xpath("//ul[@class='btn-options up']");

		//Remove Item - Workspace
		public static By RemoveItemSelected =By.xpath("//button[@class='btn btn-inverse btn-split md md-btn-primary' and contains(text(),'REMOVE ITEM(S)')]");
		public static By RemoveItemAll =By.xpath("//li[@class='btn btn-inverse md-btn-primary bg-grey md' and contains(text(),'FROM ALL MD')]");
		public static By SelectItem =By.xpath("//li[@class='table-list__item sm text-center'][1]");
		public static By Submit =By.xpath("//button[contains(@type,'submit')]");

		//Action buttons
		public static By Actionbtn = By.xpath("(//span[text()='Action'])");
		public static By ExecuteMDX =By.xpath("(//span[text()='Execute'])");
		public static By RejectMDX= By.xpath("(//span[text()='Reject'])");
		public static By SaveDraft =By.xpath("(//span[text()='Save'])");
		public static By ResetDraft =By.xpath("(//span[text()='Reset'])");

		//Workspace -Gate Filter
		public static By GateFilterX=By.xpath("//div[@class='pull-left md-padding-0 md-margin-0 md-padding-left-10 ng-binding' and contains(text(),'Markdowns (All)')]");
		public static By GateFilterdropdown=By.xpath("//ul[@class='dropdown-menu sp-dropdown-menu col-md-12']");

		//ModifyMD
		public static String ModifyMDStrategytype =("//div[@class='row md-cs-plan-animate ng-scope'][%s]//div[@ng-model='review.defaultStrategyTypeSelect']");
		public static String ModifyMDStrategytypeValue =("(//span[text()='%s'])");
		public static String ModifyMDPricingtype =("//div[@class='row md-cs-plan-animate ng-scope'][%s]//div[@ng-model='review.defaultPricingTypeSelect']");
		public static String ModifyMDPricingtypeValue =("(//span[text()='%s'])");
		public static String ModifyMDPricingValue =("(//input[@name='mdPricingTypeValue%s'])");
		public static String ModifyMDVehicle =("(//div[@ng-model='review.defaultVehicleTypeSelect'])[%s]");
		public static By ModifyMDVehicletypeValue =By.xpath("(//span[text()='Shelf'])");

		//PricePoint
		public static By EyeIcon =By.xpath("//div[@class='table-list__item md-pp-eye'][1]");
		public static By Pricepointscreen =By.xpath("//div[@class='md-small-div md-scrollable']");
		public static By Pricevalue =By.xpath("//li[@class='table-list__item margin-right-30']");
	}

	public interface AddItem {
		//Add Item - Workspace
		public static By AI_Btn=By.xpath("//button[@class='btn md-positive' and contains(text(),'+ ITEMS ')]");
		public static By AI_SelectGateClnheader =By.xpath("//ul[@class='table-list header'][1]");
		public static By AI_Nextstepbtn =By.xpath("//input[@value='Next Step']");

	}

*/}
