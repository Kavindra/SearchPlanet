<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Search Planets</title>
    
    <script src="js/jquery-1.10.2.min.js"></script>
    <script src="js/jquery-1.10.2.js"></script>
	<!-- <script src="js/jquery-ui.custom.min.js"></script> -->
  </head>

  <body>
    <h1>Welcome to searchplanets.com..</h1>
	
    <!-- <table>
      <tr>
        <td colspan="2" style="font-weight:bold;">Available Servlets:</td>        
      </tr>
      <tr>
        <td><a href="searchplanet">SearchPlanet</a></td>
      </tr>
    </table> -->
    
     <table>
    	<tr>
    	<label>Enter search query:</label> 
    	<input type="text" name="searchword" id="searchword">
    	</tr>
    	<tr><button type="button" id="searchButton">Search</button></tr>
    </table>
    </br>
    
    <p id="search-results"> </p>
    <!-- <h2 align = "center"> Planet Search</h2>

	<form method="post" action="searchterm" id="searchform">

		<table border="0" cellpadding="5" cellspacing ="3" align = "center">

			<tr>
				<th align = "right">Enter Planet : </th>			
				<td><input type="text" name="planet" /> </td>
			</tr>
			<tr>
				<td colspan = "2" align = "center"><input type="submit" value="SUBMIT" /> </td>
			</tr>
		</table>
	</form> -->
	
	<%-- <%
	response.setHeader(200, { 'Content-Type': contentType, 'Access-Control-Allow-Origin': '*' }); 
	%> --%>
    
    <script type="text/javascript">
    $(document).on("click","#searchButton",function(event){
    	event.preventDefault();
    	//var planetName = "saturn";
    	var planetName = $("#searchword").val();
    	//alert(planetName);
    	$("#search-results").append('<div>Searching....</div>');
    	var result = '';
    	
    	var currentdate = new Date(); 
    	var datetime = currentdate.getDate() + "/"
    	                + (currentdate.getMonth()+1)  + "/" 
    	                + currentdate.getFullYear() + " @ "  
    	                + currentdate.getHours() + ":"  
    	                + currentdate.getMinutes() + ":" 
    	                + currentdate.getSeconds();
    	
    	console.log("Datetime: "+datetime);       
    	         
    	function saveterm(term){
    		$.ajax({
        	    type: "POST",
        	    url: "/api/json/model",
        	    //dataType: 'jsonp',
        	    data: { planet: term , time: datetime, action: "save-data"},
        	    success: function(){
        	    		console.log("succesfully saved")
        	    },
        	    /* error: function(e) {
        	        alert('Errorrrrrrr: '+e);
        	    } */     	    	
        	});
        	
    	}
    	
    	$.ajax({
    	    type: "POST",
    	    url: "http://data.nasa.gov/api/get_search_results/?search="+planetName+"&callback=?",
    	    dataType: 'jsonp',
    	    data: { planet: planetName },
    	    success: function (data) {
    	        //alert("Completed..!!");
    	        //alert(data.status);
    	        var postsList = data.posts;
    	        
    	        result += '<table width = \"70%\" align = \"center\" border = \"1\">';
    	        $.each(postsList, function(index,post){
    	        	
    	        	/*result += '<div>Id: '+post.id+'</div>';
    	        	result += '<div>slug: '+post.slug+'</div>';
    	        	result += '<div>url: '+post.url+'</div>';
    	        	result += '<div>title: '+post.title+'</div>';
    	        	result += '<div>content: '+post.content+'</div>';*/
    	        	
    	        	
    	        	result += '<tr><td>Post Id</td><td>' + post.id + '</td></tr>';
    	        	result += '<tr><td>Slug</td><td>' + post.slug + '</td></tr>';
    	        	result += '<tr><td>Url</td><td>' + post.url + '</td></tr>';
    	        	result += '<tr><td>Title</td><td>' + post.title + '</td></tr>';
    	        	result += '<tr><td>Content</td><td>' + post.content + '</td></tr>';
    	        	result += '<tr><td colspan=2></td></tr>';
    	        	
    	        
    	        	});
    	        
    	        result += '</table><br><br>';
    	        $("#search-results").append(result);
    	        //saveterm(planetName);
    	        
    	    },
    	    error: function(e) {
    	        alert('Error: '+e);
    	    }  
    	});
    	
    	saveterm(planetName);
    });
    </script>
  </body>
</html>
