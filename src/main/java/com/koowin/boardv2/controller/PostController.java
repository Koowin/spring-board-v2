package com.koowin.boardv2.controller;

import com.koowin.boardv2.dto.PostSaveRequestDto;
import com.koowin.boardv2.exception.BadRequestException;
import com.koowin.boardv2.model.Post;
import com.koowin.boardv2.repository.PostRepository;
import com.koowin.boardv2.validator.PostValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;
    private final PostValidator postValidator;

    @GetMapping("/list")
    public String list(Model model) {
        List<Post> allPosts = postRepository.findAll();
        model.addAttribute("posts", allPosts);
        return "board/list";
    }

    @GetMapping("/{id}")
    public String lookup(@PathVariable Long id, Model model) {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isEmpty()) {
            throw new BadRequestException(id);
        }
        model.addAttribute("post", postOptional.get());
        return "board/post";
    }

    @GetMapping("/save")
    public String saveForm(Model model) {
        model.addAttribute("post", new PostSaveRequestDto());
        return "board/save";
    }

    @PostMapping("/save")
    public String save(@Valid PostSaveRequestDto requestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "board/save";
        }
        postRepository.save(requestDto.toEntity());
        return "redirect:/board/list";
    }
}
