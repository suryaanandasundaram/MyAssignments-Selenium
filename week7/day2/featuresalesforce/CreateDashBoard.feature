Feature: Salesforce Create New Dashboard

Background:
Given CD-Open the Chrome browser,Maximize and set the Time out
And CD-Load the application "https://login.salesforce.com"


@Smoke @Sanity
Scenario Outline: SA002- Verify the new Dashboard Creation
And CD-Enter Username as <username>
And CD-Enter Password as <password>
And CD-Enter Login in Salesforce
And CD-Click on toggle menu button from the left corner
And CD-Enter "Dashboards" and select from result list
And CD-Click on New Dashboard
And CD-Enter name as <dashboardname>
When CD-Click on Create
Then Verify newly created Dashboard name

Examples:
|username|password|dashboardname|
|'hari.radhakrishnan@qeagle.com'|'Testleaf$321'|'Salesforce Automation by Suryaprabha'|
