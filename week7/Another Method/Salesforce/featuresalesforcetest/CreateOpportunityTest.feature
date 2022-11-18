Feature: Salesforce Create New Opportunity



@Smoke @Opportunity
Scenario Outline: SA001- Verify the new Opportunity creation


And Click View All and click Sales from App Launcher
And Click on Opportunity tab
And Click on New button in the page
And Enter Opportunity name as <oppname>
And Choose close date as Today
And Select Need Analysis as "Stage"
When Click on Save in the page
Then Verify Opportunityname

Examples:
|oppname|
|'Salesforce Automation by Suryaprabha'|
