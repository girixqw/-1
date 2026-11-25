import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Послпоиск.txt"));
        br.readLine(); // служебная строка

        ArrayList<Long> list = new ArrayList<>();
        String s;
        int count = 0;

        while ((s = br.readLine()) != null && count < 10000) {
            s = s.trim();
            if (s.isEmpty()) continue;

            String[] p = s.split("\\s+");
            if (p.length == 2) {
                list.add(Long.parseLong(p[0]));
                list.add(Long.parseLong(p[1]));
                count++;
            }
        }
        br.close();

        long min = Long.MAX_VALUE;

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                long pr = list.get(i) * list.get(j);
                if (pr % 21 == 0 && pr < min) {
                    min = pr;
                }
            }
        }

        if (min == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}