# GUI-Program


Sprint 1
GUI, basic database

Week 1

Create JavaFX project. See IntelliJ page and IntelliJ Help
Share to private repository on GitHub. See GitHub page.
Create README. Details in Documentation Expectations at bottom of page. 
Week 2

Add a tab view with three tabs: Product Line, Produce, and Production Log
Add a CSS file with some code TutorialsPoint Reference
Quality expectations: see bottom of page
Style expectations: see bottom of page
Documentation expectations: see bottom of page
Week 3

In the Product Line tab
In the AnchorPane
Add a 2x3 GridPane
Add a Label and text field for Product Name in row 0, columns 0 and 1
Add a Label and text field for Manufacturer in row 1, columns 0 and 1
Add a Label and ChoiceBox for Item Type in row 2, columns 0 and 1
Add a Button that says Add Product
Add an event handler to the button click event. For now, just have it print to the console (System.out.println)
Add a Label and a Table View for Existing Products
In the Produce tab
In the AnchorPane
Add a Label and ListView for Choose Product
Add a Label and ComboBox (data type String) for Choose Quantity
Add a Button that says Record Production
For now, just have the button print to the console (System.out.println)
In the Production Log tab
In the AnchorPane
Add a TextArea
Week 4

Install database software if necessary
Create database in a res folder at same level as src folder
Similar to...
create table Product
(
  id int auto_increment,
  name varchar,
  type varchar,
  manufacturer varchar
);

create unique index Product_id_uindex
  on Product (id);

alter table Product
  add constraint Product_pk
    primary key (id);

create table ProductionRecord
(
 production_num int auto_increment,
 product_id int,
 serial_num varchar,
 date_produced datetime
);
Connect to database 
Make sure to commit and push your res folder to the remote repository. 
Week 5

Use a controller for almost all code. 
In the Product Line tab, for the Add Product button event handler, add code to insert a product into the database
You could hard code this statement or build from the user interface, like INSERT INTO Product(type, manufacturer, name) VALUES ( 'AUDIO', 'Apple', 'iPod' );
See JDBC - Insert Records Example
In the Produce tab, for the ComboBox
Populate with values 1-10 in an initialize method in the Controller
To allow the users to enter other values in the combobox, call the method setEditable(true);
To show a default value, call the method getSelectionModel().selectFirst();
Prepare for submission






This program is a 'Try it yourself" type activity with all instructions from class available here:
https://sites.google.com/site/profvanselow/course/cop-3003/oop-project



