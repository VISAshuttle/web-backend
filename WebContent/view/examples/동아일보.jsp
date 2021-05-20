<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../include/header.jspf" %>

<link rel="stylesheet" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/moonspam/NanumSquare@1.0/nanumsquare.css">

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			동아일보 <small>최신 기사 모음</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">Examples</a></li>
			<li class="active">동아일보 RSS</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">

		<!-- Default box -->
		<div class="box">
			<div class="box-header with-border">
				<!-- <h3 class="box-title">Title</h3> -->
				<div id="google_translate_element"></div>

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
				<table id="donga" class="display" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>사진</th>
							<th>기사제목</th>
							<th>작성일시</th>
						</tr>
					</thead>
					<tfoot>

					</tfoot>
					<tbody>

					</tbody>
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

<script 	src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
<script src="<%= contextPath %>/resources/dist/js/pages/동아일보.js"></script>
<script>
		function googleTranslateElementInit() {
			new google.translate.TranslateElement({
				pageLanguage: 'ko,en',
				includedLanguages: 'ko,en,ja,zh-CN',
				layout: google.translate.TranslateElement.InlineLayout.SIMPLE
			}, 'google_translate_element');
		}
	</script>
<script 	src="http://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>