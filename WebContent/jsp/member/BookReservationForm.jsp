<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

   <head>
      <title>Boek Reserveren</title>
      <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
   </head>

   <body>
	    <h4>BoekInfo.</h4>
	    
	    <hr />

	    <table>
		    <tr class="thcolor">
			    <th>id</th>
			    <th>titel</th>
			    <th>status</th>
		    </tr>
		    <s:iterator value="books">
			    <tr class="tdcolor">
				    <td><s:property value="id" /></td>
					<td><s:property value="titel" /></td>
		     		<td><s:property value="status" /></td>
		        </tr>
 		    </s:iterator>
	    </table>
	    
	    <s:form action="BookReservation">
    	  <s:textfield name="bookID" label="Boek ID"/>
    	  <s:submit value="Reserveer"/>
		</s:form>
  		
	    <hr /> 
	    
        <a href=" <s:url action="MemberMenu" namespace="/member" /> ">Het menu voor leden</a>
   	</body> 
</html>