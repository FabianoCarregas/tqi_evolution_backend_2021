package com.fabiano.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fabiano.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class LoanDTO {
	public class Loan implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	    @NotNull
	    private Integer loanValue;
	    
	    private Instant date;

	    @NotNull
	    private String firstInstallment;

	    @Min(value = 3, message = "Must be equal or greatter than 3 installments")
	    @Max(value = 60, message = "Most be equal or less than 60 installments")
	    @NotNull
	    private Integer Installments;
	    
	    @JsonIgnore
	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;

	    public Loan() {
		}

		public Loan(Loan obj) {
			id = obj.id ;
			loanValue = obj.loanValue;
			firstInstallment = obj.firstInstallment;
			Installments = obj.Installments;
			user = obj.user;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstInstallment() {
			return firstInstallment;
		}

		public void setFirstInstallment(String firstInstallment) {
			this.firstInstallment = firstInstallment;
		}

		public Integer getInstallments() {
			return Installments;
		}

		public void setInstallments(Integer installments) {
			Installments = installments;
		}

		public Integer getLoanValue() {
			return loanValue;
		}

		public void setLoanValue(Integer loanValue) {
			this.loanValue = loanValue;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Loan other = (Loan) obj;
			return Objects.equals(id, other.id);
		}   
	    
	}

}