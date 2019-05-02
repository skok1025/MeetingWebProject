package com.meeting.courtship.model;

public class ProfileImagesDTO {
   
   private String seq;
   private String cseq;
   private String img1;
   private String img2;
   private String img3;
   private String img4;
   private String img5;
   public String getSeq() {
      return seq;
   }
   public void setSeq(String seq) {
      this.seq = seq;
   }
   public String getCseq() {
      return cseq;
   }
   public void setCseq(String cseq) {
      this.cseq = cseq;
   }
   public String getImg1() {
      return img1;
   }
   public void setImg1(String img1) {
      this.img1 = img1;
   }
   public String getImg2() {
      return img2;
   }
   public void setImg2(String img2) {
      this.img2 = img2;
   }
   public String getImg3() {
      return img3;
   }
   public void setImg3(String img3) {
      this.img3 = img3;
   }
   public String getImg4() {
      return img4;
   }
   public void setImg4(String img4) {
      this.img4 = img4;
   }
   public String getImg5() {
      return img5;
   }
   public void setImg5(String img5) {
      this.img5 = img5;
   }
   @Override
   public String toString() {
      return "ProfileImagesDTO [seq=" + seq + ", cseq=" + cseq + ", img1=" + img1 + ", img2=" + img2 + ", img3="
            + img3 + ", img4=" + img4 + ", img5=" + img5 + "]";
   }
   
   
   

}