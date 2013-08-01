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
    
    <script type="text/javascript">
    $(document).on("click","#searchButton",function(event){
    	event.preventDefault();
    	//alert("begining");
    	$.post('http://data.nasa.gov/api/get_search_results/?','search=saturn',function(status){
    		alert("here");
    		$.mobile.hidePageLoadingMsg();
			/* if(response.error){
				alert(response.error);
			} */
    	});
    	alert("Button clicked");
    });
    </script>
  </body>
</html>
