
$("#butUpdate").click(function () {
    var name = $("#name").val();
    if(!name){
        layer.alert("小说名称不能为空",{icon: 2});
        return false;
    }
    var author = $("#author").val();
    if(!author){
        layer.alert("小说作者不能为空",{icon: 2});
        return false;
    }
    var wordCount = $("#wordCount").val();
    if(!wordCount){
        layer.alert("小说字数不能为空",{icon: 2});
        return false;
    }
    var section = $("#section").val();
    if(!section){
        layer.alert("小说章节不能为空",{icon: 2});
        return false;
    }
    var faceImg = $("#faceImg").val();
    if(!faceImg){
        layer.alert("请上传小说封面",{icon: 2});
        return false;
    }
    var faceImg = $("#faceImg").val();
    if(!faceImg){
        layer.alert("请上传小说封面",{icon: 2});
        return false;
    }
    if(!UE.getEditor('editor').getContent()){
        layer.alert("小说简介不能为空",{icon: 2});
        return false;
    }
    $.post(
        "/books/booksUpdateSave",
        $("#updateform").serialize(),
        function (data) {
            if(data.result=="success"){
                layer.confirm('修改成功!是否回到小说列表页？', {
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