<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

   <head>
      <title>Annuleer Reservering</title>
      <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
   </head>

   <body>
	    <h4>Annuleer Reservering.</h4>
	    
	    <hr />

	    <table>
		    <tr class="thcolor">
			    <th>id</th>
			    <th>titel</th>
			    <th>status</th>
		    </tr>
		    <s:iterator value="memberBooks">
			    <tr class="tdcolor">
				    <td><s:property value="id" />
					<td><s:property value="titel" />
		     		<td><s:property value="status" />
		        </tr>
 		    </s:iterator>
	    </table>
	    
	    <s:form action="CancelReservation">
    	  <s:textfield name="bookID" label="Boek ID"/>
    	  <s:submit value="Annuleer"/>
		</s:form>
  		
	    <hr /> 
	    
        <a href=" <s:url action="MemberMenu" namespace="/member" /> ">Het menu voor leden</a>
	</body> 
</html> 