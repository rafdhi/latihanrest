package com.eksad.latihanrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.type.TrueFalseType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter @Setter
//@EqualsAndHashCode
//@ToString

@Data // kependekan dari @getter, @setter, @to string, @equalsandhashcode
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter @Setter
@Entity
@Table(name = "brand")
public class Brand extends BaseEntity {
	
//	@Id // karna dia primary key
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // karna sifatnya bertingkat atau increment
	//@Column(unique = true, nullable = false)
//	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(name = "product_type") // ngasih tau kalo nama di pgAdmin itu product_type
	private String productType;

}
