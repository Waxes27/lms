package com.waxes27.lmstemplate.LMS.controllers;

import com.waxes27.lmstemplate.LMS.services.LmsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LmsController {
    private LmsService lmsService;
}
