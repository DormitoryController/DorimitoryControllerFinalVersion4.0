<%--
  Created by IntelliJ IDEA.
  User: 赵嗣瑜
  Date: 2017/4/25
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>repositoryTable</title>
    <meta charset="UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>

    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>
<body>
<style>body {
    background-color: #d9edf7;
}
</style>
<script>
    var index=1;
    $(document).ready(function repositoryAdding() {
        $.ajax({
            type:'post',
            url:'/MainController/repositoryItem',
            data:{index:0},
            success: function (data) {
                var txt1="";
                var result = eval("(" + data + ")");
                var ob = result.itemlist;
                for (var i in ob) {
                    txt1=txt1+"<option value='"+ob[i].name+"'>"+ob[i].name+"</option>"
                }
                var txt2="<tr id='reducetr"+index+"'><td id='mydiv"+index+"'>"+index+"</td>" +
                    "<td ><select style='background-color: #d9edf7'id='reduceitem"+index+"'> "+txt1+
                    "<td><input type='number'style='background-color: #d9edf7'id='reducenum"+index+"'></td>" +
                    "<td onclick='addColumn()'> <a>+</a> </td>"+
                    "<td onclick='deleteColumn("+index+")'> <a>-</a> </td>"+
                    "</tr>";
                $("#repReduceTable").append(txt2);
                index++;
            },
        },JSON)

//        $("#itemBtn").on("click",function(){//upnew为这个button控件ID
//                var txt=$("#mydiv"+1+"").text();
//                alert(txt)
//            }
//        );
    })
    function addColumn() {
        $.ajax({
            type:'post',
            url:'/MainController/repositoryItem',
            data:{index:0},
            success: function (data) {
                var txt1="";
                var result = eval("(" + data + ")");
                var ob = result.itemlist;
                for (var i in ob) {
                    txt1=txt1+"<option value='"+ob[i].name+"'>"+ob[i].name+"</option>"
                }
                var txt2="<tr id='reducetr"+index+"'><td id='mydiv"+index+"'>"+index+"</td>" +
                    "<td ><select style='background-color: #d9edf7'id='reduceitem"+index+"'> "+txt1+
                    "<td><input type='number'style='background-color: #d9edf7'id='reducenum"+index+"'></td>" +
                    "<td onclick='addColumn()'> <a>+</a> </td>"+
                    "<td onclick='deleteColumn("+index+")'> <a>-</a> </td>"+
                    "</tr>";
                $("#repReduceTable").append(txt2);
                index++;
            },
        },JSON)
    }
    //    function ItemSubmit() {
    //        $.ajax({
    //            type:'post',
    //            url:'/MainController/itemSubmit',
    //            data:{index:0},
    //            success: function (data) {
    //
    //                var txt=$("#mydiv"+1+"").val();
    //                var txt1=$("#price"+1+"").val();
    //                var txt2=$("#item"+1+"").val();
    //                alert(txt2)
    //            },
    //            error:function () {
    //                alter("服务器异常，提交失败")
    //            }
    //
    //        },JSON)
    //
    //    }

    $("#reduceItemBtn").on("click",function(){//upnew为这个button控件ID
            var numlist=[];
            var itemlist=[];
            var length=$("#repReduceTable tr").length+1;
            var addCheck=0;
            for( var i=1;i <length;i++) {
                var txt1 = $("#reduceitem" + i + "").val();
                var txt3 = $("#reducenum" + i + "").val();
                if ( txt3 != "") {
                    itemlist.push(txt1)
                    numlist.push(txt3)
                }
                else {
                    alert("请输入价格或数量")
                    addCheck=1;
                    break
                }
            }
            if(addCheck==0) {
                $.ajax({
                    type: 'post',
                    url: '/MainController/reduceItem',
                    data: {itemlist: itemlist, numlist: numlist},
                    success: function (data) {
                        alert("成功")
                    },
                }, JSON)
            }
        }
    );
    function deleteColumn(number) {
        $("#reducetr"+number+"").empty();
    }
</script>
<table class="table"  >
    <thead>
    <tr class="info">
        <th>
            编号
        </th>
        <th>
            产品
        </th>
        <th>
            数量
        </th>
        <th>

        </th>
        <th>
        </th>
    </tr>
    </thead>
    <tbody   id="repReduceTable">


    </tbody>
    <tfoot>
    <tr class="info">
        <td>
            <button  style="background-color: #d9edf7"id="reduceItemBtn" >提交</button>
        </td>
    </tr>
    </tfoot>
</table>
</body>
</html>
