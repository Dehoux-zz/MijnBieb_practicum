<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

   <head>
      <title>Boek Info</title>
      <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
   </head>

   <body>
	    <h4>Informatie over <s:property value="book.titel" /></h4>
	    
	    <hr />

	    <table>
	    	<tr class="thcolor">
	    		<th>attribuut</th>
	    		<th>waarde</th>
	    	</tr>
	    	<tr class="tdcolor">
	    		<th>id</th>
	    		<th><s:property value="book.id" /></th>
	    	</tr>
	    	<tr class="tdcolor">
	    		<th>titel</th>
	    		<th><s:property value="book.titel" /></th>
	    	</tr>
	    	<tr class="tdcolor">
	    		<th>auteur</th>
	    		<th><s:property value="book.auteur" /></th>
	    	</tr>
	    	<tr class="tdcolor">
	    		<th>isbn</th>
	    		<th><s:property value="book.isbn" /></th>
	    	</tr>
	    	<tr class="tdcolor">
	    		<th>pages</th>
	    		<th><s:property value="book.pages" /></th>
	    	</tr>
	    	<tr class="tdcolor">
	    		<th>status</th>
	    		<th><s:property value="book.status" /></th>
	    	</tr>
	    </table>
  		
	    <hr /> 
	    
	    <a href=" <s:url action="BookList" namespace="/manager" /> ">Terug naar boekenlijst</a>
        <a href=" <s:url action="ManagerMenu" namespace="/manager" /> ">Het menu voor manager</a>
	</body> 
</html>
 