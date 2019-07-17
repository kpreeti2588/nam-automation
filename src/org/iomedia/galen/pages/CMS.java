package org.iomedia.galen.pages;




import java.util.List;

import org.iomedia.common.BaseUtil;

import org.iomedia.framework.Driver.HashMapNew;
import org.iomedia.galen.common.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.iomedia.framework.Reporting;
import org.iomedia.framework.WebDriverFactory;

public class CMS extends BaseUtil {

	public CMS(Utils base, WebDriverFactory driverFactory, HashMapNew Dictionary, HashMapNew Environment, Reporting Reporter, org.iomedia.framework.Assert Assert, org.iomedia.framework.SoftAssert SoftAssert, ThreadLocal<HashMapNew>[] sTestDetails) {
		super(driverFactory, Dictionary, Environment, Reporter, Assert, SoftAssert, sTestDetails);
		
	}
	
	private By buildtext= By.xpath("//span[@class='build-text']");
	private By invoices = By.xpath("//p[text()='Invoices']");
	private By setting = By.xpath("//p[text()='Settings']");
	private By ticketmanagement = By.xpath("//p[text()='Ticket Management']");
	private By donation = By.xpath("//p[text()='Donation']");
	private By quickdonation = By.xpath("//p[text()='Quick Donation']");
	private By quickdonationenabled = By.cssSelector("#edit-box-donation-enable[checked='checked']");
	private By quickdonationenablecb = By.cssSelector("#edit-box-donation-enable + span");
	private By ticketoptions = By.xpath("//p[text()='Ticket Options']");
	private By bulktoggle = By.cssSelector("label[title='Enable this to show bulk transfer option'] span[class='toggle']");
	private By editsubmit = By.cssSelector("#edit-submit");
	
	private By addpage =By.xpath("//a[@title='Add a new page']");
	private By videopform = By.xpath("//form[@class='add-content-videotakeover']");
	private By formchekbox = By.xpath("(//span[@class='checkbox-material'])[2]");
	private By closeX = By.xpath("//span[contains(@class,'ui-icon-closethick')]");
	private By homepage =By.xpath("Home Pages");
	private By selectbutton = By.xpath("(//li[@class='content-type-options']/a//div[text()='Select'])[1]");
	private By ticketsalesverification = By.xpath("//div[@class='panel-title' and text()='Ticket Sales']");
	private By pagemanager= By.xpath("//p[text()='Page Manager']");
	private By ticketsalespage =By.xpath("//div[@id='edit-ticket-sales']");
	private By formpresent =By.xpath("//div[@id='edit-ticket-sales']/div");
	private By ticketsalestext =By.xpath("//p[@id='edit-ticket-sales-wrapper--description']");
 
	private By signInComponent = By.xpath("//p[text()='Sign In Component']");
	private By addNewInvoice = By.xpath("//p[text()='Add New Invoice']");
	private By viewInvoices = By.xpath("//*[@class='view-invoices']");
	private By settingGear = By.xpath("//a[contains(@href,'invoice/list')]//i");
	private By invoiceTitle = By.name("title");
	private By summaryTab = By.xpath("//label[contains(@for,'summary-tab')]/..//input");
	private By paymentTab = By.xpath("//label[contains(@for,'payment-tab')]/..//input");
	private By reviewTab = By.xpath("//label[contains(@for,'review-tab')]/..//input");
	private By donationTab = By.xpath("//label[contains(@for,'donation-tab')]/..//input");
	private By questionTab = By.xpath("//label[contains(@for,'question-tab')]/..//input");
	private By addOnTab = By.xpath("//label[contains(@for,'addon-tab')]/..//input");
	
	private By subtotalLabel = By.xpath("(//div[contains(@class,'common')]//label[contains(@for,'tab-labels')]/..//input)[1]");
	private By amountDueLabel = By.xpath("(//div[contains(@class,'common')]//label[contains(@for,'tab-labels')]/..//input)[2]");
	private By payTodayLabel = By.xpath("(//div[contains(@class,'common')]//label[contains(@for,'tab-labels')]/..//input)[3]");
	
	private By invoiceSummarySection = By.xpath("//a//span[text()='INVOICE SUMMARY']");
	private By paymentSection = By.xpath("//a//span[text()='PAYMENT']");
	private By reviewSection = By.xpath("//a//span[text()='REVIEW']");
	
	private By fieldName = By.xpath("//label[contains(@for,'field-name')]/..//input");
	
	private By lastNameLabel = By.xpath("//input[contains(@id,'payment-surname-lbl')]");
	private By stateLabel = By.xpath("//input[contains(@id,'state-lbl')]");
	private By cityLabel = By.xpath("//input[contains(@id,'city-lbl')]");
	private By zipCode = By.xpath("//input[contains(@id,'zipcode')]");
	
	private By interstitialGear = By.xpath("//td[contains(text(),'Interstitial')]/..//a");
	private By homePageGear = By.xpath("//td[contains(text(),'Home')]/..//a");
	private By changePasswordGear = By.xpath("//td[contains(text(),'Change')]/..//a");
	private By resetPasswordGear = By.xpath("//td[contains(text(),'Reset')]/..//a");
	private By claimTicketGear = By.xpath("//td[contains(text(),'Claim')]/..//a");
	
	private By toggle = By.xpath("(//input[@class='iom-checkbox-ajax form-checkbox iom-processed'])[1]/..//span");
	private By submit = By.xpath("//button[text()='Submit']| //button[@type='submit' and text()='Save']");
	
	private By createAccountInput = By.xpath("//input[@id='edit-settings-userentry-signup-title-label']");
	private By signUpInput = By.xpath("//input[@id='edit-settings-userentry-signup-submit-btn-label']");
	private By firstInput = By.xpath("//input[@id='edit-settings-userentry-signup-first-name-label']");
	private By lastInput = By.xpath("//input[@id='edit-settings-userentry-signup-last-name-label']");
	private By signUpEmail = By.xpath("//input[@id='edit-settings-userentry-signup-email-label']");
	private By signUpPassword = By.xpath("//input[@id='edit-settings-userentry-signup-password-label']");
	private By signUpRemember = By.xpath("//input[@id='edit-settings-userentry-signup-remember-me-label']");
	
	private By signInTab = By.xpath("//a[@aria-controls='signin']");
	private By signInHeader = By.xpath("//input[@id='edit-settings-userentry-signin-title-label']");
	private By signInButtonText = By.xpath("//input[@id='edit-settings-userentry-signin-submit-btn-label']");
	private By signInEmail = By.xpath("//input[@id='edit-settings-userentry-signin-email-label']");
	private By signInPassword = By.xpath("//input[@id='edit-settings-userentry-signin-password-label']");
	private By signInRemember = By.xpath("//input[@id='edit-settings-userentry-signin-remember-me-label']");
	
