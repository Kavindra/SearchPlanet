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
    <title>search Planets</title>
    
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
    	<tr>Enter search query: <input type="text" name="searchword"></tr>
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
    	var planetName = "saturn";
    	alert(planetName);
    	
    	$.ajax({
    	    type: "POST",
    	    url: "http://data.nasa.gov/api/get_search_results/?search="+planetName+"&callback=?",
    	    dataType: 'jsonp',
    	    data: { planet: planetName },
    	    success: function (data) {
    	        //alert("Completed..!!");
    	        //alert(data.status);
    	        var postsList = data.posts;
    	        var result = '';
    	        $.each(postsList, function(index,post){
    	        	
    	        	result += '<div>Id: '+post.id+'</div>';
    	        	result += '<div>slug: '+post.slug+'</div>';
    	        	result += '<div>url: '+post.url+'</div>';
    	        	result += '<div>title: '+post.title+'</div>';
    	        	result += '<div>content: '+post.content+'</div>';
    	        	
    	        	$("#search-results").append(result);
    	        
    	        	});
    	        
    	       
    	    },
    	    error: function(e) {
    	        alert('Error: '+e);
    	    }  
    	});
    	
    	
    	
    	
    	
    	// $("#searchform form").submit(function(event){
    //	event.preventDefault();
    	//alert("begining");
    	//var planetName = $("searchword").val();
    //	var planetName = "saturn";
    	//alert(planetName);
    	//$.post("http://data.nasa.gov/api/get_search_results/?search=" + planetName,function(status){
    	/* $.post("http://data.nasa.gov/api/get_search_results/?search="+planetName+"&format=json&callback=",function(status){
    	//"/api/json/center","action=new-customer&referrer="+referrer
    		alert("here");
    		$.mobile.hidePageLoadingMsg();
			/* if(response.error){
				alert(response.error);
			} */
    	//}); 
    	//alert("Button clicked");
    });
    </script>
  </body>
</html>
