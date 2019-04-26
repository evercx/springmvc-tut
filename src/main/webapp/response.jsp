
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>

<head>
<script src="http://lib.sinaapp.com/js/jquery/2.0.2/jquery-2.0.2.min.js">
    </script>


<script>

$(function(){


$("#btn").click(function(){

    $.ajax({

        type: 'POST',
        url: 'user/testAjax',
        contentType:'application/json;charset=UTF-8',
        data:'{"username":"hehe","password":"123","age":30}',
        dataType:'json',
        success:function(data){
             alert(data);
             alert(data.username);
             alert(data.password);
             alert(data.age);
        }


    });

})


});


</script>
</head>
<body>


<a href="user/testString">testString</a>
<br/>

<a href="user/testVoid">testVoid</a>
<br/>

<a href="user/testModelAndView">testModelAndView</a>
<br/>

<a href="user/testForwardOrRedirect">testForwardOrRedirect</a>
<br/>

<button id="btn">ajax</button>



</body>
</html>
