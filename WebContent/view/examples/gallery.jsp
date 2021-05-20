<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../include/header.jspf" %>

<link rel="stylesheet" href="<%= contextPath %>/resources/dist/css/pages/gallery.css">

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			갤러리 <small>it all starts here</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">Examples</a></li>
			<li class="active">Blank page</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">

		<!-- Default box -->
		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">웹 브라우저 로고 모음</h3>

				<div class="box-tools pull-right">
					<button type="button" class="btn btn-box-tool"
						data-widget="collapse" data-toggle="tooltip" title="Collapse">
						<i class="fa fa-minus"></i>
					</button>
					<button type="button" class="btn btn-box-tool" data-widget="remove"
						data-toggle="tooltip" title="Remove">
						<i class="fa fa-times"></i>
					</button>
				</div>
			</div>
			<div class="box-body">
				<div id="gallery">
					<p id="photo">
						<img
							src="<%= contextPath %>/resources/dist/img/gallery/web_browser/chrome.png"
							alt="" />
					</p>
					<div id="photo_list">
						<ul id="inner_list">
							<li><a
								href="<%= contextPath %>/resources/dist/img/gallery/web_browser/chrome.png">
									<img
									src="<%= contextPath %>/resources/dist/img/gallery/web_browser/chrome.png"
									alt="chrome" />
							</a></li>
							<li><a
								href="<%= contextPath %>/resources/dist/img/gallery/web_browser/chromium.png">
									<img
									src="<%= contextPath %>/resources/dist/img/gallery/web_browser/chromium.png"
									alt="chromium" />
							</a></li>
							<li><a
								href="<%= contextPath %>/resources/dist/img/gallery/web_browser/firefox.png">
									<img
									src="<%= contextPath %>/resources/dist/img/gallery/web_browser/firefox.png"
									alt="firefox" />
							</a></li>
							<li><a
								href="<%= contextPath %>/resources/dist/img/gallery/web_browser/opera.png">
									<img
									src="<%= contextPath %>/resources/dist/img/gallery/web_browser/opera.png"
									alt="opera" />
							</a></li>
							<li><a
								href="<%= contextPath %>/resources/dist/img/gallery/web_browser/safari.png">
									<img
									src="<%= contextPath %>/resources/dist/img/gallery/web_browser/safari.png"
									alt="safari" />
							</a></li>
							<li><a
								href="<%= contextPath %>/resources/dist/img/gallery/web_browser/edge.png">
									<img
									src="<%= contextPath %>/resources/dist/img/gallery/web_browser/edge.png"
									alt="edge" />
							</a></li>
							<li><a
								href="<%= contextPath %>/resources/dist/img/gallery/web_browser/IE11.png">
									<img
									src="<%= contextPath %>/resources/dist/img/gallery/web_browser/IE11.png"
									alt="IE" />
							</a></li>
							<li><a
								href="<%= contextPath %>/resources/dist/img/gallery/web_browser/samsung.png">
									<img
									src="<%= contextPath %>/resources/dist/img/gallery/web_browser/samsung.png"
									alt="samsung" />
							</a></li>
							<li><a
								href="<%= contextPath %>/resources/dist/img/gallery/web_browser/puffin.png">
									<img
									src="<%= contextPath %>/resources/dist/img/gallery/web_browser/puffin.png"
									alt="puffin" />
							</a></li>
							<li><a
								href="<%= contextPath %>/resources/dist/img/gallery/web_browser/dolphin.png">
									<img
									src="<%= contextPath %>/resources/dist/img/gallery/web_browser/dolphin.png"
									alt="dolphin" />
							</a></li>
						</ul>
					</div>
					<p class="btn_wrap">
						<a href="#" id="before_btn">&lt;</a> <a href="#" id="next_btn">&gt;</a>
					</p>
				</div>
			</div>
			<!-- /.box-body -->
			<div class="box-footer">Footer</div>
			<!-- /.box-footer-->
		</div>
		<!-- /.box -->

	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@ include file="../include/footer.jspf" %>

<script src="<%= contextPath %>/resources/dist/js/pages/gallery.js"></script>