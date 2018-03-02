//生成用户数据
$('#mytab').bootstrapTable({
    method: 'post',
    contentType: "application/x-www-form-urlencoded",//必须要有！！！！
    url: "/books/booksList",//要请求数据的文件路径
    toolbar: '#toolbar',//指定工具栏
    striped: true, //是否显示行间隔色
    dataField: "res",
    sortable: true, //是否启用排序 sortOrder: "ID asc",
    sortOrder: "ID asc",
    pagination: true,//是否分页
    queryParamsType: 'limit',//查询参数组织方式
    queryParams: queryParams,//请求服务器时所传的参数
    sidePagination: 'server',//指定服务器端分页
    pageNumber: 1, //初始化加载第一页，默认第一页
    pageSize: 10,//单页记录数
    pageList: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100],//分页步进值
    showRefresh: true,//刷新按钮
    showColumns: true,
    clickToSelect: true,//是否启用点击选中行
    toolbarAlign: 'right',//工具栏对齐方式
    buttonsAlign: 'right',//按钮对齐方式
    toolbar: '#toolbar',
    uniqueId: "id",                     //每一行的唯一标识，一般为主键列
    showExport: true,
    exportDataType: 'all',
    columns: [
        {
            title: '全选',
            field: 'select',
            //复选框
            checkbox: true,
            width: 25,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '小说名称',
            field: 'name',
            align: 'center',
            sortable: true
        },
        {
            title: '小说类型',
            field: 'bookTypeName',
            align: 'center',
            sortable: true
        },
        {
            title: '所属模块',
            field: 'bookModuleName',
            align: 'center',
            sortable: true
        },
        {
            title: '作者',
            field: 'author',
            align: 'center',
            sortable: true
        },
        {
            title: '字数',
            field: 'wordCount',
            align: 'center',
            sortable: true,
            formatter: function (value, row, index) {
                return '<span style="color: green">'+parseFloat(value/10000)+'(万字)</i>';
            }
        },
        {
            title: '章节数',
            field: 'section',
            align: 'center',
            sortable: true,
            formatter: function (value, row, index) {
                return '<span style="color: green">'+value+'(章)</i>';
            }
        },
        {
            title: '是否完本',
            field: 'isLast',
            align: 'center',
            formatter: function (value, row, index) {
                if (value == 0) {
                    //表示启用状态
                    return '<span style="color: green">未完本</i>';
                } else {
                    //表示启用状态
                    return '<span style="color: red">已完本</i>';
                }
            }
        }
        ,
        {
            title: '小说简介',
            field: 'introduction',
            align: 'center',
            sortable: true,
            formatter: function (value, row, index) {
                if(value.length<10){
                    return '<a   data-toggle="modal" title="点击查看详情" alt="点击查看详情" data-id="\'' + row.id + '\'" data-target="#remark_modal_" onclick="return remark_s(\'' + value + '\')">'+value.substr(0,10)+'</a>';
                }else{
                    return '<a   data-toggle="modal" title="点击查看详情" alt="点击查看详情" data-id="\'' + row.id + '\'" data-target="#remark_modal_" onclick="return remark_s(\'' + value + '\')">'+value.substr(0,10)+"..."+'</a>';
                }
            }
        }
        ,
        {
            title: '创建时间',
            field: 'createTime',
            align: 'center',
            sortable: true,
            formatter: function (value) {
                var date = new Date(value);
                var y = date.getFullYear();
                var m = date.getMonth() + 1;
                var d = date.getDate();
                var h = date.getHours();
                var mi = date.getMinutes();
                var ss = date.getSeconds();
                return y + '-' + m + '-' + d + ' ' + h + ':' + mi + ':' + ss;
            }
        }
        ,
        {
            title: '当前状态',
            field: 'status',
            align: 'center',
            formatter: function (value, row, index) {
                if (value == 0) {
                    //表示启用状态
                    return '<span style="color: green">启用</i>';
                } else {
                    //表示启用状态
                    return '<span style="color: red">停用</i>';
                }
            }
        }
        ,
        {
            title: '操作',
            align: 'center',
            field: '',
            formatter: function (value, row, index) {
                var e = '<a title="编辑" id="books"  class="J_menuItem" href="/books/booksUpdatePage/'+row.id+'"><i class="glyphicon glyphicon-pencil" alt="修改" style="color:green">修改</i></a> ';
                var d = '<a title="删除" href="javascript:void(0);" onclick="del(' + row.id + ',' + row.status + ')"><i class="glyphicon glyphicon-trash" alt="删除" style="color:red">删除</i></a> ';
                var f = '';
                if (row.status == 1) {
                    f = '<a title="启用" href="javascript:void(0);" onclick="updatestatus(' + row.id + ',' + 0 + ')"><i class="glyphicon glyphicon-ok-sign" style="color:green">启用</i></a> ';
                } else if (row.status == 0) {
                    f = '<a title="停用" href="javascript:void(0);" onclick="updatestatus(' + row.id + ',' + 1 + ')"><i class="glyphicon glyphicon-remove-sign"  style="color:#ff1a1c">停用</i></a> ';
                }
                var p = '<a title="章节管理" class="J_menuItem" href="/booksSection/booksSectionPage/'+row.id+'"><i class="glyphicon glyphicon-th-large" alt="章节管理" style="color:#3096fa">章节管理</i></a> ';
                return e + d + f+p;
            }
        }
    ],
    locale: 'zh-CN',//中文支持,
    responseHandler: function (res) {
        if (res) {
            return {
                "res": res.rows,
                "total": res.total
            };
        } else {
            return {
                "rows": [],
                "total": 0
            };
        }
    }
})

