package com.yeyac.tb_hldy.service;

import com.yeyac.tb_hldy.model.Tb_hldy;
import com.yeyac.tb_hldy.repository.Tb_hldyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class Tb_hldyServiceImpl implements Tb_hldyService{

    private final Tb_hldyRepository tb_hldyRepository;

    @Override
    public int saveTb_hldy(Tb_hldy tb_hldy) {
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strNowDate = simpleDateFormat.format(tb_hldy.getTcbizBgngYmd());

            Tb_hldy th = Tb_hldy.builder()
                    .hldySeq(null)
                    .fcSeq(tb_hldy.getFcSeq())
                    .tcbizBgngYmd(tb_hldy.getTcbizBgngYmd())
                    .ymdFormat(strNowDate)
                    .stat(1)
                    .build();
            tb_hldyRepository.save(th);

            log.info("{}", strNowDate);
            return 1;
        }catch (Exception e){
            log.error(e.getMessage());
            return 0;
        }
    }

    @Override
    public int editTb_hldy(Long id, Tb_hldy tb_hldy) {
        if(tb_hldyRepository.findById(id).isPresent()){
            try {
                Tb_hldy th = tb_hldyRepository.findById(id).get();
                th = Tb_hldy.builder()
                        .hldySeq(th.getHldySeq())
                        .fcSeq(tb_hldy.getFcSeq())
                        .tcbizBgngYmd(tb_hldy.getTcbizBgngYmd())
                        .ymdFormat(tb_hldy.getYmdFormat())
                        .stat(tb_hldy.getStat())
                        .build();
                tb_hldyRepository.save(th);
                return 1;
            }catch (Exception e){
                log.error(e.getMessage());
                return 0;
            }
        }else{
            return 2;
        }
    }

    @Override
    public List<Tb_hldy> getAllTb_hldy() {
        return tb_hldyRepository.findAll();
    }

    @Override
    public Tb_hldy getTb_hldy(Long id) {
        return tb_hldyRepository.findById(id).get();
    }

    @Override
    public int deleteTb_hldy(Long id) {
        if( tb_hldyRepository.findById(id).isPresent() ){
            try{
                Tb_hldy th = tb_hldyRepository.findById(id).get();
                th.setStat(0);
                tb_hldyRepository.save(th);
                return 1;
            }catch (Exception e){
                log.error(e.getMessage());
                return 0;
            }
        }else{
            return 2;
        }
    }

    @Override
    public int undeleteTb_hldy(Long id) {
        if( tb_hldyRepository.findById(id).isPresent() ){
            try{
                Tb_hldy th = tb_hldyRepository.findById(id).get();
                th.setStat(1);
                tb_hldyRepository.save(th);
                return 1;
            }catch (Exception e){
                log.error(e.getMessage());
                return 0;
            }
        }else{
            return 2;
        }
    }
}
