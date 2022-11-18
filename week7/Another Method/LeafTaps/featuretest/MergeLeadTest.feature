Feature: LeafTaps Merge LeadStory

@Smoke @Merge
Scenario: TC004 -Verify the Merge Contacts

And Click on Contacts
And Click on Merge Contacts
And Click on Widget of From Contact 
And Select first result
And Click on Widget of To Contact 
And Select second result
When Click on Merge button
Then Accept the Alert
And Verify the title of the page after merge
