package com.yeyac.reservation.controller;

import java.util.List;

import com.yeyac.reservation.model.Reservation;
import com.yeyac.reservation.repository.ReservationRepository;
import com.yeyac.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/reservation")
@RestController
public class ReservationController {

	private final ReservationService reservationService;
	private final ReservationRepository reservationRepository;
	
	@PostMapping("/save")
	public String saveReservation(@RequestBody Reservation reservation) {
		if(reservationService.saveReservation(reservation) == 1){
			return "예약 완료!";
		}else if(reservationService.saveReservation(reservation) == 2){
			return "이미 예약된 시간입니다.";
		}else{
			return "예약 실패";
		}
	}
	
	@PostMapping("/edit/{rsvtSeq}")
	public String editReservation(@PathVariable Long rsvtSeq, @RequestBody Reservation reservation) {
		if(reservationService.editReservation(rsvtSeq, reservation) == 1){
			return "수정 완료";
		}else if(reservationService.editReservation(rsvtSeq, reservation) == 2){
			return "수정 실패 : 해당 아이디의 값이 없음";
		}else{
			return "수정 실패";
		}
	}
	
	@GetMapping("/getAll")
	public List<Reservation> getAllReservations(){
		return reservationService.getAllReservation();
	}

	@GetMapping("/getAll/{fcSeq}")
	public List<Reservation> getAllByFcSeq(@PathVariable Long fcSeq) {
		return reservationRepository.findAllByFcSeq(fcSeq);
	}

	@GetMapping("/get/{rsvtSeq}")
	public Reservation getResOptionalById(@PathVariable Long rsvtSeq) {
		if(reservationService.getReservation(rsvtSeq) != null){
			return reservationService.getReservation(rsvtSeq);
		}else{
			return null;
		}
	}

//	@PostMapping("/delete/{rsvtSeq}")
	@RequestMapping(value="/delete/{rsvtSeq}", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteReservation (@PathVariable Long rsvtSeq){
		if(reservationService.deleteReservation(rsvtSeq) == 1){
			return "삭제 완료";
		}else if(reservationService.deleteReservation(rsvtSeq) == 2){
			return "삭제 실패 : 해당 아이디의 값이 없음.";
		}else{
			return "삭제 실패";
		}
	}

//	@PostMapping("/undelete/{rsvtSeq}")
	@RequestMapping(value="/undelete/{rsvtSeq}", method = {RequestMethod.GET, RequestMethod.POST})
	public String undeleteReservation (@PathVariable Long rsvtSeq){
		if(reservationService.undeleteReservation(rsvtSeq) == 1){
			return "복구 완료";
		}else if(reservationService.undeleteReservation(rsvtSeq) == 2){
			return "복구 실패 : 해당 아이디의 값이 없음.";
		}else{
			return "복구 실패";
		}
	}

//	@PostMapping("/approval/{rsvtSeq}")
	@RequestMapping(value="/approval/{rsvtSeq}", method = {RequestMethod.GET, RequestMethod.POST})
	public String approvalReservation (@PathVariable Long rsvtSeq){
		if(reservationService.approvalReservation(rsvtSeq) == 1){
			return "예약 승인";
		}else if(reservationService.deleteReservation(rsvtSeq) == 2){
			return "승인 실패 : 해당 아이디의 값이 없음.";
		}else{
			return "승인 실패";
		}
	}

//	@PostMapping("/noapproval/{rsvtSeq}")
	@RequestMapping(value="/noapproval/{rsvtSeq}", method = {RequestMethod.GET, RequestMethod.POST})
	public String noapprovalReservation (@PathVariable Long rsvtSeq){
		if(reservationService.noapprovalReservation(rsvtSeq) == 1){
			return "승인 거절";
		}else if(reservationService.deleteReservation(rsvtSeq) == 2){
			return "승인 거절 실패 : 해당 아이디의 값이 없음.";
		}else{
			return "승인 거절 실패";
		}
	}
}
