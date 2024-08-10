package com.company.confluent;

import java.util.*;

// https://leetcode.com/discuss/interview-question/1878821/confluent-onsite-search-phrase-in-document

public class PhraseSearchNew {


    private Map<String, Set<Pair>> buildInvertedIndex(List<Doc> docs) {
        Map<String, Set<Pair>> invertedIndex = new HashMap<>();
        for (Doc doc : docs) {
            String[] words = doc.text.toLowerCase().split("\\s+");  // split on one or more spaces
            for (int idx = 0; idx < words.length; idx++) {
                invertedIndex.computeIfAbsent(words[idx], k -> new HashSet<>()).add(new Pair(doc.docID, idx));
            }
        }
        return invertedIndex;
    }

    // o(p*a + d*l) , where p is phrase words length, a is number of documents that contains the phrases.
    // d is no do docs, each doc has l words.
    Set<Integer> search(List<Doc> docs, String phrase) {
        Set<Integer> res = new HashSet<>();
        if (phrase == null || phrase.length() == 0) {
            return res;
        }
        // Build inverted index with position
        Map<String, Set<Pair>> invertedIndex = buildInvertedIndex(docs);
        String[] phraseWords = phrase.toLowerCase().split(" ");
        Set<Pair> candidates = invertedIndex.getOrDefault(phraseWords[0], new HashSet<>());
        for (int i = 1; i < phraseWords.length; i++) {
            Set<Pair> phraseWordIdx = invertedIndex.getOrDefault(phraseWords[i], new HashSet<>());
            Set<Pair> newCandidates = new HashSet<>();
            for (Pair pair : candidates) {
                Pair nextWordIdx = new Pair(pair.docID, pair.idx + 1);
                if (phraseWordIdx.contains(nextWordIdx)) {
                    newCandidates.add(nextWordIdx);
                }
            }
            candidates = newCandidates;
        }
        Set<Integer> matchingDocuments = new HashSet<>();
        for (Pair candidate : candidates) {
            matchingDocuments.add(candidate.docID);
        }
        return matchingDocuments;
    }

    static Set<Integer> phraseSingleSearch(List<Doc> docs, String searchWord) {
        Map<String, Set<Integer>> invertedIndex = new HashMap<>();
        searchWord = searchWord.toLowerCase();
        for (Doc doc : docs) {
            String[] words = doc.text.toLowerCase().split("\\s+");
            for (int idx = 0; idx < words.length; idx++) {
                invertedIndex.computeIfAbsent(words[idx], k -> new HashSet<>()).add(doc.docID);
            }
        }
        if (invertedIndex.containsKey(searchWord)) {
            return invertedIndex.get(searchWord);
        }
        return null;
    }

    public static void main(String[] args) {
        List<Doc> docs = Arrays.asList(
                new Doc(1, "Cloud computing is the on-demand availability of computer system resources."),
                new Doc(2, "One integrated service for metrics uptime cloud monitoring dashboards and alerts reduces time spent navigating between systems."),
                new Doc(3, "Monitor entire cloud infrastructure, whether in the cloud computing is or in virtualized data centers.")
        );

        PhraseSearchNew psn = new PhraseSearchNew();
//        System.out.println(psn.search(docs, "Cloud computing is"));
        System.out.println(psn.search(docs, "Cloud monitoring"));
    }

}

 class Pair {
    int docID;
    int idx;

    Pair(int docID, int idx) {
        this.docID = docID;
        this.idx = idx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return docID == pair.docID && idx == pair.idx;
    }

    @Override
    public int hashCode() {
        return Objects.hash(docID, idx);
    }
}

class Doc {
    int docID;
    String text;

    Doc(int docID, String text) {
        this.docID = docID;
        this.text = text;
    }
}

// DocID                   Content

// 1                            Cloud Computing is booming in the market

// 2                            I am going to introduce what is Cloud Monitoring in following

//                               paragraphs. I have been working in cloud industry for 10 years.

// 3                           Scientist has investigated Venus Monitoring Camera images and try to

//                              identify the possibility of bacteria living in cloud tops.

// List<Long> search(String word)

// For example,
// search(“cloud”) -> [1, 2, 3]
// search(“monitoring”) -> [2, 3]

// List<DocID> search(String phrase)

// For example,
// search (“cloud monitoring”) -> [2]