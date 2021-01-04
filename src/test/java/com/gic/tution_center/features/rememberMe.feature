@RememberMe
Feature: Testing Remeber Me feature on Login page

  @RememberMeUnchecked
  Scenario: Remember Me unchecked by default
    Given   i am in login page "http://demo.dontonno.com/cms-test-v2/auth/login"
    Then    Remember Me check box is not selected by default

  @RememberMeChecked
  Scenario: Remember me checked
    Given   i am in login page "http://demo.dontonno.com/cms-test-v2/auth/login"
    When    i enter username and password as "admin@coaching.com" and "22091671"
    And     i select Remember Me check box
    And     i click login button
    And     i click avatar
    And     i click Logout from drop down
    And     i restart the browser
    And     i launch the application "http://demo.dontonno.com/cms-test-v2/auth/login"
    Then    i should see the username and password field is remembered and should be login
