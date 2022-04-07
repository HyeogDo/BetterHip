<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>

	<script type="text/javascript">
		function test() {
			alert("move");
			document.signupForm.submit();
		}
	</script>
	
	<script type="text/javascript">
		// 체크박스 전체 선택
		$(".checkbox_group").on("click", "#check_all", function () {
		    $(this).parents(".checkbox_group").find('input').prop("checked", $(this).is(":checked"));
		});
	
		// 체크박스 개별 선택
		$(".checkbox_group").on("click", ".normal", function() {
		    var is_checked = true;
	
		    $(".checkbox_group .normal").each(function(){
		        is_checked = is_checked && $(this).is(":checked");
		    });
	
		    $("#check_all").prop("checked", is_checked);
		});
	</script>
 <!-- 다음 주소 시작 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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


<body>
	<div style="position: absolute; left: 40%">
	
		<form action="userInfoModify.do" name="userInfoView" method="post">
		
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
					<td>비밀번호</td>
				</tr>
				<tr>
					<td colspan="2"><input type="password" name="user_pw" size="41" value="${userInfo.user_pw }"></td>
				</tr>
				<tr>
					<td>새 비밀번호</td>
				</tr>
				<tr>
					<td colspan="2"><input type="password" name="new_user_pw" size="41"></td>
				</tr>
				<tr>
					<td>비밀번호 재확인</td>
				</tr>
				<tr>
					<td colspan="2"><input type="password" name="check_new_user_pw" size="41"></td>
				</tr>
				<tr>
					<td>이메일</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="user_email" size="41" value="${userInfo.user_email }"></td>
				</tr>
				<tr>
					<td>휴대폰 번호</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="user_phone" size="30" value="${userInfo.user_phone }"> <input type="button" size="20" value="중복확인"></td>
				</tr>
				<tr>
					<td>주소</td>
				</tr>
				<tr>
					<td>
						<input type="text" onclick="sample6_execDaumPostcode()" id="sample6_postcode" name="user_postcode" size="30" value= "${userInfo.user_postcode } ">
						<input type="button" onclick="sample6_execDaumPostcode()" size="20" value="우편번호"><br>
						<input type="text" onclick="sample6_execDaumPostcode()" id="sample6_address" size="41" name="user_address" value= "${userInfo.user_address } "><br>
						<input type="text" id="sample6_detailAddress" size="41" placeholder="상세주소 입력" name="user_address_detail" value= "${userInfo.user_address_detail } ">
					</td>
					</tr>
			
			</table>
			
			<div class="checkbox_group">
				<input type="checkbox" id="check_all">
				<label for="check_all">전체 동의</label><br>
					  
				<input type="checkbox" id="check_1" class="normal" >
				<label for="check_1">개인정보 처리방침 동의</label><br>
					  
				<input type="checkbox" id="check_2" class="normal" >
				<label for="check_2">서비스 이용약관 동의</label><br>
					  
				<input type="checkbox" id="check_3" class="normal" >
				<label for="check_3">마케팅 수신 동의</label><br>
			</div>
		
		<!-- 알럿 띄우기  -->
			<input type="submit" name="userInfoModify" value="수정">
	
		</form>
	
	</div>

	
</body>
</html>