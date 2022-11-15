Feature: LeafTaps Duplicate Lead Story

Background:
Given DL-Open the Chrome browser,Maximize and set the Time out
And DL-Load the application "http://leaftaps.com/opentaps/control/main"
@Sanity
Scenario Outline: TC003 -Verify the Duplicate Lead with phonenumber
And DL-Enter Username as <username>
And DL-Enter Password as <password>
And DL-Enter Login
And DL-Click CRMSFA link
And DL-Click on Leads
And DL-Click on Find Leads
And DL-Click on Phone
And DL-Enter Phonenumber as <phonenumber>
And DL-Click on Find Leads Button
And DL-Click on the First displayed LeadID
And DL-Click on DuplicateLead Button
When DL-Click on CreateLead button
Then DL-Verify the created lead

Examples:
|username|password|phonenumber|
|'Demosalesmanager'|'crmsfa'|'88'|
|'Demosalesmanager'|'crmsfa'|'99'|