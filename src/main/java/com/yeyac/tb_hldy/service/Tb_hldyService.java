package com.yeyac.tb_hldy.service;

import com.yeyac.tb_hldy.model.Tb_hldy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Tb_hldyService {

    int saveTb_hldy(Tb_hldy tb_hldy);
    int editTb_hldy(Long id, Tb_hldy tb_hldy);
    List<Tb_hldy> getAllTb_hldy();
    Tb_hldy getTb_hldy(Long id);
    int deleteTb_hldy(Long id);
    int undeleteTb_hldy(Long id);
}
