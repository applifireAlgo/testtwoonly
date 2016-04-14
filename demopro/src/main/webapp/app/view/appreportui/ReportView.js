Ext.define('Demopro.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Demopro.view.appreportui.ReportViewController',
	            'Demopro.view.appreportui.datagrid.DataGridPanel',
	            'Demopro.view.appreportui.datagrid.DataGridView',
	            'Demopro.view.appreportui.querycriteria.QueryCriteriaView',
	            'Demopro.view.appreportui.chart.ChartView',
	            'Demopro.view.appreportui.datapoint.DataPointView',
	            'Demopro.view.googlemaps.map.MapPanel',
	            'Demopro.view.appreportui.chartpoint.ChartPointView'
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
