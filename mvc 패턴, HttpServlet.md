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

# Servlet
- Http 요청을 처리할 수 있는 자바 클래스 (웹 개발을 위해 만든 표준)
- 클라이언트의 HTTP 요청을 처리하는 자바클래스는 반드시 HttpServlet을 상속받아야 한다
- 서블릿을 실행하기 위해서는 서버가 필요하다
- 서블릿의 생성/유지/관리/폐기, 요청에 대한 적절한 서블릿의 실행을 서버가 담당한다

# HttpServlet
- HTTP 요청을 처리하는 모든 웹 애플리케이션의 부모 클래스
- 주요 메소드
  + void init()
    + HttpServlet 객체의 초기화를 담당한다
    + Tomcat이 HttpServlet 객체를 생성하면 init() 메소드를 실행한다
    + 성공적으로 init() 메소드가 호출되었다면 service() 메소드를 수행해서 클라이언트의 요청을 수행한다
  + void destroy()
    + 서블릿 객체가 더이상 서비스를 하고 있지 않는 경우 호출된다<br>(서블릿이 메모리로부터 제거)
  + void service(HttpServletRequest request, HttpServletResponse response)
    + Http 요청이 올 때마다 실행되는 메소드다
    + Http 요청을 분석해서 요청 방식을 확인하고, 요청방식에 따라서 메소드를 실행한다
    + 요청 방식에 따라 아래에 나열된 네가지 메소드를 호출한다(주로 doGet, doPost를 사용)
    + 주로 재정의되어 사용된다
  + void doGet(HttpServletRequest request, HttpServletResponse response)
  + void doPost(HttpServletRequest request, HttpServletResponse response)
  + void doPut(HttpServletRequest request, HttpServletResponse response)
  + void doDelete(HttpServletRequest request, HttpServletResponse response)

# 프론트 컨트롤러
- 모든 요청을 .hta로 받아온다
![image](https://user-images.githubusercontent.com/87356533/145699320-3c5e0376-13fd-468b-9097-f54a5379cead.png)
![image](https://user-images.githubusercontent.com/87356533/145699332-b094510b-c40d-447d-9093-282c3ed6d26d.png)

# 컨트롤러
- 요청 하나당 컨트롤러가 필요하기 때문에 많은 컨트롤러가 필요할 수 있다
![image](https://user-images.githubusercontent.com/87356533/145699290-4ebf2690-deb1-4fe6-bb69-ef76f2966f4f.png)
