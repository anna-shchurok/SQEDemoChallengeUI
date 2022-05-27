## Demo Challenge

#### Instructions
1. Complete the project setup as listed below
2. Complete the Exercise
3. Email a link to your EPAM git repo containing the completed exercise to: Ruslan_Kashapau@epam.com


#### Expectations
We will be evaluating
1. Naming conventions
2. Code readability
3. Code encapsulation
4. Code structure and organization
5. Quality of test cases
6. Variety  of testing types (examples: boundary, happy path, negative, etc) 


#### Technologies
1. Java
2. Selenium
3. TestNG
4. Any other technologies you see fit.
5. Please do not use a BDD framework.

#### Project Setup
1. Clone this project to your EPAM git account
2. Setup the project in your IDE
3. Open the index.html file from src/test/resource/files in a browser
4. Copy the url from the browser and update the url value in src/test/resource/config.properties to be the copied url.
5. In src/test/resources update the config.properties file platform for your OS.
6. From command line run mvn clean install -U -DskipTests
7. Make sure you can run the DemoTest and chrome launches.  You may need to update the chromedriver in /src/test/resources/chromedriver/ to the version that works with your browser
   https://chromedriver.chromium.org/


#### Exercise
1. Use the site at the index.html
2. There are helper locators provided for you in the src/test/resource/files/locators.txt file.
3. In the Test Cases section below:
  - List all of the test cases you think are necessary to test the sample page
  - Note any defects or issues observed
4. Code up a few examples of:
  - At least one happy path case placing an order
  - At least one error case
5. When complete please check your code into your public git repo

#### Test Cases
 1. SMOKE - HAPPY PATH - DEFAULT VIEW OF FORM
 - Pizza 1 dropdown is shown with chosen "Choose pizza" option
 - Pizza 1 dropdown has values:
                               Small 6 Slices - no toppings $6.75
                               Small 6 Slices - 1 topping $7.50
                               Medium 8 Slices - 2 toppings $9.75
                               Large 10 Slices - no toppings $11.75
                               Large 10 Slices - 2 toppings $13.50
 - Topping 1 dropdown is shown with chosen "Choose a Toppings 1"
 - Topping 1 dropdown has values:
                               Diced Mango
                               Olives
                               Mushrooms
                               Caramelized onions
                               Italian Ham
                               Classic Pepperoni
                               Salami
                               Provolone cheese
                               Extra cheese
                               Mozzarella cheese
                               Parmesan cheese
 - Topping 2 dropdown is shown with chosen "Choose a Toppings 2"   
 - Topping 2 dropdown has values:
                               Diced Mango
                               Olives
                               Mushrooms
                               Caramelized onions
                               Italian Ham
                               Classic Pepperoni
                               Salami
                               Provolone cheese
                               Extra cheese
                               Mozzarella cheese
                               Parmesan cheese
 - Quantity input has value 0
 - Costs input has value 0.00
 - Name, email, phone input are empty
 - 2 Payment options are present, none of them selected
 - Place order and Reset buttons are present

 2. SMOKE - HAPPY PATH - ABILITY TO PLACE ORDER 
 - select any Pizza
 - update Quantity to 1
 - fill required fields: name and phone
 - select any payment
 - click on [Place order]
 - verify modal window is shown with "Thank you for your order! TOTAL:" and price and name of selected pizza
 
 3. NEGATIVE - INABILITY TO PLACE ORDER WITH NO REQUIRED FIELDS
 - select any Pizza
 - update Quantity to random single-digit number
 - click on [Place order]
 - verify modal window is shown with text "Missing name\nMissing phone number"
 - select any Pizza
 - update Quantity to 1
 - fill Name field
 - click on [Place order]
 - verify modal window is shown with text "Missing phone number"
 - select any Pizza
 - update Quantity to 1
 - fill Phone field
 - click on [Place order]
 - verify modal window is shown with text "Missing name"  
  
 4. HAPPY PATH - ABILITY TO RESET THE FORM
 - select any Pizza
 - select any Topping 1 and Topping 2
 - update Quantity with any number
 - fill name, phone and email
 - select any payment
 - click on [Reset]
 - verify all filled fields are cleared
 
 5. NEGATIVE - BOUNDARY - QUANTITY FIELD VALIDATION
 - update Quantity with negative number
 - verify it's unable to pass negative number
 - update Quantity with number 123456
 - verify it's unable to pass more than 5 numbers (figure '6' is truncated)
 - update Quantity with any 5-length string
 - verify it's unable to pass strings
 - update Quantity with any 5 special characters
 - verify it's unable to pass special characters
  
 6. NEGATIVE - BOUNDARY - NAME FIELD VALIDATION
 - update Name field with 101 characters string (mix Uppercase and Lowercase)
 - verify Name field has first 100 characters
 - update Name field with numbers
 - unable to type numbers
 - update Name field with special characters
 - unable to type special characters
 - update Name field with several spaces
 - error message "Please enter valid name" below input is shown
 - update Name field with string + space + string
 - no error message is shown 

 7. NEGATIVE - BOUNDARY - EMAIL FIELD VALIDATION
 - update Email field with 101 characters string
 - verify Email field has first 100 characters
 - update Email field with invalid email form (without @)
 - error message below input shown "Invalid email format"
 - update Email field with valid format email (string@string.com)
 - error message is not shown
 
 8. NEGATIVE - BOUNDARY - PHONE FIELD VALIDATION
 - update Phone field with 101 number characters
 - verify Phone field has first 100 characters
 - update Phone field with string
 - unable to type alphabet characters
 - update Phone field with special characters
 - unable to type special characters

 9. NEGATIVE - BOUNDARY - COST FIELD VALIDATION
 - update Cost field with any character or number
 - verify field is read-only and cannot be updated
 - select any Pizza
 - update Quantity to 1
 - verify Costs is updated as per price for Pizza
 - updated Quantity to any number
 - verify Cost is updated as Pizza price * Quantity
 - select another pizza
 - verify Cost is updated as Pizza price * Quantity
 
 ### Improvements
 1. Make Pizza dropdown required
 2. Make Quantity required
 3. Show Toppings fields when Pizza with toppings is selected
 4. Add format validation for fields Name, Phone, Email
 
 ### Bugs
 1. Cost field is not getting updated after selecting Pizza and any Toppings
 2. Able to order with quantity 0
 3. Able to put negative value/string/special characters to Quantity
 4. Able to order with no payment selected
 5. Able to order with no Pizza selected
 6. Toppings 1 is not reset when Reset button is clicked
