package com.gl.longrange.service;

import com.gl.longrange.entity.ExcelUtil;
import com.gl.longrange.entity.RemoteInfo;
import com.gl.longrange.mapper.RemoteInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@Service
@Transactional
public class ExceService implements IExceService {
    @Resource
    private RemoteInfoMapper remoteInfoMapper;
    @Override
    public String ajaxUploadExcel(MultipartFile file){
        // 获取IO流
        InputStream in = null;
        try {
            in = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return "系统导入表格出错！";
        }

        // 获取IO流的数据，[[1647, 顶顶顶, 1647, 男, 13-203], [174, 烦烦烦, ddd, 男, 12-201]]
        List<List<Object>> listob = null;
        try {
            listob = new ExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
            return "系统获取表格内容出错！";
        }
        //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
        System.out.println("listob"+listob);
        for (int i = 0; i < listob.size(); i++) {
            List<Object> lo = listob.get(i);
            System.out.println("遍历" + listob.get(i));
            RemoteInfo vo = new RemoteInfo();
            RemoteInfo j = null;

            try {
                //j = studentmapper.selectByPrimaryKey(Long.valueOf());
                j = remoteInfoMapper.selectByPrimaryKey(Integer.valueOf(String.valueOf(lo.get(0))));
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                System.out.println("没有新增");
            }

            vo.setRe_id((Integer.valueOf((String)lo.get(0))));
            vo.setRe_name(String.valueOf(lo.get(1)));
            vo.setRe_code(String.valueOf(lo.get(2)));
            vo.setRe_pwd(String.valueOf(lo.get(3)));
            vo.setCom_name(Integer.valueOf((String) lo.get(4)));
            vo.setSf_id(Integer.valueOf((String) lo.get(5)));
            if(j == null)
            {
                remoteInfoMapper.insert(vo);
            }
            else
            {
                remoteInfoMapper.updateByPrimaryKey(vo);
            }
        }
        return "导入成功";
    }

}

