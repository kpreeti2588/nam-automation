package org.iomedia.galen.steps;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.iomedia.common.BaseUtil;
import org.iomedia.galen.common.Utils;
import org.iomedia.galen.pages.AddNewPage;
import org.iomedia.galen.pages.CMS;
import org.iomedia.galen.pages.ContentPageEdit;
import org.iomedia.galen.pages.SuperAdminPanel;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Calendar;
import java.util.Dictionary;

public class CMSSteps {
	
	SuperAdminPanel adminPanel;
	AddNewPage addNewPage;
	ContentPageEdit contentPageEdit;
	CMS cms;
	BaseUtil base;
	Utils utils;
	org.iomedia.framework.Assert Assert;
	
	public CMSSteps(SuperAdminPanel adminPanel, BaseUtil base, Utils utils, org.iomedia.framework.Assert Assert, AddNewPage addNewPage,ContentPageEdit contentPageEdit,CMS cms) {
		this.adminPanel = adminPanel;
		this.base = base;
		this.utils = utils;
		this.Assert = Assert;
		this.addNewPage = addNewPage;
		this.contentPageEdit =contentPageEdit;
		this.cms = cms;
	}
	
	@When("^User login into CMS$")
	public void user_login_into_cms_using_and() {
		
			String userName = base.Dictionary.get("cmsUserName");
			String password = base.Dictionary.get("cmsPassword");
		adminPanel.login(userName, password);
	}
	
	@When("^User login into CMS with support user$")
	public void user_login_into_cms_with_support_user() {
		String username, password;
//		username = "automation_editor_manager";
//		password = "nam_editor_manager";
		username = "siteadmin";
		password = "123456";
		adminPanel.login(username, password);
	}
	
	@When("^Navigate to (.+)$")
	public void navigate_to(String uri) {
		uri = (String) base.getGDValue(uri);
		utils.navigateTo(uri);
	}
	
	@Then("^Promotiles page is displayed$")
	public void promotiles_page_is_displayed() {
		Assert.assertEquals(adminPanel.getpromotilesTitle(), "Promo Tiles", "Promotiles title is displayed");
	}
	
	@When("^Click edit icon for logged in promotiles$")
	public void click_edit_icon_for_logged_in_promotiles() {
		adminPanel.loggedInEdit();
	}
	
	@Then("^Logged In Promotiles page is displayed$")
	public void logged_in_promotiles_page_is_displayed() {
		Assert.assertEquals("Logged In", adminPanel.getLoggedInTxt(),"Logged In header text is displayed");
	}
	
	@Given("^First promotile is saved with following values$")
	public void first_promotile_is_saved_with_following_values(DataTable values) {
		List<List<String>> data = values.raw();
		List<String> firstRow = data.get(0);
		String headerText = (String) base.getGDValue(firstRow.get(0));
		String promotileText = (String) base.getGDValue(firstRow.get(1));
		String url = (String) base.getGDValue(firstRow.get(2));
		String backgroundColor = (String) base.getGDValue(firstRow.get(3));
		
		adminPanel.clickPromotilesecondEdit();
		adminPanel.typeHeaderText(headerText.trim());
		adminPanel.typepromoTitle(promotileText.trim());
		Assert.assertEquals("Logged In", adminPanel.selectPromoTileGroup(),"Logged In promotile group is selected");
		adminPanel.typeurl(url.trim());
		adminPanel.colorPicker(backgroundColor.trim());
		String URL= adminPanel.getTitleLink();
		adminPanel.save();
		adminPanel.logout();
		Assert.assertEquals(url, URL,"Redirecting URLs are matching for first promotiles for Logged In users");
	}
	
	@Then("^Verify header text of first promotile with (.+)$")
	public void verify_header_text_of_first_promotile(String headerText) {
		headerText = (String) base.getGDValue(headerText);
		Assert.assertEquals(headerText.trim(), adminPanel.getpromotilesheadertext(), "Promotiles header texts are matching for Logged In users");
	}
	
	@When("^Click first promotile$")
	public void click_first_promotile() {
		adminPanel.clickFirstpromotile();
	}
	
