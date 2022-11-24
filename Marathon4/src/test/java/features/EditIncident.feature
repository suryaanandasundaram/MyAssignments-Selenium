Feature: Edit Incident in ServiceNow


@EditIncident @Smoke
Scenario Outline:TC002-Verify the Edit Incident in ServiceNow
And Enter Username as <username>
And Enter Password as <password>
And Click Login
And Click on All
And Click Incidents in Filter navigator
And Click the first Incident
And Get Incident Number
And Enter urgency as <urgency>
And Enter state as <state>
And Enter edit Description as <shortdesc>
When Click Update button


Examples:
|username|password|urgency|state|shortdesc|
|'admin'|'mc/-vASs9V1E'|'1 - High'|'In Progress'|'Edited via Automation-Surya'|