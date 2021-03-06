package com.yeyac.tb_facit.service;

import com.yeyac.tb_facit.model.Tb_facit;
import com.yeyac.tb_facit.repository.Tb_facitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Slf4j
@RequiredArgsConstructor
@Service
public class Tb_facitServiceImpl implements Tb_facitService{
	
    private final Tb_facitRepository tb_facitRepository;


    @Override
    public int saveTb_facit(Tb_facit tb_facit) {
        try{
            Tb_facit tbFacit = Tb_facit.builder()
                    .fcSeq(null)
                    .faciRoadAddr1(tb_facit.getFaciRoadAddr1())
                    .mdfr(tb_facit.getMdfr())
                    .stat(1)
                    .updated(1)
                    .totFaciArea(tb_facit.getTotFaciArea())
                    .faciHomepage(tb_facit.getFaciHomepage())
                    .faciGbNm(tb_facit.getFaciGbNm())
                    .faciNm(tb_facit.getFaciNm())
                    .faciStat(tb_facit.getFaciStat())
                    .fmngUserTel(tb_facit.getFmngUserTel())
                    .faciPointX(tb_facit.getFaciPointX())
                    .faciPointY(tb_facit.getFaciPointY())
                    .nationYn(tb_facit.getNationYn())
                    .fcobNm(tb_facit.getFcobNm())
                    .fmngCpbNm(tb_facit.getFmngCpbNm())
                    .fmngCpNm(tb_facit.getFmngCpNm())
                    .fmngTypeGbNm(tb_facit.getFmngTypeGbNm())
                    .ftypeNm(tb_facit.getFtypeNm())
                    .build();
            tb_facitRepository.save(tbFacit);
            return 1;
        }catch (Exception e){
            log.error(e.getMessage());
            return 0;
        }
    }

    @Override
    public int editTb_facit(Long id, Tb_facit tb_facit) {
        if(tb_facitRepository.findById(id).isPresent()){
            try{
                Tb_facit tbFacit = Tb_facit.builder()
                                .fcSeq(id)
                                .faciRoadAddr1(tb_facit.getFaciRoadAddr1())
                                .mdfr(tb_facit.getMdfr())
                                .stat(1)
                                .updated(1)
                                .totFaciArea(tb_facit.getTotFaciArea())
                                .faciHomepage(tb_facit.getFaciHomepage())
                                .faciGbNm(tb_facit.getFaciGbNm())
                                .faciNm(tb_facit.getFaciNm())
                                .faciStat(tb_facit.getFaciStat())
                                .fmngUserTel(tb_facit.getFmngUserTel())
                                .faciPointX(tb_facit.getFaciPointX())
                                .faciPointY(tb_facit.getFaciPointY())
                                .nationYn(tb_facit.getNationYn())
                                .fcobNm(tb_facit.getFcobNm())
                                .fmngCpbNm(tb_facit.getFmngCpbNm())
                                .fmngCpNm(tb_facit.getFmngCpNm())
                                .fmngTypeGbNm(tb_facit.getFmngTypeGbNm())
                                .ftypeNm(tb_facit.getFtypeNm())
                                .build();
                tb_facitRepository.save(tbFacit);
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
    public List<Tb_facit> getAllTb_facit() {
        return tb_facitRepository.findAll();
    }

    @Override
    public Tb_facit getTb_facitById(Long id) {
        return tb_facitRepository.findById(id).get();
    }

    @Override
    public int deleteTb_facit(Long id) {
            if (tb_facitRepository.findById(id).isPresent()) {
                Tb_facit tbFacit = tb_facitRepository.findById(id).get();
                tbFacit.setStat(0);
                tb_facitRepository.save(tbFacit);
                return 1;
            } else {
                return 2;
            }
    }

    @Override
    public int undeleteTb_facit(Long id) {
        if (tb_facitRepository.findById(id).isPresent()) {
            Tb_facit tbFacit = tb_facitRepository.findById(id).get();
            tbFacit.setStat(1);
            tb_facitRepository.save(tbFacit);
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public void init(String jsonData) {
        try{
            //Json ????????? ??????
            JSONObject jObj;
            //JSON ?????? ?????? ??????
            JSONParser jsonParser = new JSONParser();
            //????????? String (Controller?????? ????????? ?????? ????????? StringBuilder result)???
            //JSON ????????? ????????? ?????? ??????
            JSONObject jsonObj=(JSONObject) jsonParser.parse(jsonData);

            //response??? ?????????.
            JSONObject parseResponse = (JSONObject) jsonObj.get("response");
            //parseResponse?????? response ????????? ??????????????? ????????????

            //body??? ?????????
            JSONObject parseBody = (JSONObject) parseResponse.get("body");
            //parseBody?????? body ????????? ??????????????? ????????????.

            //items ????????? ??????????????? [] ???, ????????? ???????????? ????????? json ????????? ????????????.
            JSONObject parseItems = (JSONObject) parseBody.get("items");

            //items ????????? ??????????????? [] ???, ????????? ???????????? ????????? json ????????? ????????????.
            JSONArray array = (JSONArray) parseItems.get("item");

            Tb_facit tbFacit;

            Long j = 0L;
            //??????????????? ???????????? ??????
            for (int i = 0; i < array.size(); i++) {
                jObj = (JSONObject) array.get(i);

                if(!jObj.get("faciPointX").equals("-")){
                    j++;

                    tbFacit = Tb_facit.builder()
                            .fcSeq(j)
                            .faciRoadAddr1(jObj.get("faciRoadAddr1").toString())
                            .stat(1)
                            .updated(0)
                            .totFaciArea(jObj.get("totFaciArea").toString())
                            .faciHomepage(jObj.get("faciHomepage").toString())
                            .faciGbNm(jObj.get("faciGbNm").toString())
                            .faciNm(jObj.get("faciNm").toString())
                            .faciStat(jObj.get("faciStat").toString())
                            .fmngUserTel(jObj.get("fmngUserTel").toString())
                            .faciPointX(Double.parseDouble(jObj.get("faciPointX").toString()))
                            .faciPointY(Double.parseDouble(jObj.get("faciPointY").toString()))
                            .nationYn(jObj.get("nationYn").toString())
                            .fcobNm(jObj.get("fcobNm").toString())
                            .fmngCpbNm(jObj.get("fmngCpbNm").toString())
                            .fmngCpNm(jObj.get("fmngCpNm").toString())
                            .fmngTypeGbNm(jObj.get("fmngTypeGbNm").toString())
                            .ftypeNm(jObj.get("ftypeNm").toString())
                            .build();
                    tb_facitRepository.save(tbFacit);
                }
        }
    }catch (Exception e){
            e.printStackTrace();
        }
    }
}
