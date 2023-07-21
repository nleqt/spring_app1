package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "booking_detail")
public class BookingDetail extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
=======
import lombok.Getter;
import lombok.Setter;
=======
import javax.persistence.*;
import lombok.Data;
>>>>>>> 49c445e (spring_app)

@Getter
@Setter
@Entity
=======
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
>>>>>>> ac64e9d (First 5 Feature of Customer Manager)
@Table(name = "booking_detail")
@Entity
public class BookingDetail extends BaseEntity {
    @Id
<<<<<<< HEAD
    @Column(name = "id", nullable = false)
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
=======
    @Column(name = "ID", nullable = false)
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
=======
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "booking_detail", indexes = {
        @Index(name = "booking_id", columnList = "booking_id"),
        @Index(name = "service_id", columnList = "service_id")
})
@Getter
@Setter
public class BookingDetail extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
>>>>>>> 470e9af (create database with jpa)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
<<<<<<< HEAD
<<<<<<< HEAD
    @JoinColumn(name = "BOOKING_ID", nullable = false)
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SERVICE_ID", nullable = false)
    private Services service;

    @Column(name = "NOTE")
    private String note;

}
=======
=======
>>>>>>> 470e9af (create database with jpa)
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
<<<<<<< HEAD
<<<<<<< HEAD
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;
=======
    @JoinColumn(name = "SERVICE_ID", nullable = false)
    private Services service;
>>>>>>> 49c445e (spring_app)
=======
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;
>>>>>>> 470e9af (create database with jpa)

    @Column(name = "note", length = 500)
    private String note;

<<<<<<< HEAD
<<<<<<< HEAD
}
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
=======
<<<<<<< Updated upstream
<<<<<<< HEAD
<<<<<<< HEAD
=======
    /*JPA Required Constructor*/
    public BookingDetail() {
    }
>>>>>>> 49c445e (spring_app)
=======
>>>>>>> ac64e9d (First 5 Feature of Customer Manager)
=======

>>>>>>> Stashed changes
}
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
=======
}
>>>>>>> 470e9af (create database with jpa)
