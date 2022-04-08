<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>


<!-- CSS -->
<!-- Button Style -->
<style>
.button {
	background-color: blue;
	border: none;
	color: white;
	padding: 15px 30px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	-webkit-transition-duration: 0.4s;
	transition-duration: 0.4s;
	display: block;
}

.buttonsignup {
	width: 200px
}

.buttonsignup {
	border-radius: 5px
}

.buttonsignup {
	background-color: #535353;
}

.buttonsignup {
	align-self: center;
}

.buttonsignup:hover {
	background-color: #A9A9A9;
}
}
</style>
 
<!-- 전화번호 자동 하이픈 -->
<script type="text/javascript">
const autoHyphen2 = (target) => {
	 target.value = target.value
	   .replace(/[^0-9]/g, '')
	  .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
	}
</script>

<!-- 비밀번호 재확인용 -->
<script type="text/javascript">
	function checkPw() {
		var regExpPasswd = /[0-9]{5,10}$/
		if(!regExpPasswd.test(document.getElementById('pw').value)) {
			document.getElementById('checking').innerHTML='사용할 수 없는 비밀번호 입니다.'
			document.getElementById('checking').style.color='red'
		} else {
			document.getElementById('checking').innerHTML='사용가능한 비밀번호 입니다.'
			document.getElementById('checking').style.color='blue'
		}
	}
	function checkPwRe() {
		if(document.getElementById('pw').value !='' && document.getElementById('pw2').value!=''){
            if(document.getElementById('pw').value==document.getElementById('pw2').value){
                document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
                document.getElementById('check').style.color='blue';
            }
            else{
                document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
                document.getElementById('check').style.color='red';
            }
        }
	}
</script>

<!--전화번호 중복확인 -->
<script type="text/javascript">
	var isCheckedPhone = false
</script>

<!--  전화번호 중복 확인 -->
<script type="text/javascript">
	function checkPhone() {
		var regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/
		var form = document.signupForm
		
		// 핸드폰 번호 확인
		var user_phone = form.user_phone.value
		if(user_phone == "") {
			alert("휴대폰 번호를 입력해주세요")
			return
		} else {
			if (!regExpPhone.test(user_phone)) {
				alert("연락처 입력을 확인해 주세요")
				form.user_phone.select()
				return
			} else {
				isCheckedPhone = true
				window.open("http://localhost:9413/BetterHip/signup/signupCheckPhone.do?user_phone=" + user_phone,"","width=500, height=300, left=500, top=150");
			}
		} 
		
		
		
	}
</script> 

<!-- 유효성 검사 -->
<script type="text/javascript">
	function userInfoModify() {
		
		//숫자만 5~10자
		var regExpPasswd = /[0-9]{5,10}$/
		var regExpName = /^[가-힣]*$/
		var regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/
		var regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
		
		var form = document.userInfoModifyForm

		// 비밀번호 확인
		var new_user_pw = form.new_user_pw.value
		var new_user_pw_re = form.new_user_pw_re.value
		if(new_user_pw == "") {
			alert("비밀번호를 입력해주세요")
			return
		}else {
			if (!regExpPasswd.test(new_user_pw)) {
				alert("사용할 수 없는 비밀번호 입니다.")
				form.new_user_pw.select()
				return
			}
			
		}
		if(new_user_pw != new_user_pw_re) {
			alert("비밀번호 재확인이 잘못되었습니다.")
			return
		}
		
		// 이름 확인
		var user_name = form.user_name.value
		if(user_name == "") {
			alert("이름을 입력해주세요")
			return
		}else {
			if (!regExpName.test(user_name)) {
				alert("이름은 한글만 입력해주세요")
				form.user_name.select()
				return
			}
		}
		
		//이메일 확인
		var user_email = form.user_email.value
		if(user_email == "") {
			alert("이메일을 입력해주세요")
			return
		}else {
			if (!regExpEmail.test(user_email)) {
				alert("이메일 입력을 확인해 주세요")
				form.user_email.select()
				return
			}
		}
		
		// 주소 확인
		var user_address = form.user_address.value
		var user_address_detail = form.user_address_detail.value
		if(user_address == "") {
			alert("주소를 입력해주세요")
			return
		}
		if(user_address_detail = "") {
			alert("상세주소를 입력해주세요")
			form.user_address_detail.select()
			return
		}
		
/* 		// 핸드폰 번호 중복체크 확인 여부
		if(isCheckedPhone == false) {
			alert("핸드폰 번호 중복체크를 해주세요")
			return
		} */
		
		/* 위 유효성 검사 모두 통과 수정 완료 ALERT */
		if(confirm("수정이 완료 되었습니다.")){
			location.href = "userInfoModifyView.do";
		}
		
		document.userInfoModifyForm.submit();
	}
	
