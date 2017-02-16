<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Five in a row Game!</title>
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/css/game.css">
<Script>
function send()
{
	
	var namee = document.forms.login.nm.value;
	var password=document.forms.login.pass.value;
	
	if(namee=="" || namee==null)
	   {
	     alert("please enter User Name");
	     return;
	 
	    }
	  else if(password=="" || password==null)
	   {
	    alert("please enter Password");
	    return;
	   }
	document.forms.login.action="logins";
	document.forms.login.submit();
}
</script>
</head>
<body style="background-color:#FFE4C4">

<h2><center>Five In a Row Game</center></h2> 
<center>
<br /><br /><br /><br /><br /><br />
<form name="login" action="" method="post">
<input type="hidden" name="requestType" value="loginValidate"></input>

<table>

<tr>
<td>USERNAME</td>
<td><h3><input type="text"  name="nm"></h3><td>
</tr>

<br />

<tr>
<td>PASSWORD</td>
<td><input type="password" name="pass"/></td>
</tr>

</table>
<br /><br /><br /><br />
<input type="button" name="btn1" value="SUBMIT" onClick="send();"/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<input type="reset" name="reset" value="RESET"/>
<tr>
		<td colspan="2"><center> &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp
		</center> </td>
	</tr>

</form>
</center>

</body>
</html>