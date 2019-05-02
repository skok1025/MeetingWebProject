<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
   .mdl-list{
      border:0px solid #9866C5;
      box-shadow: 10px 10px 8px #888888;
      width: 300px;
   }
   
   .demo-list-item{
      width:200px;
   }
   
   .mdl-list__item-primary-content{
      color: #96759A;
   }
   .mdl-list__item-primary-content > a{
      color: #96759A;
   }
   
</style>

<ul id="introducelist" class="demo-list-item mdl-list">
   <li class="mdl-list__item"><span
      class="mdl-list__item-primary-content"><a href="/Meeting/introduce/intro.do"><i class="material-icons small">account_box</i> 대표 인사말</a> </span></li>
   <li class="mdl-list__item"><span
      class="mdl-list__item-primary-content"><a href="/Meeting/introduce/manager.do"><i class="material-icons small">account_circle</i> 매니저 소개</a> </span></li>
   <li class="mdl-list__item"><span
      class="mdl-list__item-primary-content"><a href="/Meeting/introduce/company.do"><i class="material-icons small">account_balance</i> 회사소개</a> </span></li>
</ul>
<ul id="matchinglist" class="demo-list-item mdl-list">
   <li class="mdl-list__item"><span
      class="mdl-list__item-primary-content"><a href="/Meeting/matching/index.do"><i class="material-icons small">chat</i> 매칭 설명</a> </span></li>
   <li class="mdl-list__item"><span
      class="mdl-list__item-primary-content"><a href="/Meeting/matching/stepmatching.do"><i class="material-icons small">layers</i> 단계별 매칭</a> </span></li>
   <li class="mdl-list__item"><span
      class="mdl-list__item-primary-content"><a href="/Meeting/matching/managermatching.do"><i class="material-icons small">leak_add</i> 매니저 매칭</a> </span></li>
</ul>
 <ul id="communitylist" class="demo-list-item mdl-list">
   <li class="mdl-list__item"><span
      class="mdl-list__item-primary-content"><a href="/Meeting/community/allcommunity.do"><i class="material-icons small">tab</i> 커뮤니티</a> </span></li>
       <li class="mdl-list__item"><span
      class="mdl-list__item-primary-content"><a href="/Meeting/community/daterecommend.do"><i class="material-icons small">rowing</i> 데이트 코스 추천</a> </span></li>
   
</ul>
 <ul id="courtshiplist" class="demo-list-item mdl-list">
   <li class="mdl-list__item"><span
      class="mdl-list__item-primary-content"><a href="/Meeting/courtship/profile.do"><i class="material-icons small">face</i>Courtship</a> </span></li>

</ul> 
<ul id="lovetestlist" class="demo-list-item mdl-list">
   <li class="mdl-list__item"><span
      class="mdl-list__item-primary-content"><a href="/Meeting/love/lovetestmain.do"><i class="material-icons small">assignment</i>LoveTest</a> </span></li>
   
</ul> 

<!-- ------------------------------------------------- 김석현 ------------------------------------------------------------------------- -->
<c:if test="${isUser}">
<ul id="mypagelist" class="demo-list-item mdl-list">
   <li class="mdl-list__item"><a class="mdl-list__item-primary-content" href="/Meeting/mypage/todaylove.do"><i class="material-icons small">group</i> 오늘의 인연 </a></li>
   <li class="mdl-list__item"><a class="mdl-list__item-primary-content" href="/Meeting/mypage/myinfo.do"><i class="material-icons small">folder_shared</i> 나의 정보 </a></li>
   <li class="mdl-list__item"><a class="mdl-list__item-primary-content" href="/Meeting/mypage/updatemyinfopw.do"><i class="material-icons small">lock</i> 개인정보 수정</a></li>
   <li class="mdl-list__item"><span
      class="mdl-list__item-primary-content"><a href="/Meeting/mypage/managersos.do"><i class="material-icons small">feedback</i> 매니저 SOS</a>
   </span></li>
   <li class="mdl-list__item"><span
      class="mdl-list__item-primary-content"><a href="/Meeting/mypage/meeting.do"><i class="material-icons small">favorite</i> 미팅현황 </a></span></li>
   <li class="mdl-list__item"><a class="mdl-list__item-primary-content" href="/Meeting/mypage/withdrawalpw.do"><i class="material-icons small">flight_takeoff</i> 회원탈퇴</a></li>
</ul>
</c:if>


<c:if test="${isManager}">
<ul id="mypagelist" class="demo-list-item mdl-list">
   <li class="mdl-list__item"><a class="mdl-list__item-primary-content" href="/Meeting/mypage/manager/userlist.do"><i class="material-icons small">group</i> 회원 정보 리스트 </a></li>
   <li class="mdl-list__item"><a class="mdl-list__item-primary-content" href="/Meeting/mypage/manager/managersos.do"><i class="material-icons small">feedback</i> 매니저 SOS</a></li>
   <li class="mdl-list__item"><span
      class="mdl-list__item-primary-content"><a href="/Meeting/mypage/manager/meeting.do"><i class="material-icons small">local_library</i> 미팅현황</a>
   </span></li>
   <li class="mdl-list__item"><a class="mdl-list__item-primary-content" href="/Meeting/mypage/manager/withdrawlist.do"><i class="material-icons small">insert_chart</i> 담당회원 탈퇴현황</a></li>
</ul>
</c:if>

<c:if test="${isAdmin}">
<ul id="mypagelist" class="demo-list-item mdl-list">
   <li class="mdl-list__item"><a class="mdl-list__item-primary-content" href="/Meeting/mypage/admin/statistics.do"><i class="material-icons small">insert_chart</i>통계 </a></li>
</ul>
</c:if>