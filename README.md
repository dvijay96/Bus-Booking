# Bus-Booking
Demo project on bus booking

### JSON Bodies

#ADMIN user_add

{
	"firstName":"",
	"lastName":"",
	"DOB":"",
	"gender":"",
	"username":"",
	"password":"",
	"role":{
		"role":"",
		}
}

#CUSTOMER register

{
	"firstName":"",
	"lastName":"",
	"DOB":"",
	"gender":"",
	"username":"",
	"password":""
}

#BUS ADD |/\/\/\| UPDATE for name,date, times , fare, seats

{
	 "type": "",
     "name": "",
     "available_Seats": 0,
     "arrivalTime": "",
     "departureTime": "",
     "fare": 700,
     "date": ""
}

#BUS_ROUTE Addition

{
	"origin":"",
	"destination":"",
	"busId":""
}


#ROUTE Add /\\/\ Update ( "routeId": )

{
	"originCity":"",
	"destinationCity:"",
	"distance":""
}