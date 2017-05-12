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
                  故障描述：
              </th>
          </tr>
    </tbody>
</table>
<table>
    <tr>
        <th>
            <p style="word-wrap:break-word;word-break:break-all;" >
                sadlakslfjalkjfhdakshdu9iqwaydhiuadudalwkjdlkajdawlkdjoaldahfjskhfaslfhasjkfhasjkdhkajbncknasbckjashgfuiwqhidqhyudoipashdouaiduah
                sadlakslfjalkjfhdakshdu9iqwaydhiuadudalwkjdlkajdawlkdjoaldahfjskhfaslfhasjkfhasjkdhkajbncknasbckjashgfuiwqhidqhyudoipashdouaiduahhaiduadioashjdosaihdsao

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
    <tr>
        <th>
            <p style="word-wrap:break-word;word-break:break-all;" >
                sadlakslfjalkjfhdakshdu9iqwaydhiuadudalwkjdlkajdawlkdjoaldahfjskhfaslfhasjkfhasjkdhkajbncknasbckjashgfuiwqhidqhyudoipashdouaiduah
                sadlakslfjalkjfhdakshdu9iqwaydhiuadudalwkjdlkajdawlkdjoaldahfjskhfaslfhasjkfhasjkdhkajbncknasbckjashgfuiwqhidqhyudoipashdouaiduahhaiduadioashjdosaihdsao

            </p>
        </th>
    </tr>
</table>
</body>
<table>
    <thead>
    <tr>
        <th>
            维修零件清单
        </th>
    </tr>
    </thead>
    <tbody id="repairItemList">

    </tbody>
    <tfoot>
    <tr>
        <th>
            <a onclick="returnReword()">返回</a>
        </th>
    </tr>
    </tfoot>
</table>
</html>
