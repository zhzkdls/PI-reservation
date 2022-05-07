package com.yeyac.tb_facit.controller;

import com.fasterxml.jackson.core.io.JsonEOFException;
import com.yeyac.tb_facit.model.Tb_facit;
import com.yeyac.tb_facit.repository.Tb_facitRepository;
import com.yeyac.tb_facit.service.Tb_facitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/tbfacit")
public class Tb_facitController {

    private final Tb_facitService tbFacitService;
    private final Tb_facitRepository tb_facitRepository;

    @PostMapping("/save")
    public String saveTb_facit(@RequestBody Tb_facit tb_facit){
        if(tbFacitService.saveTb_facit(tb_facit) == 1){
            return "저장 완료";
        }else{
            return "저장 실패";
        }
    }

    @RequestMapping(value="/edit/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public String editTb_facit(@PathVariable Long id, @RequestBody Tb_facit tb_facit){
        if(tbFacitService.editTb_facit(id, tb_facit) == 1){
            return "수정 완료";
        }else if (tbFacitService.editTb_facit(id, tb_facit) == 2){
            return "수정 실패 : 해당 아이디의 값이 없음";
        }else{
            return "수정 실패";
        }
    }

    @GetMapping("/getAll")
    public List<Tb_facit> getAllTb_facit(){
        return tbFacitService.getAllTb_facit();
    }

    @RequestMapping(value="/get/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public Tb_facit getTb_facitById(@PathVariable Long id){
        return tbFacitService.getTb_facitById(id);
    }

    @RequestMapping(value="/delete/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteTb_facit(@PathVariable Long id){
        if(tbFacitService.deleteTb_facit(id) == 1){
            return "삭제 완료";
        }else if (tbFacitService.deleteTb_facit(id) == 2){
            return "삭제 실패 : 해당 아이디의 값이 없음 ";
        }else{
            return "삭제 실패";
        }
    }

    @RequestMapping(value="/undelete/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public String undeleteTb_facit(@PathVariable Long id){
        if(tbFacitService.undeleteTb_facit(id) == 1){
            return "복구 완료";
        }else if (tbFacitService.undeleteTb_facit(id) == 2){
            return "복구 실패 : 해당 아이디의 값이 없음";
        }else{
            return "복구 실패";
        }
    }
}
