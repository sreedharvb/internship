@ForgotPasswordTests
Feature: Recover Password from Forgot your password link Tests

  @PasswordRecoveryPage
  Scenario: To verify Forgot your password link loads Recover your password page
    Given   i am in login page "http://demo.dontonno.com/cms-test-v2/auth/login"
    When    i click Forgot your password link
    Then    i should be in Recover your Password page

  @RecoverAdminPassword
  Scenario: Verify if the forgot your password link provides password recovery
    Given   i am in login page "http://demo.dontonno.com/cms-test-v2/auth/login"
    When    i click Forgot your password link
    And     i enter valid admin emailID into Username field "admin@coaching.com"
    And     i click Send Recovery Link button
    Then    recovery mail should be sent and login page should be loaded with message "Password Reset Email Sent"

  @RecoverPasswordUnRegEmail
  Scenario: Verify Recover password when unregistered email is entered
    Given i am in login page "http://demo.dontonno.com/cms-test-v2/auth/login"
    When    i click Forgot your password link
    And     i enter unregistered email ID into Username field "testerone@coaching.com"
    And     i click Send Recovery Link button
    Then    i should see the no record of that error message "No record of that email address."

  @RecoverPasswordBlankUserName
  Scenario: Verify Recover password when username field is left blank
    Given i am in login page "http://demo.dontonno.com/cms-test-v2/auth/login"
    When    i click Forgot your password link
    And     i leave Username field blank
    And     i click Send Recovery Link button
    Then    i should see the email address required error message "The Email Address field is required."
