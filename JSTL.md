# JSTL(JSP Standard Tag Library)
- JSP 표준 라이브러리
- 스크립틀릿을 사용해 작성했던 자바코드를 대체할 수 있다.
- 사용법 예시
  + JSTL 파일을 다운받아 WEB-INF/lib에 넣는다.
```JSP
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" 
```

## 태그 종류
- core 태그
  + 변수/출력/제어문/반복문/URL 처리를 지원한다.

- ftm 태그
  + 숫자나 날짜에 대한 포맷팅을 지원한다.

- function 태그
  + String 클래스의 주요 메소드 사용을 지원한다.

- tld는 tag library definition 파일이다.
  + 사진에서와 같이 태그의 별칭과 uri를 확인할 수 있다.
![image](https://user-images.githubusercontent.com/87356533/145973992-574d3a2d-7aa4-45ac-8c8d-f641670f5676.png)

## Core 태그 라이브러리
- c:out 태그
- 주요 속성
  + value : 값을 출력하며, 생략할 수 없다.
![image](https://user-images.githubusercontent.com/87356533/145974351-d8c9a6e3-fe46-4e8e-95fb-b8bce9e57e89.png)
- c:if 태그
  + if문과 동일한 역할을 수행하며, else에 해당하는 태그는 없다.
  + <c:when>과 <c:otherwise>는 반드시 <c:choose> 안에 위치해야 한다.
- 주요 속성
  + test : 검사조건을 정의하고, 생략할 수 없다. 결과값은 boolean 타입이어야 한다.
![image](https://user-images.githubusercontent.com/87356533/145974970-6adb253b-b371-4c50-8330-d4c0532b229d.png)
- c:forEach 태그
  + for문과 같은 역할을 수행한다.
  + 배열 혹은 콜렉션에 대해서 그 항목의 개수만큼 반복작업을 수행한다.
  + var 안에는 변수명을 적고, items 안에는 ${표현식}과 같은 형태로 적는다.
  + varStatus에 지정된 변수는 현재 반복상태 정보를 담고 있는 객체가 전달된다.
    + index: 인덱스번호(0번부터 시작)
    + count: 반복 횟수(1부터 시작)
    + first: 첫번째 요소인 경우
    + last: 마지막번째 요소인 경우
![image](https://user-images.githubusercontent.com/87356533/145975590-c5bb8f9e-a3a0-42b8-9649-1d8b081eb9d9.png)
- c:forEach를 사용하는 다른 방식
  + var에는 변수명, begin에는 시작 페이지번호, end에는 긑 페이지번호를 적는다.
![image](https://user-images.githubusercontent.com/87356533/145976039-85a1280e-c9c9-4b60-b602-dca0d18d0f18.png)