	@When ("^Click on leftMenuToggle$")
	public void Click_on_leftMenuToggle() {
		adminPanel.clickMenuToggle();
	}
	
	@When ("^Click on leftMenu Hamburger$")
	public void Click_on_leftMenuHamburger() {
		adminPanel.clickLeftHamburger();
	}
	
	@When ("^Click on menuManager$")
	public void Click_on_menuManager() {
		utils.navigateTo("/admin/menu-listing");
	}
	
	@When ("^Click on addMenu$")
	public void Click_on_addMenu() {
		adminPanel.clickaddMenu();
	}
	
	@Then ("^Click Page Settings for Page (.+)$")
	public void click_Page_Settings_PageManager(String pageName) {
		pageName = (String) base.getGDValue(pageName);
		adminPanel.clickPageSettingsPageManager(pageName);
	}
	
	@Then ("^Type Menu Name (.+)$")
	public void Type_Menu_Name(String MenuName) throws Exception {
		MenuName = (String) base.getGDValue(MenuName);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		base.Dictionary.put("MenuName", MenuName + " - " + timeStamp);
		adminPanel.typeMenuName(MenuName + " - " + timeStamp);
    }
	
	@Then ("^Click on Public Access Level$")
	public void Click_on_Public_Access_Level() {
		adminPanel.clickPublicAccessLevel();
	}
	
	@Then ("^Click on LoggedIn Access Level$")
	public void click_on_LoggedIn_Access_Level() {
	adminPanel.clickLoggedInAccessLevel();	
	}
	
	@Then ("^Click on Internal Pages$")
	public void Click_on_Internal_Pages() {
		adminPanel.clickInternalPagesHeader();
	}
	
	@Then ("^Click on External Pages$")
	public void Click_on_External_Pages() {
		adminPanel.clickExternalPagesHeader();
	}
	
	@Then ("^Insert Page Title (.+) and Page Link (.+) of External Page$")
	public void create_external_page_MenuItem(String pageTitle, String pageLink) throws Exception {
		pageTitle = (String) base.getGDValue(pageTitle);
		pageLink = (String) base.getGDValue(pageLink);
		adminPanel.typeMenuExternalPageTitle(pageTitle);
		adminPanel.typeMenuExternalPageLink(pageLink);
		adminPanel.clickAddButtonExternalMenu();
	}
	
	
	@Then ("^Drag and Drop Menu item(.*)$")
	public void Drag_and_Drop_Menu_item(String menuName) throws Exception {
		menuName = (String) base.getGDValue(menuName.trim());
		adminPanel.dragAndDropInternalPages(menuName);
	}
	
	@Then ("^Save Menu$")
	public void Save_Menu() {
		adminPanel.clicksaveMenu();
	}
	
	@Then ("^Click Page Manager$")
	public void Click_Page_Manager() {
		adminPanel.clickPageManager();
	}
	
	@Then ("^Click on View Page$")
	public void Click_on_View_Page() {
		adminPanel.clickViewPagemenuItem();
	}
	
	@When ("^User reaches page settings for (.+) page$")
	public void user_reaches_page_settings(String pageType) {
		pageType = (String) base.getGDValue(pageType);
		adminPanel.clickPageSettingsIcon(pageType);
		adminPanel.clickPageSettings();
	}
	
	@When ("User clicks on Page Settings")
	public void user_clicks_PageSettings(){
		adminPanel.clickPageSettings();
	}
	
	@When ("^Select (.+) from Menu and click save$")
	public void select_from_menu_and_click_save(String menu) {
		menu = (String) base.getGDValue(menu);
		adminPanel.selectPageMenu(menu);
		adminPanel.save();
	}
	
	@Then ("^Get all the menu nodes from CMS for current menu$")
	public void get_menu_links_cms(){
		adminPanel.getAllMenuNodesNames();
	}
	
