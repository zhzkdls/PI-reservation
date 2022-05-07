package com.yeyac.tb_hldy.repository;

import com.yeyac.tb_hldy.model.Tb_hldy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tb_hldyRepository extends JpaRepository<Tb_hldy, Long> {
    List<Tb_hldy> findAllTb_tldyByFcSeq(Long fcSeq);
}
