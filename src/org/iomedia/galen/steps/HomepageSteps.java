package org.iomedia.galen.steps;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.mail.Folder;
import javax.mail.Store;
import org.iomedia.common.BaseUtil;
import org.iomedia.galen.common.AccessToken;
import org.iomedia.galen.common.EncryptDecrypt;
import org.iomedia.galen.common.ManageticketsAPI;
import org.iomedia.galen.common.RecieveMail;
import org.iomedia.galen.common.Screenshot;
import org.iomedia.galen.common.Utils;
import org.iomedia.galen.pages.DashboardSection;
import org.iomedia.galen.pages.Homepage;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomepageSteps  {
	
	Homepage homepage;
	BaseUtil base;
	Utils utils;
	org.iomedia.framework.Assert Assert;
	AccessToken accessToken;
	String driverType;
	DashboardSection section;
	RecieveMail mail;
	EncryptDecrypt decode = new EncryptDecrypt();
	ManageticketsAPI api;
	Screenshot shot;
	int actualMsgCount;
	
	public HomepageSteps(Screenshot shot, Homepage homepage, BaseUtil base, Utils utils, org.iomedia.framework.Assert Assert, DashboardSection section, RecieveMail mail, AccessToken accessToken, ManageticketsAPI api) {
		this.homepage = homepage;
		this.base = base;
		this.utils = utils;
		this.Assert = Assert;
		this.section = section;
		this.accessToken = accessToken;
		driverType = base.driverFactory.getDriverType().get();
		this.mail = mail;
		this.api = api;
		this.shot=shot;
		actualMsgCount = -1;
	}
	
	@When("^User verify congratulation message$")
	public void user_verify_congratulation_msg() {
		Assert.assertTrue(homepage.getLoginMessage().contains("Congratulations") || homepage.getLoginMessage().contains("To view your offer"), "Verify 'Congratulations' text is displayed on login screen");
	}

	@Given("^User is on (.+) Page$")
	public void user_is_on_Page(String uri) {
		uri = (String) base.getGDValue(uri);
		homepage.get(uri);
	}
	
	@Then("^Verify interstitial SignIn component on invites page$")
	public void verify_interstitial_signIn() {
		homepage.verifyInterstitialPage();
	}
	
	@When("^User enters (.+) and (.+)$")
	public void user_enters_and(String emailaddress, String password) throws Exception {
		String datasheet = System.getProperty("calendar") != null && !System.getProperty("calendar").trim().equalsIgnoreCase("") ? System.getProperty("calendar").trim() : base.Environment.get("calendar").trim();
		emailaddress = (String) base.getGDValue(emailaddress);
		password = (String) base.getGDValue(password);
	
		if(datasheet.trim().equalsIgnoreCase("PROD_SANITY") || datasheet.trim().equalsIgnoreCase("PRE_DEPLOYMENT")) {
			try {
		homepage.login(emailaddress, password, null, false);
			}
			catch(Exception e) {
				homepage.createaccount(null, false);
				base.Dictionary.put("ProdEmailAddress", base.Dictionary.get("NEW_EMAIL_ADDRESS"));
				base.Dictionary.put("ProdPassword", base.Dictionary.get("NEW_PASSWORD"));
				
			}		
		}
		else {
			homepage.login(emailaddress, password, null, false);	
		}
	}
	
	@When("^User landed on interstitial page and enters (.+) and (.+)$")
	public void user_landed_on_interstitial_page_and_enters_and(String emailaddress, String password) throws Exception {
		
		emailaddress = (String) base.getGDValue(emailaddress);
		password = (String) base.getGDValue(password);
		homepage.login(emailaddress, password, null, true);
	}
	
	@When("^User navigates to STP homepage after entering (.+) and (.+)$")
	public void user_navigates_to_stp_homepage_after_entering_and(String emailaddress, String password) throws Exception {
		emailaddress = (String) base.getGDValue(emailaddress);
		password = (String) base.getGDValue(password);
		homepage.stplogin(emailaddress, password, null);
	}
	
	@Then("^User creates account$")
	public void user_creates_account() throws Exception {
		homepage.createaccount(null, false);
	}
	
	@Then("^User creates account from interstitial$")
	public void user_creates_account_from_interstitial() throws Exception {
		homepage.createaccount(null, true);
	}
	
	@Then("^User creates account from interstitial using Email (.+)$")
	public void user_creates_account_from_interstitial_using_email_and_pass(String email) throws Exception {
		email = (String) base.getGDValue(email);
	//	pass = (String) base.getGDValue(pass);
		homepage.createaccount(email, null, true);
	}
	
	
	@Given("^User navigates to (.+) from NAM$")
	public void user_navigates_to_from_nam(String uri) {
		uri = (String) base.getGDValue(uri);
		utils.navigateTo(uri);
	}
	
	@When("^User navigates to (.+) for CMS Login$")
	public void user_navigates_to_cms(String uri) {
		uri = (String) base.getGDValue(uri);
		utils.navigateTo(uri);
		homepage.verifyInterstitialPage();
	}
	
	@When("^User navigates to (.+) Link$")
	public void user_navigates_to_link(String uri) {
		uri = (String) base.getGDValue(uri);
		base.getDriver().navigate().to(uri);
	}
	
	@Then("^NAM homepage is displayed$")
	public void nam_homepage_is_displayed() {
		try {
			WebElement we = base.getElementWhenPresent(By.xpath(".//input[@name='email'] | .//div[@class='mobile-signin']//*[text()='Sign In'] | .//div[@class='desktop-signin-dashboard']//a[text()='Sign In']"), 5);
			Assert.assertNotNull(we, "Verify NAM homepage is displayed");
		} catch(Exception ex) {
			// Do Nothing
		}
	}
	
	@Given("^User clicked on signup link$")
	public void user_clicked_on_signup_link() {
		homepage.clickSignInLink(null);
		homepage.clickSignUpLink();
	}
	
	@When("^User clicked on privacy link$")
	public void user_clicked_on_privacy_link() {
		homepage.clickPrivacyTermsLink();
	}
	
	@Then("^Verify user is navigated to correct link on clicking privacy policy or terms link$")
	public void verify_user_is_navigated_to_correct_link_on_clicking_privacy_policy_or_terms_link() throws Exception {
		String url = homepage.getPrivacyTermsLinkUrl();
		String newUrl = url;
		
		Assert.assertTrue(!url.trim().equalsIgnoreCase(""), "Verify privacy or terms conditions link url is set");
		int code = -1;
		if(url.trim().contains(base.Environment.get("TM_HOST"))) {
			code = section.checkStatuscodeExternal(url);
		} else {
			if(!url.trim().contains(base.Environment.get("APP_URL"))) {
				url = base.Environment.get("APP_URL") + url.trim().substring(url.trim().lastIndexOf("/"));
			}
			if(url.trim().contains("privacy-policy") || url.trim().contains("privacy") || url.trim().contains("terms")) {
				Set<Cookie> cookies = base.getDriver().manage().getCookies();
				code = section.checkStatuscode(url, cookies);
			} else {
				url = newUrl;
				code = section.checkStatuscodeExternal(url);
			}
		}
		Assert.assertTrue(code==200 || code==302 || code==301, "Verify URL status code");
		Assert.assertTrue(url.trim().toLowerCase().contains("privacy-policy") || url.trim().toLowerCase().contains("privacy") || url.trim().toLowerCase().contains("terms"), "Verify user is redirecting to correct page");
	}
	
	@When("^User click on Forgot Password link$")
	public void user_click_forgot_password() {
		homepage.clickSignInLink(null);
		homepage.clickForgotPasswordLink();
	}
	
	@Then("^Verify Forgot Password page is displayed$")
	public void verify_forgot_passord_page_displayed() {
		Assert.assertTrue(homepage.isForgotpasswordPageDisplayed(), "Verify forgot password page is displayed");
	}
	
	@When("^User enters EmailAddress using (.+)$")
	public void user_enter_emailaddress(String emailaddress) {		
		emailaddress = (String) base.getGDValue(emailaddress);
		homepage.enterEmailAddress(emailaddress);
	}
	
	@Then("^User connecting with Mailbox \"(.+)\" and \"(.+)\"$")
	public Store user_connecting_mailbox(String mailbox, String pass) throws Exception {
		Store store = mail.connect(base.Environment.get(mailbox), decode.decrypt(decode.decrypt(base.Environment.get(pass))));
		System.out.println("Store    "+store);
		return store;
	}
	
	@Then("^Get reset password link from Email \"(.+)\" \"(.+)\"$")
	public String get_reset_password_link(String mailbx, String passky) throws Exception {
		Store s = user_connecting_mailbox(mailbx,passky);
		Folder folder = mail.getFolder(s, "RESET");
		String link1 = mail.SearchLinkContent(folder, actualMsgCount);
		String link = link1.replaceAll("&amp;", "&");
		Assert.assertNotEquals(link, "", "Verify reset password link");
		base.Dictionary.put("Reset_Link", link);
		return link;
	}
	
	@Given("^Verify user exist in the site for (.+) and (.+) with \"(.+)\" \"(.+)\"$")
	public void verify_user_exist_site(String emailaddress, String password, String mailbx, String passky) throws Exception {
		emailaddress = (String) base.getGDValue(emailaddress);
		password = (String) base.getGDValue(password);
		Object[] status =	accessToken.postOauthToken(emailaddress, password);
	    String accessToken = (String)status[0];
	    if(accessToken == null) {
	    	if(!api.isCustomerExist(emailaddress, password)) {
	    		homepage.clickForgotPasswordLink();
	    		Assert.assertTrue(homepage.isForgotpasswordPageDisplayed(), "Verify forgot password page is displayed");
	    		homepage.enterEmail(emailaddress);
	    		Store s=user_connecting_mailbox(mailbx, passky);
	    		Folder folder = mail.getFolder(s, "RESET");
	    		actualMsgCount = mail.getMessages(folder).length;
	    		homepage.clickSendEmail();
	    		base.sync(10000L);
	    		String link1= mail.SearchLinkContent(folder, actualMsgCount);
	    		String link= link1.replaceAll("&amp;", "&");
	    		Assert.assertNotEquals(link, "", "Verify reset password link");
	    		homepage.redirect(link);
	    		homepage.enterPassword(password);
	    		homepage.clickSaveChanges();
	    		Assert.assertEquals(homepage.getresetpwdmessage(), "Your password has been updated");
	    		utils.navigateTo("/");
	    	}
	    }
	}
	
	@When("^User puts email (.+)$")
	public void user_put_emailId(String emailaddress) {
		emailaddress = (String) base.getGDValue(emailaddress);
		homepage.enterEmail(emailaddress);
	}
	
	@When("^User puts password (.+)$")
	public void user_put_password(String password) {
		password = (String) base.getGDValue(password);
		homepage.typePassword(password);
	}
	
	@When("^User click on SignIn button$")
	public void user_click_SignIn() {
		homepage.clickSignInButton(); 
	}
	
	@Then("^User request for further instruction \"(.+)\" \"(.+)\"$")
	public void user_request_instruction(String mailbx, String passky) throws Exception {
		getCountOfMessage("RESET", mailbx, passky);
		actualMsgCount= Integer.parseInt(base.Dictionary.get("ACTUAL_MSG_COUNT"));
		homepage.clickSendEmail();
	}

	@Given("^User gets count of Ticket in mail \"(.+)\" \"(.+)\"$")
	public void getCountOfTicket(String mailbx, String passky) throws Exception {
		getCountOfMessage("Ticket",mailbx, passky);
		actualMsgCount= Integer.parseInt(base.Dictionary.get("ACTUAL_MSG_COUNT"));

	}

	public void getCountOfMessage(String fold,String mailbx, String passky) {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				try {
					Store s = user_connecting_mailbox(mailbx,passky);
					Folder folder = mail.getFolder(s,fold);
					actualMsgCount = mail.getMessages(folder).length;
					base.Dictionary.put("ACTUAL_MSG_COUNT", String.valueOf(actualMsgCount));
					folder.close(true);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			
			}
		});

		thread.start();
