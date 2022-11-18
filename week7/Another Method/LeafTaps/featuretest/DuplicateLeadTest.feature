Feature: LeafTaps Duplicate Lead Story

@Smoke @Duplicate
Scenario Outline: TC003 -Verify the Duplicate Lead with phonenumber

And Click on Find Leads
And Click on Phone
And Enter Phonenumber as <phonenumber>
And Click on Find Leads Button
And Click on the First displayed LeadID
And Click on DuplicateLead Button
When Click on CreateLead button in the page
Then Verify the created lead

Examples:
|phonenumber|
|'99'|