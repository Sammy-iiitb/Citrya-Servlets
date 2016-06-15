<%@ page language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
      <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
      <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
      <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
      <title>JSON</title>
      <script>
      $(document).ready(function() {
          //update();
            //  }
          //alert("q");
          update();

      });
      function update() {
          $.ajax({
              url: "/DbConnect",
              dataType: "text",
              success : function(data) {
                //$("#demo").html("");
                  var json1 = $.parseJSON(data);
                      /*$(json1).each(function(i,val){
                          $.each(val,function(k,v){
                          $("#demo").append(k+" : "+ v + "<br/>");
                        });
                      });*/
                    $('#example').DataTable({
                     destroy: true,
                    data: json1,
                    "columns": [
                      { "data": "CustomerId" },
                      { "data": "CustomerName" },
                      { "data": "ContactNAme" },
                      { "data": "Address" },
                      { "data": "City" },
                      { "data": "PostalCode" },
                      { "data": "Country" }
                    ]
                  });
                }
              });
            }
            setInterval(update, 10000);
      </script>

</head>
<body>
	<h1>Ajax - Servlets Integration Example</h1>
    <p>This is an example of how to use Ajax with a servlet backend.</p>
    <!--<p id="demo"></p>-->
    <table id="example" class="display" width="100%">
      <thead>
        <tr>
          <th>CustomerId</th>
          <th>CustomerName</th>
          <th>ContactNAme</th>
          <th>Address</th>
          <th>City</th>
          <th>PostalCode</th>
          <th>Country</th>
        </tr>
      </thead>
    </table>
</body>
</html>
