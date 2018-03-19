<html>
<script src="res/plugin/jquery-3.2.1.js" type="text/javascript"></script>
<body>
<h2>Hello World!</h2>
<p onclick="loginAjax()"> into</p>
</body>
<script>
    function loginAjax(){
        $.ajax({
            url:"getUser",
            type:'post',
            dataType:'json',
            data:{name:"seek"},
            success:function(data){
            }
        });
    }
</script>
</html>