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
            $("#singleNumberbtn").click(function() {
                $.ajax({
                    url: '/test/number',
                    type: 'GET',
                    contentType: 'application/json',
                    success: function(data) {
                        $("#singleView").text("");
                        data.data.numbers[0].forEach(number => $("#singleView").append(number + ' '));
                    }
                })
            })

            $("#multiNumberbtn").click(function() {
                alert("호출");
                $.ajax({
                    url: '/test/number',
                    type: 'GET',
                    contentType: 'application/json',
                    success: function(data) {
                        data.data.numbers.forEach(numbers => {
                            numbers.forEach(number => $("#multiView").append(number + ' '));
                            $("#multiView").append('<br>');
                        })
                    }
                })
            })

            const getNumber = (number) => {
                document.getElementById("multiNumberbtn")[0].click();
            }
        })
    </script>
</head>
<body>
    <img src="img/app_logo.png" />
    <br>
    <button id="singleNumberbtn">로또 번호 한 줄 받기</button> ==>
    <span id="singleView"></span>
    <br>
    <button id="multiNumberbtn">로또 번호 여러 줄 받기</button>
    <button id="one"    value="1" onclick="getNumber(1)"/>
    <button id="two"    value="2" onclick="getNumber(2)"/>
    <button id="three"  value="3" onclick="getNumber(3)"/>
    <button id="four"   value="4" onclick="getNumber(4)"/>
    <button id="five"   value="5" onclick="getNumber(5)"/>

    <br>
    <span id="multiView"></span>
</body>
</html>