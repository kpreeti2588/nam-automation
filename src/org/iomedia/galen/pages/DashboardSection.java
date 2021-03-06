package org.iomedia.galen.pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.iomedia.common.BaseUtil;
import org.iomedia.framework.Driver.HashMapNew;
import org.iomedia.framework.Driver.TestDevice;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.iomedia.framework.Reporting;
import org.iomedia.framework.WebDriverFactory;
import org.iomedia.galen.common.AccessToken;

public class DashboardSection extends BaseUtil {
    Homepage hp = new Homepage(driverFactory, Dictionary, Environment, Reporter, Assert, SoftAssert, sTestDetails);
	AccessToken at = new AccessToken(driverFactory, Dictionary, Environment, Reporter, Assert, SoftAssert,sTestDetails);
	private String driverType;
	public DashboardSection(WebDriverFactory driverFactory, HashMapNew Dictionary, HashMapNew Environment, Reporting Reporter, org.iomedia.framework.Assert Assert, org.iomedia.framework.SoftAssert SoftAssert) {
		super(driverFactory, Dictionary, Environment, Reporter, Assert, SoftAssert);
		driverType = driverFactory.getDriverType().get();
	}
	
	private By manageTickets = By.cssSelector(".react-root-event-dashboard ul li a div");
	private By manageTicketsPlaceholder = By.cssSelector(".react-root-event-dashboard ul li a,div[class*='events-placeholderContainer']");
	private By manageTicketsPlaceholderNew = By.cssSelector(".react-root-event-dashboard ul li a,div[class*='style-placeholderContainer']");
	private By EventsPlaceholder = By.xpath("//div[contains(@class,'style-placeholderContainer')]//div//p");
	private By EventsText = By.xpath("//div[contains(@class,'react-root-event')]//p");
	private By events = By.xpath(".//div[contains(@class, 'react-root-event')]//ul[contains(@class, 'events-eventList')]//li[contains(@class, 'events-event')]//a");
	private By invoices = By.cssSelector(".react-root-invoice-dashboard ul li.list-item");
	private By invoicesPlaceholder = By.cssSelector(".react-root-invoice-dashboard ul li.list-item,div[class*='invoice-placeholderContainer']");
	private By viewAllTickets = By.xpath("//*[contains(@class,'eventslist')]//a[@class='viewAllBtn']");
	private By viewAllInvoice= By.xpath("//*[contains(@class,'invoicelist')]//a[@class='viewAllBtn']");
	private By Links = By.xpath("//nav[@id='block-loggedinmenu']//ul//li[contains(@class,'expanded dropdown')]//a");
//	private By Dropdown = By.cssSelector("div[class*='user-fullname'] .material-icons , div[class*='user-fullname'] a");
	private By Dropdown = By.cssSelector("div[class*='user-fullname'] a");
//	private By DropdownMobile = By.xpath(".//*[@id='block-useraccountmenumobile']/div/div/a");
	private By ChangePassword = By.cssSelector("#amgr-user-menu li:nth-last-child(2) a");
	private By temp_pass = By.xpath("//input[@name='temp_pass']");
	private By password = By.xpath("//input[@name='password']");
	private By confirm = By.xpath("//input[@name='confirm_pass']");
	private By Save = By.xpath("//button[@type='submit']");
	private By EventText = By.xpath("//div[contains(@class,'style-eventDetails')]");
	private By ticketname= By.xpath("//div[contains(@class,'ticket-ticketImage')]");
	private By mobileTicketName = By.cssSelector("div[class*='ticket-eventName'] h3");
	private By InvoiceLink = By.cssSelector(".dashboard-invoicelist .react-root-invoice-dashboard ul.react-listing li.list-item a");
	private By InvoiceText = By.cssSelector(".dashboard-invoicelist .react-root-invoice-dashboard ul.react-listing li.list-item a em");
	private By InvoicePageLink = By.xpath("//div[@class='container']//div//div[1]//ul//li[1]//a");
	private By InvoicePageName = By.xpath("//div[@class='container']//div//div[1]//ul//li[1]//a//div//em");
	private By InvoiceLinkText = By.xpath("//div[@class='react-root-invoice-dashboard']//div//div//div[1]//div//div//p");
	private By yourAccount = By.xpath(".//*[@id='amgr-user-menu']/li[1]/a");
	private By yourAccountMobile = By.xpath(".//*[@id='amgr-user-menu-mobile']/li[1]/a");
	private By yourSwitchAccount = By.xpath(".//*[@id='amgr-user-menu']/li[1]/a[text()='Switch Accounts']");
	private By switchAccountMobile = By.xpath(".//*[@id='amgr-user-menu-mobile']/li[1]/a[text()='Switch Accounts']");
	private By editName = By.xpath("//*[contains(@class,'switch-switchDialog')]//*[contains(@class,'formSubmitButtons')]/button[1] | //*[contains(@class,'theme-dialog')]//*[contains(@class,'formSubmitButtons')]/button[1]");
	private By switchAccount = By.xpath("//*[contains(@class,'switch-switchDialog')]//*[contains(@class,'formSubmitButtons')]/button[2][text()='SWITCH' or text()='Switch'] | //*[contains(@class,'theme-dialog')]//*[contains(@class,'formSubmitButtons')]/button[2][text()='SWITCH' or text()='Switch']");
	private By accountName = By.xpath("//*[contains(@class,'switch-setName')]/input");
	private By saveName = By.xpath("//*[contains(@class,'switch-switchDialog')]//*[contains(@class,'formSubmitButtons')]/button[2] | //*[contains(@class,'theme-dialog')]//*[contains(@class,'formSubmitButtons')]/button[2]");
	private By closePopUp= By.xpath("//*[contains(@class,'manage-tickets-closeButton')]/i");
	private By accountBalance = By.xpath("//div[contains(@class,'accountBalance')]//span");
	private By YourAccntMobile = By.xpath(".//*[@id='amgr-user-menu-mobile']/li[descendant::a[text()='Your Account' or text()='Account Settings' or text()='Edit Profile' or @class='your-account-classic']]/a");
	private By YourAccnt = By.xpath(".//*[@id='amgr-user-menu']/li[descendant::a[text()='Your Account' or text()='Account Settings' or text()='Edit Profile' or @class='your-account-classic']]/a");
	private By changePasswordMobile = By.xpath(".//*[@id='amgr-user-menu-mobile']/li[descendant::a[text()='Change Password']]/a");
	private By changePassword = By.xpath(".//*[@id='amgr-user-menu']/li[descendant::a[text()='Change Password']]/a");
	private By passwordShowHide = By.cssSelector(".passwordShowHide");
	private By userMenuMobile = By.cssSelector(".navbar-header button.pull-right");
	private By transferInfoBar = By.cssSelector("div[class*=style-toastrItem] h4");
	private By DeclineButton = By.cssSelector("div[class*=style-toastrItem] div[class*=style-buttonBox] button:nth-child(1)");
	private By AcceptButton = By.cssSelector("div[class*=style-toastrItem] div[class*=style-buttonBox] button:nth-child(2)");
	private By seeDetails = By.cssSelector("div[class*=style-toastrItem] h4 span");
	private By acceptTransferDialogue = By.cssSelector("div[data-react-toolbox='dialog'] section h6");
	private By eventNameAcceptTransfer = By.cssSelector("div[class*=style-event] div[class*=style-detailsHolder] h4");
	private By ticketsCountAcceptTransfer = By.cssSelector("div[class*=style-event] div[class*=style-iconAction] div span");
	private By successMsg = By.cssSelector("div[class*='style-claimMessage'] h3");
	private By gotoEventButton = By.cssSelector(" div[class*='style-buttonBox'] button");
	private By eventPage = By.cssSelector("div[class*='ticket-subHeader'] div div h3");
	private By declineDialouge = By.cssSelector("div[class*='style-buttonBox'] div button:nth-child(1)");
	private By acceptDialouge = By.cssSelector("div[class*='style-buttonBox'] div button:nth-child(2)");
	private By actionText = By.cssSelector("div[class*='style-claimMessage'] div span");
	private By declineTransferOffer = By.cssSelector("div[data-react-toolbox='dialog'] div[class*='text-center'] button:nth-child(2)");
	private By declineTransferOfferClose = By.cssSelector("div[data-react-toolbox='dialog'] section span i");

	
	public void closePopUp(){
		click(closePopUp,"ClosePopUp");
	}
	
