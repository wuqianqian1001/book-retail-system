package com.example.bookretailsystem.control;

import com.example.bookretailsystem.repository.PointsRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuqianqian
 * @date 2022/3/27
 */
@RestController
@RequestMapping("/points")
public class PointsController {

    @Resource
    private PointsRepository pointsService;
}
