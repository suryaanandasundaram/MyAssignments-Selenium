Feature: Create New Incident in ServiceNow




@CreateIncident @Smoke
Scenario Outline:TC001-Verify the Create Incident with valid credentials
And Enter Username as <username>
And Enter Password as <password>
And Click Login
And Click on All
And Click Incidents in Filter navigator
And Click on Create New option
And Enter Description as <desc>
When Click submit button
Then Give the newly created Incident number in search field
And Confirm incident exists

Examples:
|username|password|desc|
|'admin'|'mc/-vASs9V1E'|'Created via Automation-Surya'|