	@Then ("^User clicks (.+) type PageSettings icon or creates New ContentPage if no available$")
		public void create_new_page(String accessType) throws Exception {
		accessType =  (String) base.getGDValue(accessType);
		if(accessType.equalsIgnoreCase("hybrid")){
			if(adminPanel.checkPageTypeAvailable("Public/Logged In"))	{
				adminPanel.clickPageSettingsIcon("Public/Logged In");
				contentPageEdit.clickPageSettings();
				base.Dictionary.put("PageUrl", adminPanel.getPageUrl());
		}
			else {
				adminPanel.clickAddNewPage();
				addNewPage.clickSelectContentPage();
				addNewPage.selectContentPageLayout();
				addNewPage.clickNext();
				contentPageEdit.clickPageSettings();
				contentPageEdit.typePageName(base.Dictionary.get("ContentPageName"));
				contentPageEdit.typePageTitle(base.Dictionary.get("ContentPageTitle"));
				base.Dictionary.put("PageUrl", adminPanel.getPageUrl());
				contentPageEdit.clickSaveSettings();
				contentPageEdit.clickPageSettings();
			}	
		}
			else {
				if(adminPanel.checkPageTypeAvailable(accessType))	{
					adminPanel.clickPageSettingsIcon(accessType);
					contentPageEdit.clickPageSettings();
					contentPageEdit.typePageName(base.Dictionary.get("ContentPageName"));
					contentPageEdit.typePageTitle(base.Dictionary.get("ContentPageTitle"));
					base.Dictionary.put("PageUrl", adminPanel.getPageUrl());
				}
				else {
					adminPanel.clickAddNewPage();
					addNewPage.clickSelectContentPage();
					addNewPage.selectContentPageLayout();
					addNewPage.clickNext();
					contentPageEdit.clickPageSettings();
					contentPageEdit.typePageName(base.Dictionary.get("ContentPageName"));
					contentPageEdit.typePageTitle(base.Dictionary.get("ContentPageTitle"));
					base.Dictionary.put("PageUrl", adminPanel.getPageUrl());
					adminPanel.selectPageAccess(accessType);
					contentPageEdit.clickSaveSettings();
					contentPageEdit.clickPageSettings();
				}	
			}
	}
	
	@Then ("^Verify the content menu items is displaying as per CMS$")
	public void verify_menu_links_homepage(){
		adminPanel.verifyAllMenuNodesTextswithCMS();
	}
	
	@Then ("^Select (.+) as Active Public Menu and Click Save$")
	public void select_active_public_menu(String menuName){
		menuName =  (String) base.getGDValue(menuName);
		adminPanel.selectActivePublicMenu(menuName);
		adminPanel.clickSaveActiveMenu();
	}
	
	@Then ("^Select (.+) as Active LoggedIn Menu and Click Save$")
	public void select_active_loggedIn_menu(String menuName){
		menuName =  (String) base.getGDValue(menuName);
		adminPanel.selectActiveLoggedInMenu(menuName);
		adminPanel.clickSaveActiveMenu();
	}
	
	@Then ("^Verify menuName (.+) is not available$")
	public void verify_Menu_Item_not_available(String menuName) {
		menuName =  (String) base.getGDValue(menuName);
		Assert.assertFalse(adminPanel.getMenuDropdownItemsText().contains(menuName),"Menu "+menuName+ " is not available in menu dropdown");
	}
	
	@Given ("^Delete menu (.+) from menu manager$")
	public void delete_menu_menuManager(String menuName) {
		menuName =  (String) base.getGDValue(menuName);
		adminPanel.clickDeleteMenuIcon(menuName);
		adminPanel.clickDeletePopUp();
	}
	
	@Then ("^Verify menu (.+) is not available in menu manager table$")
	public void verify_menu_not_availabler(String menuName) {
		menuName =  (String) base.getGDValue(menuName);
		Assert.assertFalse(adminPanel.getMenuTableAllText().contains(menuName),"Menu "+menuName+ " is not available in menu table");
	}

	@Then ("^Click settings icon for menu (.+)$")
	public void click_menu_settings_icon(String menuName){
		menuName =  (String) base.getGDValue(menuName);
		adminPanel.clickMenuSettingsIcon(menuName);
	}

