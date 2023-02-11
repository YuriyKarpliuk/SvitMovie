
function getMovieDescription(id) {
    localStorage.setItem('movieId', id);
    window.location = "description.html";
}

function getMoviesByCategoryName(categoryName) {
    $('ul.pagination').empty();
    fetchMovies(0, "http://localhost:8080/api/movies/all/categoryName/" + categoryName);

}


function fetchMovies(startPage, urlLink) {

    console.log('startPage: ' + startPage);

    localStorage.setItem('currentUrl',urlLink);
    $.ajax({
        type: "GET",
        url: urlLink,
        data: {
            page: startPage,
            size: 4
        },
        success: function (response) {
            $('.movies-container').empty();
            $.each(response.content, (i, movie) => {
                const newElement0 = document.createElement('li');
                newElement0.style.width = "100%";
                newElement0.innerHTML =
                    `    	  <div class="card" >
				<div class="content">

				  <div class="new">
                        <a href="javascript:getMovieDescription(Number(${movie.id})) "><img src="${movie.imageUrl}"></></a>

				  </div>



				<div class="title"> <a href="javascript:getMovieDescription(Number(${movie.id})) ">${movie.title}</a></div>

				<div class="text">
					<p class="alignleft">${movie.year}</p>
  <p class="alignright"> ${movie.duration}</p>

				</div>
				 </div>


			  </div>`;
                $('.movies-container').append(newElement0);
            });


            if ($('ul.pagination li').length - 2 != response.totalPages) {
                // build pagination list at the first time loading
                $('ul.pagination').empty();
                buildPagination(response);
            }

        },
        error: function (e) {
            alert("ERROR: ", e);
            console.log("ERROR: ", e);
        }
    });
}

function buildPagination(response) {
    totalPages = response.totalPages;
    var pageNumber = response.pageable.pageNumber;




    if (totalPages > 1) {
        var numLinks = totalPages - 1;

    } else {
        var numLinks = totalPages;

    }

    // print 'previous' link only if not on page one
    var first = '';
    var prev = '';
    if (pageNumber > 0) {
        if (pageNumber !== 0) {

            first = '<li class="page-item"><a class="page-link">« First</a></li>';
        }
        prev = '<li class="page-item"><a class="page-link">‹ Prev</a></li>';
    } else {

        prev = ''; // on the page one, don't show 'previous' link
        first = ''; // nor 'first page' link
    }

    // print 'next' link only if not on the last page
    var next = '';
    var last = '';
    if (pageNumber < totalPages) {
        if (pageNumber !== totalPages - 1) {
            next = '<li class="page-item"><a class="page-link">Next ›</a></li>';
            last = '<li class="page-item"><a class="page-link">Last »</a></li>';
        }
    } else {
        next = ''; // on the last page, don't show 'next' link
        last = ''; // nor 'last page' link
    }

    var start = pageNumber - (pageNumber % numLinks) + 1;
    var end = start + numLinks - 1;
    end = Math.min(totalPages, end);
    var pagingLink = '';

    for (var i = start; i <= end; i++) {
        if (i == pageNumber + 1) {
            pagingLink += '<li class="page-item active"><a class="page-link"> ' + i + ' </a></li>'; // no need to create a link to current page
        } else {
            pagingLink += '<li class="page-item"><a class="page-link"> ' + i + ' </a></li>';
        }
    }

    // return the page navigation link
    pagingLink = first + prev + pagingLink + next + last;

    $("ul.pagination").append(pagingLink);
}



$(document).on("click", "ul.pagination li a", function () {
    var data = $(this).attr('data');
    let val = $(this).text();
    console.log('val: ' + val);

    // click on the NEXT tag
    if (val.toUpperCase() === "« FIRST") {
        let currentActive = $("li.active");
        fetchMovies(0,localStorage.getItem('currentUrl'));
        $("li.active").removeClass("active");
        // add .active to next-pagination li
        currentActive.next().addClass("active");
    } else if (val.toUpperCase() === "LAST »") {
        fetchMovies(totalPages - 1, localStorage.getItem('currentUrl'));
        $("li.active").removeClass("active");
        // add .active to next-pagination li
        // currentActive.next().addClass("active");
    } else if (val.toUpperCase() === "NEXT ›") {
        let activeValue = parseInt($("ul.pagination li.active").text());
        if (activeValue < totalPages) {
            let currentActive = $("li.active");
            startPage = activeValue;
            fetchMovies(startPage, localStorage.getItem('currentUrl'));
            // remove .active class for the old li tag
            $("li.active").removeClass("active");
            // add .active to next-pagination li
            currentActive.next().addClass("active");
        }
    } else if (val.toUpperCase() === "‹ PREV") {
        let activeValue = parseInt($("ul.pagination li.active").text());
        if (activeValue > 1) {
            // get the previous page
            startPage = activeValue - 2;
            fetchMovies(startPage, localStorage.getItem('currentUrl'));
            let currentActive = $("li.active");
            currentActive.removeClass("active");
            // add .active to previous-pagination li
            currentActive.prev().addClass("active");
        }
    } else {
        startPage = parseInt(val - 1);
        fetchMovies(startPage, localStorage.getItem('currentUrl'));
        // add focus to the li tag
        $("li.active").removeClass("active");
        $(this).parent().addClass("active");
        // $(this).addClass("active");
    }
});


function getMovieCategories() {
    let response = fetch("http://localhost:8080/api/categories/all", {

        method: 'GET',
        headers: {
            'Content-type': 'application/json',
        },
    }).then(response => {
        if (!response.ok) {
            throw new Error(`Request failed with status ${reponse.status}`)
        }
        response.json()
            .then((categories) => {
                console.log(categories);
                categories.forEach(element => {
                    const newElement0 = document.createElement('li');
                    newElement0.style.width = "100%";
                    newElement0.innerHTML =
                        `  <div class="nearly-pepls" id="elements" style="  text-align: left;font-size: 20px;
                width: initial; margin-top: 20px">

                    <div class="pepl-info">
                                  <a href=" javascript:getMoviesByCategoryName('${element.categoryName}') " >${element.categoryName}</a>

                    </div>`

                    $('#ul_categories_list').append(newElement0);
                });
            })
    });
}


$(document).ready(function () {
    getMovieCategories();
    let totalPages = 1;

    (function () {
        // get first-page at initial time
        fetchMovies(0, 'http://localhost:8080/api/movies/all');
    })();
});

