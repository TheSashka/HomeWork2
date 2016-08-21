package io;


import java.io.*;

public class ChangeEncoding
{
    private String filename;
    private StringBuilder stringBuilder;
    private File file;

    public ChangeEncoding(String filename)
    {
        this.filename = filename;
        stringBuilder = new StringBuilder();
        file = new File("./src/io/output.txt");
    }


    public void fileReader()
    {

        byte [] buffer = new byte[512];
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filename)))
        {
            while (bufferedInputStream.available() > 0)
            {
                if(bufferedInputStream.available() < 512)
                {
                    buffer = new byte[bufferedInputStream.available()];
                }
                bufferedInputStream.read(buffer);
                String test = new String(buffer);
                stringBuilder.append(test);
            }
            System.out.println(stringBuilder.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void fileWriter()
    {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-16")))
        {
            bufferedWriter.write(stringBuilder.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        ChangeEncoding encoding = new ChangeEncoding("./src/io/text.txt");
        encoding.fileReader();
        encoding.fileWriter();
    }

}
