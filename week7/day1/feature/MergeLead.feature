Feature: LeafTaps Merge LeadStory

Background:
Given ML-Open the Chrome browser,Maximize and set the Time out
And ML-Load the application "http://leaftaps.com/opentaps/control/main"
@Smoke
Scenario Outline: TC004 -Verify the Merge Contacts
And ML-Enter Username as <username>
And ML-Enter Password as <password>
And ML-Enter Login
And ML-Click CRMSFA link
And ML-Click on Contacts
And ML-Click on Merge Contacts
And ML-Click on Widget of From Contact and select first result
And ML-Click on Widget of To Contact and select second result
When ML-Click on Merge button
Then ML-Accept the Alert
And ML-Verify the title of the page

Examples:
|username|password|
|'Demosalesmanager'|'crmsfa'|