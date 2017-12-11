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
			var largeInfowindow = new google.maps.InfoWindow();
			var defaultIcon = makeMarkerIcon('0091ff');
			
			var highlightedIcon = makeMarkerIcon('FFFF24');
			
	var geocoder = new google.maps.Geocoder();
	
		geocoder
				.geocode(
						{
							'address' : address,
							componentRestrictions : {
								
							}
						},
						function(results, status) {
							if (status == google.maps.GeocoderStatus.OK) {
								
							myCenter = results[0].geometry.location;
								
							var position = myCenter;
										console.log(position);
										console.log(position.lat);
								var marker = new google.maps.Marker({
									position : position,
									name : name,
									animation : google.maps.Animation.DROP,
									icon : defaultIcon,
								});
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
		marker.setMap(map);
		bounds.extend(marker.position);
	marker.addListener('mouseover', function() {
		document.getElementById('map2').height =  "200%";
		populateInfoWindow(this, largeInfowindow);
	});
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
		if (infowindow.marker != marker) {
			infowindow.setContent('');
			infowindow.marker = marker;
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