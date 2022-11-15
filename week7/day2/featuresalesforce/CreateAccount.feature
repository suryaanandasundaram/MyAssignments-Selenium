Feature: Salesforce Create New Account

Background:
Given CA-Open the Chrome browser,Maximize and set the Time out
And CA-Load the application "https://login.salesforce.com"


@Smoke @Sanity
Scenario Outline: SA003- Verify the new Dashboard Creation
And CA-Enter Username as <username>
And CA-Enter Password as <password>
And CA-Enter Login in Salesforce
And CA-Click on toggle menu button from the left corner
And CA-Click View All and click Sales from App Launcher
And CA-Click on Account tab
And CA-Click on New button
And CA-Enter name as <accountname>
And CA-Enter Ownership as public
When CA-Click on Save
Then CA-Verify newly created account name

Examples:
|username|password|accountname|
|'hari.radhakrishnan@qeagle.com'|'Testleaf$321'|'Suryaprabha'|
