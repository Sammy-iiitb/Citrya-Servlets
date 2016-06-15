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
                    //destroy: true,
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
          setInterval(update, 1000);
