package com.yeyac.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yeyac.reservation.model.Reservation;

@Service
public interface ReservationService {
	int saveReservation(Reservation reservation);
	int editReservation(Long id, Reservation reservation);
	List<Reservation> getAllReservation();
	Reservation getReservation(Long rsvtSeq);
	int deleteReservation(Long rsvtSeq);
	int undeleteReservation(Long rsvtSeq);
	int validateDuplicateReservation(Reservation reservation);
	int approvalReservation(Long rsvtSeq);
	int noapprovalReservation(Long rsvtSeq);
}
