Feature: Delete Incident in ServiceNow

@DeleteIncident @Smoke
Scenario Outline: TC003-Verify the Delete Incident in ServiceNow
And Enter Username as <username>
And Enter Password as <password>
And Click Login
And Click on All
And Click Incidents in Filter navigator
And Click the first Incident
When Click delete Button

Examples:
|username|password|
|'admin'|'mc/-vASs9V1E'|
