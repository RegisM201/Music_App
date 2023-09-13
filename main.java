import java.util.ArrayList;
import java.util.Scanner;

public class main{
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args){
        ArrayList <PlayList> List = new ArrayList<>();
        

        welcomeScreen(List);

    }

 
    public static void welcomeScreen(ArrayList<PlayList> List){
        System.out.println("What would you like to do?");
        System.out.println("1:select playlist  2:create playlist  3:delete playlist\n");

            if(List.isEmpty()){
                System.out.println("No Playlists");
                
            }
            else{
                System.out.println("\nPlayLists:\n");
                for(int i = 0; i < List.size(); i++)
                System.out.println(i + ": " + List.get(i).getTitle()); 
            }

            int choice = input.nextInt();

            if(choice == 1){
                if(List.isEmpty()){
                    System.out.println("No Playlists");
                    welcomeScreen(List);
                }
                else{
                    listSelector(List);
                }
            }
            else if(choice == 2){
                playListCreator(List);

            }
            else if(choice == 3){
                if(List.isEmpty()){
                    System.out.println("No Playlists");
                    welcomeScreen(List);
                }
                else{
                    listDeleter(List);
                }
            }
            else{
                System.out.println("invalid input");
                welcomeScreen(List);
            }

        
        
    }

    public static void listSelector(ArrayList <PlayList> List){
        for(int i = 0; i < List.size(); i++)
            System.out.println(i + ":" + List.get(i).getTitle()); 
        System.out.println("Select the number of the playList you would like to open");
        int choice = input.nextInt();
        if(choice < 0 || choice > List.size()-1){
            System.out.println("invalid playlist");
            listSelector(List);
        }
        else{
            openPlaylist(List.get(choice), List);
            
        }
    }

    public static void playListCreator(ArrayList<PlayList> List){
        System.out.println("Name your playlist: ");
        input.nextLine();
        String choice = input.nextLine();

        PlayList play = new PlayList(choice);
        List.add(play);
        System.out.println("PlayList Created");
        welcomeScreen(List);

    }

    public static void listDeleter(ArrayList <PlayList> List){
        for(int i = 0; i < List.size(); i++)
            System.out.println(i + ":" + List.get(i).getTitle()); 
        System.out.println("Select the number of the playList you would like to delete");
        int choice = input.nextInt();
        if(choice < 0 || choice > List.size()-1){
            System.out.println("invalid playlist");
            listDeleter(List);
        }
        else{
            List.remove(choice);
            welcomeScreen(List);
        }
    }

    public static void openPlaylist(PlayList play,ArrayList <PlayList> List ){
        System.out.println("What would you like to do\n");
        System.out.println("1:add song   2:delete song   3:play playList   4:PlayLists");
        System.out.println("current playlist: " + play.getTitle() + "\n");

        play.open();

        
        int choice = input.nextInt();

        if(choice == 1){
            addSong(play, List);
        }
        else if(choice == 2){
            if(play.isEmpty()){
                    System.out.println("No Songs in Playlist");
                    openPlaylist(play, List);
                }
                else{
                    songDeleter(play, List);
                };
        }
        else if(choice == 3){
            if(play.isEmpty()){
                System.out.println("No songs to play");
                openPlaylist(play,List);
            }
            else{
                playing(play);
            }
        }
        else if(choice == 4){
            welcomeScreen(List);
        }
        else{
            System.out.println("invalid input");
            openPlaylist(play, List);
        }




    }

    public static void addSong(PlayList play, ArrayList <PlayList> List){
        System.out.println("input name of song: ");
        
        String choice1 = input.nextLine();
        input.nextLine();
        
        System.out.println("input name of artist: ");
        
        String choice2 = input.nextLine();

        if(!existing(play, choice1, choice2)){

            song addition = new song(choice1, choice2);
            play.addSong(addition);
            System.out.println("Song added");
            openPlaylist(play, List);
        }
        else{
            System.out.println("Song is already in Playlist");
            openPlaylist(play, List);
        }
    
    }

    public static Boolean existing(PlayList play, String name, String artist){
        for(int i = 0; i < play.size(); i++){
            if(play.get(i).getTitle().equals(name) && play.get(i).getArtist().equals(artist)){
                return true;
            }
        }
        return false;
    }

    public static void songDeleter(PlayList play, ArrayList <PlayList> List){
        play.open();
        System.out.print("Select song number to delete: ");
        
        int choice = input.nextInt();

        if(choice < 0 || choice > play.size() - 1){
            System.out.println("Invalid input");
            songDeleter(play,List);
        }
        else{
            play.remove(choice);
            System.out.println("song removed");
            openPlaylist(play,List);
        }
    }

    public static void playing(PlayList play){
        System.out.print("Now playing " + play.getSongTitle() + " by " + play.getSongArtist());
    }
}