</script>

<!-- 주소 api 불러오기 -->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    //document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    //document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr+extraAddr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>

<head>
<meta charset="UTF-8">
<title>회원정보 변경</title>
</head>
<!--회원정보 수정 View 메인-->
<body>
	<div style="position: absolute; left: 40%">
	
		<form action="userInfoModify.do" name="userInfoModifyForm" method="get">
		
			<table>
				<tr>
					<td align="center" colspan="2">BETTER HIP</td>
				</tr>
				<tr>
					<td align="center" colspan="2">회원정보 변경</td>
				</tr>
			
				<tr>
					<td>아이디</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="user_id" size="41" value="${userInfo.user_id }" readonly="readonly"></td>
				</tr>
				<tr>
					<td>이름</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="user_name" size="41" value="${userInfo.user_name }" onfocus="this.select()"></td>
				</tr>
				<tr>
					<td>새 비밀번호</td>
				</tr>
				<tr>
					<td colspan="2"><input placeholder="비밀번호는 숫자로 5~10자만 입력해주세요!!" 
					type="password" name="new_user_pw" size="41" id="pw" onkeyup="checkPw()" onchange="checkPwRe()" maxlength="10"></td>
					<td><span id="checking"></span></td>
				</tr>
				<tr>
					<td>비밀번호 재확인</td>
				</tr>
				<tr>
					<td colspan="2"><input type="password" name="new_user_pw_re" size="41" id="pw2" onkeyup="checkPwRe()"></td>
					<td><span id="check"></span></td>
				</tr>
				<tr>
					<td>이메일</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="user_email" size="41" value="${userInfo.user_email }" onfocus="this.select()"></td>
				</tr>
				<tr>
					<td>휴대폰 번호</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="user_phone" value="${userInfo.user_phone }" oninput="autoHyphen2(this)" maxlength="13" onfocus="this.select()"> 
					<input type="button" size="20" value="중복확인" onclick="checkPhone()"></td> 
				</tr>
				<tr>
					<td>주소</td>
				</tr>
				<tr>
					<td>
						<input type="text" onclick="sample6_execDaumPostcode()" id="sample6_postcode" name="user_postcode" size="30" value= "${userInfo.user_postcode } " onfocus="this.select()">
						<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호"><br>
						<input type="text" onclick="sample6_execDaumPostcode()" readonly="readonly" id="sample6_address" size="41" placeholder="기본주소" name="user_address" value= "${userInfo.user_address } " onfocus="this.select()"><br>
						<input type="text" id="sample6_detailAddress" size="41" placeholder="상세주소 입력" name="user_address_detail" value= "${userInfo.user_address_detail } " onfocus="this.select()">
					</td>
					</tr>
			
			
				<tr>
					<!-- 수정버튼  -->
					<td align="center" colspan="2">

						<input type="button" value="회원 정보 수정" name="btnSubmit" onclick="userInfoModify()" class="buttonUserInfoModify">

					</td>
				</tr>
			</table>
	
		</form>
	
	</div>

	
</body>
</html>