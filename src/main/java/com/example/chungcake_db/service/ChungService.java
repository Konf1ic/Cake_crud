package com.example.chungcake_db.service;

import com.example.chungcake_db.model.Chung;
import com.example.chungcake_db.repository.ChungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChungService {
    @Autowired
    private ChungRepository chungRepository;
    public List<Chung> getAllListCake() {
        return (List<Chung>) chungRepository.findAll();
    }

    public void createCake(Chung trungCake) {
        chungRepository.save(trungCake);
    }

    public Chung findById(int id) {
        return chungRepository.findById(id).get();
    }

    public void updateCake(Chung chung) {
        Chung trungCakeEdit = findById(chung.getId());

        if (trungCakeEdit != null) {
            trungCakeEdit.setDetails(chung.getDetails());
            trungCakeEdit.setPrice(chung.getPrice());
            trungCakeEdit.setType(chung.getType());
            trungCakeEdit.setStatus(chung.isStatus());

            chungRepository.save(trungCakeEdit);
        }
    }

    public void deleteById(int id) {
        chungRepository.deleteById(id);
    }

    public List<Chung> searchWithKeyword(String keyword) {
        return chungRepository.findChungByDetailsContaining(keyword);
    }


}