public class song{
    private String title;
    private String artist;
    private int id;
    
    public song(String title, String artist){
        this.title = title;
        this.artist = artist;

    }

    public song(){

    }

    public String getTitle(){
        return this.title;
    }

    public String getArtist(){
        return this.artist;

    }

    public void setID(int id){
        this.id = id;
    }

   public int getID(){
        return this.id;
   }


    
}