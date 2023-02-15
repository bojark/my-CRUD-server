package ru.bojark.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import ru.bojark.model.Post;
import ru.bojark.service.PostService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    public static final String APPLICATION_JSON = "application/json";
    private static final String POST_DELETED = "Post deleted.";
    private final PostService service;
    private final Gson GSON = new Gson();

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<Post> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable long id) {
        return service.getById(id);
    }

    @PostMapping
    public Post save(@RequestBody Post post) {
        return service.save(post);
    }
    @DeleteMapping("/{id}")
    public void removeById(@PathVariable long id) throws IOException {
        service.removeById(id);
    }

}
