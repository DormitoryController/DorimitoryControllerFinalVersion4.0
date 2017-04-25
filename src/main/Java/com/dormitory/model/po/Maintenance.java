package com.dormitory.model.po;

/**
 * Created by war on 2017/4/17.
 */
public class Maintenance {
    private int id;
    private int sid;
    private int svid;
    private int rid;
    private int item_id;
    private String repairer_type;
    private String fault_type;
    private String fault_location;
    private String fault_detail;
    private String fault_analysis;
    private String fault_state="待审定";
    private String reform_time;
    private String response_time;
    private int item_num;
    private String estimate_rate;
    private String estimate_detail;

    public Maintenance() {

    }

    public Maintenance(int id, int sid, int svid, int rid, int item_id, String repairer_type,String fault_type, String fault_location,
                       String fault_detail, String fault_analysis, String fault_state, String reform_time,
                       String response_time, int item_num, String estimate_rate, String estimate_detail) {
        this.id = id;
        this.sid = sid;
        this.svid = svid;
        this.rid = rid;
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
        this.estimate_detail = estimate_detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getSvid() {
        return svid;
    }

    public void setSvid(int svid) {
        this.svid = svid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
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

    public String getReform_time() {
        return reform_time;
    }

    public void setReform_time(String request_time) {
        this.reform_time = reform_time;
    }

    public String getResponse_time() {
        return response_time;
    }

    public void setResponse_time(String response_time) {
        this.response_time = response_time;
    }

    public int getItem_num() {
        return item_num;
    }

    public void setItem_num(int item_num) {
        this.item_num = item_num;
    }

    public String getEstimate_rate() {
        return estimate_rate;
    }

    public void setEstimate_rate(String estimate_rate) {
        this.estimate_rate = estimate_rate;
    }

    public String getEstimate_detail() {
        return estimate_detail;
    }

    public void setEstimate_detail(String estimate_detail) {
        this.estimate_detail = estimate_detail;
    }
}
