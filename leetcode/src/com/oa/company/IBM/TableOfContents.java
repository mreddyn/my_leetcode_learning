package com.oa.company.IBM;

import java.util.ArrayList;
import java.util.List;

public class TableOfContents {
    private List<String> generateTableOfContents(String[] text) {
        List<String> toc = new ArrayList<>();
        int chapterNumber = 0;
        int sectionNumber = 0;
        for (String line : text) {
            if (line.startsWith("# ")) {
                chapterNumber++;
                sectionNumber = 0;
                toc.add(chapterNumber + ". " + line.substring(2));
            } else if (line.startsWith("## ")) {
                sectionNumber++;
                toc.add(chapterNumber + "." + sectionNumber + ". " + line.substring(3));
            }
        }
        return toc;
    }

    public static void main(String[] args) {
        TableOfContents tableOfContents = new TableOfContents();
        String[] text = {
                "# Algorithms",
                "This chapter covers the most basic algorithms.",
                "## Sorting",
                "Quicksort is fast and widely used in practice",
                "Merge sort is a deterministic algorithm",
                "## Searching",
                "DFS and BFS are widely used graph searching algorithms",
                "Some variants of DFS are also used in game theory applications",
                "# Data Structures",
                "This chapter is all about data structures",
                "It's a draft for now and will contain more sections in the future",
                "# Binary Search Trees"
        };
        List<String> toc = tableOfContents.generateTableOfContents(text);
        for (String entry : toc) {
            System.out.println(entry);
        }
    }
}
