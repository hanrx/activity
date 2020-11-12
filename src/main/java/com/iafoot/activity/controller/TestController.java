package com.iafoot.activity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Copyright: iAfoot.
 * @Description:
 * @author: RX.HAN
 * @since: 2020/11/11 11:07 AM
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public Object test() {
        return "okay!";
    }
}
