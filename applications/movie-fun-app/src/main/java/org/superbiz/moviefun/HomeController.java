package org.superbiz.moviefun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.superbiz.moviefun.movieapi.movies.MovieFixtures;
import org.superbiz.moviefun.movieapi.movies.MovieInfo;
import org.superbiz.moviefun.movieapi.movies.MoviesClient;

import java.util.Map;

@Controller
public class HomeController {

    private final MoviesClient moviesClient;
//    private final AlbumsBean albumsBean;
    private final MovieFixtures movieFixtures;
//    private final AlbumFixtures albumFixtures;

    public HomeController(MoviesClient moviesClient, MovieFixtures movieFixtures) {
        this.moviesClient = moviesClient;
//        this.albumsBean = albumsBean;
        this.movieFixtures = movieFixtures;
//        this.albumFixtures = albumFixtures;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/setup")
    public String setup(Map<String, Object> model) {
        for (MovieInfo movieInfo : movieFixtures.load()) {
            moviesClient.addMovie(movieInfo);
        }

//        for (Album album : albumFixtures.load()) {
//            albumsBean.addAlbum(album);
//        }

        model.put("movies", moviesClient.getMovies());
//        model.put("albums", albumsBean.getAlbums());

        return "setup";
    }
}
