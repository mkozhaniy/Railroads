package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * @author Максим Кожуховский
 * mail: m.kozhukhovskii@g.nsu.ru
 * */

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(Path.of("tests.txt"), StandardCharsets.UTF_8);
        PrintWriter out = new PrintWriter("out.txt", StandardCharsets.UTF_8);
        int n;

        while (in.hasNextInt()) {
            n = in.nextInt();
            int[] seq = new int[n];
            while (in.hasNextInt()) {
                seq[0] = in.nextInt();
                if (seq[0] == 0) {
                    out.write("\n");
                    break;
                }

                for (int i = 1; i < n; ++i) {
                    seq[i] = in.nextInt();
                }

                if (possible(seq, n)) out.write("Yes\n");
                else out.write("No\n");

            }
        }
        out.flush();
    }

    public static boolean possible(int[] seq, int n) {
        int start = 1;
        while (start == seq[start - 1] && start < n) ++start;
        int curr = start - 1;

        for (int i = n; i > start; --i) {
            if (seq[curr] != i) return false;
            ++curr;
        }
        return true;
    }
}