	public void clickMobileUserMenu() {
		click(userMenuMobile, "Mobile User Menu");
	}
	
	public String getEventsPlaceholderText() {
		String value= getText(EventsPlaceholder);
		return value;
	}
	
	public String getEventsTextinTicketPage() {
		String value= getText(EventsText);
		return value;
	}
	
	public int getAccountCount(){
		getElementWhenVisible(By.xpath("//*[contains(@class,'switch-multipleAccounts')]/div"));
		List<WebElement> accounts= getWebElementsList(By.xpath("//*[contains(@class,'switch-multipleAccounts')]/div"));
		return accounts.size();
	}
	
	public void clickYourAccountMobile(){
		getElementWhenVisible(By.xpath(".//*[@id='block-useraccountmenumobile']/div/div[1]/a/span[2]")).click();
		sync(500L);
		click(yourAccountMobile, "Your Account");
	}
	
	public void clickYourAccntMobile(){
		getElementWhenVisible(By.xpath(".//*[@id='block-useraccountmenumobile']/div/div[1]/a/span[2]")).click();
		sync(500L);
		click(YourAccntMobile, "Your Account");
	}
	
	public void clickChangePasswordMobile(){
		//getElementWhenVisible(By.xpath(".//*[@id='block-useraccountmenumobile']/div/div[1]/a/span[2]")).click();
		sync(500L);
		click(changePasswordMobile, "Change password");
	}
	