	@Then ("^Edit First Menu Link name to (.+) in the dropped menu items$")
	public void edit_menu_link_name(String linkName) throws Exception	{
		linkName =  (String) base.getGDValue(linkName);
		adminPanel.editMenuLinkName(linkName);
	}
	
	@Then("^Redirect to Language Configuration under Settings tab$")
	public void view_Language_Configuration_Page() throws Exception {
		adminPanel.viewLanguageConfigurationPage();
	}
	
	@Then("^Get the number of languages added$")
	public void get_num_of_languages_add() {
		List<WebElement> list = adminPanel.ListinLanguagetable();
		for(int i=0; i<list.size();i++) {
			if(list.size()>1) {
				System.out.println(list.get(i).getText());
			}
			else {
				adminPanel.selectLanguageFromDropdown("Français - FR");
//				throw new SkipException("Only" +list.get(i).getText() +"Language is getting dispayed. No internationalization Enabled.");
			}
		}
	}
	
	@Then("^Verify user lands on Add Language Page$")
	public void add_Language_header_text() {
		//language = (String) base.getGDValue(language);
		Assert.assertEquals(adminPanel.verifyAddLanguagePageHeaderText(), "Add language", "Verify Add language page is displayed");
		//if(adminPanel.getLanguagTableText().contains(language))
		//	throw new SkipException("Language already added");
	}
	
	@When("^Select Language from Add language Dropdown (.+) and Click Add$")	
	public void select_Language_From_Dropdown(String language) {
		language = (String) base.getGDValue(language);
		adminPanel.selectLanguageFromDropdown(language);
	}
	
	@Then("^(.+) language got successfully installed$")
	public void verify_French_Language_in_Table(String language) {
		language = (String) base.getGDValue(language);
		Assert.assertTrue(adminPanel.getLanguagTableText().contains(language), "Language is successfully installed");
	}
	
	@But("^Delete (.+) language if already installed$")
	public void deleteLanguage(String language) {
		language = (String) base.getGDValue(language);
		if(adminPanel.getLanguagTableText().contains(language)) {
			adminPanel.deleteLanguage(language);
		}
	}
	
	@When("^Switch to (.+) langauge from Language Switcher$")	
	public void click_language_Switcher(String language) throws Exception {
		language = (String) base.getGDValue(language);
		adminPanel.clicklanguageSwitcher(language);
	}
	
	@Then("^User navigates to Add Email Template Page")
	public void add_Email_Template() throws Exception{
		adminPanel.viewAddEmailTemplate();	
	}

	@Then("^Add Invoice Email template and enter text in template fields (.+) , (.+), (.+) and Save$")
	public void enter_Email_Template_Fields(String emailtemplatetype, String emailtemplatetitle, String emailtemplatesubject) throws Exception{
		emailtemplatetype = (String) base.getGDValue(emailtemplatetype);
		emailtemplatetitle = (String) base.getGDValue(emailtemplatetitle);	
		emailtemplatesubject = (String) base.getGDValue(emailtemplatesubject);
		adminPanel.enterEmailTemplateFields(emailtemplatetitle, emailtemplatetype, emailtemplatesubject);	
	}
	
	@Then("^Add Payment Email template and enter text in template fields (.+) , (.+), (.+) and Save$")
	public void enter_Payment_Email_template_Fields(String emailtemplatetype, String emailtemplatetitle, String emailtemplatesubject) throws Exception{
		emailtemplatetype = (String) base.getGDValue(emailtemplatetype);
		emailtemplatetitle = (String) base.getGDValue(emailtemplatetitle);	
		emailtemplatesubject = (String) base.getGDValue(emailtemplatesubject);
		adminPanel.enterEmailTemplateFields(emailtemplatetitle, emailtemplatetype, emailtemplatesubject);	
	}
	
	@When("^User navigates to Add new Invoice Template page$")
	public void view_Invoice_template_Listing_page() throws Exception{
		adminPanel.editInvoiceTemplate();
	}
	
