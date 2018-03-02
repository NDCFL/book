<%--
  Created by IntelliJ IDEA.
  User: jb9
  Date: 2018/2/28
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="favicon.ico" >
    <link rel="icon" href="favicon.ico">
    <link href="<%=path%>/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path%>/static/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="<%=path%>/static/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="<%=path%>/static/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link href="<%=path%>/static/css/bootstrapValidator.css" rel="stylesheet">
    <link href="<%=path%>/static/css/plugins/datapicker/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <link href="<%=path%>/static/js/layui/css/layui.css" rel="stylesheet">
    <title>修改小说</title>
</head>
<body class="gray-bg">
<div class="wrapper">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>修改图书<a onClick="javascript :history.back(-1);">(双击选项卡返回到列表)</a></h5>
                </div>
                <div class="ibox-content">
                    <form method="get" class="form-horizontal" id="updateform">
                        <input name="id" type="hidden" />
                        <div class="form-group">
                            <label class="col-sm-1 control-label">小说名称</label>
                            <div class="col-sm-2">
                                <input type="text" name="name" id="name" placeholder="请输入小说名称" class="form-control">
                            </div>
                            <label class="col-sm-1 control-label">所属模块</label>
                            <div class="col-sm-2">
                                <select class="form-control" id="bookModule" name="bookModule">

                                </select>
                            </div>
                            <label class="col-sm-1 control-label">小说类型</label>
                            <div class="col-sm-2">
                                <select class="form-control" id="bookTypeId" name="bookTypeId">
                                </select>
                            </div>
                            <label class="col-sm-1 control-label">小说作者</label>
                            <div class="col-sm-2">
                                <input type="text" name="author" placeholder="请输入小说作者" id="author" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">小说字数</label>
                            <div class="col-sm-2">
                                <input type="text" name="wordCount" placeholder="请输入小说字数"  id="wordCount" class="form-control">
                            </div>
                            <label class="col-sm-1 control-label">章节总数</label>
                            <div class="col-sm-2">
                                <input type="text" name="section" placeholder="请输入小说章节总数"  id="section" class="form-control">
                            </div>
                            <label class="col-sm-1 control-label">是否完本</label>
                            <div class="col-sm-2">
                                <select class="form-control" id="isLast" name="isLast">
                                    <option value="0">连载中</option>
                                    <option value="1">已完本</option>
                                </select>
                            </div>
                            <label class="col-sm-1 control-label">小说封面</label>
                            <div class="col-sm-2">
                                <div class="layui-upload-list">
                                   <img class="layui-upload-img" style="width: 100px;height: 100px" src="<%=path%>/static/img/load.png" id="demo1">
                                    <input type="hidden" value="" name="faceImg" id="faceImg" />
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">小说简介</label>
                            <div class="col-sm-11">
                                <textarea type="text"  name="introduction" style="height: 420px" id="editor" ></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-1">
                                <button class="btn btn-primary" type="button" id="butUpdate">保存内容</button>
                                <button class="btn btn-danger" type="button" id="backs" onClick="javascript :history.back(-1);">返回到列表</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/bootstraptablejs.jsp"></jsp:include></body>
<script type="text/javascript" src="<%=path%>/static/js/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/static/js/pageJs/booksUpdate.js"></script>
<script>
    var datas = ${books};
    var ue = UE.getEditor('editor');
    $("#updateform").autofill(datas);
    document.getElementById("demo1").src=$("#faceImg").val();
    layui.use('upload', function() {
        var $ = layui.jquery
            , upload = layui.upload;
        //普通图片上传
        var uploadInst = upload.render({
            elem: '#demo1'
            , url: '/file/up'
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg('上传失败');
                }else{
                    $("#faceImg").val(res.data.src);
                }
                //上传成功
            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });
    });
    $(function () {
        $.post(
            "/bookType/getBookType",
            function (data) {
                $("#bookTypeId").select2({
                    data: data
                });
                var colum = $("#bookTypeId").select2();
                //选中某一行
                colum.val(datas.bookTypeId).trigger("change");
                colum.change();
                $("#select2-bookTypeId-container").remove();
            },
            "json"
        );
        $.post(
            "/bookModule/getBookModule",
            function (data) {
                $("#bookModule").select2({
                    data: data
                });
                var colum = $("#bookModule").select2();
                //选中某一行
                colum.val(datas.bookModule).trigger("change");
                colum.change();
                $("#select2-bookModule-container").remove();
            },
            "json"
        );
    });
</script>

</html>