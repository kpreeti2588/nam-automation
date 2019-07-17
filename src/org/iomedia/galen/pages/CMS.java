package org.iomedia.galen.pages;


import org.iomedia.common.BaseUtil;
import org.iomedia.framework.Driver.HashMapNew;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.server.handler.SwitchToParentFrame;
import org.iomedia.framework.Reporting;
import org.iomedia.framework.WebDriverFactory;

public class CMS extends BaseUtil {

	public CMS(WebDriverFactory driverFactory, HashMapNew Dictionary, HashMapNew Environment, Reporting Reporter, org.iomedia.framework.Assert Assert, org.iomedia.framework.SoftAssert SoftAssert, ThreadLocal<HashMapNew>[] sTestDetails) {
		super(driverFactory, Dictionary, Environment, Reporter, Assert, SoftAssert, sTestDetails);
	}
	
	private By invoices = By.xpath("//p[text()='Invoices']");
	private By setting = By.xpath("//p[text()='Settings']");
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
	private By submit = By.xpath("//button[text()='Submit']");
	
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
	
	private By changePasswordCurrentVerify = By.xpath("//input[@name='temp_pass']/..//label");
	private By changePasswordNewVerify = By.xpath("//input[@name='password']/..//label");
	private By changePasswordConfirmVerify = By.xpath("//input[@name='confirm_pass']/..//label");
	private By changePasswordSubmitVerify = By.xpath("//button[@type='submit']");
	
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
//	public String city = "AutoCity";
//	public String zip = "AutoZip";
	
	
	
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
	
	
}
