package com.mtj.mytestlist.entity;

import java.util.List;

/**
 * @author mtj
 * @time 2018/4/3 2018 04
 * @des
 */

public class Entity {

    private String site;   //站点

    private List<Data> Data;

    public List<Entity.Data> getData() {
        return Data;
    }

    public void setData(List<Entity.Data> data) {
        Data = data;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public static class Data {
        private String workSite;//工地

        private String workSiteType;//工地类型

        private String taskType;//作业类型

        private String inspectionTime;//督查时间


        public String getWorkSite() {
            return workSite;
        }

        public void setWorkSite(String workSite) {
            this.workSite = workSite;
        }

        public String getWorkSiteType() {
            return workSiteType;
        }

        public void setWorkSiteType(String workSiteType) {
            this.workSiteType = workSiteType;
        }

        public String getTaskType() {
            return taskType;
        }

        public void setTaskType(String taskType) {
            this.taskType = taskType;
        }

        public String getInspectionTime() {
            return inspectionTime;
        }

        public void setInspectionTime(String inspectionTime) {
            this.inspectionTime = inspectionTime;
        }
    }

}
