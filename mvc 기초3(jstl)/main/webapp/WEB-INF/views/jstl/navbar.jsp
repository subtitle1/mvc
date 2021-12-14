<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-light navbar-light">
	<div class="container">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link ${menu eq '샘플1' ? 'active' : ''}" href="/model2-app/jstl1.hta">샘플1</a></li>
			<li class="nav-item"><a class="nav-link ${menu eq '샘플2' ? 'active' : ''}" href="/model2-app/jstl2.hta">샘플2</a></li>
			<li class="nav-item"><a class="nav-link ${menu eq '샘플3' ? 'active' : ''}" href="/model2-app/jstl3.hta">샘플3</a></li>
			<li class="nav-item"><a class="nav-link ${menu eq '샘플4' ? 'active' : ''}" href="/model2-app/jstl4.hta">샘플4</a></li>
		</ul>
	</div>
</nav>