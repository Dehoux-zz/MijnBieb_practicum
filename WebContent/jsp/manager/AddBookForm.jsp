<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

   <head>
      <title>Add Book</title>
      <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
   </head>

   <body>
	    <h4>Add Book.</h4>
	    
	    <hr />

	    <s:form action="AddBook">
    	  <s:textfield name="bookId" label="bookId"/>
    	  <s:textfield name="titel" label="titel"/>
    	  <s:textfield name="auteur" label="auteur"/>
    	  <s:textfield name="isbn" label="isbn"/>
    	  <s:textfield name="pages" label="pagina's"/>
    	  <s:submit value="Add"/>
		</s:form>
  		
	    <hr /> 
	    
        <a href=" <s:url action="ManagerMenu" namespace="/manager" /> ">Het menu voor managers</a>
   	</body> 
</html>