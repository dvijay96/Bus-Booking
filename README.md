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
     "availableSeats": 0,
     "arrivalTime": "",
     "departureTime": "",
     "fare": 700,
     "date": ""
}

#BUS Search

{
	"origin":"",
	"destination:"",
	"date":""
}


#ROUTE Add /\\/\ Update ( "routeId": )

{
	"originCity":"",
	"destinationCity:"",
	"distance":""
}