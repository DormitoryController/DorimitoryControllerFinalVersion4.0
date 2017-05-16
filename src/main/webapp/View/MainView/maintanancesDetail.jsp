<%--
  Created by IntelliJ IDEA.
  User: 赵嗣瑜
  Date: 2017/5/11
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MaintananceDetail</title>
    <meta charset="UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>

    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>
<script>
    function returnReword() {
        $("#repositoryControl").load("/MainController/reword")
    }
    $(document).ready(function () {
        $.ajax({
            type:'post',
            url:'/MainController/maitanancesInfoGet',
            data:{},
            success: function (data) {
                var result = eval("(" + data + ")");
                var id=result.maintenanceId;
                var replist=result.replist;
                var mainlist=result.mainlist;
                var stulist=result.stulist;
                var itemNameList=result.itemNameList;
                var itemNumList=result.itemNumList;
                for(var i in replist){
                    $("#maintanancesId").append(id)
                    $("#repairerName").append(replist[i].name)
                    $("#repairerTelephone").append(replist[i].telephone);
                    $("#maintananceDetail").append(mainlist[i].fault_detail);
                    $("#rewordDetail").append(mainlist[i].fault_analysis);
                    $("#studentName").append(stulist[i].name);
                    $("#studentRoom").append(stulist[i].dormnum);
                    $("#repairItemList").append()
                }
                for(var i in itemNameList){
                    var txt2="<tr><th>"+itemNameList[i]+"</th><th>"+itemNumList[i]+"</th></tr>"
                    $("#repairItemList").append(txt2)
                }
//                var rep_name=rep[1].name;
//                var rep_telephone=rep.telephone;
//                var maintenance=result.maintenance;
//                var fault_detail=maintenance.fault_detail;
//                var fault_analysis=maintenance.fault_analysis;
//                $("#maintanancesId").append(id)
//                $("#repairerName").append(rep.name)
//                $("#repairerTelephone").append(rep.telephone);
//                $("#maintananceDetail").append(mai.fault_detail);
//                $("#rewordDetail").append(mai.fault_analysis);
            },
        },JSON)
    })
</script>
<body>
<style>body {
    background-color: #d9edf7;
}
</style>
<table class="table"  >
    <thead>
    <tr class="info">
        <th>
            维修单编号
        </th>
        <th id="maintanancesId">

        </th>
    </tr>
    </thead>
    <tbody   id="table1">
          <tr>
              <th>
                  维修人
              </th>
              <th id="repairerName">

              </th>
              <th>
                  维修人联系电话
              </th>
              <th id="repairerTelephone">

              </th>
          </tr>
          <tr>
              <th>
                  报修人：
              </th>
              <th id="studentName">

              </th>
              <th>
                  报修人住址：
              </th>
              <th id="studentRoom">

              </th>
          </tr>
          <tr>
              <th>
                  故障描述：
              </th>
          </tr>
    </tbody>
</table>
<table>
    <tr>
        <th>
            <p style="color:royalblue;word-wrap:break-word;word-break:break-all;" id="maintananceDetail" >
            </p>
        </th>
    </tr>
</table>
<table>
    <tr>
        <th>
            维修回执：
        </th>
    </tr>
</table>
<table>
    <tbody>
    <tr>
        <th>
            <p style="color:blue;word-wrap:break-word;word-break:break-all;" id="rewordDetail">
            </p>
        </th>
    </tr>
    </tbody>
</table>
</body>
<table>
    <thead>
    <tr>
        <th>
            维修零件清单:
        </th>
    </tr>
    </thead>
    <tbody id="repairItemList">

    </tbody>
    <tfoot>
    <tr>
        <th>
            <a onclick="returnReword()">确定</a>
        </th>
    </tr>
    </tfoot>
</table>
</html>
