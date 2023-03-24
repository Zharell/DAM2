var platform = new H.service.Platform({
    'apikey': '5vqjNFPriIDscQ4YdUQgnu3OM7rYQnLE82mzbmGkF9Q'
  });
  
  
  var defaultLayers = platform.createDefaultLayers();
  
  
  var map = new H.Map(
    document.getElementById('mapContainer'),
    defaultLayers.vector.normal.map,
    {
      zoom: 14,
      center: { lat: 52.5, lng: 13.4 }
    });
  
 
  var defaultLayers = platform.createDefaultLayers();
  
  var geocodingParams;
  
  var onResult = function (result) {
    var locations = result.Response.View[0].Result,
      position,
      marker;
 
  };
  
 
  var geocoder = platform.getGeocodingService();
