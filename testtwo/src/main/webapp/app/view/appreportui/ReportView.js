Ext.define('Testtwo.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Testtwo.view.appreportui.ReportViewController',
	            'Testtwo.view.appreportui.datagrid.DataGridPanel',
	            'Testtwo.view.appreportui.datagrid.DataGridView',
	            'Testtwo.view.appreportui.querycriteria.QueryCriteriaView',
	            'Testtwo.view.appreportui.chart.ChartView',
	            'Testtwo.view.appreportui.datapoint.DataPointView',
	            'Testtwo.view.googlemaps.map.MapPanel',
	            'Testtwo.view.appreportui.chartpoint.ChartPointView'
	            ],
	xtype : 'reportView',
	controller : 'reportViewController',
	layout : 'border',
	reportJSON:null,
	listeners : {
		scope : 'controller',
		afterrender : 'afterRenderReport',
		boxready : 'fetchReportData'
	}
});
