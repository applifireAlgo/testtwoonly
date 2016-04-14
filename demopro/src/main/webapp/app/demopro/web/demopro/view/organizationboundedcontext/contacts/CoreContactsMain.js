Ext.define('Demopro.demopro.web.demopro.view.organizationboundedcontext.contacts.CoreContactsMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CoreContactsMainController",
     "restURL": "/CoreContacts",
     "defaults": {
          "split": true
     },
     "requires": ["Demopro.demopro.shared.demopro.model.organizationboundedcontext.contacts.CoreContactsModel", "Demopro.demopro.web.demopro.controller.organizationboundedcontext.contacts.CoreContactsMainController", "Demopro.demopro.shared.demopro.model.organizationboundedcontext.contacts.TitleModel", "Demopro.demopro.shared.demopro.model.organizationboundedcontext.location.LanguageModel", "Demopro.demopro.shared.demopro.model.organizationboundedcontext.contacts.GenderModel", "Demopro.demopro.shared.demopro.model.organizationboundedcontext.location.TimezoneModel", "Demopro.view.fw.component.Grids", "Demopro.demopro.shared.demopro.model.organizationboundedcontext.location.AddressTypeModel", "Demopro.demopro.shared.demopro.model.organizationboundedcontext.location.CountryModel", "Demopro.demopro.shared.demopro.model.organizationboundedcontext.location.StateModel", "Demopro.demopro.shared.demopro.model.organizationboundedcontext.location.CityModel", "Demopro.view.fw.component.Grids", "Demopro.demopro.shared.demopro.model.organizationboundedcontext.contacts.CommunicationGroupModel", "Demopro.demopro.shared.demopro.model.organizationboundedcontext.contacts.CommunicationTypeModel", "Demopro.demopro.shared.demopro.viewmodel.organizationboundedcontext.contacts.CoreContactsViewModel"],
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
               "displayName": "Core Contacts",
               "name": "CoreContactsTreeContainer",
               "itemId": "CoreContactsTreeContainer",
               "margin": "5 0 5 5",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "useArrows": true,
                    "name": "entityTreePanel",
                    "title": "Browse",
                    "rootVisible": false,
                    "itemId": "CoreContactsTree",
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
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick",
                         "name": "filterButton"
                    }],
                    "items": []
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
                    "xtype": "form",
                    "displayName": "Core Contacts",
                    "name": "CoreContacts",
                    "itemId": "CoreContactsForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form0",
                         "customWidgetType": "vdCard",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "contactId",
                                   "itemId": "contactId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Contact Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Contact Id<font color='red'> *<\/font>",
                                   "fieldId": "1F3A2EE5-F465-4838-9E1D-4A49294902D8",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "contactId"
                              }, {
                                   "name": "titleId",
                                   "itemId": "titleId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Title",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Demopro.demopro.shared.demopro.model.organizationboundedcontext.contacts.TitleModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Title<font color='red'> *<\/font>",
                                   "fieldId": "5BAED388-AFF1-480C-B889-B8B9300F8F95",
                                   "errorMessage": "Please enter title",
                                   "restURL": "Title",
                                   "bindable": "titleId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "firstName",
                                   "itemId": "firstName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "First Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "First Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "E8A998B0-CC69-4908-8012-80A605EF3257",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "errorMessage": "Please enter First Name",
                                   "bindable": "firstName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "middleName",
                                   "itemId": "middleName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Middle Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Middle Name",
                                   "fieldId": "150CE7A6-6EEB-42A7-A310-29148403353B",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "middleName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "lastName",
                                   "itemId": "lastName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Last Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Last Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "CE6DDDC1-8A52-4E44-8DA2-5C91781F21EB",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "errorMessage": "Please enter Last Name",
                                   "bindable": "lastName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "nativeLanguageCode",
                                   "itemId": "nativeLanguageCode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Native Language Code",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Demopro.demopro.shared.demopro.model.organizationboundedcontext.location.LanguageModel"
                                   },
                                   "fieldLabel": "Native Language Code",
                                   "fieldId": "21B03CCB-45AF-4E76-A73F-9C1620CE8F98",
                                   "errorMessage": "Please enter gender",
                                   "restURL": "Language",
                                   "bindable": "nativeLanguageCode",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "nativeTitle",
                                   "itemId": "nativeTitle",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Native Title",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "fieldLabel": "Native Title",
                                   "fieldId": "CD2AD0FA-E620-446A-ABF8-AEB78E2B4118",
                                   "bindable": "nativeTitle",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "nativeFirstName",
                                   "itemId": "nativeFirstName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Native First Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Native First Name",
                                   "fieldId": "57F08BB7-7B08-4224-81C1-BEA120FF8E55",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "nativeFirstName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "nativeMiddleName",
                                   "itemId": "nativeMiddleName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Native Middle Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Native Middle Name",
                                   "fieldId": "778C2F21-E65F-431F-9848-4F505A7DA6EC",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "nativeMiddleName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "nativeLastName",
                                   "itemId": "nativeLastName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Native LastName",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Native LastName",
                                   "fieldId": "A2891A04-CD95-4525-B563-5405651F3F13",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "nativeLastName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "genderId",
                                   "itemId": "genderId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Gender",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Demopro.demopro.shared.demopro.model.organizationboundedcontext.contacts.GenderModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Gender<font color='red'> *<\/font>",
                                   "fieldId": "2B045906-ED7F-49A9-823A-BCF7C9DBD103",
                                   "errorMessage": "Please enter gender",
                                   "restURL": "Gender",
                                   "bindable": "genderId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "dateofbirth",
                                   "itemId": "dateofbirth",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "DOB",
                                   "margin": "5 5 5 5",
                                   "format": "d-m-Y",
                                   "submitFormat": "d-m-Y",
                                   "fieldLabel": "DOB",
                                   "fieldId": "49B7390F-E748-4454-A286-4FA99B402908",
                                   "errorMessage": "Please enter Date of birth",
                                   "bindable": "dateofbirth",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "age",
                                   "itemId": "age",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Age",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Age",
                                   "fieldId": "9A5101CB-23E3-42C6-811D-AEFB4094A8AF",
                                   "minValue": "0",
                                   "maxValue": "125",
                                   "bindable": "age",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "approximateDOB",
                                   "itemId": "approximateDOB",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Approx DOB",
                                   "margin": "5 5 5 5",
                                   "format": "d-m-Y",
                                   "submitFormat": "d-m-Y",
                                   "fieldLabel": "Approx DOB",
                                   "fieldId": "3B8C80EE-37C4-40D3-8EEC-C5ED2AE5777C",
                                   "bindable": "approximateDOB",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "emailId",
                                   "itemId": "emailId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Email ID",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Email ID<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "5EE7646F-DAD8-4B1A-87A7-25F2D9ABE57A",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "errorMessage": "Please enter Email ID",
                                   "bindable": "emailId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "phoneNumber",
                                   "itemId": "phoneNumber",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Phone Number",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Phone Number<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "F3CF4680-2991-4B6A-BB1E-11ADB21D671D",
                                   "minLength": "0",
                                   "maxLength": "20",
                                   "errorMessage": "Please enter Phone Number",
                                   "bindable": "phoneNumber",
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
                                   "fieldId": "C3A95DFC-4046-4CC0-9E4C-ED1C2A004073",
                                   "bindable": "versionId",
                                   "hidden": true
                              }, {
                                   "xtype": "combo",
                                   "name": "Timezone",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "margin": 5,
                                   "bindable": "timezone.timeZoneId",
                                   "typeAhead": true,
                                   "columnWidth": 0.5,
                                   "queryMode": "local",
                                   "minChars": 1,
                                   "fieldLabel": "Timezone<font color='red'> *<\/font>",
                                   "title": "Timezone",
                                   "itemId": "timezone",
                                   "store": {
                                        "data": [],
                                        "model": "Demopro.demopro.shared.demopro.model.organizationboundedcontext.location.TimezoneModel"
                                   }
                              }]
                         }]
                    }, {
                         "xtype": "form",
                         "displayName": "Address",
                         "title": "Address",
                         "name": "Address",
                         "itemId": "AddressForm",
                         "bodyPadding": 10,
                         "items": [{
                              "xtype": "form",
                              "itemId": "form1",
                              "customWidgetType": "vdAnchorLayout",
                              "header": {
                                   "hidden": true
                              },
                              "items": [{
                                   "layout": "column",
                                   "customWidgetType": "vdColumnLayout",
                                   "header": {
                                        "hidden": true
                                   },
                                   "xtype": "panel",
                                   "items": [{
                                        "name": "addressId",
                                        "itemId": "addressId",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Address Id",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address Id<font color='red'> *<\/font>",
                                        "fieldId": "8988F5DD-B155-49BA-B07A-69F26A1265C7",
                                        "minLength": "0",
                                        "maxLength": "64",
                                        "hidden": true,
                                        "value": "",
                                        "bindable": "address.addressId"
                                   }, {
                                        "name": "addressTypeId",
                                        "itemId": "addressTypeId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Address Type",
                                        "margin": "5 5 5 5",
                                        "valueField": "primaryKey",
                                        "displayField": "primaryDisplay",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Demopro.demopro.shared.demopro.model.organizationboundedcontext.location.AddressTypeModel"
                                        },
                                        "allowBlank": false,
                                        "fieldLabel": "Address Type<font color='red'> *<\/font>",
                                        "fieldId": "65E394AF-4D80-4386-9CF7-731F5BF0726F",
                                        "errorMessage": "Please enter valid Address type",
                                        "restURL": "AddressType",
                                        "bindable": "address.addressTypeId",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "addressLabel",
                                        "itemId": "addressLabel",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Address Label",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address Label",
                                        "fieldId": "5BDD6E41-FD27-45E6-96A6-4AF4208BF366",
                                        "minLength": "0",
                                        "maxLength": "11",
                                        "bindable": "address.addressLabel",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "address1",
                                        "itemId": "address1",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Address1",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address1",
                                        "fieldId": "D78AE565-2332-4437-B05B-BD449E69DB79",
                                        "bindable": "address.address1",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "address2",
                                        "itemId": "address2",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Address2",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address2",
                                        "fieldId": "F005F2A1-1FE6-4DFB-9EFE-B3C9DFFC43D9",
                                        "bindable": "address.address2",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "address3",
                                        "itemId": "address3",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Address3",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address3",
                                        "fieldId": "AE1B3611-44FA-4B6B-94C5-84486394CE23",
                                        "bindable": "address.address3",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "countryId",
                                        "itemId": "countryId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Country",
                                        "margin": "5 5 5 5",
                                        "valueField": "primaryKey",
                                        "displayField": "primaryDisplay",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Demopro.demopro.shared.demopro.model.organizationboundedcontext.location.CountryModel"
                                        },
                                        "allowBlank": false,
                                        "fieldLabel": "Country<font color='red'> *<\/font>",
                                        "fieldId": "041C6D28-D13B-4763-9219-68B8B826AC73",
                                        "errorMessage": "Please enter Country",
                                        "restURL": "Country",
                                        "bindable": "address.countryId",
                                        "columnWidth": 0.5,
                                        "listeners": {
                                             "change": "onCountryIdChange"
                                        }
                                   }, {
                                        "name": "stateId",
                                        "itemId": "stateId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "State",
                                        "margin": "5 5 5 5",
                                        "valueField": "primaryKey",
                                        "displayField": "primaryDisplay",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Demopro.demopro.shared.demopro.model.organizationboundedcontext.location.StateModel"
                                        },
                                        "allowBlank": false,
                                        "fieldLabel": "State<font color='red'> *<\/font>",
                                        "fieldId": "F3E55A34-161B-4591-A5E4-890081F05A6E",
                                        "errorMessage": "Please enter State",
                                        "restURL": "State",
                                        "bindable": "address.stateId",
                                        "columnWidth": 0.5,
                                        "listeners": {
                                             "change": "onStateIdChange"
                                        }
                                   }, {
                                        "name": "cityId",
                                        "itemId": "cityId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "City",
                                        "margin": "5 5 5 5",
                                        "valueField": "primaryKey",
                                        "displayField": "primaryDisplay",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Demopro.demopro.shared.demopro.model.organizationboundedcontext.location.CityModel"
                                        },
                                        "allowBlank": false,
                                        "fieldLabel": "City<font color='red'> *<\/font>",
                                        "fieldId": "088856BF-3BAB-49F0-9AF9-B63DBE345A4E",
                                        "errorMessage": "Please enter City",
                                        "restURL": "City",
                                        "bindable": "address.cityId",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "zipcode",
                                        "itemId": "zipcode",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Postal Code",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Postal Code<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "D99C82FE-4337-4CE1-9281-3E6FEC9136C1",
                                        "minLength": "0",
                                        "maxLength": "6",
                                        "errorMessage": "Please enter postal code",
                                        "bindable": "address.zipcode",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "latitude",
                                        "itemId": "latitude",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Latitude",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Latitude",
                                        "fieldId": "4D3730E0-2A71-4703-A651-9EA51B38D640",
                                        "minLength": "0",
                                        "maxLength": "64",
                                        "bindable": "address.latitude",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "longitude",
                                        "itemId": "longitude",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Longitude",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Longitude",
                                        "fieldId": "CC125136-1142-4DCE-AAE9-E21B4E301F89",
                                        "minLength": "0",
                                        "maxLength": "64",
                                        "bindable": "address.longitude",
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
                                        "fieldId": "8D6118D5-F962-410A-8816-90CF7B796AF8",
                                        "bindable": "address.versionId",
                                        "hidden": true
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 132,
                              "text": "Add Address",
                              "handler": "addAddress"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "Address",
                              "columnWidth": 1,
                              "itemId": "AddressGrid",
                              "fieldLabel": "List",
                              "bindLevel": "address",
                              "bindable": "address",
                              "listeners": {
                                   "select": "onAddressGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "Address Id",
                                   "text": "Address Id",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "addressId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "Address Type",
                                   "text": "Address Type",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "addressTypeId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Address Label",
                                   "text": "Address Label",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "addressLabel",
                                   "flex": 1
                              }, {
                                   "header": "Address1",
                                   "text": "Address1",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "address1",
                                   "flex": 1
                              }, {
                                   "header": "Address2",
                                   "text": "Address2",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "address2",
                                   "flex": 1
                              }, {
                                   "header": "Address3",
                                   "text": "Address3",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "address3",
                                   "flex": 1
                              }, {
                                   "header": "Country",
                                   "text": "Country",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "countryId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "State",
                                   "text": "State",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "stateId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "City",
                                   "text": "City",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "cityId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Postal Code",
                                   "text": "Postal Code",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "zipcode",
                                   "flex": 1
                              }, {
                                   "header": "Latitude",
                                   "text": "Latitude",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "latitude",
                                   "flex": 1
                              }, {
                                   "header": "Longitude",
                                   "text": "Longitude",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "longitude",
                                   "flex": 1
                              }, {
                                   "header": "createdBy",
                                   "text": "createdBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "createdDate",
                                   "text": "createdDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedBy",
                                   "text": "updatedBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedDate",
                                   "text": "updatedDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "versionId",
                                   "text": "versionId",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "versionId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "activeStatus",
                                   "text": "activeStatus",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "activeStatus",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "txnAccessCode",
                                   "text": "txnAccessCode",
                                   "customWidgetType": "vdGridColumn",
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
                                        "handler": "onDeleteActionColumnClick"
                                   }]
                              }]
                         }],
                         "customWidgetType": "vdCard"
                    }, {
                         "xtype": "form",
                         "displayName": "Communication Data",
                         "title": "Communication Data",
                         "name": "CommunicationData",
                         "itemId": "CommunicationDataForm",
                         "bodyPadding": 10,
                         "items": [{
                              "xtype": "form",
                              "itemId": "form1",
                              "customWidgetType": "vdAnchorLayout",
                              "header": {
                                   "hidden": true
                              },
                              "items": [{
                                   "layout": "column",
                                   "customWidgetType": "vdColumnLayout",
                                   "header": {
                                        "hidden": true
                                   },
                                   "xtype": "panel",
                                   "items": [{
                                        "name": "commDataId",
                                        "itemId": "commDataId",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "commType",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "commType<font color='red'> *<\/font>",
                                        "fieldId": "BF4C98DA-9EE3-4454-9D85-810C75033889",
                                        "minLength": "0",
                                        "maxLength": "64",
                                        "hidden": true,
                                        "value": "",
                                        "bindable": "communicationData.commDataId"
                                   }, {
                                        "name": "commGroupId",
                                        "itemId": "commGroupId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Communication Group",
                                        "margin": "5 5 5 5",
                                        "valueField": "primaryKey",
                                        "displayField": "primaryDisplay",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Demopro.demopro.shared.demopro.model.organizationboundedcontext.contacts.CommunicationGroupModel"
                                        },
                                        "allowBlank": false,
                                        "fieldLabel": "Communication Group<font color='red'> *<\/font>",
                                        "fieldId": "21EFE220-048F-406B-A8D2-12E00210AC45",
                                        "restURL": "CommunicationGroup",
                                        "bindable": "communicationData.commGroupId",
                                        "columnWidth": 0.5,
                                        "listeners": {
                                             "change": "onCommGroupIdChange"
                                        }
                                   }, {
                                        "name": "commType",
                                        "itemId": "commType",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Communication Type",
                                        "margin": "5 5 5 5",
                                        "valueField": "primaryKey",
                                        "displayField": "primaryDisplay",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Demopro.demopro.shared.demopro.model.organizationboundedcontext.contacts.CommunicationTypeModel"
                                        },
                                        "allowBlank": false,
                                        "fieldLabel": "Communication Type<font color='red'> *<\/font>",
                                        "fieldId": "354D20E7-6624-4DCD-8330-61CD929E4277",
                                        "restURL": "CommunicationType",
                                        "bindable": "communicationData.commType",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "commData",
                                        "itemId": "commData",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Communication Data",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Communication Data<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "CA36D540-4E78-43FA-A55B-085CCD3FF043",
                                        "minLength": "10",
                                        "errorMessage": "please enter communication details",
                                        "bindable": "communicationData.commData",
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
                                        "fieldId": "F7A7B4DC-0885-4F2E-B3B2-78B8215D0B20",
                                        "bindable": "communicationData.versionId",
                                        "hidden": true
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 242,
                              "text": "Add CommunicationData",
                              "handler": "addCommunicationData"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "CommunicationData",
                              "columnWidth": 1,
                              "itemId": "CommunicationDataGrid",
                              "fieldLabel": "List",
                              "bindLevel": "communicationData",
                              "bindable": "communicationData",
                              "listeners": {
                                   "select": "onCommunicationDataGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "commType",
                                   "text": "commType",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "commDataId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "Communication Group",
                                   "text": "Communication Group",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "commGroupId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Communication Type",
                                   "text": "Communication Type",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "commType",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Communication Data",
                                   "text": "Communication Data",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "commData",
                                   "flex": 1
                              }, {
                                   "header": "createdBy",
                                   "text": "createdBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "createdDate",
                                   "text": "createdDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedBy",
                                   "text": "updatedBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedDate",
                                   "text": "updatedDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "versionId",
                                   "text": "versionId",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "versionId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "activeStatus",
                                   "text": "activeStatus",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "activeStatus",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "txnAccessCode",
                                   "text": "txnAccessCode",
                                   "customWidgetType": "vdGridColumn",
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
                                        "handler": "onDeleteActionColumnClick"
                                   }]
                              }]
                         }],
                         "customWidgetType": "vdCard"
                    }],
                    "tools": [{
                         "type": "help",
                         "tooltip": "Get Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "layout": "card",
                    "defaults": {
                         "autoScroll": true
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "margin": 0,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5"
                         }
                    }, {
                         "xtype": "toolbar",
                         "customWidgetType": "vdTBar",
                         "defaults": {
                              "margin": "0 5 0 5"
                         },
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardPrev",
                              "text": "&laquo; Previous",
                              "handler": "showPreviousCard",
                              "disabled": true,
                              "margin": "0 5 0 5"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardNext",
                              "text": "Next &raquo;",
                              "handler": "showNextCard",
                              "margin": "0 5 0 5"
                         }]
                    }],
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "Core Contacts",
                    "title": "Details Grid",
                    "name": "CoreContactsGrid",
                    "itemId": "CoreContactsGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "Contact Id",
                         "dataIndex": "contactId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Title",
                         "dataIndex": "titleId",
                         "flex": 1
                    }, {
                         "header": "First Name",
                         "dataIndex": "firstName",
                         "flex": 1
                    }, {
                         "header": "Middle Name",
                         "dataIndex": "middleName",
                         "flex": 1
                    }, {
                         "header": "Last Name",
                         "dataIndex": "lastName",
                         "flex": 1
                    }, {
                         "header": "Native Language Code",
                         "dataIndex": "nativeLanguageCode",
                         "flex": 1
                    }, {
                         "header": "Native Title",
                         "dataIndex": "nativeTitle",
                         "flex": 1
                    }, {
                         "header": "Native First Name",
                         "dataIndex": "nativeFirstName",
                         "flex": 1
                    }, {
                         "header": "Native Middle Name",
                         "dataIndex": "nativeMiddleName",
                         "flex": 1
                    }, {
                         "header": "Native LastName",
                         "dataIndex": "nativeLastName",
                         "flex": 1
                    }, {
                         "header": "Gender",
                         "dataIndex": "genderId",
                         "flex": 1
                    }, {
                         "header": "DOB",
                         "dataIndex": "dateofbirth",
                         "flex": 1
                    }, {
                         "header": "Age",
                         "dataIndex": "age",
                         "flex": 1
                    }, {
                         "header": "Approx DOB",
                         "dataIndex": "approximateDOB",
                         "flex": 1
                    }, {
                         "header": "Email ID",
                         "dataIndex": "emailId",
                         "flex": 1
                    }, {
                         "header": "Phone Number",
                         "dataIndex": "phoneNumber",
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
               "xtype": "form",
               "displayName": "Core Contacts",
               "name": "CoreContacts",
               "itemId": "CoreContactsForm",
               "bodyPadding": 10,
               "items": [{
                    "xtype": "form",
                    "itemId": "form0",
                    "customWidgetType": "vdCard",
                    "header": {
                         "hidden": true
                    },
                    "items": [{
                         "layout": "column",
                         "customWidgetType": "vdColumnLayout",
                         "header": {
                              "hidden": true
                         },
                         "xtype": "panel",
                         "items": [{
                              "name": "contactId",
                              "itemId": "contactId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Contact Id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Contact Id<font color='red'> *<\/font>",
                              "fieldId": "1F3A2EE5-F465-4838-9E1D-4A49294902D8",
                              "minLength": "0",
                              "maxLength": "64",
                              "hidden": true,
                              "value": "",
                              "bindable": "contactId"
                         }, {
                              "name": "titleId",
                              "itemId": "titleId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Title",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Demopro.demopro.shared.demopro.model.organizationboundedcontext.contacts.TitleModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Title<font color='red'> *<\/font>",
                              "fieldId": "5BAED388-AFF1-480C-B889-B8B9300F8F95",
                              "errorMessage": "Please enter title",
                              "restURL": "Title",
                              "bindable": "titleId",
                              "columnWidth": 0.5
                         }, {
                              "name": "firstName",
                              "itemId": "firstName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "First Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "First Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "E8A998B0-CC69-4908-8012-80A605EF3257",
                              "minLength": "0",
                              "maxLength": "256",
                              "errorMessage": "Please enter First Name",
                              "bindable": "firstName",
                              "columnWidth": 0.5
                         }, {
                              "name": "middleName",
                              "itemId": "middleName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Middle Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Middle Name",
                              "fieldId": "150CE7A6-6EEB-42A7-A310-29148403353B",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "middleName",
                              "columnWidth": 0.5
                         }, {
                              "name": "lastName",
                              "itemId": "lastName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Last Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Last Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "CE6DDDC1-8A52-4E44-8DA2-5C91781F21EB",
                              "minLength": "0",
                              "maxLength": "256",
                              "errorMessage": "Please enter Last Name",
                              "bindable": "lastName",
                              "columnWidth": 0.5
                         }, {
                              "name": "nativeLanguageCode",
                              "itemId": "nativeLanguageCode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Native Language Code",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Demopro.demopro.shared.demopro.model.organizationboundedcontext.location.LanguageModel"
                              },
                              "fieldLabel": "Native Language Code",
                              "fieldId": "21B03CCB-45AF-4E76-A73F-9C1620CE8F98",
                              "errorMessage": "Please enter gender",
                              "restURL": "Language",
                              "bindable": "nativeLanguageCode",
                              "columnWidth": 0.5
                         }, {
                              "name": "nativeTitle",
                              "itemId": "nativeTitle",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Native Title",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "fieldLabel": "Native Title",
                              "fieldId": "CD2AD0FA-E620-446A-ABF8-AEB78E2B4118",
                              "bindable": "nativeTitle",
                              "columnWidth": 0.5
                         }, {
                              "name": "nativeFirstName",
                              "itemId": "nativeFirstName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Native First Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Native First Name",
                              "fieldId": "57F08BB7-7B08-4224-81C1-BEA120FF8E55",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "nativeFirstName",
                              "columnWidth": 0.5
                         }, {
                              "name": "nativeMiddleName",
                              "itemId": "nativeMiddleName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Native Middle Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Native Middle Name",
                              "fieldId": "778C2F21-E65F-431F-9848-4F505A7DA6EC",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "nativeMiddleName",
                              "columnWidth": 0.5
                         }, {
                              "name": "nativeLastName",
                              "itemId": "nativeLastName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Native LastName",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Native LastName",
                              "fieldId": "A2891A04-CD95-4525-B563-5405651F3F13",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "nativeLastName",
                              "columnWidth": 0.5
                         }, {
                              "name": "genderId",
                              "itemId": "genderId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Gender",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Demopro.demopro.shared.demopro.model.organizationboundedcontext.contacts.GenderModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Gender<font color='red'> *<\/font>",
                              "fieldId": "2B045906-ED7F-49A9-823A-BCF7C9DBD103",
                              "errorMessage": "Please enter gender",
                              "restURL": "Gender",
                              "bindable": "genderId",
                              "columnWidth": 0.5
                         }, {
                              "name": "dateofbirth",
                              "itemId": "dateofbirth",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "DOB",
                              "margin": "5 5 5 5",
                              "format": "d-m-Y",
                              "submitFormat": "d-m-Y",
                              "fieldLabel": "DOB",
                              "fieldId": "49B7390F-E748-4454-A286-4FA99B402908",
                              "errorMessage": "Please enter Date of birth",
                              "bindable": "dateofbirth",
                              "columnWidth": 0.5
                         }, {
                              "name": "age",
                              "itemId": "age",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Age",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Age",
                              "fieldId": "9A5101CB-23E3-42C6-811D-AEFB4094A8AF",
                              "minValue": "0",
                              "maxValue": "125",
                              "bindable": "age",
                              "columnWidth": 0.5
                         }, {
                              "name": "approximateDOB",
                              "itemId": "approximateDOB",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "Approx DOB",
                              "margin": "5 5 5 5",
                              "format": "d-m-Y",
                              "submitFormat": "d-m-Y",
                              "fieldLabel": "Approx DOB",
                              "fieldId": "3B8C80EE-37C4-40D3-8EEC-C5ED2AE5777C",
                              "bindable": "approximateDOB",
                              "columnWidth": 0.5
                         }, {
                              "name": "emailId",
                              "itemId": "emailId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Email ID",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Email ID<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "5EE7646F-DAD8-4B1A-87A7-25F2D9ABE57A",
                              "minLength": "0",
                              "maxLength": "256",
                              "errorMessage": "Please enter Email ID",
                              "bindable": "emailId",
                              "columnWidth": 0.5
                         }, {
                              "name": "phoneNumber",
                              "itemId": "phoneNumber",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Phone Number",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Phone Number<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "F3CF4680-2991-4B6A-BB1E-11ADB21D671D",
                              "minLength": "0",
                              "maxLength": "20",
                              "errorMessage": "Please enter Phone Number",
                              "bindable": "phoneNumber",
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
                              "fieldId": "C3A95DFC-4046-4CC0-9E4C-ED1C2A004073",
                              "bindable": "versionId",
                              "hidden": true
                         }, {
                              "xtype": "combo",
                              "name": "Timezone",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "margin": 5,
                              "bindable": "timezone.timeZoneId",
                              "typeAhead": true,
                              "columnWidth": 0.5,
                              "queryMode": "local",
                              "minChars": 1,
                              "fieldLabel": "Timezone<font color='red'> *<\/font>",
                              "title": "Timezone",
                              "itemId": "timezone",
                              "store": {
                                   "data": [],
                                   "model": "Demopro.demopro.shared.demopro.model.organizationboundedcontext.location.TimezoneModel"
                              }
                         }]
                    }]
               }, {
                    "xtype": "form",
                    "displayName": "Address",
                    "title": "Address",
                    "name": "Address",
                    "itemId": "AddressForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form1",
                         "customWidgetType": "vdAnchorLayout",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "addressId",
                                   "itemId": "addressId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Address Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address Id<font color='red'> *<\/font>",
                                   "fieldId": "8988F5DD-B155-49BA-B07A-69F26A1265C7",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "address.addressId"
                              }, {
                                   "name": "addressTypeId",
                                   "itemId": "addressTypeId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Address Type",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Demopro.demopro.shared.demopro.model.organizationboundedcontext.location.AddressTypeModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Address Type<font color='red'> *<\/font>",
                                   "fieldId": "65E394AF-4D80-4386-9CF7-731F5BF0726F",
                                   "errorMessage": "Please enter valid Address type",
                                   "restURL": "AddressType",
                                   "bindable": "address.addressTypeId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "addressLabel",
                                   "itemId": "addressLabel",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Address Label",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address Label",
                                   "fieldId": "5BDD6E41-FD27-45E6-96A6-4AF4208BF366",
                                   "minLength": "0",
                                   "maxLength": "11",
                                   "bindable": "address.addressLabel",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "address1",
                                   "itemId": "address1",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Address1",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address1",
                                   "fieldId": "D78AE565-2332-4437-B05B-BD449E69DB79",
                                   "bindable": "address.address1",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "address2",
                                   "itemId": "address2",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Address2",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address2",
                                   "fieldId": "F005F2A1-1FE6-4DFB-9EFE-B3C9DFFC43D9",
                                   "bindable": "address.address2",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "address3",
                                   "itemId": "address3",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Address3",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address3",
                                   "fieldId": "AE1B3611-44FA-4B6B-94C5-84486394CE23",
                                   "bindable": "address.address3",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "countryId",
                                   "itemId": "countryId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Country",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Demopro.demopro.shared.demopro.model.organizationboundedcontext.location.CountryModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Country<font color='red'> *<\/font>",
                                   "fieldId": "041C6D28-D13B-4763-9219-68B8B826AC73",
                                   "errorMessage": "Please enter Country",
                                   "restURL": "Country",
                                   "bindable": "address.countryId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onCountryIdChange"
                                   }
                              }, {
                                   "name": "stateId",
                                   "itemId": "stateId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "State",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Demopro.demopro.shared.demopro.model.organizationboundedcontext.location.StateModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "State<font color='red'> *<\/font>",
                                   "fieldId": "F3E55A34-161B-4591-A5E4-890081F05A6E",
                                   "errorMessage": "Please enter State",
                                   "restURL": "State",
                                   "bindable": "address.stateId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onStateIdChange"
                                   }
                              }, {
                                   "name": "cityId",
                                   "itemId": "cityId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "City",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Demopro.demopro.shared.demopro.model.organizationboundedcontext.location.CityModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "City<font color='red'> *<\/font>",
                                   "fieldId": "088856BF-3BAB-49F0-9AF9-B63DBE345A4E",
                                   "errorMessage": "Please enter City",
                                   "restURL": "City",
                                   "bindable": "address.cityId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "zipcode",
                                   "itemId": "zipcode",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Postal Code",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Postal Code<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "D99C82FE-4337-4CE1-9281-3E6FEC9136C1",
                                   "minLength": "0",
                                   "maxLength": "6",
                                   "errorMessage": "Please enter postal code",
                                   "bindable": "address.zipcode",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "latitude",
                                   "itemId": "latitude",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Latitude",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Latitude",
                                   "fieldId": "4D3730E0-2A71-4703-A651-9EA51B38D640",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "address.latitude",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "longitude",
                                   "itemId": "longitude",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Longitude",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Longitude",
                                   "fieldId": "CC125136-1142-4DCE-AAE9-E21B4E301F89",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "address.longitude",
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
                                   "fieldId": "8D6118D5-F962-410A-8816-90CF7B796AF8",
                                   "bindable": "address.versionId",
                                   "hidden": true
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 132,
                         "text": "Add Address",
                         "handler": "addAddress"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "Address",
                         "columnWidth": 1,
                         "itemId": "AddressGrid",
                         "fieldLabel": "List",
                         "bindLevel": "address",
                         "bindable": "address",
                         "listeners": {
                              "select": "onAddressGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "Address Id",
                              "text": "Address Id",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "addressId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "Address Type",
                              "text": "Address Type",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "addressTypeId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Address Label",
                              "text": "Address Label",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "addressLabel",
                              "flex": 1
                         }, {
                              "header": "Address1",
                              "text": "Address1",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "address1",
                              "flex": 1
                         }, {
                              "header": "Address2",
                              "text": "Address2",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "address2",
                              "flex": 1
                         }, {
                              "header": "Address3",
                              "text": "Address3",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "address3",
                              "flex": 1
                         }, {
                              "header": "Country",
                              "text": "Country",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "countryId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "State",
                              "text": "State",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "stateId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "City",
                              "text": "City",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "cityId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Postal Code",
                              "text": "Postal Code",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "zipcode",
                              "flex": 1
                         }, {
                              "header": "Latitude",
                              "text": "Latitude",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "latitude",
                              "flex": 1
                         }, {
                              "header": "Longitude",
                              "text": "Longitude",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "longitude",
                              "flex": 1
                         }, {
                              "header": "createdBy",
                              "text": "createdBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "createdDate",
                              "text": "createdDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedBy",
                              "text": "updatedBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedDate",
                              "text": "updatedDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "versionId",
                              "text": "versionId",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "versionId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "activeStatus",
                              "text": "activeStatus",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "activeStatus",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "txnAccessCode",
                              "text": "txnAccessCode",
                              "customWidgetType": "vdGridColumn",
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
                                   "handler": "onDeleteActionColumnClick"
                              }]
                         }]
                    }],
                    "customWidgetType": "vdCard"
               }, {
                    "xtype": "form",
                    "displayName": "Communication Data",
                    "title": "Communication Data",
                    "name": "CommunicationData",
                    "itemId": "CommunicationDataForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form1",
                         "customWidgetType": "vdAnchorLayout",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "commDataId",
                                   "itemId": "commDataId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "commType",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "commType<font color='red'> *<\/font>",
                                   "fieldId": "BF4C98DA-9EE3-4454-9D85-810C75033889",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "communicationData.commDataId"
                              }, {
                                   "name": "commGroupId",
                                   "itemId": "commGroupId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Communication Group",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Demopro.demopro.shared.demopro.model.organizationboundedcontext.contacts.CommunicationGroupModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Communication Group<font color='red'> *<\/font>",
                                   "fieldId": "21EFE220-048F-406B-A8D2-12E00210AC45",
                                   "restURL": "CommunicationGroup",
                                   "bindable": "communicationData.commGroupId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onCommGroupIdChange"
                                   }
                              }, {
                                   "name": "commType",
                                   "itemId": "commType",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Communication Type",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Demopro.demopro.shared.demopro.model.organizationboundedcontext.contacts.CommunicationTypeModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Communication Type<font color='red'> *<\/font>",
                                   "fieldId": "354D20E7-6624-4DCD-8330-61CD929E4277",
                                   "restURL": "CommunicationType",
                                   "bindable": "communicationData.commType",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "commData",
                                   "itemId": "commData",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Communication Data",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Communication Data<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "CA36D540-4E78-43FA-A55B-085CCD3FF043",
                                   "minLength": "10",
                                   "errorMessage": "please enter communication details",
                                   "bindable": "communicationData.commData",
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
                                   "fieldId": "F7A7B4DC-0885-4F2E-B3B2-78B8215D0B20",
                                   "bindable": "communicationData.versionId",
                                   "hidden": true
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 242,
                         "text": "Add CommunicationData",
                         "handler": "addCommunicationData"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "CommunicationData",
                         "columnWidth": 1,
                         "itemId": "CommunicationDataGrid",
                         "fieldLabel": "List",
                         "bindLevel": "communicationData",
                         "bindable": "communicationData",
                         "listeners": {
                              "select": "onCommunicationDataGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "commType",
                              "text": "commType",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "commDataId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "Communication Group",
                              "text": "Communication Group",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "commGroupId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Communication Type",
                              "text": "Communication Type",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "commType",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Communication Data",
                              "text": "Communication Data",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "commData",
                              "flex": 1
                         }, {
                              "header": "createdBy",
                              "text": "createdBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "createdDate",
                              "text": "createdDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedBy",
                              "text": "updatedBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedDate",
                              "text": "updatedDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "versionId",
                              "text": "versionId",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "versionId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "activeStatus",
                              "text": "activeStatus",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "activeStatus",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "txnAccessCode",
                              "text": "txnAccessCode",
                              "customWidgetType": "vdGridColumn",
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
                                   "handler": "onDeleteActionColumnClick"
                              }]
                         }]
                    }],
                    "customWidgetType": "vdCard"
               }],
               "tools": [{
                    "type": "help",
                    "tooltip": "Get Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "layout": "card",
               "defaults": {
                    "autoScroll": true
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "margin": 0,
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {
                         "margin": "0 5 0 5"
                    }
               }, {
                    "xtype": "toolbar",
                    "customWidgetType": "vdTBar",
                    "defaults": {
                         "margin": "0 5 0 5"
                    },
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardPrev",
                         "text": "&laquo; Previous",
                         "handler": "showPreviousCard",
                         "disabled": true,
                         "margin": "0 5 0 5"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardNext",
                         "text": "Next &raquo;",
                         "handler": "showNextCard",
                         "margin": "0 5 0 5"
                    }]
               }],
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});