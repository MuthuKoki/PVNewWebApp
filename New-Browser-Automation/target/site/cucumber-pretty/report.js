$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("bin/Jurisdiction_LibraryFilter.feature");
formatter.feature({
  "line": 2,
  "name": "JusrisdictionLibraryFilter",
  "description": "",
  "id": "jusrisdictionlibraryfilter",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Ram"
    }
  ]
});
formatter.before({
  "duration": 244500,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Verify the UI of Jusrisdiction Library Filter",
  "description": "",
  "id": "jusrisdictionlibraryfilter;verify-the-ui-of-jusrisdiction-library-filter",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "We launch and login to the Application",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I Verify the \"Jurisdiction\" option display on Home page of Proview filter and sort",
  "keyword": "Then "
});
formatter.match({
  "location": "Jurisdiction_LibraryFilter_and_Sort.we_launch_and_login_to_the_Application()"
});
formatter.result({
  "duration": 14938579300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Jurisdiction",
      "offset": 14
    }
  ],
  "location": "Jurisdiction_LibraryFilter_and_Sort.i_Verify_the_option_display_on_Home_page_of_Proview_filter_and_sort(String)"
});
formatter.result({
  "duration": 3162201,
  "status": "passed"
});
formatter.after({
  "duration": 762622800,
  "status": "passed"
});
});