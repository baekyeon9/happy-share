<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     trimDirectiveWhitespaces="true" %>
	 <!DOCTYPE html>
	 <html lang="ko">
	   <head>
		 <!-- meta -->
		 <meta charset="UTF-8">
		 <meta name="viewport" content="width=device-width, initial-scale=1.0">
		 <meta http-equiv="X-UA-Compatible" content="IE=edge">
		 
		   <title>HappyShare : 단체 회원가입</title>
		   
		   <!--  link -->
		 <link rel="stylesheet" href="../../assets/css/bootstrap.css">
		 <link rel="stylesheet" href="../../assets/css/maicons.css">
		 <link rel="stylesheet" href="../../assets/vendor/animate/animate.css">
		 <link rel="stylesheet" href="../../assets/vendor/owl-carousel/css/owl.carousel.css">
		 <link rel="stylesheet" href="../../assets/vendor/fancybox/css/jquery.fancybox.css">
		 <link rel="stylesheet" href="../../assets/css/theme.css">
		 <link rel="stylesheet" href="../../assets/css/style.css">
		 </head>
		 
	   <body>
		 <header>
		   <div class="top-bar">
			 <div class="container">
			   <div class="row align-items-center">          
				 <div class="col-md-12 text-right d-none d-md-block">
				   <div class="social-mini-button">
					 <a href="#"><span>로그인</span></a>
					 <a href="#"><span>회원가입</span></a>
					 <a href="#"><span>관리자</span></a>
				   </div>
				 </div>
			   </div>
			   <!-- //row -->
			 </div>
		   </div>
		   <!-- //top-bar -->
		   
		   <nav class="navbar navbar-expand-lg navbar-light">
			 <div class="container">
			   <a href="index.html" class="navbar-brand">Happy<span class="text-primary logo">Share</span></a>
			   <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
				 <span class="navbar-toggler-icon"></span>
			   </button>
			   <!-- navbarContent -->
			   
			   <div class="navbar-collapse collapse" id="navbarContent">
				 <ul class="navbar-nav ml-auto pt-3 pt-lg-0">
				   <li class="nav-item">
					 <a href="index.html" class="nav-link">함께해요</a>
				   </li>
				   <li class="nav-item">
					 <a href="about.html" class="nav-link">소통해요</a>
				   </li>
				   <li class="nav-item">
					 <a href="services.html" class="nav-link">챌린지</a>
				   </li>
				   <li class="nav-item">
					 <a href="portfolio.html" class="nav-link">모금함</a>
				   </li>
				   <li class="nav-item">
					 <a href="blog.html" class="nav-link">고객센터</a>
				   </li>
				 </ul>
			   </div>
			   <!-- //navbarContent -->
			 </div>
			 <!-- container -->
		   </nav>
		   <!-- //navbar -->
		 </header>
	 <!---------------------------------------- main ---------------------------> 
		 <main>
		   <div class="page-section">
					 <div class="container">
						 <form action="index.html">
						 <h1 class="title-h">회원가입 - 단체</h1>
					   <div class="join-wrap">
				 <h5>기본정보<span class="required_title"><em class="icon_required">·</em>표시는 반드시 입력하셔야 합니다.</span></h5>
				   <div class="base-table">
					 <table class="join-table">
					   <caption>개인회원 기본정보</caption>
						<tbody>
						 <tr>
						   <th><em class="icon_required">·</em><span>아이디</span></th>
						   <td>
							 <label for='f-id' class="sr-only sr-cont">아이디</label> 
							 <input id='f-id' class="form-control form-sub-control box-input" type='text' name='id' placeholder="아이디">
							 <button type="button" class="btnj btn btn-primary" id="person-id">중복확인</button>
							
						   </td>
						 </tr>
						 <!-- //아이디 -->
						 <tr>
						   <th><em class="icon_required">·</em><span>비밀번호</span></th>
						   <td>
							 <label for='f-password' class="sr-only">비밀번호</label> 
							 <input id='f-password' class="form-control box-input" type='password' name='password' placeholder="8-16자의 영문 및 숫자, 특수문자를 모두 포함">
						   </td>
						 </tr>
						 <!-- //비밀번호 -->
						 <tr>
						   <th><em class="icon_required">·</em><span>이름</span></th>
						   <td>
							 <label for='f-name' class="sr-only">이름</label> 
							 <input id='f-name' class="form-control box-input" type='text' name='name'>
						   </td>
						 </tr>
						 <!-- //이름 -->
						 <tr>
						   <th><em class="icon_required">·</em><span>휴대폰번호</span></th>
						   <td>
							 <label for='f-tel' class="sr-only">휴대폰번호</label> 
							 <input id='f-tel' class="form-control box-input" type='tel' name='tel'>
						   </td>
						 </tr>
						 <!-- //휴대폰번호 -->
						 <tr>
						   <th><em class="icon_required">·</em><span>이메일</span></th>
						   <td>
							 <label for='f-email' class="sr-only">이메일</label> 
							 <input id='f-email' class="form-control box-input" type='email' name='email'>
						   </td>
						 </tr>
						 <!-- //이메일 -->
						 <tr>
						   <th><em class="icon_required">·</em><span>주소</span></th>
						   <td>
							 <div>
							   <label for='f-postNo' class="sr-only">우편번호</label> 
							   <input id='f-postNo' class="form-control form-sub-control box-input" type='number' name='number'>
								 <button type="button" class="btnj btn btn-primary" id="post-no">우편번호</button>
							 </div>
							 <div>
								 <label for='f-basicAddress' class="sr-only sr-cont">기본주소</label> 
							   <input id='f-basicAddress' class="form-control form-sub-control postfo box-input" type='text' name='basicAddress' placeholder="기본주소">          
							 </div>
							 <div>
							   <label for='f-detailAddress' class="sr-only sr-cont">상세주소</label> 
							   <input id='f-detailAddress' class="form-control form-sub-control postfo box-input" type='text' name='detailAddress' placeholder="상세주소">
							 </div>
						   </td>
						 </tr>
						 <!-- //주소 -->
						 <tr>
						   <th><em class="icon_required">·</em><span>소속인원</span></th>
						   <td>
							 <label for='f-groupCount' class="sr-only">소속인원</label> 
							 <input id='f-groupCount' class="form-control box-input" type='nember' name='groupCount'>
						   </td>
						 </tr>
						 <!-- //이름 -->
						</tbody>
					 </table>
				   </div>
				   <div class="btn-regi">
					   <button type="submit" class="btn btn-primary nBtn" id="abc">회원가입</button>
					   <a href="#" class="btn btn-outline-primary nBtn" role="button">이전</a>
				   </div>
				 </div>  <!-- //join-wrap -->
				
			   </form>
					 </div> <!-- //container -->
				 </div>
			 </main>  
				<script>
				document.querySelector("#person-id").onclick = () => {
				var name = document.querySelector("#f-id");
				if (name.value == "") {
					alert("아이디를 정확히 입력해주세요");
					return; // submit 버튼이 아니라 일반 버튼이기 때문에 false를 리턴할 필요가 없다.
				} 
			}

			//document.querySelector(".btnj").onclick = () => {
			//	var postNo = document.querySelector("#f-postNo");
			//	if (postNo.value == "") {
			//		alert("우편번호를 입력해주세요.");
			//		return; // submit 버튼이 아니라 일반 버튼이기 때문에 false를 리턴할 필요가 없다.
			//	}
			//}

			
			document.querySelector("#post-no").onclick = () => {
				var postNo = document.querySelector("#f-postNo");
				if (postNo.value.length < 5 || postNo.value == "") {
					alert("우편번호를 입력해주세요");
					return; // submit 버튼이 아니라 일반 버튼이기 때문에 false를 리턴할 필요가 없다.
				}
			}


				</script>
		 </body>
	 </html>
		 