	private By forgotPassword = By.xpath("//a[@aria-controls='forgotpassword']");
	private By forgotPasswordHeader = By.xpath("//input[@id='edit-settings-userentry-forgotpassword-title-label']");
	private By forgotPasswordButtonText = By.xpath("//input[@id='edit-settings-userentry-forgotpassword-submit-btn-label']");
	private By forgotPasswordDescription = By.xpath("//input[@id='edit-settings-userentry-forgotpassword-description-label']");
	private By forgotPasswordEmail = By.xpath("//input[@id='edit-settings-userentry-forgotpassword-email-label']");
	
	private By interstitialSaveCMS = By.xpath("//button[@type='submit']");
	
	private By changePasswordTitle = By.xpath("//input[@id='edit-settings-userentry-resetpassword-title-label']");
	private By changePasswordSubmitText = By.xpath("//input[@id='edit-settings-userentry-resetpassword-submit-btn-label']");
	private By changePasswordCurrentPassword = By.xpath("//input[@id='edit-settings-userentry-resetpassword-temp-pass-label']");
	private By changePasswordNewPassword = By.xpath("//input[@id='edit-settings-userentry-resetpassword-password-label']");
	private By changePasswordConfirmPassword = By.xpath("//input[@id='edit-settings-userentry-resetpassword-confirm-pass-label']");
	private By invokeAccount = By.xpath("//a[@class='invokeAccount']");
	
	private By signInTitleUI = By.xpath("//div[contains(@class,'componentTitle')]");
	private By signInEmailUI = By.xpath("//input[contains(@type,'email')]/..//label");
	private By signInPasswordUI = By.xpath("//input[contains(@type,'password')]/..//label");
	private By signInSignInButtonUI = By.xpath("//button[contains(@type,'submit')]");
	private By signInRememberUI = By.xpath("//input[contains(@name,'remember_me')]/..//span");
	
	private By signUpLink = By.xpath("//a[@href='/signup']");
	private By forgotPasswordLink = By.xpath("//a[@href='/forgot']");
	private By backToSignInLink = By.xpath("//a[@href='/']");
	
	private By firstNameSignUpUI = By.xpath("//input[contains(@name,'first_name')]/..//label");
	private By lastNameSignUpUI = By.xpath("//input[contains(@name,'last_name')]/..//label");
	private By componentSubHeading = By.xpath("//div[contains(@class,'componentSubHeading')]");
	
	// CMS - settings 
	public By cmssetting = By.xpath("//*[@id=\"block-editornavigation\"]/ul/li[6]/a/p");
	public By dashboardconfig = By.xpath("//*[@id=\"editor-navigation--6-1\"]/li[1]/a/p");
	
	//cms- manage ticket dash board header elements...cleaning this method2
	public By welcomelabel=By.xpath("//*[@id=\"edit-manage-dashboard-manage-ticket-dashboard-header-welcome-label-label\"]");
	public By accountidlabel=By.xpath("//*[@id=\"edit-manage-dashboard-manage-ticket-dashboard-header-account-id-label-label\"]");
	public By clientnamelabel=By.xpath("//*[@id=\"edit-manage-dashboard-manage-ticket-dashboard-header-team-name-label\"]");
	public By manageticketlabel= By.xpath("//*[@id=\"edit-manage-dashboard-manage-ticket-dashboard-header-manage-ticket-label-label\"]");
	public By totalticketslabel= By.xpath("//*[@id=\"edit-manage-dashboard-manage-ticket-dashboard-header-ticket-total-label-label\"]");
	public By accountbalancelabel=By.xpath("//*[@id=\"edit-manage-dashboard-manage-ticket-dashboard-header-account-balance-label-label\"]");
	public By outstandinginvoiceslabel=By.xpath("//*[@id=\"edit-manage-dashboard-manage-ticket-dashboard-header-outstanding-invoice-label-label\"]");
	
	public By dashboardconfigsave=By.id("edit-submit");
	
	//cms- manage ticket 
	public By ticketlabel=By.xpath("//*[@id=\"edit-manage-dashboard-manage-tickets-ticket-label-label\"]");

	//cms - manage invoices
	public By invoicelabel= By.xpath("//*[@id=\"edit-manage-dashboard-manage-invoices-invoice-label-label\"]");
	
	//cms - quicklinkslabel
	public By quicklinkslabels=By.xpath("//*[@id=\"edit-manage-dashboard-manage-quick-links-quick-link-label-label\"]");
	
	//frontend dashboard locators
	public By f_welcome=By.xpath("//*[@id=\"block-manage-ticket-dashboard-header-block\"]/div/div/div[1]/div/div[1]/p[1]");
	public By f_accountid=By.xpath("//*[@id=\"block-manage-ticket-dashboard-header-block\"]/div/div/div[1]/div/div[1]/p[2]");
	public By f_clientname=By.xpath("//*[@id=\"block-manage-ticket-dashboard-header-block\"]/div/div/div[1]/div/div[1]/h3/span");
	
	public By f_accountbalance=By.xpath("//*[@id=\"block-manage-ticket-dashboard-header-block\"]/div/div/div[1]/div/div[3]/p[1]");
	public By f_outstandinginvoices=By.xpath("//*[@id=\"block-manage-ticket-dashboard-header-block\"]/div/div/div[1]/div/div[3]/p[2]/a");
	public By f_ticket=By.xpath("//*[@id=\"block-manage-ticket-dashboard-block\"]/div/div[1]/div/div[1]/h3");
	public By f_manageinvoice= By.xpath("//*[@id=\"block-invoicedashboardblock\"]/div/div[1]/div/div[1]/h3");
	public By f_quicklinks=By.xpath("//*[@id=\"block-views-block-promo-tile-block-3\"]/h2");
	public By f_logedin=By.xpath("//*[@id=\"block-userentrycomponentblock\"]/div/div/div/div/form/div[4]");
	
	private By changePasswordCurrentVerify = By.xpath("//input[@name='temp_pass']/..//label");
	private By changePasswordNewVerify = By.xpath("//input[@name='password']/..//label");
	private By changePasswordConfirmVerify = By.xpath("//input[@name='confirm_pass']/..//label");
	private By changePasswordSubmitVerify = By.xpath("//button[@type='submit']");
	
	public By typeformworkspaceid = By.cssSelector("input[name*='typeform_workspace_id'][id*='edit-typeform-workspace-id']");
	public By saveconfigurationid = By.id("edit-submit");
	public By enabletypeformcheckbox = By.cssSelector("span[class*='check']");
	private By invoice_active = By.cssSelector("div[class*='togglebutton'] label[class*='toggle-color']");
	public By checkbox = By.cssSelector("input[checked*='checked']");
	
	//edp implemetation
	public By edptoggle = By.xpath("//label[@title='Enable this to list View EDP UI']//span[@class='toggle']");
	
	//secure barcode Implementation
	public By secureBarcode = By.xpath("//label[@title='Enable this to show Secure Barcode (Rotating Barcode)']//span[@class='toggle']");
	
	public String cmsuser="//*[@id=\"block-iom-admin-account-menu\"]/div/div/div[2]/i";
	public String cmslogout="//*[@id=\"amgr-user-menu\"]/li[2]/a";
	public String flogin="//*[@id=\"invoke-signin-modal\"]";
	
