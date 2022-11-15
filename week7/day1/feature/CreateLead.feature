Feature: LeafTaps Create Lead Story

Background:
Given Open the Chrome browser,Maximize and set the Time out
And Load the application "http://leaftaps.com/opentaps/control/main"

@Smoke
Scenario Outline: TC0010 -Verify the Create Lead with valid credentials
And Enter Username as <username>
And Enter Password as <password>
And Enter Login
And Click CRMSFA link
And Click on Leads
And Click on Create Leads
And Enter Company Name as <cname>
And Enter FirstName as <fname>
And Enter LastName as <lname>
When Click on CreateLead button
Then Verify new lead created with given details
And Close the Browser
Examples:
|username|password|cname|fname|lname|
|'Demosalesmanager'|'crmsfa'|'SRM'|'Surya'|'Prabha'|


@Sanity
Scenario Outline: TC0011-Verify the Create Lead without company name
And Enter Username as <username>
And Enter Password as <password>
And Enter Login
And Click CRMSFA link
And Click on Leads
And Click on Create Leads
And Enter FirstName as <fname>
And Enter LastName as <lname>
When Click on CreateLead button
Then Verify the error message
And Close the Browser
Examples:
|username|password|fname|lname|
|'Demosalesmanager'|'crmsfa'|'Surya'|'Prabha'|

@Smoke @Sanity
Scenario Outline: TC0012-Verify the Create Lead without first name
And Enter Username as <username>
And Enter Password as <password>
And Enter Login
And Click CRMSFA link
And Click on Leads
And Click on Create Leads
And Enter Company Name as <cname>
And Enter LastName as <lname>
When Click on CreateLead button
Then Verify the error message
And Close the Browser
Examples:
|username|password|cname|lname|
|'Demosalesmanager'|'crmsfa'|'XYZ'|'Prabha'|

@Regression
Scenario Outline: TC0013-Verify the Create Lead without last name
And Enter Username as <username>
And Enter Password as <password>
And Enter Login
And Click CRMSFA link
And Click on Leads
And Click on Create Leads
And Enter Company Name as <cname>
And Enter FirstName as <fname>
When Click on CreateLead button
Then Verify the error message
And Close the Browser
Examples:
|username|password|cname|fname|
|'Demosalesmanager'|'crmsfa'|'XYZ'|'Prabha'|






