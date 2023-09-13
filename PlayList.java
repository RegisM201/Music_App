import java.util.ArrayList;

public class PlayList {
    private int id;

    private String title;
    static ArrayList<song> songs = new ArrayList<>();

    public PlayList(String title){
        this.title = title;
        
    }

    public String getTitle(){
        return this.title;
    }

    public int size(){
        return songs.size();
    }

    public void remove(int index){
        songs.remove(index);
    }

    public song get(int index){
        return songs.get(index);
    }

    public void addSong(song Song){
        
        songs.add(Song);
        Song.setID(songs.size());

    }

    public String getSongTitle(){
        return songs.get(1).getTitle();
    }

    public String getSongArtist(){
        return songs.get(1).getArtist();
    }

    

    public void open(){
        if(songs.isEmpty()){
            System.out.println("PlayList is Empty");
        }
        for(int i = 0; i < songs.size(); i++){
            System.out.println(songs.get(i).getID() + ": " + songs.get(i).getTitle() + "   " + songs.get(i).getArtist());
        }
    }

    public Boolean isEmpty(){
        if(songs.isEmpty()){
            return true;
        }
        return false;

        
    }
}
