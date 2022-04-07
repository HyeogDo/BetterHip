<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<!-- 유효성 검사 -->
<script type="text/javascript">
	function test() {

		//숫자만 5~10자
		var regExpPasswd = /[0-9]{5,10}$/
		var regExpName = /^[가-힣]*$/
		var regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/
		var regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
		
		var form = document.signupForm

		
		var user_pw = form.user_pw.value
		if(user_pw == "") {
			alert("비밀번호를 입력해주세요")
			return
		}else {
			if (!regExpPasswd.test(user_pw)) {
				alert("사용할 수 없는 비밀번호 입니다.")
				form.user_pw.select()
				return
			}
			
		}
		
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
		
		var user_phone = form.user_phone.value
		if(user_phone == "") {
			alert("휴대폰 번호를 입력해주세요")
			return
		}else {
			if (!regExpPhone.test(user_phone)) {
				alert("연락처 입력을 확인해 주세요")
				form.user_phone.select()
				return
			}
		}
		
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

		document.signupForm.submit();
	}
</script>



<!-- 아이디 중복확인 -->
<script type="text/javascript">
	function checkId() {
		//영문자로 시작하는 영문자 또는 숫자 6~20자
		var regExpId = /^[a-z]+[a-z0-9]{5,19}$/g
		
		var form = document.signupForm
		
		var user_id = form.user_id.value
		if(!regExpId.test(user_id)) {
			alert("아이디는 영문자로 시작하는 영문자 혹은 숫자 6~20자로 입력해주세요")
			form.user_id.select()
			return
		} else {
			window.open("http://localhost:9413/BetterHip/signup/signupCheckId.do?user_id=" + user_id,"","width=500, height=300, left=500, top=150");
		}
		

	}
</script>



<!-- 전화번호 중복 확인 -->
<script type="text/javascript">
	function checkPhone() {
		var regExpPhone = /^\d{3}\d{3,4}\d{4}$/
		
		
	}
</script>

<!-- 약관 동의 체크박스 설정 -->
<script type="text/javascript">
	
	function checkSelectAll() {
		// 체크박스 전체 선택
		const checkboxes = document.querySelectorAll('input[name="check"]')
		// 선택된 체크박스
		const checked = document.querySelectorAll('input[name="check"]:checked')
		// selectall 체크박스
		const selectAll = document.querySelector('input[name="selectall"]')
		
		if (checkboxes.length === checked.length) {
			selectAll.checked = true
		}else {
			selectAll.checked = false
		}
		
		if(checkbox.checked === false) {
			selectall.checked = false
		}
	}
	
	// select all 누를시 전체 선택하기
	function selectAll(selectAll)  {
		  const checkboxes 
		       = document.getElementsByName('check');
		  
		  checkboxes.forEach((checkbox) => {
		    checkbox.checked = selectAll.checked;
		  })
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

<!-- 메인 -->
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<div style="position: absolute; left: 40%">
		<!-- 회원 가입 form -->
		<form action="signup.do" name="signupForm" method="get">
			<table>
				<tr>
					<td align="center" colspan="2"><b>BETTER HIP</b></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><b>회원 가입</b></td>
				</tr>
				<tr>
					<td>아이디</td>
				</tr>
				<tr>
					<td><input type="text" name="user_id" size="30"> 
					<input type="button" size="20" value="중복확인" onclick="checkId()"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
				</tr>
				<tr>
					<td colspan="2"><input placeholder="비밀번호는 숫자로 5~10자만 입력해주세요!!" 
					type="password" name="user_pw" size="41" id="pw" onkeyup="checkPw()" onchange="checkPwRe()" maxlength="10"></td>
					<td><span id="checking"></span></td>
				</tr>
				<tr>
					<td>비밀번호 재확인</td>
				</tr>
				<tr>
					<td colspan="2"><input type="password" name="user_pw_re" size="41" id="pw2" onkeyup="checkPwRe()"></td>
					<td><span id="check"></span></td>
				</tr>
				<tr>
					<td>이름</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="user_name" size="41"></td>
				</tr>
				<tr>
					<td>이메일</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="user_email" size="41"></td>
				</tr>
				<tr>
					<td>휴대폰 번호</td>
				</tr>
				<tr>
					<td><input type="text" name="user_phone" oninput="autoHyphen2(this)" maxlength="13"placeholder="ex) 010-6603-0058"> 
					<input type="button" size="20" value="중복확인"></td>
				</tr>
				<tr>
					<td>주소</td>
				</tr>
				<tr>
					<td><input type="text" onclick="sample6_execDaumPostcode()"
						readonly="readonly" id="sample6_postcode" name="postcode">
						<input type="button" onclick="sample6_execDaumPostcode()"
						value="우편번호"><br> <input type="text"
						onclick="sample6_execDaumPostcode()" readonly="readonly"
						id="sample6_address" size="41" placeholder="기본주소" name="address1"><br>
						<input type="text" id="sample6_detailAddress" size="41"
						placeholder="상세주소 입력" name="address2"></td>
				</tr>

			</table>
			<br>
			<!-- 약관 동의 -->
			<table>
				<tr>
					<td colspan="2" align="left">서비스 약관 동의</td>
					<td><input type="checkbox" name="selectall" value="selectall"
						onclick="selectAll(this)"><b>모두 동의합니다.</b><br></td>
				</tr>
				<tr>
					<td colspan="3"><hr></td>
				</tr>
				<tr>
					<td colspan="2" align="left">이용약관(필수)</td>
					<td align="right"><input type="checkbox" name="check"
						value="option_1" onclick="checkSelectAll(this)">동의<br></td>
				</tr>
				<tr>
					<td colspan="2" align="left">개인 정보 동의(필수)</td>
					<td align="right"><input type="checkbox" name="check"
						value="option_2" onclick="checkSelectAll(this)">동의<br></td>
				</tr>
				<tr>
					<td colspan="2" align="left">마케팅 안내 동의(선택)</td>
					<td align="right"><input type="checkbox" name="check"
						value="option_3" onclick="checkSelectAll(this)">동의<br></td>
				</tr>
				<tr>
					<!-- 이동하는 버튼  -->
					<td align="center" colspan="2">

						<input type="button" value="회원 가입" name="btnSubmit" onclick="test()" class="buttonsignup">

					</td>
				</tr>
			</table>
			<br>
			<div id="div1">	<input type="text" value=<%=session.getAttribute("RESULT") %>></div>
		</form>
	</div>
</body>
</html>