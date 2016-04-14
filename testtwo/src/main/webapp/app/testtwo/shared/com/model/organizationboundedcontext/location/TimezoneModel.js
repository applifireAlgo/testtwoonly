Ext.define('Testtwo.testtwo.shared.com.model.organizationboundedcontext.location.TimezoneModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "timeZoneId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "utcdifference",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "gmtLabel",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "timeZoneLabel",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "country",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "cities",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});