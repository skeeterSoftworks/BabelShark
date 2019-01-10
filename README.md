# BabelShark
A demo project featuring Spring Boot, MySQL, Hibernate, ORM, Spring MVC, Thymeleaf

BabelShark is an E-registry for a fictitious languages school (Like BabelFish, the fish-translator from the Hitch-Hikers' guide, only it's a shark). It is meant to track students' grades and tuition fees, held lessons, exams taken etc. It is meant to be used by teachers, students and the school administration staff.

To test the app, you can also use the embedded H2 DB- add the required dependencies and change datasource parameters
in the application.properties.

10.01: After wrestling with erroneous logging in for a couple of hours, I've redesigned the User model on a "kako-je-Bog-rekao" basis: I added the 'active' column (which may be used to temporarily suspend user profiles) to please the AuthenticationManagerBuilder. I tried to make a model with just e-mail, username and password but it wouldn't work.
I added the Registration.html page- it works like a charm, but all new users are registered as ADMINs by default (experimental version). NEW TODO: Designing an admin page where existing admins will manually set roles of newly-registered users as either teachers or students and enable/disable their profiles (or approve their role-requests or something).

09.01: Okay, today I have done most of the dirty work of implementing Spring Security: redesigned the MySQL DB,
added dependencies for spring-starter-security and Mockito, remodeled the User and Role class (added ManyToMany
mapping), added two configuration classes (for defining Password Encryption Bean and for Http security). It works! The attempt to access to Students.html now redirects to the login page, while visitors can stick around
the home page. I haven't yet made rigged the login.html for actual logging in, and the app still needs the 
sign up page. I'll leave it for the next couple of days.
Also, I have started using Mockito; so far I've been cramming up unnecessary entries into the DB with plain old
jUnit (and the actual StudentRepository object). Aaaand last but not the least, I added validation to Student object, which means no more empty fields or invalid passwords. I'll be gitting up all the files as soon as I finish the views. I think I'll have myself a beer now.

04.01.2019: I played a little with Javascript, jQuery and Ajax and made a little REST Random Quote/Wisdom 
Generator on the Students.html page. A click on a given button or page refresh elicits a new random quote straight from the MySql DB via Spring Rest Controller. The javascript files are stored in resources/static/js folder. Neat :)

03.01.2019: Happy New Year! Today I played around with Thymeleaf arithmetic operations (subtraction) a little
and added a label for remaining tuition fees (payments.html). For now all courses cost 10500, but I guess it wouldn't hurt to add a table with different courses, descriptions and prices and a new view template to present it all.

Notable milestones completed last year:
-Mapped the Payment POJO as ManyToOne (to Student);
-Mapped the Grade POJO as ManyToMany (to Student), whereas it could have also worked as ManyToOne;
-Designed the most of the BabelShark DB using native MySQL (yet to add the Group table for individual courses);

Big ToDos:
-Add Admin Control panel for manually processing user's role-requests by newly registered users;
-Add Course/Group .html views to be available to users with 'Teacher' and 'Admin' role;
-Have a beer.

Small ToDos:
-I18n: export labels to .properties files;
-Course prices and descriptions: DB table and a view template available to non-authenticated users;
-Tidy up that code a little :)



