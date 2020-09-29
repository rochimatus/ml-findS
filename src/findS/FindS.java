package findS;

import data.DB;
import data.Data;
import data.EnjoySport;
import java.util.ArrayList;

public class FindS {

    private static final int NOT_KNOWN_YET = -1;
    private ArrayList<Data> listData;
    private ArrayList<Boolean> listResult = new ArrayList<>();
    private ArrayList<Data> listHipotesis = new ArrayList<>();

    public FindS(ArrayList<Data> listData) {
        this.listData = listData;
    }

    public String hypothesize() {
        Data hipotesis = null;
        int idHipotesis;
        for (int i = 0; i < listData.size(); i++) {
            idHipotesis = isLabelListed(listData.get(i).getLabel());

            if (idHipotesis == NOT_KNOWN_YET) {
                listHipotesis.add(new Data(listData.get(i).getLabel()));
                hipotesis = listHipotesis.get(listHipotesis.size() - 1);
                listHipotesis.set(listHipotesis.size() - 1, trainByLabel(hipotesis, listData.get(i), i));
            } else {
                hipotesis = listHipotesis.get(idHipotesis);
                listHipotesis.set(idHipotesis, trainByLabel(hipotesis, listData.get(i), i));
            }
        }
        return printAllHipotesis();
    }

    private int isLabelListed(String label) {
        for (int i = 0; i < listHipotesis.size(); i++) {
            if (listHipotesis.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return NOT_KNOWN_YET;
    }

    public String testData(Data data) {
        listResult.clear();

        for (Data hipotesis : listHipotesis) {
            int i = 0;
            listResult.add(true);
            for (String attribute : hipotesis.getAttributes()) {
                if (!(attribute.equals("?") || data.getAttributes()[i].equals("?")))
                    if (!attribute.equalsIgnoreCase(data.getAttributes()[i])) {
                        listResult.set(listHipotesis.indexOf(hipotesis), false);
                        break;
                    }
                i++;
            }
        }
        return result();
    }

    private Data trainByLabel(Data hipotesis, Data data, int i) {
        if (hipotesis.getAttributes() == null) {
            hipotesis.setAttributes(data.getAttributes());
            return hipotesis;
        }

        String[] attr = data.getAttributes();
        for (int j = 0; j < attr.length; j++) {
            if (!hipotesis.getAttributes()[j].equals("?")) {
                if (!attr[j].equalsIgnoreCase(hipotesis.getAttributes()[j])) {
                    hipotesis.getAttributes()[j] = "?";
                }
            }
        }
        return hipotesis;
    }

    public String result() {
        boolean flag = listResult.get(0);
        for (int i = 1; i < listResult.size(); i++) {
            flag ^= listResult.get(i);
        }
        
        System.out.println(listResult.get(0)+ " " + listResult.get(1));
        String send = "";
        if (flag) {
            if (listResult.get(0)) {
                send += listHipotesis.get(0).getLabel();
            } else {
                send += listHipotesis.get(1).getLabel();
            }
        } else {
            if (listResult.get(0)) {
                send += "Bisa " + listHipotesis.get(0).getLabel();
                send += ", bisa " + listHipotesis.get(1).getLabel();
            } else {
                send += "Tidak Ada";
            }
        }

        return send;
    }

    private String printAllHipotesis() {
        String str = "";
        for (Data hipotesis : listHipotesis) {
            str += hipotesis.getData() + "\n";
        }
        return str;
    }
}
