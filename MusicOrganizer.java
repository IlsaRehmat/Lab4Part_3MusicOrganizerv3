import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
/* Part 3 questions
 * Question 24
 * public void listAllFiles() {
    int position = 0;
    for (String file : files) {
        System.out.println(position + ": " + file);
        position++;
    }
}
 * 
 * Question 28
 * 
 * for (Track track : tracks) {
 *     // Loop body (process each track here)
 }
 * 
 * Question 29
 * 
 * boolean found = false;
 * while (!found) {
 *     if (the keys are in the next place) {
 *         found = true;
 *     }
 *}
 *
 * Question 30
 * 
 * public void multiplesOfFive() {
 *     int num = 10;
 *     while (num <= 95) {
 *         System.out.println(num)
 *         num += 5;
 *     }
 * }
 * 
 * Question 31
 * 
 * public void sumNumbers() {
 *     int sum = 0;
 *     int num = 1;
 *     while (num <= 10) {
 *         sum += num;
 *         num++;
 *     }
 *     System.out.println("Sum: " + sum);
 * }
 * 
 * Question 32
 * 
 * public int sum( int a, int b) {
 *     int sum = 0;
 *     while (a <= b) {
 *         sum += a;
 *         a++;
 *     }
 *     return sum;
 * }
 * 
 * 
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        for(String filename : files) {
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(validIndex(index)) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            player.startPlaying(filename);
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Play a file in the collection. Only return once playing has finished.
     * @param index The index of the file to be played.
     */
    public void playAndWait(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            player.playSample(filename);
        }
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;
        
        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= files.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }
     
    /**
     * List the names of files matching the given search string.
     * @param searchString The string to match.
     */
    
    // Question 26

    public void listMatching(String searchString)
    {
    for(String filename : files) {
        boolean foundMatch = false; //Declare a boolean variable to track if a match is found
        if(filename.contains(searchString)){
            // A match.
            System.out.println("Found match :" + filename);
            foundMatch = true; //Set to true if a match is found
        }
        
        if (!foundMatch) {
        System.out.println("No files matched the search string.");
        }
    }
}
}