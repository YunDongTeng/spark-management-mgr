package cn.sparke.modules.year.entity;

import cn.sparke.core.common.entity.BaseEntity;
import java.util.*;
import java.math.*;

/**
 * 年份Entity
 *
 * @author spark
 * @Date 2017-11-30 19:10:00
 */
public class YearEntity extends BaseEntity{
    //
    private String name;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

}
