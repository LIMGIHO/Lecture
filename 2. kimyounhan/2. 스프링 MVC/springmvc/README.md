# Spring MVC 김영한 강의

1. 2024.09.19
    1) Slf4j 
      - 로깅 사용법 학습

2. 2024.09.20
    1) 요청 맵핑 (MappingController.java)
      - @RestController : @Controller는 리턴되는 문자의 view를 찾아 반환하지만 @RestController는 문자를 그대로 http body에 담아 리턴
      - PathVariabel
      - 미디어타입조건 매핑 : consumes, produce

3. 2024.09.22
  1) class 단에서 @RequestMapping("/mapping/users")으로 url 공통 부분 처리
  2) @RequestMapping("/headers") 이렇게 하면 get, post, put, delete 등 모든 method 처리 가능
  3) 에러에서 java.lang.IllegalArgumentException: Invalid character found in method name 메시지에서 [{0x0d0x0a ]
    발생시 CR(케리지리턴), 즉 url에 엔터값이 들어가 있는것임
  4) @ResponseBody 애노테이션 사용시 @Controller여도 return 시 view 이름으로 반환 되는게 아니라 String 그대로 반환 됨(@RestController 효과)

  4. 2024.09.23
    1) messageBody 가져오는 변천사
       HttpServletRequest - ServletInputStream(request.getInputStream())
    2) InputStream
    3) HttpEntity
    4) @RequestBody, @RequestHeader

      - 최종적으로 거의 이걸 사용

  5. 2024.09.23
    1) StandardCharsets.UTF_8 자동임포트가 안됨..
       - import java.nio.charset.StandardCharsets; 사용
    2) @ModelAttribute, @RequestParam 생략시 다음 규칙 적용
       - 단순 타입(String, int, Integer등) : @RequestPAram
       - 나머지 : @ModelAttribute

    3) Response
       - 정적응답
       - 뷰 템플릿 : 동적HTML, SSR
       - HTTP Message : Rest API
       
       
  6. 2024.09.25
    1)  메세지컨버터 작동 순서
      (1) 클래스 타입 일치 여부 체크
      (2) 미디어 타입 일치 여부 체크

  7. 2024.09.26
    1) 요청 맵핑 핸들러
      - Argument Resolver 에서 매개변수들을 만들어서 넘겨줌
        (@RequestParam, HttpServletRequest 등등 30개가 넘음)
      - ReturnValue Handler 에서 컨트롤러의 반환 값을 변환
        (ModelAndView, String등등)
      - 여기서 h
      ttp메세지 컨버터가 사용된다
    2) 확장 필요시 WebMvcConfigurer 스프링빈에 등록하면 된다.