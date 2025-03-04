import java.io.*;
import java.util.*;

public class FileHan {
    private static final String LIBRARY_FILE = "music_library.txt";
    private static final String PLAYLIST_FILE = "playlists.txt";

    // Save music library to file
    public static void saveLibrary(List<Song> musicLibrary) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(LIBRARY_FILE))) {
            oos.writeObject(musicLibrary);
        } catch (IOException e) {
            System.out.println("❌ Error saving music library.");
        }
    }

    // Load music library from file
    public static List<Song> loadLibrary() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(LIBRARY_FILE))) {
            return (List<Song>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    // Save playlists to file
    public static void savePlaylists(Map<String, List<Song>> playlists) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PLAYLIST_FILE))) {
            oos.writeObject(playlists);
        } catch (IOException e) {
            System.out.println("❌ Error saving playlists.");
        }
    }

    // Load playlists from file
    public static Map<String, List<Song>> loadPlaylists() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PLAYLIST_FILE))) {
            return (Map<String, List<Song>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }
}
