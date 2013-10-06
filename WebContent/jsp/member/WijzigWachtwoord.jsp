<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
        <title>Wachtwoord wijzigen</title>
        <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
	</head>

	<body>
	    <h4>Wachtwoord wijzigen.</h4> 	
	    
	    <hr />
	    
		<s:form action="ChangePassword">
    	  <s:password name="huidigWachtwoord" label="huidig wachtwoord:"/>
    	  <s:password name="nieuwWachtwoord" label="nieuw wachtwoord:"/>
    	  <s:submit value="Wijzig wachtwoord"/>
		</s:form>
			
	    <hr />
	    
        <a href=" <s:url action="MemberMenu" namespace="/member" /> ">Het menu voor leden</a>
	</body> 
</html>