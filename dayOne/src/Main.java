import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final Pattern pat = Pattern.compile("\\d+");

    public static void main(String[] args) {
        int numbers = 0;

        try(BufferedReader reader = new BufferedReader(new FileReader("dayOne/src/input.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                Integer res = findMatches(line);
                System.out.println("Matches for: " + line + " are " + res );
                 numbers += res;
            }
            System.out.println("Final res: "+  numbers);
        } catch (IOException e){
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static Integer findMatches(String string){
        ArrayList<String> matches = new ArrayList<>();
        Matcher matcher = pat.matcher(string);

        while(matcher.find()){
            if(matches.size() < 2){
                matches.add(matcher.group());
            } else {
                matches.set(1, matcher.group());
            }
        }

        if(matches.size() == 2){
            return Integer.valueOf(String.join("", matches));
        }

        return Integer.valueOf(matches.get(0) + matches.get(0));
    }
}