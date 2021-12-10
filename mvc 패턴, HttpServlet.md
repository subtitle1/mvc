# MVC 패턴
- 모델2 개발방식이라고도 부른다
- Model
  + View가 표시할 데이터, 혹은 ***데이터를 획득하는 과정(업무로직, DB 엑세스 작업)에서 실행되는 자바 클래스***를 일컫는다. <br> `(vo, dao, dto, service 등)`
- View
  + Model에 포함된 ***데이터의 표현***을 담당한다 `(jsp)`
- Controller
  + 클라이언트의 ***요청처리를 담당***한다
  + 클라이언트의 요청방식에 따라 다양한 컨트롤러가 존재할 수 있다
  + 컨트롤러는 특정 클라이언트의 요청에 종속적이다
  + public void execute(HttpServletRequest request, HttpServletResponse response) { ... }
  + 위에 정의된 메소드는 프론트컨트롤러로부터 요청객체, 응답객체를 전달받아서 클라이언트의 요청을 처리하는 메소드다
- Front controller
  + 서블릿(HTTP 요청을 처리할 수 있는 자바클래스)로 제작

# MVC 개발 방식의 특징
- 디자인요소와 로직요소가 분리된다
- view를 담당하는 jsp에서 스크립틀릿, 표현식을 제거할 수 있다 (EL, JSTL 사용)
- 장점
  + 로직의 재사용성 높아짐
  + 디자인요소, 로직요소가 분리되어 복잡도 감소
  + 유지보수성이 높아짐
- 단점
  + 프로그램의 구조가 복잡해짐
  + 라이브러리나 프레임워크의 추가 및 설정이 필요함

# HttpServlet
- HTTP 요청을 처리하는 모든 웹 애플리케이션의 부모 클래스
- 주요 메소드
  + void init()
  + void destroy()
  + void service(HttpServletRequest request, HttpServletResponse response)
  + void doGet(HttpServletRequest request, HttpServletResponse response)
  + void doPost(HttpServletRequest request, HttpServletResponse response)
  + void doPut(HttpServletRequest request, HttpServletResponse response)
  + void doDelete(HttpServletRequest request, HttpServletResponse response)