//请求服务数据时所传参数
function queryParams(params) {
    var title = "";
    $(".search input").each(function () {
        title = $(this).val();
    });
    return {
        //每页多少条数据
        pageSize: this.pageSize,
        //请求第几页
        pageIndex: this.pageNumber,
        searchVal: title
    }
}
function  remarks(val) {
    $("#remarks").html(val);
}
function  remark_s(val) {
    $("#remark_s").html(val);
}
function del(booksid, status) {
    layer.confirm('确认要删除吗？', function (index) {
        $.ajax({
            type: 'POST',
            url: '/books/deleteBooks/' + booksid,
            dataType: 'json',
            success: function (data) {
                if (data.message == '删除成功!') {
                    layer.alert(data.message, {icon: 6});
                } else {
                    layer.alert(data.message, {icon: 6});
                }
                refush();
            },
            error: function (data) {
                console.log(data.msg);
            },
        });
    });
}
function updatestatus(id, status) {
    $.post("/books/updateStatus/" + id + "/" + status,
        function (data) {
            if(status==0){
                if(data.message=="ok"){
                    layer.alert("已启用", {icon:6});
                }else{
                    layer.alert("操作失败", {icon:6});
                }
            }else{
                if(data.message=="ok"){
                    layer.alert("已停用", {icon:5});
                }else{
                    layer.alert("操作失败", {icon:5});
                }
            }
            refush();
        },
        "json"
    );
}
//查询按钮事件
$('#search_btn').click(function () {
    $('#mytab').bootstrapTable('refresh', {url: '/books/booksList'});
})
function refush() {
    $('#mytab').bootstrapTable('refresh', {url: '/books/booksList'});
}
$("#update").click(function () {
    $.post(
        "/books/booksUpdateSave",
        $("#updateform").serialize(),
        function (data) {
            if (data.message == "修改成功!") {
                layer.alert(data.message, {icon: 6});
                refush();
            } else {
                layer.alert(data.message, {icon: 6});
                refush();
            }
        }, "json"
    );
});
$("#add").click(function () {
    $.post(
        "/books/booksAddSave",
        $("#formadd").serialize(),
        function (data) {
            if (data.message == "新增成功!") {
                layer.alert(data.message, {icon: 6});
                refush();
            } else {
                layer.alert(data.message, {icon: 6});
                refush();
            }
        }, "json"
    );
});
function deleteMany11() {
    var isactivity = "";
    var row = $.map($("#mytab").bootstrapTable('getSelections'), function (row) {
        if (row.status == 0) {
            isactivity += row.status;
        }
        return row.id;
    });
    if (row == "") {
        layer.msg('删除失败，请勾选数据!', {
            icon: 2,
            time: 2000
        });
        return;
    }
    if (isactivity != "") {
        layer.msg('删除失败，已经启用的不允许删除!', {
            icon: 2,
            time: 2000
        });
        return;

    }
    $("#deleteId").val(row);
    layer.confirm('确认要执行批量修改小说类型的状态吗？', function (index) {
        $.post(
            "/books/deleteManyBooks",
            {
                "manyId": $("#deleteId").val()
            },
            function (data) {
                if (data.message == "删除成功!") {
                    layer.alert(data.message, {icon: 6});
                    refush();
                } else {
                    layer.alert(data.message, {icon: 6});
                    refush();
                }
            }, "json"
        );
    });
}
function deleteMany(){
    var isactivity="";
    var row=$.map($("#mytab").bootstrapTable('getSelections'),function(row){
        if(row.status==0){
            isactivity+=row.status;
        }
        return row.id ;
    });
    if(row==""){
        layer.msg('修改失败，请勾选数据!', {
            icon : 2,
            time : 3000
        });
        return ;
    }
    $("#statusId").val(row);
    $("#updateStatus").modal('show');

}
$("#updateSta").click(function () {
    layer.confirm('确认要执行批量修改小说类型的状态吗？',function(index){
        $.post(
            "/books/deleteManyBooks",
            {
                "manyId":$("#statusId").val(),
                "status":$("#status").val()
            },
            function(data){
                if(data.message=="修改成功!"){
                    layer.alert(data.message, {icon:6});
                    refush();
                }else{
                    layer.alert(data.message, {icon:6});
                    refush();
                }
            },"json"
        );
    });
});