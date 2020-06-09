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
   Description: Add list of users to the users table using csv file.

2. URI: "/download/{file}"
   METHOD: GET
   Description: Download errored records by entering the file name.

# Guide
1. Import as a maven project into your local codebase.
2. Change database credentials in application.properties. 
