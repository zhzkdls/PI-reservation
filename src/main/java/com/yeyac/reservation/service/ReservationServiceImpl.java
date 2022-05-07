package com.yeyac.reservation.service;


import com.yeyac.reservation.model.Reservation;
import com.yeyac.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService{

	private final ReservationRepository reservationRepository;
	
	@Override
	public int saveReservation(Reservation reservation) {
		try {
			if(validateDuplicateReservation(reservation) == 0){
				LocalDateTime ldt = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
				String formatedldt = ldt.format(formatter);

				Reservation reservation2 = Reservation.builder()
						.rsvtMdfcnDt(null)
						.rsvtSeq(null)
						.rsvtRcptDt(formatedldt)
						.rsvtRtrchDt(reservation.getRsvtRtrchDt())
						.stat(reservation.getStat())
						.fcSeq(reservation.getFcSeq())
						.rsvtAprvDt(formatedldt)
						.rsvtHr(reservation.getRsvtHr())
						.rsvtPdt(reservation.getRsvtPdt())
						.rsvtYmd(reservation.getRsvtYmd())
						.userId(reservation.getUserId())
						.userTel(reservation.getUserTel())
						.build();
				reservationRepository.save(reservation2);
				return 1;
			}else{
				return 2;
			}
		}catch (Exception e){
			log.error(e.getMessage());
			return 0;
		}
	}

	@Override
	public int editReservation(Long rsvtSeq, Reservation reservation) {
		if(reservationRepository.findById(rsvtSeq).isPresent()){
			try{
				LocalDateTime ldt = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
				String formatedldt = ldt.format(formatter);

				Reservation reservation2;
				reservation2 = Reservation.builder()
						.rsvtMdfcnDt(formatedldt)
						.rsvtSeq(rsvtSeq)
						.rsvtRcptDt(null)
						.rsvtRtrchDt(reservation.getRsvtRtrchDt())
						.stat(reservation.getStat())
						.fcSeq(reservation.getFcSeq())
						.rsvtAprvDt(reservation.getRsvtAprvDt())
						.rsvtHr(reservation.getRsvtHr())
						.rsvtPdt(reservation.getRsvtPdt())
						.rsvtYmd(reservation.getRsvtYmd())
						.userId(reservation.getUserId())
						.userTel(reservation.getUserTel())
						.build();
				reservationRepository.save(reservation2);
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
	public int validateDuplicateReservation(Reservation reservation) {
		try{
			List<Reservation> reservations = reservationRepository.findAllByRsvtYmdAndRsvtHrAndFcSeq(reservation.getRsvtYmd(), reservation.getRsvtHr(), reservation.getFcSeq());

			if(reservations.isEmpty()){
				return 0;
			}else{
				for (Reservation reservation1 : reservations) {
					if (reservation1.getStat() == 1 || reservation1.getStat() == 2) {
						return 1;
					}
				}
			}
			return 0;
		}catch (Exception e){
			System.out.println(e.getMessage());
			return 1;
		}
	}

	@Override
	public List<Reservation> getAllReservation() {
		return reservationRepository.findAll();
	}

	@Override
	public Reservation getReservation(Long rsvtSeq) {
		if(reservationRepository.findById(rsvtSeq).isPresent()){
			return reservationRepository.findById(rsvtSeq).get();
		}else{
			return null;
		}
	}

	@Override
	public int deleteReservation(Long rsvtSeq) {
		if( reservationRepository.findById(rsvtSeq).isPresent()){
			try {
				LocalDateTime ldt = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
				String formatedldt = ldt.format(formatter);

				Reservation reservation = reservationRepository.findById(rsvtSeq).get();
				reservation.setStat(0);
				reservation.setRsvtRtrchDt(formatedldt);
				reservationRepository.save(reservation);
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
	public int undeleteReservation(Long rsvtSeq) {

		if( reservationRepository.findById(rsvtSeq).isPresent()){
			try {
				Reservation reservation = reservationRepository.findById(rsvtSeq).get();
				reservation.setStat(1);
				reservationRepository.save(reservation);
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
	public int approvalReservation(Long rsvtSeq) {

		if( reservationRepository.findById(rsvtSeq).isPresent()){
			try {
				LocalDateTime ldt = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
				String formatedldt = ldt.format(formatter);

				Reservation reservation = reservationRepository.findById(rsvtSeq).get();
				reservation.setStat(1);
				reservation.setRsvtAprvDt(formatedldt);
				reservationRepository.save(reservation);
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
	public int noapprovalReservation(Long rsvtSeq) {

		if( reservationRepository.findById(rsvtSeq).isPresent()){
			try {
				LocalDateTime ldt = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
				String formatedldt = ldt.format(formatter);

				Reservation reservation = reservationRepository.findById(rsvtSeq).get();
				reservation.setStat(4);
				reservation.setRsvtRtrchDt(formatedldt);
				reservationRepository.save(reservation);
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
