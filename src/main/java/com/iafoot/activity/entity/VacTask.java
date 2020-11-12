package com.iafoot.activity.entity;

import java.util.Date;

/**
 * @Copyright: iAfoot.
 * @Description:
 * @author: RX.HAN
 * @since: 2020/11/11 11:07 AM
 */
public class VacTask {

    private String id;
    private String name;
    private Vacation vac;
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vacation getVac() {
        return vac;
    }

    public void setVac(Vacation vac) {
        this.vac = vac;
    }
}