//		while (base.Dictionary.get("ACTUAL_MSG_COUNT").trim().equalsIgnoreCase("")) {
		long time = System.currentTimeMillis();
		long end = time + 30000;
		while (base.Dictionary.get("ACTUAL_MSG_COUNT").trim().equalsIgnoreCase("") && System.currentTimeMillis() < end) {

		}
	}
	
	@Given("^Get Link for \"(.+)\" ticket \"(.+)\" \"(.+)\"$")
	public void getLinkForTicket(String linkToFetch,String mailbx, String passky) throws Exception {
		base.sync(20000L);		
		Store s = user_connecting_mailbox(mailbx, passky);
		Folder folder = mail.getFolder(s, "Ticket");
		actualMsgCount= Integer.parseInt(base.Dictionary.get("ACTUAL_MSG_COUNT"));
		String link = mail.SearchLinkContentForSend(folder, actualMsgCount, linkToFetch);
		System.out.println(link);
		base.Dictionary.put("TicketsLink", link);
	}

	@When("^User redirected to link (.+)$")
	public void user_redirected_to_link(String resetlink) {
		resetlink = (String) base.getGDValue(resetlink);		
		homepage.redirect(resetlink);
		if(homepage.isPasswordLinkExpired())
		{
			throw new SkipException("Password Link Expired");
		}
	}
	
	@Then("^User enters new password using (.+)$")
	public void user_enter_new_password(String password) {
		password = (String) base.getGDValue(password);
		homepage.enterPassword(password);
		homepage.clickSaveChanges();
	}
	
	@Then("^Verify password gets changed$")
	public void verify_password_changed() {
		Assert.assertEquals(homepage.getresetpwdmessage(), "Your password has been updated");
	}
	
	@Then("^Verify user does not get logged in$")
	public void verify_user_not_logged_in() {
		Assert.assertEquals(homepage.getNotificationBannerTitleMessage(), "User credentials are invalid");
		Assert.assertTrue(homepage.getNotificationBannerTextMessage().trim().contains("User credentials are invalid"));
	}
	
	@Then("^Verify password expires$")
	public void verify_password_expire() {
		Assert.assertEquals(homepage.getexpirelinkmessage(), "Your password reset link has expired");
	}
	
	@Then("^User logs out from NAM$")
	public void user_logout_from_NAM() {
		homepage.clickLogout();	
	}
	
	@Then("^User read the barcode from ImagePath (.+)$")
	public void user_read_barcode_folder(String ImagePath) throws com.google.zxing.NotFoundException, IOException {
		ImagePath = (String) base.getGDValue(ImagePath);	
		String decodedText="";
        File file = new File(ImagePath);
        decodedText = shot.decodeQRCode(file);
        if(decodedText == null) {
            System.out.println("No QR Code found in the image");
        } else {
            System.out.println("Decoded text = " + decodedText);
        }
		decodedText = decodedText.trim();
		base.Dictionary.put("QRCode", decodedText);
	}
	
	@Then("^Verify the barcode for (.+) and (.+) with (.+)$")
	public void verify_barcode(String ticketIds, String index, String barcode) throws Exception {
		barcode = (String) base.getGDValue(barcode);
		ticketIds = (String) base.getGDValue(ticketIds);
		index = (String) base.getGDValue(index);
		String ticketId = ticketIds.trim().split(",")[Integer.valueOf(index.trim())];
		String[] details = api.renderTicketDetails(ticketId);
		String apibarcode = details[1];
		Assert.assertEquals(barcode, apibarcode, "Barcode gets matched");
	}
	
	@Then("^Verify the homepage public menu items is displaying as per CMS$")
	public void verify_menu_links_homepage(){
		homepage.verifyAllMenuNodesTextswithCMS();
	}
}
