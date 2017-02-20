package cl.bennu.jdbc.dto;

import java.util.Date;

public class CalculateDTO {

    private Long id;
    private String ip;
    private String user;
    private String calculate;
    private Double result;
    private Date date;


    @Override
    public String toString() {
        return "CalculateDTO{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", user='" + user + '\'' +
                ", calculate='" + calculate + '\'' +
                ", result=" + result +
                ", date=" + date +
                '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCalculate() {
        return calculate;
    }

    public void setCalculate(String calculate) {
        this.calculate = calculate;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
