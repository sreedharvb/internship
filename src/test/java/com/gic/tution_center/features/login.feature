Feature: Login validation

  @login
  Scenario: Login validation with valid credentials
  Given i am on the login page url "http://demo.dontonno.com/cms-test-v2/"
  When i enter username as "admin@coaching.com"
  And i enter the password as "22091671"
  And i click the login button
  Then i should be on the dashboard page