	@Then("^User Enters text in Invoice template (.+)$")
	public void enter_Invoice_template_text(String invoicetemplatetitle) throws Exception{
		invoicetemplatetitle = (String) base.getGDValue(invoicetemplatetitle);
		adminPanel.enterinvoiceTemplateFields(invoicetemplatetitle);
	}
	
	@Then("^User Selects Email Templates (.+), (.+) and save$")
	public void select_email_template(String paymentEmailType , String invoiceEmailType) throws Exception{
		adminPanel.selectemailtemplateandsave(paymentEmailType, invoiceEmailType);
	}
	
	@And("^Click on Invoices, Add New Invoices and Enter Invoice Title$")
	public void clickInvoicesAddNewInvoices() throws Exception{
		cms.clickInvoices();
		cms.clickAddNewInvoice();
		
	}
	
	@And("^Click on Invoices, View Invoices and Gear$")
	public void clickInvoicesViewInvoices() throws Exception{
		cms.clickInvoices();
		cms.clickViewInvoicesClickGear();
	}
	
	@And("^Enter details in ALL LABELS Tab$")
	public void enterInvoiceTitleAndAllLabels() throws Exception{
		cms.enterInvoiceTitleAndAllLabels();
	}
	
	@And("^Enter details in INVOICE SUMMARY Tab$")
	public void enterInvoiceSummary() throws Exception{
		cms.enterInvoiceSummary();
	}
	
	@And("^Enter details in PAYMENT Tab$")
	public void enterPayment() throws Exception{
		cms.enterPaymentDetails();
	}
	
	@And("^Enter details in REVIEW Tab$")
	public void enterReview() throws Exception{
		cms.enterReviewDetailsAndClickSubmit();
	}
	
	@And("^Click on Setting Tab and Sign In Component$")
	public void clickSettingSignInComponent() throws Exception{
		cms.clickSettingAndSignInComponent();
	}
	
	@And("^Click on Interstitial Sign In Gear and Enter Details$")
	public void clickInterstitialAndEnterDetails() throws Exception{
		cms.enterCreateAccountInterstitialDetails();
		cms.enterSignInInterstitialDetails();
		cms.enterForgetPasswordInterstitialDetailsAndSubmit();
	}
	
	@And("^Click on Homepage Sign In Gear and Enter Details$")
	public void clickHomePageAndEnterDetails() throws Exception{
		cms.enterCreateAccountHomePageDetails();
		cms.enterSignInHomePageDetails();
		cms.enterForgetPasswordHomePageDetailsAndSubmit();
	}
	
	@And("^Click on Change Password Gear and Enter Details$")
	public void clickChangePasswordAndEnterDetails() throws Exception{
		cms.enterChangePasswordDetailsAndSubmit();
	}
	
	@And("^Click on Claim Sign In Gear and Enter Details$")
	public void clickClaimPageAndEnterDetails() throws Exception{
		cms.enterCreateAccountClaimDetails();
		cms.enterSignInClaimDetails();
		cms.enterForgetPasswordClaimDetailsAndSubmit();
	}
	
	@And("^Verify the Home Page Labels - Create, Sign in and Forgot$")
	public void verifyHomePageLabels() throws Exception{
		cms.verifyHomePageSignInLabel();
		cms.verifyHomePageSignUpLabel();
		cms.verifyHomePageForgotPasswordLabel();
	}
	
	@And("^Verify the Interstitial Labels - Create, Sign in and Forgot$")
	public void verifyInterstitialLabels() throws Exception{
		cms.verifyInterstitialSignInLabel();
		cms.verifyInterstitialSignUpLabel();
		cms.verifyInterstitialForgotPasswordLabel();
	}
	
	@And("^Verify the Claim Labels - Create, Sign in and Forgot$")
	public void verifyClaimLabels() throws Exception{
		cms.verifyClaimSignInLabel();
		cms.verifyClaimSignUpLabel();
		cms.verifyClaimForgotPasswordLabel();
	}
	
	@And("^Verify Change Password Labels$")
	public void verifyChangePasswordLabels() throws Exception{
		cms.verifyChangePasswordLabels();
	}
}