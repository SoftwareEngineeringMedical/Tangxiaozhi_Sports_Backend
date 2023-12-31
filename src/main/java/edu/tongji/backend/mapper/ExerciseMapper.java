package edu.tongji.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.tongji.backend.entity.Exercise;
import edu.tongji.backend.entity.Intervals;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ExerciseMapper extends BaseMapper<Exercise> {
    @MapKey("userId")
    public List<Map<String,String>> getExerciseIntervalsInOneDay(@Param("category") String
            type,@Param("userId")String userId,@Param("date") String date);

}
