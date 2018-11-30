package Week3;

import java.util.*;

public class Tester {
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }

    public void testLogAnalyzer() {
        // complete method
      LogAnalyzer la = new LogAnalyzer();

/*        la.readFile("weblog2_log");
       la.printAll();
        System.out.println();
        System.out.println("Number of unique IPs: " + la.countUniqueIPs());
        System.out.println();
        la.printAllHigherThanNum(400);
        System.out.println();

      System.out.println(la.uniqueIPVisitsOnDay("Sep 27").size());

        System.out.println("Number of unique IPs in the range: " + la.countUniqueIPsInrange(400,499));*/

     la.readFile("weblog2_log");
    /*    new HashMap<String, ArrayList<String>>();
        HashMap<String, Integer> uniqueIp = la.countVisitsPerIP();
        System.out.println(uniqueIp);
        System.out.println("Max number of visit form a single IP is: " + la.mostNumberVisitsByIP(uniqueIp));
       ArrayList<String> mostVisit = la.ipMostVisits(uniqueIp);
        System.out.println(mostVisit);*/
       HashMap<String, ArrayList<String>> ipDays = la.ipForDays();
        System.out.println(ipDays);
        System.out.println();
        System.out.println(la.dayWithMostIPVisits(ipDays));
       ArrayList<String> ipsWithmostVisit = la.iPsWithMostVisitsOnDay("Sep 30");
        System.out.println(ipsWithmostVisit);
    }

}