# EL (Expression Language)
- ***값을 표현할 때 사용하는 스크립트 언어***이다
- 요청파라미터 값의 표현을 담당한다
- PageContext, 요청객체, 세션객체, 애플리케이션 객체의 속성값을 표현한다
- 사칙연산/비교연산/논리연산자/기타 연산자 등을 제공한다

## EL의 내장객체
- param: ${param.파라미터명}
- paramValues: ${paramValues.파라미터명}
- pageScope: ${pageScope.속성명}
- requestScope: ${requestScope.속성명}
- sessionScope: ${sessionScope.속성명}
- applicationScope: ${applicaionScope.속성명}
- initParam: ${initParam.초기화파라미터명} 
- header: ${header.요청헤더명}
- cookie: ${cookie.쿠키명}
- pageContext: ${pageContext.getter메소드이름}
- EL 표현식으로 속성을 검색하면 <br> PageContext -> HttpServletRequest -> HttpSession -> ServletContext 순으로 표현식에서 지정한 속성을 검색한다.
- 각 객체를 순서대로 검색하는 도중 EL 표현식에 해당하는 속성이 발견되면, <br> 그 속성값을 표현하고 검색 순위상 뒤에 남아있는 객체에서는 검색작업을 수행하지 않는다.

- 아래 사진과 같이 연산식이 필요한 경우, jsp 내에서 연산을 하는 것이 아니라 <br> Cart 클래스에 getXXX 메소드로 정의해준 후 값을 조회할 수 있다.
- Cart 클래스 안에 discountPercent, discountedPrice, orderPrice가 멤버변수로 정의되어 있지 않아도 된다.
![image](https://user-images.githubusercontent.com/87356533/145796746-488c74cd-2a1b-4a6e-820b-2eb6241c3aae.png)

## empty 연산자
- empty 연산자는 `속성값이 null`이거나, `""`와 같이 빈문자열이거나, <br> `배열이나 콜렉션의 길이가 0`이거나, `비어있는 맵`인 경우에 true를 반환한다.
- empty 연산자는 아래와 같이 구현할 때 많이 사용한다.
```java
  // Controller
  public void searchController(HttpServletRequest request, HttpServletResponse response) {
    String keyword = request.getParameter("keyword");
    List<News> newsList = newsDao.searchNewsList(keyword);
    
    request.setAttribute("newsList", newsList);
    request.getRequestDispatcher("news.jsp").forward(request, response);
  }
```
```jsp
  <!-- news.jsp -->
  <table>
    <tbody>
      <c:if test="${empty newsList}">
        <tr>
          <td colspan="4">검색된 뉴스가 없습니다.</td>
        </tr>
       </c:if>
       <c:if test="${not empty newsList}">
        <c:forEach var="news" items="${newsList}">
          <tr>
            <td>${news.id}</td>
            <td>${news.title}</td>
            <td>${news.writer}</td>
            <td>${news.createdDate}</td>
          </tr>
       </c:if>
    </tbody>
  </table>
```
