$(document).ready(function() {
    let response = fetch("http://localhost:8080/api/movies/"+localStorage.getItem('movieId'), {
        method: 'GET',
        headers: {
            'Content-type': 'application/json',
        }
    }).then(response => {
        if (!response.ok) {
            throw new Error(`Request failed with status ${reponse.status}`)
        }
        response.json()
            .then((movie) => {
                console.log(movie);
                document.getElementById('mvi_title').innerHTML += movie.title;
                document.getElementById('rental_period').innerHTML += movie.startDate + " - "+movie.endDate;
                document.getElementById('minAge').innerHTML += movie.minAge + "+";
                document.getElementById('year').innerHTML += movie.year;
                document.getElementById('director').innerHTML += movie.director.firstName + " " + movie.director.lastName;
                document.getElementById('language').innerHTML += movie.language;
                document.getElementById('duration').innerHTML += movie.duration;
                document.getElementById('description').innerHTML += movie.description;
                document.getElementById('genre').innerHTML += movie.categories;
                document.getElementById('actors').innerHTML += movie.actorsInitials;
                document.getElementById('image').src = movie.imageUrl;
            });
    });
})