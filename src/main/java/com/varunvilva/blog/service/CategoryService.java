package com.varunvilva.blog.service;

import com.varunvilva.blog.domain.entity.Category;
import com.varunvilva.blog.exception.ResourceAlreadyExistsException;
import com.varunvilva.blog.exception.ResourceDeletionFailedException;
import com.varunvilva.blog.exception.ResourceNotFoundExcpetion;
import com.varunvilva.blog.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public List<Category> getAllCategories(){
        return repository.findAll();
    }

    @Transactional
    public void createCategory(Category category){
        if(repository.existsByNameIgnoreCase(category.getName())){
            throw new ResourceAlreadyExistsException("Category already exists");
        }
        repository.save(category);
    }

    @Transactional
    public void deleteCategory(UUID id){
        Optional<Category> category = repository.findById(id);
        if(category.isPresent()){
            if(category.get().getPosts().isEmpty()){
                repository.deleteById(id);
            }
            throw new ResourceDeletionFailedException("Category has posts associated to it.");
        }
        throw new ResourceNotFoundExcpetion("Category not found");
    }



}
