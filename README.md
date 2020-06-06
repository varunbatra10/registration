# Library-Managment-System
 An API to manage library operations like find, borrow and return

# Users Schema
user_id
borrowed_qty
name

## API Methods
1. URI: "/users"
   METHOD: POST
   Description: Add list of users to the users table.

2. URI: "/users"
   METHOD: DELETE
   Description: Delete all users from the users table.

#Books Schema
book_id
borrowed_qty
name
total_qty

## API Methods
1. URI: "/books"
   METHOD: POST
   Description: Add list of books to the books table.

2. URI: "/books"
   METHOD: DELETE
   Description: Delete all books from the books table.

3. URI: "/books/find"
   METHOD: GET
   Description: Get all books from the books table which are not borrowed or which are available to be borrowed from the library.

4. URI: "/books/borrow"
   METHOD: POST
   Description: Pass user_id and book_id as BorrowDto object to borrow a book from the library.
   An existent user would only be able to borrow book or else would return "User doesn't exist".
   An user can't borrow more than 2 books at a time or else would return "You can't borrow more than 2 books".
   An user can't borrow more than one cop of a book or else would return "You can't borrow more than one copy".
   If all the copies of a book are borrowed then no user would be able to borrow it and it would return "No copies of the book are available".
 
5. URI: "/books/return"
   METHOD: POST
   Description: Pass user_id and book_id as BorrowDto object to return a book to the library and would return "Book is returned".
   Pass user_id as BorrowDto object to return all books to the library and would return "All Books are returned".

# JUNIT TestCases
Test cases are executed in a sequential order that's why named alphabetically so that insert operation is performed before running any test case and delete operation is performed after running all the testcases.

# Guide
1. Import as a maven project into your local codebase.
2. Change database credentials in application.properties. 
3. Run as Junit Test for running the Junit testcases.
4. Run as java application and try to hit the API's using postman.
