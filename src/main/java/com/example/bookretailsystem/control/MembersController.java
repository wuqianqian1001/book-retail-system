package com.example.bookretailsystem.control;

import com.example.bookretailsystem.repository.MembersRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuqianqian
 * @date 2022-03-27
 */

@RestController
@RequestMapping("/member")
public class MembersController {

    @Resource
    private MembersRepository membersRepository;

}
