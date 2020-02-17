# BabelShark
A demo project featuring Spring Boot, MySQL, Hibernate, ORM, Spring MVC, Thymeleaf

BabelShark is an E-registry for a fictitious languages school (Like BabelFish, the fish-translator from the Hitch-Hikers' guide, only it's a shark). It is meant to track students' grades and tuition fees, held lessons, exams taken etc. It is meant to be used by teachers, students and the school administration staff.

To test the app, you can also use the embedded H2 DB- add the required dependencies and change datasource parameters
in the application.properties.
-----------------------------------------------------------------------------------------


17.02.2020: It's been a while since I worked on Babelshark- I had pretty much abandoned it as a Demo project for the CV that helped me find my first IT job, but a few days back I decided to return to it: I wanted to use it as a testing arena for some of the skills I learned at work, and do some related experiments. 
To cut the long story short, in the past three days I managed to get the hang of Webpack dev server + hot module replacement (yes, before this I really installed the project anew every time I made changes on the front end :O); I managed to get around the CORS issue (which I also encountered at work), and I finally imported react-bootstrap as npm module.

---------------------------------------------------------2019-----------------------------------------------------------------

07.04: I made the first big step in implementing React.js. After several unsuccessful Maven builds I finally managed to make the WebPack plugin pack the js files to a bundle.js (koji je to bezobrazluk da Webpack pretresa KOMENTARE? i zali se na nepostojece commented-out importe??). 

I'm really starting to like the modularity of React.js. For now I have made that single student list component, and added buttons which will call/fetch grades and payments info from a Spring REST controller which means I will no longer need separate static HTML pages for every batch-info display, but will update all components asynchronously instead. 
TO DO: replace the native fetch method with async/await method as I've seen people do around the Internets.

22.03: It's been a while since the last update- I've been learning big and diverse stuff such as RxJava, Retrofit library (a slight digression into Android programming) as well as... React.js. Today I started translating the pages of HTML+Thymeleaf into React.js components and such. In other words, Babelshark gets a whole new and improved Frontend ;)
Also, Maven was a little fussy about the Frontend plugin for Node and NPM (it wouldn't clean install the project from Eclipse properly so I C&Ied it from the command prompt. I've also installed Node and NPM on my machine to facilitate the design of pages, and as soon as I finish the most of the View, I will Webpack it and ship it bundled(js) to the Spring app, and upload it to gitHub.

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
-add Jasper report with data for each student;
-Use RxJava and Optionals;
-Add Admin Control panel for manually processing user's role-requests by newly registered users;
-Add Course/Group views to be available to users with 'Teacher' and 'Admin' role;
-Have a beer.

Small ToDos:
-I18n: export labels to .properties files;
-Course prices and descriptions: DB table and a view template available to non-authenticated users;
-Tidy up that code a little :)



