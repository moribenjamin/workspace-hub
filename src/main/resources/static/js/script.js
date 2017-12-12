var spaceTypeImages = document.querySelectorAll('.spacetype-image img');
const mq = window.matchMedia("(min-width: 1200px)");

if(mq.matches){
for (var i = 0; i < spaceTypeImages.length; i++) {
	spaceTypeImages[i].addEventListener('mouseover', function() {
		this.style.height = '350px';
		this.style.width = '450px';
	});
	spaceTypeImages[i].addEventListener('mouseout', function() {
		this.style.height = '300px';
		this.style.width = '400px';
	});
}
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
					});
	google.maps.event.addDomListener(window, 'load', initMap);
	console.log(name);
	console.log(address);
function populateInfoWindow(marker, infowindow) {
	if (infowindow.marker != marker) {
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
          streetViewService.getPanoramaByLocation(marker.position, radius, getStreetView);
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
	for (var i = 0; i < markers.length; i++) {
		markers[i].setMap(map);
		bounds.extend(markers[i].position);
		markers[i].url = `location?id=${i+1}`
		markers[i].title  = data[i].name;
	}
	map.fitBounds(bounds)
}
function hideListings() {
	for (var i = 0; i < markers.length; i++) {
		markers[i].setMap(null);
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