	public void clickChangePasswordDesktop(){
		click(Dropdown, "dropdown");
		click(changePassword, "Change password");
	}
	
	public void clickSwitchAccountMobile() {
		getElementWhenVisible(By.xpath(".//*[@id='block-useraccountmenumobile']/div/div[1]/a/span[2]")).click();
		sync(500L);
		click(switchAccountMobile, "Switch Account");
	}
	
	public void clickSwitchAccounts() {
		click(Dropdown, "dropdown");
		click(yourSwitchAccount, "Switch Account");
	}
	
	public void typeAccountName(String nickName) throws Exception{
		if(nickName.trim().equals(getAttribute(accountName, "value"))){
			type(accountName, "Account Nick Name", nickName+"a", false, By.xpath(".//XCUIElementTypeTextField[1]"));
		}
		else
			type(accountName, "SearchBox", nickName, false, By.xpath(".//XCUIElementTypeTextField[1]"));
	}
	
	public boolean checkSwitchAccountPresentMobile(){
		return checkIfElementPresent(switchAccountMobile);
	}
	
	public boolean checkSwitchAccountPresent(){
		return checkIfElementPresent(yourSwitchAccount);
	}
	
	public String getTypedName(){
		return getAttribute(accountName, "value");
	}
	
	public void clickSaveNickName(){
		click(saveName, "Save Button");
	}
	
	public void clickEditName(){
		click(editName, "Edit Name");
	}
	
	public void clickSwitchAccount(){
		click(switchAccount, "Switch");
	}
	
	public void selectAccount(String AccountId){
		getElementWhenVisible(By.xpath("//*[contains(@class,'switch-multipleAccounts')]//span[contains(.,'"+AccountId+"')]/../../*[contains(@class,'logoAccount')]")).click();
	}
	
	public String getNickName(String AccountId){
		return getElementWhenVisible(By.xpath("//*[contains(@class,'switch-multipleAccounts')]//span[contains(.,'"+AccountId+"')]/../../*[contains(@class,'accountName')]/div")).getText();
	}
	
	public String getAccountId(String AccountId){
		return getElementWhenVisible(By.xpath("//*[contains(@class,'switch-multipleAccounts')]//span[contains(.,'"+AccountId+"')]/../../*[contains(@class,'accountId')]/span")).getText().trim().replaceAll("\\#", "");
	}
	
//	public String getPrimaryAccountName(){
//		return getElementWhenVisible(PrimaryAccountName).getText();
//	}
	
	public void clickYourAccount(){
		click(Dropdown, "dropdown");
		click(yourAccount, "Your Account");
	}
	
	public void clickAccount(){
		click(Dropdown, "dropdown");
		click(YourAccnt, "Your Account");	
	}
	
	public void clickViewAllTickets(){
		click(viewAllTickets, "View All Tickets");
	}
	
	public void clickViewAllInvoice(){
		click(viewAllInvoice, "View All Invoices");
	}

	public void clickChangePassword(){
	//	click(Dropdown,"dropup");
		click(ChangePassword, "ChangePassword");
	}	

	public String getChangePasswordText() {
        click(Dropdown,"dropup");
		return getText(ChangePassword);
	}

	public void clickSavePassword(){
		click(Save, "Save");
	}
	
	public String clickDashboardEvent() {
		String eventName = getText(EventText);
		click(manageTickets, eventName);
		return eventName;
	}
	
	public String getInvoiceDashboardText(){
		return getText(InvoiceLinkText, 10);
	}
	
	public void clickInvoice(){
		click(InvoiceLink, getText(InvoiceText, 10));
	}
	
	public String getInvoiceText(){
		return getText(InvoiceText, 10);
	}
	
	public String getInvoicePageName(){
		WebElement we = getElementWhenVisible(this.InvoicePageLink);
		return we.getAttribute("href"); 
	}
	
	public String getInvoicePageText(){
		return getText(InvoicePageName, 10);
	}
	
