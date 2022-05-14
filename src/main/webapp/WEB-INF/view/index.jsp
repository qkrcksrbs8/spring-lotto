<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
                      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko"  xml:lang="ko">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<head>
    <meta http-equiv="Content-Type" Content="text/html; charset=utf-8" />
    <title>뜨균이의 로또 메인 페이지</title>
    <script type="application/javascript">
        $(function(){
            $("#btn").click(function() {
                $.ajax({
                    url: '/test/number',
                    type: 'GET',
                    contentType: 'application/json',
                    success: function(data) {
                        $("#number").val(data.data.numbers[0]);
                    }
                })
            })
        })
    </script>
</head>
<body>
    <img src="img/app_logo.png" />
    <button id="btn">로또 번호 받기</button>
    <input type="text" name="number" id="number" value="1" readonly="true">
</body>
</html>