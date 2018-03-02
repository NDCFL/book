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
    <title>修改章节</title>
</head>
<body class="gray-bg">
<div class="wrapper">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>修改小说章节<a onClick="javascript :history.back(-1);">(双击选项卡返回到列表)</a></h5>
                </div>
                <div class="ibox-content">
                    <form method="get" class="form-horizontal" id="updateform">
                        <input name="id" type="hidden" />
                        <div class="form-group">
                            <label class="col-sm-1 control-label">章节名称</label>
                            <div class="col-sm-3">
                                <input type="text" name="name" id="name" placeholder="请输入小说章节名称" class="form-control">
                            </div>
                            <label class="col-sm-1 control-label">章节标题</label>
                            <div class="col-sm-3">
                                <input type="text" name="title" id="title" placeholder="请输入小说章节标题"  class="form-control">
                            </div>
                            <label class="col-sm-1 control-label">所需书币</label>
                            <div class="col-sm-3">
                                <input type="number" name="bookMoney" id="bookMoney" placeholder="请输入小说章节阅读书币"  class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">章节简介</label>
                            <div class="col-sm-11">
                                <textarea type="text"  name="content" style="height: 420px" id="editor" ></textarea>
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
<script type="text/javascript" charset="utf-8" src="<%=path%>/static/js/pageJs/booksSectionUpdate.js"></script>
<script>
    var datas = ${booksSection};
    var ue = UE.getEditor('editor');
    $("#updateform").autofill(datas);
</script>

</html>