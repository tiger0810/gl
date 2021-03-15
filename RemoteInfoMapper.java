package com.gl.longrange.mapper;
import com.gl.longrange.entity.ReSftware;
import com.gl.longrange.entity.RemoteInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

@Mapper
public interface RemoteInfoMapper {
     //根据店名查询 RemoteInfo
     List<RemoteInfo> selectfindall(@Param("Re_name")String Re_name);
     //查询所有数据 RemoteInfo
     List<RemoteInfo> selectRemoteInfo(RemoteInfo remoteInfo);
     //添加 RemoteInfo
     int insertRemoteInfo(Map<String, Object> map);
     //批量删除 RemoteInfo
     int deleteMany(List<String> delList);
     //修改
   /*  int updateRemoteInfo (RemoteInfo remoteInfo);*/
     //删除 RemoteInfo
     int deleteRemoteInfo(Integer reid);
     //Exce导入
     /* public boolean insertInfoBatch(List<RemoteInfo> list);*/
     /*String ajaxUploadExcel(MultipartFile file) throws Exception;*/
     //根据id查询
     RemoteInfo selectByPrimaryKey(Integer Re_id);
      //Exce添加
     int insert(RemoteInfo remoteInfo);
     //修改
     int updateByPrimaryKey(RemoteInfo remoteInfo);
     //下拉框查询
     List<ReSftware> addsele (ReSftware reSftware);

}
