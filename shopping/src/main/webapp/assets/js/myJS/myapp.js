$(function() {
	console.log("--->", window.contextRoot);
	switch (menu) {
	case "About":
		$("#about").addClass("active");
		break;
	case "Contact":
		$("#contact").addClass("active");
		break;
	case "All Products":
		$("#listProduct").addClass("active");
		break;
	default:
		if (menu == "Home")
			break;
		$("#listProduct").addClass("active");
		$('#a_' + menu).addClass("active");
		break;
	}

	/*
	 * var products = [ [ '1', 'ABC' ], [ '2', 'XYZ' ], [ '3', 'ZXYABC' ], [
	 * '4', 'i3' ], [ '5', 'i5' ], [ '6', 'ryzen 5' ], [ '7', 'ryzen 3' ] ];
	 */
	var $table = $("#productListTable");

	// execute this code only where this table is available

	if ($table.length) {

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + "/json/data/all/products";
		} else {
			jsonUrl = window.contextRoot + "/json/data/category/"
					+ window.categoryId + "/products";
		}

		$table
				.DataTable({
					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img class="dataTableImg" src="'
											+ window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg">';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377,' + data;
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red;">Out of Stock!</span>';
									}
									return data;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a>';
									if (row.quantity < 1) {
										str += ' <a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									}
									str += ' <a href="'
											+ window.contextRoot
											+ '/cart/add/'
											+ data
											+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									return str;
								}
							}

					]
				});
	}
});