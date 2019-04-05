package parser.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "parsed_data")
public class ParsedData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PARSE_SEQ")
    //@SequenceGenerator(name="PARSE_SEQ", sequenceName="parser_sequence", allocationSize=1)
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

    public String getTs() {
        return ts;
    }

    public String getGrp() {
        return grp;
    }

    public String getType() {
        return type;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getUrl() {
        return url;
    }

    public String getOrgid() {
        return orgid;
    }

    public String getFormid() {
        return formid;
    }

    public String getCode() {
        return code;
    }

    public String getLtpa() {
        return ltpa;
    }

    public String getSudirresponse() {
        return sudirresponse;
    }

    public Date getYmdh() {
        return ymdh;
    }
}
