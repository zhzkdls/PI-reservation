package com.yeyac.tb_facit.service;

import com.yeyac.tb_facit.model.Tb_facit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Tb_facitService {

    int saveTb_facit(Tb_facit tb_facit);
    int editTb_facit(Long id, Tb_facit tb_facit);
    List<Tb_facit> getAllTb_facit();
    Tb_facit getTb_facitById(Long id);
    int deleteTb_facit(Long id);
    int undeleteTb_facit(Long id);
    void init(String jsonData);
}
