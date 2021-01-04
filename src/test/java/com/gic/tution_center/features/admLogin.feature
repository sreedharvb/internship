@AdminLoginTests
Feature: Validation of Administrator Login
  The user should be able to login with admin credentials.
  The user should be logout when the Logout option is clicked
  The user should be logout when the Logout option is selected using keyboard

  Background:
    Given i am in login page "http://demo.dontonno.com/cms-test-v2/auth/login"

  @AdminLogin
  Scenario: Login validation with administrator credentials
    When  i enter valid value to username field as "admin@coaching.com"
    And   i enter valid value to password field as "22091671"
    And   i click login button
    Then  i should be in application dashboard page

   @AdminLogout
   Scenario: Admin Logout Check
      When   i enter admin username as "admin@coaching.com"
      And    i enter admin password as "22091671"
      And    i click login button
      And    i should see admin login page
      And    i click avatar
      And    i click Logout from drop down
      Then   i should be logged out from admin and login page should be loaded

  @AdminLogoutKeyboard
  Scenario: Admin Logout Check with keyboard
    When   i enter username and password as "admin@coaching.com" and "22091671"
    And    i click login button
    And    i should see admin login page and i click avatar
    And    i press tab to reach Logout from drop down
    And    i press enter key
    Then   i should be logged out from admin and back to login page

  @BlankUsernamePassword
  Scenario: Blank username and password
    When   i leave username and password fields blank and click Login button
    Then   login should fail with messages "The Email/Username field is required." and "The Password field is required."

  @BlankUsername
  Scenario: Blank username field
    When  i leave username field blank and enter valid password into Password field as "22091671"
    And   i click login button
    Then  login should fail with message "The Email/Username field is required."

  @BlankPassword
  Scenario: Blank Password field
    When  i enter valid username and leave the Password field blank as "admin@coaching.com"
    And   i click login button
    Then  login should fail with message "The Password field is required."

  @UnregisteredUsername
  Scenario: Login with un-registered username
    When  i enter un-registered username and password as "testerone@coaching.com" and "tcadln"
    And   i click login button
    Then  login should fail with message "Incorrect Login"

  @IncorrectAdminPassword
  Scenario: Login with incorrect Admin password
    When  i enter valid admin username and incorrect admin password as "admin@coaching.com" and "incorrect234"
    And   i click login button
    Then  login should fail with message "Incorrect Login"

