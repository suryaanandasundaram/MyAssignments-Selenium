Feature: Salesforce Create New Opportunity

Background:
Given Open the Chrome browser,Maximize and set the Time out
And Load the application "https://login.salesforce.com"


@Smoke
Scenario Outline: SA001- Verify the new Opportunity creation
And Enter Username as <username>
And Enter Password as <password>
And Enter Login in Salesforce
And Click on toggle menu button from the left corner
And Click View All and click Sales from App Launcher
And Click on Opportunity tab
And Click on New button
And Enter Opportunity name as <oppname>
And Choose close date as Today
And Select Need Analysis as "Stage"
When Click on Save
Then Verify Opportunityname

Examples:
|username|password|oppname|
|'hari.radhakrishnan@qeagle.com'|'Testleaf$321'|'Salesforce Automation by Suryaprabha'|
