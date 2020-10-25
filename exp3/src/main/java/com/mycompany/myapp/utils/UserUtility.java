package com.mycompany.myapp.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/// static uitilty   生命周期不受 spring 管理, 没有lazy（），要求所有与之有依赖关系的都要是static
///
/// @Component  自己定义的 class .use lazy() 缺点： 需要依赖注入到每个使用者中
/// @Bean
///
@Component
//@Bean
public class UserUtility {

    public String getUserName() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}

/// @bean
