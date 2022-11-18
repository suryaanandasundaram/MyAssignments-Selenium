Feature: LeafTaps Create Lead Story


@Smoke @Create
Scenario Outline: TC0010 -Verify the Create Lead with valid credentials
And Click on Create Leads
And Enter Company Name as <cname>
And Enter FirstName as <fname>
And Enter LastName as <lname>
When Click on CreateLead button
Then Verify new lead created with given details

Examples:
|cname|fname|lname|
|'SRM'|'Surya'|'Prabha'|









