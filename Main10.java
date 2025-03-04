import java.util.Scanner;

public class Main10 {
    private static Playlist playlist = new Playlist();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🎵 Welcome to Music Playlist Manager 🎵");

        while (true) {
            System.out.println("\n1. Add Song to Library");
            System.out.println("2. Create Playlist");
            System.out.println("3. Add Song to Playlist");
            System.out.println("4. Remove Song from Playlist");
            System.out.println("5. View Playlists");
            System.out.println("6. Play Songs");
            System.out.println("7. Shuffle Play");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    playlist.addSongToLibrary();
                    break;
                case 2:
                    playlist.createPlaylist();
                    break;
                case 3:
                    playlist.addSongToPlaylist();
                    break;
                case 4:
                    playlist.removeSongFromPlaylist();
                    break;
                case 5:
                    playlist.viewPlaylists();
                    break;
                case 6:
                    playlist.playSongs();
                    break;
                case 7:
                    playlist.shufflePlay();
                    break;
                case 8:
                    System.out.println("Exiting... Enjoy your music! 🎶");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}
