Feature: Salesforce Create New Account


@Smoke @Sanity @Account
Scenario Outline: SA003- Verify the new Dashboard Creation


And Click View All and click Sales from App Launcher
And Click on Account tab
And Click on New button
And Enter Account name as <accountname>
And Enter Ownership as public
When Click on Save
Then Verify newly created account name

Examples:
|accountname|
|'Suryaprabha'|