	public String getInvoiceLink(){
		WebElement we = getElementWhenVisible(this.InvoiceLink);
		return we.getAttribute("href");
	}
		
	public String getTicketName() {
		if(driverType.trim().toUpperCase().contains("ANDROID") || driverType.trim().toUpperCase().contains("IOS"))
			return getText(mobileTicketName);
		else
			return getText(ticketname, 10);
	}
	
	public String getChangePasswordLink(){
		WebElement we = getElementWhenVisible(this.ChangePassword);
		return we.getAttribute("href");
	}

	public void typeChangePassword(String currentpassword, String newpassword){
		WebElement we = getElementWhenVisible(this.temp_pass);
		we.sendKeys(currentpassword, Keys.TAB);
		we = getElementWhenVisible(this.password);
		we.sendKeys(newpassword, Keys.TAB);
		we = getElementWhenVisible(this.confirm);
		we.sendKeys(newpassword, Keys.TAB);		
		if(!driverType.trim().toUpperCase().contains("IE"))
			if(checkIfElementPresent(passwordShowHide, 1))
				getElementWhenVisible(passwordShowHide).click();
	}
	
	public boolean isChangePasswordPageDisplayed(){
		getElementWhenVisible(this.temp_pass);
		return true;
	}
	
	public boolean waitForDasboardSection(TestDevice device) {
		try{
			if(getDriver().getCurrentUrl().equals(Environment.get("APP_URL"))) {
				hp.login("","",device,true);
				}
			getElementWhenVisible(manageTickets);
		} catch(Exception ex) {
			getDriver().navigate().refresh();
			try {
				if(getDriver().getCurrentUrl().equals(Environment.get("APP_URL"))) {
					hp.login("","",device,true);
					}
			getElementWhenVisible(manageTickets);
			}
			catch(Exception e) {
				getElementWhenVisible(manageTicketsPlaceholderNew);	
			}
		}
		if((device != null && (device.getName().trim().equalsIgnoreCase("mini-tablet") || device.getName().trim().equalsIgnoreCase("mobile"))) || (driverType.trim().toUpperCase().contains("ANDROID") || driverType.trim().toUpperCase().contains("IOS"))) {
			//Do Nothing
		} else {
			try {
			getElementWhenVisible(invoices, 40);
			}
			catch(Exception e) {
				getElementWhenVisible(invoicesPlaceholder, 40);
			}
		}
		
		try {
		getElementWhenRendered(manageTickets, 150, 150);
		}
		catch(Exception e) {
			getElementWhenRendered(manageTicketsPlaceholderNew, 150, 150);
		}
		sync(2000L);
		return true;
	}
	
	public boolean waitForDashboardSection(TestDevice device) {
		try{
			try {
           if(getDriver().getCurrentUrl().equals(Environment.get("APP_URL"))) {
			hp.login("","",device,true);
			}
			getElementWhenVisible(manageTicketsPlaceholderNew);}
			catch(Exception e) {
				Assert.assertEquals(getEventsPlaceholderText(), "There are no events in your account.", "No events found");
			}
			
		} catch(Exception ex) {
			getDriver().navigate().refresh();
			try {
				if(getDriver().getCurrentUrl().equals(Environment.get("APP_URL"))) {
					hp.login("","",device,true);
					}
			getElementWhenVisible(manageTicketsPlaceholder);}
			catch(Exception e) {
				Assert.assertEquals(getEventsPlaceholderText(), "There are no events in your account.", "No events found");
			}
		}
		if((device != null && (device.getName().trim().equalsIgnoreCase("mini-tablet") || device.getName().trim().equalsIgnoreCase("mobile"))) || (driverType.trim().toUpperCase().contains("ANDROID") || driverType.trim().toUpperCase().contains("IOS"))) {
			//Do Nothing
		} else {
			try {
			getElementWhenVisible(invoicesPlaceholder, 40);
			}
			catch(Exception e) {
				getElementWhenVisible(invoices, 40);
			}
		}
		sync(2000L);
		return true;
	}
	
	public List<WebElement> getAllLinks(){
		return getWebElementsList(Links);
	}
	
	public String getURL(WebElement E){
		return E.getAttribute("href");
	}
	
	public String getAccountBalance(){
		click(accountBalance, "Account Balance");
		return getText(accountBalance);
	}
	
	public void clickLinks(WebElement E){
		click(E,E.getText());
	}
		
