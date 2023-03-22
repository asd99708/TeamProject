package com.wedogo.controller.validator;
import com.wedogo.dto.UserInfoDTO;
import com.wedogo.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component // (2)
@RequiredArgsConstructor // (2)
public class UserInfoValidator implements Validator { // (1)

    private final UserInfoRepository userInfoRepository; // (2)

    @Override
    public boolean supports(Class<?> clazz) { // (3)
        return clazz.isAssignableFrom(UserInfoDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) { // (4)
        UserInfoDTO userInfoDTO = (UserInfoDTO) target;
        if (userInfoRepository.existsByEmail(userInfoDTO.getEmail())) {
            errors.rejectValue("email", "invalid.email", new Object[]{userInfoDTO.getEmail()},
                    "이미 사용중인 이메일입니다.");
        }
        if (userInfoRepository.existsByUserid(userInfoDTO.getUserid())) {
            errors.rejectValue("userid", "invalid.userid", new Object[]{userInfoDTO.getUserid()},
                    "이미 사용중인 아이디입니다.");
        }
    }
}