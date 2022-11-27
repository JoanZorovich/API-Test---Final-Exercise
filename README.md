# API-Test - User Bank

Four tests are performed in this repository, using the API [mockapi](https://mockapi.io/projects).

- Only one [end point](https://mockapi.io/projects/637bd29d72f3ce38ea95f585) was used to perform all the tests. 

## - Test 1
Verify the Endpoint is empty (If it has any data use the DELETE request to clean and leave it empty)

## - Test 2
Initialize the POJO with 10 random data.  Also, make a code verification for avoiding duplicate email accounts. Then, perform the POST request.

## - Test 3
Make the GET request, asserting that there are not duplicate email accounts.

## - Test 4
Add a test to update an existing AccountNumber
