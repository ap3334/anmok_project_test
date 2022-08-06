package com.lion.youranmok.category.controller;

import com.lion.youranmok.category.dto.CategoryDto;
import com.lion.youranmok.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
@Log4j2
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @PostMapping("search")
    public String showList(String keyword, Model model) {

        List<CategoryDto> categories = new ArrayList<>();

        categories = categoryRepository.findByTitleContaining(keyword).stream().map(i -> {
            CategoryDto dto = CategoryDto.builder()
                    .id(i.getId())
                    .title(i.getTitle())
                    .build();
            return dto;
        }).collect(Collectors.toList());



        model.addAttribute("categories", categories);

        return "/home";
    }

}
