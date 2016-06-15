## Linking Mysql using Servlets and render data using Jquery Datatable library and AJAX

- This is fairly simple to use.
- Servlet is in your Dbconenct.java file where in doGet method it calls MySqlConnect class and in that file it actually sets up a connection to the mysql and queries that needs to be done.

- Basically in index.jsp it calls the ajax which calls the servlet and servlet calls MySqlConnect class with takes the data and render that into the html using Datatable library on Jquery.   
