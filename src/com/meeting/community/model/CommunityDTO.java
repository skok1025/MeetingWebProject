/**
 * 
 * tblCommunity DTO
 * @author 송미령
 * 
 */

package com.meeting.community.model;

public class CommunityDTO {

	private String seq;
	private String title;
	private String content;
	private String attach;
	private String image;
	private String kind;
	private String warning;
	private String readCount;
	private String regdate;
	private String cseq;
	private String ccseq;
	private String rnum;
	private String name;
	private String nick;
	private String id;
	private String orgfilename;
	
	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getWarning() {
		return warning;
	}

	public void setWarning(String warning) {
		this.warning = warning;
	}

	public String getReadCount() {
		return readCount;
	}

	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getCseq() {
		return cseq;
	}

	public void setCseq(String cseq) {
		this.cseq = cseq;
	}

	public String getCcseq() {
		return ccseq;
	}

	public void setCcseq(String ccseq) {
		this.ccseq = ccseq;
	}

	@Override
	public String toString() {
		return "CommunityDTO [seq=" + seq + ", title=" + title + ", content=" + content + ", attach=" + attach
				+ ", image=" + image + ", kind=" + kind + ", warning=" + warning + ", readCount=" + readCount
				+ ", regdate=" + regdate + ", cseq=" + cseq + ", ccseq=" + ccseq + "]";
	}

	public String getRnum() {
		return rnum;
	}

	public void setRnum(String rnum) {
		this.rnum = rnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getOrgfilename() {
		return orgfilename;
	}

	public void setOrgfilename(String orgfilename) {
		this.orgfilename = orgfilename;
	}

}
