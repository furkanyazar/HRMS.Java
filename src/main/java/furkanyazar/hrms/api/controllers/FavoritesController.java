package furkanyazar.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import furkanyazar.hrms.business.abstracts.FavoriteService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Favorite;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin
public class FavoritesController {

    private FavoriteService favoriteService;

    @Autowired
    public FavoritesController(FavoriteService favoriteService) {
        super();
        this.favoriteService = favoriteService;
    }

    @GetMapping("/findall")
    public DataResult<List<Favorite>> findAll() {
        return favoriteService.findAll();
    }

    @PostMapping("/add")
    public Result add(int userId, int jobPostingId) {
        return favoriteService.add(new Favorite(), userId, jobPostingId);
    }

    @PostMapping("/remove")
    public Result remove(int userId, int jobPostingId) {
        return favoriteService.delete(userId, jobPostingId);
    }

    @GetMapping("/getfavs")
    public DataResult<List<Favorite>> findByUserId(int id) {
        return favoriteService.findByUserId(id);
    }

}
