//Leaflet map
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

let pharmacies = /*[[${pharmacies}]]*/ [];

        pharmacies.forEach(pharmacy => {
            L.marker([pharmacy.latitude, pharmacy.longitude]).addTo(map)
                .bindPopup('<b>' + pharmacy.name + '</b><br>Latitude: ' + pharmacy.latitude + '<br>Longitude: ' + pharmacy.longitude)
                .openPopup();
        });
