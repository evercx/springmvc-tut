
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<body>
<h2>Hello World!</h2>

<a href="anno/testCookieValue">RequestParam</a>

<br>

<form action="anno/testRequestBody" method="post">
用户姓名：<input type="text" name="uname" /><br/>
用户年龄：<input type="text" name="age" /><br/>
<input type="submit" value="提交"/>

</form>



<a href="anno/testSessionAttributes">testSessionAttributes</a>
<br>
<a href="anno/getSessionAttributes">getSessionAttributes</a>
<br>
<a href="anno/delSessionAttributes">delSessionAttributes</a>
<br>

</body>
</html>
