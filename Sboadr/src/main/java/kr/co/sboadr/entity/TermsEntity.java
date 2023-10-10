package kr.co.sboadr.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Terms")
public class TermsEntity {

	@Id //엔티티는 무조건 아이가 하나 있어야 하기에 억지로 하나 만듬.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	private String terms;
	private String privacy;

}