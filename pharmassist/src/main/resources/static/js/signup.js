(function ($) {
    "use strict";

    // Spinner
    let spinner = function () {
        setTimeout(function () {
            if ($('#spinner').length > 0) {
                $('#spinner').removeClass('show');
            }
        }, 1);
    };
    spinner();
})(jQuery);

//Leaflet map
let map = L.map('map').setView([37.267206, 9.880512], 15);
L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {}).addTo(map);

let drawnItems = new L.FeatureGroup();
map.addLayer(drawnItems);

let drawControl = new L.Control.Draw({
  draw: {
    polyline: false,
    circle: false,
    marker: true,
    polygon: false,
    rectangle: false,
    circlemarker: false,
  },
});
map.addControl(drawControl);

let lastMarker = null;
map.on('draw:created', function (e) {
  if (lastMarker !== null) {
    map.removeLayer(lastMarker);
  }
  drawnItems.clearLayers();
  let layer = e.layer;
  drawnItems.addLayer(layer);
  let markerPosition = layer.getLatLng();
  let lat = markerPosition.lat;
  let lng = markerPosition.lng;
  document.getElementById("lat").value = lat;
  document.getElementById("lng").value = lng;
  console.log(lat, lng);
  lastMarker = L.marker([lat, lng]).addTo(map);
});
