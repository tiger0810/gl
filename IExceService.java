package com.gl.longrange.service;

import org.springframework.web.multipart.MultipartFile;

public interface IExceService {
    String ajaxUploadExcel(MultipartFile file) throws Exception;

}
