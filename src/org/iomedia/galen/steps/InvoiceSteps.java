package org.iomedia.galen.steps;

import org.iomedia.common.BaseUtil;
import org.iomedia.galen.common.Utils;
import org.iomedia.galen.pages.Invoice;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InvoiceSteps {
	
	Invoice invoice;
	Utils utils;
	BaseUtil base;
	org.iomedia.framework.Assert Assert;
	
	public InvoiceSteps(Invoice invoice, Utils utils, BaseUtil base, org.iomedia.framework.Assert Assert) {
		this.invoice = invoice;
		this.utils = utils;
		this.base = base;
		this.Assert = Assert;
	}
	
	@Then("^Pending invoice found on NAM with id (.+) and amount due (.+)$")
	public void pending_invoice_found_on_nam_with_id_and_amount_due(String invoiceId, String amtDue) {
		invoiceId = (String) base.getGDValue(invoiceId);
		amtDue = (String) base.getGDValue(amtDue);
		
		if(invoiceId.trim().contains("/"))
			invoiceId = invoiceId.trim().substring(0, invoiceId.trim().lastIndexOf("/"));
		invoice.isInvoiceSelected(Integer.valueOf(invoiceId), null);
		base.sync(5000L);
		Assert.assertTrue(invoice.isInvoiceDetailDisplayed(null), "Verify invoice detail block is displayed");
		invoice.getInvoice(amtDue, Integer.valueOf(invoiceId));
		String invDue = invoice.amountDue();
		Assert.assertEquals(invDue, amtDue, "Verify invoice balance should match with the stp");
	}
	
	@Then("^User clicks on First unpaid invoice$")
	public void click_first_unpaid_invoice() {
		invoice.clickFirstUnpaidInvoiceLink(null);
	}
	
	@Then("^Verify Invoice detail gets displayed$")
	public void verify_invoice_detail() {
		Assert.assertTrue(invoice.isInvoiceDetailDisplayed(null), "Verify invoice detail block is displayed");
	}
	
	@When("^Continue button gets display$")
	public void continue_button_gets_display() {
		invoice.isContinueButtonDisplayed();
		String invDue = invoice.amountDue();
		base.Dictionary.put("InvoiceDue", invDue);
		invoice.clickContinueButton();
	}
	//method identify survey tab displaying
	@Then("^Verify survey tab gets display$")
	public void verify_surveytab_display() {
		Assert.assertTrue(invoice.isSurveyDisplay().trim().contains("Questions"),"Survey tab is not found");
	}
	
	@When("^User clicks on pay in full$")
	public void User_clickon_payinfull() {
		invoice.clickpayInFull();
	}
	
	@Then("^User clicks on continue plan$")
	public void clickc_continue_plan() {
		invoice.clickContinuePlan();
	}
	
	@When("^User select First Card$")
	public void userselectfirstcard() {
		invoice.selectFirstCard();
	}
	
	@Then("^User type Existing CardCVV$")
	public void Usertypeexistingcardcvv() throws Exception {
		invoice.typeExistingCardCVV();
	}
	@Then("^User click Continue Card$")
	public void clickcontunuecards() {
		invoice.clickContinueCard();
	}
	
	@Then("^User click Continue Billing$")
	public void clickContinueBilling() {
		invoice.clickContinueBilling();
	}
	
	@When("^User type Partial Amount (.+) for due amount (.+)$")
	public void typePartialAmount(String partialAmount, String dueAmount) throws Exception {
		partialAmount = (String) base.getGDValue(partialAmount);
		dueAmount = (String) base.getGDValue(dueAmount);
		invoice.typePartialAmount(dueAmount, partialAmount);
	}
	
	@Then("^User select Accept TnC$")
	public void accepttnc() {
		invoice.selectAcceptTnC();
	}
}
