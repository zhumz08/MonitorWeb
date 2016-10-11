package com.mvp.monitorweb.web.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 */

@SuppressWarnings("serial")
public class ViewCamera implements java.io.Serializable {

	// Fields

	private Integer sxjid;
	private String xjbh;
	private Integer dbh;
	private String xjmc;
	private String dwbh;
	private String jkcd;
	private String xjpp;
	private String xjxh;
	private String xjxslx;
	private String xjlx;
	private String mac;
	private String ipdz;
	private String dkh;
	private String dlyhm;
	private String dlmm;
	private String wgdz;
	private String zxzt;
	private String bzSheng;
	private String bzShi;
	private String bzXqq;
	private String bzSdXzjd;
	private String bzDd;
	private String gbShengj;
	private String gbShij;
	private String gbQuj;
	private String gbJcdw;
	private String gbSshy;
	private String gbWlbx;
	private String gbCjdw;
	private Integer jkfw;
	private Integer sfkk;
	private Integer yt;
	private Integer azwz;
	private Integer zgd;
	private String lxjh;
	private Integer qybz;
	private String spxy;
	private String xjtdh;
	private String xyyhm;
	private String xymm;
	private Integer zmlmllx;
	private String zmlurl;
	private Integer zmlyp;
	private Integer zmlljlx;
	private Integer zmlbmgs;
	private Integer zmlfzgs;
	private Integer zmlzdml;
	private Integer zmlzxml;
	private Integer zmljtfblk;
	private Integer zmljtfblg;
	private Integer zmlzl;
	private Integer zmlgopms;
	private Integer zmlgopjg;
	private Integer zimlmllx;
	private String zimlurl;
	private Integer zimlyp;
	private Integer zimlljlx;
	private Integer zimlbmgs;
	private Integer zimlfzgs;
	private Integer zimlzdml;
	private Integer zimlzxml;
	private Integer zimljtfblk;
	private Integer zimljtfblg;
	private Integer zimlzl;
	private Integer zimlgopms;
	private Integer zimlgopjg;
	private Integer jttw;
	private Integer jsny;
	private String jsdw;
	private String cjcs;
	private String sccs;
	private String ccrq;
	private String azrq;
	private Date bzqz;
	private String lrr;
	private Timestamp rksj;
	private String gxr;
	private Timestamp gxsj;
	private String glbm;
	private String xjzsbh;
	private String ytHtbh;
	private String jtHtbh;
	private String gcbh;
	private Date jyrq;
	private Date yxqz;
	private String jydw;
	private String zrrBm;
	private String zrrLxdh;
	private String zrrSjh;
	private String sfwjbgd;
	private String pgisjd;
	private String pgiswd;
	private String gisjd;
	private String giswd;
	private Integer lkxxid;
	private Integer lkxxwzx;
	private Integer lkxxwzy;
	private Integer dwxxid;
	private Integer fzid1;
	private Integer fzid2;
	private Integer fzid3;
	private Integer fzid4;
	private Integer fzid5;
	private Integer fzid6;
	private Integer fzid7;
	private Integer fzid8;
	private Integer fwqid;
	private Integer bmcsid;
	private Integer txzqjbxxid;
	private Integer txtjxxid;
	private Integer lxccjhid;
	private String fwqdz;
	private Integer ffsfcg;
	private Integer id;
	private String dm;
	private String dy;
	private String sjdm;

	// Constructors

	/** default constructor */
	public ViewCamera() {
	}

	/** minimal constructor */
	public ViewCamera(Integer sxjid, String xjbh, Integer id, String dm,
			String dy, String sjdm) {
		this.sxjid = sxjid;
		this.xjbh = xjbh;
		this.id = id;
		this.dm = dm;
		this.dy = dy;
		this.sjdm = sjdm;
	}

	/** full constructor */
	public ViewCamera(Integer sxjid, String xjbh, Integer dbh, String xjmc,
			String dwbh, String jkcd, String xjpp, String xjxh, String xjxslx,
			String xjlx, String mac, String ipdz, String dkh, String dlyhm,
			String dlmm, String wgdz, String zxzt, String bzSheng,
			String bzShi, String bzXqq, String bzSdXzjd, String bzDd,
			String gbShengj, String gbShij, String gbQuj, String gbJcdw,
			String gbSshy, String gbWlbx, String gbCjdw, Integer jkfw,
			Integer sfkk, Integer yt, Integer azwz, Integer zgd, String lxjh,
			Integer qybz, String spxy, String xjtdh, String xyyhm, String xymm,
			Integer zmlmllx, String zmlurl, Integer zmlyp, Integer zmlljlx,
			Integer zmlbmgs, Integer zmlfzgs, Integer zmlzdml, Integer zmlzxml,
			Integer zmljtfblk, Integer zmljtfblg, Integer zmlzl,
			Integer zmlgopms, Integer zmlgopjg, Integer zimlmllx,
			String zimlurl, Integer zimlyp, Integer zimlljlx, Integer zimlbmgs,
			Integer zimlfzgs, Integer zimlzdml, Integer zimlzxml,
			Integer zimljtfblk, Integer zimljtfblg, Integer zimlzl,
			Integer zimlgopms, Integer zimlgopjg, Integer jttw, Integer jsny,
			String jsdw, String cjcs, String sccs, String ccrq, String azrq,
			Date bzqz, String lrr, Timestamp rksj, String gxr, Timestamp gxsj,
			String glbm, String xjzsbh, String ytHtbh, String jtHtbh,
			String gcbh, Date jyrq, Date yxqz, String jydw, String zrrBm,
			String zrrLxdh, String zrrSjh, String sfwjbgd, String pgisjd,
			String pgiswd, String gisjd, String giswd, Integer lkxxid,
			Integer lkxxwzx, Integer lkxxwzy, Integer dwxxid, Integer fzid1,
			Integer fzid2, Integer fzid3, Integer fzid4, Integer fzid5,
			Integer fzid6, Integer fzid7, Integer fzid8, Integer fwqid,
			Integer bmcsid, Integer txzqjbxxid, Integer txtjxxid,
			Integer lxccjhid, String fwqdz, Integer ffsfcg, Integer id,
			String dm, String dy, String sjdm) {
		this.sxjid = sxjid;
		this.xjbh = xjbh;
		this.dbh = dbh;
		this.xjmc = xjmc;
		this.dwbh = dwbh;
		this.jkcd = jkcd;
		this.xjpp = xjpp;
		this.xjxh = xjxh;
		this.xjxslx = xjxslx;
		this.xjlx = xjlx;
		this.mac = mac;
		this.ipdz = ipdz;
		this.dkh = dkh;
		this.dlyhm = dlyhm;
		this.dlmm = dlmm;
		this.wgdz = wgdz;
		this.zxzt = zxzt;
		this.bzSheng = bzSheng;
		this.bzShi = bzShi;
		this.bzXqq = bzXqq;
		this.bzSdXzjd = bzSdXzjd;
		this.bzDd = bzDd;
		this.gbShengj = gbShengj;
		this.gbShij = gbShij;
		this.gbQuj = gbQuj;
		this.gbJcdw = gbJcdw;
		this.gbSshy = gbSshy;
		this.gbWlbx = gbWlbx;
		this.gbCjdw = gbCjdw;
		this.jkfw = jkfw;
		this.sfkk = sfkk;
		this.yt = yt;
		this.azwz = azwz;
		this.zgd = zgd;
		this.lxjh = lxjh;
		this.qybz = qybz;
		this.spxy = spxy;
		this.xjtdh = xjtdh;
		this.xyyhm = xyyhm;
		this.xymm = xymm;
		this.zmlmllx = zmlmllx;
		this.zmlurl = zmlurl;
		this.zmlyp = zmlyp;
		this.zmlljlx = zmlljlx;
		this.zmlbmgs = zmlbmgs;
		this.zmlfzgs = zmlfzgs;
		this.zmlzdml = zmlzdml;
		this.zmlzxml = zmlzxml;
		this.zmljtfblk = zmljtfblk;
		this.zmljtfblg = zmljtfblg;
		this.zmlzl = zmlzl;
		this.zmlgopms = zmlgopms;
		this.zmlgopjg = zmlgopjg;
		this.zimlmllx = zimlmllx;
		this.zimlurl = zimlurl;
		this.zimlyp = zimlyp;
		this.zimlljlx = zimlljlx;
		this.zimlbmgs = zimlbmgs;
		this.zimlfzgs = zimlfzgs;
		this.zimlzdml = zimlzdml;
		this.zimlzxml = zimlzxml;
		this.zimljtfblk = zimljtfblk;
		this.zimljtfblg = zimljtfblg;
		this.zimlzl = zimlzl;
		this.zimlgopms = zimlgopms;
		this.zimlgopjg = zimlgopjg;
		this.jttw = jttw;
		this.jsny = jsny;
		this.jsdw = jsdw;
		this.cjcs = cjcs;
		this.sccs = sccs;
		this.ccrq = ccrq;
		this.azrq = azrq;
		this.bzqz = bzqz;
		this.lrr = lrr;
		this.rksj = rksj;
		this.gxr = gxr;
		this.gxsj = gxsj;
		this.glbm = glbm;
		this.xjzsbh = xjzsbh;
		this.ytHtbh = ytHtbh;
		this.jtHtbh = jtHtbh;
		this.gcbh = gcbh;
		this.jyrq = jyrq;
		this.yxqz = yxqz;
		this.jydw = jydw;
		this.zrrBm = zrrBm;
		this.zrrLxdh = zrrLxdh;
		this.zrrSjh = zrrSjh;
		this.sfwjbgd = sfwjbgd;
		this.pgisjd = pgisjd;
		this.pgiswd = pgiswd;
		this.gisjd = gisjd;
		this.giswd = giswd;
		this.lkxxid = lkxxid;
		this.lkxxwzx = lkxxwzx;
		this.lkxxwzy = lkxxwzy;
		this.dwxxid = dwxxid;
		this.fzid1 = fzid1;
		this.fzid2 = fzid2;
		this.fzid3 = fzid3;
		this.fzid4 = fzid4;
		this.fzid5 = fzid5;
		this.fzid6 = fzid6;
		this.fzid7 = fzid7;
		this.fzid8 = fzid8;
		this.fwqid = fwqid;
		this.bmcsid = bmcsid;
		this.txzqjbxxid = txzqjbxxid;
		this.txtjxxid = txtjxxid;
		this.lxccjhid = lxccjhid;
		this.fwqdz = fwqdz;
		this.ffsfcg = ffsfcg;
		this.id = id;
		this.dm = dm;
		this.dy = dy;
		this.sjdm = sjdm;
	}

