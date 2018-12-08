$(function() {

  // page is now ready, initialize the calendar...

  $('#calendar').fullCalendar({
	  events: [
		    {
		      title  : 'event1',
		      start  : '2018-12-04T12:30:00',
		      end	 : '2018-12-04T14:00:00',
		      editable: true,
		      startRecur: start,
		    },
		  ],
	  
	  
    // put your options and callbacks here
		  	eventColor: '#378006',
	  		weekends: false,
	  		defaultView: 'agendaWeek',
	  		minTime: "08:00:00",
	  		maxTime: "22:00:00",
	  		height: "auto",
	  		columnHeader: true,
	  		columnHeaderFormat: 'ddd',
	  		nowIndicator: false,
	  		header: {
	  			left: 'prev',
	  			center: '',
	  			right: 'next',
	  		},
	  		editable: false,
  })

});