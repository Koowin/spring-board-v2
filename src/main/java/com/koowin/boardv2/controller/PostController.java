package com.koowin.boardv2.controller;

import com.koowin.boardv2.model.Post;
import com.koowin.boardv2.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;

    @GetMapping("/list")
    public String list(Model model) {
        List<Post> allPosts = postRepository.findAll();
        model.addAttribute("posts", allPosts);
        return "board/list";
    }
}