	// Property accessors

	public Integer getSxjid() {
		return this.sxjid;
	}

	public void setSxjid(Integer sxjid) {
		this.sxjid = sxjid;
	}

	public String getXjbh() {
		return this.xjbh;
	}

	public void setXjbh(String xjbh) {
		this.xjbh = xjbh;
	}

	public Integer getDbh() {
		return this.dbh;
	}

	public void setDbh(Integer dbh) {
		this.dbh = dbh;
	}

	public String getXjmc() {
		return this.xjmc;
	}

	public void setXjmc(String xjmc) {
		this.xjmc = xjmc;
	}

	public String getDwbh() {
		return this.dwbh;
	}

	public void setDwbh(String dwbh) {
		this.dwbh = dwbh;
	}

	public String getJkcd() {
		return this.jkcd;
	}

	public void setJkcd(String jkcd) {
		this.jkcd = jkcd;
	}

	public String getXjpp() {
		return this.xjpp;
	}

	public void setXjpp(String xjpp) {
		this.xjpp = xjpp;
	}

	public String getXjxh() {
		return this.xjxh;
	}

	public void setXjxh(String xjxh) {
		this.xjxh = xjxh;
	}

	public String getXjxslx() {
		return this.xjxslx;
	}

	public void setXjxslx(String xjxslx) {
		this.xjxslx = xjxslx;
	}

	public String getXjlx() {
		return this.xjlx;
	}

	public void setXjlx(String xjlx) {
		this.xjlx = xjlx;
	}

