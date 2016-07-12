package model;

public class MovieBean {

   private int mvid;         // 영화 고유번호
   private String mname;      // 영화 제목
   private String opendate;   // 상영날짜
   private String director;   // 감독
   private String genre;      // 장르
   private int playingtime;   // 상영시간
   private String story;      // 스토리
   private String rating;      //상영등급
   private String distributor;   //배급사
   private String actor;      //배우
   private int condition;      //영화의상태 (상영예정0, 상영중1, 상영끝2)
   private String StringImage;      //영화 이미지 파일 이름
   public int getMvid() {
      return mvid;
   }
   public String getMname() {
      return mname;
   }
   public String getOpendate() {
      return opendate;
   }
   public String getDirector() {
      return director;
   }
   public String getGenre() {
      return genre;
   }
   public int getPlayingtime() {
      return playingtime;
   }
   public String getStory() {
      return story;
   }
   public String getRating() {
      return rating;
   }
   public String getDistributor() {
      return distributor;
   }
   public String getActor() {
      return actor;
   }
   public int getCondition() {
      return condition;
   }
   public String getStringImage() {
      return StringImage;
   }
   public void setMvid(int mvid) {
      this.mvid = mvid;
   }
   public void setMname(String mname) {
      this.mname = mname;
   }
   public void setOpendate(String opendate) {
      this.opendate = opendate;
   }
   public void setDirector(String director) {
      this.director = director;
   }
   public void setGenre(String genre) {
      this.genre = genre;
   }
   public void setPlayingtime(int playingtime) {
      this.playingtime = playingtime;
   }
   public void setStory(String story) {
      this.story = story;
   }
   public void setRating(String rating) {
      this.rating = rating;
   }
   public void setDistributor(String distributor) {
      this.distributor = distributor;
   }
   public void setActor(String actor) {
      this.actor = actor;
   }
   public void setCondition(int condition) {
      this.condition = condition;
   }
   public void setStringImage(String stringImage) {
      StringImage = stringImage;
   }
   @Override
   public String toString() {
      return "MovieBean [mvid=" + mvid + ", mname=" + mname + ", opendate=" + opendate + ", director=" + director
            + ", genre=" + genre + ", playingtime=" + playingtime + ", story=" + story + ", rating=" + rating
            + ", distributor=" + distributor + ", actor=" + actor + ", condition=" + condition + ", StringImage="
            + StringImage + "]";
   }
}