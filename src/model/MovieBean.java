package model;

public class MovieBean {

   private int mvid;         // ��ȭ ������ȣ
   private String mname;      // ��ȭ ����
   private String opendate;   // �󿵳�¥
   private String director;   // ����
   private String genre;      // �帣
   private int playingtime;   // �󿵽ð�
   private String story;      // ���丮
   private String rating;      //�󿵵��
   private String distributor;   //��޻�
   private String actor;      //���
   private int condition;      //��ȭ�ǻ��� (�󿵿���0, ����1, �󿵳�2)
   private String StringImage;      //��ȭ �̹��� ���� �̸�
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