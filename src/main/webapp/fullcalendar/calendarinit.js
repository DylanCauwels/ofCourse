$(function() {

  // page is now ready, initialize the calendar...

  $('#calendar').fullCalendar({
	  events: [
		    {
		      title  : 'event1',
		      start  : '2018-11-27T12:30:00',
		      end	 : '2018-11-27T14:00:00'
		    },
		    
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
	  		header: {
	  			left: '',
	  			center: '',
	  			right: '',
	  		},
  })

});