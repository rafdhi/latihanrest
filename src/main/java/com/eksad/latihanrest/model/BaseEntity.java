package com.eksad.latihanrest.model;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
}
