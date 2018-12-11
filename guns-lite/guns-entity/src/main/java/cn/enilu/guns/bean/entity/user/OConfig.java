package cn.enilu.guns.bean.entity.user;

import javax.persistence.*;

/**
 * Created by sunlm on 2018/11/13.
 */
@Entity
@Table(name = "o_config", schema = "insure_service_sit" )
public class OConfig {
    private String cKey;
    private String cValue;
    private String cName;
    private String cRemark;

    @Id
    @Column(name = "C_KEY", nullable = false, length = 100)
    public String getcKey() {
        return cKey;
    }

    public void setcKey(String cKey) {
        this.cKey = cKey;
    }

    @Basic
    @Column(name = "C_VALUE", nullable = true, length = 400)
    public String getcValue() {
        return cValue;
    }

    public void setcValue(String cValue) {
        this.cValue = cValue;
    }

    @Basic
    @Column(name = "C_NAME", nullable = true, length = 200)
    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Basic
    @Column(name = "C_REMARK", nullable = true, length = 400)
    public String getcRemark() {
        return cRemark;
    }

    public void setcRemark(String cRemark) {
        this.cRemark = cRemark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OConfig oConfig = (OConfig) o;

        if (cKey != null ? !cKey.equals(oConfig.cKey) : oConfig.cKey != null) return false;
        if (cValue != null ? !cValue.equals(oConfig.cValue) : oConfig.cValue != null) return false;
        if (cName != null ? !cName.equals(oConfig.cName) : oConfig.cName != null) return false;
        if (cRemark != null ? !cRemark.equals(oConfig.cRemark) : oConfig.cRemark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cKey != null ? cKey.hashCode() : 0;
        result = 31 * result + (cValue != null ? cValue.hashCode() : 0);
        result = 31 * result + (cName != null ? cName.hashCode() : 0);
        result = 31 * result + (cRemark != null ? cRemark.hashCode() : 0);
        return result;
    }
}
