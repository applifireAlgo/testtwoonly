Ext.define('Testtwo.view.databrowsercalendar.DBCalendar', {
	extend : 'Testtwo.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Testtwo.view.databrowsercalendar.DBCalendarController',
	             'Testtwo.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
