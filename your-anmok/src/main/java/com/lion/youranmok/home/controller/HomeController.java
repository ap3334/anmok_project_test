package com.lion.youranmok.home.controller;

import com.lion.youranmok.category.controller.CategoryController;
import com.lion.youranmok.category.dto.CategoryDto;
import com.lion.youranmok.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final CategoryRepository categoryRepository;

    @GetMapping()
    public String home(Model model) {

        List<CategoryDto> categories = new ArrayList<>();

        categories = categoryRepository.findAll().stream().map(i -> {
            CategoryDto dto = CategoryDto.builder()
                    .id(i.getId())
                    .title(i.getTitle())
                    .build();
            return dto;
        }).collect(Collectors.toList());



        model.addAttribute("categories", categories);

        return "home";

    }

}
