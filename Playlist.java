import java.util.*;

public class Playlist {
    private List<Song> musicLibrary;
    private Map<String, List<Song>> playlists;
    private Scanner sc;

    public Playlist() {
        this.musicLibrary = FileHandler.loadLibrary();
        this.playlists = FileHandler.loadPlaylists();
        this.sc = new Scanner(System.in);
    }

    public void addSongToLibrary() {
        System.out.print("Enter song title: ");
        String title = sc.nextLine();
        System.out.print("Enter artist name: ");
        String artist = sc.nextLine();
        System.out.print("Enter genre: ");
        String genre = sc.nextLine();

        musicLibrary.add(new Song(title, artist, genre));
        FileHandler.saveLibrary(musicLibrary);
        System.out.println("✅ Song Added to Library!");
    }

    public void createPlaylist() {
        System.out.print("Enter playlist name: ");
        String name = sc.nextLine();
        if (playlists.containsKey(name)) {
            System.out.println("❌ Playlist already exists.");
        } else {
            playlists.put(name, new ArrayList<>());
            FileHandler.savePlaylists(playlists);
            System.out.println("✅ Playlist Created!");
        }
    }

    public void addSongToPlaylist() {
        if (musicLibrary.isEmpty()) {
            System.out.println("🎶 No songs available in library! Add songs first.");
            return;
        }

        viewSongs();
        System.out.print("Enter song number to add: ");
        int songIndex = sc.nextInt() - 1;
        sc.nextLine();

        if (songIndex < 0 || songIndex >= musicLibrary.size()) {
            System.out.println("❌ Invalid song number.");
            return;
        }

        System.out.print("Enter playlist name: ");
        String playlistName = sc.nextLine();

        if (!playlists.containsKey(playlistName)) {
            System.out.println("❌ Playlist does not exist.");
            return;
        }

        playlists.get(playlistName).add(musicLibrary.get(songIndex));
        FileHandler.savePlaylists(playlists);
        System.out.println("✅ Song Added to Playlist!");
    }

    public void removeSongFromPlaylist() {
        System.out.print("Enter playlist name: ");
        String playlistName = sc.nextLine();

        if (!playlists.containsKey(playlistName) || playlists.get(playlistName).isEmpty()) {
            System.out.println("❌ Playlist is empty or does not exist.");
            return;
        }

        List<Song> selectedPlaylist = playlists.get(playlistName);
        for (int i = 0; i < selectedPlaylist.size(); i++) {
            System.out.println((i + 1) + ". " + selectedPlaylist.get(i));
        }

        System.out.print("Enter song number to remove: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < selectedPlaylist.size()) {
            selectedPlaylist.remove(index);
            FileHandler.savePlaylists(playlists);
            System.out.println("✅ Song Removed from Playlist!");
        } else {
            System.out.println("❌ Invalid song number.");
        }
    }

    public void viewPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("No playlists available.");
            return;
        }

        System.out.println("\n📂 Playlists:");
        for (String name : playlists.keySet()) {
            System.out.println("🎶 " + name + " (" + playlists.get(name).size() + " songs)");
        }
    }

    public void playSongs() {
        System.out.print("Enter playlist name to play: ");
        String playlistName = sc.nextLine();

        if (!playlists.containsKey(playlistName) || playlists.get(playlistName).isEmpty()) {
            System.out.println("❌ Playlist is empty or does not exist.");
            return;
        }

        System.out.println("\n🎵 Now Playing:");
        for (Song song : playlists.get(playlistName)) {
            System.out.println("🎶 " + song);
        }
    }

    public void shufflePlay() {
        System.out.print("Enter playlist name for shuffle play: ");
        String playlistName = sc.nextLine();

        if (!playlists.containsKey(playlistName) || playlists.get(playlistName).isEmpty()) {
            System.out.println("❌ Playlist is empty or does not exist.");
            return;
        }

        List<Song> shuffledList = new ArrayList<>(playlists.get(playlistName));
        Collections.shuffle(shuffledList);

        System.out.println("\n🔀 Shuffle Play:");
        for (Song song : shuffledList) {
            System.out.println("🎶 " + song);
        }
    }

    private void viewSongs() {
        System.out.println("\n📀 Available Songs:");
        for (int i = 0; i < musicLibrary.size(); i++) {
            System.out.println((i + 1) + ". " + musicLibrary.get(i));
        }
    }
}
