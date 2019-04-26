
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<body>
<h2>文件上传</h2>

<form action="user/fileupload1" method="post" enctype="multipart/form-data">
选择文件:<input type="file" name="upload" />
</form>
</br>


<h2>mvc文件上传</h2>

<form action="user/fileupload2" method="post" enctype="multipart/form-data">
选择文件:<input type="file" name="upload" /></br>


<input type="submit" value="上传">

</form>


</body>
</html>
