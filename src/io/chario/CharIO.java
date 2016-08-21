package io.chario;


import java.io.*;
import java.util.*;

public class CharIO
{
    private String filename;
    private Set<String> keyWords;
    private Map<String, Integer> countOfKeyWords;
    private StringBuilder stringBuilder;

    CharIO(String filename)
    {
        stringBuilder = new StringBuilder();
        this.filename = filename;
        countOfKeyWords = new HashMap<>();
        keyWords = new HashSet<>();
        init();

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

    public void searchKeyWords()
    {
        Iterator<String> iterator = keyWords.iterator();
        while (iterator.hasNext())
        {
            int index = 0;
            int count = 0;
            String keyWord = iterator.next();
            while((index = stringBuilder.indexOf(keyWord)) != -1 )
            {
                if(keyWord.equals("do") && stringBuilder.charAt(index+keyWord.length()) == 'u')
                {
                    keyWord = "double";
                }
                count++;
                stringBuilder.delete(index, keyWord.length()+index);
            }
            if(count > 0)
            {
                countOfKeyWords.put(keyWord, count);
            }
        }
    }

    public void fileReader()
    {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename)))
        {
            while (bufferedReader.ready())
            {
                stringBuilder.append(bufferedReader.readLine()).append('\n');
            }
            System.out.println(stringBuilder);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void fileWriter(String filename)
    {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename)))
        {
            Iterator<String> iterator = keyWords.iterator();
            while (iterator.hasNext())
            {
                String keyWord = iterator.next();
                if(countOfKeyWords.get(keyWord) != null)
                {
                    String keyVal = keyWord + "\t" + countOfKeyWords.get(keyWord) +"\n";
                    char[] buffer = keyVal.toCharArray();
                    bufferedWriter.write(buffer);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        CharIO charIO = new CharIO("./src/io/byteio/test.java");
        charIO.fileReader();
        charIO.searchKeyWords();
        charIO.fileWriter("./src/io/chario/test.txt");

    }
}