	public String getMac() {
		return this.mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getIpdz() {
		return this.ipdz;
	}

	public void setIpdz(String ipdz) {
		this.ipdz = ipdz;
	}

	public String getDkh() {
		return this.dkh;
	}

	public void setDkh(String dkh) {
		this.dkh = dkh;
	}

	public String getDlyhm() {
		return this.dlyhm;
	}

	public void setDlyhm(String dlyhm) {
		this.dlyhm = dlyhm;
	}

	public String getDlmm() {
		return this.dlmm;
	}

	public void setDlmm(String dlmm) {
		this.dlmm = dlmm;
	}

	public String getWgdz() {
		return this.wgdz;
	}

	public void setWgdz(String wgdz) {
		this.wgdz = wgdz;
	}

	public String getZxzt() {
		return this.zxzt;
	}

	public void setZxzt(String zxzt) {
		this.zxzt = zxzt;
	}

	public String getBzSheng() {
		return this.bzSheng;
	}

	public void setBzSheng(String bzSheng) {
		this.bzSheng = bzSheng;
	}

	public String getBzShi() {
		return this.bzShi;
	}

	public void setBzShi(String bzShi) {
		this.bzShi = bzShi;
	}

	public String getBzXqq() {
		return this.bzXqq;
	}

	public void setBzXqq(String bzXqq) {
		this.bzXqq = bzXqq;
	}

	public String getBzSdXzjd() {
		return this.bzSdXzjd;
	}

	public void setBzSdXzjd(String bzSdXzjd) {
		this.bzSdXzjd = bzSdXzjd;
	}

	public String getBzDd() {
		return this.bzDd;
	}

	public void setBzDd(String bzDd) {
		this.bzDd = bzDd;
	}

	public String getGbShengj() {
		return this.gbShengj;
	}

	public void setGbShengj(String gbShengj) {
		this.gbShengj = gbShengj;
	}

	public String getGbShij() {
		return this.gbShij;
	}

	public void setGbShij(String gbShij) {
		this.gbShij = gbShij;
	}

	public String getGbQuj() {
		return this.gbQuj;
	}

	public void setGbQuj(String gbQuj) {
		this.gbQuj = gbQuj;
	}

	public String getGbJcdw() {
		return this.gbJcdw;
	}

	public void setGbJcdw(String gbJcdw) {
		this.gbJcdw = gbJcdw;
	}

	public String getGbSshy() {
		return this.gbSshy;
	}

	public void setGbSshy(String gbSshy) {
		this.gbSshy = gbSshy;
	}

	public String getGbWlbx() {
		return this.gbWlbx;
	}

	public void setGbWlbx(String gbWlbx) {
		this.gbWlbx = gbWlbx;
	}

	public String getGbCjdw() {
		return this.gbCjdw;
	}

	public void setGbCjdw(String gbCjdw) {
		this.gbCjdw = gbCjdw;
	}

	public Integer getJkfw() {
		return this.jkfw;
	}

	public void setJkfw(Integer jkfw) {
		this.jkfw = jkfw;
	}

	public Integer getSfkk() {
		return this.sfkk;
	}

	public void setSfkk(Integer sfkk) {
		this.sfkk = sfkk;
	}

	public Integer getYt() {
		return this.yt;
	}

	public void setYt(Integer yt) {
		this.yt = yt;
	}

	public Integer getAzwz() {
		return this.azwz;
	}

	public void setAzwz(Integer azwz) {
		this.azwz = azwz;
	}

	public Integer getZgd() {
		return this.zgd;
	}

	public void setZgd(Integer zgd) {
		this.zgd = zgd;
	}

	public String getLxjh() {
		return this.lxjh;
	}

	public void setLxjh(String lxjh) {
		this.lxjh = lxjh;
	}

	public Integer getQybz() {
		return this.qybz;
	}

	public void setQybz(Integer qybz) {
		this.qybz = qybz;
	}

	public String getSpxy() {
		return this.spxy;
	}

	public void setSpxy(String spxy) {
		this.spxy = spxy;
	}

	public String getXjtdh() {
		return this.xjtdh;
	}

	public void setXjtdh(String xjtdh) {
		this.xjtdh = xjtdh;
	}

	public String getXyyhm() {
		return this.xyyhm;
	}

	public void setXyyhm(String xyyhm) {
		this.xyyhm = xyyhm;
	}

	public String getXymm() {
		return this.xymm;
	}

	public void setXymm(String xymm) {
		this.xymm = xymm;
	}

	public Integer getZmlmllx() {
		return this.zmlmllx;
	}

	public void setZmlmllx(Integer zmlmllx) {
		this.zmlmllx = zmlmllx;
	}

	public String getZmlurl() {
		return this.zmlurl;
	}

	public void setZmlurl(String zmlurl) {
		this.zmlurl = zmlurl;
	}

	public Integer getZmlyp() {
		return this.zmlyp;
	}

	public void setZmlyp(Integer zmlyp) {
		this.zmlyp = zmlyp;
	}

	public Integer getZmlljlx() {
		return this.zmlljlx;
	}

	public void setZmlljlx(Integer zmlljlx) {
		this.zmlljlx = zmlljlx;
	}

	public Integer getZmlbmgs() {
		return this.zmlbmgs;
	}

	public void setZmlbmgs(Integer zmlbmgs) {
		this.zmlbmgs = zmlbmgs;
	}

	public Integer getZmlfzgs() {
		return this.zmlfzgs;
	}

	public void setZmlfzgs(Integer zmlfzgs) {
		this.zmlfzgs = zmlfzgs;
	}

	public Integer getZmlzdml() {
		return this.zmlzdml;
	}

	public void setZmlzdml(Integer zmlzdml) {
		this.zmlzdml = zmlzdml;
	}

	public Integer getZmlzxml() {
		return this.zmlzxml;
	}

	public void setZmlzxml(Integer zmlzxml) {
		this.zmlzxml = zmlzxml;
	}

	public Integer getZmljtfblk() {
		return this.zmljtfblk;
	}

	public void setZmljtfblk(Integer zmljtfblk) {
		this.zmljtfblk = zmljtfblk;
	}

	public Integer getZmljtfblg() {
		return this.zmljtfblg;
	}

	public void setZmljtfblg(Integer zmljtfblg) {
		this.zmljtfblg = zmljtfblg;
	}

	public Integer getZmlzl() {
		return this.zmlzl;
	}

	public void setZmlzl(Integer zmlzl) {
		this.zmlzl = zmlzl;
	}

	public Integer getZmlgopms() {
		return this.zmlgopms;
	}

	public void setZmlgopms(Integer zmlgopms) {
		this.zmlgopms = zmlgopms;
	}

	public Integer getZmlgopjg() {
		return this.zmlgopjg;
	}

	public void setZmlgopjg(Integer zmlgopjg) {
		this.zmlgopjg = zmlgopjg;
	}

	public Integer getZimlmllx() {
		return this.zimlmllx;
	}

	public void setZimlmllx(Integer zimlmllx) {
		this.zimlmllx = zimlmllx;
	}

	public String getZimlurl() {
		return this.zimlurl;
	}

	public void setZimlurl(String zimlurl) {
		this.zimlurl = zimlurl;
	}

	public Integer getZimlyp() {
		return this.zimlyp;
	}

	public void setZimlyp(Integer zimlyp) {
		this.zimlyp = zimlyp;
	}

	public Integer getZimlljlx() {
		return this.zimlljlx;
	}

	public void setZimlljlx(Integer zimlljlx) {
		this.zimlljlx = zimlljlx;
	}

	public Integer getZimlbmgs() {
		return this.zimlbmgs;
	}

	public void setZimlbmgs(Integer zimlbmgs) {
		this.zimlbmgs = zimlbmgs;
	}

	public Integer getZimlfzgs() {
		return this.zimlfzgs;
	}

	public void setZimlfzgs(Integer zimlfzgs) {
		this.zimlfzgs = zimlfzgs;
	}

	public Integer getZimlzdml() {
		return this.zimlzdml;
	}

	public void setZimlzdml(Integer zimlzdml) {
		this.zimlzdml = zimlzdml;
	}

	public Integer getZimlzxml() {
		return this.zimlzxml;
	}

	public void setZimlzxml(Integer zimlzxml) {
		this.zimlzxml = zimlzxml;
	}

	public Integer getZimljtfblk() {
		return this.zimljtfblk;
	}

	public void setZimljtfblk(Integer zimljtfblk) {
		this.zimljtfblk = zimljtfblk;
	}

	public Integer getZimljtfblg() {
		return this.zimljtfblg;
	}

	public void setZimljtfblg(Integer zimljtfblg) {
		this.zimljtfblg = zimljtfblg;
	}

	public Integer getZimlzl() {
		return this.zimlzl;
	}

	public void setZimlzl(Integer zimlzl) {
		this.zimlzl = zimlzl;
	}

	public Integer getZimlgopms() {
		return this.zimlgopms;
	}

	public void setZimlgopms(Integer zimlgopms) {
		this.zimlgopms = zimlgopms;
	}

	public Integer getZimlgopjg() {
		return this.zimlgopjg;
	}

	public void setZimlgopjg(Integer zimlgopjg) {
		this.zimlgopjg = zimlgopjg;
	}

	public Integer getJttw() {
		return this.jttw;
	}

	public void setJttw(Integer jttw) {
		this.jttw = jttw;
	}

	public Integer getJsny() {
		return this.jsny;
	}

	public void setJsny(Integer jsny) {
		this.jsny = jsny;
	}

	public String getJsdw() {
		return this.jsdw;
	}

	public void setJsdw(String jsdw) {
		this.jsdw = jsdw;
	}

	public String getCjcs() {
		return this.cjcs;
	}

	public void setCjcs(String cjcs) {
		this.cjcs = cjcs;
	}

	public String getSccs() {
		return this.sccs;
	}

	public void setSccs(String sccs) {
		this.sccs = sccs;
	}

	public String getCcrq() {
		return this.ccrq;
	}

	public void setCcrq(String ccrq) {
		this.ccrq = ccrq;
	}

	public String getAzrq() {
		return this.azrq;
	}

	public void setAzrq(String azrq) {
		this.azrq = azrq;
	}

	public Date getBzqz() {
		return this.bzqz;
	}

	public void setBzqz(Date bzqz) {
		this.bzqz = bzqz;
	}

	public String getLrr() {
		return this.lrr;
	}

	public void setLrr(String lrr) {
		this.lrr = lrr;
	}

	public Timestamp getRksj() {
		return this.rksj;
	}

	public void setRksj(Timestamp rksj) {
		this.rksj = rksj;
	}

	public String getGxr() {
		return this.gxr;
	}

	public void setGxr(String gxr) {
		this.gxr = gxr;
	}

	public Timestamp getGxsj() {
		return this.gxsj;
	}

	public void setGxsj(Timestamp gxsj) {
		this.gxsj = gxsj;
	}

	public String getGlbm() {
		return this.glbm;
	}

	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}

	public String getXjzsbh() {
		return this.xjzsbh;
	}

	public void setXjzsbh(String xjzsbh) {
		this.xjzsbh = xjzsbh;
	}

	public String getYtHtbh() {
		return this.ytHtbh;
	}

	public void setYtHtbh(String ytHtbh) {
		this.ytHtbh = ytHtbh;
	}

	public String getJtHtbh() {
		return this.jtHtbh;
	}

	public void setJtHtbh(String jtHtbh) {
		this.jtHtbh = jtHtbh;
	}

	public String getGcbh() {
		return this.gcbh;
	}

	public void setGcbh(String gcbh) {
		this.gcbh = gcbh;
	}

	public Date getJyrq() {
		return this.jyrq;
	}

	public void setJyrq(Date jyrq) {
		this.jyrq = jyrq;
	}

	public Date getYxqz() {
		return this.yxqz;
	}

	public void setYxqz(Date yxqz) {
		this.yxqz = yxqz;
	}

	public String getJydw() {
		return this.jydw;
	}

	public void setJydw(String jydw) {
		this.jydw = jydw;
	}

	public String getZrrBm() {
		return this.zrrBm;
	}

	public void setZrrBm(String zrrBm) {
		this.zrrBm = zrrBm;
	}

	public String getZrrLxdh() {
		return this.zrrLxdh;
	}

	public void setZrrLxdh(String zrrLxdh) {
		this.zrrLxdh = zrrLxdh;
	}

	public String getZrrSjh() {
		return this.zrrSjh;
	}

