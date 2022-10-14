# eb_api_test

# what to expect
- a simple http request client using retrofit in order to fetch the properties and show their titles.
- every time you click on the button the log console will show you the pagination and the property titles.
- a very simple separation in layers has been proposed here to maintain clean architechture. you will find an activity (view) that calls the repository who handles de api request.

#what has been found
- while running some testing I noticed that if you use a page over the total amount of pages (currently 840 I think) the expected content is suposed to be empty what is correct but the pagination brings the page with number 44... I think that the backEnd is overfloating here and gives back this value when the correct thing would be to get the same page as the param sent. Check this please.
