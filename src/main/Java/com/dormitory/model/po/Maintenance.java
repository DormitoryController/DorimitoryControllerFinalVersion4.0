package com.dormitory.model.po;

import java.util.Date;

/**
 * Created by war on 2017/4/17.
 */
public class Maintenance {
    private int id;
    private Long student_id;
    private int supervisor_id;
    private int repairer_id;
    private int item_id;
    private String repairer_type;
    private String fault_type;
    private String fault_location;
    private String fault_detail;
    private String fault_analysis;
    private String fault_state="待审定";
    private Date reform_time;
    private Date response_time;
    private int item_num;
    private float estimate_rate;
    private String estimate_detial;

    public Maintenance() {

    }

    public Maintenance(int id, Long student_id, int supervisor_id, int repairer_id, int item_id, String repairer_type, String fault_type, String fault_location, String fault_detail, String fault_analysis, String fault_state, Date reform_time, Date response_time, int item_num, float estimate_rate, String estimate_detial) {
        this.id = id;
        this.student_id = student_id;
        this.supervisor_id = supervisor_id;
        this.repairer_id = repairer_id;
        this.item_id = item_id;
        this.repairer_type = repairer_type;
        this.fault_type = fault_type;
        this.fault_location = fault_location;
        this.fault_detail = fault_detail;
        this.fault_analysis = fault_analysis;
        this.fault_state = fault_state;
        this.reform_time = reform_time;
        this.response_time = response_time;
        this.item_num = item_num;
        this.estimate_rate = estimate_rate;
        this.estimate_detial = estimate_detial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public int getSupervisor_id() {
        return supervisor_id;
    }

    public void setSupervisor_id(int supervisor_id) {
        this.supervisor_id = supervisor_id;
    }

    public int getRepairer_id() {
        return repairer_id;
    }

    public void setRepairer_id(int repairer_id) {
        this.repairer_id = repairer_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getRepairer_type() {
        return repairer_type;
    }

    public void setRepairer_type(String repairer_type) {
        this.repairer_type = repairer_type;
    }

    public String getFault_type() {
        return fault_type;
    }

    public void setFault_type(String fault_type) {
        this.fault_type = fault_type;
    }

    public String getFault_location() {
        return fault_location;
    }

    public void setFault_location(String fault_location) {
        this.fault_location = fault_location;
    }

    public String getFault_detail() {
        return fault_detail;
    }

    public void setFault_detail(String fault_detail) {
        this.fault_detail = fault_detail;
    }

    public String getFault_analysis() {
        return fault_analysis;
    }

    public void setFault_analysis(String fault_analysis) {
        this.fault_analysis = fault_analysis;
    }

    public String getFault_state() {
        return fault_state;
    }

    public void setFault_state(String fault_state) {
        this.fault_state = fault_state;
    }

    public Date getReform_time() {
        return reform_time;
    }

    public void setReform_time(Date reform_time) {
        this.reform_time = reform_time;
    }

    public Date getResponse_time() {
        return response_time;
    }

    public void setResponse_time(Date response_time) {
        this.response_time = response_time;
    }

    public int getItem_num() {
        return item_num;
    }

    public void setItem_num(int item_num) {
        this.item_num = item_num;
    }

    public float getEstimate_rate() {
        return estimate_rate;
    }

    public void setEstimate_rate(float estimate_rate) {
        this.estimate_rate = estimate_rate;
    }

    public String getEstimate_detial() {
        return estimate_detial;
    }

    public void setEstimate_detial(String estimate_detial) {
        this.estimate_detial = estimate_detial;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "id=" + id +
                ", student_id=" + student_id +
                ", supervisor_id=" + supervisor_id +
                ", repairer_id=" + repairer_id +
                ", item_id=" + item_id +
                ", repairer_type='" + repairer_type + '\'' +
                ", fault_type='" + fault_type + '\'' +
                ", fault_location='" + fault_location + '\'' +
                ", fault_detail='" + fault_detail + '\'' +
                ", fault_analysis='" + fault_analysis + '\'' +
                ", fault_state='" + fault_state + '\'' +
                ", reform_time=" + reform_time +
                ", response_time=" + response_time +
                ", item_num=" + item_num +
                ", estimate_rate=" + estimate_rate +
                ", estimate_detial='" + estimate_detial + '\'' +
                '}';
    }


}
