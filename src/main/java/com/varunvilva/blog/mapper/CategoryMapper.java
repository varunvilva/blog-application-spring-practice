package com.varunvilva.blog.mapper;

import com.varunvilva.blog.domain.PostStatus;
import com.varunvilva.blog.domain.entity.Category;
import com.varunvilva.blog.domain.entity.Post;
import com.varunvilva.blog.dto.in.CategoryRequest;
import com.varunvilva.blog.dto.out.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target="postCount", source="posts", qualifiedByName="calculatePostCount")
    CategoryDto toDto(Category category);

    Category toEntity(CategoryRequest categoryRequest);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts){
        if(null == posts){
            return 0;
        }else{
           return posts.stream().filter(x->x.getStatus().equals(PostStatus.PUBLISHED)).count();
        }
    }
}
