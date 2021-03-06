<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String cpath = request.getContextPath();
%>
<script src="<%=cpath%>/jquery/jquery-1.7.2.min.js" type="text/javascript"></script>
<link href="<%=cpath%>/js/upload.css" rel="stylesheet" type="text/css">
<link href="<%=cpath%>/js/btn.css" rel="stylesheet" type="text/css">
<link href="<%=cpath%>/js/loader.css" rel="stylesheet" type="text/css">
<html>
<head>
    <title>测试上传插件</title>
    <script>
        var totalSize = 0;

        //绑定所有type=file的元素的onchange事件的处理函数
        $(".file1").live("change", function () {
            var file = this.files[0]; //假设file标签没打开multiple属性，那么只取第一个文件就行了
            name = file.name;
            size = file.size;
            type = file.type;
            url = window.URL.createObjectURL(file); //获取本地文件的url，如果是图片文件，可用于预览图片

            $(this).next().html("文件名：" + name + " 文件类型：" + type + " 文件大小：" + size + " url: " + url);

            totalSize += size;

            $("#info").html("总大小: " + totalSize + "bytes");

        });

        function upload() {
            //创建FormData对象，初始化为form表单中的数据。需要添加其他数据可使用formData.append("property", "value");
            var formData = new FormData($('form')[0]);
            var values = '';
            for (var i = 0; i < $('form')[0].file.length; i++) {
                values += $('form')[0].file.value;
            }
            if (values == '') {
                alert("请选择文件！");
                return;
            }
            //ajax异步上传
            $.ajax({
                url: '<%=cpath%>/upload',
                type: "POST",
                data: formData,
                xhr: function () { //获取ajaxSettings中的xhr对象，为它的upload属性绑定progress事件的处理函数

                    myXhr = $.ajaxSettings.xhr();
                    if (myXhr.upload) { //检查upload属性是否存在
                        //绑定progress事件的回调函数
                        myXhr.upload.addEventListener('progress', progressHandlingFunction, false);
                    }
                    return myXhr; //xhr对象返回给jQuery使用
                },
                success: function (result) {
                    alert(result.msg);
                },
                contentType: false, //必须false才会自动加上正确的Content-Type
                processData: false  //必须false才会避开jQuery对 formdata 的默认处理
            });
        }

        //上传进度回调函数：
        function progressHandlingFunction(e) {
            if (e.lengthComputable) {
                $('progress').attr({value: e.loaded, max: e.total}); //更新数据到进度条
                var percent = e.loaded / e.total * 100;
                $('#progress').html(e.loaded + "/" + e.total + " bytes. " + percent.toFixed(2) + "%");
            }
        }
        var test;
        function progressbar(){
            test = setInterval(function addperce(){
                        var wd =  $(".container .bar").find("span:eq(0)")[0].style;
                        if(parseInt(wd.width)!==100){
                            wd.width = parseInt(wd.width)+1+"%";
                        }else{
                            clearInterval(test);
                        }
                    },100
            );
        }


        function controlBar(){
            if( $('#btn1').hasClass("off")){
                $('#btn1').removeClass("off").addClass("on");
                progressbar();
            }else{
                $('#btn1').removeClass("on").addClass("off");
                clearInterval(test);
                var wd =  $(".container .bar").find("span:eq(0)")[0].style;
                wd.width = 0+"%";
            }
        }
        var loader;
        function loaderbar(){
            loader = setInterval(function loaderadd(){
                        var wd =  $(".wrapper .load-bar-inner")[0].style;
                        var c = $(".wrapper #counter")[0].style;
                        if(parseInt(wd.width)!==100){
                            wd.width = parseInt(wd.width)+1+"%";
                            c.left = parseFloat(c.left.split('px')[0])+3.5+"px";
                            $(".wrapper #counter").html(wd.width);
                        }else{
                            clearInterval(test);
                        }
                    },100
            );
        }
        function controlLoadBar(){
            if( $('#btn2').hasClass("off")){
                $('#btn2').removeClass("off").addClass("on");
                loaderbar();
            }else{
                $('#btn2').removeClass("on").addClass("off");
                clearInterval(loader);
                var wd =  $(".wrapper .load-bar-inner")[0].style;
                var c = $(".wrapper #counter")[0].style;
                wd.width = 0+"%";
                c.left = "-25px";
                $(".wrapper #counter").html("");
            }
        }


    </script>
</head>

<body >
<h2>HTML5异步上传文件，带进度条</h2>

<form method="post" enctype="multipart/form-data">
    <%--其他需要提交的信息：<input type="text" name="otherInfo"/><br/><br/>--%>
    选择要上传的文件：<br/>
    <input type="file" name="file" class="file1"/><span></span><br/>
    <input type="file" name="file" class="file1"/><span></span><br/>
</form>

<br/><br/>
<input type="button" onclick="upload()" class="btn"
       style="background: url(<%=cpath%>/image/jsls.jpg);width: 150px;height: 55px;background-size: 100% 100% "/>
<br/><br/>
<p id="info"></p>
上传进度：
<progress></progress>
<br/>
<p id="progress">0 bytes</p>
<div class='container'>
    <div class='bar blue stripes'>
        <span style="width: 0"></span>
    </div>
</div>

<div class="btnbg" >
    <a id="btn1" href="#" onclick="controlBar()" class="button off"></a>
</div>
<div class = "wrapper" style="float: right">
    <div class="loadbar">
        <div class="load-bar-inner" style="width: 0"><span id="counter" style="left: -25px;"></span></div>
    </div>
    <h1>Loading</h1>
    <p>Please wait...</p>
</div>
<div class="btnbg" style="float: left">
    <a id="btn2" href="#" onclick="controlLoadBar()" class="button off"></a>
</div>
</body>
</html>