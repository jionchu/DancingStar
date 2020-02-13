package com.jyami.dancingstar.service;

import com.jyami.dancingstar.repository.DancingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by jyami on 2020/02/14
 */
@Service
@RequiredArgsConstructor
public class AdminService {

    private final NcloudAPIService ncloudAPIService;
    private final PythonExeService pythonExeService;
    private final DancingRepository dancingRepository;




}
