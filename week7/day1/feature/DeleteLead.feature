Feature: LeafTaps Delete LeadStory

Background:
Given DeL-Open the Chrome browser,Maximize and set the Time out
And DeL-Load the application "http://leaftaps.com/opentaps/control/main"
@Smoke
Scenario Outline: TC005 -Verify the Delete Lead
And DeL-Enter Username as <username>
And DeL-Enter Password as <password>
And DeL-Enter Login
And DeL-Click CRMSFA link
And DeL-Click on Leads
And DeL-Click on Find Leads
And DeL-Click on First resulting result
When DeL-Click on delete
And DeL-Verify the title of the page

Examples:
|username|password|
|'Demosalesmanager'|'crmsfa'|