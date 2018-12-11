package cn.enilu.guns.bean.entity.user;

import javax.persistence.*;

@Entity
@Table(name = "p_product_expand_group", schema = "insure_service_sit", catalog = "")
public class PProductExpandGroup {
    private int pgId;
    private String masterPid;
    private String attachPid;

    @Id
    @Column(name = "PG_ID")
    public int getPgId() {
        return pgId;
    }

    public void setPgId(int pgId) {
        this.pgId = pgId;
    }

    @Basic
    @Column(name = "MASTER_PID")
    public String getMasterPid() {
        return masterPid;
    }

    public void setMasterPid(String masterPid) {
        this.masterPid = masterPid;
    }

    @Basic
    @Column(name = "ATTACH_PID")
    public String getAttachPid() {
        return attachPid;
    }

    public void setAttachPid(String attachPid) {
        this.attachPid = attachPid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PProductExpandGroup that = (PProductExpandGroup) o;

        if (pgId != that.pgId) return false;
        if (masterPid != null ? !masterPid.equals(that.masterPid) : that.masterPid != null) return false;
        if (attachPid != null ? !attachPid.equals(that.attachPid) : that.attachPid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pgId;
        result = 31 * result + (masterPid != null ? masterPid.hashCode() : 0);
        result = 31 * result + (attachPid != null ? attachPid.hashCode() : 0);
        return result;
    }
}
