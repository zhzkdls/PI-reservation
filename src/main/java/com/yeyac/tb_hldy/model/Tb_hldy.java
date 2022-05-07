package com.yeyac.tb_hldy.model;


import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Entity
public class Tb_hldy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hldySeq;
    private Long fcSeq; // 시설 아이디
    private Timestamp tcbizBgngYmd; // 휴업 시작 일자
    private String ymdFormat; // 휴업 종료 일자
    @Setter
    private int stat = 1; // 0 : 삭제 1 : 정상

    @Builder
    public Tb_hldy(Long hldySeq, Long fcSeq, Timestamp tcbizBgngYmd, String ymdFormat, int stat) {
        this.hldySeq = hldySeq;
        this.fcSeq = fcSeq;
        this.tcbizBgngYmd = tcbizBgngYmd;
        this.ymdFormat = ymdFormat;
        this.stat = stat;
    }
}
