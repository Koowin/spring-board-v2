package com.koowin.boardv2.validator;

import com.koowin.boardv2.model.Post;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PostValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Post.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Post p = (Post) target;
        if (p.getContent().isEmpty()) {
            errors.rejectValue("content", "key", "내용을 입력하세요");
        }
    }
}
