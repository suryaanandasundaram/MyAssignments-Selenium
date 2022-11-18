Feature: LeafTaps Edit Lead Story



@Smoke @Edit
Scenario Outline: TC002 -Verify the Edit Lead with company name update

And Click on Find Leads
And Click on the First displayed LeadID
And Click on Edit Button
And Update Company Name as <company>
When Click on Update Button
Then Verify the updated company name

Examples:
|company|
|'SRM'|



