<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

   <head>
      <title>Delete User</title>
      <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
   </head>

   <body>
	    <h4>Delete User.</h4>
	    
	    <hr />

	    <table>
		    <tr class="thcolor">
			    <th>username</th>
		    </tr>
		    <s:iterator value="users">
			    <tr class="tdcolor">
				    <td><s:property value="username" /></td>
		        </tr>
 		    </s:iterator>
	    </table>
	    
	    <s:form action="DeleteUserForm">
    	  <s:textfield name="username" label="username"/>
    	  <s:submit value="Delete"/>
		</s:form>
  		
	    <hr /> 
	    
        <a href=" <s:url action="ManagerMenu" namespace="/manager" /> ">Het menu voor managers</a>
   	</body> 
</html>