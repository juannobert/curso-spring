package com.cursojava.curso.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cursojava.curso.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd 'T' HH:mm:ss'Z'",timezone = "GMT") // Formatando data para o formato UTC(Universal)
	private Instant moment;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	
	
	private Integer orderStatus;
	@OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
	private Payment payment;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> itens = new HashSet<>();
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	

	public Order(Long id, Instant moment, User client, OrderStatus orderStatus) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
		setOrderStatus(orderStatus);
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}


	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus.getCode();
	}
	
	

	public Set<OrderItem> getItens() {
		return itens;
	}


	

	public Payment getPayment() {
		return payment;
	}



	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Double getTotal() {
		double total = 0.0;
		for(OrderItem orderItem : itens) {
			total += orderItem.getSubTotal();
		}
		return total;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
}