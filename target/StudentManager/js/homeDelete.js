var billObj;


//学生信息管理页面上点击删除按钮弹出删除框(main.jsp)
function deleteBill(obj){
    $.ajax({
        type:"GET",
        url:path+"/homework/deleteHomework",
        data:{event:obj.attr("event")},
        dataType:"html",
        success:function(data){
            //删除成功：移除删除行
            cancleBtn();
            obj.parents("tr").remove();
        },
        error:function(data){
            alert("对不起，删除失败");
        }
    });
}

function openYesOrNoDLG(){
    $('.zhezhao').css('display', 'block');
    $('#removeBi').fadeIn();
}

function cancleBtn(){
    $('.zhezhao').css('display', 'none');
    $('#removeBi').fadeOut();
}
function changeDLGContent(contentStr){
    var p = $(".removeMain").find("p");
    p.html(contentStr);
}

$(function(){

    $(".modifyBill").on("click",function(){
        var obj = $(this);
        window.location.href=path+"/homework/updateHomework?event="+ obj.attr("event");
    });
    $('#no').click(function () {
        cancleBtn();
    });

    $('#yes').click(function () {
        deleteBill(billObj);
    });

    $(".deleteBill").on("click",function(){
        billObj = $(this);
        changeDLGContent("你确定要删除作业【"+billObj.attr("event")+"】吗？");
        openYesOrNoDLG();
    });

});