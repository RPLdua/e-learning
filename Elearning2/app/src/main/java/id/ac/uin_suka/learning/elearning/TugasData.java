package id.ac.uin_suka.learning.elearning;

import java.util.ArrayList;

public class TugasData {
    public static String[][] data = new String[][]{
            {"1","Taufik", "RPL", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Presiden_Sukarno.jpg/418px-Presiden_Sukarno.jpg"},
            {"2","Nurochman", "Pemrograman Berorientasi Obyek", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/President_Suharto%2C_1993.jpg/468px-President_Suharto%2C_1993.jpg"},
            {"3","Nama Dosen", "Nama Mata Kuliah", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Bacharuddin_Jusuf_Habibie_official_portrait.jpg/520px-Bacharuddin_Jusuf_Habibie_official_portrait.jpg"},
            {"4","Agus Mulyanto", "SIM", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/President_Abdurrahman_Wahid_-_Indonesia.jpg/486px-President_Abdurrahman_Wahid_-_Indonesia.jpg"},
            {"5","Taufik", "RPL", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/President_Megawati_Sukarnoputri_-_Indonesia.jpg/540px-President_Megawati_Sukarnoputri_-_Indonesia.jpg"},
            {"6","Nurochman", "PBO", "https://upload.wikimedia.org/wikipedia/commons/5/58/Presiden_Susilo_Bambang_Yudhoyono.png"},
            {"7","Aulia Faqih", "Kommas", "https://upload.wikimedia.org/wikipedia/commons/1/1c/Joko_Widodo_2014_official_portrait.jpg"}
    };

    public static ArrayList<Tugas> getListData(){
        Tugas tugas = null;
        ArrayList<Tugas> list = new ArrayList<>();
        for (int i = 0; i <data.length; i++) {
            tugas = new Tugas();
            tugas.setId(data[i][0]);
            tugas.setName(data[i][1]);
            tugas.setRemarks(data[i][2]);
            tugas.setPhoto(data[i][3]);

            list.add(tugas);
        }

        return list;
    }
}