	//typeform locators
	public String superadminsetup = "//*[@id=\"block-editornavigation\"]/ul/li[8]/a/p";
	public String cmstypeform= "//*[@id=\"editor-navigation--8-1\"]/li[3]/a/p";
	public String work_space="cfER3z";

	public String cmsinvoice ="//*[@id=\"block-editornavigation\"]/ul/li[5]/a/p";
	public String viewinvoice="//*[@id=\"editor-navigation--5-1\"]/li[1]/a/p";
	public String invoicesetting="//*[@id=\"search_default\"]/tbody/tr/td[7]/span/a/i";
	public String questions="//*[@id=\"add-invoices\"]/div[3]/div/ul/li[7]/a";
	public String selecttypeform="openPopup";
	public String type_save="typeform-accepted";
	public String typeform_submit="edit-submit";
	
	public String cmstoggle="//*[@id=\"search_default\"]/tbody/tr/td[6]/div/label/span";
	String firsttypeform="//*[@id=\"typeform-list\"]/div/div/div[2]/div[2]/div[1]/div[2]/a";
	
	
	public String fname="email";
	public String fpwd="password";

	public String f_manageticket="";
	public String f_totalticket="";
	
	//declare cms variables dashboard config page 
	public String welcome = "welcome_custom"; 
	public String accountid = "accountid_custom";
	public String clientname = "clientname_custom";
	public String manageticket ="manageticket_custom"; 
	public String totaltickets = "tickets_custom";
	public String accountbalance = "accountbalance_custom";
	public String outstandinginvoices="outstandinginvoices_custom";
	
	public String ticket="ticket_cistom";
	public String manageinvoice="manageinvoice_custom";
	public String quicklinks="quicklinks_custom";
	
	boolean allowMultipleSubmission=true;
	String showAfter="Invoice Summary";
	String payment="Payment";
	
	public String invoiceName = "Invoice Test";
	public String invoiceSummaryMessage = "Test Invoice Summary";
	public String invoiceReviewMessage = "Test Review";
	public String summaryName = "AutoSummary";
	public String paymentName = "AutoPayment";
	public String reviewName = "AutoReview";
	public String donationName = "AutoName";
	public String addOnName = "AutoAddOn";
	public String questionName = "AutoQuestions";
	public String subtotalName = "AutoSubtotal";
	public String amountDueName = "AutoAmountDue";
	public String paytodayName = "AutoPayToday";
	public String fieldNameAuto = "AutoFieldName";
	public String lastName = "AutoLast";
	public String state = "AutoState";
	public String city = "AutoCity";
	public String zip = "AutoZip";
	public String createHeaderText = "AutoCreate";
	public String signUpText = "AutoSignUp";
	public String firstNameSignUpText = "AutoFirstSignUp";
	public String lastNameSignUpText = "AutoLastSignUp";
	public String emailSignUp = "AutoEmailSignUp";
	public String passwordSignUp = "AutoPasswordSignUp";
	public String rememberSignUp = "AutoRememberSignUp";
	
	public String signInText = "AutoSignInText";
	public String signInButton = "AutoSignInButton";
	public String signInEmailText = "AutoEmailSignIn";
	public String signInPasswordText = "AutoPasswordSignIn";
	public String signInRememberText = "AutoRememberSignIn";
	
	public String forgotPasswordHeaderText = "AutoForgotText";
	public String forgotPasswordButton = "AutoForgotButton";
	public String forgotPasswordDescriptionText = "AutoForgotDescription";
	public String forgotPasswordEmailText = "AutoForgotEmail";
	
	public String signInTextHome = "AutoSignInTextHome";
	public String signInButtonHome = "AutoSignInButtonHome";
	public String signInEmailTextHome = "AutoEmailSignInHome";
	public String signInPasswordTextHome = "AutoPasswordSignInHome";
	public String signInRememberTextHome = "AutoRememberSignInHome";
	
	public String forgotPasswordHeaderTextHome = "AutoForgotTextHome";
	public String forgotPasswordButtonHome = "AutoForgotButtonHome";
	public String forgotPasswordDescriptionTextHome = "AutoForgotDescriptionHome";
	public String forgotPasswordEmailTextHome = "AutoForgotEmailHome";
	
	public String createHeaderTextHome = "AutoCreateHome";
	public String signUpTextHome = "AutoSignUpHome";
	public String firstNameSignUpTextHome = "AutoFirstSignUpHome";
	public String lastNameSignUpTextHome = "AutoLastSignUpHome";
	public String emailSignUpHome = "AutoEmailSignUpHome";
	public String passwordSignUpHome = "AutoPasswordSignUpHome";
	public String rememberSignUpHome = "AutoRememberSignUpHome";
	
	public String createHeaderTextClaim = "AutoCreateClaim";
	public String signUpTextClaim = "AutoSignUpClaim";
	public String firstNameSignUpTextClaim = "AutoFirstSignUpClaim";
	public String lastNameSignUpTextClaim = "AutoLastSignUpClaim";
	public String emailSignUpClaim = "AutoEmailSignUpClaim";
	public String passwordSignUpClaim = "AutoPasswordSignUpClaim";
	public String rememberSignUpClaim = "AutoRememberSignUpClaim";
	
	public String signInTextClaim = "AutoSignInTextClaim";
	public String signInButtonClaim = "AutoSignInButtonClaim";
	public String signInEmailTextClaim = "AutoEmailSignInClaim";
	public String signInPasswordTextClaim = "AutoPasswordSignInClaim";
	public String signInRememberTextClaim = "AutoRememberSignInClaim";
	
	public String forgotPasswordHeaderTextClaim = "AutoForgotTextClaim";
	public String forgotPasswordButtonClaim = "AutoForgotButtonClaim";
	public String forgotPasswordDescriptionTextClaim = "AutoForgotDescriptionClaim";
	public String forgotPasswordEmailTextClaim = "AutoForgotEmailClaim";
	
	public String changePasswordTitleText = "AutoChangePasswordTitle";
	public String changePasswordSubmitButtonText = "AutoChangePasswordSubmit";
	public String changePasswordCurrentPasswordText = "AutoChangePasswordCurrent";
	public String changePasswordNewPasswordText = "AutoChangePasswordNew";
	public String changePasswordConfirmPasswordText = "AutoChangePasswordConfirm";
	
	
	
	public Utils utils;
	
