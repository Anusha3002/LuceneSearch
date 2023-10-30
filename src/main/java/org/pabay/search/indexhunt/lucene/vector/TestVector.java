package org.pabay.search.indexhunt.lucene.vector;

public class TestVector {


    public static void main(String args[]) {

        try {
            java.io.InputStream in = null;
            java.io.OutputStream out = null;
            // create a new array of 2 strings
            String[] cmdArray = new String[2];

            // first argument is the program we want to open
            cmdArray[0] = "org.apache.lucene.demo.IndexFiles";

            // second argument is a txt file we want to open with notepad
            cmdArray[1] = "-docs E:\\www\\git\\lucene\\test";

            // print a message
            System.out.println("Executing notepad.exe and opening example.txt");

            // create a process and execute cmdArray and currect environment
            Process process = Runtime.getRuntime().exec(cmdArray,null);

            // print another message
            System.out.println("example.txt should now open.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
