<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; utf-8" %>


<script type="text/javascript">
    var toolbar = [{
        iconCls: 'icon-edit',
        text: "添加章节",
        handler: function () {
            var row = $("#chapterY").edatagrid("getSelected")
            if (row == null) {
                alert("请选中一行")
            } else {
                $("#cc_id").val(row.id);
                $('#cd').dialog({
                    title: '添加',
                    width: 400,
                    height: 300,
                    closed: false,
                    cache: false,
                    //  href: 'get_content.php',
                    modal: true
                });
            }
        }
    }, '-', {
        iconCls: 'icon-help',
        text: "添加专辑",
        handler: function () {
            $('#cdk').dialog({
                title: '添加',
                width: 400,
                height: 300,
                closed: false,
                cache: false,
                //  href: 'get_content.php',
                modal: true
            });

        }
    }, '-', {
        text: "下载",
        iconCls: 'icon-help',
        handler: function () {
            var row = $("#chapterY").edatagrid("getSelected");
            location.href = "${pageContext.request.contextPath}/getChapter?downpath=" + row.downpath + "&title=" + row.title;
        }
    },];
    $('#chapterY').treegrid({
        toolbar: toolbar,
        url: '${pageContext.request.contextPath}/AselectAll',
        idField: 'id',
        treeField: 'title',
        //method:'get',
        fit: true,
        fitColumns: true,
        pagination: true,
        columns: [[
            {title: '标题', field: 'title', width: 180},
            {field: 'size', title: '大小', width: 60, align: 'right'},
            {field: 'duration', title: '时长', width: 80},
            {title: '下载路径', field: 'downpath', width: 180}
        ]],
        onDblClickRow: function (row) {
            $("#audio").dialog("open")
            $("#audio_id").prop("src", "${pageContext.request.contextPath}/upload/" + row.downpath);
        },
    });

    //添加操作开始
    function doAddc() {
        $("#cc").form("submit", {
            url: "${pageContext.request.contextPath}/ChapterAdd",
            //回调函数
            success: function (data) {
                //因为data是json字符串，所以判断时，要么用JSON.parse()方法解析，要么时其等于一个true字符串进行判断
                if (data == "true") {
                    //关闭修改对话框
                    $("#cd").dialog("close", true);
                    alert("添加成功")
                    //刷新展示数据页面
                    // $("#ta").datagrid("reload",true);
                } else {
                    alert("添加失败");
                }
            },
        });
    };
    //添加操作====结束===

    //专辑
    //添加操作开始
    function doAdda() {
        $("#cck").form("submit", {
            url: "${pageContext.request.contextPath}/Ainsert",
            //回调函数
            success: function (data) {
                //因为data是json字符串，所以判断时，要么用JSON.parse()方法解析，要么时其等于一个true字符串进行判断
                if (data == "true") {
                    //关闭修改对话框
                    $("#cdk").dialog("close", true);
                    alert("添加成功")
                    //刷新展示数据页面
                    // $("#ta").datagrid("reload",true);
                } else {
                    alert("添加失败");
                }
            },
        });
    };
    //添加操作====结束===
    $('#audio').dialog({
        title: '播放',
        width: 400,
        height: 200,
        closed: true,
    });
</script>

<table id="chapterY"></table>
<%--弹出对话框--%>
<div id="cd">
    <form id="cc" method="post" enctype="multipart/form-data">
        <input id="cc_id" type="hidden" name="cc_id" value=""/>
        标题：<input type="text" name="title"/> </br>
        上传音频:<<input type="file" name="chapter" id="">
        <%-- <input type="submit" value="添加">--%>
        <a href="JavaScript:void(0)" class="easyui-linkbutton" onclick="doAddc()">添加</a>
    </form>
</div>

<div id="cdk">
    <form id="cck" method="post">
        专辑标题：<input type="text" name="title"/> </br>
        专辑作者:<input type="text" name="author"/> </br>
        播音:<input type="text" name="broadCast"/> </br>
        简介:<input type="text" name="brief"/> </br>
        <a href="JavaScript:void(0)" class="easyui-linkbutton" onclick="doAdda()">添加</a>
    </form>
</div>
<div id="audio">
    <audio id="audio_id" src="" autoplay="autoplay" controls="controls" loop="loop"></audio>
</div>


