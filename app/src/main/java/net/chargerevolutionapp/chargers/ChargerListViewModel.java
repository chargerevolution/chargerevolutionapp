package net.chargerevolutionapp.chargers;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.firestore.FirebaseFirestore;

import net.chargerevolutionapp.profiles.UserProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChargerListViewModel extends AndroidViewModel {
    private static final String LOG_TAG = ChargerListViewModel.class.getName();

    ChargerRepository chargerRepository;
    MutableLiveData<List<Charger>> chargerListMutableLiveData;
    FirebaseFirestore mFirestore;

    public ChargerListViewModel(Application application, UserProfile userProfile) {
        super(application);
        chargerRepository = new ChargerRepository();
        chargerListMutableLiveData = chargerRepository.getChargerListMutableLiveData(userProfile);
        mFirestore = FirebaseFirestore.getInstance();
    }

    //CREATE
    public void insert(Charger charger) {
        this.chargerRepository.insert(charger);
    }

    //READ
    public MutableLiveData<List<Charger>> getAllChargersLive() {
        return chargerListMutableLiveData;
    }

    //UPDATE
    public void update(Charger charger) {
        this.chargerRepository.update(charger);
    }

    //DELETE
    public void delete(Charger charger) {
        this.chargerRepository.delete(charger);
    }

//
//    //ADD FILTER
//    public void addUserFilter(UserProfile profileInfo) {
//        List<Charger> filteredListTemp = new ArrayList<>();
//        if (chargerRepository.getChargerListMutableLiveData(profileInfo).getValue() == null) {
//            Log.i(LOG_TAG, "Error filtering chargers: Charger list is null!");
//        } else {
//
//            for (Charger charger :
//                    Objects.requireNonNull(chargerRepository.getChargerListMutableLiveData().getValue())) {
//                if (charger.getConnectorTypes().contains(profileInfo.getCarConnector())) {
//                    filteredListTemp.add(charger);
//                }
//            }
//            this.chargerListMutableLiveData.setValue(filteredListTemp);
//        }
//    }
//
//    //REMOVE FILTER
//    public void removeUserFilter() {
//        this.chargerListMutableLiveData = chargerRepository.getChargerListMutableLiveData();
//    }

}