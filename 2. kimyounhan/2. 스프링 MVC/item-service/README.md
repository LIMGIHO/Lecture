# Spring MVC 김영한 강의

-- 상품관리 앱
1. Thymeleaf 문법 사용법
  1) |..| -> 리터럴 대체
  2) th:each - 반복
  3) ${} : 변수표현식
  4) th:text - 내용 변경
  5) @{...} - URL링크표현식
    - (.., query='test') 식으로 쿼리파라메터도 사용 가능

2. Controller
  1) ModelAttribute("item") 사용시 model에 자동으로 등록 됨
  2) ModelAttribute("item")의 item도 생략 가능,
     -객체의 이름의 첫글자만 소문자로 바꾼 후 modelattribute에 등록
     -@ModelAttribute 자체도 생략 가능

3. 상품 수정 개발 차례
  1) 리다이렉트
  2) PRG (Post/Redirec/Get)
    - 브라우저에서 새로고침시 마지막 요청을 다시 하기때문에 등록(post) 요청을 다시하게 된다.
    - 그걸 막기 위해 리다이렉트를 사용