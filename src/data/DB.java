package data;

import java.util.ArrayList;

public class DB {

    private ArrayList<Data> dataEnjoySport = new ArrayList<>();
    private ArrayList<Data> dataPengenalanBuah = new ArrayList<>();
    private ArrayList<Data> dataPenyakitHipertensi = new ArrayList<>();

    private DB() {
        dataEnjoySport.add(new EnjoySport("yes", "Sunny, Warm, Normal, Strong, Warm, Same"));
        dataEnjoySport.add(new EnjoySport("yes", "Sunny, Warm, High, Strong, Warm, Same"));        
        dataEnjoySport.add(new EnjoySport("no", "Rainy, Cold, High, Strong, Warm, Change"));
        dataEnjoySport.add(new EnjoySport("yes", "Sunny, Warm, High, Strong, Cool, Change"));    
        
        dataPengenalanBuah.add(new PengenalanBuah("pisang", "panjang, sedang"));
        dataPengenalanBuah.add(new PengenalanBuah("pisang", "panjang, pendek"));
        dataPengenalanBuah.add(new PengenalanBuah("apel", "pendek, pendek"));
        
        dataPenyakitHipertensi.add(new PenyakitHipertensi("tidak", "muda, gemuk"));
        dataPenyakitHipertensi.add(new PenyakitHipertensi("tidak", "muda, sangat gemuk"));
        dataPenyakitHipertensi.add(new PenyakitHipertensi("tidak", "paruh baya, gemuk"));
        dataPenyakitHipertensi.add(new PenyakitHipertensi("ya", "paruh baya, terlalu gemuk"));
        dataPenyakitHipertensi.add(new PenyakitHipertensi("ya", "tua, terlalu gemuk"));
    }
    
    public static DB getInstance() {
        return DBHolder.INSTANCE;
    }

    public ArrayList<Data> getDataEnjoySport() {
        return dataEnjoySport;
    }

    public ArrayList<Data> getDataPengenalanBuah() {
        return dataPengenalanBuah;
    }

    public ArrayList<Data> getDataPenyakitHipertensi() {
        return dataPenyakitHipertensi;
    }

    public void printData(ArrayList<Data> data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static class DBHolder {

        private static final DB INSTANCE = new DB();
    }
}