	//typeform selected under review tab
		public void typeform_selection_payment() throws InterruptedException
		{
			WebDriverWait wait= new WebDriverWait(getDriver(), 20);
			JavascriptExecutor ex = (JavascriptExecutor)getDriver();
			WebElement active_toggle=getDriver().findElement(By.xpath(cmstoggle));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cmstoggle)));
			
			if(!checkIfElementPresent(invoice_active, 5))
			{
				active_toggle.click();
			
			}
			
			utils = new Utils(driverFactory, Dictionary, Environment, Reporter, Assert, SoftAssert, sTestDetails);
			utils.navigateTo("/admin/invoice/1/edit?destination=admin/invoice/list");	
			ex.executeScript("history.go(0)");
			
			WebElement questiontab=getDriver().findElement(By.xpath(questions));
			questiontab.click();
		
		
			By save = By.id("typeform-accepted");
			By dropDown = By.cssSelector("div[class*='typeform'] input[class*='select-dropdown']");
			
			if(checkIfElementPresent(selecttext, 3))
			{
				try {
							
				By questionsTab = By.xpath(".//span[text()='QUESTIONS']");
				By embedTypeform = By.xpath(".//*[@id='openPopup']/span[text()='EMBED TYPEFORM'] | .//*[@id='openPopup']/span[text()='SELECT TYPEFORM']");
				//
				ex.executeScript("arguments[0].click();", getDriver().findElement(questionsTab));
				
				if(checkIfElementPresent(embedTypeform))
				
				{
					WebElement we = getElementWhenVisible(embedTypeform);
					click(we, "Select Typeform");
					By typeform_automation = By.cssSelector("a[title='Automation']");
					WebElement wtypeform_automation = getElementWhenVisible(typeform_automation);
					scrollingToElementofAPage(wtypeform_automation); //scrolling not working
					wtypeform_automation.click();

					ex.executeScript("arguments[0].click();", getDriver().findElement(save));
				
				}
				
				WebElement wdropDown = getElementWhenRefreshed(dropDown, "disabled", "null", 2);
				
				//controlling position of typeform for client
				if(wdropDown.getAttribute("value").trim().equalsIgnoreCase(showAfter.trim())) {

					ex.executeScript("arguments[0].click();", wdropDown);
					By locator = By.xpath(".//div[contains(@class, 'typeform')]//ul//li[2]//span[1]");
					wait.until(ExpectedConditions.elementToBeClickable(locator));
					WebElement pay=getDriver().findElement(locator);
				
					ex.executeScript("arguments[0].click();", pay);
					
				
				}
				
				By allow_multiple_submissions = By.cssSelector("label[for*='typeform-allow-multiple-submission'] input");
				WebElement wallow_multiple_submissions = getDriver().findElement(allow_multiple_submissions);
				
				if(allowMultipleSubmission && wallow_multiple_submissions.getAttribute("checked") == null)
				{
					ex.executeScript("arguments[0].click();", wallow_multiple_submissions);
				} 
				else if(!allowMultipleSubmission && wallow_multiple_submissions.getAttribute("checked") != null) 
				{
					ex.executeScript("arguments[0].click();", wallow_multiple_submissions);
				}
				
				getDriver().findElement(dashboardconfigsave).click();
				ex.executeScript("arguments[0].click();", getDriver().findElement(dashboardconfigsave));
				
				By alert = By.cssSelector("div[role='alert']");
				getElementWhenVisible(alert, 5);
				}
				
				finally {
					
					//getDriver().navigate().to("https://stg1-am.ticketmaster.com/namautomation/user/logout");
					getDriver().navigate().to(Environment.get("APP_URL")+"/user/logout");
					getElementWhenPresent(By.xpath(".//input[@name='email'] | .//div[@class='mobile-signin']//*[text()='Sign In'] | .//div[@class='desktop-signin-dashboard']//a[text()='Sign In']"));
				}
			}
			else
				{
				System.out.println("typeform already selected ... Now changing its poition");
				WebElement wdropDown = getElementWhenRefreshed(dropDown, "disabled", "null", 2);

				if(wdropDown.getAttribute("value").trim().equalsIgnoreCase(showAfter.trim())) {
					ex.executeScript("arguments[0].click();", wdropDown);
					By locator = By.xpath(".//div[contains(@class, 'typeform')]//ul//li[2]//span[1]");
					WebElement pay=getDriver().findElement(locator);
					
					wait.until(ExpectedConditions.elementToBeClickable(locator));
					
					ex.executeScript("arguments[0].click();", pay);
				
					//getDriver().findElement(dashboardconfigsave).click();
					ex.executeScript("arguments[0].click();", getDriver().findElement(dashboardconfigsave));
			
					
				}
				
				//getDriver().navigate().to("https://stg1-am.ticketmaster.com/namautomation/user/logout");
				
				//utils.navigateTo("/user/logout");
				getDriver().navigate().to(Environment.get("APP_URL")+"/user/logout");
				getElementWhenPresent(By.xpath(".//input[@name='email'] | .//div[@class='mobile-signin']//*[text()='Sign In'] | .//div[@class='desktop-signin-dashboard']//a[text()='Sign In']"));
				}
		}
		
	
	
	
		public void verifiesCustomiseDashboard()
		{
	//remove takeover
			((JavascriptExecutor) getDriver()).executeScript("$('.theme-dialog-3SJ5Op').remove()");
			
			Assert.assertTrue(getText(f_welcome).contains(welcome));
			Assert.assertTrue(getText(f_accountid).contains(accountid));
			Assert.assertTrue(getText(f_accountbalance).contains(accountbalance));
			Assert.assertTrue(getText(f_outstandinginvoices).contains(outstandinginvoices));
			Assert.assertTrue(getText(f_ticket).contains(ticket));
			Assert.assertTrue(getText(f_quicklinks).contains(quicklinks));
			Assert.assertTrue(getText(f_manageinvoice).contains(manageinvoice));
				
		}
		
	
	public void ViewDashboardconfig()
	{
	click(cmssetting, "cms setting", 3);
	click(dashboardconfig, "cms Dashboard config", 3);
	}
	
	public void enterManageTicketDashboard()
	{
		getElementWhenClickable(welcomelabel, 3).clear();
		getElementWhenClickable(welcomelabel, 3).sendKeys(welcome);
		
		getElementWhenClickable(accountidlabel, 3).clear();
		getElementWhenClickable(accountidlabel, 3).sendKeys(accountid);
		
		getElementWhenClickable(clientnamelabel, 3).clear();
		getElementWhenClickable(clientnamelabel, 3).sendKeys(clientname);
		
		getElementWhenClickable(manageticketlabel, 3).clear();
		getElementWhenClickable(manageticketlabel, 3).sendKeys(manageticket);
		
		getElementWhenClickable(totalticketslabel, 3).clear();
		getElementWhenClickable(totalticketslabel, 3).sendKeys(totaltickets);

		getElementWhenClickable(accountbalancelabel, 3).clear();
		getElementWhenClickable(accountbalancelabel, 3).sendKeys(accountbalance);
		
		getElementWhenClickable(outstandinginvoiceslabel, 3).clear();
		getElementWhenClickable(outstandinginvoiceslabel, 3).sendKeys(outstandinginvoices);
	}
	
	
	public void EnterTicketLabel()
	{

		getElementWhenClickable(ticketlabel, 3).clear();
		getElementWhenClickable(ticketlabel, 3).sendKeys(ticket);
	}
	
	public void EnterInvoiceLabel()
	{

		getElementWhenClickable(invoicelabel, 3).clear();
		getElementWhenClickable(invoicelabel, 3).sendKeys(manageinvoice);
	}
	
	public void EnterQuickLinkLabel()
	{

		getElementWhenClickable(quicklinkslabels, 3).clear();
		getElementWhenClickable(quicklinkslabels, 3).sendKeys(quicklinks);
	}
	
	public void DashboardConfigSaveButton()
	{
		getElementWhenClickable(dashboardconfigsave, 3).click();
		
	}
	
	
	//enable typeform via cms and configured its work space if not already
	
	public void verifiestypeformadminsetup()
	{	
			try {
				if(checkIfElementPresent(checkbox, 2)==false)
				{
					click(enabletypeformcheckbox, "enable typeform", 2);
				
					click(saveconfigurationid, "Save Configuration",2);	
				}
				
				if(getDriver().findElement(typeformworkspaceid).getAttribute("typeform_workspace_id")=="" || getDriver().findElement(typeformworkspaceid).getAttribute("typeform_workspace_id")==null)
				{
					getDriver().findElement(typeformworkspaceid).clear();	
				type(typeformworkspaceid, "workspaceid", "cfER3z", 2);
				click(saveconfigurationid, "Save Configuration",2);	
				}
			
			    } 
			catch (Exception e) {
				e.printStackTrace();
								}
			finally
			{
				click(saveconfigurationid, "Save Configuration",2);	
			}
		}
		
	public By selecttext=By.xpath(".//*[@id='openPopup']/span[text()='SELECT TYPEFORM']");

	public void typeform_selection() throws InterruptedException
	{
		WebDriverWait wait= new WebDriverWait(getDriver(), 20);
		JavascriptExecutor ex = (JavascriptExecutor)getDriver();
		WebElement active_toggle=getDriver().findElement(By.xpath(cmstoggle));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cmstoggle)));
		boolean status = false;
		int counter = 3;
		WebElement typeform_summary;
		utils = new Utils(driverFactory, Dictionary, Environment, Reporter, Assert, SoftAssert, sTestDetails);
		By submit = By.id("edit-submit");
		
		
		if(!checkIfElementPresent(invoice_active, 5))
		{
			active_toggle.click();
		
		}
		
		
		utils.navigateTo("/admin/invoice/1/edit?destination=admin/invoice/list");	
		//ex.executeScript("history.go(0)");
		
		WebElement questiontab=getDriver().findElement(By.xpath(questions));
		questiontab.click();
		
		if(checkIfElementPresent(selecttext, 3))
		{
			try {
						
			By questionsTab = By.xpath(".//span[text()='QUESTIONS']");
			By embedTypeform = By.xpath(".//*[@id='openPopup']/span[text()='EMBED TYPEFORM'] | .//*[@id='openPopup']/span[text()='SELECT TYPEFORM']");
			//
			ex.executeScript("arguments[0].click();", getDriver().findElement(questionsTab));
			
			if(checkIfElementPresent(embedTypeform))
			
			{
				WebElement we = getElementWhenVisible(embedTypeform);
				click(we, "Select Typeform");
				
				By typeform_automation = By.cssSelector("a[title='Automation']");
			
				//refreshing typeform	
				do {
					status = checkIfElementPresent(typeform_automation);
					if (!status) {
						getDriver().navigate().refresh();
						sync(500L);
						questiontab.click();
						click(we, "Select Typeform");
						
					}
					counter--;
				} while (counter > 0 && status == false);
				
				
				WebElement wtypeform_automation = getElementWhenVisible(typeform_automation);
				
				scrollingToElementofAPage(wtypeform_automation); //scrolling not working
				wtypeform_automation.click();
				By save = By.id("typeform-accepted");
				ex.executeScript("arguments[0].click();", getDriver().findElement(save));
			
			}
			
			By dropDown = By.cssSelector("div[class*='typeform'] input[class*='select-dropdown']");
			WebElement wdropDown = getElementWhenRefreshed(dropDown, "disabled", "null", 2);
			
			//controlling summary  position of typeform for client 
			if(!wdropDown.getAttribute("value").trim().equalsIgnoreCase(showAfter.trim())) {
				ex.executeScript("arguments[0].click();", wdropDown);
				By locator = By.xpath(".//div[contains(@class, 'typeform')]//ul//li//span[text()='" + showAfter.trim() + "']");
				//ex.executeScript("arguments[0].click();", getDriver().findElement(locator));
				wait.until(ExpectedConditions.elementToBeClickable(locator));
				typeform_summary=getDriver().findElement(locator);
				typeform_summary.click();	
			}
			
			By allow_multiple_submissions = By.cssSelector("label[for*='typeform-allow-multiple-submission'] input");
			WebElement wallow_multiple_submissions = getDriver().findElement(allow_multiple_submissions);
			
			if(allowMultipleSubmission && wallow_multiple_submissions.getAttribute("checked") == null) 
			{
				ex.executeScript("arguments[0].click();", wallow_multiple_submissions);
			} 
			
			else if(!allowMultipleSubmission && wallow_multiple_submissions.getAttribute("checked") != null) {
				ex.executeScript("arguments[0].click();", wallow_multiple_submissions);
			}
			
			ex.executeScript("arguments[0].click();", getDriver().findElement(dashboardconfigsave));
			ex.executeScript("arguments[0].click();", getDriver().findElement(submit));
			
			By alert = By.cssSelector("div[role='alert']");
			getElementWhenVisible(alert, 5);
			}
			
		catch(Exception e)	
			{
			e.printStackTrace();
			}
			
			finally 
			{	
		 	System.out.println("user is getting logs out");
		 	
		 
		 //	getDriver().navigate().to("https://stg1-am.ticketmaster.com/namautomation/user/logout");
			
		 	getDriver().navigate().to(Environment.get("APP_URL")+"/user/logout");
		 	
			getElementWhenPresent(By.xpath(".//input[@name='email'] | .//div[@class='mobile-signin']//*[text()='Sign In'] | .//div[@class='desktop-signin-dashboard']//a[text()='Sign In']"));
			}
		}
		else
			{
			System.out.println("typeform already selected");

			boolean isSelectTypeformDisabled = getElementWhenVisible(By.id(selecttypeform)).getAttribute("class").contains("removesign-button-text");
			if(isSelectTypeformDisabled) {
				WebElement removesign = getElementWhenVisible(By.xpath("//button[@id=\"openPopup\"]/following-sibling::*[contains(@class,'removesign')]"), 2);
				removesign.click();
			}
			
			// click and select type form
			click(getDriver().findElement(By.id(selecttypeform)), "Select Typeform");
			WebElement typeform = getElementWhenClickable(By.xpath("//a[@title='Automation' and @class='typeform_anchor']"), 10);
			typeform.click();
			// Save the Select Typeform
			click(getDriver().findElement(By.xpath("//*[@id=\"typeform-accepted\"]")), "Submit Typeform (Save)");
			
			
			By dropDown = By.cssSelector("div[class*='typeform'] input[class*='select-dropdown']");
			WebElement wdropDown = getElementWhenRefreshed(dropDown, "disabled", "null", 20);
			
			if(!wdropDown.getAttribute("value").trim().equalsIgnoreCase(showAfter.trim())) 
			{
				ex.executeScript("arguments[0].click();", wdropDown);
				By locator = By.xpath(".//div[contains(@class, 'typeform')]//ul//li//span[text()='" + showAfter.trim() + "']");
				//ex.executeScript("arguments[0].click();", getDriver().findElement(locator));
				wait.until(ExpectedConditions.elementToBeClickable(locator));
				typeform_summary=getDriver().findElement(locator);
				typeform_summary.click();
				//ex.executeScript("arguments[0].click();", getDriver().findElement(dashboardconfigsave));
				
				
			}
			ex.executeScript("arguments[0].click();", getDriver().findElement(submit));
			getDriver().navigate().to(Environment.get("APP_URL")+"/user/logout");
			 //	getDriver().navigate().to("https://stg1-am.ticketmaster.com/namautomation/user/logout");
			//utils.navigateTo("/user/logout");
			getElementWhenPresent(By.xpath(".//input[@name='email'] | .//div[@class='mobile-signin']//*[text()='Sign In'] | .//div[@class='desktop-signin-dashboard']//a[text()='Sign In']"));
			
			}
	}
	
	public void clickInvoices() {
		click(invoices,"Invoices");
	}
	
	public void clickAddNewInvoice() {
		click(addNewInvoice,"Add New Invoice");
		((JavascriptExecutor) getDriver()).executeScript("$('.close').trigger('click')");
		getDriver().findElement(invoiceTitle).clear();
		getDriver().findElement(invoiceTitle).sendKeys(invoiceName);
	}
	
	public void clickViewInvoicesClickGear() {
		click(addNewInvoice,"Add New Invoice");
		click(viewInvoices, "View Invoice");
		click(settingGear,"Setting Gear");
	}
	
	public void enterInvoiceTitleAndAllLabels() throws Exception {
		((JavascriptExecutor) getDriver()).executeScript("$('.close').trigger('click')");
		type(summaryTab, "Summary Name", summaryName);
		type(paymentTab, "Payment Name", paymentName);
		type(reviewTab, "Review Name", reviewName);
		type(donationTab, "Donation Name", donationName);
		type(addOnTab, "Add On Name", addOnName);
		type(questionTab, "Question Name", questionName);
		type(subtotalLabel, "Subtotal Name", subtotalName);
		type(amountDueLabel, "Amount Due Name", amountDueName);
		type(payTodayLabel, "Pay Today Name", paytodayName);
	}
	
	public void switchToParentFrame()
	{
		getDriver().switchTo().parentFrame();
	}
	
	public void enterInvoiceSummary() throws Exception {
		click(invoiceSummarySection, "Invoice Summary");
		
		try{
		getDriver().switchTo().frame(0);
		//click(By.xpath("//body"), "Body");
	//	type(invoiceSummaryMessage, "Summary Message", "Test");
		getDriver().findElement(By.xpath("(//*[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders'])[1]")).clear();
		getDriver().findElement(By.xpath("(//*[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders'])[1]")).sendKeys(invoiceSummaryMessage);
		switchToParentFrame();
		}
		catch(Exception E)
		{
			switchToParentFrame();
			getDriver().findElement(By.xpath("(//textarea)[1]")).clear();
			type(By.xpath("(//textarea)[1]"), "Invoice Summary Message", invoiceSummaryMessage);
		}
		type(fieldName, "Field Name", fieldNameAuto);
	}
	
	public void enterPaymentDetails() throws Exception {
		click(paymentSection, "Payment Tab");
		type(lastNameLabel, "Last Name", lastName);
		type(stateLabel, "Sur Name", state);
		type(cityLabel, "City Label", city);
		type(zipCode, "Zip Code", zip);
	}
	
	public void enterReviewDetailsAndClickSubmit() throws Exception {
		click(reviewSection,"Review Tab");
		try{getDriver().switchTo().frame(3);
		getDriver().findElement(By.xpath("(//*[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders'])[1]")).clear();
		getDriver().findElement(By.xpath("(//*[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders'])[1]")).sendKeys(invoiceReviewMessage);
		switchToParentFrame();}
		catch(Exception E)
		{
			switchToParentFrame();
			getDriver().findElement(By.xpath("(//textarea)[4]")).clear();
			type(By.xpath("(//textarea)[4]"), "Review Message", invoiceReviewMessage);
		}
		click(submit, "Submit");
		//click(toggle, "Disable Default Invoice");
		System.out.println();
	}
	
	public void clickSettingAndSignInComponent() {
		click(setting, "Setting");
		click(signInComponent,"Sign In Componenet");
	}
	
	public void enterCreateAccountInterstitialDetails() throws Exception {
		click(interstitialGear, "Interstitial Setting");
		((JavascriptExecutor) getDriver()).executeScript("$('.close').trigger('click')");
		type(createAccountInput, "create account", createHeaderText);
		type(signUpInput, "Sign Up Text", signUpText);
		type(firstInput, "First name", firstNameSignUpText);
		getDriver().findElement(lastInput).clear();
		getDriver().findElement(lastInput).sendKeys(lastNameSignUpText);
		//type(lastInput, "Last name", lastNameSignUpText);
		type(signUpEmail, "Sign Up Email", emailSignUp);
		type(signUpPassword, "Sign Up Password", passwordSignUp);
		type(signUpRemember, "Sign Up Remember", rememberSignUp);
	}
	
	public void enterSignInInterstitialDetails() throws Exception {
		click(signInTab, "Sign In");
		((JavascriptExecutor) getDriver()).executeScript("$('.close').trigger('click')");
		getDriver().findElement(signInHeader).clear();
		getDriver().findElement(signInHeader).sendKeys(signInText);
		//type(signInHeader, "Sign In Text", signInText);
		type(signInButtonText, "Sign In Button Text", signInButton);
		type(signInEmail, "Sign In Email Text", signInEmailText);
		type(signInPassword, "Sign In Password Text", signInPasswordText);
		type(signInRemember, "Sign In Remember Me Text", signInRememberText);
	}
	
	public void enterForgetPasswordInterstitialDetailsAndSubmit() throws Exception {
		click(forgotPassword, "Forget Password");
		type(forgotPasswordHeader, "Forget Password Text", forgotPasswordHeaderText);
		type(forgotPasswordButtonText, "Forget Password Button Text", forgotPasswordButton);
		type(forgotPasswordDescription, "Forget Password Description", forgotPasswordDescriptionText);
		type(forgotPasswordEmail, "Forget Password Email", forgotPasswordEmailText);
		click(interstitialSaveCMS, "Submit");
	}
	
	public void enterCreateAccountHomePageDetails() throws Exception {
		click(homePageGear, "HomePage Setting");
		type(createAccountInput, "create account", createHeaderTextHome);
		type(signUpInput, "Sign Up Text", signUpTextHome);
		type(firstInput, "First name", firstNameSignUpTextHome);
		getDriver().findElement(lastInput).clear();
		getDriver().findElement(lastInput).sendKeys(lastNameSignUpTextHome);
		//type(lastInput, "Last name", lastNameSignUpTextHome);
		type(signUpEmail, "Sign Up Email", emailSignUpHome);
		type(signUpPassword, "Sign Up Password", passwordSignUpHome);
		type(signUpRemember, "Sign Up Remember", rememberSignUpHome);
	}
	
	public void enterSignInHomePageDetails() throws Exception {
		click(signInTab, "Sign In");
		((JavascriptExecutor) getDriver()).executeScript("$('.close').trigger('click')");
		getDriver().findElement(signInHeader).clear();
		getDriver().findElement(signInHeader).sendKeys(signInTextHome);
		//type(signInHeader, "Sign In Text", signInTextHome);
		type(signInButtonText, "Sign In Button Text", signInButtonHome);
		type(signInEmail, "Sign In Email Text", signInEmailTextHome);
		type(signInPassword, "Sign In Password Text", signInPasswordTextHome);
		type(signInRemember, "Sign In Remember Me Text", signInRememberTextHome);
	}
	
	public void enterForgetPasswordHomePageDetailsAndSubmit() throws Exception {
		click(forgotPassword, "Forget Password");
		type(forgotPasswordHeader, "Forget Password Text", forgotPasswordHeaderTextHome);
		type(forgotPasswordButtonText, "Forget Password Button Text", forgotPasswordButtonHome);
		type(forgotPasswordDescription, "Forget Password Description", forgotPasswordDescriptionTextHome);
		type(forgotPasswordEmail, "Forget Password Email", forgotPasswordEmailTextHome);
		click(interstitialSaveCMS, "Submit");
	}
	
	public void enterCreateAccountClaimDetails() throws Exception {
		click(claimTicketGear, "Claim Setting");
		type(createAccountInput, "create account", createHeaderTextClaim);
		type(signUpInput, "Sign Up Text", signUpTextClaim);
		type(firstInput, "First name", firstNameSignUpTextClaim);
		getDriver().findElement(lastInput).clear();
		getDriver().findElement(lastInput).sendKeys(lastNameSignUpTextClaim);
		//type(lastInput, "Last name", lastNameSignUpTextClaim);
		type(signUpEmail, "Sign Up Email", emailSignUpClaim);
		type(signUpPassword, "Sign Up Password", passwordSignUpClaim);
		type(signUpRemember, "Sign Up Remember", rememberSignUpClaim);
	}
	
	public void enterSignInClaimDetails() throws Exception {
		click(signInTab, "Sign In");
		((JavascriptExecutor) getDriver()).executeScript("$('.close').trigger('click')");
		getDriver().findElement(signInHeader).clear();
		getDriver().findElement(signInHeader).sendKeys(signInTextClaim);
		//type(signInHeader, "Sign In Text", signInTextClaim);
		type(signInButtonText, "Sign In Button Text", signInButtonClaim);
		type(signInEmail, "Sign In Email Text", signInEmailTextClaim);
		type(signInPassword, "Sign In Password Text", signInPasswordTextClaim);
		type(signInRemember, "Sign In Remember Me Text", signInRememberTextClaim);
	}
	
	public void enterForgetPasswordClaimDetailsAndSubmit() throws Exception {
		click(forgotPassword, "Forget Password");
		type(forgotPasswordHeader, "Forget Password Text", forgotPasswordHeaderTextClaim);
		type(forgotPasswordButtonText, "Forget Password Button Text", forgotPasswordButtonClaim);
		type(forgotPasswordDescription, "Forget Password Description", forgotPasswordDescriptionTextClaim);
		type(forgotPasswordEmail, "Forget Password Email", forgotPasswordEmailTextClaim);
		click(interstitialSaveCMS, "Submit");
	}
	
	public void enterChangePasswordDetailsAndSubmit() throws Exception {
		click(changePasswordGear, "Change Password");
		type(changePasswordTitle, "Change Password Text", changePasswordTitleText);
		type(changePasswordSubmitText, "Change Password Submit Text", changePasswordSubmitButtonText);
		type(changePasswordCurrentPassword, "Change Password Current Password", changePasswordCurrentPasswordText);
		type(changePasswordNewPassword, "Change Password New Password", changePasswordNewPasswordText);
		type(changePasswordConfirmPassword, "Change Password Confirm Password", changePasswordConfirmPasswordText);
		click(interstitialSaveCMS, "Submit");
	}
	
	public void verifyHomePageSignInLabel() throws Exception {
		click(invokeAccount, "Invoke Account");
		Assert.assertTrue(getText(signInTitleUI).contains(signInTextHome));
		Assert.assertTrue(getText(signInEmailUI).contains(signInEmailTextHome));
		Assert.assertTrue(getText(signInPasswordUI).contains(signInPasswordTextHome));
		Assert.assertTrue(getText(signInSignInButtonUI).contains(signInButtonHome));
		Assert.assertTrue(getText(signInRememberUI).contains(signInRememberTextHome));
	}
	
	public void verifyInterstitialSignInLabel() throws Exception {
		Assert.assertTrue(getText(signInTitleUI).contains(signInText));
		Assert.assertTrue(getText(signInEmailUI).contains(signInEmailText));
		Assert.assertTrue(getText(signInPasswordUI).contains(signInPasswordText));
		Assert.assertTrue(getText(signInSignInButtonUI).contains(signInButton));
		Assert.assertTrue(getText(signInRememberUI).contains(signInRememberText));
	}
	
	public void verifyClaimSignInLabel() throws Exception {
		Assert.assertTrue(getText(signInTitleUI).contains(signInTextClaim));
		Assert.assertTrue(getText(signInEmailUI).contains(signInEmailTextClaim));
		Assert.assertTrue(getText(signInPasswordUI).contains(signInPasswordTextClaim));
		Assert.assertTrue(getText(signInSignInButtonUI).contains(signInButtonClaim));
		Assert.assertTrue(getText(signInRememberUI).contains(signInRememberTextClaim));
	}
	
	public void verifyHomePageSignUpLabel() throws Exception {
		click(signUpLink, "Click Here");
		Assert.assertTrue(getText(signInTitleUI).contains(createHeaderTextHome));
		Assert.assertTrue(getText(signInEmailUI).contains(emailSignUpHome));
		Assert.assertTrue(getText(signInPasswordUI).contains(passwordSignUpHome));
		Assert.assertTrue(getText(signInSignInButtonUI).contains(signUpTextHome));
		Assert.assertTrue(getText(firstNameSignUpUI).contains(firstNameSignUpTextHome));
		System.out.println(getText(lastNameSignUpUI));
		System.out.println(lastNameSignUpTextHome);
		Assert.assertTrue(getText(lastNameSignUpUI).contains(lastNameSignUpTextHome));
		click(backToSignInLink, "Click Here");
	}
	
	public void verifyInterstitialSignUpLabel() throws Exception {
		click(signUpLink, "Click Here");
		Assert.assertTrue(getText(signInTitleUI).contains(createHeaderText));
		Assert.assertTrue(getText(signInEmailUI).contains(emailSignUp));
		Assert.assertTrue(getText(signInPasswordUI).contains(passwordSignUp));
		Assert.assertTrue(getText(signInSignInButtonUI).contains(signUpText));
		Assert.assertTrue(getText(firstNameSignUpUI).contains(firstNameSignUpText));
		Assert.assertTrue(getText(lastNameSignUpUI).contains(lastNameSignUpText));
		click(backToSignInLink, "Click Here");
	}
	
	public void verifyClaimSignUpLabel() throws Exception {
		click(signUpLink, "Click Here");
		Assert.assertTrue(getText(signInTitleUI).contains(createHeaderTextClaim));
		Assert.assertTrue(getText(signInEmailUI).contains(emailSignUpClaim));
		Assert.assertTrue(getText(signInPasswordUI).contains(passwordSignUpClaim));
		Assert.assertTrue(getText(signInSignInButtonUI).contains(signUpTextClaim));
		Assert.assertTrue(getText(firstNameSignUpUI).contains(firstNameSignUpTextClaim));
		Assert.assertTrue(getText(lastNameSignUpUI).contains(lastNameSignUpTextClaim));
		click(backToSignInLink, "Click Here");
	}
	
	public void verifyHomePageForgotPasswordLabel() throws Exception {
		click(invokeAccount, "Invoke Account");
		click(forgotPasswordLink, "Forgot Password");
		Assert.assertTrue(getText(signInTitleUI).contains(forgotPasswordHeaderTextHome));
		Assert.assertTrue(getText(signInEmailUI).contains(forgotPasswordEmailTextHome));
		Assert.assertTrue(getText(signInSignInButtonUI).contains(forgotPasswordButtonHome));
		Assert.assertTrue(getText(componentSubHeading).contains(forgotPasswordDescriptionTextHome));
	}
	
	public void verifyInterstitialForgotPasswordLabel() throws Exception {
		click(forgotPasswordLink, "Forgot Password");
		Assert.assertTrue(getText(signInTitleUI).contains(forgotPasswordHeaderText));
		Assert.assertTrue(getText(signInEmailUI).contains(forgotPasswordEmailText));
		Assert.assertTrue(getText(signInSignInButtonUI).contains(forgotPasswordButton));
		Assert.assertTrue(getText(componentSubHeading).contains(forgotPasswordDescriptionText));
	}
	
	public void verifyClaimForgotPasswordLabel() throws Exception {
		click(forgotPasswordLink, "Forgot Password");
		Assert.assertTrue(getText(signInTitleUI).contains(forgotPasswordHeaderTextClaim));
		Assert.assertTrue(getText(signInEmailUI).contains(forgotPasswordEmailTextClaim));
		Assert.assertTrue(getText(signInSignInButtonUI).contains(forgotPasswordButtonClaim));
		Assert.assertTrue(getText(componentSubHeading).contains(forgotPasswordDescriptionTextClaim));
	}
	
	public void verifyChangePasswordLabels() throws Exception {
		Assert.assertTrue(getText(signInTitleUI).contains(changePasswordTitleText));
		Assert.assertTrue(getText(changePasswordCurrentVerify).contains(changePasswordCurrentPasswordText));
		Assert.assertTrue(getText(changePasswordNewVerify).contains(changePasswordNewPasswordText));
		Assert.assertTrue(getText(changePasswordConfirmVerify).contains(changePasswordConfirmPasswordText));
		Assert.assertTrue(getText(changePasswordSubmitVerify).contains(changePasswordSubmitButtonText));
	}

	public void enableBulk() {
		click(ticketmanagement, "TICKET MANAGEMENT");
		click(ticketoptions, "TICKET OPTIONS");
		click(bulktoggle,"BULK TOGGLE");
		click(editsubmit,"SUBMIT changes");
	}

	public boolean checkBulkEnabled() {
		try {
			long value =  (long)((JavascriptExecutor)this.getDriver()).executeScript("return drupalSettings.componentConfigData.siteconfig.manage_ticket_configuration.bulk_transfer_enabled");
			if(value==1)
				return true;
		} catch (WebDriverException var5) {
			var5.getMessage();
		}
		return false;
	}

	public boolean checkenableSecureBarcode() {
		try {
			long value =  (long)((JavascriptExecutor)this.getDriver()).executeScript("return window.drupalSettings.componentConfigData.siteconfig.manage_ticket_configuration.secure_barcode_enabled");
			if(value==1)
				return true;
		} catch (WebDriverException var5) {
			var5.getMessage();
		}
		return false;
	}
	
	public boolean checkQDEnabled() {
		try {
			long value =  (long)((JavascriptExecutor)this.getDriver()).executeScript("return drupalSettings.componentConfigData.siteconfig.manage_ticket_configuration.donate");
			if(value==1)
				return true;
		} catch (WebDriverException var5) {
			var5.getMessage();
		}
		return false;
	}
	
	public boolean checkenableEDP() {
		try {
			long value =  (long)((JavascriptExecutor)this.getDriver()).executeScript("return window.drupalSettings.componentConfigData.siteconfig.manage_ticket_configuration.eventslistView");
			if(value==1)
				return true;
		} catch (WebDriverException var5) {
			var5.getMessage();
		}
		return false;
	}
	
	public void enableQD() {
		click(donation, "DONATION");
		click(quickdonation, "Quick Donation");
		if(!checkIfElementPresent(quickdonationenabled,5))
			click(quickdonationenablecb,"Quick Donation CB");
		click(editsubmit,"SUBMIT changes");
	}
	
	public void clickAddPageButton() {
		click(pagemanager,"Page Manager",5);
		click(addpage, "Add Page",5);
		Assert.assertTrue(getDriver().getCurrentUrl().contains("page-manager"));
	}
	public void selectHomePageButton() {
		click(selectbutton,"Select",5);
		Assert.assertTrue(getText(ticketsalesverification).contains("Ticket Sales"));
		Assert.assertTrue(getDriver().getCurrentUrl().contains("hybrid_home_page"));
	}

	public void verifyTicketsSalespage() {
		Assert.assertTrue(getText(ticketsalestext).contains("Ticket Sales layouts are designed around ticket on-sales including new season tickets"));
		List<WebElement> element = getDriver().findElements(formpresent);
		for(int i=1; i<=element.size();i++) {
	    	  By form = By.xpath("//div[@id='edit-ticket-sales']/div["+i+"]/label//div[2]");	
	    	  Assert.assertTrue((getText(form, 0)!=""),getText(form, 0));
	      }
	}  
	
	
	public void enableEDP() {
		click(ticketmanagement, "TICKET MANAGEMENT");
		click(ticketoptions, "TICKET OPTIONS");
		click(edptoggle,"EDP TOGGLE");
		click(editsubmit,"SUBMIT changes");
	}
	
	public void enableSecureBarcode() {
		click(ticketmanagement, "TICKET MANAGEMENT");
		click(ticketoptions, "TICKET OPTIONS");
		click(secureBarcode,"Secure Barcode TOGGLE");
		click(editsubmit,"SUBMIT changes");
	}
	
	public String versionUI() {
	  return	getText(buildtext, 2);
	}
	
	public String versionAPI() {
		try {
			String value =  (String)((JavascriptExecutor)this.getDriver()).executeScript("return window.drupalSettings.componentConfigData.siteconfig.version");
				return value;
		} catch (WebDriverException var5) {
			var5.getMessage();
		}
		return "";
	}
	
	
}
