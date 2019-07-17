Feature: Typeform
	
	Scenario: Typeform feature verification at summary position

		And User navigates to /user/login from NAM
   	When User login into CMS
    Then User navigates to superadmin setting of typeform
		When user verifies typeform configuration at admin setup
		Then User select typeform
		When User navigates to /invoice from NAM
		When User landed on interstitial page and enters %{GD_EMAIL_ADDRESS} and %{GD_PASSWORD}
    Then User is on Invoice page and Invoice list is displayed
    When User selects payment plan invoice %{GD_EMAIL_ADDRESS},%{GD_PASSWORD}
    Then Invoice Summary is displayed with Due Amount and Continue button
    When Continue button gets display
    Then Verify survey tab gets display
    And Payment card is select and Amount is autopopulated
    And MOP has same card as displayed in UI
    When User enters %{GD_AMOUNT},pay today gets updated, user clicks on Continue button
    When User clicks on Continue button in Payment Section
    Then Review Your Payment section is displayed with Confirm button
    When User clicks on Confirm button
    Then Confirm Payment pop-up is displayed
    When User enters cvv,clicks on Continue button in Confirm Payment
    Then Payment should be successfull and amount should get updated
    
    Scenario: Typeform feature verification at payment position

		And User navigates to /user/login from NAM
   	When User login into CMS
    Then User navigates to superadmin setting of typeform
		When user verifies typeform configuration at admin setup
		Then User select typeform at payment position
		When User navigates to /invoice from NAM
		When User landed on interstitial page and enters %{GD_EMAIL_ADDRESS} and %{GD_PASSWORD}
    Then User is on Invoice page and Invoice list is displayed
    When User selects payment plan invoice %{GD_EMAIL_ADDRESS},%{GD_PASSWORD}
    Then Invoice Summary is displayed with Due Amount and Continue button
    When Continue button gets display
    And Payment card is select and Amount is autopopulated
    And MOP has same card as displayed in UI
    When User enters %{GD_AMOUNT},pay today gets updated, user clicks on Continue button
    When User clicks on Continue button in Payment Section
    Then Review Your Payment section is displayed with Confirm button
    When User clicks on Confirm button
    Then Confirm Payment pop-up is displayed
    When User enters cvv,clicks on Continue button in Confirm Payment
    Then Typeform submitted and Payment should be successfull and amount should get updated
   	