# BabelShark
A demo project featuring Spring Boot, MySQL, Hibernate, ORM, Spring MVC, Thymeleaf

The MySQL schema is enclosed in the resources dir. 
It is meant to contain login info as well (usernames, passwords and roles of app users).

To test the app, you can also use the embedded H2 DB- add the required dependencies and change datasource parameters
in the application.properties.

04.01.2019: I played a little with Javascript, jQuery and Ajax and made a little REST Random Quote/Wisdom 
Generator on the Students.html page. A click on a given button or page refresh elicits a new random quote straight from the MySql DB via Spring Rest Controller. The javascript files are stored in resources/static/js folder. Neat :)

03.01.2019: Happy New Year! Today I played around with Thymeleaf arithmetic operations (subtraction) a little
and added a label for remaining tuition fees (payments.html). For now all courses cost 10500, but I guess it wouldn't hurt to add a table with different courses, descriptions and prices and a new view template to present it all.

Notable milestones completed last year:
-Mapped the Payment POJO as ManyToOne (to Student);
-Mapped the Grade POJO as ManyToMany (to Student), whereas it could have also worked as ManyToOne;
-Designed the most of the BabelShark DB using native MySQL (yet to add the Group table for individual courses);

Big ToDos:
-Configure Spring Security (Users and Roles tables are ready; need a class to extend WebSecurityConfigureAdapter);
-Add Course/Group .html views to be available to users with 'Teacher' and 'Admin' role;

Small ToDos:
-I18n: export labels to .properties files;
-Course prices and descriptions: DB table and a view template available to non-authenticated users;
-data.sql schema, to add example users;
-Tidy up that code a little :)



