//package com.book.domain;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.validation.constraints.Size;
//
//
//
//	@Entity
//	public class Authors {
//
//		@GeneratedValue(strategy = GenerationType.IDENTITY)
//		@Id
//		private short id;
//		@Size(min = 2, max = 80)
//		private String authorsName;
//
//		public Authors() {
//
//		}
//		
//		public Authors (String authorsName) {
//			this.authorsName = authorsName;
//		}
//
//		public short getId() {
//			return id;
//		}
//
//		public void setId(short id) {
//			this.id = id;
//		}
//
//		public String getAuthorsName() {
//			return authorsName;
//		}
//
//		public void setAuthorsName(String AuthorsName) {
//			this.authorsName = authorsName;
//		}
//	}
