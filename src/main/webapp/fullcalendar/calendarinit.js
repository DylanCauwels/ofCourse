$(function() {

  // page is now ready, initialize the calendar...

  $('#calendar').fullCalendar({
    defaultDate: "2018-01-01",

    /*events: {
    url: '/myfeed.php',
    data: function() { // a function that returns an object
      return {
        dynamic_value: Math.random()
      };
    }
  },*/

    events: '/myfeed.txt',

	  events: [
		    {
		      title : 'Test Event',
		      start : '2018-01-01T12:30:00',
		      end	: '2018-01-01T14:00:00'
		    }


		  ],


    // put your options and callbacks here
	  		weekends: false,
	  		defaultView: 'agendaWeek',
	  		minTime: "08:00:00",
	  		maxTime: "22:00:00",
	  		height: "auto",
	  		columnHeader: true,
	  		columnHeaderFormat: 'dddd',
	  		nowIndicator: false,
        titleFormat: 'MMM D YYYY',
	  		header: {
	  			left: '',
	  			center: '',
	  			right: '',
	  		},
  })

    //var text = '{ "events" : [' + '{ "title":"John" , "start":"2018-01-02T12:30:00", "end":"2018-01-02T14:00:00" }]}';
    /*var text = '{ "events" : [' +
'{ "title":"Test" , "start":"2018-01-02T12:30:00", "end":"2018-01-02T14:00:00" },' +
'{ "title":"John" , "start":"2018-01-03T12:30:00", "end":"2018-01-03T14:00:00" }]}';*/

var filePath = 'schedule_events/1.txt';
var xmlhttp = new XMLHttpRequest();
xmlhttp.open("GET",filePath,false);
xmlhttp.send(null);
var fileContent = xmlhttp.responseText;

    var obj = JSON.parse(fileContent);

    for(var i = 0; i < obj.events.length; i++) {
      var testEvent = {
        title  : obj.events[i].title,
        start  : obj.events[i].start,
        end	 : obj.events[i].end
      }

      $('#calendar').fullCalendar('renderEvent', testEvent, true);
    }

    //document.getElementById("testOutput").innerHTML = obj.events[1].title + " " + obj.events[1].title;

});
