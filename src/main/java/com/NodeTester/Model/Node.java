package com.NodeTester.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor          
@Entity                     
@Table(name = "Table_Node")
public class Node {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	public Node(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Node() {
		super();
		
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
