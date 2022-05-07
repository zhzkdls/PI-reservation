package com.yeyac.reservation.repository;

import com.yeyac.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;


public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    List<Reservation> findAllByRsvtYmdAndRsvtHrAndFcSeq(String rsvtYmd, String rsvtHr, Long fcSeq);
    List<Reservation> findAllByFcSeq(Long fcSeq);
}
