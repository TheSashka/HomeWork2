package io.byteio;

import java.io.*;
import java.util.*;

public class ByteIO
{
    private Set<String> keyWords;
    private StringBuilder temp;
    private File writeFile;
    private String filename;
    private Map<String, Integer> countOfKeyWords;

    public ByteIO(String filename)
    {
        countOfKeyWords = new HashMap<>();
        keyWords = new HashSet<>();
        init();
        this.filename = filename;
        writeFile = new File("./src/io/byteio/test.txt");
        temp = new StringBuilder();
    }


    private void init()
    {
        keyWords.add("abstract");
        keyWords.add("assert");
        keyWords.add("boolean");
        keyWords.add("break");
        keyWords.add("byte");
        keyWords.add("case");
        keyWords.add("catch");
        keyWords.add("char");
        keyWords.add("class");
        keyWords.add("continue");
        keyWords.add("default");
        keyWords.add("do");
        keyWords.add("double");
        keyWords.add("else");
        keyWords.add("enum");
        keyWords.add("extends");
        keyWords.add("final");
        keyWords.add("finally");
        keyWords.add("float");
        keyWords.add("for");
        keyWords.add("if");
        keyWords.add("implements");
        keyWords.add("import");
        keyWords.add("instanceof");
        keyWords.add("int");
        keyWords.add("interface");
        keyWords.add("long");
        keyWords.add("native");
        keyWords.add("new");
        keyWords.add("package");
        keyWords.add("private");
        keyWords.add("protected");
        keyWords.add("public");
        keyWords.add("return");
        keyWords.add("short");
        keyWords.add("static");
        keyWords.add("strictfp");
        keyWords.add("super");
        keyWords.add("switch");
        keyWords.add("synchronized");
        keyWords.add("this");
        keyWords.add("throw");
        keyWords.add("throws");
        keyWords.add("transient");
        keyWords.add("try");
        keyWords.add("void");
        keyWords.add("volatile");
        keyWords.add("while");
    }

    public void readFile(int value)
    {
        byte [] buffer = new byte[value];
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filename)))
        {
            int count = 0;
            while (bufferedInputStream.available() > 0)
            {
                if(bufferedInputStream.available() < 512)
                {
                    buffer = new byte[bufferedInputStream.available()];
                }
                bufferedInputStream.read(buffer);
                String test = new String(buffer);
                temp.append(test);
            }
            System.out.println(temp);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void showString()
    {
        Iterator<String> iterator = keyWords.iterator();
        while (iterator.hasNext())
        {
            String keyWork = iterator.next();
            if(countOfKeyWords.get(keyWork) != null)
            {
                System.out.println(keyWork + "\t" + countOfKeyWords.get(keyWork));
            }
        }
    }

    public void searchKeyWords()
    {
        Iterator<String> iterator = keyWords.iterator();
        while (iterator.hasNext())
        {
            int index = 0;
            int count = 0;
            String keyWord = iterator.next();
            while((index = temp.indexOf(keyWord)) != -1 )
            {
                if(keyWord.equals("do") && temp.charAt(index+keyWord.length()) == 'u')
                {
                    keyWord = "double";
                }
                count++;
                temp.delete(index, keyWord.length()+index);
            }
            if(count > 0)
            {
                countOfKeyWords.put(keyWord, count);
            }
        }
    }

    public void writeInFile()
    {
        try (FileOutputStream fileOutputStream = new FileOutputStream(writeFile))
        {
            Iterator<String> iterator = keyWords.iterator();
            while (iterator.hasNext())
            {
                String keyWord = iterator.next();
                if(countOfKeyWords.get(keyWord) != null)
                {
                    String keyVal = keyWord + "\t" + countOfKeyWords.get(keyWord) +"\n";
                    byte[] buffer = keyVal.getBytes();
                    fileOutputStream.write(buffer);
                }
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public static void main(String [] args)
    {
        ByteIO byteIO = new ByteIO("./src/io/byteio/test.java");
        byteIO.readFile(512);
        byteIO.searchKeyWords();
        byteIO.showString();
        byteIO.writeInFile();
    }
}
