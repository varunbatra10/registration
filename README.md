# Registration
 An API to add users using csv file and download errored records

# Users Schema
id
Email
name

# Role Schema
id
name


## API Methods
1. URI: "/register"
   METHOD: POST
   Description: Add list of users to the users table using csv file and errored users to a csv file.
   Return: This API returns passed records, failed records and failed records file url.

2. URI: "/download/{file}"
   METHOD: GET
   Description: Download errored records by entering the file name.
   Return: This API returns a csv file which contains errored records.

## Junit Testcases
1. Testcase to check "register" API is working or not.
2. Testcase to check "download" API is working or not.

# Guide
1. Import as a maven project into your local codebase.
2. Change database credentials in application.properties. 
