
$("#butUpdate").click(function () {
    var name = $("#name").val();
    if(!name){
        layer.alert("小说名称不能为空",{icon: 2});
        return false;
    }
    var title = $("#bookMoney").val();
    if(!title){
        layer.alert("小说书币不能为空",{icon: 2});
        return false;
    }
    if(!UE.getEditor('editor').getContent()){
        layer.alert("小说简介不能为空",{icon: 2});
        return false;
    }
    $.post(
        "/booksSection/booksSectionUpdateSave",
        $("#updateform").serialize(),
        function (data) {
            if(data.result=="success"){
                layer.confirm('修改成功!是否回到小说章节列表页？', {
                    btn: ['确定','取消'] //按钮
                }, function(){
                    $("#backs").click();
                }, function(){
                });
            }else{
                layer.alert("修改失败",{icon: 2});
            }
        }
    );
});