package Week3;

import java.util.ArrayList;
import java.util.Date;

import edu.duke.*;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        // complete constructor

        records = new ArrayList<>();
    }

    public void readFile(String filename) {
        // complete method
        FileResource fr = new FileResource(filename);
        for (String line : fr.lines()) {
            records.add(WebLogParser.parseEntry(line));
        }
    }

    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }

    public int countUniqueIPs() {
        ArrayList<String> uniqueIps = new ArrayList<>();
        for (LogEntry le : records) {
            String s = le.getIpAddress();
            if (!uniqueIps.contains(s)) {
                uniqueIps.add(s);
            }
        }
        return uniqueIps.size();
    }

    public void printAllHigherThanNum(int num) {
        for (LogEntry le : records) {
            int number = le.getStatusCode();
            if (number > num) {
                System.out.println(le);
            }
        }
    }

    public ArrayList<String> uniqueIPVisitsOnDay(String someday) {
        ArrayList<String> unique = new ArrayList<>();
        for (LogEntry le : records) {
            Date d = le.getAccessTime();
            String str = d.toString();
            if (str.contains(someday)) {
                String s = le.getIpAddress();
                if (!unique.contains(s)) {
                    unique.add(s);
                }
            }
        }
        return unique;
    }

    public int countUniqueIPsInrange(int low, int high) {
        ArrayList<String> unique = new ArrayList<>();
        for (LogEntry le : records) {
            int number = le.getStatusCode();
            if (number >= low && number <= high) {
                String s = le.getIpAddress();
                if (!unique.contains(s)) {
                    unique.add(s);
                }
            }

        }
        return unique.size();
    }


}
