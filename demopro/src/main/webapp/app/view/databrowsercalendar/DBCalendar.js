Ext.define('Demopro.view.databrowsercalendar.DBCalendar', {
	extend : 'Demopro.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Demopro.view.databrowsercalendar.DBCalendarController',
	             'Demopro.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
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
