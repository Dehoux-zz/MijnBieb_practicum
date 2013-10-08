<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

   <head>
      <title>Add Coworker</title>
      <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
   </head>

   <body>
	    <h4>Add Coworker.</h4>
	    
	    <hr />

	    <table>
		    <tr class="thcolor">
			    <th>username</th>
		    </tr>
		    <s:iterator value="coworkers">
			    <tr class="tdcolor">
				    <td><s:property value="username" /></td>
		        </tr>
 		    </s:iterator>
	    </table>
	    
	    <s:form action="AddCoworkerForm">
    	  <s:textfield name="username" label="username"/>
    	  <s:password name="password" label="password"/>
    	  <s:submit value="Add"/>
		</s:form>
  		
	    <hr /> 
	    
        <a href=" <s:url action="ManagerMenu" namespace="/manager" /> ">Het menu voor managers</a>
   	</body> 
</html>