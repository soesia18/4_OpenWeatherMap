function getWeather() {
    let city = document.getElementById('city').value;
    let lang = document.getElementById('lang').value;
    fetch('./api/weather/current/' + city + '?lang=' + lang)
        .then(result => {
            if (result.status !== 200) {
                alert(result.statusText + " - " + result.status);
            }
            result.json().then(data => {
                console.log(data);

                let currentWeather = document.getElementById("currentWeather");

                let table = '';
                let tempColor;

                if (data.temperature.value < 0) {
                    tempColor = 'blue';
                } else {
                    tempColor = 'red';
                }

                table = '<tr style="border-bottom: solid black 2px;">';
                if (lang === 'en') {
                    table += '<th>City</th>';
                    table += '<th>Humidity</th>';
                    table += '<th>Pressure</th>';
                    table += '<th>Temperature</th>';
                    table += '<th>Wind</th>';
                    table += '<th>Clouds</th>';
                    table += '<th>Icon</th>';
                } else {
                    table += '<th>Stadt</th>';
                    table += '<th>Feuchtigkeit</th>';
                    table += '<th>Druck</th>';
                    table += '<th>Temperatur</th>';
                    table += '<th>Wind</th>';
                    table += '<th>Wolken</th>';
                    table += '<th>Icon</th>';
                }
                table += '</tr>';
                table += '<tr>';
                table += '<td>' + data.city.name + ' ' + data.city.country + '</td>';
                table += '<td>' + data.humidity.value + ' ' + data.humidity.unit + '</td>';
                table += '<td>' + data.pressure.value + ' ' + data.pressure.unit + '</td>';
                table += '<td style="color:  ' + tempColor + '">' + data.temperature.value + ' ' + data.temperature.unit + '</td>';
                table += '<td>' + data.wind.speed.value + ' ' + data.wind.speed.unit + '</td>';
                table += '<td>' + data.clouds.name + '</td>';
                table += '<td><img src="' + getIconPath(data.clouds.name) + '"></td>';
                table += '</tr>';

                currentWeather.innerHTML = table;
            })
        })
    fetch('./api/weather/forecast/' + city + '?lang=' + lang)
        .then(result => {
            result.json().then(data => {
                console.log(data);
                let forecastWeather = document.getElementById("forecastWeather");
                let forecast;
                if (lang === 'en') {
                    forecast = '<hr><table><tr>' +
                        '<th>Time</th>' +
                        '<th>Humidity</th>' +
                        '<th>Pressure</th>' +
                        '<th>Temperature</th>' +
                        '<th>Wind</th>' +
                        '<th>Cloud</th>' +
                        '<th>Icon</th>' +
                        '</tr>';
                } else {
                    forecast = '<hr><table><tr>' +
                        '<th>Zeit</th>' +
                        '<th>Feuchtigkeit</th>' +
                        '<th>Druck</th>' +
                        '<th>Temperatur</th>' +
                        '<th>Wind</th>' +
                        '<th>Wolken</th>' +
                        '<th>Icon</th>' +
                        '</tr>';
                }
                data.forecast.time.forEach(weather => {
                    let tempColor;
                    if (weather.temperature.value < 0) {
                        tempColor = 'blue';
                    } else {
                        tempColor = 'red';
                    }
                    forecast += '<tr>' +
                        '<td>' + weather.from + '</td>' +
                        '<td>' + weather.humidity.value + ' ' + weather.humidity.unit + '</td>' +
                        '<td>' + weather.pressure.value + ' ' + weather.pressure.unit + '</td>' +
                        '<td style="color: ' + tempColor + '">' + weather.temperature.value + ' ' + weather.temperature.unit + '</td>' +
                        '<td>' + weather.windSpeed.mps + ' ' + weather.windSpeed.unit + '</td>' +
                        '<td>' + weather.clouds.value + '</td>' +
                        '<td><img src="' + getIconPath(weather.clouds.value) + '"></td>' +
                        '</tr>';
                });
                forecast += '</table>';
                forecastWeather.innerHTML = forecast;
            })
        })
}

function getIconPath(cloudValue) {
    switch (cloudValue) {
        case 'clear sky':
            return "./icon/03d@2x.png";
        case 'Klarer Himmel':
            return "./icon/03d@2x.png";
        case 'few clouds':
            return "./icon/02d@2x.png";
        case 'Ein paar Wolken':
            return "./icon/02d@2x.png";
        case 'scattered clouds':
            return "./icon/03d@2x.png";
        case 'Mäßig bewölkt':
            return "./icon/03d@2x.png";
        case 'broken clouds':
            return "./icon/04d@2x.png";
        case 'Überwiegend bewölkt':
            return "./icon/04d@2x.png";
        case 'overcast clouds':
            return "./icon/04d@2x.png";
        case 'Bedeckt':
            return "./icon/04d@2x.png";

    }
}