	public void setZrrSjh(String zrrSjh) {
		this.zrrSjh = zrrSjh;
	}

	public String getSfwjbgd() {
		return this.sfwjbgd;
	}

	public void setSfwjbgd(String sfwjbgd) {
		this.sfwjbgd = sfwjbgd;
	}

	public String getPgisjd() {
		return this.pgisjd;
	}

	public void setPgisjd(String pgisjd) {
		this.pgisjd = pgisjd;
	}

	public String getPgiswd() {
		return this.pgiswd;
	}

	public void setPgiswd(String pgiswd) {
		this.pgiswd = pgiswd;
	}

	public String getGisjd() {
		return this.gisjd;
	}

	public void setGisjd(String gisjd) {
		this.gisjd = gisjd;
	}

	public String getGiswd() {
		return this.giswd;
	}

	public void setGiswd(String giswd) {
		this.giswd = giswd;
	}

	public Integer getLkxxid() {
		return this.lkxxid;
	}

	public void setLkxxid(Integer lkxxid) {
		this.lkxxid = lkxxid;
	}

	public Integer getLkxxwzx() {
		return this.lkxxwzx;
	}

	public void setLkxxwzx(Integer lkxxwzx) {
		this.lkxxwzx = lkxxwzx;
	}

	public Integer getLkxxwzy() {
		return this.lkxxwzy;
	}

	public void setLkxxwzy(Integer lkxxwzy) {
		this.lkxxwzy = lkxxwzy;
	}

	public Integer getDwxxid() {
		return this.dwxxid;
	}

	public void setDwxxid(Integer dwxxid) {
		this.dwxxid = dwxxid;
	}

	public Integer getFzid1() {
		return this.fzid1;
	}

	public void setFzid1(Integer fzid1) {
		this.fzid1 = fzid1;
	}

	public Integer getFzid2() {
		return this.fzid2;
	}

	public void setFzid2(Integer fzid2) {
		this.fzid2 = fzid2;
	}

	public Integer getFzid3() {
		return this.fzid3;
	}

	public void setFzid3(Integer fzid3) {
		this.fzid3 = fzid3;
	}

	public Integer getFzid4() {
		return this.fzid4;
	}

	public void setFzid4(Integer fzid4) {
		this.fzid4 = fzid4;
	}

	public Integer getFzid5() {
		return this.fzid5;
	}

	public void setFzid5(Integer fzid5) {
		this.fzid5 = fzid5;
	}

	public Integer getFzid6() {
		return this.fzid6;
	}

	public void setFzid6(Integer fzid6) {
		this.fzid6 = fzid6;
	}

	public Integer getFzid7() {
		return this.fzid7;
	}

	public void setFzid7(Integer fzid7) {
		this.fzid7 = fzid7;
	}

	public Integer getFzid8() {
		return this.fzid8;
	}

	public void setFzid8(Integer fzid8) {
		this.fzid8 = fzid8;
	}

	public Integer getFwqid() {
		return this.fwqid;
	}

	public void setFwqid(Integer fwqid) {
		this.fwqid = fwqid;
	}

	public Integer getBmcsid() {
		return this.bmcsid;
	}

	public void setBmcsid(Integer bmcsid) {
		this.bmcsid = bmcsid;
	}

	public Integer getTxzqjbxxid() {
		return this.txzqjbxxid;
	}

	public void setTxzqjbxxid(Integer txzqjbxxid) {
		this.txzqjbxxid = txzqjbxxid;
	}

	public Integer getTxtjxxid() {
		return this.txtjxxid;
	}

	public void setTxtjxxid(Integer txtjxxid) {
		this.txtjxxid = txtjxxid;
	}

	public Integer getLxccjhid() {
		return this.lxccjhid;
	}

	public void setLxccjhid(Integer lxccjhid) {
		this.lxccjhid = lxccjhid;
	}

	public String getFwqdz() {
		return this.fwqdz;
	}

	public void setFwqdz(String fwqdz) {
		this.fwqdz = fwqdz;
	}

	public Integer getFfsfcg() {
		return this.ffsfcg;
	}

