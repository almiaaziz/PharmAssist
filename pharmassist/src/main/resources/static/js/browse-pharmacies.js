// Spinner
let spinner = function () {
  setTimeout(function () {
      if ($('#spinner').length > 0) {
          $('#spinner').removeClass('show');
      }
  }, 1);
};
spinner();


let map = L.map('map').setView([37.267206, 9.880512], 15);
L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {}).addTo(map);

let drawnItems = new L.FeatureGroup();
map.addLayer(drawnItems);

let drawControl = new L.Control.Draw({
  draw: {
    polyline: false,
    circle: false,
    marker: false,
    polygon: false,
    rectangle: false,
    circlemarker: false,
  },
});
map.addControl(drawControl);

let marker;

function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
    } else {
        document.getElementById("location").value = "Geolocation is not supported by this browser.";
    }
}

function showPosition(position) {
    let location = [position.coords.latitude, position.coords.longitude];
    document.getElementById("location").value = location;

    if (marker) {
        map.removeLayer(marker);
    }

    marker = L.marker(location).addTo(map);
    marker.bindPopup("<b>Hello!</b><br>You are here").openPopup();
    map.setView(location, 15);
}