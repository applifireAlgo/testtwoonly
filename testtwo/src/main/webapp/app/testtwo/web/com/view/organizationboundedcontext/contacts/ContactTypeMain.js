Ext.define('Testtwo.testtwo.web.com.view.organizationboundedcontext.contacts.ContactTypeMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ContactTypeMainController",
     "restURL": "/ContactType",
     "defaults": {
          "split": true
     },
     "requires": ["Testtwo.testtwo.shared.com.model.organizationboundedcontext.contacts.ContactTypeModel", "Testtwo.testtwo.web.com.controller.organizationboundedcontext.contacts.ContactTypeMainController", "Testtwo.testtwo.shared.com.viewmodel.organizationboundedcontext.contacts.ContactTypeViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "Contact Type",
               "name": "ContactTypeTreeContainer",
               "itemId": "ContactTypeTreeContainer",
               "restURL": "/ContactType",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "name": "entityTreePanel",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "ContactTypeTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "name": "filterButton",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": [{
                         "name": "contactType",
                         "itemId": "contactType",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Contact Type",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact Type",
                         "fieldId": "E1A9A943-D231-4C1C-9A9E-7652B55B66E8",
                         "minLength": "0",
                         "maxLength": "128",
                         "errorMessage": "Please enter contact type",
                         "bindable": "contactType"
                    }]
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "xtype": "form",
                    "displayName": "Contact Type",
                    "title": "Contact Type",
                    "name": "ContactType",
                    "itemId": "ContactTypeForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "contactTypeId",
                         "itemId": "contactTypeId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Contact Type Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact Type Id<font color='red'> *<\/font>",
                         "fieldId": "5F20EFD5-55B0-4ACE-8495-FD3343A2B491",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "contactTypeId"
                    }, {
                         "name": "contactType",
                         "itemId": "contactType",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Contact Type",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact Type<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "E1A9A943-D231-4C1C-9A9E-7652B55B66E8",
                         "minLength": "0",
                         "maxLength": "128",
                         "errorMessage": "Please enter contact type",
                         "bindable": "contactType",
                         "columnWidth": 0.5
                    }, {
                         "name": "contactTypeDesc",
                         "itemId": "contactTypeDesc",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Contact Type Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact Type Description",
                         "fieldId": "6AF70285-688D-44FF-8F6C-6971CC226496",
                         "bindable": "contactTypeDesc",
                         "columnWidth": 0.5
                    }, {
                         "name": "contactTypeIcon",
                         "itemId": "contactTypeIcon",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Contact Type Icon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact Type Icon",
                         "fieldId": "E7C13BC3-35FE-4AD6-A2BF-D519A44AE20D",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "contactTypeIcon",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "6FCCD37E-B989-49C9-AE4C-7ED69ED9E8B1",
                         "bindable": "versionId",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 321,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 321,
                              "customId": 842
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 321,
                              "customId": 843,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "resetFormButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 321,
                              "customId": 844,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "Contact Type",
                    "title": "Details Grid",
                    "name": "ContactTypeGrid",
                    "itemId": "ContactTypeGrid",
                    "restURL": "/ContactType",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Contact Type Id",
                         "dataIndex": "contactTypeId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Contact Type",
                         "dataIndex": "contactType",
                         "flex": 1
                    }, {
                         "header": "Contact Type Description",
                         "dataIndex": "contactTypeDesc",
                         "flex": 1
                    }, {
                         "header": "Contact Type Icon",
                         "dataIndex": "contactTypeIcon",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "xtype": "form",
               "displayName": "Contact Type",
               "title": "Contact Type",
               "name": "ContactType",
               "itemId": "ContactTypeForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "contactTypeId",
                    "itemId": "contactTypeId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Contact Type Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Contact Type Id<font color='red'> *<\/font>",
                    "fieldId": "5F20EFD5-55B0-4ACE-8495-FD3343A2B491",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "contactTypeId"
               }, {
                    "name": "contactType",
                    "itemId": "contactType",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Contact Type",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Contact Type<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "E1A9A943-D231-4C1C-9A9E-7652B55B66E8",
                    "minLength": "0",
                    "maxLength": "128",
                    "errorMessage": "Please enter contact type",
                    "bindable": "contactType",
                    "columnWidth": 0.5
               }, {
                    "name": "contactTypeDesc",
                    "itemId": "contactTypeDesc",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Contact Type Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Contact Type Description",
                    "fieldId": "6AF70285-688D-44FF-8F6C-6971CC226496",
                    "bindable": "contactTypeDesc",
                    "columnWidth": 0.5
               }, {
                    "name": "contactTypeIcon",
                    "itemId": "contactTypeIcon",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Contact Type Icon",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Contact Type Icon",
                    "fieldId": "E7C13BC3-35FE-4AD6-A2BF-D519A44AE20D",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "contactTypeIcon",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "6FCCD37E-B989-49C9-AE4C-7ED69ED9E8B1",
                    "bindable": "versionId",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 321,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 321,
                         "customId": 842
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 321,
                         "customId": 843,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "resetFormButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 321,
                         "customId": 844,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});