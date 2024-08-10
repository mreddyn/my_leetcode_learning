package com.company.confluent;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//  implement tail -n 100, view the last 100 lines of a static file,
// If the file is very large and the number of lines read is also
// very large and cannot be stored in the memory, how can I optimize it?
public class TailFileReader {

    public static void main(String[] args) {
        TailFileReader tf = new TailFileReader();
        System.out.println(tf.readLastNLines("/Users/chakradhar/Desktop/test.txt", 1));
    }


    public static List<String> readLastNLines(String fileName, int numberOfLines) {
        List<String> result = new ArrayList<>();
        try (RandomAccessFile fileAccess = new RandomAccessFile(fileName, "r")) {
            long fileLength = fileAccess.length() - 1;
            StringBuilder lineBuilder = new StringBuilder();

            // Start from the end of the file and move backwards
            for (long filePointer = fileLength; filePointer != -1; filePointer--) {
                fileAccess.seek(filePointer);
                char readChar = (char) fileAccess.readByte();

                if (readChar == '\n') {
                    // Check if the new line is complete (not the very end of the file)
//                    if (filePointer < fileLength) {
                    result.add(lineBuilder.reverse().toString());
                    lineBuilder.setLength(0);
                    if (result.size() == numberOfLines) {
                        break;
                    }
//                    }
                } else/* if (readChar != '\r')*/ {
                    // Include only valid text characters in the line
                    lineBuilder.append(readChar);
                }
            }

            if (lineBuilder.length() > 0) {
                result.add(lineBuilder.reverse().toString());
            }
            Collections.reverse(result);
            return result;
        } catch (Exception ex) {
            System.err.println("Error reading file: " + ex.getMessage());
        }
        return null;
    }

    public static void readLastNLinesFollowUp(String filename, int numLines) throws IOException {
        Path tempFile = Files.createTempFile("lastLines", ".txt");
        try (RandomAccessFile fileAccess = new RandomAccessFile(filename, "r");
             RandomAccessFile tempFileAccess = new RandomAccessFile(tempFile.toFile(), "rw")) {

            long fileLength = fileAccess.length() - 1;
            long tempFilePointer = 0;
            StringBuilder lineBuilder = new StringBuilder();
            int linesCount = 0;

            for (long pos = fileLength; pos >= 0; pos--) {
                fileAccess.seek(pos);
                char readChar = (char) fileAccess.read();

                if (readChar == '\n') {
//                    if (lineBuilder.length() > 0) {
                    linesCount++;
                    lineBuilder.reverse();
                    tempFileAccess.seek(tempFilePointer);
                    tempFileAccess.writeBytes(lineBuilder.toString() + System.lineSeparator());
                    tempFilePointer = tempFileAccess.getFilePointer();
                    lineBuilder.setLength(0);

                    if (linesCount == numLines) {
                        break;
                    }
//                    }
                } else if (readChar != '\r') {
                    lineBuilder.append(readChar);
                }
            }
            printTempFile(tempFile);
        }
    }

    private static void printTempFile(Path tempFile) throws IOException {
        try (RandomAccessFile tempFileAccess = new RandomAccessFile(tempFile.toFile(), "r")) {
            String line;
            while ((line = tempFileAccess.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static String readLastLine(File file) throws IOException {
        try (RandomAccessFile fileAccess = new RandomAccessFile(file, "r")) {
            long fileLength = fileAccess.length() - 1;
            StringBuilder lineBuilder = new StringBuilder();

            for (long filePointer = fileLength; filePointer != -1; filePointer--) {
                fileAccess.seek(filePointer);
                char readChar = (char) fileAccess.readByte();

                // Check if the read character is a newline or carriage return
                if (readChar == '\n' || readChar == '\r') {
                    if (filePointer < fileLength) {
                        break;
                    }
                } else {
                    lineBuilder.append(readChar);
                }
            }
            // Reverse the line (because it was read from end to start)
            return lineBuilder.reverse().toString();
        }
    }

    void readLastNLinesBruteForce(String fileName, int numLines) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            LinkedList<String> lines = new LinkedList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
                if (lines.size() > numLines) {
                    lines.poll(); // Keep only the last 'numLines'
                }
            }

            // Print the contents of the queue
            lines.forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(2);
        }
    }
}
