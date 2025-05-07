<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="회원가입 양식"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원가입 양식</title>
<jsp:include page="../common/jsp/external_file.jsp"/>
<style type="text/css">

</style>
<!-- 다음 api -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function findZipcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('zipcode').value = data.zonecode;
                document.getElementById("addr").value = roadAddr;
                document.getElementById("addr2").focus();
                //document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
               
            }
        }).open();
    }
</script>
<script type="text/javascript">
function checkPassword() {
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirmPassword').value;

    if (password !== confirmPassword) {
        alert("비밀번호가 일치하지 않습니다.");
        document.getElementById('confirmPassword').value = '';
        document.getElementById('password').focus();
    }
}

function updateCount() {
    var intro = document.getElementById('intro');
    var count = document.getElementById('count');
    
    if (intro.value.length > 500) {
        alert("500자 초과");
        intro.value = intro.value.substring(0, 500);  // 500자로 잘라내기
    }
   	count.innerText = intro.value.length;  // 글자수 표시
}

window.onload = function () {
    document.getElementById('confirmPassword').addEventListener('blur', checkPassword);
    document.getElementById("btnZipcode").addEventListener("click",findZipcode);
    document.getElementById('intro').addEventListener('input', updateCount);
}

$(function(){
	$("#btnConfirm").click(function(){
		$("#frm").submit();
	});
});

</script>
</head>
<body>
<header data-bs-theme="dark">
<jsp:include page="../common/jsp/header.jsp"/>
</header>
<main>
<div id="container">
	<h2>회원가입 양식</h2>
	<iframe src="http://localhost/jsp_prj/member/scrollbar.html"
	style="border: 0x; width :1420px; height:200px"></iframe>
	<form action="a.jsp" method="get" id="frm" name="frm">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text"  
				class="inputBox" style="width: 160px" name="id">
				<input type="button" value="ID중복확인" class="btnBox">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="password" name="password" class="inputBox" style="width: 200px">
				 비밀번호 확인
				<input type="password" id="confirmPassword" class="inputBox" style="width: 200px">
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td colspan="3"><input type="text" name="name" class="inputBox" style="width: 150px"></td>
			</tr>
			<tr>
				<th>생일</th>
				<td colspan="3"><input type="text" name="birth" class="inputBox" style="width: 130px"></td>
			</tr>
			<tr>
				<th>연락처</th>
				<td colspan="3"><input type="text" name="number" class="inputBox" style="width: 130px"></td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td colspan="3"><input type="text" name="phonenumber" class="inputBox"style="width: 130px"><input
					type="checkbox">수신</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td colspan="3"><input type="text" class="inputBox" name="frontEmail" style="width: 250px">@<input type="text"
					list="domainData" name="backEmail" class="inputBox" style="width: 160px"> <datalist id="langData">
						<option value="선택해주세요.">
						<option value="직접 입력">
						<option value="daum.net">
						<option value="gmail.com">
						<option value="hotmail.com">
						<option value="nate.com">
						<option value="korea.com">
					</datalist> <input type="checkbox">수신</td>
			</tr>
			<tr>
				<th>성별</th>
				<td><input type="radio" name="gender" id="gender"
					class="gender" value="남자" checked="checked"><label>남자</label>
					<input type="radio" name="gender" id="gender" class="gender"
					value="여자"><label>여자</label><br></td>
			</tr>
			<tr>
			<th>소재지</th>
			<td><select name="domain" id="domain" size="1" class="inputBox" style="width: 150px">
					<option value="선택해주세요">선택해주세요</option>
					<option value="강원">강원</option>
					<option value="경기">경기</option>
					<option value="경남">경남</option>
					<option value="경북">경북</option>
					<option value="광주">광주</option>
			</select></td>
			</tr>
			<tr>
			<th>우편번호</th>
			<td colspan="3">
			<input type="text" name="zipcode" id=zipcode readonly = "readonly" class="inputBox" style="width: 150px">
			<input type="button" id="btnZipcode" value = "우편번호검색" class="btnBox">
			</td>
			</tr>
			
			<tr>
			<th>주소</th>
			<td>
				<input type="text" name="address" id=addr readonly = "readonly" class="inputBox" style="width: 500px"><br>
				<input type="text" name="address2" id=addr2 class="inputBox" style="width: 500px">
			</td>
			</tr>
			<tr>
				<th>자기소개</th>
				<td>
				<textarea id="intro" name="intro" style="width:400px; height:100px"></textarea>
				<div style="text-align: right; padding-right:20px">
				<span id="count">0</span>/500
				</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="확인" class="btnBox" id="btnConfirm"/>
					<input type="button" value="취소" class="btnBox" id="btnCancle"/>
			</td>
			</tr>
		</table>
	</form>
</div>
</main>
<footer class="text-body-secondary py-5">
<jsp:include page="../common/jsp/footer.jsp"/>
</footer>
	
</body>
</html>