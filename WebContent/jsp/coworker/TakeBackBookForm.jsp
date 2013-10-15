<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

   <head>
      <title>Neem een boek terug</title>
      <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
   </head>

   <body>
	    <h4>Neem een boek terug.</h4>
	    
	    <hr />

	    <table>
		    <tr class="thcolor">
			    <th>id</th>
			    <th>titel</th>
			    <th>status</th>
		    </tr>
		    <s:iterator value="Books">
			    <tr class="tdcolor">
				    <td><s:property value="id" />
					<td><s:property value="titel" />
		     		<td><s:property value="status" />
		        </tr>
 		    </s:iterator>
	    </table>
	    
	    <s:form action="TakeBackBook">
    	  <s:textfield name="bookID" label="Boek ID"/>
    	  <s:submit value="Neem terug"/>
		</s:form>
  		
	    <hr /> 
	    
        <a href=" <s:url action="CoworkerMenu" namespace="/coworker" /> ">Het menu voor coworkers</a>
	</body> 
</html> 