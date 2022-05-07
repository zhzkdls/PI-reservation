package com.yeyac.reservation.model;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor()
@Getter
@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rsvtSeq; // 예약 일련번호
	private Long fcSeq; // 시설 일련번호
	@Column(columnDefinition = "VARCHAR(20)")
	private String userId; // 사용자아이디
	@Column(columnDefinition = "VARCHAR(20)")
	private String userTel; // 사용자 전화번호
	private String rsvtYmd; //예약 날짜
	private String rsvtHr; // 예약 시간
	private int rsvtPdt; // 예약 가능일
	@Setter
	private String rsvtRtrchDt; // 예약 취소 일시
	@Setter
	private String rsvtAprvDt; // 예약 승인 일시
	private String rsvtRcptDt; // 예약 접수 일시
	private String rsvtMdfcnDt; // 예약 수정 일시
	@Setter
	private int stat; // 상태 0 : 취소 & 삭제 // 1 : 승인 // 2 : 승인 대기 // 3 : 승인 거부

	@Builder

	public Reservation(Long rsvtSeq, Long fcSeq, String userId, String userTel, String rsvtYmd, String rsvtHr, int rsvtPdt,
					   String rsvtRtrchDt, String rsvtAprvDt, String rsvtRcptDt, String rsvtMdfcnDt, int stat) {
		this.rsvtSeq = rsvtSeq;
		this.fcSeq = fcSeq;
		this.userId = userId;
		this.userTel = userTel;
		this.rsvtYmd = rsvtYmd;
		this.rsvtHr = rsvtHr;
		this.rsvtPdt = rsvtPdt;
		this.rsvtRtrchDt = rsvtRtrchDt;
		this.rsvtAprvDt = rsvtAprvDt;
		this.rsvtRcptDt = rsvtRcptDt;
		this.rsvtMdfcnDt = rsvtMdfcnDt;
		this.stat = stat;
	}
}
