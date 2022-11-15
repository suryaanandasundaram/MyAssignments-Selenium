Feature: LeafTaps Edit Lead Story

Background:
Given EL-Open the Chrome browser,Maximize and set the Time out
And EL-Load the application "http://leaftaps.com/opentaps/control/main"

@Smoke
Scenario Outline: TC002 -Verify the Edit Lead with company name update
And EL-Enter Username as <username>
And EL-Enter Password as <password>
And EL-Enter Login
And EL-Click CRMSFA link
And EL-Click on Leads
And EL-Click on Find Leads
And EL-Click on the First displayed LeadID
And EL-Click on Edit Button
And EL-Update Company Name as <company>
When EL-Click on Update Button
Then EL-Verify the updated company name

Examples:
|username|password|company|
|'Demosalesmanager'|'crmsfa'|'SRM'|
|'Demosalesmanager'|'crmsfa'|'STCM'|


