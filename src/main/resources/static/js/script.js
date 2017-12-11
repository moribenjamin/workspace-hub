var spaceTypeImages = document.querySelectorAll('.spacetype-image img');

for (var i = 0; i < spaceTypeImages.length; i++) {
	spaceTypeImages[i].addEventListener('mouseover', function() {
		this.style.height = '300px';
		this.style.width = '400px';
	});
	spaceTypeImages[i].addEventListener('mouseout', function() {
		this.style.height = '200px';
		this.style.width = '330px';
	});
}

window.onscroll = function(){
	myFunction()
};

var navbar = document.querySelector("nav");
var sticky = navbar.offsetTop;

function myFunction(){
	if (window.pageYOffset >= sticky) {
		navbar.classList.add("sticky")
	}else{
		navbar.classList.remove("sticky");
	}
}

<<<<<<< Updated upstream
var myCenter;
function initMap() {
		// Create a styles array to use with the map.

=======
var map;

var markers = [];

var polygon = null;
var locations = [];
function store_locations(lat, lng) {
}
var address;
var name;
var idW;

var myCenter;
function initMap() {
		
>>>>>>> Stashed changes
		var styles = [ {
			featureType : 'water',
			stylers : [ {
				color : '#19a0d8'
			} ]
		}, {
			featureType : 'administrative',
			elementType : 'labels.text.stroke',
			stylers : [ {
				color : '#ffffff'
			}, {
				weight : 6
			} ]
		}, {
			featureType : 'administrative',
			elementType : 'labels.text.fill',
			stylers : [ {
				color : '#e85113'
			} ]
		}, {
			featureType : 'road.highway',
			elementType : 'geometry.stroke',
			stylers : [ {
				color : '#efe9e4'
			}, {
				lightness : -40
			} ]
		}, {
			featureType : 'transit.station',
			stylers : [ {
				weight : 9
			}, {
				hue : '#e85113'
			} ]
		}, {
			featureType : 'road.highway',
			elementType : 'labels.icon',
			stylers : [ {
				visibility : 'off'
			} ]
		}, {
			featureType : 'water',
			elementType : 'labels.text.stroke',
			stylers : [ {
				lightness : 100
			} ]
		}, {
			featureType : 'water',
			elementType : 'labels.text.fill',
			stylers : [ {
				lightness : -100
			} ]
		}, {
			featureType : 'poi',
			elementType : 'geometry',
			stylers : [ {
				visibility : 'on'
			}, {
				color : '#f0e4d3'
			} ]
		}, {
			featureType : 'road.highway',
			elementType : 'geometry.fill',
			stylers : [ {
				color : '#efe9e4'
			}, {
				lightness : -25
			} ]
		} ];
<<<<<<< Updated upstream

		var largeInfowindow = new google.maps.InfoWindow();

		// Style the markers a bit. This will be our listing marker icon.
		var defaultIcon = makeMarkerIcon('0091ff');

		var highlightedIcon = makeMarkerIcon('FFFF24');
		
		
		var geocoder = new google.maps.Geocoder();
		// Get the address or place that the user entered.

			geocoder
					.geocode(
							{
								'address' : address,
								componentRestrictions : {
									/* locality : 'Columbus' */
								}
							},
							function(results, status) {

								if (status == google.maps.GeocoderStatus.OK) {
									/* locations.push(results[0].geometry.location); */
								myCenter = results[0].geometry.location;

									/* var mapProp = {
											center: myCenter,
											zoom: 5,
											mapTypeId: google.maps.MapTypeId.ROADMAP
											}; */
								var position = myCenter;
											console.log(position);
											console.log(position.lat);

									// Create a marker per location, and put into markers array.
									var marker = new google.maps.Marker({
										position : position,
										name : name,
										animation : google.maps.Animation.DROP,
										icon : defaultIcon,
									
										/* id: i */

									});

							 		/* markers.push(marker); */
							 		map = new google.maps.Map(document.getElementById('map2'), {
					center : {
						lat : 39.9612,
						lng : -82.9988
					},
					zoom : 8,
					styles : styles,
					mapTypeControl : false
				});
							 		var bounds = new google.maps.LatLngBounds();
		// Extend the boundaries of the map for each marker and display the marker
							 		marker.setMap(map);
									bounds.extend(marker.position);

								marker.addListener('mouseover', function() {
									document.getElementById('map2').height =  "200%";
									populateInfoWindow(this, largeInfowindow);
								});
								// Two event listeners - one for mouseover, one for mouseout,
								// to change the colors back and forth.
								marker.addListener('mouseover', function() {
									this.setIcon(highlightedIcon);
								});
								marker.addListener('mouseout', function() {
									this.setIcon(defaultIcon);
								});
								
														}
													});
														
									google.maps.event.addDomListener(window, 'load', initMap);
								


								function populateInfoWindow(marker, infowindow) {
									// Check to make sure the infowindow is not already opened on this marker.
									if (infowindow.marker != marker) {
										// Clear the infowindow content to give the streetview time to load.
										infowindow.setContent('');
										infowindow.marker = marker;
										// Make sure the marker property is cleared if the infowindow is closed.
										infowindow.addListener('closeclick', function() {
											infowindow.marker = null;
											document.getElementById('map2').height =  "100%";
										});
										var streetViewService = new google.maps.StreetViewService();
										var radius = 50;
										
										function getStreetView(data, status) {
								            if (status == google.maps.StreetViewStatus.OK) {
								              var nearStreetViewLocation = data.location.latLng;
								              var heading = google.maps.geometry.spherical.computeHeading(
								                nearStreetViewLocation, marker.position);
								                infowindow.setContent('<div>' + marker.name + '</div><div id="pano"></div>');
								                var panoramaOptions = {
								                  position: nearStreetViewLocation,
								                  pov: {
								                    heading: heading,
								                    pitch: 30
								                  }
								                };
								              var panorama = new google.maps.StreetViewPanorama(
								                document.getElementById('pano'), panoramaOptions);
								            } else {
								              infowindow.setContent('<div>' + marker.name + '</div>' +
								                '<div>No Street View Found</div>');
								            }
								          }
								    
								          streetViewService.getPanoramaByLocation(marker.position, radius, getStreetView);
								      
							          infowindow.open(map, marker);
								        }
								      }
								}

								
								function makeMarkerIcon(markerColor) {
									var markerImage = new google.maps.MarkerImage(
											'http://chart.googleapis.com/chart?chst=d_map_spin&chld=1.15|0|'
													+ markerColor + '|40|_|%E2%80%A2', new google.maps.Size(21,
													34), new google.maps.Point(0, 0), new google.maps.Point(10,
													34), new google.maps.Size(21, 34));
									return markerImage;
								}					 		
							 		
=======
		
		map = new google.maps.Map(document.getElementById('map'), {
			center : {
				lat : 39.9612,
				lng : -82.9988
			},
			zoom : 13,
			styles : styles,
			mapTypeControl : false
		});
		var largeInfowindow = new google.maps.InfoWindow();
		
		var defaultIcon = makeMarkerIcon('0091ff');
		
		var highlightedIcon = makeMarkerIcon('FFFF24');
		
var geocoder = new google.maps.Geocoder();

for (var i =0; i<data.length; i++) {
	address = data[i].address;
	name = data[i].name;
	idW = data[i].id;
	console.log(idW);

	geocoder
			.geocode(
					{
						'address' : address,
						componentRestrictions : {
							locality : 'Columbus'
						}
					},
					function(results, status) {
						if (status == google.maps.GeocoderStatus.OK) {
							locations.push(results[0].geometry.location);
						myCenter = results[0].geometry.location;
							
						var position = myCenter;
							// Create a marker per location, and put into markers array.
							var marker = new google.maps.Marker({
								position : position,
								name : name,
								animation : google.maps.Animation.DROP,
								icon : defaultIcon,
								url : `location?id=${idW} `,
								id: i
							});
					 		markers.push(marker);
marker.addListener('mouseover', function() {
	populateInfoWindow(this, largeInfowindow);
});
// Two event listeners - one for mouseover, one for mouseout,
// to change the colors back and forth.
marker.addListener('mouseover', function() {
	this.setIcon(highlightedIcon);
});
marker.addListener('mouseout', function() {
	this.setIcon(defaultIcon);
});
 google.maps.event.addListener(marker, 'click', function() {
        window.location.href = marker.url;
    });
					 		console.log(markers.length);
					 		console.log(locations);
						}
						 /*  else {
								 	alert('Geocode was not successful for the following reason: ' + status);
						}  */
					});
	google.maps.event.addDomListener(window, 'load', initMap);
	
function populateInfoWindow(marker, infowindow) {
	// Check to make sure the infowindow is not already opened on this marker.
	if (infowindow.marker != marker) {
		// Clear the infowindow content to give the streetview time to load.
		infowindow.setContent('');
		infowindow.marker = marker;
		
		infowindow.addListener('closeclick', function() {
			infowindow.marker = null;
		});
		var streetViewService = new google.maps.StreetViewService();
		var radius = 50;
		
		function getStreetView(data, status) {
            if (status == google.maps.StreetViewStatus.OK) {
              var nearStreetViewLocation = data.location.latLng;
              var heading = google.maps.geometry.spherical.computeHeading(
                nearStreetViewLocation, marker.position);
                infowindow.setContent('<div>' + marker.title + '</div><div id="pano"></div>');
                var panoramaOptions = {
                  position: nearStreetViewLocation,
                  pov: {
                    heading: heading,
                    pitch: 30
                  }
                };
              var panorama = new google.maps.StreetViewPanorama(
                document.getElementById('pano'), panoramaOptions);
            } else {
              infowindow.setContent('<div>' + marker.title + '</div>' +
                '<div>No Street View Found</div>');
            }
          }
          // Use streetview service to get the closest streetview image within
          // 50 meters of the markers position
          streetViewService.getPanoramaByLocation(marker.position, radius, getStreetView);
          // Open the infowindow on the correct marker.
          infowindow.open(map, marker);
        }
      }
}
}
document.getElementById('show-listings').addEventListener('click',
	showListings);
document.getElementById('hide-listings').addEventListener('click',
hideListings);

function showListings() {
	var bounds = new google.maps.LatLngBounds();
	// Extend the boundaries of the map for each marker and display the marker
	for (var i = 0; i < markers.length; i++) {
		markers[i].setMap(map);
		bounds.extend(markers[i].position);
		markers[i].url = `location?id=${i+1}`
		markers[i].title  = data[i].name;
	}
	map.fitBounds(bounds)
}
// This function will loop through the listings and hide them all.
function hideListings() {
	for (var i = 0; i < markers.length; i++) {
		markers[i].setMap(null);
	}
}
// This function takes in a COLOR, and then creates a new marker
// icon of that color. The icon will be 21 px wide by 34 high, have an origin
// of 0, 0 and be anchored at 10, 34).
function makeMarkerIcon(markerColor) {
	var markerImage = new google.maps.MarkerImage(
			'http://chart.googleapis.com/chart?chst=d_map_spin&chld=1.15|0|'
					+ markerColor + '|40|_|%E2%80%A2', new google.maps.Size(21,
					34), new google.maps.Point(0, 0), new google.maps.Point(10,
					34), new google.maps.Size(21, 34));
	return markerImage;
}
>>>>>>> Stashed changes
