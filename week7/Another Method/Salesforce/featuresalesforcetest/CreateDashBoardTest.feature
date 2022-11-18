Feature: Salesforce Create New Dashboard


@Smoke @Sanity @Dashboard
Scenario Outline: SA002- Verify the new Dashboard Creation


And Enter "Dashboards" and select from result list
And Click on New Dashboard
And Enter name as <dashboardname>
When Click on Create
Then Verify newly created Dashboard name

Examples:
|dashboardname|
|'Salesforce Automation by Suryaprabha'|
