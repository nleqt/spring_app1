package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import lombok.*;

import jakarta.persistence.*;
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.Date;
=======
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
=======

>>>>>>> cc23f7d (fix conflict)
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "feedbacks")
<<<<<<< HEAD
<<<<<<< HEAD
=======
@Entity
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
=======

@Entity
>>>>>>> cc23f7d (fix conflict)
public class Feedbacks extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SERVICES_ID", nullable = false)
    private Services services;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "REPLY_ID")
    private Integer replyId;

    @Column(name = "RATING")
    private Integer rating;

<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
=======
>>>>>>> cc23f7d (fix conflict)
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "feedbacks")
    private Set<Replies> replies = new LinkedHashSet<>();
}
