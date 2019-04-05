package parser.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "parsed_data")
public class ParsedData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PARSE_SEQ")
    @SequenceGenerator(name="PARSE_SEQ", sequenceName="parser_sequence", allocationSize=1)
    private long id;

    @Column
    private String ssoid;

    @Column
    private String ts;

    @Column
    private String grp;

    @Column(name = "data_type")
    private String type;

    @Column(name = "data_subtype")
    private String subtype;

    @Column
    private String url;

    @Column
    private String orgid;

    @Column
    private String formid;

    @Column
    private String code;

    @Column
    private String ltpa;

    @Column
    private String sudirresponse;

    @Column
    private Date ymdh;

    public ParsedData() {
    }

    public ParsedData(String ssoid, String ts, String grp, String type, String subtype, String url, String orgid, String formid, String code, String ltpa, String sudirresponse, Date ymdh) {
        this.ssoid = ssoid;
        this.ts = ts;
        this.grp = grp;
        this.type = type;
        this.subtype = subtype;
        this.url = url;
        this.orgid = orgid;
        this.formid = formid;
        this.code = code;
        this.ltpa = ltpa;
        this.sudirresponse = sudirresponse;
        this.ymdh = ymdh;
    }

    public long getId() {
        return id;
    }

    public String getSsoid() {
        return ssoid;
    }

    public void setSsoid(String ssoid) {
        this.ssoid = ssoid;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLtpa() {
        return ltpa;
    }

    public void setLtpa(String ltpa) {
        this.ltpa = ltpa;
    }

    public String getSudirresponse() {
        return sudirresponse;
    }

    public void setSudirresponse(String sudirresponse) {
        this.sudirresponse = sudirresponse;
    }

    public Date getYmdh() {
        return ymdh;
    }

    public void setYmdh(Date ymdh) {
        this.ymdh = ymdh;
    }
}
