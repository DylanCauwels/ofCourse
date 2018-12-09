$(function() {

  // page is now ready, initialize the calendar...

  $('#calendar').fullCalendar({
    defaultDate: "2018-01-01",
	  events: [
		    {
		      title  : 'event1',
		      start  : '2018-01-01T12:30:00',
		      end	 : '2018-01-01T14:00:00'
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
        titleFormat: '',
	  		header: {
	  			left: '',
	  			center: '',
	  			right: '',
	  		},
  })

});
