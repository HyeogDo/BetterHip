<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<ul>
	<li onclick="kakaoLogin();">
      <a href="javascript:void(0)">
          <span>카카오 로그인</span>
      </a>
	</li>
	<li onclick="kakaoLogout();">
      <a href="javascript:void(0)">
          <span>카카오 로그아웃</span>
      </a>
	</li>
</ul>

<!-- 카카오 스크립트 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
Kakao.init('7c1aa88300eb4966019664a165594ea4'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
			// response.kakao_account.email = 이메일
			  location.href='kakao_return.jsp?email='+response.kakao_account.email+''
        	  
        	  if (response.kakao_account.email === 'undefined') {
        		  alert('이메일정보 동의좀')
        		  kakaoLogout()
        	  
        	  }else{
        		  
        	  }
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  }
//카카오로그아웃  
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	console.log(response)
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
    }
  }  
</script>

<script type="text/javascript">
	function checkOnclick() {
		var form = document.loginForm
		if(form.user_id.value != "") {
			if(form.user_pw.value != "") {
				form.submit()
			}else {
				alert("비밀번호을 입력해주세요")
			}
		}else {
			if(form.user_pw.value != "") {
				alert("아이디를 입력해주세요")
			}else {
				alert("아이디 비밀번호을 입력해주세요")
			}
		}
	
	}
		
	window.onload=function(){		
		if("${message}" != "init") {
			
			alert("${message}")
		}
	}
	
</script>

<body>


	<h1><center>BETTER HIP</center></h1>
	<div style="text-align: center;">
		<form name="loginForm" action="login.do" method='post'>
	    	<input type="text" name="user_id" placeholder="아이디를 입력하세요" style="height: 40px;width: 400px;font-size:15px;"><br>
	    	<input type="password" name="user_pw" placeholder="패스워드를 입력하세요" style="height: 40px;width: 400px;font-size:15px;"><br>
	    	<input type="button" onclick="checkOnclick()" name="loginMethod"  value="로그인" style="height: 40px;width: 408px;font-size:15px;"><br>
	    	<input type="hidden" name="loginMethod" value="normal">
	    	<input type="button" onclick="kakaoLogin()" value="카카오 로그인" style="height: 40px;width: 408px;background-color:#ffd400;font-size:15px;font-weight:bold;"><br>
	    </form>
	</div>
	<a href="../BetterHip/signupForm.do" >회원가입</a>


</body>
</html>