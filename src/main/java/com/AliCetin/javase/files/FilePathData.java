package com.AliCetin.javase.files;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class FilePathData {

    // Variable

    private String id;
    //Klasör yolu
    private String pathFileName;
    //Dosya adı
    private String pathDirectoryName;
    //Kasör yolu + Dosya adı
    private String url;
    // Dosya
    private File file;
    //Sistemden alınan zaman
    private Date systemCreatedDate;

    //Constructor
    public FilePathData() {
        //Rasgele id oluşturma
        this.id = UUID.randomUUID().toString();
        this.systemCreatedDate = new Date(System.currentTimeMillis());
        pathFileName = "log.txt";
        pathDirectoryName = FilePathUrl.MY_FILE_PATH_URL;
        //Tam url
        url = pathDirectoryName.concat(pathFileName);
        //Dosyayı getiriyoruz.
        file = new File(url);
        //Dosya kontrolü
        try {
            // createNewFile() dosya oluşturuyor ve geri bildirim olarak boolean değer  döndürüyor.
            if (file.createNewFile()) {
                System.out.println( url + " => Adreste böyle bir dosya yok.");
                System.out.println( "`" + pathFileName + "` Adında bir dosya oluşturuldu.");
            } else {
                String fileName = pathFileName + " => Böyle bir dosya var.";
                System.out.println(fileName);
            }
        } catch (Exception exception){
            // exception bilgilerini, oldukça detaylı bir şekilde ekrana yazdırır.
            exception.printStackTrace();
        }
    } //End Constructor

    // toString
    @Override
    public String toString() {
        return "FilePathData{" +
                "id='" + id + '\'' +
                ", pathFileName='" + pathFileName + '\'' +
                ", pathDirectoryName='" + pathDirectoryName + '\'' +
                ", url='" + url + '\'' +
                ", file=" + file +
                ", systemCreatedDate=" + systemCreatedDate +
                '}';
    }

    // file Date Locale
    private String localDateTime(){
        Locale locale= new Locale("tr","TR");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MMMM-yyyy",locale);
        String changeDate=simpleDateFormat.format(new Date());
        return changeDate;
    }

    // Dosyaya yazma işlemi
    public void logFileWriter(String email, String password) {
        try {
            //BufferedWriter yazma işlemi için ara tampon
            // FileWriter deki append metin sonundan yazılacağını belirler
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.url, true));
            String data="[ "+ localDateTime()+" ] "+email+" "+password;
            //Dosyaya yazma
            bufferedWriter.write(data+"\n");
            //tampon veriyi siliyor.
            bufferedWriter.flush();
            //Dosyayı kapatma
            bufferedWriter.close();

        } catch (Exception e) {
            System.out.println(pathFileName +" => Dosya yazma hatası !!!");
            e.printStackTrace();
        }
    } //end Writer

    // File Reader
    public void logFileReader() {
        String readerLine; // okunan satır
        StringBuilder stringBuilder = new StringBuilder();
        String builderToString;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.url));
            while ((readerLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(readerLine).append("\n");
            }
            builderToString=stringBuilder.toString();
            System.out.println("log.txt \n" +builderToString);
        } catch (Exception e) {
            System.out.println(pathFileName +" => Dosya okuma hatası !!!");
            e.printStackTrace();
        }
    } //End Reader

}// End Class FilePathData
