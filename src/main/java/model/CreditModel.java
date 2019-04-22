package model;

import model.data.IkrSibBankData;
import model.data.PimbBankData;
import model.data.PrivitBankData;
import model.entity.Credit;

import java.util.ArrayList;
import java.util.List;

public class CreditModel {

    public List<Credit> allCredits = new ArrayList<Credit>();

    public void addToList() {
        for (IkrSibBankData value : IkrSibBankData.values()) {
            allCredits.add(value.getIkrSibBankCredit());
        }

        for (PimbBankData value : PimbBankData.values()) {
            allCredits.add(value.getPimbBankCredit());
        }

        for (PrivitBankData value : PrivitBankData.values()) {
            allCredits.add(value.getPrivitBankCredit());
        }
    }
}
