package com.yeyac.tb_hldy.controller;

import com.yeyac.tb_facit.repository.Tb_facitRepository;
import com.yeyac.tb_hldy.model.Tb_hldy;
import com.yeyac.tb_hldy.repository.Tb_hldyRepository;
import com.yeyac.tb_hldy.service.Tb_hldyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/hldy")
public class Tb_hldyController {

    private final Tb_hldyService tb_hldyService;
    private final Tb_hldyRepository tb_hldyRepository;

    @PostMapping("/save")
    String saveTb_hldy(@RequestBody Tb_hldy tb_hldy){
        if(tb_hldyService.saveTb_hldy(tb_hldy) == 1){
            return "추가 완료";
        }else{
            return "추가 실패";
        }
    }

    @RequestMapping(value="/edit/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    String eidtTb_hldy(@PathVariable Long id, @RequestBody Tb_hldy tb_hldy){
        if(tb_hldyService.editTb_hldy(id, tb_hldy) == 1){
            return "수정 완료";
        }else if(tb_hldyService.editTb_hldy(id, tb_hldy) == 2){
            return "추가 실패 : 해당 아이디의 값이 존재하지 않음";
        }else{
            return "수정 실패";
        }
    }

    @GetMapping("/getAll")
    List<Tb_hldy> getAllTb_hldy(){
        return tb_hldyService.getAllTb_hldy();
    }

    @GetMapping("/getAllByhldySeq/{fcSeq}")
    List<Tb_hldy> getAllTb_hldyByFcSeq(@PathVariable Long fcSeq){
        return tb_hldyRepository.findAllTb_tldyByFcSeq(fcSeq);
    }

    @GetMapping("/get/{id}")
    Tb_hldy getTb_hldy(@PathVariable Long id){
        return tb_hldyService.getTb_hldy(id);
    }

    @RequestMapping(value="/delete/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    String deleteTb_hldy(@PathVariable Long id){
        if( tb_hldyService.deleteTb_hldy(id) == 1 ){
            return "삭제 완료";
        }else if( tb_hldyService.deleteTb_hldy(id) == 2 ){
            return "삭제 실패 : 해당 아이디의 값이 존재하지 않음";
        }else{
            return "삭제 실패";
        }
    }

    @RequestMapping(value="/undelete/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    String undeleteTb_hldy(@PathVariable Long id){
        if( tb_hldyService.undeleteTb_hldy(id) == 1 ){
            return "복구 완료";
        }else if( tb_hldyService.undeleteTb_hldy(id) == 2 ){
            return "복구 실패 : 해당 아이디의 값이 존재하지 않음";
        }else{
            return "복구 실패";
        }
    }

}
