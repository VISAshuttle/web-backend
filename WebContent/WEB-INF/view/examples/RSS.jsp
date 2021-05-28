<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../include/header.jspf" %>

<link rel="stylesheet" href="<%= contextPath %>/resources/dist/css/pages/RSS.css">
<link rel="stylesheet" href="<%= contextPath %>/resources/dist/css/pages/RestArea.css">

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			RSS Reader <small>it all starts here</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">Examples</a></li>
			<li class="active">RSS Reader</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">

		<!-- Default box -->
		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">조선일보 기사 모음</h3>

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
				<div id="news_wrap">
					<h2>
						<a href="http://myhome.chosun.com/rss/www_section_rss.xml">주요뉴스</a>
					</h2>
					<h2>
						<a
							href="http://newsplus.chosun.com/hitdata/xml/newsplus/index/index.xml">인기뉴스</a>
					</h2>
					<h2>
						<a
							href="http://newsplus.chosun.com/hitdata/xml/se/sports/index.xml">스포츠</a>
					</h2>
					<ul id="news_list"></ul>
				</div>
			</div>
			<!-- /.box-body -->
			<div class="box-footer">Footer</div>
			<!-- /.box-footer-->
		</div>
		<!-- /.box -->

		<!-- Second box -->
		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">휴게소별 날씨 정보</h3>

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
				<table id="restarea_weather">

				</table>
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

<script src="<%= contextPath %>/resources/dist/js/pages/RSS.js"></script>
<script src="<%= contextPath %>/resources/dist/js/pages/RestArea.js"></script>