	public int checkStatuscode(String linkURL, Set<Cookie> cookies) throws Exception{	
		URL urlstatus = new URL (linkURL);
		URLConnection connection = urlstatus.openConnection();
		HttpURLConnection con = (HttpURLConnection) connection;
	    con.setRequestMethod("GET");	
	    con.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36");
	    con.addRequestProperty("Content-Type", "text/html; charset=UTF-8");
	    con.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
	    con.addRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
	    con.addRequestProperty("Connection", "keep-alive");
	    Iterator<Cookie> iter = cookies.iterator();
	    String _cookies = "";
	    while(iter.hasNext()) {
	    	Cookie cookie = iter.next();
	    	_cookies += cookie.getName() + "=" + cookie.getValue() + ";";
	    }
	    _cookies=_cookies.substring(0, _cookies.length()-1);
//		  con.setRequestProperty("Host", "amgr-pre prod.io-media.com");
	    con.setRequestProperty("Cookie",_cookies);
	    con.connect();
	    int statuscode = con.getResponseCode();
		return statuscode;
	}
	
	public int checkStatuscodeExternal(String linkURL) throws Exception{
		URL urlstatus = new URL (linkURL);
		URLConnection connection = urlstatus.openConnection();
		HttpURLConnection con = (HttpURLConnection) connection;
	    con.setRequestMethod("GET");
	    con.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36");
	    con.addRequestProperty("Content-Type", "text/html; charset=UTF-8");
	    con.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
	    con.addRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
	    con.addRequestProperty("Connection", "keep-alive");
	    con.connect();
	    int statuscode = con.getResponseCode();
		return statuscode;
	}
	
	public HashMap<Integer, String> getListOfEvents() {
		List<WebElement> levents = getWebElementsList(events);
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for(int i = 0; i < levents.size() && i < 4; i++) {
			int eventId = Integer.valueOf(levents.get(i).getAttribute("href").split("/")[levents.get(i).getAttribute("href").split("/").length - 1]);
			String xpath = getXpath(events, "Event", "", -1);
			String ticketCount = "0 Ticket";
			if(checkIfElementPresent(By.xpath("(" + xpath + ")[" + (i+1) + "]" + "//div[contains(@class, 'events-eventTicketCount')]//span[2]"), 1))
				ticketCount = getText(By.xpath("(" + xpath + ")[" + (i+1) + "]" + "//div[contains(@class, 'events-eventTicketCount')]//span[2]"));
			map.put(eventId, ticketCount);
		}
		return map;
	}

	public void verifyInfobar() {

		Assert.assertTrue(checkIfElementPresent(transferInfoBar),"Transfer Info bar not present on DashBoard");
		Assert.assertTrue(getText(DeclineButton).equalsIgnoreCase("Decline"));
		Assert.assertTrue(getText(AcceptButton).equalsIgnoreCase("Accept"));
		Assert.assertTrue(checkIfElementPresent(seeDetails),"See Details link not present");


	}

	public void clickSeeDetails() {
		click(seeDetails,"SEE DETAILS");
	}

	public void verifyTransferredTickets(String tickets, String event) {
		Assert.assertTrue(getText(acceptTransferDialogue).equalsIgnoreCase("Accept Transfer Offer"));
		Assert.assertEquals(getText(eventNameAcceptTransfer),event);
		Assert.assertEquals(getText(ticketsCountAcceptTransfer),tickets);
	}

	public void verifyTransferredTicketsTwoEvents(int num, String event1, String event2) {
		Assert.assertTrue(getText(acceptTransferDialogue).equalsIgnoreCase("Accept Transfer Offer"));
	}

	public void acceptTransfer() {
		click(acceptDialouge,"Accept Button from Dialogue");
	}

	public void declineTransfer() {
		click(declineDialouge,"Decline button from Dialouge");
	}

	public void successMsg() {
		SoftAssert.assertTrue(getText(successMsg).equalsIgnoreCase("Success!"));
		Assert.assertTrue(checkIfElementPresent(gotoEventButton));
	}

	public void declineMsg() {
		SoftAssert.assertTrue(getText(successMsg).equalsIgnoreCase("Not feeling it?"));
		SoftAssert.assertTrue(getText(actionText).contains("You've declined the ticket offer. We'll let"));
		Assert.assertTrue(checkIfElementPresent(gotoEventButton));
	}

	public void verifyEventPage(String name) {
		click(gotoEventButton,"Go to Event");
		Assert.assertTrue(getText(eventPage).contains(name));
	}

	public void verifyInfoBarDisappear() {
		Assert.assertFalse(checkIfElementPresent(transferInfoBar));
	}

	public void cleanPendingTransfer() {
		while(checkIfElementPresent(DeclineButton)) {
			click(DeclineButton,"DECLINE");
			click(declineTransferOffer,"DECLINE TRANSFER OFFER");
			click(declineTransferOfferClose,"DECLINE TRANSFER OFFER CLOSE");

		}
	}
}