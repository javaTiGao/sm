<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body bgcolor = "cccfff">
<form action = "updateStudent" method = "post">


    <center>
        <br><br><br>
        修改学生信息
        <hr>
        <br>
        <table>
            <tr>
                <td>学号</td>
                <td><input type = "text" name = "sNo"> </td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type = "text" name = "sName"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type = "text" name = "sSex" >

                </td>
            </tr>
            <tr>
                <td>班级</td>
                <td><input type = "text" name = "sClass"></td>
            </tr>

            <tr>
                <td>班主任</td>
                <td><input type = "text" name = "Headmaster"></td>
            </tr>
            <tr>
                <td colspan = "2" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type = "submit" name = "sure" value = "提交">
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type = "reset" name = "sure" value = "取消">
                </td>
            </tr>
        </table>
    </center>
</form>
</body>
</html>