	public void setFfsfcg(Integer ffsfcg) {
		this.ffsfcg = ffsfcg;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDm() {
		return this.dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	public String getDy() {
		return this.dy;
	}

	public void setDy(String dy) {
		this.dy = dy;
	}

	public String getSjdm() {
		return this.sjdm;
	}

	public void setSjdm(String sjdm) {
		this.sjdm = sjdm;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ViewCamera))
			return false;
		ViewCamera castOther = (ViewCamera) other;

		return ((this.getSxjid() == castOther.getSxjid()) || (this.getSxjid() != null
				&& castOther.getSxjid() != null && this.getSxjid().equals(
				castOther.getSxjid())))
				&& ((this.getXjbh() == castOther.getXjbh()) || (this.getXjbh() != null
						&& castOther.getXjbh() != null && this.getXjbh()
						.equals(castOther.getXjbh())))
				&& ((this.getDbh() == castOther.getDbh()) || (this.getDbh() != null
						&& castOther.getDbh() != null && this.getDbh().equals(
						castOther.getDbh())))
				&& ((this.getXjmc() == castOther.getXjmc()) || (this.getXjmc() != null
						&& castOther.getXjmc() != null && this.getXjmc()
						.equals(castOther.getXjmc())))
				&& ((this.getDwbh() == castOther.getDwbh()) || (this.getDwbh() != null
						&& castOther.getDwbh() != null && this.getDwbh()
						.equals(castOther.getDwbh())))
				&& ((this.getJkcd() == castOther.getJkcd()) || (this.getJkcd() != null
						&& castOther.getJkcd() != null && this.getJkcd()
						.equals(castOther.getJkcd())))
				&& ((this.getXjpp() == castOther.getXjpp()) || (this.getXjpp() != null
						&& castOther.getXjpp() != null && this.getXjpp()
						.equals(castOther.getXjpp())))
				&& ((this.getXjxh() == castOther.getXjxh()) || (this.getXjxh() != null
						&& castOther.getXjxh() != null && this.getXjxh()
						.equals(castOther.getXjxh())))
				&& ((this.getXjxslx() == castOther.getXjxslx()) || (this
						.getXjxslx() != null && castOther.getXjxslx() != null && this
						.getXjxslx().equals(castOther.getXjxslx())))
				&& ((this.getXjlx() == castOther.getXjlx()) || (this.getXjlx() != null
						&& castOther.getXjlx() != null && this.getXjlx()
						.equals(castOther.getXjlx())))
				&& ((this.getMac() == castOther.getMac()) || (this.getMac() != null
						&& castOther.getMac() != null && this.getMac().equals(
						castOther.getMac())))
				&& ((this.getIpdz() == castOther.getIpdz()) || (this.getIpdz() != null
						&& castOther.getIpdz() != null && this.getIpdz()
						.equals(castOther.getIpdz())))
				&& ((this.getDkh() == castOther.getDkh()) || (this.getDkh() != null
						&& castOther.getDkh() != null && this.getDkh().equals(
						castOther.getDkh())))
				&& ((this.getDlyhm() == castOther.getDlyhm()) || (this
						.getDlyhm() != null && castOther.getDlyhm() != null && this
						.getDlyhm().equals(castOther.getDlyhm())))
				&& ((this.getDlmm() == castOther.getDlmm()) || (this.getDlmm() != null
						&& castOther.getDlmm() != null && this.getDlmm()
						.equals(castOther.getDlmm())))
				&& ((this.getWgdz() == castOther.getWgdz()) || (this.getWgdz() != null
						&& castOther.getWgdz() != null && this.getWgdz()
						.equals(castOther.getWgdz())))
				&& ((this.getZxzt() == castOther.getZxzt()) || (this.getZxzt() != null
						&& castOther.getZxzt() != null && this.getZxzt()
						.equals(castOther.getZxzt())))
				&& ((this.getBzSheng() == castOther.getBzSheng()) || (this
						.getBzSheng() != null && castOther.getBzSheng() != null && this
						.getBzSheng().equals(castOther.getBzSheng())))
				&& ((this.getBzShi() == castOther.getBzShi()) || (this
						.getBzShi() != null && castOther.getBzShi() != null && this
						.getBzShi().equals(castOther.getBzShi())))
				&& ((this.getBzXqq() == castOther.getBzXqq()) || (this
						.getBzXqq() != null && castOther.getBzXqq() != null && this
						.getBzXqq().equals(castOther.getBzXqq())))
				&& ((this.getBzSdXzjd() == castOther.getBzSdXzjd()) || (this
						.getBzSdXzjd() != null
						&& castOther.getBzSdXzjd() != null && this
						.getBzSdXzjd().equals(castOther.getBzSdXzjd())))
				&& ((this.getBzDd() == castOther.getBzDd()) || (this.getBzDd() != null
						&& castOther.getBzDd() != null && this.getBzDd()
						.equals(castOther.getBzDd())))
				&& ((this.getGbShengj() == castOther.getGbShengj()) || (this
						.getGbShengj() != null
						&& castOther.getGbShengj() != null && this
						.getGbShengj().equals(castOther.getGbShengj())))
				&& ((this.getGbShij() == castOther.getGbShij()) || (this
						.getGbShij() != null && castOther.getGbShij() != null && this
						.getGbShij().equals(castOther.getGbShij())))
				&& ((this.getGbQuj() == castOther.getGbQuj()) || (this
						.getGbQuj() != null && castOther.getGbQuj() != null && this
						.getGbQuj().equals(castOther.getGbQuj())))
				&& ((this.getGbJcdw() == castOther.getGbJcdw()) || (this
						.getGbJcdw() != null && castOther.getGbJcdw() != null && this
						.getGbJcdw().equals(castOther.getGbJcdw())))
				&& ((this.getGbSshy() == castOther.getGbSshy()) || (this
						.getGbSshy() != null && castOther.getGbSshy() != null && this
						.getGbSshy().equals(castOther.getGbSshy())))
				&& ((this.getGbWlbx() == castOther.getGbWlbx()) || (this
						.getGbWlbx() != null && castOther.getGbWlbx() != null && this
						.getGbWlbx().equals(castOther.getGbWlbx())))
				&& ((this.getGbCjdw() == castOther.getGbCjdw()) || (this
						.getGbCjdw() != null && castOther.getGbCjdw() != null && this
						.getGbCjdw().equals(castOther.getGbCjdw())))
				&& ((this.getJkfw() == castOther.getJkfw()) || (this.getJkfw() != null
						&& castOther.getJkfw() != null && this.getJkfw()
						.equals(castOther.getJkfw())))
				&& ((this.getSfkk() == castOther.getSfkk()) || (this.getSfkk() != null
						&& castOther.getSfkk() != null && this.getSfkk()
						.equals(castOther.getSfkk())))
				&& ((this.getYt() == castOther.getYt()) || (this.getYt() != null
						&& castOther.getYt() != null && this.getYt().equals(
						castOther.getYt())))
				&& ((this.getAzwz() == castOther.getAzwz()) || (this.getAzwz() != null
						&& castOther.getAzwz() != null && this.getAzwz()
						.equals(castOther.getAzwz())))
				&& ((this.getZgd() == castOther.getZgd()) || (this.getZgd() != null
						&& castOther.getZgd() != null && this.getZgd().equals(
						castOther.getZgd())))
				&& ((this.getLxjh() == castOther.getLxjh()) || (this.getLxjh() != null
						&& castOther.getLxjh() != null && this.getLxjh()
						.equals(castOther.getLxjh())))
				&& ((this.getQybz() == castOther.getQybz()) || (this.getQybz() != null
						&& castOther.getQybz() != null && this.getQybz()
						.equals(castOther.getQybz())))
				&& ((this.getSpxy() == castOther.getSpxy()) || (this.getSpxy() != null
						&& castOther.getSpxy() != null && this.getSpxy()
						.equals(castOther.getSpxy())))
				&& ((this.getXjtdh() == castOther.getXjtdh()) || (this
						.getXjtdh() != null && castOther.getXjtdh() != null && this
						.getXjtdh().equals(castOther.getXjtdh())))
				&& ((this.getXyyhm() == castOther.getXyyhm()) || (this
						.getXyyhm() != null && castOther.getXyyhm() != null && this
						.getXyyhm().equals(castOther.getXyyhm())))
				&& ((this.getXymm() == castOther.getXymm()) || (this.getXymm() != null
						&& castOther.getXymm() != null && this.getXymm()
						.equals(castOther.getXymm())))
				&& ((this.getZmlmllx() == castOther.getZmlmllx()) || (this
						.getZmlmllx() != null && castOther.getZmlmllx() != null && this
						.getZmlmllx().equals(castOther.getZmlmllx())))
				&& ((this.getZmlurl() == castOther.getZmlurl()) || (this
						.getZmlurl() != null && castOther.getZmlurl() != null && this
						.getZmlurl().equals(castOther.getZmlurl())))
				&& ((this.getZmlyp() == castOther.getZmlyp()) || (this
						.getZmlyp() != null && castOther.getZmlyp() != null && this
						.getZmlyp().equals(castOther.getZmlyp())))
				&& ((this.getZmlljlx() == castOther.getZmlljlx()) || (this
						.getZmlljlx() != null && castOther.getZmlljlx() != null && this
						.getZmlljlx().equals(castOther.getZmlljlx())))
				&& ((this.getZmlbmgs() == castOther.getZmlbmgs()) || (this
						.getZmlbmgs() != null && castOther.getZmlbmgs() != null && this
						.getZmlbmgs().equals(castOther.getZmlbmgs())))
				&& ((this.getZmlfzgs() == castOther.getZmlfzgs()) || (this
						.getZmlfzgs() != null && castOther.getZmlfzgs() != null && this
						.getZmlfzgs().equals(castOther.getZmlfzgs())))
				&& ((this.getZmlzdml() == castOther.getZmlzdml()) || (this
						.getZmlzdml() != null && castOther.getZmlzdml() != null && this
						.getZmlzdml().equals(castOther.getZmlzdml())))
				&& ((this.getZmlzxml() == castOther.getZmlzxml()) || (this
						.getZmlzxml() != null && castOther.getZmlzxml() != null && this
						.getZmlzxml().equals(castOther.getZmlzxml())))
				&& ((this.getZmljtfblk() == castOther.getZmljtfblk()) || (this
						.getZmljtfblk() != null
						&& castOther.getZmljtfblk() != null && this
						.getZmljtfblk().equals(castOther.getZmljtfblk())))
				&& ((this.getZmljtfblg() == castOther.getZmljtfblg()) || (this
						.getZmljtfblg() != null
						&& castOther.getZmljtfblg() != null && this
						.getZmljtfblg().equals(castOther.getZmljtfblg())))
				&& ((this.getZmlzl() == castOther.getZmlzl()) || (this
						.getZmlzl() != null && castOther.getZmlzl() != null && this
						.getZmlzl().equals(castOther.getZmlzl())))
				&& ((this.getZmlgopms() == castOther.getZmlgopms()) || (this
						.getZmlgopms() != null
						&& castOther.getZmlgopms() != null && this
						.getZmlgopms().equals(castOther.getZmlgopms())))
				&& ((this.getZmlgopjg() == castOther.getZmlgopjg()) || (this
						.getZmlgopjg() != null
						&& castOther.getZmlgopjg() != null && this
						.getZmlgopjg().equals(castOther.getZmlgopjg())))
				&& ((this.getZimlmllx() == castOther.getZimlmllx()) || (this
						.getZimlmllx() != null
						&& castOther.getZimlmllx() != null && this
						.getZimlmllx().equals(castOther.getZimlmllx())))
				&& ((this.getZimlurl() == castOther.getZimlurl()) || (this
						.getZimlurl() != null && castOther.getZimlurl() != null && this
						.getZimlurl().equals(castOther.getZimlurl())))
				&& ((this.getZimlyp() == castOther.getZimlyp()) || (this
						.getZimlyp() != null && castOther.getZimlyp() != null && this
						.getZimlyp().equals(castOther.getZimlyp())))
				&& ((this.getZimlljlx() == castOther.getZimlljlx()) || (this
						.getZimlljlx() != null
						&& castOther.getZimlljlx() != null && this
						.getZimlljlx().equals(castOther.getZimlljlx())))
				&& ((this.getZimlbmgs() == castOther.getZimlbmgs()) || (this
						.getZimlbmgs() != null
						&& castOther.getZimlbmgs() != null && this
						.getZimlbmgs().equals(castOther.getZimlbmgs())))
				&& ((this.getZimlfzgs() == castOther.getZimlfzgs()) || (this
						.getZimlfzgs() != null
						&& castOther.getZimlfzgs() != null && this
						.getZimlfzgs().equals(castOther.getZimlfzgs())))
				&& ((this.getZimlzdml() == castOther.getZimlzdml()) || (this
						.getZimlzdml() != null
						&& castOther.getZimlzdml() != null && this
						.getZimlzdml().equals(castOther.getZimlzdml())))
				&& ((this.getZimlzxml() == castOther.getZimlzxml()) || (this
						.getZimlzxml() != null
						&& castOther.getZimlzxml() != null && this
						.getZimlzxml().equals(castOther.getZimlzxml())))
				&& ((this.getZimljtfblk() == castOther.getZimljtfblk()) || (this
						.getZimljtfblk() != null
						&& castOther.getZimljtfblk() != null && this
						.getZimljtfblk().equals(castOther.getZimljtfblk())))
				&& ((this.getZimljtfblg() == castOther.getZimljtfblg()) || (this
						.getZimljtfblg() != null
						&& castOther.getZimljtfblg() != null && this
						.getZimljtfblg().equals(castOther.getZimljtfblg())))
				&& ((this.getZimlzl() == castOther.getZimlzl()) || (this
						.getZimlzl() != null && castOther.getZimlzl() != null && this
						.getZimlzl().equals(castOther.getZimlzl())))
				&& ((this.getZimlgopms() == castOther.getZimlgopms()) || (this
						.getZimlgopms() != null
						&& castOther.getZimlgopms() != null && this
						.getZimlgopms().equals(castOther.getZimlgopms())))
				&& ((this.getZimlgopjg() == castOther.getZimlgopjg()) || (this
						.getZimlgopjg() != null
						&& castOther.getZimlgopjg() != null && this
						.getZimlgopjg().equals(castOther.getZimlgopjg())))
				&& ((this.getJttw() == castOther.getJttw()) || (this.getJttw() != null
						&& castOther.getJttw() != null && this.getJttw()
						.equals(castOther.getJttw())))
				&& ((this.getJsny() == castOther.getJsny()) || (this.getJsny() != null
						&& castOther.getJsny() != null && this.getJsny()
						.equals(castOther.getJsny())))
				&& ((this.getJsdw() == castOther.getJsdw()) || (this.getJsdw() != null
						&& castOther.getJsdw() != null && this.getJsdw()
						.equals(castOther.getJsdw())))
				&& ((this.getCjcs() == castOther.getCjcs()) || (this.getCjcs() != null
						&& castOther.getCjcs() != null && this.getCjcs()
						.equals(castOther.getCjcs())))
				&& ((this.getSccs() == castOther.getSccs()) || (this.getSccs() != null
						&& castOther.getSccs() != null && this.getSccs()
						.equals(castOther.getSccs())))
				&& ((this.getCcrq() == castOther.getCcrq()) || (this.getCcrq() != null
						&& castOther.getCcrq() != null && this.getCcrq()
						.equals(castOther.getCcrq())))
				&& ((this.getAzrq() == castOther.getAzrq()) || (this.getAzrq() != null
						&& castOther.getAzrq() != null && this.getAzrq()
						.equals(castOther.getAzrq())))
				&& ((this.getBzqz() == castOther.getBzqz()) || (this.getBzqz() != null
						&& castOther.getBzqz() != null && this.getBzqz()
						.equals(castOther.getBzqz())))
				&& ((this.getLrr() == castOther.getLrr()) || (this.getLrr() != null
						&& castOther.getLrr() != null && this.getLrr().equals(
						castOther.getLrr())))
				&& ((this.getRksj() == castOther.getRksj()) || (this.getRksj() != null
						&& castOther.getRksj() != null && this.getRksj()
						.equals(castOther.getRksj())))
				&& ((this.getGxr() == castOther.getGxr()) || (this.getGxr() != null
						&& castOther.getGxr() != null && this.getGxr().equals(
						castOther.getGxr())))
				&& ((this.getGxsj() == castOther.getGxsj()) || (this.getGxsj() != null
						&& castOther.getGxsj() != null && this.getGxsj()
						.equals(castOther.getGxsj())))
				&& ((this.getGlbm() == castOther.getGlbm()) || (this.getGlbm() != null
						&& castOther.getGlbm() != null && this.getGlbm()
						.equals(castOther.getGlbm())))
				&& ((this.getXjzsbh() == castOther.getXjzsbh()) || (this
						.getXjzsbh() != null && castOther.getXjzsbh() != null && this
						.getXjzsbh().equals(castOther.getXjzsbh())))
				&& ((this.getYtHtbh() == castOther.getYtHtbh()) || (this
						.getYtHtbh() != null && castOther.getYtHtbh() != null && this
						.getYtHtbh().equals(castOther.getYtHtbh())))
				&& ((this.getJtHtbh() == castOther.getJtHtbh()) || (this
						.getJtHtbh() != null && castOther.getJtHtbh() != null && this
						.getJtHtbh().equals(castOther.getJtHtbh())))
				&& ((this.getGcbh() == castOther.getGcbh()) || (this.getGcbh() != null
						&& castOther.getGcbh() != null && this.getGcbh()
						.equals(castOther.getGcbh())))
				&& ((this.getJyrq() == castOther.getJyrq()) || (this.getJyrq() != null
						&& castOther.getJyrq() != null && this.getJyrq()
						.equals(castOther.getJyrq())))
				&& ((this.getYxqz() == castOther.getYxqz()) || (this.getYxqz() != null
						&& castOther.getYxqz() != null && this.getYxqz()
						.equals(castOther.getYxqz())))
				&& ((this.getJydw() == castOther.getJydw()) || (this.getJydw() != null
						&& castOther.getJydw() != null && this.getJydw()
						.equals(castOther.getJydw())))
				&& ((this.getZrrBm() == castOther.getZrrBm()) || (this
						.getZrrBm() != null && castOther.getZrrBm() != null && this
						.getZrrBm().equals(castOther.getZrrBm())))
				&& ((this.getZrrLxdh() == castOther.getZrrLxdh()) || (this
						.getZrrLxdh() != null && castOther.getZrrLxdh() != null && this
						.getZrrLxdh().equals(castOther.getZrrLxdh())))
				&& ((this.getZrrSjh() == castOther.getZrrSjh()) || (this
						.getZrrSjh() != null && castOther.getZrrSjh() != null && this
						.getZrrSjh().equals(castOther.getZrrSjh())))
				&& ((this.getSfwjbgd() == castOther.getSfwjbgd()) || (this
						.getSfwjbgd() != null && castOther.getSfwjbgd() != null && this
						.getSfwjbgd().equals(castOther.getSfwjbgd())))
				&& ((this.getPgisjd() == castOther.getPgisjd()) || (this
						.getPgisjd() != null && castOther.getPgisjd() != null && this
						.getPgisjd().equals(castOther.getPgisjd())))
				&& ((this.getPgiswd() == castOther.getPgiswd()) || (this
						.getPgiswd() != null && castOther.getPgiswd() != null && this
						.getPgiswd().equals(castOther.getPgiswd())))
				&& ((this.getGisjd() == castOther.getGisjd()) || (this
						.getGisjd() != null && castOther.getGisjd() != null && this
						.getGisjd().equals(castOther.getGisjd())))
				&& ((this.getGiswd() == castOther.getGiswd()) || (this
						.getGiswd() != null && castOther.getGiswd() != null && this
						.getGiswd().equals(castOther.getGiswd())))
				&& ((this.getLkxxid() == castOther.getLkxxid()) || (this
						.getLkxxid() != null && castOther.getLkxxid() != null && this
						.getLkxxid().equals(castOther.getLkxxid())))
				&& ((this.getLkxxwzx() == castOther.getLkxxwzx()) || (this
						.getLkxxwzx() != null && castOther.getLkxxwzx() != null && this
						.getLkxxwzx().equals(castOther.getLkxxwzx())))
				&& ((this.getLkxxwzy() == castOther.getLkxxwzy()) || (this
						.getLkxxwzy() != null && castOther.getLkxxwzy() != null && this
						.getLkxxwzy().equals(castOther.getLkxxwzy())))
				&& ((this.getDwxxid() == castOther.getDwxxid()) || (this
						.getDwxxid() != null && castOther.getDwxxid() != null && this
						.getDwxxid().equals(castOther.getDwxxid())))
				&& ((this.getFzid1() == castOther.getFzid1()) || (this
						.getFzid1() != null && castOther.getFzid1() != null && this
						.getFzid1().equals(castOther.getFzid1())))
				&& ((this.getFzid2() == castOther.getFzid2()) || (this
						.getFzid2() != null && castOther.getFzid2() != null && this
						.getFzid2().equals(castOther.getFzid2())))
				&& ((this.getFzid3() == castOther.getFzid3()) || (this
						.getFzid3() != null && castOther.getFzid3() != null && this
						.getFzid3().equals(castOther.getFzid3())))
				&& ((this.getFzid4() == castOther.getFzid4()) || (this
						.getFzid4() != null && castOther.getFzid4() != null && this
						.getFzid4().equals(castOther.getFzid4())))
				&& ((this.getFzid5() == castOther.getFzid5()) || (this
						.getFzid5() != null && castOther.getFzid5() != null && this
						.getFzid5().equals(castOther.getFzid5())))
				&& ((this.getFzid6() == castOther.getFzid6()) || (this
						.getFzid6() != null && castOther.getFzid6() != null && this
						.getFzid6().equals(castOther.getFzid6())))
				&& ((this.getFzid7() == castOther.getFzid7()) || (this
						.getFzid7() != null && castOther.getFzid7() != null && this
						.getFzid7().equals(castOther.getFzid7())))
				&& ((this.getFzid8() == castOther.getFzid8()) || (this
						.getFzid8() != null && castOther.getFzid8() != null && this
						.getFzid8().equals(castOther.getFzid8())))
				&& ((this.getFwqid() == castOther.getFwqid()) || (this
						.getFwqid() != null && castOther.getFwqid() != null && this
						.getFwqid().equals(castOther.getFwqid())))
				&& ((this.getBmcsid() == castOther.getBmcsid()) || (this
						.getBmcsid() != null && castOther.getBmcsid() != null && this
						.getBmcsid().equals(castOther.getBmcsid())))
				&& ((this.getTxzqjbxxid() == castOther.getTxzqjbxxid()) || (this
						.getTxzqjbxxid() != null
						&& castOther.getTxzqjbxxid() != null && this
						.getTxzqjbxxid().equals(castOther.getTxzqjbxxid())))
				&& ((this.getTxtjxxid() == castOther.getTxtjxxid()) || (this
						.getTxtjxxid() != null
						&& castOther.getTxtjxxid() != null && this
						.getTxtjxxid().equals(castOther.getTxtjxxid())))
				&& ((this.getLxccjhid() == castOther.getLxccjhid()) || (this
						.getLxccjhid() != null
						&& castOther.getLxccjhid() != null && this
						.getLxccjhid().equals(castOther.getLxccjhid())))
				&& ((this.getFwqdz() == castOther.getFwqdz()) || (this
						.getFwqdz() != null && castOther.getFwqdz() != null && this
						.getFwqdz().equals(castOther.getFwqdz())))
				&& ((this.getFfsfcg() == castOther.getFfsfcg()) || (this
						.getFfsfcg() != null && castOther.getFfsfcg() != null && this
						.getFfsfcg().equals(castOther.getFfsfcg())))
				&& ((this.getId() == castOther.getId()) || (this.getId() != null
						&& castOther.getId() != null && this.getId().equals(
						castOther.getId())))
				&& ((this.getDm() == castOther.getDm()) || (this.getDm() != null
						&& castOther.getDm() != null && this.getDm().equals(
						castOther.getDm())))
				&& ((this.getDy() == castOther.getDy()) || (this.getDy() != null
						&& castOther.getDy() != null && this.getDy().equals(
						castOther.getDy())))
				&& ((this.getSjdm() == castOther.getSjdm()) || (this.getSjdm() != null
						&& castOther.getSjdm() != null && this.getSjdm()
						.equals(castOther.getSjdm())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSxjid() == null ? 0 : this.getSxjid().hashCode());
		result = 37 * result
				+ (getXjbh() == null ? 0 : this.getXjbh().hashCode());
		result = 37 * result
				+ (getDbh() == null ? 0 : this.getDbh().hashCode());
		result = 37 * result
				+ (getXjmc() == null ? 0 : this.getXjmc().hashCode());
		result = 37 * result
				+ (getDwbh() == null ? 0 : this.getDwbh().hashCode());
		result = 37 * result
				+ (getJkcd() == null ? 0 : this.getJkcd().hashCode());
		result = 37 * result
				+ (getXjpp() == null ? 0 : this.getXjpp().hashCode());
		result = 37 * result
				+ (getXjxh() == null ? 0 : this.getXjxh().hashCode());
		result = 37 * result
				+ (getXjxslx() == null ? 0 : this.getXjxslx().hashCode());
		result = 37 * result
				+ (getXjlx() == null ? 0 : this.getXjlx().hashCode());
		result = 37 * result
				+ (getMac() == null ? 0 : this.getMac().hashCode());
		result = 37 * result
				+ (getIpdz() == null ? 0 : this.getIpdz().hashCode());
		result = 37 * result
				+ (getDkh() == null ? 0 : this.getDkh().hashCode());
		result = 37 * result
				+ (getDlyhm() == null ? 0 : this.getDlyhm().hashCode());
		result = 37 * result
				+ (getDlmm() == null ? 0 : this.getDlmm().hashCode());
		result = 37 * result
				+ (getWgdz() == null ? 0 : this.getWgdz().hashCode());
		result = 37 * result
				+ (getZxzt() == null ? 0 : this.getZxzt().hashCode());
		result = 37 * result
				+ (getBzSheng() == null ? 0 : this.getBzSheng().hashCode());
		result = 37 * result
				+ (getBzShi() == null ? 0 : this.getBzShi().hashCode());
		result = 37 * result
				+ (getBzXqq() == null ? 0 : this.getBzXqq().hashCode());
		result = 37 * result
				+ (getBzSdXzjd() == null ? 0 : this.getBzSdXzjd().hashCode());
		result = 37 * result
				+ (getBzDd() == null ? 0 : this.getBzDd().hashCode());
		result = 37 * result
				+ (getGbShengj() == null ? 0 : this.getGbShengj().hashCode());
		result = 37 * result
				+ (getGbShij() == null ? 0 : this.getGbShij().hashCode());
		result = 37 * result
				+ (getGbQuj() == null ? 0 : this.getGbQuj().hashCode());
		result = 37 * result
				+ (getGbJcdw() == null ? 0 : this.getGbJcdw().hashCode());
		result = 37 * result
				+ (getGbSshy() == null ? 0 : this.getGbSshy().hashCode());
		result = 37 * result
				+ (getGbWlbx() == null ? 0 : this.getGbWlbx().hashCode());
		result = 37 * result
				+ (getGbCjdw() == null ? 0 : this.getGbCjdw().hashCode());
		result = 37 * result
				+ (getJkfw() == null ? 0 : this.getJkfw().hashCode());
		result = 37 * result
				+ (getSfkk() == null ? 0 : this.getSfkk().hashCode());
		result = 37 * result + (getYt() == null ? 0 : this.getYt().hashCode());
		result = 37 * result
				+ (getAzwz() == null ? 0 : this.getAzwz().hashCode());
		result = 37 * result
				+ (getZgd() == null ? 0 : this.getZgd().hashCode());
		result = 37 * result
				+ (getLxjh() == null ? 0 : this.getLxjh().hashCode());
		result = 37 * result
				+ (getQybz() == null ? 0 : this.getQybz().hashCode());
		result = 37 * result
				+ (getSpxy() == null ? 0 : this.getSpxy().hashCode());
		result = 37 * result
				+ (getXjtdh() == null ? 0 : this.getXjtdh().hashCode());
		result = 37 * result
				+ (getXyyhm() == null ? 0 : this.getXyyhm().hashCode());
		result = 37 * result
				+ (getXymm() == null ? 0 : this.getXymm().hashCode());
		result = 37 * result
				+ (getZmlmllx() == null ? 0 : this.getZmlmllx().hashCode());
		result = 37 * result
				+ (getZmlurl() == null ? 0 : this.getZmlurl().hashCode());
		result = 37 * result
				+ (getZmlyp() == null ? 0 : this.getZmlyp().hashCode());
		result = 37 * result
				+ (getZmlljlx() == null ? 0 : this.getZmlljlx().hashCode());
		result = 37 * result
				+ (getZmlbmgs() == null ? 0 : this.getZmlbmgs().hashCode());
		result = 37 * result
				+ (getZmlfzgs() == null ? 0 : this.getZmlfzgs().hashCode());
		result = 37 * result
				+ (getZmlzdml() == null ? 0 : this.getZmlzdml().hashCode());
		result = 37 * result
				+ (getZmlzxml() == null ? 0 : this.getZmlzxml().hashCode());
		result = 37 * result
				+ (getZmljtfblk() == null ? 0 : this.getZmljtfblk().hashCode());
		result = 37 * result
				+ (getZmljtfblg() == null ? 0 : this.getZmljtfblg().hashCode());
		result = 37 * result
				+ (getZmlzl() == null ? 0 : this.getZmlzl().hashCode());
		result = 37 * result
				+ (getZmlgopms() == null ? 0 : this.getZmlgopms().hashCode());
		result = 37 * result
				+ (getZmlgopjg() == null ? 0 : this.getZmlgopjg().hashCode());
		result = 37 * result
				+ (getZimlmllx() == null ? 0 : this.getZimlmllx().hashCode());
		result = 37 * result
				+ (getZimlurl() == null ? 0 : this.getZimlurl().hashCode());
		result = 37 * result
				+ (getZimlyp() == null ? 0 : this.getZimlyp().hashCode());
		result = 37 * result
				+ (getZimlljlx() == null ? 0 : this.getZimlljlx().hashCode());
		result = 37 * result
				+ (getZimlbmgs() == null ? 0 : this.getZimlbmgs().hashCode());
		result = 37 * result
				+ (getZimlfzgs() == null ? 0 : this.getZimlfzgs().hashCode());
		result = 37 * result
				+ (getZimlzdml() == null ? 0 : this.getZimlzdml().hashCode());
		result = 37 * result
				+ (getZimlzxml() == null ? 0 : this.getZimlzxml().hashCode());
		result = 37
				* result
				+ (getZimljtfblk() == null ? 0 : this.getZimljtfblk()
						.hashCode());
		result = 37
				* result
				+ (getZimljtfblg() == null ? 0 : this.getZimljtfblg()
						.hashCode());
		result = 37 * result
				+ (getZimlzl() == null ? 0 : this.getZimlzl().hashCode());
		result = 37 * result
				+ (getZimlgopms() == null ? 0 : this.getZimlgopms().hashCode());
		result = 37 * result
				+ (getZimlgopjg() == null ? 0 : this.getZimlgopjg().hashCode());
		result = 37 * result
				+ (getJttw() == null ? 0 : this.getJttw().hashCode());
		result = 37 * result
				+ (getJsny() == null ? 0 : this.getJsny().hashCode());
		result = 37 * result
				+ (getJsdw() == null ? 0 : this.getJsdw().hashCode());
		result = 37 * result
				+ (getCjcs() == null ? 0 : this.getCjcs().hashCode());
		result = 37 * result
				+ (getSccs() == null ? 0 : this.getSccs().hashCode());
		result = 37 * result
				+ (getCcrq() == null ? 0 : this.getCcrq().hashCode());
		result = 37 * result
				+ (getAzrq() == null ? 0 : this.getAzrq().hashCode());
		result = 37 * result
				+ (getBzqz() == null ? 0 : this.getBzqz().hashCode());
		result = 37 * result
				+ (getLrr() == null ? 0 : this.getLrr().hashCode());
		result = 37 * result
				+ (getRksj() == null ? 0 : this.getRksj().hashCode());
		result = 37 * result
				+ (getGxr() == null ? 0 : this.getGxr().hashCode());
		result = 37 * result
				+ (getGxsj() == null ? 0 : this.getGxsj().hashCode());
		result = 37 * result
				+ (getGlbm() == null ? 0 : this.getGlbm().hashCode());
		result = 37 * result
				+ (getXjzsbh() == null ? 0 : this.getXjzsbh().hashCode());
		result = 37 * result
				+ (getYtHtbh() == null ? 0 : this.getYtHtbh().hashCode());
		result = 37 * result
				+ (getJtHtbh() == null ? 0 : this.getJtHtbh().hashCode());
		result = 37 * result
				+ (getGcbh() == null ? 0 : this.getGcbh().hashCode());
		result = 37 * result
				+ (getJyrq() == null ? 0 : this.getJyrq().hashCode());
		result = 37 * result
				+ (getYxqz() == null ? 0 : this.getYxqz().hashCode());
		result = 37 * result
				+ (getJydw() == null ? 0 : this.getJydw().hashCode());
		result = 37 * result
				+ (getZrrBm() == null ? 0 : this.getZrrBm().hashCode());
		result = 37 * result
				+ (getZrrLxdh() == null ? 0 : this.getZrrLxdh().hashCode());
		result = 37 * result
				+ (getZrrSjh() == null ? 0 : this.getZrrSjh().hashCode());
		result = 37 * result
				+ (getSfwjbgd() == null ? 0 : this.getSfwjbgd().hashCode());
		result = 37 * result
				+ (getPgisjd() == null ? 0 : this.getPgisjd().hashCode());
		result = 37 * result
				+ (getPgiswd() == null ? 0 : this.getPgiswd().hashCode());
		result = 37 * result
				+ (getGisjd() == null ? 0 : this.getGisjd().hashCode());
		result = 37 * result
				+ (getGiswd() == null ? 0 : this.getGiswd().hashCode());
		result = 37 * result
				+ (getLkxxid() == null ? 0 : this.getLkxxid().hashCode());
		result = 37 * result
				+ (getLkxxwzx() == null ? 0 : this.getLkxxwzx().hashCode());
		result = 37 * result
				+ (getLkxxwzy() == null ? 0 : this.getLkxxwzy().hashCode());
		result = 37 * result
				+ (getDwxxid() == null ? 0 : this.getDwxxid().hashCode());
		result = 37 * result
				+ (getFzid1() == null ? 0 : this.getFzid1().hashCode());
		result = 37 * result
				+ (getFzid2() == null ? 0 : this.getFzid2().hashCode());
		result = 37 * result
				+ (getFzid3() == null ? 0 : this.getFzid3().hashCode());
		result = 37 * result
				+ (getFzid4() == null ? 0 : this.getFzid4().hashCode());
		result = 37 * result
				+ (getFzid5() == null ? 0 : this.getFzid5().hashCode());
		result = 37 * result
				+ (getFzid6() == null ? 0 : this.getFzid6().hashCode());
		result = 37 * result
				+ (getFzid7() == null ? 0 : this.getFzid7().hashCode());
		result = 37 * result
				+ (getFzid8() == null ? 0 : this.getFzid8().hashCode());
		result = 37 * result
				+ (getFwqid() == null ? 0 : this.getFwqid().hashCode());
		result = 37 * result
				+ (getBmcsid() == null ? 0 : this.getBmcsid().hashCode());
		result = 37
				* result
				+ (getTxzqjbxxid() == null ? 0 : this.getTxzqjbxxid()
						.hashCode());
		result = 37 * result
				+ (getTxtjxxid() == null ? 0 : this.getTxtjxxid().hashCode());
		result = 37 * result
				+ (getLxccjhid() == null ? 0 : this.getLxccjhid().hashCode());
		result = 37 * result
				+ (getFwqdz() == null ? 0 : this.getFwqdz().hashCode());
		result = 37 * result
				+ (getFfsfcg() == null ? 0 : this.getFfsfcg().hashCode());
		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result + (getDm() == null ? 0 : this.getDm().hashCode());
		result = 37 * result + (getDy() == null ? 0 : this.getDy().hashCode());
		result = 37 * result
				+ (getSjdm() == null ? 0 : this.getSjdm().hashCode());
		return result;
	}

}