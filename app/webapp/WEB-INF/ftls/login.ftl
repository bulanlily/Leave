<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Login to People soft.</title>

    <script type="text/javascript" src="/wallofshame/javascripts/jquery-1.5.2.min.js"></script>

</head>


<body>
<h3 >Your peoplesoft username and password</h3>
<br/>
<#if error?? >
<h5><span style="color:red;">${error}</span></h5>
<br/>
</#if>

<form method="POST" action="/wallofshame/login.html">
    <input name="username">
    <input name="password">
    <input type="submit" value="Save"/>
</form>
</body>
</html>

