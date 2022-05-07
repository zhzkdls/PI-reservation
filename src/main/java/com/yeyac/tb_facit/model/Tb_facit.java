package com.yeyac.tb_facit.model;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Tb_facit{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fcSeq; // 시설일련번호
    @Column(name = "fc_name")
    private String faciNm;	//시설명
    @Column(name = "fc_gubun_name")
    private String faciGbNm;//시설구분명
    @Column(name = "fc_obNm")
    private String fcobNm;//업종명
    @Column(name = "fc_tyNm")
    private String ftypeNm;//시설유형명
    @Column(name = "fTGNm")
    private String fmngTypeGbNm;//소유주체명
    @Column(name = "fnCNm")
    private String fmngCpNm;//소유주체 시도명
    @Column(name = "fnCbNm")
    private String fmngCpbNm;//소유주체 시군구명
    @Column(name = "fc_mg_tel")
    private String fmngUserTel;//담당자 연락처
    @Column(name = "fc_load_addr")
    private String faciRoadAddr1;//시설도로명주소1
    @Column(name = "fc_hp")
    private String faciHomepage;//시설홈페이지
    @Column(name = "fc_point_x", columnDefinition = "DECIMAL(17,14)")
    private double faciPointX;	//시설좌표_경도
    @Column(name = "fc_point_Y", columnDefinition = "DECIMAL(17,14)")
    private double faciPointY;	//시설좌표_위도
    @Column(name = "fc_stat")
    private String faciStat;//시설상태
    @Column(name = "fc_ar")
    private String totFaciArea;//시설총면적(현재시설)
    @Column(name = "fc_ntn_gubun", columnDefinition = "CHAR")
    private String nationYn;//국가체육시설여부

    private String mdfr;// 수정자
    @Setter
    private int stat;
    @Setter
    private int updated;
    @Setter
    private Long managerSeq;

    @Builder
    public Tb_facit(Long fcSeq, String faciNm, String faciGbNm, String fcobNm, String ftypeNm, String fmngTypeGbNm, String fmngCpNm, String fmngCpbNm,
                    String fmngUserTel, String faciRoadAddr1, String faciHomepage, double faciPointX, double faciPointY, String faciStat, String totFaciArea, String nationYn,
                    String mdfr, int stat, int updated) {
        this.fcSeq = fcSeq;
        this.faciNm = faciNm;
        this.faciGbNm = faciGbNm;
        this.fcobNm = fcobNm;
        this.ftypeNm = ftypeNm;
        this.fmngTypeGbNm = fmngTypeGbNm;
        this.fmngCpNm = fmngCpNm;
        this.fmngCpbNm = fmngCpbNm;
        this.fmngUserTel = fmngUserTel;
        this.faciRoadAddr1 = faciRoadAddr1;
        this.faciHomepage = faciHomepage;
        this.faciPointX = faciPointX;
        this.faciPointY = faciPointY;
        this.faciStat = faciStat;
        this.totFaciArea = totFaciArea;
        this.nationYn = nationYn;
        this.mdfr = mdfr;
        this.stat = stat;
        this.updated = updated;
    }
}
