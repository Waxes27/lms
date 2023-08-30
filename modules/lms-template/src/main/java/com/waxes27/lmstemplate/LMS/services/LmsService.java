package com.waxes27.lmstemplate.LMS.services;


import com.waxes27.lmstemplate.LMS.repository.LmsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LmsService {
    private LmsRepository lmsRepository;
}
